using System.Collections;
using System.Collections.Generic;
using Unity.VisualScripting;
using UnityEngine;

public class Obstacle : MonoBehaviour
{
    [SerializeField] private float speed = 5f;
    [SerializeField] private float speedVariance = 2f; // How much speed can vary from the average

    private static int obstacleDespawnCount = 0;

    private void Awake()
    {
        // Randomize speed around the anchor value
        speed = Random.Range(speed - speedVariance, speed + speedVariance);
    }

    private void Update()
    {
        transform.Translate(Vector2.left * speed * Time.deltaTime);
    }

    private void OnTriggerEnter2D(Collider2D collision)
    {
        if (collision.tag == "ObstacleDespawn")
        {
            obstacleDespawnCount++;
            Debug.Log($"Obstacle destroyed ({obstacleDespawnCount})");
            Destroy(gameObject);
        }
    }
}
