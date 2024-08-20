#!/usr/bin/env groovy

import static groovy.json.JsonOutput.toJson

void call(final String message, final String url = env.PROJECT_GOOGLE_CHAT_WEBHOOK_URL) {
    final String requestBody = toJson([text: message])
    echo requestBody
    httpRequest(requestBody: requestBody, url: url, httpMode: 'POST', contentType: 'APPLICATION_JSON_UTF8')
}
