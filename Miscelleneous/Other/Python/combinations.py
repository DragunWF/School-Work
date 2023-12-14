from rich import print


def main() -> None:
    input_states = [35, 65, 95, 125]
    channel_noise = [5, 10, 15]
    outputs = []
    for i in range(len(input_states)):
        for j in range(len(channel_noise)):
            outputs.append(input_states[i] + channel_noise[j])
    print(f"yx = {outputs}")
    print(f"my = {len(outputs)}")


if __name__ == '__main__':
    main()
