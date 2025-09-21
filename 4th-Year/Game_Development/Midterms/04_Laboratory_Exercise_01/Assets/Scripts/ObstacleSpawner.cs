using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ObstacleSpawner : MonoBehaviour
{
    [SerializeField] private GameObject obstaclePrefab1;
    [SerializeField] private GameObject obstaclePrefab2;
    [SerializeField] private Transform spawnPoint;

    private static int obstacleSpawnCount = 0;
    private const float spawnInterval = 2.5f;
    private const float initialDelay = 3f;

    #region Public Methods

    public static int GetObstacleSpawnCount() => obstacleSpawnCount;

    #endregion

    #region Private Methods

    private void Start()
    {
        StartCoroutine(SpawnObstacles());
    }

    private IEnumerator SpawnObstacles()
    {
        yield return new WaitForSeconds(initialDelay); // Initial delay before starting

        while (true)
        {
            // Spawn an obstacle
            GameObject obstacle = Random.Range(0f, 1f) < 0.5f ? obstaclePrefab1 : obstaclePrefab2;
            Instantiate(obstacle, spawnPoint.position, spawnPoint.rotation);
            obstacleSpawnCount++;
            yield return new WaitForSeconds(spawnInterval);
        }
    }

    #endregion
}
