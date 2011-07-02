package Bulby.net;

import java.io.BufferedWriter;
import java.io.FileWriter;
import Bulby.Engine;
import Bulby.Server;
import Bulby.players.Player;
import Bulby.util.Misc;

/**
 * Server anti-flood protection.
 *
 * @author Gravediggah
 */
public class Protect {

    /**
     * Maximum amount of connections per host.
     */
    static final int MAX_CONNECTIONS = 6;
    /**
     * Minimum length of a pattern to be handled as a pattern.
     * For example 'SYIpker' has a length of 7 characters.
     */
    static final int SIZE_PATTERN = 7;
    /**
     * Maximum amount of players with the same username
     * pattern are allowed. Note: A pattern is seen as a
     * pattern when the length of a pattern is larger than
     * the length defined in SIZE_PATTERN;
     */
    static final int MAX_PATTERN_COUNT = 6;
    /**
     * If set to true, player's host will be checked.
     */
    static final boolean CHECK_HOST = true;
    /**
     * If set to true, player will be checked for patterns.
     */
    static final boolean CHECK_PATTERN = true;
    /**
     * If set to true, actions related to bans will be logged.
     */
    static final boolean LOG_BANS = true;

    /**
     * Performs all enabled checks.
     *
     * @param p The player to check.
     */
    public static void checkPlayer(Player p) {
        if (p != null) {
            if (CHECK_HOST) {
                checkHost(p);
            }

            if (CHECK_PATTERN) {
                checkPattern(p);
            }
        }

    }

    /**
     * Checks if the Player's host exceeds the maximum
     * amount of connections per host and, if exceeded,
     * IP-ban the player's host.
     *
     * @param p The player to check.
     */
    public static void checkHost(Player p) {
        if (p == null) {
            return;
        }

        String cHost = getHost(p);
        int cCount = 0;

        for (Player o : Engine.players) {
            if (o != null) {
                if (getHost(o).equals(cHost)) {
                    cCount++;
                }
            }
        }

        if (cCount >= MAX_CONNECTIONS && cHost.length() > 0) {
            sendLog("Too much connections: " + cHost + " (" + cCount + " connections)");
            killByHost(cHost);
        }
    }

    /**
     * This method is used to process an ip-ban.
     * 
     * @param host The host to ban.
     */
    public static void banHost(String host) {
        if (host.length() > 0) {
            if (!isBannedHost(host)) {
                addBan(host, true);
            }
            killByHost(host);
        }
    }

    /**
     * This method is used to process a single-user ban.
     *
     * @param p The player to ban.
     */
    public static void banUser(Player p) {
        if (p != null) {
            if (p.username.length() > 0) {
                if (!isBannedUser(p.username)) {
                    addBan(p.username, false);
                }
                p.disconnected[0] = true;
            }
        }
    }

    /**
     * Disconnects all players with the given host.
     *
     * @param host The host to disconnect.
     */
    public static void killByHost(String host) {
        for (Player o : Engine.players) {
            if (o != null) {
                if (getHost(o).equals(host)) {
                    if (!isBannedUser(o.username)) {
                        banUser(o);
                    }
                    o.disconnected[0] = true;
                }
            }
        }
    }

    /**
     * Checks the Player's username for a pattern, compared
     * to all other Players' usernames. IP-ban all Players
     * with this pattern, if the pattern applies to the defined
     * restrictions: SIZE_PATTERN / MAX_PATTERN_COUNT.
     *
     * @param p The player to check.
     */
    public static void checkPattern(Player p) {
        if (p == null) {
            return;
        }

        String pattern = p.username;

        for (Player o : Engine.players) {
            if (o != null) {
                String foundPattern = equString(pattern, o.username);
                if (foundPattern.length() >= SIZE_PATTERN) {
                    pattern = foundPattern;
                }
            }
        }

        if (pattern.length() >= SIZE_PATTERN) {
            if (pattern.length() > SIZE_PATTERN) {
                pattern = pattern.substring(0, SIZE_PATTERN).toLowerCase();
            }
            if (countPattern(pattern) >= MAX_PATTERN_COUNT) {
                sendLog("Banning pattern: " + pattern);
                for (Player o : Engine.players) {
                    if (o != null) {
                        if (o.username.toLowerCase().startsWith(pattern)) {
                            //Ban all hosts with this pattern, possibility of proxies.
                            banHost(getHost(o));
                        }
                    }
                }
            }
        }
    }

    /**
     * This method is used to count the amount of players with
     * a username starting with the given pattern.
     *
     * @param pattern The pattern to count.
     * @return Amount of usernames, starting with the given pattern.
     */
    public static int countPattern(String pattern) {
        int pCount = 0;
        for (Player o : Engine.players) {
            if (o != null) {
                if (o.username.toLowerCase().startsWith(pattern.toLowerCase())) {
                    pCount++;
                }
            }
        }
        return pCount;
    }

    /**
     * Returns the pattern of two usernames.
     *
     * @param a The first username.
     * @param b The second username.
     * @return The pattern of two usernames.
     */
    public static String equString(String a, String b) {
        String equ = "";

        for (int i = 0; i < a.length(); i++) {
            if (b.length() > i) {
                if (a.charAt(i) == b.charAt(i)) {
                    equ = equ + a.charAt(i);
                } else {
                    return equ;
                }
            } else {
                return equ;
            }
        }
        return equ;
    }

    /**
     * Returns the host of a player.
     *
     * @param p The player to get the host of.
     * @return The host of the given player.
     */
    public static String getHost(Player p) {
        if (p != null) {
            return p.socket.socket.getInetAddress().getHostAddress();
        } else {
            return "";
        }
    }

    /**
     * This method is used to apply a ban. It saves the
     * host or username to the ban-file and loaded lists.
     *
     * @param banStr The value to ban: Host or Username.
     * @param ipban If true, IP-ban host. If false, ban username.
     */
    public static void addBan(String banStr, boolean ipban) {
        BufferedWriter bw = null;
        String toFile;
        if (ipban) {
            toFile = "./data/banned/bannedhosts.dat";
            Server.socketListener.banHost(banStr);
            sendLog("Banned host: " + banStr);
        } else {
            toFile = "./data/banned/bannedusers.dat";
            Server.banUser(banStr);
            sendLog("Banned user: " + banStr);
        }
        try {
            FileWriter fileWriter = new FileWriter(toFile, true);

            bw = new BufferedWriter(fileWriter);
            bw.write(banStr);
            bw.newLine();
            bw.flush();
            bw.close();
            fileWriter = null;
            bw = null;
        } catch (Exception exception) {
            Misc.println("Critical error while writing data: " + toFile);
        }
    }

    /**
     * Checks if the given host is in the bannedhosts array.
     *
     * @param host The host to check.
     * @return Host is banned.
     */
    public static boolean isBannedHost(String host) {
        return Server.socketListener.checkBanned(host);
    }

    /**
     * Checks if the given username is in the bannedusers array.
     *
     * @param host The username to check.
     * @return Username is banned.
     */
    public static boolean isBannedUser(String user) {
        if (user == null) {
            return false;
        }
        for (int i = 0; i < Server.bannedUsers.length; i++) {
            if (Server.bannedUsers[i] != null && user.equalsIgnoreCase(Server.bannedUsers[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Logs actions if LOG_BANS is set to true.
     *
     * @param s The text to log.
     */
    public static void sendLog(String s) {
        if (LOG_BANS) {
            System.out.println("[SERVER-PROTECT] " + s);
        }
    }
}