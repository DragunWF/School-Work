using System;
using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;
using UnityEngine.UI;

public class ScoringSystem : MonoBehaviour
{
    [SerializeField] private float highScore = 0;
    [SerializeField] private float score = 0;
    private bool isNewHighScore = false;

    private TextMeshProUGUI scoreText;
    private const string HIGH_SCORE_KEY = "HighScore";

    #region Private Methods

    private void Start()
    {
        scoreText = GameObject.Find("ScoreText").GetComponent<TextMeshProUGUI>();
        if (scoreText == null)
        {
            Debug.LogError("ScoreText not found in the scene.");
            return;
        }

        // Load the high score from PlayerPrefs
        LoadHighScore();
    }

    private void Update()
    {
        score += Time.deltaTime;
        scoreText.text = $"Score: {Mathf.FloorToInt(score)}";
    }

    private void LoadHighScore()
    {
        highScore = PlayerPrefs.GetFloat(HIGH_SCORE_KEY, 0f);
        Debug.Log($"Loaded high score: {highScore}");
    }

    private void SaveHighScore()
    {
        PlayerPrefs.SetFloat(HIGH_SCORE_KEY, highScore);
        PlayerPrefs.Save(); // Force save to disk/browser storage
        Debug.Log($"Saved high score: {highScore}");
    }

    #endregion

    #region Public Methods

    public void OnGameLose()
    {
        TextMeshProUGUI newHighScoreText = GameObject.Find("NewHighScoreText").GetComponent<TextMeshProUGUI>();
        newHighScoreText.gameObject.SetActive(false);
        isNewHighScore = score > highScore;

        if (isNewHighScore)
        {
            TextMeshProUGUI highScoreText = GameObject.Find("HighScoreText").GetComponent<TextMeshProUGUI>();
            TextMeshProUGUI loseScoreText = GameObject.Find("LoseScoreText").GetComponent<TextMeshProUGUI>();
            newHighScoreText.gameObject.SetActive(true);

            if (highScoreText != null)
            {
                highScoreText.text = $"High Score: {Mathf.FloorToInt(score)}";
            }
            if (loseScoreText != null)
            {
                loseScoreText.text = $"Your Score: {Mathf.FloorToInt(score)}";
            }

            highScore = score;
            SaveHighScore(); // Save the new high score
        }
        else
        {
            // Still update the UI with current high score
            TextMeshProUGUI highScoreText = GameObject.Find("HighScoreText").GetComponent<TextMeshProUGUI>();
            TextMeshProUGUI loseScoreText = GameObject.Find("LoseScoreText").GetComponent<TextMeshProUGUI>();

            if (highScoreText != null)
            {
                highScoreText.text = $"High Score: {Mathf.FloorToInt(highScore)}";
            }
            if (loseScoreText != null)
            {
                loseScoreText.text = $"Your Score: {Mathf.FloorToInt(score)}";
            }
        }
        score = 0;
    }

    public bool IsNewHighScore() => isNewHighScore;

    public float GetHighScore() => highScore;

    public float GetCurrentScore() => score;

    #endregion
}