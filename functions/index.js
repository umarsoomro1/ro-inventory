const functions = require("firebase-functions");
const { spawn } = require("child_process");

exports.api = functions.https.onRequest((req, res) => {
    const jarPath = "E:\RO-Inventory\build\libs\roinventory-0.0.1-SNAPSHOT.jar"; // Update with the correct path
    const java = spawn("java", ["-jar", jarPath]);

    java.stdout.on("data", (data) => {
        console.log(`stdout: ${data}`);
    });

    java.stderr.on("data", (data) => {
        console.error(`stderr: ${data}`);
    });

    java.on("close", (code) => {
        console.log(`child process exited with code ${code}`);
    });

    res.send("Backend is running on Firebase Cloud Functions!");
});
