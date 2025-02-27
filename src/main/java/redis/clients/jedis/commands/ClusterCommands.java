package redis.clients.jedis.commands;

import java.util.List;
import java.util.Map;

import redis.clients.jedis.args.ClusterResetType;
import redis.clients.jedis.args.ClusterFailoverOption;

public interface ClusterCommands {

  String asking();

  String readonly();

  String readwrite();

  String clusterNodes();

  String clusterReplicas(String nodeId);

  String clusterMeet(String ip, int port);

  String clusterAddSlots(int... slots);

  String clusterDelSlots(int... slots);

  String clusterInfo();

  List<String> clusterGetKeysInSlot(int slot, int count);

  List<byte[]> clusterGetKeysInSlotBinary(int slot, int count);

  String clusterSetSlotNode(int slot, String nodeId);

  String clusterSetSlotMigrating(int slot, String nodeId);

  String clusterSetSlotImporting(int slot, String nodeId);

  String clusterSetSlotStable(int slot);

  String clusterForget(String nodeId);

  String clusterFlushSlots();

  long clusterKeySlot(String key);

  long clusterCountKeysInSlot(int slot);

  String clusterSaveConfig();

  String clusterReplicate(String nodeId);

  /**
   * {@code CLUSTER SLAVES} command is deprecated since Redis 5.
   *
   * @deprecated Use {@link ClusterCommands#clusterReplicas(java.lang.String)}.
   */
  @Deprecated
  List<String> clusterSlaves(String nodeId);

  String clusterFailover();

  String clusterFailover(ClusterFailoverOption failoverOption);

  List<Object> clusterSlots();

  String clusterReset();

  /**
   * {@code resetType} can be null for default behavior.
   *
   * @param resetType
   * @return OK
   */
  String clusterReset(ClusterResetType resetType);

  String clusterMyId();

  /**
   * return the information of all such peer links as an array, where each array element is a map that contains
   * attributes and their values for an individual link.
   *
   * @return the information of all such peer links as an array
   * @see <a href="https://redis.io/commands/cluster-links" >CLUSTET LINKS</a>
   */
  List<Map<String, Object>> clusterLinks();

  /**
   * Takes a list of slot ranges (specified by start and end slots) to assign to the node
   *
   * @param ranges slots range
   * @return OK if the command was successful. Otherwise an error is returned.
   */
  String clusterAddSlotsRange(int... ranges);

  /**
   * Takes a list of slot ranges (specified by start and end slots) to remove to the node.
   *
   * @param ranges slots range
   * @return OK if the command was successful. Otherwise an error is returned.
   */
  String clusterDelSlotsRange(int... ranges);
}
