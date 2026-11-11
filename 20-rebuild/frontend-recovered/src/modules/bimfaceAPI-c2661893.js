let sdkScript;
const sdkTimeout = 90000;

function loadSdkScript(url) {
  if (!sdkScript) {
    sdkScript = new Promise((resolve, reject) => {
      const script = document.createElement("script");
      const timeout = setTimeout(() => fail("BIM SDK 加载超时"), sdkTimeout);
      function fail(message) {
        clearTimeout(timeout);
        script.remove();
        reject(new Error(message));
      }
      script.src = url;
      script.addEventListener("load", () => {
        clearTimeout(timeout);
        if (typeof BimfaceSDKLoaderConfig === "function" && typeof BimfaceSDKLoader !== "undefined" && typeof BimfaceSDKLoader.load === "function") resolve();
        else fail("BIM SDK 加载失败，请核对 SDK 版本与地址");
      }, { once: true });
      script.addEventListener("error", () => fail("BIM SDK 加载失败，请核对地址与浏览器策略"), { once: true });
      document.head.appendChild(script);
    }).catch(error => {
      sdkScript = undefined;
      throw error;
    });
  }
  return sdkScript;
}

async function u({ viewToken, signal } = {}) {
  const config = document.getElementById("ljaps-bim-viewer-config");
  if (!config) throw new Error("BIM 浏览器环境未配置，请联系管理员");
  if (typeof viewToken !== "string" || !viewToken.trim()) throw new Error("模型查看凭据缺失，请刷新重试");
  const { sdk_loader_url, api_url, static_url, resource_url, sdk_version } = JSON.parse(config.textContent);
  const hosts = { APIHost: api_url, staticHost: static_url, resourceHost: resource_url, dataEnvType: "BIMFACE", securityApi: true };
  window.hostConfig = hosts;
  await loadSdkScript(sdk_loader_url);
  signal?.throwIfAborted();
  return new Promise((resolve, reject) => {
    const timeout = setTimeout(() => finish(reject, new Error("BIM 模型加载超时，请刷新重试")), sdkTimeout);
    function abort() {
      finish(reject, signal.reason);
    }
    function finish(callback, value) {
      clearTimeout(timeout);
      signal?.removeEventListener("abort", abort);
      callback(value);
    }
    function fail() {
      finish(reject, new Error("BIM 模型加载失败，请刷新重试"));
    }
    signal?.addEventListener("abort", abort, { once: true });
    try {
      const loaderConfig = Object.assign(new BimfaceSDKLoaderConfig(), hosts, {
        build: "Release",
        viewToken,
        version: sdk_version
      });
      const pending = BimfaceSDKLoader.load(loaderConfig, data => data ? finish(resolve, data) : fail(), fail);
      pending?.catch?.(fail);
    } catch {
      fail();
    }
  });
}
function h() {
  return Glodon.Bimface.Viewer.AxisOption.Z;
}
function b() {
  return Glodon.Bimface.Viewer.NavigationMode3D.Fly;
}
function B() {
  return new Glodon.Bimface.Application.WebApplication3DConfig();
}
function v(e) {
  return new Glodon.Bimface.Application.WebApplication3D(e);
}
function C() {
  return Glodon.Bimface.Viewer.Viewer3DEvent;
}
function D() {
  return Glodon.Bimface.Application.WebApplication3DEvent;
}
function P() {
  return new Glodon.Bimface.Application.WebApplicationDrawingConfig();
}
function G(e) {
  return new Glodon.Bimface.Application.WebApplicationDrawing(e);
}
function T() {
  return Glodon.Bimface.Viewer.ViewerDrawingEvent;
}
function L(e, n) {
  return new Glodon.Web.Graphics.Color(e, n);
}
function k() {
  return Glodon.Bimface.Viewer.IsolateOption;
}
function j(e) {
  return new Glodon.Bimface.Plugins.SkyBox.SkyBoxManager(e);
}
function A() {
  return new Glodon.Bimface.Plugins.Drawable.DrawableContainerConfig();
}
function S(e) {
  return new Glodon.Bimface.Plugins.Drawable.DrawableContainer(e);
}
function z() {
  return new Glodon.Bimface.Plugins.Drawable.CustomItemConfig();
}
function I(e) {
  return new Glodon.Bimface.Plugins.Drawable.CustomItem(e);
}
function y() {
  return new Glodon.Bimface.Plugins.Drawable.LeadLabelConfig();
}
function E(e) {
  return new Glodon.Bimface.Plugins.Drawable.LeadLabel(e);
}
function x() {
  return new Glodon.Bimface.Plugins.Walkthrough.WalkthroughConfig();
}
function O(e) {
  return new Glodon.Bimface.Plugins.Walkthrough.Walkthrough(e);
}
function K() {
  return Glodon.Bimface.UI.Panel.PanelPositions;
}
function W() {
  return new Glodon.Bimface.UI.Panel.PanelConfig();
}
function U(e) {
  return console.log(Glodon.Bimface), new Glodon.Bimface.UI.Panel.Panel(e);
}
function H() {
  return new Glodon.Bimface.UI.Button.ButtonConfig();
}
function V(e) {
  return new Glodon.Bimface.UI.Button.Button(e);
}
function _() {
  return new Glodon.Bimface.UI.Toolbar.ToolbarConfig();
}
function M(e) {
  return new Glodon.Bimface.UI.Toolbar.Toolbar(e);
}
function N() {
  return new Glodon.Bimface.UI.Tree.TreeNodeConfig();
}
function F(e) {
  return new Glodon.Bimface.UI.Tree.TreeNode(e);
}
function R(e) {
  return new Glodon.Bimface.UI.Tree.Tree(e);
}
const Z = Object.freeze(Object.defineProperty({ __proto__: null, createButton: V, createPanel: U, createToolbar: M, createTree: F, get2DApp: G, get2DConfig: P, getApp: v, getApp3DEvent: D, getAxisOptionZ: h, getButtonConfig: H, getColor: L, getConfig: B, getCustomItem: I, getCustomItemConfig: z, getDrawableContainer: S, getDrawableContainerConfig: A, getIsolateOption: k, getLeadLabel: E, getLeadLabelConfig: y, getNavigationMode3D: b, getPanelConfig: W, getPanelPositions: K, getSkyBoxManager: j, getToolbarConfig: _, getTreeApi: R, getTreeConfig: N, getViewer2DEvent: T, getViewer3DEvent: C, getWalkthrough: O, getWalkthroughConfig: x, initBimfaceApp: u }, Symbol.toStringTag, { value: "Module" }));
export {
  v as a,
  C as b,
  x as c,
  O as d,
  h as e,
  j as f,
  B as g,
  P as h,
  u as i,
  G as j,
  T as k,
  L as l,
  Z as m,
  K as n
};
