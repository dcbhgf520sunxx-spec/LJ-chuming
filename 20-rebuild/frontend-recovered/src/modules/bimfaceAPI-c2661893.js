window.hostConfig = { APIHost: "https://znzhlj.znjs.com:7077/bimface", resourceHost: "https://znzhlj.znjs.com:7077/bimface/resource", staticHost: "https://znzhlj.znjs.com:7077/bimface/static", dataEnvType: "BIMFACE", securityApi: true };
function g(e, n) {
  if (!(e instanceof n)) throw new TypeError("Cannot call a class as a function");
}
function f(e, n) {
  for (var t = 0; t < n.length; t++) {
    var o = n[t];
    o.enumerable = o.enumerable || false, o.configurable = true, "value" in o && (o.writable = true), Object.defineProperty(e, o.key, o);
  }
}
function d(e, n, t) {
  return n && f(e.prototype, n), t && f(e, t), e;
}
var l = new Object();
l.url = window.location.href;
l.cleanUrl = function() {
  var e = (function(n) {
    var t = n.indexOf("?");
    return -1 < t ? t : n.indexOf("#");
  })(this.url);
  return e == -1 ? this.url : this.url.substr(0, e);
};
l._get = function() {
  var e = this.url.indexOf("?");
  if (e == -1) return null;
  var n = this.url.substr(e + 1);
  return 1 > n.length ? null : (function(t) {
    var o = t.split("&");
    if (1 > o.length) return null;
    for (var i = new Object(), r = 0; r < o.length; r++) {
      var a = o[r].split("=");
      a.length == 2 && (i[a[0]] = a[1]);
    }
    return i;
  })(n);
};
var m = (function() {
  function e() {
    g(this, e);
  }
  return d(e, [{ key: "set", value: function(t, o) {
    var i = /* @__PURE__ */ new Date();
    i.setTime(i.getTime() + 12 * 60 * 60 * 1e3), document.cookie = t + "=" + escape(o) + ";expires=" + i.toGMTString();
  } }, { key: "get", value: function(t) {
    var o, i = new RegExp("(^| )" + t + "=([^;]*)(;|$)");
    return (o = document.cookie.match(i)) ? unescape(o[2]) : null;
  } }]), e;
})();
new m();
var p = { local: { SDKLoaderPath: "./static/BimfaceSDKLoader/BimfaceSDKLoader@latest-debug.js", staticHost: "./static" }, dev: { SDKLoaderPath: "http://10.5.3.5/Packages/jssdk-dev/web/BimfaceSDKLoader/BimfaceSDKLoader@latest-debug.js", staticHost: "http://10.5.3.5/Packages/jssdk-dev/web" }, portal: { SDKLoaderPath: "https://znzhlj.znjs.com:7077/bimface/static/api/BimfaceSDKLoader/BimfaceSDKLoader@latest-release.js", staticHost: "https://znzhlj.znjs.com:7077/bimface/static/api" } }, c = c || p;
function u({ viewToken: e }) {
  var n = l._get(), t;
  return n ? t = n.mode || "portal" : t = "portal", new Promise(function(o, i) {
    w(c[t].SDKLoaderPath).then(function(r) {
      console.log(r, "ff");
      var a = new BimfaceSDKLoaderConfig();
      console.log(a, n, "params"), a = Object.assign({}, a, n, { build: "Debug", APIHost: "https://znzhlj.znjs.com:7077/bimface", staticHost: c[t].staticHost }), console.log(a, "BimfaceLoaderConfig"), t === "portal" && (a.build = "Release"), a.path && (a.dataEnvType = BimfaceEnvOption.Local), a.viewToken || (a.viewToken = e), a.version = "3.6.295", (a.viewToken || a.resourcePath || a.path || a.dataPath) && BimfaceSDKLoader.load(a, function(s) {
        o(s);
      }, i);
    });
  });
}
function w(e) {
  return new Promise(function(n, t) {
    var o = document.createElement("script");
    o.src = e, document.head.appendChild(o), o.addEventListener("load", function() {
      n("success");
    }, { passive: false }), o.addEventListener("error", function(i) {
      t(i);
    }, { passive: false });
  });
}
window.initBimfaceApp = u;
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
