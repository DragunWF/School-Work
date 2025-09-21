using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Player : MonoBehaviour
{
    private readonly float jumpForce = 7.5f;
    private bool isGrounded = false;
    private UserInterfaceController uiController;

    private AudioPlayer audioPlayer;

    private void Awake()
    {
        uiController = FindObjectOfType<UserInterfaceController>();
        audioPlayer = FindObjectOfType<AudioPlayer>();
    }

    private void Update()
    {
        if (Input.GetKeyDown(KeyCode.Space) && isGrounded)
        {
            GetComponent<Rigidbody2D>().velocity = Vector2.up * jumpForce;
        }
    }

    private void OnCollisionStay2D(Collision2D collision)
    {
        if (collision.gameObject.CompareTag("Ground"))
        {
            isGrounded = true;
        }
    }

    private void OnCollisionExit2D(Collision2D collision)
    {
        if (collision.gameObject.CompareTag("Ground"))
        {
            isGrounded = false;
        }
        if (collision.gameObject.CompareTag("Obstacle"))
        {
            Debug.Log("Game Over!");
            uiController.ShowEndScreenUI();
            audioPlayer.StopBackgroundMusic();
            Time.timeScale = 0f; // Pause the game
        }
    }
}
