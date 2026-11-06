import { ref as H } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as V } from "vue";
import { Fragment as te } from "vue";
import { renderList as mt } from "vue";
import { normalizeClass as Wl } from "vue";
import { normalizeStyle as Xe } from "vue";
import { createElementVNode as O } from "vue";
import { toDisplayString as qn } from "vue";
import { resolveComponent as at } from "vue";
import { createVNode as r } from "vue";
import { withCtx as m } from "vue";
import { createCommentVNode as T } from "vue";
import { createBlock as K } from "vue";
import { ElTooltip as Jn } from "element-plus";
import { reactive as tn } from "vue";
import { computed as _e } from "vue";
import { watch as vt } from "vue";
import { nextTick as Xl } from "vue";
import { unref as s } from "vue";
import { createTextVNode as j } from "vue";
import { withDirectives as Pe } from "vue";
import { withModifiers as Ie } from "vue";
import jl from "qrcode.vue";
import { Transition as Gl } from "vue";
import { vShow as lt } from "vue";
import nn from "moment";
import { ElOption as ql } from "element-plus";
import { ElSelect as Jl } from "element-plus";
import { ElImage as Zl } from "element-plus";
import { ElFormItem as Ql } from "element-plus";
import { ElInput as eo } from "element-plus";
import { ElCheckbox as to } from "element-plus";
import { Check as no } from "@element-plus/icons-vue";
import { ElIcon as lo } from "element-plus";
import { StarFilled as oo } from "@element-plus/icons-vue";
import { ElTag as io } from "element-plus";
import { ElTableColumn as ao } from "element-plus";
import { ElForm as ro } from "element-plus";
import { vLoading as so } from "element-plus";
import { _ as bn, c_ as ft, c$ as At, b as Re, a as uo, gf as fo, gg as co, gh as mo, gi as po, cY as Fn, cZ as ho, gj as Nt, gk as de, ao as go, i as M, gl as ie, c as vo, gm as bo, gn as Hn, go as Rn, gp as yo, d1 as wo, gq as Ze, d0 as D, ck as $t, d5 as _o, gr as bt, bg as Eo, cl as Vo, gs as xo } from "../../../../../shared/runtime.js";
import { e as ln } from "../../../../../modules/index-73880c3c.js";
import { _ as To } from "../../../../../modules/index-5e774f84.js";
import { v as Se } from "../../../../../modules/vertical-label-c3028fe0.js";
const So = { class: "r_option-container" }, Do = ["onClick"], Co = { class: "r_title ellipsis-text" }, ko = { __name: "index", props: { value: { type: null, default: void 0 }, required: { type: Boolean, default: true }, options: { type: [Array, Object], default: () => [] }, type: { type: String, default: "enum" }, color: { type: String, default: "#303133" }, activeColor: { type: String, default: "#fff" }, buttonColor: { type: String, default: "#409EFF" } }, emits: ["update:value", "change"], setup(l, { emit: e }) {
  const t = e, n = l, a = H(), u = { key: "id", label: "label", value: "value" }, f = { key: "K", label: "L", value: "V" }, c = { key: "id", label: "name", value: "id" };
  n.type === "dict" ? a.value = u : n.type === "enum" ? a.value = f : a.value = c;
  function h(b) {
    b[a.value.value] !== n.value ? g(b) : n.required || g();
  }
  function g(b) {
    t("update:value", b ? b[a.value.value] : void 0), t("change", b);
  }
  return (b, E) => (v(), V("div", So, [(v(true), V(te, null, mt(l.options, (x, P) => (v(), V("span", { key: P, class: Wl(["r_option-drawer r_select-able", { r_active: l.value !== void 0 && l.value === x[a.value.value] }]), style: Xe({ color: l.value !== void 0 && l.value === x[a.value.value] ? l.activeColor : l.color, "background-color": l.value !== void 0 && l.value === x[a.value.value] ? l.buttonColor : "unset" }), onClick: (N) => h(x) }, [O("span", Co, qn(x[a.value.label]), 1)], 14, Do))), 128))]));
} }, Uo = bn(ko, [["__scopeId", "data-v-e3ea5b06"]]);
const Mo = { class: "content" }, Oo = { key: 0 }, Ao = { key: 1 }, No = { key: 2 }, $o = { key: 3 }, Po = { key: 4 }, Io = { __name: "index", props: { data: { type: Object, required: true }, showAllPage: { type: Boolean, default: false }, showDisplay: { type: Boolean, default: true }, showBold: { type: Boolean, default: true }, showAlign: { type: Boolean, default: true }, showVerticleAlign: { type: Boolean, default: true } }, setup(l) {
  const e = l, t = H([{ value: ft.LEFT.V, icon: "doc-align-left", tip: "左对齐" }, { value: ft.CENTER.V, icon: "doc-align-center", tip: "居中对齐" }, { value: ft.RIGHT.V, icon: "doc-align-right", tip: "右对齐" }]), n = H([{ value: At.TOP.V, icon: "doc-verticle-align-top", tip: "顶端对齐" }, { value: At.CENTER.V, icon: "doc-verticle-align-center", tip: "垂直居中" }, { value: At.BOTTOM.V, icon: "doc-verticle-align-bottom", tip: "低端对齐" }]);
  a();
  function a() {
    const b = {};
    e.showAllPage && Re(e.data.allPage) && (b.allPage = false), e.showDisplay && Re(e.data.show) && (b.show = false), e.showBold && Re(e.data.bold) && (b.bold = "unset"), e.showAlign && Re(e.data.align) && (b.align = ft.CENTER.V), e.showVerticleAlign && Re(e.data.verticleAlign) && (b.verticleAlign = At.CENTER.V), Object.assign(e.data, b);
  }
  function u(b) {
    Object.assign(e.data, { allPage: !b });
  }
  function f(b) {
    Object.assign(e.data, { show: !b });
  }
  function c(b) {
    Object.assign(e.data, { bold: b === "bold" ? "unset" : "bold" });
  }
  function h(b) {
    Object.assign(e.data, { align: b });
  }
  function g(b) {
    Object.assign(e.data, { verticleAlign: b });
  }
  return (b, E) => {
    const x = uo, P = at("common-button"), N = Jn;
    return v(), V("div", Mo, [e.showDisplay ? (v(), V("span", Oo, [r(N, { content: "是否显示", placement: "bottom-start", effect: "light", "open-delay": 1e3 }, { default: m(() => [r(P, { type: e.data.show ? "info" : "", size: "default", class: "icon-select-btn", onClick: E[0] || (E[0] = (S) => f(l.data.show)) }, { default: m(() => [r(x, { "icon-class": "doc-display" })]), _: 1 }, 8, ["type"])]), _: 1 })])) : T("", true), e.showAllPage ? (v(), V("span", Ao, [r(N, { content: `是否每页显示(显示的前提下)

不选择则只在第一页（标题/表头）或最后一页（表尾）显示`, placement: "bottom-start", effect: "light", "open-delay": 1e3 }, { default: m(() => [r(P, { type: e.data.allPage ? "info" : "", size: "default", class: "icon-select-btn", onClick: E[1] || (E[1] = (S) => u(l.data.allPage)) }, { default: m(() => [r(x, { "icon-class": "doc-all-page" })]), _: 1 }, 8, ["type"])]), _: 1 })])) : T("", true), e.showBold ? (v(), V("span", No, [r(N, { content: "将字体加粗", placement: "bottom-start", effect: "light", "open-delay": 1e3 }, { default: m(() => [r(P, { type: e.data.bold === "bold" ? "info" : "", size: "default", class: "icon-select-btn", onClick: E[2] || (E[2] = (S) => c(l.data.bold)) }, { default: m(() => [r(x, { "icon-class": "doc-bold" })]), _: 1 }, 8, ["type"])]), _: 1 })])) : T("", true), e.showAlign ? (v(), V("span", $o, [(v(true), V(te, null, mt(t.value, (S) => (v(), K(N, { key: `align_${S.value}`, content: S.tip, placement: "bottom-start", effect: "light", "open-delay": 1e3 }, { default: m(() => [r(P, { type: e.data.align === S.value ? "info" : "", size: "default", class: "icon-select-btn", onClick: (ce) => h(S.value) }, { default: m(() => [r(x, { "icon-class": S.icon }, null, 8, ["icon-class"])]), _: 2 }, 1032, ["type", "onClick"])]), _: 2 }, 1032, ["content"]))), 128))])) : T("", true), e.showVerticleAlign ? (v(), V("span", Po, [(v(true), V(te, null, mt(n.value, (S) => (v(), K(N, { key: `verticleAlign_${S.value}`, content: S.tip, placement: "bottom-start", effect: "light", "open-delay": 1e3 }, { default: m(() => [r(P, { type: e.data.verticleAlign === S.value ? "info" : "", size: "default", class: "icon-select-btn", onClick: (ce) => g(S.value) }, { default: m(() => [r(x, { "icon-class": S.icon }, null, 8, ["icon-class"])]), _: 2 }, 1032, ["type", "onClick"])]), _: 2 }, 1032, ["content"]))), 128))])) : T("", true)]);
  };
} }, Be = bn(Io, [["__scopeId", "data-v-504be700"]]);
/**!
* Sortable 1.15.6
* @author	RubaXa   <trash@rubaxa.org>
* @author	owenm    <owen23355@gmail.com>
* @license MIT
*/
function zn(l, e) {
  var t = Object.keys(l);
  if (Object.getOwnPropertySymbols) {
    var n = Object.getOwnPropertySymbols(l);
    e && (n = n.filter(function(a) {
      return Object.getOwnPropertyDescriptor(l, a).enumerable;
    })), t.push.apply(t, n);
  }
  return t;
}
function Ke(l) {
  for (var e = 1; e < arguments.length; e++) {
    var t = arguments[e] != null ? arguments[e] : {};
    e % 2 ? zn(Object(t), true).forEach(function(n) {
      Fo(l, n, t[n]);
    }) : Object.getOwnPropertyDescriptors ? Object.defineProperties(l, Object.getOwnPropertyDescriptors(t)) : zn(Object(t)).forEach(function(n) {
      Object.defineProperty(l, n, Object.getOwnPropertyDescriptor(t, n));
    });
  }
  return l;
}
function Rt(l) {
  "@babel/helpers - typeof";
  return typeof Symbol == "function" && typeof Symbol.iterator == "symbol" ? Rt = function(e) {
    return typeof e;
  } : Rt = function(e) {
    return e && typeof Symbol == "function" && e.constructor === Symbol && e !== Symbol.prototype ? "symbol" : typeof e;
  }, Rt(l);
}
function Fo(l, e, t) {
  return e in l ? Object.defineProperty(l, e, { value: t, enumerable: true, configurable: true, writable: true }) : l[e] = t, l;
}
function Ge() {
  return Ge = Object.assign || function(l) {
    for (var e = 1; e < arguments.length; e++) {
      var t = arguments[e];
      for (var n in t) Object.prototype.hasOwnProperty.call(t, n) && (l[n] = t[n]);
    }
    return l;
  }, Ge.apply(this, arguments);
}
function Ho(l, e) {
  if (l == null) return {};
  var t = {}, n = Object.keys(l), a, u;
  for (u = 0; u < n.length; u++) a = n[u], !(e.indexOf(a) >= 0) && (t[a] = l[a]);
  return t;
}
function Ro(l, e) {
  if (l == null) return {};
  var t = Ho(l, e), n, a;
  if (Object.getOwnPropertySymbols) {
    var u = Object.getOwnPropertySymbols(l);
    for (a = 0; a < u.length; a++) n = u[a], !(e.indexOf(n) >= 0) && Object.prototype.propertyIsEnumerable.call(l, n) && (t[n] = l[n]);
  }
  return t;
}
var zo = "1.15.6";
function je(l) {
  if (typeof window < "u" && window.navigator) return !!navigator.userAgent.match(l);
}
var qe = je(/(?:Trident.*rv[ :]?11\.|msie|iemobile|Windows Phone)/i), Dt = je(/Edge/i), Ln = je(/firefox/i), Et = je(/safari/i) && !je(/chrome/i) && !je(/android/i), yn = je(/iP(ad|od|hone)/i), Zn = je(/chrome/i) && je(/android/i), Qn = { capture: false, passive: false };
function R(l, e, t) {
  l.addEventListener(e, t, !qe && Qn);
}
function F(l, e, t) {
  l.removeEventListener(e, t, !qe && Qn);
}
function Kt(l, e) {
  if (e) {
    if (e[0] === ">" && (e = e.substring(1)), l) try {
      if (l.matches) return l.matches(e);
      if (l.msMatchesSelector) return l.msMatchesSelector(e);
      if (l.webkitMatchesSelector) return l.webkitMatchesSelector(e);
    } catch {
      return false;
    }
    return false;
  }
}
function el(l) {
  return l.host && l !== document && l.host.nodeType ? l.host : l.parentNode;
}
function He(l, e, t, n) {
  if (l) {
    t = t || document;
    do {
      if (e != null && (e[0] === ">" ? l.parentNode === t && Kt(l, e) : Kt(l, e)) || n && l === t) return l;
      if (l === t) break;
    } while (l = el(l));
  }
  return null;
}
var Bn = /\s+/g;
function De(l, e, t) {
  if (l && e) if (l.classList) l.classList[t ? "add" : "remove"](e);
  else {
    var n = (" " + l.className + " ").replace(Bn, " ").replace(" " + e + " ", " ");
    l.className = (n + (t ? " " + e : "")).replace(Bn, " ");
  }
}
function C(l, e, t) {
  var n = l && l.style;
  if (n) {
    if (t === void 0) return document.defaultView && document.defaultView.getComputedStyle ? t = document.defaultView.getComputedStyle(l, "") : l.currentStyle && (t = l.currentStyle), e === void 0 ? t : t[e];
    !(e in n) && e.indexOf("webkit") === -1 && (e = "-webkit-" + e), n[e] = t + (typeof t == "string" ? "" : "px");
  }
}
function pt(l, e) {
  var t = "";
  if (typeof l == "string") t = l;
  else do {
    var n = C(l, "transform");
    n && n !== "none" && (t = n + " " + t);
  } while (!e && (l = l.parentNode));
  var a = window.DOMMatrix || window.WebKitCSSMatrix || window.CSSMatrix || window.MSCSSMatrix;
  return a && new a(t);
}
function tl(l, e, t) {
  if (l) {
    var n = l.getElementsByTagName(e), a = 0, u = n.length;
    if (t) for (; a < u; a++) t(n[a], a);
    return n;
  }
  return [];
}
function Ye() {
  var l = document.scrollingElement;
  return l || document.documentElement;
}
function ee(l, e, t, n, a) {
  if (!(!l.getBoundingClientRect && l !== window)) {
    var u, f, c, h, g, b, E;
    if (l !== window && l.parentNode && l !== Ye() ? (u = l.getBoundingClientRect(), f = u.top, c = u.left, h = u.bottom, g = u.right, b = u.height, E = u.width) : (f = 0, c = 0, h = window.innerHeight, g = window.innerWidth, b = window.innerHeight, E = window.innerWidth), (e || t) && l !== window && (a = a || l.parentNode, !qe)) do
      if (a && a.getBoundingClientRect && (C(a, "transform") !== "none" || t && C(a, "position") !== "static")) {
        var x = a.getBoundingClientRect();
        f -= x.top + parseInt(C(a, "border-top-width")), c -= x.left + parseInt(C(a, "border-left-width")), h = f + u.height, g = c + u.width;
        break;
      }
    while (a = a.parentNode);
    if (n && l !== window) {
      var P = pt(a || l), N = P && P.a, S = P && P.d;
      P && (f /= S, c /= N, E /= N, b /= S, h = f + b, g = c + E);
    }
    return { top: f, left: c, bottom: h, right: g, width: E, height: b };
  }
}
function Yn(l, e, t) {
  for (var n = tt(l, true), a = ee(l)[e]; n; ) {
    var u = ee(n)[t], f = void 0;
    if (t === "top" || t === "left" ? f = a >= u : f = a <= u, !f) return n;
    if (n === Ye()) break;
    n = tt(n, false);
  }
  return false;
}
function ht(l, e, t, n) {
  for (var a = 0, u = 0, f = l.children; u < f.length; ) {
    if (f[u].style.display !== "none" && f[u] !== k.ghost && (n || f[u] !== k.dragged) && He(f[u], t.draggable, l, false)) {
      if (a === e) return f[u];
      a++;
    }
    u++;
  }
  return null;
}
function wn(l, e) {
  for (var t = l.lastElementChild; t && (t === k.ghost || C(t, "display") === "none" || e && !Kt(t, e)); ) t = t.previousElementSibling;
  return t || null;
}
function Me(l, e) {
  var t = 0;
  if (!l || !l.parentNode) return -1;
  for (; l = l.previousElementSibling; ) l.nodeName.toUpperCase() !== "TEMPLATE" && l !== k.clone && (!e || Kt(l, e)) && t++;
  return t;
}
function Kn(l) {
  var e = 0, t = 0, n = Ye();
  if (l) do {
    var a = pt(l), u = a.a, f = a.d;
    e += l.scrollLeft * u, t += l.scrollTop * f;
  } while (l !== n && (l = l.parentNode));
  return [e, t];
}
function Lo(l, e) {
  for (var t in l) if (l.hasOwnProperty(t)) {
    for (var n in e) if (e.hasOwnProperty(n) && e[n] === l[t][n]) return Number(t);
  }
  return -1;
}
function tt(l, e) {
  if (!l || !l.getBoundingClientRect) return Ye();
  var t = l, n = false;
  do
    if (t.clientWidth < t.scrollWidth || t.clientHeight < t.scrollHeight) {
      var a = C(t);
      if (t.clientWidth < t.scrollWidth && (a.overflowX == "auto" || a.overflowX == "scroll") || t.clientHeight < t.scrollHeight && (a.overflowY == "auto" || a.overflowY == "scroll")) {
        if (!t.getBoundingClientRect || t === document.body) return Ye();
        if (n || e) return t;
        n = true;
      }
    }
  while (t = t.parentNode);
  return Ye();
}
function Bo(l, e) {
  if (l && e) for (var t in e) e.hasOwnProperty(t) && (l[t] = e[t]);
  return l;
}
function on(l, e) {
  return Math.round(l.top) === Math.round(e.top) && Math.round(l.left) === Math.round(e.left) && Math.round(l.height) === Math.round(e.height) && Math.round(l.width) === Math.round(e.width);
}
var Vt;
function nl(l, e) {
  return function() {
    if (!Vt) {
      var t = arguments, n = this;
      t.length === 1 ? l.call(n, t[0]) : l.apply(n, t), Vt = setTimeout(function() {
        Vt = void 0;
      }, e);
    }
  };
}
function Yo() {
  clearTimeout(Vt), Vt = void 0;
}
function ll(l, e, t) {
  l.scrollLeft += e, l.scrollTop += t;
}
function ol(l) {
  var e = window.Polymer, t = window.jQuery || window.Zepto;
  return e && e.dom ? e.dom(l).cloneNode(true) : t ? t(l).clone(true)[0] : l.cloneNode(true);
}
function il(l, e, t) {
  var n = {};
  return Array.from(l.children).forEach(function(a) {
    var u, f, c, h;
    if (!(!He(a, e.draggable, l, false) || a.animated || a === t)) {
      var g = ee(a);
      n.left = Math.min((u = n.left) !== null && u !== void 0 ? u : 1 / 0, g.left), n.top = Math.min((f = n.top) !== null && f !== void 0 ? f : 1 / 0, g.top), n.right = Math.max((c = n.right) !== null && c !== void 0 ? c : -1 / 0, g.right), n.bottom = Math.max((h = n.bottom) !== null && h !== void 0 ? h : -1 / 0, g.bottom);
    }
  }), n.width = n.right - n.left, n.height = n.bottom - n.top, n.x = n.left, n.y = n.top, n;
}
var Ve = "Sortable" + (/* @__PURE__ */ new Date()).getTime();
function Ko() {
  var l = [], e;
  return { captureAnimationState: function() {
    if (l = [], !!this.options.animation) {
      var n = [].slice.call(this.el.children);
      n.forEach(function(a) {
        if (!(C(a, "display") === "none" || a === k.ghost)) {
          l.push({ target: a, rect: ee(a) });
          var u = Ke({}, l[l.length - 1].rect);
          if (a.thisAnimationDuration) {
            var f = pt(a, true);
            f && (u.top -= f.f, u.left -= f.e);
          }
          a.fromRect = u;
        }
      });
    }
  }, addAnimationState: function(n) {
    l.push(n);
  }, removeAnimationState: function(n) {
    l.splice(Lo(l, { target: n }), 1);
  }, animateAll: function(n) {
    var a = this;
    if (!this.options.animation) {
      clearTimeout(e), typeof n == "function" && n();
      return;
    }
    var u = false, f = 0;
    l.forEach(function(c) {
      var h = 0, g = c.target, b = g.fromRect, E = ee(g), x = g.prevFromRect, P = g.prevToRect, N = c.rect, S = pt(g, true);
      S && (E.top -= S.f, E.left -= S.e), g.toRect = E, g.thisAnimationDuration && on(x, E) && !on(b, E) && (N.top - E.top) / (N.left - E.left) === (b.top - E.top) / (b.left - E.left) && (h = Xo(N, x, P, a.options)), on(E, b) || (g.prevFromRect = b, g.prevToRect = E, h || (h = a.options.animation), a.animate(g, N, E, h)), h && (u = true, f = Math.max(f, h), clearTimeout(g.animationResetTimer), g.animationResetTimer = setTimeout(function() {
        g.animationTime = 0, g.prevFromRect = null, g.fromRect = null, g.prevToRect = null, g.thisAnimationDuration = null;
      }, h), g.thisAnimationDuration = h);
    }), clearTimeout(e), u ? e = setTimeout(function() {
      typeof n == "function" && n();
    }, f) : typeof n == "function" && n(), l = [];
  }, animate: function(n, a, u, f) {
    if (f) {
      C(n, "transition", ""), C(n, "transform", "");
      var c = pt(this.el), h = c && c.a, g = c && c.d, b = (a.left - u.left) / (h || 1), E = (a.top - u.top) / (g || 1);
      n.animatingX = !!b, n.animatingY = !!E, C(n, "transform", "translate3d(" + b + "px," + E + "px,0)"), this.forRepaintDummy = Wo(n), C(n, "transition", "transform " + f + "ms" + (this.options.easing ? " " + this.options.easing : "")), C(n, "transform", "translate3d(0,0,0)"), typeof n.animated == "number" && clearTimeout(n.animated), n.animated = setTimeout(function() {
        C(n, "transition", ""), C(n, "transform", ""), n.animated = false, n.animatingX = false, n.animatingY = false;
      }, f);
    }
  } };
}
function Wo(l) {
  return l.offsetWidth;
}
function Xo(l, e, t, n) {
  return Math.sqrt(Math.pow(e.top - l.top, 2) + Math.pow(e.left - l.left, 2)) / Math.sqrt(Math.pow(e.top - t.top, 2) + Math.pow(e.left - t.left, 2)) * n.animation;
}
var st = [], an = { initializeByDefault: true }, Ct = { mount: function(e) {
  for (var t in an) an.hasOwnProperty(t) && !(t in e) && (e[t] = an[t]);
  st.forEach(function(n) {
    if (n.pluginName === e.pluginName) throw "Sortable: Cannot mount plugin ".concat(e.pluginName, " more than once");
  }), st.push(e);
}, pluginEvent: function(e, t, n) {
  var a = this;
  this.eventCanceled = false, n.cancel = function() {
    a.eventCanceled = true;
  };
  var u = e + "Global";
  st.forEach(function(f) {
    t[f.pluginName] && (t[f.pluginName][u] && t[f.pluginName][u](Ke({ sortable: t }, n)), t.options[f.pluginName] && t[f.pluginName][e] && t[f.pluginName][e](Ke({ sortable: t }, n)));
  });
}, initializePlugins: function(e, t, n, a) {
  st.forEach(function(c) {
    var h = c.pluginName;
    if (!(!e.options[h] && !c.initializeByDefault)) {
      var g = new c(e, t, e.options);
      g.sortable = e, g.options = e.options, e[h] = g, Ge(n, g.defaults);
    }
  });
  for (var u in e.options) if (e.options.hasOwnProperty(u)) {
    var f = this.modifyOption(e, u, e.options[u]);
    typeof f < "u" && (e.options[u] = f);
  }
}, getEventProperties: function(e, t) {
  var n = {};
  return st.forEach(function(a) {
    typeof a.eventProperties == "function" && Ge(n, a.eventProperties.call(t[a.pluginName], e));
  }), n;
}, modifyOption: function(e, t, n) {
  var a;
  return st.forEach(function(u) {
    e[u.pluginName] && u.optionListeners && typeof u.optionListeners[t] == "function" && (a = u.optionListeners[t].call(e[u.pluginName], n));
  }), a;
} };
function jo(l) {
  var e = l.sortable, t = l.rootEl, n = l.name, a = l.targetEl, u = l.cloneEl, f = l.toEl, c = l.fromEl, h = l.oldIndex, g = l.newIndex, b = l.oldDraggableIndex, E = l.newDraggableIndex, x = l.originalEvent, P = l.putSortable, N = l.extraEventProperties;
  if (e = e || t && t[Ve], !!e) {
    var S, ce = e.options, me = "on" + n.charAt(0).toUpperCase() + n.substr(1);
    window.CustomEvent && !qe && !Dt ? S = new CustomEvent(n, { bubbles: true, cancelable: true }) : (S = document.createEvent("Event"), S.initEvent(n, true, true)), S.to = f || t, S.from = c || t, S.item = a || t, S.clone = u, S.oldIndex = h, S.newIndex = g, S.oldDraggableIndex = b, S.newDraggableIndex = E, S.originalEvent = x, S.pullMode = P ? P.lastPutMode : void 0;
    var L = Ke(Ke({}, N), Ct.getEventProperties(n, e));
    for (var pe in L) S[pe] = L[pe];
    t && t.dispatchEvent(S), ce[me] && ce[me].call(e, S);
  }
}
var Go = ["evt"], Ee = function(e, t) {
  var n = arguments.length > 2 && arguments[2] !== void 0 ? arguments[2] : {}, a = n.evt, u = Ro(n, Go);
  Ct.pluginEvent.bind(k)(e, t, Ke({ dragEl: w, parentEl: J, ghostEl: A, rootEl: W, nextEl: rt, lastDownEl: zt, cloneEl: G, cloneHidden: et, dragStarted: yt, putSortable: ae, activeSortable: k.active, originalEvent: a, oldIndex: ct, oldDraggableIndex: xt, newIndex: Ce, newDraggableIndex: Qe, hideGhostForTarget: ul, unhideGhostForTarget: dl, cloneNowHidden: function() {
    et = true;
  }, cloneNowShown: function() {
    et = false;
  }, dispatchSortableEvent: function(c) {
    ge({ sortable: t, name: c, originalEvent: a });
  } }, u));
};
function ge(l) {
  jo(Ke({ putSortable: ae, cloneEl: G, targetEl: w, rootEl: W, oldIndex: ct, oldDraggableIndex: xt, newIndex: Ce, newDraggableIndex: Qe }, l));
}
var w, J, A, W, rt, zt, G, et, ct, Ce, xt, Qe, Pt, ae, dt = false, Wt = false, Xt = [], ot, Fe, rn, sn, Wn, Xn, yt, ut, Tt, St = false, It = false, Lt, fe, un = [], pn = false, jt = [], qt = typeof document < "u", Ft = yn, jn = Dt || qe ? "cssFloat" : "float", qo = qt && !Zn && !yn && "draggable" in document.createElement("div"), al = (function() {
  if (qt) {
    if (qe) return false;
    var l = document.createElement("x");
    return l.style.cssText = "pointer-events:auto", l.style.pointerEvents === "auto";
  }
})(), rl = function(e, t) {
  var n = C(e), a = parseInt(n.width) - parseInt(n.paddingLeft) - parseInt(n.paddingRight) - parseInt(n.borderLeftWidth) - parseInt(n.borderRightWidth), u = ht(e, 0, t), f = ht(e, 1, t), c = u && C(u), h = f && C(f), g = c && parseInt(c.marginLeft) + parseInt(c.marginRight) + ee(u).width, b = h && parseInt(h.marginLeft) + parseInt(h.marginRight) + ee(f).width;
  if (n.display === "flex") return n.flexDirection === "column" || n.flexDirection === "column-reverse" ? "vertical" : "horizontal";
  if (n.display === "grid") return n.gridTemplateColumns.split(" ").length <= 1 ? "vertical" : "horizontal";
  if (u && c.float && c.float !== "none") {
    var E = c.float === "left" ? "left" : "right";
    return f && (h.clear === "both" || h.clear === E) ? "vertical" : "horizontal";
  }
  return u && (c.display === "block" || c.display === "flex" || c.display === "table" || c.display === "grid" || g >= a && n[jn] === "none" || f && n[jn] === "none" && g + b > a) ? "vertical" : "horizontal";
}, Jo = function(e, t, n) {
  var a = n ? e.left : e.top, u = n ? e.right : e.bottom, f = n ? e.width : e.height, c = n ? t.left : t.top, h = n ? t.right : t.bottom, g = n ? t.width : t.height;
  return a === c || u === h || a + f / 2 === c + g / 2;
}, Zo = function(e, t) {
  var n;
  return Xt.some(function(a) {
    var u = a[Ve].options.emptyInsertThreshold;
    if (!(!u || wn(a))) {
      var f = ee(a), c = e >= f.left - u && e <= f.right + u, h = t >= f.top - u && t <= f.bottom + u;
      if (c && h) return n = a;
    }
  }), n;
}, sl = function(e) {
  function t(u, f) {
    return function(c, h, g, b) {
      var E = c.options.group.name && h.options.group.name && c.options.group.name === h.options.group.name;
      if (u == null && (f || E)) return true;
      if (u == null || u === false) return false;
      if (f && u === "clone") return u;
      if (typeof u == "function") return t(u(c, h, g, b), f)(c, h, g, b);
      var x = (f ? c : h).options.group.name;
      return u === true || typeof u == "string" && u === x || u.join && u.indexOf(x) > -1;
    };
  }
  var n = {}, a = e.group;
  (!a || Rt(a) != "object") && (a = { name: a }), n.name = a.name, n.checkPull = t(a.pull, true), n.checkPut = t(a.put), n.revertClone = a.revertClone, e.group = n;
}, ul = function() {
  !al && A && C(A, "display", "none");
}, dl = function() {
  !al && A && C(A, "display", "");
};
qt && !Zn && document.addEventListener("click", function(l) {
  if (Wt) return l.preventDefault(), l.stopPropagation && l.stopPropagation(), l.stopImmediatePropagation && l.stopImmediatePropagation(), Wt = false, false;
}, true);
var it = function(e) {
  if (w) {
    e = e.touches ? e.touches[0] : e;
    var t = Zo(e.clientX, e.clientY);
    if (t) {
      var n = {};
      for (var a in e) e.hasOwnProperty(a) && (n[a] = e[a]);
      n.target = n.rootEl = t, n.preventDefault = void 0, n.stopPropagation = void 0, t[Ve]._onDragOver(n);
    }
  }
}, Qo = function(e) {
  w && w.parentNode[Ve]._isOutsideThisEl(e.target);
};
function k(l, e) {
  if (!(l && l.nodeType && l.nodeType === 1)) throw "Sortable: `el` must be an HTMLElement, not ".concat({}.toString.call(l));
  this.el = l, this.options = e = Ge({}, e), l[Ve] = this;
  var t = { group: null, sort: true, disabled: false, store: null, handle: null, draggable: /^[uo]l$/i.test(l.nodeName) ? ">li" : ">*", swapThreshold: 1, invertSwap: false, invertedSwapThreshold: null, removeCloneOnHide: true, direction: function() {
    return rl(l, this.options);
  }, ghostClass: "sortable-ghost", chosenClass: "sortable-chosen", dragClass: "sortable-drag", ignore: "a, img", filter: null, preventOnFilter: true, animation: 0, easing: null, setData: function(f, c) {
    f.setData("Text", c.textContent);
  }, dropBubble: false, dragoverBubble: false, dataIdAttr: "data-id", delay: 0, delayOnTouchOnly: false, touchStartThreshold: (Number.parseInt ? Number : window).parseInt(window.devicePixelRatio, 10) || 1, forceFallback: false, fallbackClass: "sortable-fallback", fallbackOnBody: false, fallbackTolerance: 0, fallbackOffset: { x: 0, y: 0 }, supportPointer: k.supportPointer !== false && "PointerEvent" in window && (!Et || yn), emptyInsertThreshold: 5 };
  Ct.initializePlugins(this, l, t);
  for (var n in t) !(n in e) && (e[n] = t[n]);
  sl(e);
  for (var a in this) a.charAt(0) === "_" && typeof this[a] == "function" && (this[a] = this[a].bind(this));
  this.nativeDraggable = e.forceFallback ? false : qo, this.nativeDraggable && (this.options.touchStartThreshold = 1), e.supportPointer ? R(l, "pointerdown", this._onTapStart) : (R(l, "mousedown", this._onTapStart), R(l, "touchstart", this._onTapStart)), this.nativeDraggable && (R(l, "dragover", this), R(l, "dragenter", this)), Xt.push(this.el), e.store && e.store.get && this.sort(e.store.get(this) || []), Ge(this, Ko());
}
k.prototype = { constructor: k, _isOutsideThisEl: function(e) {
  !this.el.contains(e) && e !== this.el && (ut = null);
}, _getDirection: function(e, t) {
  return typeof this.options.direction == "function" ? this.options.direction.call(this, e, t, w) : this.options.direction;
}, _onTapStart: function(e) {
  if (e.cancelable) {
    var t = this, n = this.el, a = this.options, u = a.preventOnFilter, f = e.type, c = e.touches && e.touches[0] || e.pointerType && e.pointerType === "touch" && e, h = (c || e).target, g = e.target.shadowRoot && (e.path && e.path[0] || e.composedPath && e.composedPath()[0]) || h, b = a.filter;
    if (ri(n), !w && !(/mousedown|pointerdown/.test(f) && e.button !== 0 || a.disabled) && !g.isContentEditable && !(!this.nativeDraggable && Et && h && h.tagName.toUpperCase() === "SELECT") && (h = He(h, a.draggable, n, false), !(h && h.animated) && zt !== h)) {
      if (ct = Me(h), xt = Me(h, a.draggable), typeof b == "function") {
        if (b.call(this, e, h, this)) {
          ge({ sortable: t, rootEl: g, name: "filter", targetEl: h, toEl: n, fromEl: n }), Ee("filter", t, { evt: e }), u && e.preventDefault();
          return;
        }
      } else if (b && (b = b.split(",").some(function(E) {
        if (E = He(g, E.trim(), n, false), E) return ge({ sortable: t, rootEl: E, name: "filter", targetEl: h, fromEl: n, toEl: n }), Ee("filter", t, { evt: e }), true;
      }), b)) {
        u && e.preventDefault();
        return;
      }
      a.handle && !He(g, a.handle, n, false) || this._prepareDragStart(e, c, h);
    }
  }
}, _prepareDragStart: function(e, t, n) {
  var a = this, u = a.el, f = a.options, c = u.ownerDocument, h;
  if (n && !w && n.parentNode === u) {
    var g = ee(n);
    if (W = u, w = n, J = w.parentNode, rt = w.nextSibling, zt = n, Pt = f.group, k.dragged = w, ot = { target: w, clientX: (t || e).clientX, clientY: (t || e).clientY }, Wn = ot.clientX - g.left, Xn = ot.clientY - g.top, this._lastX = (t || e).clientX, this._lastY = (t || e).clientY, w.style["will-change"] = "all", h = function() {
      if (Ee("delayEnded", a, { evt: e }), k.eventCanceled) {
        a._onDrop();
        return;
      }
      a._disableDelayedDragEvents(), !Ln && a.nativeDraggable && (w.draggable = true), a._triggerDragStart(e, t), ge({ sortable: a, name: "choose", originalEvent: e }), De(w, f.chosenClass, true);
    }, f.ignore.split(",").forEach(function(b) {
      tl(w, b.trim(), dn);
    }), R(c, "dragover", it), R(c, "mousemove", it), R(c, "touchmove", it), f.supportPointer ? (R(c, "pointerup", a._onDrop), !this.nativeDraggable && R(c, "pointercancel", a._onDrop)) : (R(c, "mouseup", a._onDrop), R(c, "touchend", a._onDrop), R(c, "touchcancel", a._onDrop)), Ln && this.nativeDraggable && (this.options.touchStartThreshold = 4, w.draggable = true), Ee("delayStart", this, { evt: e }), f.delay && (!f.delayOnTouchOnly || t) && (!this.nativeDraggable || !(Dt || qe))) {
      if (k.eventCanceled) {
        this._onDrop();
        return;
      }
      f.supportPointer ? (R(c, "pointerup", a._disableDelayedDrag), R(c, "pointercancel", a._disableDelayedDrag)) : (R(c, "mouseup", a._disableDelayedDrag), R(c, "touchend", a._disableDelayedDrag), R(c, "touchcancel", a._disableDelayedDrag)), R(c, "mousemove", a._delayedDragTouchMoveHandler), R(c, "touchmove", a._delayedDragTouchMoveHandler), f.supportPointer && R(c, "pointermove", a._delayedDragTouchMoveHandler), a._dragStartTimer = setTimeout(h, f.delay);
    } else h();
  }
}, _delayedDragTouchMoveHandler: function(e) {
  var t = e.touches ? e.touches[0] : e;
  Math.max(Math.abs(t.clientX - this._lastX), Math.abs(t.clientY - this._lastY)) >= Math.floor(this.options.touchStartThreshold / (this.nativeDraggable && window.devicePixelRatio || 1)) && this._disableDelayedDrag();
}, _disableDelayedDrag: function() {
  w && dn(w), clearTimeout(this._dragStartTimer), this._disableDelayedDragEvents();
}, _disableDelayedDragEvents: function() {
  var e = this.el.ownerDocument;
  F(e, "mouseup", this._disableDelayedDrag), F(e, "touchend", this._disableDelayedDrag), F(e, "touchcancel", this._disableDelayedDrag), F(e, "pointerup", this._disableDelayedDrag), F(e, "pointercancel", this._disableDelayedDrag), F(e, "mousemove", this._delayedDragTouchMoveHandler), F(e, "touchmove", this._delayedDragTouchMoveHandler), F(e, "pointermove", this._delayedDragTouchMoveHandler);
}, _triggerDragStart: function(e, t) {
  t = t || e.pointerType == "touch" && e, !this.nativeDraggable || t ? this.options.supportPointer ? R(document, "pointermove", this._onTouchMove) : t ? R(document, "touchmove", this._onTouchMove) : R(document, "mousemove", this._onTouchMove) : (R(w, "dragend", this), R(W, "dragstart", this._onDragStart));
  try {
    document.selection ? Bt(function() {
      document.selection.empty();
    }) : window.getSelection().removeAllRanges();
  } catch {
  }
}, _dragStarted: function(e, t) {
  if (dt = false, W && w) {
    Ee("dragStarted", this, { evt: t }), this.nativeDraggable && R(document, "dragover", Qo);
    var n = this.options;
    !e && De(w, n.dragClass, false), De(w, n.ghostClass, true), k.active = this, e && this._appendGhost(), ge({ sortable: this, name: "start", originalEvent: t });
  } else this._nulling();
}, _emulateDragOver: function() {
  if (Fe) {
    this._lastX = Fe.clientX, this._lastY = Fe.clientY, ul();
    for (var e = document.elementFromPoint(Fe.clientX, Fe.clientY), t = e; e && e.shadowRoot && (e = e.shadowRoot.elementFromPoint(Fe.clientX, Fe.clientY), e !== t); ) t = e;
    if (w.parentNode[Ve]._isOutsideThisEl(e), t) do {
      if (t[Ve]) {
        var n = void 0;
        if (n = t[Ve]._onDragOver({ clientX: Fe.clientX, clientY: Fe.clientY, target: e, rootEl: t }), n && !this.options.dragoverBubble) break;
      }
      e = t;
    } while (t = el(t));
    dl();
  }
}, _onTouchMove: function(e) {
  if (ot) {
    var t = this.options, n = t.fallbackTolerance, a = t.fallbackOffset, u = e.touches ? e.touches[0] : e, f = A && pt(A, true), c = A && f && f.a, h = A && f && f.d, g = Ft && fe && Kn(fe), b = (u.clientX - ot.clientX + a.x) / (c || 1) + (g ? g[0] - un[0] : 0) / (c || 1), E = (u.clientY - ot.clientY + a.y) / (h || 1) + (g ? g[1] - un[1] : 0) / (h || 1);
    if (!k.active && !dt) {
      if (n && Math.max(Math.abs(u.clientX - this._lastX), Math.abs(u.clientY - this._lastY)) < n) return;
      this._onDragStart(e, true);
    }
    if (A) {
      f ? (f.e += b - (rn || 0), f.f += E - (sn || 0)) : f = { a: 1, b: 0, c: 0, d: 1, e: b, f: E };
      var x = "matrix(".concat(f.a, ",").concat(f.b, ",").concat(f.c, ",").concat(f.d, ",").concat(f.e, ",").concat(f.f, ")");
      C(A, "webkitTransform", x), C(A, "mozTransform", x), C(A, "msTransform", x), C(A, "transform", x), rn = b, sn = E, Fe = u;
    }
    e.cancelable && e.preventDefault();
  }
}, _appendGhost: function() {
  if (!A) {
    var e = this.options.fallbackOnBody ? document.body : W, t = ee(w, true, Ft, true, e), n = this.options;
    if (Ft) {
      for (fe = e; C(fe, "position") === "static" && C(fe, "transform") === "none" && fe !== document; ) fe = fe.parentNode;
      fe !== document.body && fe !== document.documentElement ? (fe === document && (fe = Ye()), t.top += fe.scrollTop, t.left += fe.scrollLeft) : fe = Ye(), un = Kn(fe);
    }
    A = w.cloneNode(true), De(A, n.ghostClass, false), De(A, n.fallbackClass, true), De(A, n.dragClass, true), C(A, "transition", ""), C(A, "transform", ""), C(A, "box-sizing", "border-box"), C(A, "margin", 0), C(A, "top", t.top), C(A, "left", t.left), C(A, "width", t.width), C(A, "height", t.height), C(A, "opacity", "0.8"), C(A, "position", Ft ? "absolute" : "fixed"), C(A, "zIndex", "100000"), C(A, "pointerEvents", "none"), k.ghost = A, e.appendChild(A), C(A, "transform-origin", Wn / parseInt(A.style.width) * 100 + "% " + Xn / parseInt(A.style.height) * 100 + "%");
  }
}, _onDragStart: function(e, t) {
  var n = this, a = e.dataTransfer, u = n.options;
  if (Ee("dragStart", this, { evt: e }), k.eventCanceled) {
    this._onDrop();
    return;
  }
  Ee("setupClone", this), k.eventCanceled || (G = ol(w), G.removeAttribute("id"), G.draggable = false, G.style["will-change"] = "", this._hideClone(), De(G, this.options.chosenClass, false), k.clone = G), n.cloneId = Bt(function() {
    Ee("clone", n), !k.eventCanceled && (n.options.removeCloneOnHide || W.insertBefore(G, w), n._hideClone(), ge({ sortable: n, name: "clone" }));
  }), !t && De(w, u.dragClass, true), t ? (Wt = true, n._loopId = setInterval(n._emulateDragOver, 50)) : (F(document, "mouseup", n._onDrop), F(document, "touchend", n._onDrop), F(document, "touchcancel", n._onDrop), a && (a.effectAllowed = "move", u.setData && u.setData.call(n, a, w)), R(document, "drop", n), C(w, "transform", "translateZ(0)")), dt = true, n._dragStartId = Bt(n._dragStarted.bind(n, t, e)), R(document, "selectstart", n), yt = true, window.getSelection().removeAllRanges(), Et && C(document.body, "user-select", "none");
}, _onDragOver: function(e) {
  var t = this.el, n = e.target, a, u, f, c = this.options, h = c.group, g = k.active, b = Pt === h, E = c.sort, x = ae || g, P, N = this, S = false;
  if (pn) return;
  function ce(re, X) {
    Ee(re, N, Ke({ evt: e, isOwner: b, axis: P ? "vertical" : "horizontal", revert: f, dragRect: a, targetRect: u, canSort: E, fromSortable: x, target: n, completed: L, onMove: function(q, B) {
      return Ht(W, t, w, a, q, ee(q), e, B);
    }, changed: pe }, X));
  }
  function me() {
    ce("dragOverAnimationCapture"), N.captureAnimationState(), N !== x && x.captureAnimationState();
  }
  function L(re) {
    return ce("dragOverCompleted", { insertion: re }), re && (b ? g._hideClone() : g._showClone(N), N !== x && (De(w, ae ? ae.options.ghostClass : g.options.ghostClass, false), De(w, c.ghostClass, true)), ae !== N && N !== k.active ? ae = N : N === k.active && ae && (ae = null), x === N && (N._ignoreWhileAnimating = n), N.animateAll(function() {
      ce("dragOverAnimationComplete"), N._ignoreWhileAnimating = null;
    }), N !== x && (x.animateAll(), x._ignoreWhileAnimating = null)), (n === w && !w.animated || n === t && !n.animated) && (ut = null), !c.dragoverBubble && !e.rootEl && n !== document && (w.parentNode[Ve]._isOutsideThisEl(e.target), !re && it(e)), !c.dragoverBubble && e.stopPropagation && e.stopPropagation(), S = true;
  }
  function pe() {
    Ce = Me(w), Qe = Me(w, c.draggable), ge({ sortable: N, name: "change", toEl: t, newIndex: Ce, newDraggableIndex: Qe, originalEvent: e });
  }
  if (e.preventDefault !== void 0 && e.cancelable && e.preventDefault(), n = He(n, c.draggable, t, true), ce("dragOver"), k.eventCanceled) return S;
  if (w.contains(e.target) || n.animated && n.animatingX && n.animatingY || N._ignoreWhileAnimating === n) return L(false);
  if (Wt = false, g && !c.disabled && (b ? E || (f = J !== W) : ae === this || (this.lastPutMode = Pt.checkPull(this, g, w, e)) && h.checkPut(this, g, w, e))) {
    if (P = this._getDirection(e, n) === "vertical", a = ee(w), ce("dragOverValid"), k.eventCanceled) return S;
    if (f) return J = W, me(), this._hideClone(), ce("revert"), k.eventCanceled || (rt ? W.insertBefore(w, rt) : W.appendChild(w)), L(true);
    var ne = wn(t, c.draggable);
    if (!ne || li(e, P, this) && !ne.animated) {
      if (ne === w) return L(false);
      if (ne && t === e.target && (n = ne), n && (u = ee(n)), Ht(W, t, w, a, n, u, e, !!n) !== false) return me(), ne && ne.nextSibling ? t.insertBefore(w, ne.nextSibling) : t.appendChild(w), J = t, pe(), L(true);
    } else if (ne && ni(e, P, this)) {
      var Oe = ht(t, 0, c, true);
      if (Oe === w) return L(false);
      if (n = Oe, u = ee(n), Ht(W, t, w, a, n, u, e, false) !== false) return me(), t.insertBefore(w, Oe), J = t, pe(), L(true);
    } else if (n.parentNode === t) {
      u = ee(n);
      var ve = 0, Ae, nt = w.parentNode !== t, le = !Jo(w.animated && w.toRect || a, n.animated && n.toRect || u, P), Ne = P ? "top" : "left", be = Yn(n, "top", "top") || Yn(w, "top", "top"), We = be ? be.scrollTop : void 0;
      ut !== n && (Ae = u[Ne], St = false, It = !le && c.invertSwap || nt), ve = oi(e, n, u, P, le ? 1 : c.swapThreshold, c.invertedSwapThreshold == null ? c.swapThreshold : c.invertedSwapThreshold, It, ut === n);
      var ke;
      if (ve !== 0) {
        var Ue = Me(w);
        do
          Ue -= ve, ke = J.children[Ue];
        while (ke && (C(ke, "display") === "none" || ke === A));
      }
      if (ve === 0 || ke === n) return L(false);
      ut = n, Tt = ve;
      var ze = n.nextElementSibling, ye = false;
      ye = ve === 1;
      var U = Ht(W, t, w, a, n, u, e, ye);
      if (U !== false) return (U === 1 || U === -1) && (ye = U === 1), pn = true, setTimeout(ti, 30), me(), ye && !ze ? t.appendChild(w) : n.parentNode.insertBefore(w, ye ? ze : n), be && ll(be, 0, We - be.scrollTop), J = w.parentNode, Ae !== void 0 && !It && (Lt = Math.abs(Ae - ee(n)[Ne])), pe(), L(true);
    }
    if (t.contains(w)) return L(false);
  }
  return false;
}, _ignoreWhileAnimating: null, _offMoveEvents: function() {
  F(document, "mousemove", this._onTouchMove), F(document, "touchmove", this._onTouchMove), F(document, "pointermove", this._onTouchMove), F(document, "dragover", it), F(document, "mousemove", it), F(document, "touchmove", it);
}, _offUpEvents: function() {
  var e = this.el.ownerDocument;
  F(e, "mouseup", this._onDrop), F(e, "touchend", this._onDrop), F(e, "pointerup", this._onDrop), F(e, "pointercancel", this._onDrop), F(e, "touchcancel", this._onDrop), F(document, "selectstart", this);
}, _onDrop: function(e) {
  var t = this.el, n = this.options;
  if (Ce = Me(w), Qe = Me(w, n.draggable), Ee("drop", this, { evt: e }), J = w && w.parentNode, Ce = Me(w), Qe = Me(w, n.draggable), k.eventCanceled) {
    this._nulling();
    return;
  }
  dt = false, It = false, St = false, clearInterval(this._loopId), clearTimeout(this._dragStartTimer), hn(this.cloneId), hn(this._dragStartId), this.nativeDraggable && (F(document, "drop", this), F(t, "dragstart", this._onDragStart)), this._offMoveEvents(), this._offUpEvents(), Et && C(document.body, "user-select", ""), C(w, "transform", ""), e && (yt && (e.cancelable && e.preventDefault(), !n.dropBubble && e.stopPropagation()), A && A.parentNode && A.parentNode.removeChild(A), (W === J || ae && ae.lastPutMode !== "clone") && G && G.parentNode && G.parentNode.removeChild(G), w && (this.nativeDraggable && F(w, "dragend", this), dn(w), w.style["will-change"] = "", yt && !dt && De(w, ae ? ae.options.ghostClass : this.options.ghostClass, false), De(w, this.options.chosenClass, false), ge({ sortable: this, name: "unchoose", toEl: J, newIndex: null, newDraggableIndex: null, originalEvent: e }), W !== J ? (Ce >= 0 && (ge({ rootEl: J, name: "add", toEl: J, fromEl: W, originalEvent: e }), ge({ sortable: this, name: "remove", toEl: J, originalEvent: e }), ge({ rootEl: J, name: "sort", toEl: J, fromEl: W, originalEvent: e }), ge({ sortable: this, name: "sort", toEl: J, originalEvent: e })), ae && ae.save()) : Ce !== ct && Ce >= 0 && (ge({ sortable: this, name: "update", toEl: J, originalEvent: e }), ge({ sortable: this, name: "sort", toEl: J, originalEvent: e })), k.active && ((Ce == null || Ce === -1) && (Ce = ct, Qe = xt), ge({ sortable: this, name: "end", toEl: J, originalEvent: e }), this.save()))), this._nulling();
}, _nulling: function() {
  Ee("nulling", this), W = w = J = A = rt = G = zt = et = ot = Fe = yt = Ce = Qe = ct = xt = ut = Tt = ae = Pt = k.dragged = k.ghost = k.clone = k.active = null, jt.forEach(function(e) {
    e.checked = true;
  }), jt.length = rn = sn = 0;
}, handleEvent: function(e) {
  switch (e.type) {
    case "drop":
    case "dragend":
      this._onDrop(e);
      break;
    case "dragenter":
    case "dragover":
      w && (this._onDragOver(e), ei(e));
      break;
    case "selectstart":
      e.preventDefault();
      break;
  }
}, toArray: function() {
  for (var e = [], t, n = this.el.children, a = 0, u = n.length, f = this.options; a < u; a++) t = n[a], He(t, f.draggable, this.el, false) && e.push(t.getAttribute(f.dataIdAttr) || ai(t));
  return e;
}, sort: function(e, t) {
  var n = {}, a = this.el;
  this.toArray().forEach(function(u, f) {
    var c = a.children[f];
    He(c, this.options.draggable, a, false) && (n[u] = c);
  }, this), t && this.captureAnimationState(), e.forEach(function(u) {
    n[u] && (a.removeChild(n[u]), a.appendChild(n[u]));
  }), t && this.animateAll();
}, save: function() {
  var e = this.options.store;
  e && e.set && e.set(this);
}, closest: function(e, t) {
  return He(e, t || this.options.draggable, this.el, false);
}, option: function(e, t) {
  var n = this.options;
  if (t === void 0) return n[e];
  var a = Ct.modifyOption(this, e, t);
  typeof a < "u" ? n[e] = a : n[e] = t, e === "group" && sl(n);
}, destroy: function() {
  Ee("destroy", this);
  var e = this.el;
  e[Ve] = null, F(e, "mousedown", this._onTapStart), F(e, "touchstart", this._onTapStart), F(e, "pointerdown", this._onTapStart), this.nativeDraggable && (F(e, "dragover", this), F(e, "dragenter", this)), Array.prototype.forEach.call(e.querySelectorAll("[draggable]"), function(t) {
    t.removeAttribute("draggable");
  }), this._onDrop(), this._disableDelayedDragEvents(), Xt.splice(Xt.indexOf(this.el), 1), this.el = e = null;
}, _hideClone: function() {
  if (!et) {
    if (Ee("hideClone", this), k.eventCanceled) return;
    C(G, "display", "none"), this.options.removeCloneOnHide && G.parentNode && G.parentNode.removeChild(G), et = true;
  }
}, _showClone: function(e) {
  if (e.lastPutMode !== "clone") {
    this._hideClone();
    return;
  }
  if (et) {
    if (Ee("showClone", this), k.eventCanceled) return;
    w.parentNode == W && !this.options.group.revertClone ? W.insertBefore(G, w) : rt ? W.insertBefore(G, rt) : W.appendChild(G), this.options.group.revertClone && this.animate(w, G), C(G, "display", ""), et = false;
  }
} };
function ei(l) {
  l.dataTransfer && (l.dataTransfer.dropEffect = "move"), l.cancelable && l.preventDefault();
}
function Ht(l, e, t, n, a, u, f, c) {
  var h, g = l[Ve], b = g.options.onMove, E;
  return window.CustomEvent && !qe && !Dt ? h = new CustomEvent("move", { bubbles: true, cancelable: true }) : (h = document.createEvent("Event"), h.initEvent("move", true, true)), h.to = e, h.from = l, h.dragged = t, h.draggedRect = n, h.related = a || e, h.relatedRect = u || ee(e), h.willInsertAfter = c, h.originalEvent = f, l.dispatchEvent(h), b && (E = b.call(g, h, f)), E;
}
function dn(l) {
  l.draggable = false;
}
function ti() {
  pn = false;
}
function ni(l, e, t) {
  var n = ee(ht(t.el, 0, t.options, true)), a = il(t.el, t.options, A), u = 10;
  return e ? l.clientX < a.left - u || l.clientY < n.top && l.clientX < n.right : l.clientY < a.top - u || l.clientY < n.bottom && l.clientX < n.left;
}
function li(l, e, t) {
  var n = ee(wn(t.el, t.options.draggable)), a = il(t.el, t.options, A), u = 10;
  return e ? l.clientX > a.right + u || l.clientY > n.bottom && l.clientX > n.left : l.clientY > a.bottom + u || l.clientX > n.right && l.clientY > n.top;
}
function oi(l, e, t, n, a, u, f, c) {
  var h = n ? l.clientY : l.clientX, g = n ? t.height : t.width, b = n ? t.top : t.left, E = n ? t.bottom : t.right, x = false;
  if (!f) {
    if (c && Lt < g * a) {
      if (!St && (Tt === 1 ? h > b + g * u / 2 : h < E - g * u / 2) && (St = true), St) x = true;
      else if (Tt === 1 ? h < b + Lt : h > E - Lt) return -Tt;
    } else if (h > b + g * (1 - a) / 2 && h < E - g * (1 - a) / 2) return ii(e);
  }
  return x = x || f, x && (h < b + g * u / 2 || h > E - g * u / 2) ? h > b + g / 2 ? 1 : -1 : 0;
}
function ii(l) {
  return Me(w) < Me(l) ? 1 : -1;
}
function ai(l) {
  for (var e = l.tagName + l.className + l.src + l.href + l.textContent, t = e.length, n = 0; t--; ) n += e.charCodeAt(t);
  return n.toString(36);
}
function ri(l) {
  jt.length = 0;
  for (var e = l.getElementsByTagName("input"), t = e.length; t--; ) {
    var n = e[t];
    n.checked && jt.push(n);
  }
}
function Bt(l) {
  return setTimeout(l, 0);
}
function hn(l) {
  return clearTimeout(l);
}
qt && R(document, "touchmove", function(l) {
  (k.active || dt) && l.cancelable && l.preventDefault();
});
k.utils = { on: R, off: F, css: C, find: tl, is: function(e, t) {
  return !!He(e, t, e, false);
}, extend: Bo, throttle: nl, closest: He, toggleClass: De, clone: ol, index: Me, nextTick: Bt, cancelNextTick: hn, detectDirection: rl, getChild: ht, expando: Ve };
k.get = function(l) {
  return l[Ve];
};
k.mount = function() {
  for (var l = arguments.length, e = new Array(l), t = 0; t < l; t++) e[t] = arguments[t];
  e[0].constructor === Array && (e = e[0]), e.forEach(function(n) {
    if (!n.prototype || !n.prototype.constructor) throw "Sortable: Mounted plugin must be a constructor function, not ".concat({}.toString.call(n));
    n.utils && (k.utils = Ke(Ke({}, k.utils), n.utils)), Ct.mount(n);
  });
};
k.create = function(l, e) {
  return new k(l, e);
};
k.version = zo;
var Q = [], wt, gn, vn = false, fn, cn, Gt, _t;
function si() {
  function l() {
    this.defaults = { scroll: true, forceAutoScrollFallback: false, scrollSensitivity: 30, scrollSpeed: 10, bubbleScroll: true };
    for (var e in this) e.charAt(0) === "_" && typeof this[e] == "function" && (this[e] = this[e].bind(this));
  }
  return l.prototype = { dragStarted: function(t) {
    var n = t.originalEvent;
    this.sortable.nativeDraggable ? R(document, "dragover", this._handleAutoScroll) : this.options.supportPointer ? R(document, "pointermove", this._handleFallbackAutoScroll) : n.touches ? R(document, "touchmove", this._handleFallbackAutoScroll) : R(document, "mousemove", this._handleFallbackAutoScroll);
  }, dragOverCompleted: function(t) {
    var n = t.originalEvent;
    !this.options.dragOverBubble && !n.rootEl && this._handleAutoScroll(n);
  }, drop: function() {
    this.sortable.nativeDraggable ? F(document, "dragover", this._handleAutoScroll) : (F(document, "pointermove", this._handleFallbackAutoScroll), F(document, "touchmove", this._handleFallbackAutoScroll), F(document, "mousemove", this._handleFallbackAutoScroll)), Gn(), Yt(), Yo();
  }, nulling: function() {
    Gt = gn = wt = vn = _t = fn = cn = null, Q.length = 0;
  }, _handleFallbackAutoScroll: function(t) {
    this._handleAutoScroll(t, true);
  }, _handleAutoScroll: function(t, n) {
    var a = this, u = (t.touches ? t.touches[0] : t).clientX, f = (t.touches ? t.touches[0] : t).clientY, c = document.elementFromPoint(u, f);
    if (Gt = t, n || this.options.forceAutoScrollFallback || Dt || qe || Et) {
      mn(t, this.options, c, n);
      var h = tt(c, true);
      vn && (!_t || u !== fn || f !== cn) && (_t && Gn(), _t = setInterval(function() {
        var g = tt(document.elementFromPoint(u, f), true);
        g !== h && (h = g, Yt()), mn(t, a.options, g, n);
      }, 10), fn = u, cn = f);
    } else {
      if (!this.options.bubbleScroll || tt(c, true) === Ye()) {
        Yt();
        return;
      }
      mn(t, this.options, tt(c, false), false);
    }
  } }, Ge(l, { pluginName: "scroll", initializeByDefault: true });
}
function Yt() {
  Q.forEach(function(l) {
    clearInterval(l.pid);
  }), Q = [];
}
function Gn() {
  clearInterval(_t);
}
var mn = nl(function(l, e, t, n) {
  if (e.scroll) {
    var a = (l.touches ? l.touches[0] : l).clientX, u = (l.touches ? l.touches[0] : l).clientY, f = e.scrollSensitivity, c = e.scrollSpeed, h = Ye(), g = false, b;
    gn !== t && (gn = t, Yt(), wt = e.scroll, b = e.scrollFn, wt === true && (wt = tt(t, true)));
    var E = 0, x = wt;
    do {
      var P = x, N = ee(P), S = N.top, ce = N.bottom, me = N.left, L = N.right, pe = N.width, ne = N.height, Oe = void 0, ve = void 0, Ae = P.scrollWidth, nt = P.scrollHeight, le = C(P), Ne = P.scrollLeft, be = P.scrollTop;
      P === h ? (Oe = pe < Ae && (le.overflowX === "auto" || le.overflowX === "scroll" || le.overflowX === "visible"), ve = ne < nt && (le.overflowY === "auto" || le.overflowY === "scroll" || le.overflowY === "visible")) : (Oe = pe < Ae && (le.overflowX === "auto" || le.overflowX === "scroll"), ve = ne < nt && (le.overflowY === "auto" || le.overflowY === "scroll"));
      var We = Oe && (Math.abs(L - a) <= f && Ne + pe < Ae) - (Math.abs(me - a) <= f && !!Ne), ke = ve && (Math.abs(ce - u) <= f && be + ne < nt) - (Math.abs(S - u) <= f && !!be);
      if (!Q[E]) for (var Ue = 0; Ue <= E; Ue++) Q[Ue] || (Q[Ue] = {});
      (Q[E].vx != We || Q[E].vy != ke || Q[E].el !== P) && (Q[E].el = P, Q[E].vx = We, Q[E].vy = ke, clearInterval(Q[E].pid), (We != 0 || ke != 0) && (g = true, Q[E].pid = setInterval((function() {
        n && this.layer === 0 && k.active._onTouchMove(Gt);
        var ze = Q[this.layer].vy ? Q[this.layer].vy * c : 0, ye = Q[this.layer].vx ? Q[this.layer].vx * c : 0;
        typeof b == "function" && b.call(k.dragged.parentNode[Ve], ye, ze, l, Gt, Q[this.layer].el) !== "continue" || ll(Q[this.layer].el, ye, ze);
      }).bind({ layer: E }), 24))), E++;
    } while (e.bubbleScroll && x !== h && (x = tt(x, false)));
    vn = g;
  }
}, 30), fl = function(e) {
  var t = e.originalEvent, n = e.putSortable, a = e.dragEl, u = e.activeSortable, f = e.dispatchSortableEvent, c = e.hideGhostForTarget, h = e.unhideGhostForTarget;
  if (t) {
    var g = n || u;
    c();
    var b = t.changedTouches && t.changedTouches.length ? t.changedTouches[0] : t, E = document.elementFromPoint(b.clientX, b.clientY);
    h(), g && !g.el.contains(E) && (f("spill"), this.onSpill({ dragEl: a, putSortable: n }));
  }
};
function _n() {
}
_n.prototype = { startIndex: null, dragStart: function(e) {
  var t = e.oldDraggableIndex;
  this.startIndex = t;
}, onSpill: function(e) {
  var t = e.dragEl, n = e.putSortable;
  this.sortable.captureAnimationState(), n && n.captureAnimationState();
  var a = ht(this.sortable.el, this.startIndex, this.options);
  a ? this.sortable.el.insertBefore(t, a) : this.sortable.el.appendChild(t), this.sortable.animateAll(), n && n.animateAll();
}, drop: fl };
Ge(_n, { pluginName: "revertOnSpill" });
function En() {
}
En.prototype = { onSpill: function(e) {
  var t = e.dragEl, n = e.putSortable, a = n || this.sortable;
  a.captureAnimationState(), t.parentNode && t.parentNode.removeChild(t), a.animateAll();
}, drop: fl };
Ge(En, { pluginName: "removeOnSpill" });
k.mount(new si());
k.mount(En, _n);
const ui = { class: "print-template-title" }, di = { class: "dialog-middle" }, fi = { class: "middle-left" }, ci = ["innerHTML"], mi = ["innerHTML"], pi = ["innerHTML"], hi = ["innerHTML"], gi = ["innerHTML"], vi = ["innerHTML"], bi = { key: 1, class: "table-type-tip" }, yi = { key: 1, class: "table-type-tip" }, wi = { class: "middle-right" }, _i = { class: "form-card" }, Ei = { class: "form-card form-card-inline-block" }, Vi = { key: 0, class: "form-cards" }, xi = { class: "form-card form-card-inline-block" }, Ti = { class: "form-card form-card-inline-block" }, Si = { key: 0, class: "form-card form-card-inline-block" }, Di = { key: 1, class: "form-card form-card-inline-block" }, Ci = { class: "logo-box" }, ki = ["onClick"], Ui = { class: "logo-select" }, Mi = { class: "logo-default" }, Oi = { key: 2, class: "form-card form-card-inline-block" }, Ai = { key: 0, class: "form-card form-card-inline-block" }, Ni = { class: "form-card form-card-inline-block" }, $i = { class: "form-card form-card-inline-block" }, Pi = { class: "form-card form-card-inline-block" }, Ii = { class: "form-card form-card-inline-block clearfix" }, Fi = { class: "filter-container", style: { display: "flex", width: "100%", "margin-bottom": "15px" } }, Hi = { class: "filter-left-box" }, Ri = { class: "filter-right-box" }, zi = { key: 0 }, Li = { key: 2, class: "delimiter" }, Bi = { key: 0 }, Yi = { key: 1 }, Ki = { key: 2 }, Wi = { class: "form-card form-card-inline-block" }, Xi = { class: "form-card form-card-inline-block clearfix" }, ji = { key: 0 }, Gi = { key: 0 }, qi = { key: 2, class: "delimiter" }, Ji = { key: 0 }, Zi = { key: 1 }, Qi = { class: "form-card form-card-inline-block" }, ea = { class: "form-card form-card-inline-block" }, ta = { style: { width: "100%", padding: "0 20px", "margin-top": "10px" } }, na = { class: "form-card form-card-inline-block clearfix" }, la = { key: 0 }, oa = { key: 0 }, ia = { key: 2, class: "delimiter" }, aa = { key: 0 }, ra = { key: 1 }, sa = { key: 3, class: "delimiter" }, ua = { __name: "form", setup(l) {
  const e = [D.RATE.K, D.PROJECT.K, D.DATE.K, D.DATES.K, D.AMOUNT.K, D.LENGTH.K, D.WEIGHT.K, D.THICKNESS.K, D.ENUM.K, D.QUANTITY.K, D.METE.K], t = [D.DATE.K, D.DATES.K], n = [D.RATE.K, D.AMOUNT.K, D.QUANTITY.K, D.METE.K, D.LENGTH.K, D.WEIGHT.K, D.THICKNESS.K], a = [D.AMOUNT.K, D.LENGTH.K, D.WEIGHT.K, D.THICKNESS.K], u = [D.AMOUNT.K, D.QUANTITY.K, D.METE.K, D.LENGTH.K, D.WEIGHT.K], f = [D.AMOUNT.K, D.QUANTITY.K, D.METE.K, D.LENGTH.K, D.WEIGHT.K], c = {};
  c[D.AMOUNT.K] = fo.ENUM, c[D.LENGTH.K] = co.ENUM, c[D.WEIGHT.K] = mo.ENUM, c[D.THICKNESS.K] = po.ENUM;
  const h = { id: void 0, name: "", key: void 0, type: void 0, isDefault: false, config: {} }, g = { unit: Fn.MM.V, fontUnit: "pt", unitPrecision: ho.ZERO.V, orient: Nt.LONGITUDINAL.V, width: 210, height: 297, paddingLR: 10, paddingTB: 10 }, b = H(), E = H(), x = H(), P = H(), N = H([50, 60, 70, 75, 80, 90, 100]), S = H(100), ce = H([0, 10, 20, 30, 50, 100]), me = H(10), L = H(de.BASE.V), pe = H(""), ne = H(""), Oe = H(""), ve = H(""), Ae = H(""), nt = H(""), le = H([]), Ne = H(true), be = H(false), We = H("欢迎来到中南绿建钢结构生产执行管理系统"), ke = H(0), Ue = H({}), ze = H({}), ye = H([]), U = H({}), re = H({}), X = H({}), he = H({}), q = H({}), B = H({}), xe = H({}), cl = H({ remark: [{ max: 500, message: "不能超过 500 个字符", trigger: "blur" }], type: [{ required: true, message: "请选择表格", trigger: "change" }], name: [{ required: true, message: "请填写表格名称", trigger: "blur" }, { min: 1, max: 32, message: "长度在 1 到 32 个字符", trigger: "blur" }] });
  let d = tn({ ...g }), Je = tn({ columns: [], columnRows: [], lastColumns: [] });
  const { CRUD: kt, crud: Le, form: Y } = go(h, b), Jt = H(kt.STATUS.PREPARED), Vn = _e(() => Nt.TRANSVERSE.V === d.orient ? d.height : d.width), xn = _e(() => Nt.TRANSVERSE.V === d.orient ? d.width : d.height), Zt = _e(() => Vn.value - d.paddingLR * 2), Qt = _e(() => xn.value - d.paddingTB * 2), ml = _e(() => {
    const p = d, i = S.value / 100;
    return p.unit ? { transform: `scale(${i})`, "margin-right": `-${p.width * (1 - i) + p.unit}`, "margin-bottom": `-${p.height * (1 - i) + p.unit}`, width: Vn.value + p.unit, height: xn.value + p.unit, padding: `${p.paddingTB || 0}${p.unit} ${p.paddingLR || 0}${p.unit}` } : { transform: `scale(${i})`, "margin-right": `-${210 * (1 - i)}mm`, "margin-bottom": `-${297 * (1 - i)}mm`, width: "210mm", height: "297mm", padding: "10mm 10mm" };
  }), pl = _e(() => {
    const p = {};
    if (re.value) {
      const i = d, y = re.value;
      M(y.height) && (p.height = `${y.height}${i.unit}`), M(y.width) && (p.width = `${y.width}${i.unit}`), M(y.top) && (p.top = `${y.top}${i.unit}`), M(y.left) && (p.left = `${y.left}${i.unit}`);
    }
    return p;
  }), hl = _e(() => {
    const p = {};
    if (X.value) {
      const i = d, y = X.value;
      M(y.height) && (p.height = `${y.height}${i.unit}`), M(y.width) && (p.width = `${y.width}${i.unit}`), M(y.top) && (p.top = `${y.top}${i.unit}`), M(y.left) && (p.left = `${y.left}${i.unit}`);
    }
    return p;
  }), gl = _e(() => {
    const p = {};
    if (he.value) {
      const i = d, y = he.value;
      M(y.size) && (p["font-size"] = `${y.size}${i.fontUnit}`), M(y.bold) && (p["font-weight"] = y.bold), M(y.height) && (p.height = `${y.height}${i.unit}`), M(y.align) && (p["justify-content"] = ie.flexAlign(y.align)), M(y.verticleAlign) && (p["align-items"] = ie.verticleAlign(y.verticleAlign));
    }
    return p;
  }), vl = _e(() => {
    const p = {};
    if (xe.value) {
      const i = d, y = xe.value;
      M(i.paddingLR) && (p["padding-left"] = `${i.paddingLR || 0}${i.unit}`, p["padding-right"] = `${i.paddingLR || 0}${d.unit}`), M(y.bottom) && (p.bottom = `${y.bottom}${i.unit}`), M(y.size) && (p["font-size"] = `${y.size}${i.fontUnit}`), M(y.bold) && (p["font-weight"] = y.bold), M(y.align) && (p["text-align"] = ie.textAlign(y.align));
    }
    return p;
  }), bl = _e(() => {
    const p = {}, i = d, y = q.value;
    return M(y.width) && (p.width = `${y.width}${i.unit}`), M(y.height) && (p.height = `${y.height}${i.unit}`), M(y.size) && (p["font-size"] = `${y.size}${i.fontUnit}`), M(y.align) && (p["justify-content"] = ie.flexAlign(y.align)), M(y.verticleAlign) && (p["align-items"] = ie.verticleAlign(y.verticleAlign)), p;
  }), yl = _e(() => {
    var i, y, se;
    const p = {};
    if (U.value) {
      const z = d;
      let $e = z.height - z.paddingTB * 2;
      (i = z.title) != null && i.show && ($e -= z.title.height), (y = z.header) != null && y.show && ($e -= z.header.height), (se = z.footer) != null && se.show && ($e -= z.footer.height), p["max-height"] = `${$e}${z.unit}`;
    }
    return p;
  }), wl = _e(() => {
    const p = {};
    if (B.value) {
      const i = d, y = B.value;
      M(y.width) && (p.width = `${y.width}${i.unit}`), M(y.height) && (p.height = `${y.height}${i.unit}`), M(y.size) && (p["font-size"] = `${y.size}${i.fontUnit}`), M(y.align) && (p["justify-content"] = ie.flexAlign(y.align)), M(y.verticleAlign) && (p["align-items"] = ie.verticleAlign(y.verticleAlign));
    }
    return p;
  }), Ut = _e(() => {
    let p = [];
    if (M(ye.value)) {
      const i = me.value > ye.value.length ? ye.value.length : me.value;
      p = ye.value.slice(0, i);
    }
    return p;
  }), Mt = _e(() => vo(5, Fn.MM.V, d.unit));
  vt(() => Y.type, (p) => {
    Jt.value === Le.status.add && M(p) && (Ne.value = false);
  }), vt(() => he.value.title, () => {
    Dn();
  }, { deep: true }), vt(() => q.value, () => {
    Cn();
  }, { deep: true }), vt(() => B.value, () => {
    Un();
  }, { deep: true }), vt([() => U.value, () => me.value], () => {
    kn();
  }, { deep: true }), Dl(), kt.HOOK.beforeToCU = () => {
    _l();
  }, kt.HOOK.afterToEdit = () => {
    Sn(JSON.parse(Y.config));
  }, kt.HOOK.beforeSubmit = () => {
    Y.config = JSON.parse(JSON.stringify(d)), Y.config.type = Y.type, Y.config = JSON.stringify(d);
  };
  function _l() {
    L.value = de.BASE.V, pe.value = "", ne.value = "", Oe.value = "", ve.value = "", Ae.value = "", nt.value = "", Ne.value = true, be.value = false, Je = tn({ columns: [], columnRows: [], lastColumns: [] }), d = Object.assign(d, g);
  }
  async function El() {
    let p = { header: Ue.value, table: JSON.parse(JSON.stringify(Ut.value)), footer: ze.value, qrCode: We.value };
    Y.type && $t[Y.type] && (p = await $t[Y.type](p)), p.config = JSON.parse(JSON.stringify(d)), _o(p);
  }
  function Vl() {
    U.value.fields && U.value.fields.forEach((p) => {
      p.width = void 0, p.minWidth = void 0;
    });
  }
  function Tn(p = "width") {
    let i = Zt.value;
    const y = U.value.fields.filter((z) => z.show);
    let se = y.length + 1;
    if (U.value.index.show && (i -= U.value.index.width, se += 1), i -= bt(se, d.unit, d.unitPrecision) + 2, M(y)) {
      const z = +(i / y.length).toFloor(d.unitPrecision);
      y.forEach(($e) => {
        $e[p] = z;
      });
    }
  }
  function xl(p) {
    d.logo.left = bt(p.pageX - 70, d.unit, d.unitPrecision), d.logo.top = bt(p.pageY - 100, d.unit, d.unitPrecision);
  }
  function Tl(p) {
    d.qrCode.left = bt(p.pageX - 70, d.unit, d.unitPrecision), d.qrCode.top = bt(p.pageY - 100, d.unit, d.unitPrecision);
  }
  function Sl(p) {
    d.logo.url = p.path, Re(X.value.width) && (d.logo.width = 20), Re(X.value.height) && (d.logo.height = 20), Re(X.value.top) && (d.logo.top = 10), Re(X.value.left) && (d.logo.left = 10);
  }
  async function Dl() {
    be.value = true;
    let p = [];
    try {
      const { content: i = [] } = await bo() || {};
      p = i;
    } catch (i) {
      console.log("error 获取公司logos", i);
    } finally {
      le.value = p, be.value = false;
    }
  }
  function Cl() {
    U.value.fields.push({ key: nn().format("x"), show: true, title: "自定义", type: D.OTHER.K, source: Ze.CUSTOMIZE.V, align: ft.CENTER.V, width: 15 });
  }
  function kl(p) {
    U.value.fields.splice(p, 1);
  }
  function Ul() {
    q.value.fields.push({ key: nn().format("x"), show: true, title: "自定义", source: Ze.CUSTOMIZE.V, width: 60 });
  }
  function Ml(p) {
    q.value.fields.splice(p, 1);
  }
  function Ol() {
    B.value.fields.push({ key: nn().format("x"), show: true, title: "自定义", source: Ze.CUSTOMIZE.V, width: 60 });
  }
  function Al(p) {
    B.value.fields.splice(p, 1);
  }
  function Nl() {
    var i, y, se;
    const p = [{ el: E.value, table: (i = U.value) == null ? void 0 : i.fields }, { el: x.value, table: (y = q.value) == null ? void 0 : y.fields }, { el: P.value, table: (se = B.value) == null ? void 0 : se.fields }];
    for (const z of p) if (z.el.$refs.tableRef) {
      const $e = z.el.$refs.tableRef.$el.querySelectorAll(".el-table__body-wrapper table tbody")[0];
      k.create($e, { onEnd: ({ newIndex: $, oldIndex: Te }) => {
        const Z = z.table.splice(Te, 1)[0];
        z.table.splice($, 0, Z);
      } });
    }
  }
  function Sn(p) {
    const i = M(p) ? ie.correctJSON(JSON.parse(JSON.stringify(p))) : ie.correctJSON(Object.assign({}, g));
    Object.assign(d, { qrCode: {}, ...i }), Pl(), Hl(), ke.value++;
  }
  function $l(p) {
    Y.name = p == null ? void 0 : p.L;
  }
  function Pl() {
    var p, i, y;
    if (U.value = d.table, re.value = d.qrCode, X.value = d.logo, he.value = d.title, q.value = d.header, B.value = d.footer, xe.value = d.page, M((p = d.table) == null ? void 0 : p.fields)) {
      const se = Hn(JSON.parse(JSON.stringify(d.table.fields))), z = Rn(se);
      ye.value = ln.getList({ fields: z, extraFields: d.table.extraFields, number: 100 });
    }
    M((i = d.header) == null ? void 0 : i.fields) && (Ue.value = ln.getOne({ fields: d.header.fields, extraFields: d.header.extraFields })), M((y = d.footer) == null ? void 0 : y.fields) && (ze.value = ln.getOne({ fields: d.footer.fields, extraFields: d.footer.extraFields }));
  }
  async function Il() {
    let p = { header: Ue.value, table: Ut.value, footer: ze.value, qrCode: We.value };
    Y.type && $t[Y.type] && (p = await $t[Y.type](p)), p.printMode = Eo.PREVIEW.V, p.config = JSON.parse(JSON.stringify(d)), Vo(p);
  }
  function Fl() {
    Re(U.value) || (Je.columns = xo(JSON.parse(JSON.stringify(U.value.fields))), Je.columnRows = Hn(Je.columns), Je.lastColumns = Rn(Je.columnRows));
  }
  function Hl() {
    Re(d) || (Dn(), Cn(), kn(), Un(), Mn(), Xl(() => {
      Nl();
    }));
  }
  function Dn() {
    pe.value = ie.getTitleHtml(he.value);
  }
  function Cn() {
    ie.setHeaderFieldStyle(d), ne.value = ie.getHeaderHtml(Ue.value, q.value);
  }
  function kn() {
    Fl(), ie.setTableStyle(d, Je), Oe.value = ie.getTableHtml(Ut.value, U.value, Je);
  }
  function Un() {
    ie.setFooterFieldStyle(d), ve.value = ie.getFooterHtml(ze.value, d);
  }
  function Mn() {
    Ae.value = ie.getPageHtml(xe.value);
  }
  return (p, i) => {
    const y = ql, se = Jl, z = at("common-button"), $e = Zl, $ = Ql, Te = eo, Z = to, Rl = at("common-radio"), I = at("common-input-number"), gt = at("common-select"), we = Jn, zl = no, On = lo, Ll = oo, Bl = io, oe = ao, en = at("common-table"), Yl = ro, Kl = at("common-dialog"), Ot = so;
    return v(), K(Kl, { "append-to-body": "", "close-on-click-modal": false, "before-close": s(Le).cancelCU, "show-close": false, visible: s(Le).status.cu > 0, title: s(Le).status.title, "custom-class": "print-template-detail", fullscreen: "" }, { title: m(() => [O("div", ui, [O("span", null, qn(s(Le).status.title), 1), O("div", null, [r(s(Uo), { value: L.value, "onUpdate:value": i[0] || (i[0] = (ue) => L.value = ue), class: "config-item-box", options: s(de).ENUM, type: "enum", color: "#fff", "active-color": "#606266", "button-color": "#e8f4ff" }, null, 8, ["value", "options"]), r(se, { modelValue: S.value, "onUpdate:modelValue": i[1] || (i[1] = (ue) => S.value = ue), placeholder: "显示比例", size: "default", class: "zoom-select" }, { default: m(() => [(v(true), V(te, null, mt(N.value, (ue) => (v(), K(y, { key: ue, label: `${ue}%`, value: ue }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"]), r(se, { modelValue: me.value, "onUpdate:modelValue": i[2] || (i[2] = (ue) => me.value = ue), placeholder: "数据填充", size: "default", class: "zoom-select" }, { default: m(() => [(v(true), V(te, null, mt(ce.value, (ue) => (v(), K(y, { key: ue, label: `${ue}条`, value: ue }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"]), r(z, { size: "default", type: "danger", disabled: !s(Y).type, onClick: Il }, { default: m(() => i[54] || (i[54] = [j("打印预览")])), _: 1, __: [54] }, 8, ["disabled"]), r(z, { size: "default", type: "success", disabled: !s(Y).type, onClick: El }, { default: m(() => i[55] || (i[55] = [j("导出 Excel")])), _: 1, __: [55] }, 8, ["disabled"]), r(z, { size: "default", type: "warning", disabled: !s(Y).type, loading: s(Le).status.cu === 2, onClick: s(Le).submitCU }, { default: m(() => i[56] || (i[56] = [j("保存")])), _: 1, __: [56] }, 8, ["disabled", "loading", "onClick"]), r(z, { size: "default", onClick: s(Le).cancelCU }, { default: m(() => i[57] || (i[57] = [j("退出")])), _: 1, __: [57] }, 8, ["onClick"])])])]), default: m(() => {
      var ue, An, Nn, $n, Pn, In;
      return [O("div", di, [Pe((v(), V("div", fi, [O("div", { class: "content", style: Xe(ml.value), onClick: i[10] || (i[10] = Ie((o) => L.value = s(de).BASE.V, ["self"])) }, [s(Y).type ? (v(), V(te, { key: 0 }, [s(M)(s(d)) ? (v(), V(te, { key: 0 }, [(ue = X.value) != null && ue.show && X.value.url ? (v(), K($e, { key: 0, class: "logo-info", style: Xe(hl.value), src: X.value.url, fit: "scale-down", draggable: "true", onDragend: xl, onClick: i[3] || (i[3] = Ie((o) => L.value = s(de).BASE.V, ["stop"])) }, null, 8, ["style", "src"])) : T("", true), (An = re.value) != null && An.show ? (v(), V("div", { key: 1, class: "qr-info", style: Xe(pl.value), draggable: "true", onDragend: Tl, onClick: i[4] || (i[4] = Ie((o) => L.value = s(de).BASE.V, ["stop"])) }, [r(jl, { value: We.value, margin: 1 }, null, 8, ["value"])], 36)) : T("", true), (Nn = he.value) != null && Nn.show ? (v(), V("div", { key: 2, class: "title-info", style: Xe(gl.value), onClick: i[5] || (i[5] = Ie((o) => L.value = s(de).TITLE.V, ["stop"])), innerHTML: pe.value }, null, 12, ci)) : T("", true), ($n = q.value) != null && $n.show ? (v(), V("div", { key: 3, class: "header-info", style: Xe(bl.value), onClick: i[6] || (i[6] = Ie((o) => L.value = s(de).HEADER.V, ["stop"])), innerHTML: ne.value }, null, 12, mi)) : T("", true), U.value && s(M)(Ut.value) ? (v(), V("div", { key: 4, ref: "tableInfo", class: "table-info", style: Xe(yl.value), onClick: i[7] || (i[7] = Ie((o) => L.value = s(de).TABLE.V, ["stop"])) }, [O("div", { innerHTML: U.value.style }, null, 8, pi), O("div", { innerHTML: Oe.value }, null, 8, hi)], 4)) : T("", true), (Pn = B.value) != null && Pn.show ? (v(), V("div", { key: 5, class: "footer-info", style: Xe(wl.value), onClick: i[8] || (i[8] = Ie((o) => L.value = s(de).FOOTER.V, ["stop"])), innerHTML: ve.value }, null, 12, gi)) : T("", true), (In = xe.value) != null && In.show ? (v(), V("div", { key: 6, class: "page-info", style: Xe(vl.value), onClick: i[9] || (i[9] = Ie((o) => L.value = s(de).BASE.V, ["stop"])), innerHTML: Ae.value }, null, 12, vi)) : T("", true)], 64)) : (v(), V("span", bi, "* 请选择表格模板"))], 64)) : (v(), V("span", yi, "* 请选择表格"))], 4)])), [[Ot, !Ne.value]]), Pe((v(), V("div", wi, [O("div", null, [r(Yl, { ref_key: "formRef", ref: b, model: s(Y), rules: cl.value, size: "default", "label-width": "115px" }, { default: m(() => [Pe(O("div", null, [O("div", _i, [r($, { label: "表格类型", prop: "type" }, { default: m(() => [r(s(To), { modelValue: s(Y).type, "onUpdate:modelValue": i[11] || (i[11] = (o) => s(Y).type = o), disabled: s(Le).status.edit === Jt.value, filterable: "", "show-all-levels": "", style: { width: "300px" }, onChange: $l }, null, 8, ["modelValue", "disabled"])]), _: 1 }), s(Le).status.add === Jt.value ? (v(), K($, { key: 0, label: "创建来源" }, { default: m(() => [r(s(yo), { "table-type": s(Y).type, default: "", filterable: "", style: { width: "300px" }, onChange: Sn, onOnload: i[12] || (i[12] = (o) => Ne.value = true) }, null, 8, ["table-type"])]), _: 1 })) : T("", true), r($, { label: "表格名称", prop: "name" }, { default: m(() => [r(Te, { modelValue: s(Y).name, "onUpdate:modelValue": i[13] || (i[13] = (o) => s(Y).name = o), modelModifiers: { trim: true }, type: "text", placeholder: "请填写表格名称", style: { width: "300px" } }, null, 8, ["modelValue"])]), _: 1 }), r($, { label: "备注", prop: "remark" }, { default: m(() => [r(Te, { modelValue: s(Y).remark, "onUpdate:modelValue": i[14] || (i[14] = (o) => s(Y).remark = o), type: "textarea", style: { width: "300px" }, autosize: { minRows: 2, maxRows: 4 }, placeholder: "请输入备注" }, null, 8, ["modelValue"])]), _: 1 }), r($, { label: "默认模板", prop: "isDefault" }, { default: m(() => [r(Z, { modelValue: s(Y).isDefault, "onUpdate:modelValue": i[15] || (i[15] = (o) => s(Y).isDefault = o) }, null, 8, ["modelValue"])]), _: 1 })]), O("div", Ei, [r($, { label: "打印方向" }, { default: m(() => [r(Rl, { modelValue: s(d).orient, "onUpdate:modelValue": i[16] || (i[16] = (o) => s(d).orient = o), options: s(Nt).ENUM, type: "enum", style: { width: "350px" } }, null, 8, ["modelValue", "options"])]), _: 1 })]), r(Gl, { name: "el-fade-in-linear" }, { default: m(() => [s(d).unit && s(Y).type ? (v(), V("div", Vi, [O("div", xi, [r($, { label: `高度(${s(d).unit})` }, { default: m(() => [r(I, { modelValue: s(d).height, "onUpdate:modelValue": i[17] || (i[17] = (o) => s(d).height = o), precision: s(d).unitPrecision, min: 100, "controls-position": "right", type: "text", placeholder: "表格高度", style: { width: "150px" } }, null, 8, ["modelValue", "precision"])]), _: 1 }, 8, ["label"]), r($, { label: `宽度(${s(d).unit})` }, { default: m(() => [r(I, { modelValue: s(d).width, "onUpdate:modelValue": i[18] || (i[18] = (o) => s(d).width = o), precision: s(d).unitPrecision, min: 0, "controls-position": "right", type: "text", placeholder: "表格宽度", style: { width: "150px" } }, null, 8, ["modelValue", "precision"])]), _: 1 }, 8, ["label"])]), O("div", Ti, [r($, { label: `上下边距(${s(d).unit})` }, { default: m(() => [r(I, { modelValue: s(d).paddingTB, "onUpdate:modelValue": i[19] || (i[19] = (o) => s(d).paddingTB = o), precision: s(d).unitPrecision, min: 0, "controls-position": "right", type: "text", placeholder: "表格上下边距", style: { width: "150px" } }, null, 8, ["modelValue", "precision"])]), _: 1 }, 8, ["label"]), r($, { label: `左右边距(${s(d).unit})` }, { default: m(() => [r(I, { modelValue: s(d).paddingLR, "onUpdate:modelValue": i[20] || (i[20] = (o) => s(d).paddingLR = o), precision: s(d).unitPrecision, min: 0, "controls-position": "right", type: "text", placeholder: "表格左右边距", style: { width: "150px" } }, null, 8, ["modelValue", "precision"])]), _: 1 }, 8, ["label"])]), xe.value ? (v(), V("div", Si, [r(s(Se), { name: "页码" }), r(s(Be), { data: xe.value, "show-verticle-align": false, class: "text-setting" }, null, 8, ["data"]), i[58] || (i[58] = O("br", null, null, -1)), r($, { label: `字体大小(${s(d).fontUnit})` }, { default: m(() => [r(I, { modelValue: xe.value.size, "onUpdate:modelValue": i[21] || (i[21] = (o) => xe.value.size = o), "controls-position": "right", min: 8, max: 30, type: "text", placeholder: "字体大小", style: { width: "150px" } }, null, 8, ["modelValue"])]), _: 1 }, 8, ["label"]), r($, { label: `距离底部(${s(d).unit})` }, { default: m(() => [r(I, { modelValue: xe.value.bottom, "onUpdate:modelValue": i[22] || (i[22] = (o) => xe.value.bottom = o), "controls-position": "right", min: 0, max: s(d).height, type: "text", placeholder: "距离底部", style: { width: "150px" } }, null, 8, ["modelValue", "max"])]), _: 1 }, 8, ["label"]), r($, { label: "格式" }, { default: m(() => [r(gt, { modelValue: xe.value.format, "onUpdate:modelValue": i[23] || (i[23] = (o) => xe.value.format = o), options: s(wo).ENUM, type: "enum", placeholder: "请选择展示格式", style: { width: "150px" }, onChange: Mn }, null, 8, ["modelValue", "options"])]), _: 1 })])) : T("", true), X.value ? Pe((v(), V("div", Di, [r(we, { effect: "light", content: `图标（logo）设置：

                      1. 图标可通知管理员在公司配置中配置。

                      2. ★：公司默认图标。`, placement: "right" }, { default: m(() => [r(s(Se), { name: "图标" })]), _: 1 }), r(s(Be), { data: X.value, "show-all-page": "", "show-bold": false, "show-align": false, "show-verticle-align": false, class: "text-setting" }, null, 8, ["data"]), i[60] || (i[60] = O("br", null, null, -1)), r($, { label: `长度(${s(d).unit})` }, { default: m(() => [r(I, { modelValue: X.value.height, "onUpdate:modelValue": i[24] || (i[24] = (o) => X.value.height = o), precision: s(d).unitPrecision, "controls-position": "right", type: "text", min: 0, max: s(d).height, placeholder: "长度", style: { width: "150px" } }, null, 8, ["modelValue", "precision", "max"])]), _: 1 }, 8, ["label"]), r($, { label: `宽度(${s(d).unit})` }, { default: m(() => [r(I, { modelValue: X.value.width, "onUpdate:modelValue": i[25] || (i[25] = (o) => X.value.width = o), precision: s(d).unitPrecision, "controls-position": "right", type: "text", min: 0, max: s(d).width, placeholder: "宽度", style: { width: "150px" } }, null, 8, ["modelValue", "precision", "max"])]), _: 1 }, 8, ["label"]), i[61] || (i[61] = O("br", null, null, -1)), r($, { label: `距离顶部(${s(d).unit})` }, { default: m(() => [r(I, { modelValue: X.value.top, "onUpdate:modelValue": i[26] || (i[26] = (o) => X.value.top = o), precision: s(d).unitPrecision, "controls-position": "right", type: "text", min: 0, max: s(d).height, placeholder: "距离顶部", style: { width: "150px" } }, null, 8, ["modelValue", "precision", "max"])]), _: 1 }, 8, ["label"]), r($, { label: `距离左侧(${s(d).unit})` }, { default: m(() => [r(I, { modelValue: X.value.left, "onUpdate:modelValue": i[27] || (i[27] = (o) => X.value.left = o), precision: s(d).unitPrecision, "controls-position": "right", type: "text", min: 0, max: s(d).width, placeholder: "距离左侧", style: { width: "150px" } }, null, 8, ["modelValue", "precision", "max"])]), _: 1 }, 8, ["label"]), O("div", Ci, [s(M)(le.value) ? (v(true), V(te, { key: 0 }, mt(le.value, (o) => (v(), V("div", { key: o.id, class: "logo-drawer", onClick: (_) => Sl(o) }, [r($e, { lazy: "", class: "logo-img", src: o.path, fit: "scale-down" }, null, 8, ["src"]), Pe(O("span", Ui, [r(On, null, { default: m(() => [r(zl)]), _: 1 })], 512), [[lt, X.value.url == o.path]]), Pe(O("span", Mi, [r(On, null, { default: m(() => [r(Ll)]), _: 1 })], 512), [[lt, o.isDefault]])], 8, ki))), 128)) : (v(), K(Bl, { key: 1, type: "danger" }, { default: m(() => i[59] || (i[59] = [j("logo未上传")])), _: 1, __: [59] }))])])), [[Ot, be.value]]) : T("", true), re.value ? Pe((v(), V("div", Oi, [r(we, { effect: "light", content: `二维码设置：

                      1. 图标可通知管理员在公司配置中配置。
`, placement: "right" }, { default: m(() => [r(s(Se), { name: "二维码" })]), _: 1 }), r(s(Be), { data: re.value, "show-all-page": "", "show-bold": false, "show-align": false, "show-verticle-align": false, class: "text-setting" }, null, 8, ["data"]), i[62] || (i[62] = O("br", null, null, -1)), r($, { label: `距离顶部(${s(d).unit})` }, { default: m(() => [r(I, { modelValue: re.value.top, "onUpdate:modelValue": i[28] || (i[28] = (o) => re.value.top = o), precision: s(d).unitPrecision, "controls-position": "right", type: "text", min: 0, max: s(d).height, placeholder: "距离顶部", style: { width: "150px" } }, null, 8, ["modelValue", "precision", "max"])]), _: 1 }, 8, ["label"]), r($, { label: `距离左侧(${s(d).unit})` }, { default: m(() => [r(I, { modelValue: re.value.left, "onUpdate:modelValue": i[29] || (i[29] = (o) => re.value.left = o), precision: s(d).unitPrecision, "controls-position": "right", type: "text", min: 0, max: s(d).width, placeholder: "距离左侧", style: { width: "150px" } }, null, 8, ["modelValue", "precision", "max"])]), _: 1 }, 8, ["label"])])), [[Ot, be.value]]) : T("", true)])) : T("", true)]), _: 1 })], 512), [[lt, L.value == s(de).BASE.V]]), (v(), V("div", { key: ke.value }, [Pe(O("div", null, [s(M)(he.value) ? (v(), V("div", Ai, [r(s(Se), { name: "标题" }), r(s(Be), { data: he.value, "show-all-page": "", class: "text-setting" }, null, 8, ["data"]), i[63] || (i[63] = O("br", null, null, -1)), r($, { label: "表格名称" }, { default: m(() => [r(Te, { modelValue: he.value.title, "onUpdate:modelValue": i[30] || (i[30] = (o) => he.value.title = o), modelModifiers: { trim: true }, type: "text", placeholder: "请填写表格名称", style: { width: "150px" } }, null, 8, ["modelValue"])]), _: 1 }), r($, { label: `字体大小(${s(d).fontUnit})` }, { default: m(() => [r(I, { modelValue: he.value.size, "onUpdate:modelValue": i[31] || (i[31] = (o) => he.value.size = o), "controls-position": "right", min: 8, max: 40, type: "text", placeholder: "字体大小", style: { width: "150px" } }, null, 8, ["modelValue"])]), _: 1 }, 8, ["label"]), r($, { label: `高度(${s(d).unit})` }, { default: m(() => [r(I, { modelValue: he.value.height, "onUpdate:modelValue": i[32] || (i[32] = (o) => he.value.height = o), precision: s(d).unitPrecision, "controls-position": "right", type: "text", min: 0, max: Qt.value, placeholder: "高度", style: { width: "150px" } }, null, 8, ["modelValue", "precision", "max"])]), _: 1 }, 8, ["label"])])) : T("", true)], 512), [[lt, L.value == s(de).TITLE.V]]), Pe(O("div", null, [s(M)(U.value) ? (v(), V(te, { key: 0 }, [O("div", Ni, [r(s(Se), { name: "列名" }), r(s(Be), { data: U.value.th, "show-display": false, "show-align": false, "show-verticle-align": false, class: "text-setting" }, null, 8, ["data"]), r($, { label: `字体大小(${s(d).fontUnit})` }, { default: m(() => [r(I, { modelValue: U.value.th.size, "onUpdate:modelValue": i[33] || (i[33] = (o) => U.value.th.size = o), "controls-position": "right", min: 8, max: 20, type: "text", placeholder: "字体大小", style: { width: "150px" } }, null, 8, ["modelValue"])]), _: 1 }, 8, ["label"]), r($, { label: `行高(${s(d).fontUnit})` }, { default: m(() => [r(I, { modelValue: U.value.th.lineHeight, "onUpdate:modelValue": i[34] || (i[34] = (o) => U.value.th.lineHeight = o), "controls-position": "right", precision: 1, min: 1, max: 20, type: "text", placeholder: "行高", style: { width: "150px" } }, null, 8, ["modelValue"])]), _: 1 }, 8, ["label"]), r($, { label: `上下边距(${s(d).unit})` }, { default: m(() => [r(I, { modelValue: U.value.th.paddingTB, "onUpdate:modelValue": i[35] || (i[35] = (o) => U.value.th.paddingTB = o), precision: s(d).unitPrecision, min: 0, "controls-position": "right", type: "text", placeholder: "表头上下边距", style: { width: "150px" } }, null, 8, ["modelValue", "precision"])]), _: 1 }, 8, ["label"])]), O("div", $i, [r(we, { effect: "light", content: `表元（表格的具体数据）设置：

                1. 空值显示：当数据为空时展示的数据，不填则不显示`, placement: "right" }, { default: m(() => [r(s(Se), { name: "表元" })]), _: 1 }), r(s(Be), { data: U.value.td, "show-display": false, "show-align": false, "show-verticle-align": false, class: "text-setting" }, null, 8, ["data"]), r($, { label: `字体大小(${s(d).fontUnit})` }, { default: m(() => [r(I, { modelValue: U.value.td.size, "onUpdate:modelValue": i[36] || (i[36] = (o) => U.value.td.size = o), "controls-position": "right", min: 8, max: 20, type: "text", placeholder: "字体大小", style: { width: "150px" } }, null, 8, ["modelValue"])]), _: 1 }, 8, ["label"]), r($, { label: `行高(${s(d).fontUnit})` }, { default: m(() => [r(I, { modelValue: U.value.td.lineHeight, "onUpdate:modelValue": i[37] || (i[37] = (o) => U.value.td.lineHeight = o), "controls-position": "right", precision: 1, min: 1, max: 20, type: "text", placeholder: "行高", style: { width: "150px" } }, null, 8, ["modelValue"])]), _: 1 }, 8, ["label"]), r($, { label: `上下边距(${s(d).unit})` }, { default: m(() => [r(I, { modelValue: U.value.td.paddingTB, "onUpdate:modelValue": i[38] || (i[38] = (o) => U.value.td.paddingTB = o), precision: s(d).unitPrecision, min: 0, "controls-position": "right", type: "text", placeholder: "表元上下边距", style: { width: "150px" } }, null, 8, ["modelValue", "precision"])]), _: 1 }, 8, ["label"]), r($, { label: "空值显示" }, { default: m(() => [r(Te, { modelValue: U.value.emptyVal, "onUpdate:modelValue": i[39] || (i[39] = (o) => U.value.emptyVal = o), type: "text", placeholder: "空值显示", style: { width: "130px" } }, null, 8, ["modelValue"])]), _: 1 }), r($, { label: "合计", "label-width": "65px" }, { default: m(() => [r(Z, { modelValue: U.value.summary.show, "onUpdate:modelValue": i[40] || (i[40] = (o) => U.value.summary.show = o) }, null, 8, ["modelValue"])]), _: 1 })]), O("div", Pi, [r(we, { effect: "light", content: `序号设置：

                1. 宽度：①当最小宽度和宽度都未设置时，列宽按照内容自动分配；

                　　　　 ②当最小宽度和宽度都设置时，以宽度为准

                2. 最小宽度：列的最小宽度，若表格有多余的宽度，会按比例分配到最小宽度上
`, placement: "right" }, { default: m(() => [r(s(Se), { name: "序号" })]), _: 1 }), r(s(Be), { data: U.value.index, "show-bold": false, "show-verticle-align": false, class: "text-setting" }, null, 8, ["data"]), r($, { label: `宽度(${s(d).unit})` }, { default: m(() => [r(I, { modelValue: U.value.index.width, "onUpdate:modelValue": i[41] || (i[41] = (o) => U.value.index.width = o), precision: s(d).unitPrecision, min: 0, "controls-position": "right", type: "text" }, null, 8, ["modelValue", "precision"])]), _: 1 }, 8, ["label"]), r($, { label: `最小宽度(${s(d).unit})` }, { default: m(() => [r(I, { modelValue: U.value.index.minWidth, "onUpdate:modelValue": i[42] || (i[42] = (o) => U.value.index.minWidth = o), precision: s(d).unitPrecision, min: 0, "controls-position": "right", type: "text" }, null, 8, ["modelValue", "precision"])]), _: 1 }, 8, ["label"])]), O("div", Ii, [O("div", Fi, [O("div", Hi, [r(z, { type: "primary", size: "default", onClick: Cl }, { default: m(() => i[64] || (i[64] = [j("添加自定义列")])), _: 1, __: [64] })]), O("div", Ri, [r(z, { type: "warning", size: "default", onClick: i[43] || (i[43] = (o) => Tn()) }, { default: m(() => i[65] || (i[65] = [j("平均分配宽度")])), _: 1, __: [65] }), r(z, { type: "warning", size: "default", onClick: i[44] || (i[44] = (o) => Tn("minWidth")) }, { default: m(() => i[66] || (i[66] = [j("平均分配最小宽度")])), _: 1, __: [66] }), r(z, { type: "danger", size: "default", onClick: Vl }, { default: m(() => i[67] || (i[67] = [j("清除所有宽度")])), _: 1, __: [67] })])]), r(we, { effect: "light", content: `表格设置：

                1. 表格内容除显示为“/”的单元格皆可编辑（包括标题及日期格式）。

                2. 宽度：①当最小宽度和宽度都未设置时，列宽按照内容自动分配；

                　　　　 ②当最小宽度和宽度都设置时，以宽度为准；

                　　　　 ③设置宽度时，若希望内容在一行显示，可设置一点冗余宽度，避免因不同设备的差别导致打印换行。

                3. 最小宽度：列的最小宽度，若表格有多余的宽度，会按比例分配到最小宽度上。

                4. 日期格式：YYYY（2020, 4 位数字的年份）

                　　　　　　 YY（20, 2 位数字的年份） 

                　　　　　　 Q（1~4, 年份的季度。将月份设置为季度的第一个月）

                　　　　　　 M MM（1~12, 月份的数字, MM<补0>：01）

                　　　　　　 MMM MMMM（1月~12月, 月份名称, MMM: 1月, MMMM: 一月）

                　　　　　　 D DD（1~31, 月的某天, DD<补0>：01）

                　　　　　　 H HH（0~23, 24 小时制）

                　　　　　　 h hh（1~12, 小时, 使用 a A 的 12 小时制）

                　　　　　　 m mm（0~59, 分钟）

                　　　　　　 s ss（0~59, 秒钟）

                　　　　　　 a A（上午或下午）

                5. 分位符：1000 => 1,000 、 6666.60 => 6,666.6，使用分位符会删除小数末尾多余的0。

                6. 单位：重量（g, kg, t）、长度（mm, m）、宽度（mm, mm）、厚度（mm）、金额（元，万元）可修改单位。

                7. 小数精度：0~5, 数量类型的值都可修改小数精度。

                8. 全称/简称：部分字段会提供“全称简称”功能，但有些全称和简称是相同的。

                9. 打印列排序：可通过拖拽表格“行”上下移动来改变排序。

                10. 合计项：非数字类型不可合计，无意义字段不可合计（例：厚度）。

                11. 虚线处的表格不会打印。
`, placement: "right" }, { default: m(() => [r(s(Se), { name: "列" })]), _: 1 }), r(en, { ref_key: "tableFieldsTableRef", ref: E, "return-source-data": "", data: U.value.fields, "row-key": "key", border: "", style: { width: "100%" } }, { default: m(() => [r(oe, { label: "标题", "min-width": "100" }, { default: m((o) => [r(we, { content: o.row.title, placement: "top-start" }, { default: m(() => [r(Te, { modelValue: o.row.title, "onUpdate:modelValue": (_) => o.row.title = _, type: "text", placeholder: "标题", class: "input-border-none input-padding-right-0", style: { width: "calc(100% - 23px)" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["content"])]), _: 1 }), r(oe, { label: "显示", "min-width": "60", align: "center" }, { default: m((o) => [o.row.source === s(Ze).CUSTOMIZE.V ? (v(), K(z, { key: 0, type: "danger", icon: "el-icon-delete", size: "default", style: { padding: "7px 10px" }, onClick: Ie((_) => kl(o.$index), ["stop"]) }, null, 8, ["onClick"])) : (v(), K(Z, { key: 1, modelValue: o.row.show, "onUpdate:modelValue": (_) => o.row.show = _ }, null, 8, ["modelValue", "onUpdate:modelValue"]))]), _: 1 }), r(oe, { label: "对齐方式", "min-width": "105" }, { default: m((o) => [r(gt, { modelValue: o.row.align, "onUpdate:modelValue": (_) => o.row.align = _, options: s(ft).ENUM, type: "enum", placeholder: "对齐方式", class: "input-border-none" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 1 }), r(oe, { label: `宽度(${s(d).unit})`, "min-width": "100", align: "center" }, { default: m((o) => [o.row.children ? T("", true) : (v(), K(I, { key: 0, modelValue: o.row.width, "onUpdate:modelValue": (_) => o.row.width = _, precision: s(d).unitPrecision, min: 0, "controls-position": "right", type: "text", class: "input-border-none input-number-center" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"]))]), _: 1 }, 8, ["label"]), r(oe, { label: `最小宽度(${s(d).unit})`, "min-width": "120", align: "center" }, { default: m((o) => [o.row.children ? T("", true) : (v(), K(I, { key: 0, modelValue: o.row.minWidth, "onUpdate:modelValue": (_) => o.row.minWidth = _, precision: s(d).unitPrecision, min: 0, "controls-position": "right", type: "text", class: "input-border-none input-number-center" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"]))]), _: 1 }, 8, ["label"]), r(oe, { label: "格式", "min-width": "240", align: "center" }, { default: m((o) => [o.row.children ? T("", true) : (v(), V(te, { key: 0 }, [e.includes(o.row.type) ? s(M)(o.row.format) ? (v(), V(te, { key: 1 }, [o.row.type == s(D).PROJECT.K ? (v(), V(te, { key: 0 }, [r(Z, { modelValue: o.row.format.showProjectFullName, "onUpdate:modelValue": (_) => o.row.format.showProjectFullName = _, style: { "margin-right": "10px" } }, { default: m(() => i[68] || (i[68] = [j(" 项目全称 ")])), _: 2, __: [68] }, 1032, ["modelValue", "onUpdate:modelValue"]), r(Z, { modelValue: o.row.format.showSerialNumber, "onUpdate:modelValue": (_) => o.row.format.showSerialNumber = _ }, { default: m(() => i[69] || (i[69] = [j(" 合同编号 ")])), _: 2, __: [69] }, 1032, ["modelValue", "onUpdate:modelValue"])], 64)) : T("", true), t.includes(o.row.type) ? (v(), K(Te, { key: 1, modelValue: o.row.format, "onUpdate:modelValue": (_) => o.row.format = _, type: "text", placeholder: "填写日期格式", class: "input-border-none input-center", style: { width: "270px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : T("", true), n.includes(o.row.type) ? (v(), V("span", Li, [u.includes(o.row.type) ? (v(), V("span", Bi, [r(Z, { modelValue: o.row.format.toThousand, "onUpdate:modelValue": (_) => o.row.format.toThousand = _ }, { default: m(() => i[70] || (i[70] = [j(" 分位符 ")])), _: 2, __: [70] }, 1032, ["modelValue", "onUpdate:modelValue"])])) : T("", true), a.includes(o.row.type) ? (v(), V("span", Yi, [r(gt, { modelValue: o.row.format.unit, "onUpdate:modelValue": (_) => o.row.format.unit = _, options: c[o.row.type], type: "enum", placeholder: "单位", style: { width: "60px" }, class: "input-border-none input-center" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])])) : T("", true), O("span", null, [r(we, { content: "小数精度", placement: "top-start" }, { default: m(() => [r(I, { modelValue: o.row.format.precision, "onUpdate:modelValue": (_) => o.row.format.precision = _, precision: 0, min: 0, max: 5, "controls-position": "right", type: "text", style: { width: "60px" }, class: "input-border-none input-number-center" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1024)]), o.row.type == s(D).METE.K ? (v(), V("span", Ki, [r(Z, { modelValue: o.row.format.showUnit, "onUpdate:modelValue": (_) => o.row.format.showUnit = _ }, { default: m(() => i[71] || (i[71] = [j("显示单位")])), _: 2, __: [71] }, 1032, ["modelValue", "onUpdate:modelValue"])])) : T("", true)])) : T("", true), o.row.type == s(D).ENUM.K ? (v(), K(se, { key: 3, modelValue: o.row.format.key, "onUpdate:modelValue": (_) => o.row.format.key = _, placeholder: "名称", class: "input-border-none input-center" }, { default: m(() => [r(y, { label: "全称", value: "L" }), r(y, { label: "简称", value: "SL" })]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])) : T("", true)], 64)) : T("", true) : (v(), V("span", zi, "/"))], 64))]), _: 1 }), r(oe, { label: "合计项", "min-width": "70", align: "center" }, { default: m((o) => [o.row.children ? T("", true) : (v(), K(Z, { key: 0, modelValue: o.row.sum, "onUpdate:modelValue": (_) => o.row.sum = _, disabled: !f.includes(o.row.type) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"]))]), _: 1 })]), _: 1 }, 8, ["data"])])], 64)) : T("", true)], 512), [[lt, L.value == s(de).TABLE.V]]), Pe(O("div", null, [s(M)(q.value) ? (v(), V(te, { key: 0 }, [O("div", Wi, [r(s(Se), { name: "表头" }), r(s(Be), { data: q.value, "show-all-page": "", class: "text-setting" }, null, 8, ["data"]), i[72] || (i[72] = O("br", null, null, -1)), r($, { label: `字体大小(${s(d).fontUnit})` }, { default: m(() => [r(I, { modelValue: q.value.size, "onUpdate:modelValue": i[45] || (i[45] = (o) => q.value.size = o), "controls-position": "right", min: 8, max: 20, type: "text", placeholder: "字体大小", style: { width: "150px" } }, null, 8, ["modelValue"])]), _: 1 }, 8, ["label"]), r($, { label: `高度(${s(d).unit})` }, { default: m(() => [r(I, { modelValue: q.value.height, "onUpdate:modelValue": i[46] || (i[46] = (o) => q.value.height = o), precision: s(d).unitPrecision, "controls-position": "right", type: "text", min: 0, max: Qt.value, placeholder: "高度", style: { width: "150px" } }, null, 8, ["modelValue", "precision", "max"])]), _: 1 }, 8, ["label"]), r($, { label: `宽度(${s(d).unit})` }, { default: m(() => [r(I, { value: q.value.width, "onUpdate:value": i[47] || (i[47] = (o) => q.value.width = o), precision: s(d).unitPrecision, "controls-position": "right", type: "text", min: 0, max: Zt.value, placeholder: "高度", style: { width: "150px" } }, null, 8, ["value", "precision", "max"])]), _: 1 }, 8, ["label"])]), O("div", Xi, [r(z, { type: "primary", class: "fr", size: "default", style: { "margin-bottom": "15px" }, onClick: Ul }, { default: m(() => i[73] || (i[73] = [j("添加自定义字段")])), _: 1, __: [73] }), r(we, { effect: "light", content: `表格设置：

                1. 表格内容除显示为“/”的单元格皆可编辑（包括标题及日期格式）。

                2. 内容超出宽度，超出部分显示为“...”

                3. 宽度：① 当最大宽度和宽度都未设置时，宽度为内容长度；

                　　　　 ② 当宽度和最大宽度都设置时，取其中小的一方。

                4. 最大宽度：若当前内容比最大宽度小，则宽度相应减少

                5. 日期格式：YYYY（2020, 4 位数字的年份）

                　　　　　　 YY（20, 2 位数字的年份） 

                　　　　　　 Q（1~4, 年份的季度。将月份设置为季度的第一个月）

                　　　　　　 M MM（1~12, 月份的数字, MM<补0>：01）

                　　　　　　 MMM MMMM（1月~12月, 月份名称, MMM: 1月, MMMM: 一月）

                　　　　　　 D DD（1~31, 月的某天, DD<补0>：01）

                　　　　　　 H HH（0~23, 24 小时制）

                　　　　　　 h hh（1~12, 小时, 使用 a A 的 12 小时制）

                　　　　　　 m mm（0~59, 分钟）

                　　　　　　 s ss（0~59, 秒钟）

                　　　　　　 a A（上午或下午）

                6. 分位符：1000 => 1,000 、 6666.60 => 6,666.6，使用分位符会删除小数末尾多余的0。

                7. 单位：重量（g, kg, t）、长度（mm, m）、宽度（mm, mm）、厚度（mm）、金额（元，万元）可修改单位。

                8. 小数精度：0~5, 数量类型的值都可修改小数精度。

                9. 全称/简称：部分字段会提供“全称简称”功能，但有些全称和简称是相同的。

                10. 打印列排序：可通过拖拽表格“行”上下移动来改变排序。
`, placement: "right" }, { default: m(() => [r(s(Se), { name: "字段" })]), _: 1 }), r(en, { ref_key: "headerFieldsTableRef", ref: x, "return-source-data": "", data: q.value.fields, "row-key": "key", border: "", style: { width: "100%" } }, { default: m(() => [r(oe, { label: "标题", "min-width": "100" }, { default: m((o) => [r(we, { content: o.row.title, placement: "top-start" }, { default: m(() => [r(Te, { modelValue: o.row.title, "onUpdate:modelValue": (_) => o.row.title = _, type: "text", placeholder: "填写标题", class: "input-border-none input-padding-right-0" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["content"])]), _: 1 }), r(oe, { label: "显示", "min-width": "60", align: "center" }, { default: m((o) => [o.row.source === s(Ze).CUSTOMIZE.V ? (v(), K(z, { key: 0, type: "danger", icon: "el-icon-delete", size: "default", style: { padding: "7px 10px" }, onClick: Ie((_) => Ml(o.$index), ["stop"]) }, null, 8, ["onClick"])) : (v(), K(Z, { key: 1, modelValue: o.row.show, "onUpdate:modelValue": (_) => o.row.show = _ }, null, 8, ["modelValue", "onUpdate:modelValue"]))]), _: 1 }), r(oe, { label: `宽度(${s(d).unit})`, "min-width": "100", align: "center" }, { default: m((o) => [r(I, { modelValue: o.row.width, "onUpdate:modelValue": (_) => o.row.width = _, precision: s(d).unitPrecision, min: Mt.value, max: q.value.width, "controls-position": "right", type: "text", class: "input-border-none input-number-center" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "min", "max"])]), _: 1 }, 8, ["label"]), r(oe, { label: `最大宽度(${s(d).unit})`, "min-width": "120", align: "center" }, { default: m((o) => [o.row.source === s(Ze).CUSTOMIZE.V ? (v(), V("span", ji, "/")) : (v(), K(I, { key: 1, modelValue: o.row.maxWidth, "onUpdate:modelValue": (_) => o.row.maxWidth = _, precision: s(d).unitPrecision, min: Mt.value, max: q.value.width, "controls-position": "right", type: "text", class: "input-border-none input-number-center" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "min", "max"]))]), _: 1 }, 8, ["label"]), r(oe, { label: "格式", "min-width": "240", align: "center" }, { default: m((o) => [e.includes(o.row.type) ? s(M)(o.row.format) ? (v(), V(te, { key: 1 }, [o.row.type == s(D).PROJECT.K ? (v(), V(te, { key: 0 }, [r(Z, { modelValue: o.row.format.showProjectFullName, "onUpdate:modelValue": (_) => o.row.format.showProjectFullName = _, style: { "margin-right": "10px" } }, { default: m(() => i[74] || (i[74] = [j(" 项目全称 ")])), _: 2, __: [74] }, 1032, ["modelValue", "onUpdate:modelValue"]), r(Z, { modelValue: o.row.format.showSerialNumber, "onUpdate:modelValue": (_) => o.row.format.showSerialNumber = _ }, { default: m(() => i[75] || (i[75] = [j(" 合同编号 ")])), _: 2, __: [75] }, 1032, ["modelValue", "onUpdate:modelValue"])], 64)) : T("", true), t.includes(o.row.type) ? (v(), K(Te, { key: 1, modelValue: o.row.format, "onUpdate:modelValue": (_) => o.row.format = _, type: "text", placeholder: "填写日期格式", class: "input-border-none input-center", style: { width: "270px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : T("", true), n.includes(o.row.type) ? (v(), V("span", qi, [u.includes(o.row.type) ? (v(), V("span", Ji, [r(Z, { modelValue: o.row.format.toThousand, "onUpdate:modelValue": (_) => o.row.format.toThousand = _ }, { default: m(() => i[76] || (i[76] = [j(" 分位符 ")])), _: 2, __: [76] }, 1032, ["modelValue", "onUpdate:modelValue"])])) : T("", true), a.includes(o.row.type) ? (v(), V("span", Zi, [r(gt, { modelValue: o.row.format.unit, "onUpdate:modelValue": (_) => o.row.format.unit = _, options: c[o.row.type], type: "enum", placeholder: "单位", style: { width: "60px" }, class: "input-border-none input-center" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])])) : T("", true), O("span", null, [r(we, { content: "小数精度", placement: "top-start" }, { default: m(() => [r(I, { modelValue: o.row.format.precision, "onUpdate:modelValue": (_) => o.row.format.precision = _, precision: 0, min: 0, max: 5, "controls-position": "right", type: "text", style: { width: "60px" }, class: "input-border-none input-number-center" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1024)])])) : T("", true), o.row.type == s(D).METE.K ? (v(), K(Z, { key: 3, modelValue: o.row.format.showUnit, "onUpdate:modelValue": (_) => o.row.format.showUnit = _ }, { default: m(() => i[77] || (i[77] = [j("显示单位")])), _: 2, __: [77] }, 1032, ["modelValue", "onUpdate:modelValue"])) : T("", true), o.row.type == s(D).ENUM.K ? (v(), K(se, { key: 4, modelValue: o.row.format.key, "onUpdate:modelValue": (_) => o.row.format.key = _, placeholder: "名称", class: "input-border-none input-center" }, { default: m(() => [r(y, { label: "全称", value: "L" }), r(y, { label: "简称", value: "SL" })]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])) : T("", true)], 64)) : T("", true) : (v(), V("span", Gi, "/"))]), _: 1 })]), _: 1 }, 8, ["data"])])], 64)) : T("", true)], 512), [[lt, L.value == s(de).HEADER.V]]), Pe(O("div", null, [s(M)(B.value) ? (v(), V(te, { key: 0 }, [O("div", Qi, [r(we, { effect: "light", content: `表尾设置：

                    尽量将高度调节到自己内容所需的高度，以避免额外高度从而产生的空白页` }, { default: m(() => [r(s(Se), { name: "表尾" })]), _: 1 }), r(s(Be), { data: B.value, "show-all-page": "", class: "text-setting" }, null, 8, ["data"]), i[78] || (i[78] = O("br", null, null, -1)), r($, { label: `字体大小(${s(d).fontUnit})` }, { default: m(() => [r(I, { modelValue: B.value.size, "onUpdate:modelValue": i[48] || (i[48] = (o) => B.value.size = o), "controls-position": "right", min: 8, max: 20, type: "text", placeholder: "字体大小", style: { width: "150px" } }, null, 8, ["modelValue"])]), _: 1 }, 8, ["label"]), r($, { label: `高度(${s(d).unit})` }, { default: m(() => [r(I, { modelValue: B.value.height, "onUpdate:modelValue": i[49] || (i[49] = (o) => B.value.height = o), precision: s(d).unitPrecision, "controls-position": "right", type: "text", min: 0, max: Qt.value, placeholder: "高度", style: { width: "150px" } }, null, 8, ["modelValue", "precision", "max"])]), _: 1 }, 8, ["label"]), r($, { label: `宽度(${s(d).unit})` }, { default: m(() => [r(I, { modelValue: B.value.width, "onUpdate:modelValue": i[50] || (i[50] = (o) => B.value.width = o), precision: s(d).unitPrecision, "controls-position": "right", type: "text", min: 0, max: Zt.value, placeholder: "高度", style: { width: "150px" } }, null, 8, ["modelValue", "precision", "max"])]), _: 1 }, 8, ["label"])]), O("div", ea, [r(s(Se), { name: "提示" }), r(s(Be), { data: B.value.tip, "show-verticle-align": false, class: "text-setting" }, null, 8, ["data"]), r($, { label: `字体大小(${s(d).fontUnit})` }, { default: m(() => [r(I, { modelValue: B.value.tip.size, "onUpdate:modelValue": i[51] || (i[51] = (o) => B.value.tip.size = o), "controls-position": "right", min: 8, max: 20, type: "text", placeholder: "字体大小", style: { width: "150px" } }, null, 8, ["modelValue"])]), _: 1 }, 8, ["label"]), r($, { label: "在字段上方显示" }, { default: m(() => [r(Z, { modelValue: B.value.tip.above, "onUpdate:modelValue": i[52] || (i[52] = (o) => B.value.tip.above = o) }, null, 8, ["modelValue"])]), _: 1 }), i[79] || (i[79] = O("br", null, null, -1)), O("div", ta, [r(Te, { modelValue: B.value.tip.text, "onUpdate:modelValue": i[53] || (i[53] = (o) => B.value.tip.text = o), type: "textarea", autosize: { minRows: 2, maxRows: 4 }, placeholder: "请输入内容" }, null, 8, ["modelValue"])])]), O("div", na, [r(z, { type: "primary", class: "fr", size: "default", style: { "margin-bottom": "15px" }, onClick: Ol }, { default: m(() => i[80] || (i[80] = [j("添加自定义字段")])), _: 1, __: [80] }), r(we, { effect: "light", content: `表格设置：

                1. 表格内容除显示为“/”的单元格皆可编辑（包括标题及日期格式）。

                2. 内容超出宽度，超出部分显示为“...”

                3. 宽度：① 当最大宽度和宽度都未设置时，宽度为内容长度；

                　　　　 ② 当宽度和最大宽度都设置时，取其中小的一方。

                4. 最大宽度：若当前内容比最大宽度小，则宽度相应减少

                5. 日期格式：YYYY（2020, 4 位数字的年份）

                　　　　　　 YY（20, 2 位数字的年份） 

                　　　　　　 Q（1~4, 年份的季度。将月份设置为季度的第一个月）

                　　　　　　 M MM（1~12, 月份的数字, MM<补0>：01）

                　　　　　　 MMM MMMM（1月~12月, 月份名称, MMM: 1月, MMMM: 一月）

                　　　　　　 D DD（1~31, 月的某天, DD<补0>：01）

                　　　　　　 H HH（0~23, 24 小时制）

                　　　　　　 h hh（1~12, 小时, 使用 a A 的 12 小时制）

                　　　　　　 m mm（0~59, 分钟）

                　　　　　　 s ss（0~59, 秒钟）

                　　　　　　 a A（上午或下午）

                6. 分位符：1000 => 1,000 、 6666.60 => 6,666.6，使用分位符会删除小数末尾多余的0。

                7. 单位：重量（g, kg, t）、长度（mm, m）、宽度（mm, mm）、厚度（mm）、金额（元，万元）可修改单位。

                8. 小数精度：0~5, 数量类型的值都可修改小数精度。

                9. 全称/简称：部分字段会提供“全称简称”功能，但有些全称和简称是相同的。

                10. 打印列排序：可通过拖拽表格“行”上下移动来改变排序。
`, placement: "right" }, { default: m(() => [r(s(Se), { name: "字段" })]), _: 1 }), r(en, { ref_key: "footerFieldsTableRef", ref: P, "return-source-data": "", data: B.value.fields, "row-key": "key", border: "", style: { width: "100%" } }, { default: m(() => [r(oe, { label: "标题", "min-width": "100" }, { default: m((o) => [r(we, { content: o.row.title, placement: "top-start" }, { default: m(() => [r(Te, { modelValue: o.row.title, "onUpdate:modelValue": (_) => o.row.title = _, type: "text", placeholder: "填写标题", class: "input-border-none input-padding-right-0" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1032, ["content"])]), _: 1 }), r(oe, { label: "显示", "min-width": "60", align: "center" }, { default: m((o) => [o.row.source === s(Ze).CUSTOMIZE.V ? (v(), K(z, { key: 0, type: "danger", icon: "el-icon-delete", size: "default", style: { padding: "7px 10px" }, onClick: Ie((_) => Al(o.$index), ["stop"]) }, null, 8, ["onClick"])) : (v(), K(Z, { key: 1, modelValue: o.row.show, "onUpdate:modelValue": (_) => o.row.show = _ }, null, 8, ["modelValue", "onUpdate:modelValue"]))]), _: 1 }), r(oe, { label: `宽度(${s(d).unit})`, "min-width": "100", align: "center" }, { default: m((o) => [r(I, { modelValue: o.row.width, "onUpdate:modelValue": (_) => o.row.width = _, precision: s(d).unitPrecision, min: Mt.value, max: B.value.width, "controls-position": "right", type: "text", class: "input-border-none input-number-center" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "min", "max"])]), _: 1 }, 8, ["label"]), r(oe, { label: `最大宽度(${s(d).unit})`, "min-width": "120", align: "center" }, { default: m((o) => [o.row.source === s(Ze).CUSTOMIZE.V ? (v(), V("span", la, "/")) : (v(), K(I, { key: 1, modelValue: o.row.maxWidth, "onUpdate:modelValue": (_) => o.row.maxWidth = _, precision: s(d).unitPrecision, min: Mt.value, max: B.value.width, "controls-position": "right", type: "text", class: "input-border-none input-number-center" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "min", "max"]))]), _: 1 }, 8, ["label"]), r(oe, { label: "格式", "min-width": "240", align: "center" }, { default: m((o) => [e.includes(o.row.type) ? s(M)(o.row.format) ? (v(), V(te, { key: 1 }, [o.row.type == s(D).PROJECT.K ? (v(), V(te, { key: 0 }, [r(Z, { modelValue: o.row.format.showProjectFullName, "onUpdate:modelValue": (_) => o.row.format.showProjectFullName = _, style: { "margin-right": "10px" } }, { default: m(() => i[81] || (i[81] = [j(" 项目全称 ")])), _: 2, __: [81] }, 1032, ["modelValue", "onUpdate:modelValue"]), r(Z, { modelValue: o.row.format.showSerialNumber, "onUpdate:modelValue": (_) => o.row.format.showSerialNumber = _ }, { default: m(() => i[82] || (i[82] = [j(" 合同编号 ")])), _: 2, __: [82] }, 1032, ["modelValue", "onUpdate:modelValue"])], 64)) : T("", true), t.includes(o.row.type) ? (v(), K(Te, { key: 1, modelValue: o.row.format, "onUpdate:modelValue": (_) => o.row.format = _, type: "text", placeholder: "填写日期格式", class: "input-border-none input-center", style: { width: "270px" } }, null, 8, ["modelValue", "onUpdate:modelValue"])) : T("", true), n.includes(o.row.type) ? (v(), V("span", ia, [u.includes(o.row.type) ? (v(), V("span", aa, [r(Z, { modelValue: o.row.format.toThousand, "onUpdate:modelValue": (_) => o.row.format.toThousand = _ }, { default: m(() => i[83] || (i[83] = [j(" 分位符 ")])), _: 2, __: [83] }, 1032, ["modelValue", "onUpdate:modelValue"])])) : T("", true), a.includes(o.row.type) ? (v(), V("span", ra, [r(gt, { modelValue: o.row.format.unit, "onUpdate:modelValue": (_) => o.row.format.unit = _, options: c[o.row.type], type: "enum", placeholder: "单位", style: { width: "60px" }, class: "input-border-none input-center" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])])) : T("", true), O("span", null, [r(we, { content: "小数精度", placement: "top-start" }, { default: m(() => [r(I, { modelValue: o.row.format.precision, "onUpdate:modelValue": (_) => o.row.format.precision = _, precision: 0, min: 0, max: 5, "controls-position": "right", type: "text", style: { width: "60px" }, class: "input-border-none input-number-center" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1024)])])) : T("", true), o.row.type == s(D).METE.K ? (v(), V("span", sa, [r(Z, { modelValue: o.row.format.showUnit, "onUpdate:modelValue": (_) => o.row.format.showUnit = _ }, { default: m(() => i[84] || (i[84] = [j("显示单位")])), _: 2, __: [84] }, 1032, ["modelValue", "onUpdate:modelValue"])])) : T("", true), o.row.type == s(D).ENUM.K ? (v(), K(se, { key: 4, modelValue: o.row.format.key, "onUpdate:modelValue": (_) => o.row.format.key = _, placeholder: "名称", class: "input-border-none input-center" }, { default: m(() => [r(y, { label: "全称", value: "L" }), r(y, { label: "简称", value: "SL" })]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])) : T("", true)], 64)) : T("", true) : (v(), V("span", oa, "/"))]), _: 1 })]), _: 1 }, 8, ["data"])])], 64)) : T("", true)], 512), [[lt, L.value == s(de).FOOTER.V]])]))]), _: 1 }, 8, ["model", "rules"])])])), [[Ot, !Ne.value]])])];
    }), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, ha = bn(ua, [["__scopeId", "data-v-31ddf183"]]);
export {
  ha as default
};
