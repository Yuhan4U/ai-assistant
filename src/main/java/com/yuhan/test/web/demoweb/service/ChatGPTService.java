package com.yuhan.test.web.demoweb.service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.yuhan.test.web.demoweb.pojo.TranslationRequest;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class ChatGPTService {

	@Value("${api.key}")
	private String apiKey;

	@Value("${api.url}")
	private String url;

	// 🧠 Ask Yuhu a question
	public String ask(String message,String systemPrompt) throws IOException {
		OkHttpClient client = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
				.readTimeout(60, TimeUnit.SECONDS).build();

		// System message (Yuhu’s personality)
		JSONObject systemMessage = new JSONObject().put("role", "system").put("content",
				systemPrompt);

		// User message
		JSONObject userMessage = new JSONObject().put("role", "user").put("content", message);

		// Combine both
		JSONArray messages = new JSONArray().put(systemMessage).put(userMessage);

		// Request body
		JSONObject json = new JSONObject().put("model", "gpt-4o-mini").put("messages", messages).put("temperature",
				0.8);

		RequestBody body = RequestBody.create(json.toString(), MediaType.parse("application/json"));

		Request request = new Request.Builder().url(url).post(body).addHeader("Content-Type", "application/json")
				.addHeader("Authorization", "Bearer " + apiKey).build();

		try (Response response = client.newCall(request).execute()) {
			if (!response.isSuccessful())
				throw new RuntimeException("Unexpected code " + response);

			JSONObject responseJson = new JSONObject(response.body().string());
			String result = responseJson.getJSONArray("choices").getJSONObject(0).getJSONObject("message")
					.getString("content").trim();

			// 🗣️ Speak result
			// speak(result);
			return result;
		}
	}

	// 🔊 WINDOWS VOICE SPEAK METHOD
	public void speak(String text) {
		try {
			String command = "powershell -Command \"Add-Type -AssemblyName System.Speech; "
					+ "$speak = New-Object System.Speech.Synthesis.SpeechSynthesizer; " + "$speak.Speak('"
					+ text.replace("'", "''") + "');\"";
			Runtime.getRuntime().exec(command);
		} catch (Exception e) {
			System.out.println("Voice error: " + e.getMessage());
		}
	}

	public String translate(TranslationRequest input) throws IOException {
		OkHttpClient client = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
				.readTimeout(60, TimeUnit.SECONDS).build();

		// System message (Yuhu’s personality)
		JSONObject systemMessage = new JSONObject().put("role", "system").put("content",
				"You are Expert Langauge Translator");

		// User message
		JSONObject userMessage = new JSONObject().put("role", "user").put("content",
				"Translate word " + input.getSourceText() + " to language " + input.getTargetLanguage());

		// Combine both
		JSONArray messages = new JSONArray().put(systemMessage).put(userMessage);

		// Request body
		JSONObject json = new JSONObject().put("model", "gpt-4o-mini").put("messages", messages).put("temperature",
				0.8);

		RequestBody body = RequestBody.create(json.toString(), MediaType.parse("application/json"));

		Request request = new Request.Builder().url(url).post(body).addHeader("Content-Type", "application/json")
				.addHeader("Authorization", "Bearer " + apiKey).build();

		try (Response response = client.newCall(request).execute()) {
			if (!response.isSuccessful())
				throw new RuntimeException("Unexpected code " + response);

			JSONObject responseJson = new JSONObject(response.body().string());
			String result = responseJson.getJSONArray("choices").getJSONObject(0).getJSONObject("message")
					.getString("content").trim();

			// 🗣️ Speak result
			// speak(result);
			return result;
		}
	}
}
