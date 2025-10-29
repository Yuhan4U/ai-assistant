package com.yuhan.test.web.demoweb.service;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ChatGPTWindowsVoice {
	private static final String API_KEY = "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"; // ⚠️
																																																					// replace
																																																					// with
																																																					// env
																																																					// variable
	private static final String MODEL = "gpt-4o-mini";
	private static String voiceGender = "Female"; // default voice type

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		OkHttpClient client = new OkHttpClient();
		JSONArray messages = new JSONArray(); // store chat history

		System.out.println("💬 Chat started! Type 'exit' to quit.");
		System.out.println("🔊 Type '1' for Female voice, '2' for Male voice.");

		while (true) {
			System.out.print("You: ");
			String userInput = input.nextLine().trim();

			if (userInput.equalsIgnoreCase("exit"))
				break;

			// --- Switch voice ---
			if (userInput.equals("1")) {
				voiceGender = "Female";
				System.out.println("🎙️ Switched to Female voice.");
				continue;
			} else if (userInput.equals("2")) {
				voiceGender = "Male";
				System.out.println("🎙️ Switched to Male voice.");
				continue;
			}

			// add user message to history
			messages.put(new JSONObject().put("role", "user").put("content", userInput));

			// ask ChatGPT
			String reply = askChatGPT(client, messages);
			System.out.println("ChatGPT: " + reply);

			// add assistant reply to history
			messages.put(new JSONObject().put("role", "assistant").put("content", reply));

			// speak using selected Windows voice
			speakWindowsVoice(reply, voiceGender);
		}

		System.out.println("👋 Chat ended.");
		input.close();
	}

	// --- ChatGPT API Call ---
	private static String askChatGPT(OkHttpClient client, JSONArray messages) throws Exception {
		JSONObject json = new JSONObject();
		json.put("model", MODEL);
		json.put("messages", messages);

		RequestBody body = RequestBody.create(json.toString(), MediaType.parse("application/json"));

		Request request = new Request.Builder().url("https://api.openai.com/v1/chat/completions")
				.header("Authorization", "Bearer " + API_KEY).post(body).build();

		try (Response response = client.newCall(request).execute()) {
			if (!response.isSuccessful())
				throw new RuntimeException("API error: " + response);
			String responseBody = response.body().string();
			JSONObject obj = new JSONObject(responseBody);
			return obj.getJSONArray("choices").getJSONObject(0).getJSONObject("message").getString("content").trim();
		}
	}

	// --- Windows Voice (TTS) ---
	private static void speakWindowsVoice(String text, String gender) {
		try {
			String escaped = text.replace("'", "''");
			// Choose voice gender
			String command = "PowerShell -Command \"" + "Add-Type -AssemblyName System.Speech;"
					+ "$speak = New-Object System.Speech.Synthesis.SpeechSynthesizer;"
					+ "$speak.SelectVoiceByHints([System.Speech.Synthesis.VoiceGender]::" + gender + ");"
					+ "$speak.Speak('" + escaped + "');\"";

			Runtime.getRuntime().exec(command);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
