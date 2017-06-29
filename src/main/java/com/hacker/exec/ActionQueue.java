package com.hacker.exec;

import java.util.Queue;

public interface ActionQueue {

	ActionQueue getActionQueue();

	void enqueue(Action action);

	void dequeue(Action action);

	void clear();

	Queue<Action> getQueue();
}
