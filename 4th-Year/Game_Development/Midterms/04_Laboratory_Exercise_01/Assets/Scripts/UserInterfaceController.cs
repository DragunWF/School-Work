using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;
using UnityEngine.SceneManagement;

public class UserInterfaceController : MonoBehaviour
{
    private GameObject uiCanvas;
    private TextMeshProUGUI obstacleCountText;

    #region Public Methods

    public void RestartGame()
    {
        Time.timeScale = 1f; // Resume the game
        SceneManager.LoadScene(SceneManager.GetActiveScene().name);
    }

    public void ShowEndScreenUI()
    {
        uiCanvas.SetActive(true);
        obstacleCountText.text = $"Obstacle Spawn Count: {ObstacleSpawner.GetObstacleSpawnCount()}";
    }

    #endregion

    #region Private Methods

    private void Awake()
    {
        uiCanvas = GameObject.Find("UICanvas");
        obstacleCountText = GameObject.Find("ObstacleCountText").GetComponent<TextMeshProUGUI>();
    }

    private void Start()
    {
        uiCanvas.SetActive(false);
    }

    #endregion
}
