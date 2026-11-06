async function start() {
  const response = await fetch("/api/user/public-key", { cache: "no-store" });
  const envelope = await response.json();
  const key = envelope.data?.publicKey ?? envelope.data?.key ?? envelope.publicKey;
  if (!response.ok || envelope.code !== 2e4 || !key) throw new Error("本地服务公钥加载失败");
  window.__REBUILD_PUBLIC_KEY__ = key;
  const runtime = await import("./shared/runtime.js");
  runtime.startRecoveredApplication();
}
start().catch((error) => {
  document.getElementById("app").textContent = error.message;
  console.error(error);
});
