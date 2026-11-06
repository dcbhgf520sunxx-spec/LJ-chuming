import { defineComponent as hn } from "vue";
import { computed as Dt } from "vue";
import { toRefs as pn } from "vue";
import { unref as Y } from "vue";
import { ref as ht } from "vue";
import { reactive as gn } from "vue";
import { h as mn } from "vue";
import { getCurrentInstance as yt } from "vue";
import { watch as Lt } from "vue";
import { onUnmounted as vn } from "vue";
import { onMounted as bn } from "vue";
import { nextTick as Ut } from "vue";
import { isRef as Fe } from "vue";
import { resolveComponent as tt } from "vue";
import { openBlock as le } from "vue";
import { createBlock as fe } from "vue";
import { withCtx as K } from "vue";
import { withModifiers as Re } from "vue";
import { createTextVNode as Be } from "vue";
import { createCommentVNode as De } from "vue";
import { createElementVNode as yn } from "vue";
import { createVNode as he } from "vue";
import { normalizeClass as wn } from "vue";
import { createElementBlock as _n } from "vue";
import { toDisplayString as Sn } from "vue";
import { ElMessage as Ct } from "element-plus";
import { ElTableColumn as En } from "element-plus";
import { ElInput as Dn } from "element-plus";
import { ElColorPicker as Cn } from "element-plus";
import { b as Tn } from "../../../../modules/push-message-49ab2649.js";
import { _ as xn, u as On, o as An, V as nt, aw as kn } from "../../../../shared/runtime.js";
import { u as Nn } from "../../../../modules/use-table-operate-4f84437f.js";
var In = Object.defineProperty, $e = Object.getOwnPropertySymbols, Wt = Object.prototype.hasOwnProperty, zt = Object.prototype.propertyIsEnumerable, Tt = (e, n, t) => n in e ? In(e, n, { enumerable: true, configurable: true, writable: true, value: t }) : e[n] = t, we = (e, n) => {
  for (var t in n || (n = {})) Wt.call(n, t) && Tt(e, t, n[t]);
  if ($e) for (var t of $e(n)) zt.call(n, t) && Tt(e, t, n[t]);
  return e;
}, $t = (e, n) => {
  var t = {};
  for (var o in e) Wt.call(e, o) && n.indexOf(o) < 0 && (t[o] = e[o]);
  if (e != null && $e) for (var o of $e(e)) n.indexOf(o) < 0 && zt.call(e, o) && (t[o] = e[o]);
  return t;
};
const qt = "[vue-draggable-plus]: ";
function Mn(e) {
  console.warn(qt + e);
}
function Pn(e) {
  console.error(qt + e);
}
function xt(e, n, t) {
  return t >= 0 && t < e.length && e.splice(t, 0, e.splice(n, 1)[0]), e;
}
function Rn(e) {
  return e.replace(/-(\w)/g, (n, t) => t ? t.toUpperCase() : "");
}
function Bn(e) {
  return Object.keys(e).reduce((n, t) => (typeof e[t] < "u" && (n[Rn(t)] = e[t]), n), {});
}
function Ot(e, n) {
  return Array.isArray(e) && e.splice(n, 1), e;
}
function At(e, n, t) {
  return Array.isArray(e) && e.splice(n, 0, t), e;
}
function Yn(e) {
  return typeof e > "u";
}
function Vn(e) {
  return typeof e == "string";
}
function kt(e, n, t) {
  const o = e.children[t];
  e.insertBefore(n, o);
}
function ot(e) {
  e.parentNode && e.parentNode.removeChild(e);
}
function Xn(e, n = document) {
  var t;
  let o = null;
  return typeof (n == null ? void 0 : n.querySelector) == "function" ? o = (t = n == null ? void 0 : n.querySelector) == null ? void 0 : t.call(n, e) : o = document.querySelector(e), o || Mn(`Element not found: ${e}`), o;
}
function Hn(e, n, t = null) {
  return function(...o) {
    return e.apply(t, o), n.apply(t, o);
  };
}
function Fn(e, n) {
  const t = we({}, e);
  return Object.keys(n).forEach((o) => {
    t[o] ? t[o] = Hn(e[o], n[o]) : t[o] = n[o];
  }), t;
}
function jn(e) {
  return e instanceof HTMLElement;
}
function Nt(e, n) {
  Object.keys(e).forEach((t) => {
    n(t, e[t]);
  });
}
function Ln(e) {
  return e.charCodeAt(0) === 111 && e.charCodeAt(1) === 110 && (e.charCodeAt(2) > 122 || e.charCodeAt(2) < 97);
}
const Un = Object.assign;
/**!
* Sortable 1.15.2
* @author	RubaXa   <trash@rubaxa.org>
* @author	owenm    <owen23355@gmail.com>
* @license MIT
*/
function It(e, n) {
  var t = Object.keys(e);
  if (Object.getOwnPropertySymbols) {
    var o = Object.getOwnPropertySymbols(e);
    n && (o = o.filter(function(r) {
      return Object.getOwnPropertyDescriptor(e, r).enumerable;
    })), t.push.apply(t, o);
  }
  return t;
}
function oe(e) {
  for (var n = 1; n < arguments.length; n++) {
    var t = arguments[n] != null ? arguments[n] : {};
    n % 2 ? It(Object(t), true).forEach(function(o) {
      Wn(e, o, t[o]);
    }) : Object.getOwnPropertyDescriptors ? Object.defineProperties(e, Object.getOwnPropertyDescriptors(t)) : It(Object(t)).forEach(function(o) {
      Object.defineProperty(e, o, Object.getOwnPropertyDescriptor(t, o));
    });
  }
  return e;
}
function je(e) {
  "@babel/helpers - typeof";
  return typeof Symbol == "function" && typeof Symbol.iterator == "symbol" ? je = function(n) {
    return typeof n;
  } : je = function(n) {
    return n && typeof Symbol == "function" && n.constructor === Symbol && n !== Symbol.prototype ? "symbol" : typeof n;
  }, je(e);
}
function Wn(e, n, t) {
  return n in e ? Object.defineProperty(e, n, { value: t, enumerable: true, configurable: true, writable: true }) : e[n] = t, e;
}
function ie() {
  return ie = Object.assign || function(e) {
    for (var n = 1; n < arguments.length; n++) {
      var t = arguments[n];
      for (var o in t) Object.prototype.hasOwnProperty.call(t, o) && (e[o] = t[o]);
    }
    return e;
  }, ie.apply(this, arguments);
}
function zn(e, n) {
  if (e == null) return {};
  var t = {}, o = Object.keys(e), r, i;
  for (i = 0; i < o.length; i++) r = o[i], !(n.indexOf(r) >= 0) && (t[r] = e[r]);
  return t;
}
function $n(e, n) {
  if (e == null) return {};
  var t = zn(e, n), o, r;
  if (Object.getOwnPropertySymbols) {
    var i = Object.getOwnPropertySymbols(e);
    for (r = 0; r < i.length; r++) o = i[r], !(n.indexOf(o) >= 0) && Object.prototype.propertyIsEnumerable.call(e, o) && (t[o] = e[o]);
  }
  return t;
}
var qn = "1.15.2";
function re(e) {
  if (typeof window < "u" && window.navigator) return !!navigator.userAgent.match(e);
}
var ae = re(/(?:Trident.*rv[ :]?11\.|msie|iemobile|Windows Phone)/i), Me = re(/Edge/i), Mt = re(/firefox/i), Oe = re(/safari/i) && !re(/chrome/i) && !re(/android/i), Gt = re(/iP(ad|od|hone)/i), Zt = re(/chrome/i) && re(/android/i), Jt = { capture: false, passive: false };
function C(e, n, t) {
  e.addEventListener(n, t, !ae && Jt);
}
function S(e, n, t) {
  e.removeEventListener(n, t, !ae && Jt);
}
function qe(e, n) {
  if (n) {
    if (n[0] === ">" && (n = n.substring(1)), e) try {
      if (e.matches) return e.matches(n);
      if (e.msMatchesSelector) return e.msMatchesSelector(n);
      if (e.webkitMatchesSelector) return e.webkitMatchesSelector(n);
    } catch {
      return false;
    }
    return false;
  }
}
function Gn(e) {
  return e.host && e !== document && e.host.nodeType ? e.host : e.parentNode;
}
function ee(e, n, t, o) {
  if (e) {
    t = t || document;
    do {
      if (n != null && (n[0] === ">" ? e.parentNode === t && qe(e, n) : qe(e, n)) || o && e === t) return e;
      if (e === t) break;
    } while (e = Gn(e));
  }
  return null;
}
var Pt = /\s+/g;
function $(e, n, t) {
  if (e && n) if (e.classList) e.classList[t ? "add" : "remove"](n);
  else {
    var o = (" " + e.className + " ").replace(Pt, " ").replace(" " + n + " ", " ");
    e.className = (o + (t ? " " + n : "")).replace(Pt, " ");
  }
}
function g(e, n, t) {
  var o = e && e.style;
  if (o) {
    if (t === void 0) return document.defaultView && document.defaultView.getComputedStyle ? t = document.defaultView.getComputedStyle(e, "") : e.currentStyle && (t = e.currentStyle), n === void 0 ? t : t[n];
    !(n in o) && n.indexOf("webkit") === -1 && (n = "-webkit-" + n), o[n] = t + (typeof t == "string" ? "" : "px");
  }
}
function Se(e, n) {
  var t = "";
  if (typeof e == "string") t = e;
  else do {
    var o = g(e, "transform");
    o && o !== "none" && (t = o + " " + t);
  } while (!n && (e = e.parentNode));
  var r = window.DOMMatrix || window.WebKitCSSMatrix || window.CSSMatrix || window.MSCSSMatrix;
  return r && new r(t);
}
function Kt(e, n, t) {
  if (e) {
    var o = e.getElementsByTagName(n), r = 0, i = o.length;
    if (t) for (; r < i; r++) t(o[r], r);
    return o;
  }
  return [];
}
function ne() {
  var e = document.scrollingElement;
  return e || document.documentElement;
}
function V(e, n, t, o, r) {
  if (!(!e.getBoundingClientRect && e !== window)) {
    var i, a, s, l, u, d, f;
    if (e !== window && e.parentNode && e !== ne() ? (i = e.getBoundingClientRect(), a = i.top, s = i.left, l = i.bottom, u = i.right, d = i.height, f = i.width) : (a = 0, s = 0, l = window.innerHeight, u = window.innerWidth, d = window.innerHeight, f = window.innerWidth), (n || t) && e !== window && (r = r || e.parentNode, !ae)) do
      if (r && r.getBoundingClientRect && (g(r, "transform") !== "none" || t && g(r, "position") !== "static")) {
        var E = r.getBoundingClientRect();
        a -= E.top + parseInt(g(r, "border-top-width")), s -= E.left + parseInt(g(r, "border-left-width")), l = a + i.height, u = s + i.width;
        break;
      }
    while (r = r.parentNode);
    if (o && e !== window) {
      var h = Se(r || e), O = h && h.a, _ = h && h.d;
      h && (a /= _, s /= O, f /= O, d /= _, l = a + d, u = s + f);
    }
    return { top: a, left: s, bottom: l, right: u, width: f, height: d };
  }
}
function Rt(e, n, t) {
  for (var o = ue(e, true), r = V(e)[n]; o; ) {
    var i = V(o)[t], a = void 0;
    if (a = r >= i, !a) return o;
    if (o === ne()) break;
    o = ue(o, false);
  }
  return false;
}
function Ee(e, n, t, o) {
  for (var r = 0, i = 0, a = e.children; i < a.length; ) {
    if (a[i].style.display !== "none" && a[i] !== m.ghost && (o || a[i] !== m.dragged) && ee(a[i], t.draggable, e, false)) {
      if (r === n) return a[i];
      r++;
    }
    i++;
  }
  return null;
}
function wt(e, n) {
  for (var t = e.lastElementChild; t && (t === m.ghost || g(t, "display") === "none" || n && !qe(t, n)); ) t = t.previousElementSibling;
  return t || null;
}
function J(e, n) {
  var t = 0;
  if (!e || !e.parentNode) return -1;
  for (; e = e.previousElementSibling; ) e.nodeName.toUpperCase() !== "TEMPLATE" && e !== m.clone && (!n || qe(e, n)) && t++;
  return t;
}
function Bt(e) {
  var n = 0, t = 0, o = ne();
  if (e) do {
    var r = Se(e), i = r.a, a = r.d;
    n += e.scrollLeft * i, t += e.scrollTop * a;
  } while (e !== o && (e = e.parentNode));
  return [n, t];
}
function Zn(e, n) {
  for (var t in e) if (e.hasOwnProperty(t)) {
    for (var o in n) if (n.hasOwnProperty(o) && n[o] === e[t][o]) return Number(t);
  }
  return -1;
}
function ue(e, n) {
  if (!e || !e.getBoundingClientRect) return ne();
  var t = e, o = false;
  do
    if (t.clientWidth < t.scrollWidth || t.clientHeight < t.scrollHeight) {
      var r = g(t);
      if (t.clientWidth < t.scrollWidth && (r.overflowX == "auto" || r.overflowX == "scroll") || t.clientHeight < t.scrollHeight && (r.overflowY == "auto" || r.overflowY == "scroll")) {
        if (!t.getBoundingClientRect || t === document.body) return ne();
        if (o || n) return t;
        o = true;
      }
    }
  while (t = t.parentNode);
  return ne();
}
function Jn(e, n) {
  if (e && n) for (var t in n) n.hasOwnProperty(t) && (e[t] = n[t]);
  return e;
}
function rt(e, n) {
  return Math.round(e.top) === Math.round(n.top) && Math.round(e.left) === Math.round(n.left) && Math.round(e.height) === Math.round(n.height) && Math.round(e.width) === Math.round(n.width);
}
var Ae;
function Qt(e, n) {
  return function() {
    if (!Ae) {
      var t = arguments, o = this;
      t.length === 1 ? e.call(o, t[0]) : e.apply(o, t), Ae = setTimeout(function() {
        Ae = void 0;
      }, n);
    }
  };
}
function Kn() {
  clearTimeout(Ae), Ae = void 0;
}
function en(e, n, t) {
  e.scrollLeft += n, e.scrollTop += t;
}
function tn(e) {
  var n = window.Polymer, t = window.jQuery || window.Zepto;
  return n && n.dom ? n.dom(e).cloneNode(true) : t ? t(e).clone(true)[0] : e.cloneNode(true);
}
function nn(e, n, t) {
  var o = {};
  return Array.from(e.children).forEach(function(r) {
    var i, a, s, l;
    if (!(!ee(r, n.draggable, e, false) || r.animated || r === t)) {
      var u = V(r);
      o.left = Math.min((i = o.left) !== null && i !== void 0 ? i : 1 / 0, u.left), o.top = Math.min((a = o.top) !== null && a !== void 0 ? a : 1 / 0, u.top), o.right = Math.max((s = o.right) !== null && s !== void 0 ? s : -1 / 0, u.right), o.bottom = Math.max((l = o.bottom) !== null && l !== void 0 ? l : -1 / 0, u.bottom);
    }
  }), o.width = o.right - o.left, o.height = o.bottom - o.top, o.x = o.left, o.y = o.top, o;
}
var G = "Sortable" + (/* @__PURE__ */ new Date()).getTime();
function Qn() {
  var e = [], n;
  return { captureAnimationState: function() {
    if (e = [], !!this.options.animation) {
      var t = [].slice.call(this.el.children);
      t.forEach(function(o) {
        if (!(g(o, "display") === "none" || o === m.ghost)) {
          e.push({ target: o, rect: V(o) });
          var r = oe({}, e[e.length - 1].rect);
          if (o.thisAnimationDuration) {
            var i = Se(o, true);
            i && (r.top -= i.f, r.left -= i.e);
          }
          o.fromRect = r;
        }
      });
    }
  }, addAnimationState: function(t) {
    e.push(t);
  }, removeAnimationState: function(t) {
    e.splice(Zn(e, { target: t }), 1);
  }, animateAll: function(t) {
    var o = this;
    if (!this.options.animation) {
      clearTimeout(n), typeof t == "function" && t();
      return;
    }
    var r = false, i = 0;
    e.forEach(function(a) {
      var s = 0, l = a.target, u = l.fromRect, d = V(l), f = l.prevFromRect, E = l.prevToRect, h = a.rect, O = Se(l, true);
      O && (d.top -= O.f, d.left -= O.e), l.toRect = d, l.thisAnimationDuration && rt(f, d) && !rt(u, d) && (h.top - d.top) / (h.left - d.left) === (u.top - d.top) / (u.left - d.left) && (s = to(h, f, E, o.options)), rt(d, u) || (l.prevFromRect = u, l.prevToRect = d, s || (s = o.options.animation), o.animate(l, h, d, s)), s && (r = true, i = Math.max(i, s), clearTimeout(l.animationResetTimer), l.animationResetTimer = setTimeout(function() {
        l.animationTime = 0, l.prevFromRect = null, l.fromRect = null, l.prevToRect = null, l.thisAnimationDuration = null;
      }, s), l.thisAnimationDuration = s);
    }), clearTimeout(n), r ? n = setTimeout(function() {
      typeof t == "function" && t();
    }, i) : typeof t == "function" && t(), e = [];
  }, animate: function(t, o, r, i) {
    if (i) {
      g(t, "transition", ""), g(t, "transform", "");
      var a = Se(this.el), s = a && a.a, l = a && a.d, u = (o.left - r.left) / (s || 1), d = (o.top - r.top) / (l || 1);
      t.animatingX = !!u, t.animatingY = !!d, g(t, "transform", "translate3d(" + u + "px," + d + "px,0)"), this.forRepaintDummy = eo(t), g(t, "transition", "transform " + i + "ms" + (this.options.easing ? " " + this.options.easing : "")), g(t, "transform", "translate3d(0,0,0)"), typeof t.animated == "number" && clearTimeout(t.animated), t.animated = setTimeout(function() {
        g(t, "transition", ""), g(t, "transform", ""), t.animated = false, t.animatingX = false, t.animatingY = false;
      }, i);
    }
  } };
}
function eo(e) {
  return e.offsetWidth;
}
function to(e, n, t, o) {
  return Math.sqrt(Math.pow(n.top - e.top, 2) + Math.pow(n.left - e.left, 2)) / Math.sqrt(Math.pow(n.top - t.top, 2) + Math.pow(n.left - t.left, 2)) * o.animation;
}
var ve = [], it = { initializeByDefault: true }, Pe = { mount: function(e) {
  for (var n in it) it.hasOwnProperty(n) && !(n in e) && (e[n] = it[n]);
  ve.forEach(function(t) {
    if (t.pluginName === e.pluginName) throw "Sortable: Cannot mount plugin ".concat(e.pluginName, " more than once");
  }), ve.push(e);
}, pluginEvent: function(e, n, t) {
  var o = this;
  this.eventCanceled = false, t.cancel = function() {
    o.eventCanceled = true;
  };
  var r = e + "Global";
  ve.forEach(function(i) {
    n[i.pluginName] && (n[i.pluginName][r] && n[i.pluginName][r](oe({ sortable: n }, t)), n.options[i.pluginName] && n[i.pluginName][e] && n[i.pluginName][e](oe({ sortable: n }, t)));
  });
}, initializePlugins: function(e, n, t, o) {
  ve.forEach(function(a) {
    var s = a.pluginName;
    if (!(!e.options[s] && !a.initializeByDefault)) {
      var l = new a(e, n, e.options);
      l.sortable = e, l.options = e.options, e[s] = l, ie(t, l.defaults);
    }
  });
  for (var r in e.options) if (e.options.hasOwnProperty(r)) {
    var i = this.modifyOption(e, r, e.options[r]);
    typeof i < "u" && (e.options[r] = i);
  }
}, getEventProperties: function(e, n) {
  var t = {};
  return ve.forEach(function(o) {
    typeof o.eventProperties == "function" && ie(t, o.eventProperties.call(n[o.pluginName], e));
  }), t;
}, modifyOption: function(e, n, t) {
  var o;
  return ve.forEach(function(r) {
    e[r.pluginName] && r.optionListeners && typeof r.optionListeners[n] == "function" && (o = r.optionListeners[n].call(e[r.pluginName], t));
  }), o;
} };
function no(e) {
  var n = e.sortable, t = e.rootEl, o = e.name, r = e.targetEl, i = e.cloneEl, a = e.toEl, s = e.fromEl, l = e.oldIndex, u = e.newIndex, d = e.oldDraggableIndex, f = e.newDraggableIndex, E = e.originalEvent, h = e.putSortable, O = e.extraEventProperties;
  if (n = n || t && t[G], !!n) {
    var _, j = n.options, X = "on" + o.charAt(0).toUpperCase() + o.substr(1);
    window.CustomEvent && !ae && !Me ? _ = new CustomEvent(o, { bubbles: true, cancelable: true }) : (_ = document.createEvent("Event"), _.initEvent(o, true, true)), _.to = a || t, _.from = s || t, _.item = r || t, _.clone = i, _.oldIndex = l, _.newIndex = u, _.oldDraggableIndex = d, _.newDraggableIndex = f, _.originalEvent = E, _.pullMode = h ? h.lastPutMode : void 0;
    var z = oe(oe({}, O), Pe.getEventProperties(o, n));
    for (var M in z) _[M] = z[M];
    t && t.dispatchEvent(_), j[X] && j[X].call(n, _);
  }
}
var oo = ["evt"], W = function(e, n) {
  var t = arguments.length > 2 && arguments[2] !== void 0 ? arguments[2] : {}, o = t.evt, r = $n(t, oo);
  Pe.pluginEvent.bind(m)(e, n, oe({ dragEl: c, parentEl: I, ghostEl: v, rootEl: A, nextEl: me, lastDownEl: Le, cloneEl: k, cloneHidden: ce, dragStarted: Ce, putSortable: F, activeSortable: m.active, originalEvent: o, oldIndex: _e, oldDraggableIndex: ke, newIndex: q, newDraggableIndex: se, hideGhostForTarget: ln, unhideGhostForTarget: sn, cloneNowHidden: function() {
    ce = true;
  }, cloneNowShown: function() {
    ce = false;
  }, dispatchSortableEvent: function(i) {
    U({ sortable: n, name: i, originalEvent: o });
  } }, r));
};
function U(e) {
  no(oe({ putSortable: F, cloneEl: k, targetEl: c, rootEl: A, oldIndex: _e, oldDraggableIndex: ke, newIndex: q, newDraggableIndex: se }, e));
}
var c, I, v, A, me, Le, k, ce, _e, q, ke, se, Ye, F, ye = false, Ge = false, Ze = [], pe, Q, at, lt, Yt, Vt, Ce, be, Ne, Ie = false, Ve = false, Ue, L, st = [], pt = false, Je = [], Qe = typeof document < "u", Xe = Gt, Xt = Me || ae ? "cssFloat" : "float", ro = Qe && !Zt && !Gt && "draggable" in document.createElement("div"), on = (function() {
  if (Qe) {
    if (ae) return false;
    var e = document.createElement("x");
    return e.style.cssText = "pointer-events:auto", e.style.pointerEvents === "auto";
  }
})(), rn = function(e, n) {
  var t = g(e), o = parseInt(t.width) - parseInt(t.paddingLeft) - parseInt(t.paddingRight) - parseInt(t.borderLeftWidth) - parseInt(t.borderRightWidth), r = Ee(e, 0, n), i = Ee(e, 1, n), a = r && g(r), s = i && g(i), l = a && parseInt(a.marginLeft) + parseInt(a.marginRight) + V(r).width, u = s && parseInt(s.marginLeft) + parseInt(s.marginRight) + V(i).width;
  if (t.display === "flex") return t.flexDirection === "column" || t.flexDirection === "column-reverse" ? "vertical" : "horizontal";
  if (t.display === "grid") return t.gridTemplateColumns.split(" ").length <= 1 ? "vertical" : "horizontal";
  if (r && a.float && a.float !== "none") {
    var d = a.float === "left" ? "left" : "right";
    return i && (s.clear === "both" || s.clear === d) ? "vertical" : "horizontal";
  }
  return r && (a.display === "block" || a.display === "flex" || a.display === "table" || a.display === "grid" || l >= o && t[Xt] === "none" || i && t[Xt] === "none" && l + u > o) ? "vertical" : "horizontal";
}, io = function(e, n, t) {
  var o = t ? e.left : e.top, r = t ? e.right : e.bottom, i = t ? e.width : e.height, a = t ? n.left : n.top, s = t ? n.right : n.bottom, l = t ? n.width : n.height;
  return o === a || r === s || o + i / 2 === a + l / 2;
}, ao = function(e, n) {
  var t;
  return Ze.some(function(o) {
    var r = o[G].options.emptyInsertThreshold;
    if (!(!r || wt(o))) {
      var i = V(o), a = e >= i.left - r && e <= i.right + r, s = n >= i.top - r && n <= i.bottom + r;
      if (a && s) return t = o;
    }
  }), t;
}, an = function(e) {
  function n(r, i) {
    return function(a, s, l, u) {
      var d = a.options.group.name && s.options.group.name && a.options.group.name === s.options.group.name;
      if (r == null && (i || d)) return true;
      if (r == null || r === false) return false;
      if (i && r === "clone") return r;
      if (typeof r == "function") return n(r(a, s, l, u), i)(a, s, l, u);
      var f = (i ? a : s).options.group.name;
      return r === true || typeof r == "string" && r === f || r.join && r.indexOf(f) > -1;
    };
  }
  var t = {}, o = e.group;
  (!o || je(o) != "object") && (o = { name: o }), t.name = o.name, t.checkPull = n(o.pull, true), t.checkPut = n(o.put), t.revertClone = o.revertClone, e.group = t;
}, ln = function() {
  !on && v && g(v, "display", "none");
}, sn = function() {
  !on && v && g(v, "display", "");
};
Qe && !Zt && document.addEventListener("click", function(e) {
  if (Ge) return e.preventDefault(), e.stopPropagation && e.stopPropagation(), e.stopImmediatePropagation && e.stopImmediatePropagation(), Ge = false, false;
}, true);
var ge = function(e) {
  if (c) {
    e = e.touches ? e.touches[0] : e;
    var n = ao(e.clientX, e.clientY);
    if (n) {
      var t = {};
      for (var o in e) e.hasOwnProperty(o) && (t[o] = e[o]);
      t.target = t.rootEl = n, t.preventDefault = void 0, t.stopPropagation = void 0, n[G]._onDragOver(t);
    }
  }
}, lo = function(e) {
  c && c.parentNode[G]._isOutsideThisEl(e.target);
};
function m(e, n) {
  if (!(e && e.nodeType && e.nodeType === 1)) throw "Sortable: `el` must be an HTMLElement, not ".concat({}.toString.call(e));
  this.el = e, this.options = n = ie({}, n), e[G] = this;
  var t = { group: null, sort: true, disabled: false, store: null, handle: null, draggable: /^[uo]l$/i.test(e.nodeName) ? ">li" : ">*", swapThreshold: 1, invertSwap: false, invertedSwapThreshold: null, removeCloneOnHide: true, direction: function() {
    return rn(e, this.options);
  }, ghostClass: "sortable-ghost", chosenClass: "sortable-chosen", dragClass: "sortable-drag", ignore: "a, img", filter: null, preventOnFilter: true, animation: 0, easing: null, setData: function(i, a) {
    i.setData("Text", a.textContent);
  }, dropBubble: false, dragoverBubble: false, dataIdAttr: "data-id", delay: 0, delayOnTouchOnly: false, touchStartThreshold: (Number.parseInt ? Number : window).parseInt(window.devicePixelRatio, 10) || 1, forceFallback: false, fallbackClass: "sortable-fallback", fallbackOnBody: false, fallbackTolerance: 0, fallbackOffset: { x: 0, y: 0 }, supportPointer: m.supportPointer !== false && "PointerEvent" in window && !Oe, emptyInsertThreshold: 5 };
  Pe.initializePlugins(this, e, t);
  for (var o in t) !(o in n) && (n[o] = t[o]);
  an(n);
  for (var r in this) r.charAt(0) === "_" && typeof this[r] == "function" && (this[r] = this[r].bind(this));
  this.nativeDraggable = n.forceFallback ? false : ro, this.nativeDraggable && (this.options.touchStartThreshold = 1), n.supportPointer ? C(e, "pointerdown", this._onTapStart) : (C(e, "mousedown", this._onTapStart), C(e, "touchstart", this._onTapStart)), this.nativeDraggable && (C(e, "dragover", this), C(e, "dragenter", this)), Ze.push(this.el), n.store && n.store.get && this.sort(n.store.get(this) || []), ie(this, Qn());
}
m.prototype = { constructor: m, _isOutsideThisEl: function(e) {
  !this.el.contains(e) && e !== this.el && (be = null);
}, _getDirection: function(e, n) {
  return typeof this.options.direction == "function" ? this.options.direction.call(this, e, n, c) : this.options.direction;
}, _onTapStart: function(e) {
  if (e.cancelable) {
    var n = this, t = this.el, o = this.options, r = o.preventOnFilter, i = e.type, a = e.touches && e.touches[0] || e.pointerType && e.pointerType === "touch" && e, s = (a || e).target, l = e.target.shadowRoot && (e.path && e.path[0] || e.composedPath && e.composedPath()[0]) || s, u = o.filter;
    if (mo(t), !c && !(/mousedown|pointerdown/.test(i) && e.button !== 0 || o.disabled) && !l.isContentEditable && !(!this.nativeDraggable && Oe && s && s.tagName.toUpperCase() === "SELECT") && (s = ee(s, o.draggable, t, false), !(s && s.animated) && Le !== s)) {
      if (_e = J(s), ke = J(s, o.draggable), typeof u == "function") {
        if (u.call(this, e, s, this)) {
          U({ sortable: n, rootEl: l, name: "filter", targetEl: s, toEl: t, fromEl: t }), W("filter", n, { evt: e }), r && e.cancelable && e.preventDefault();
          return;
        }
      } else if (u && (u = u.split(",").some(function(d) {
        if (d = ee(l, d.trim(), t, false), d) return U({ sortable: n, rootEl: d, name: "filter", targetEl: s, fromEl: t, toEl: t }), W("filter", n, { evt: e }), true;
      }), u)) {
        r && e.cancelable && e.preventDefault();
        return;
      }
      o.handle && !ee(l, o.handle, t, false) || this._prepareDragStart(e, a, s);
    }
  }
}, _prepareDragStart: function(e, n, t) {
  var o = this, r = o.el, i = o.options, a = r.ownerDocument, s;
  if (t && !c && t.parentNode === r) {
    var l = V(t);
    if (A = r, c = t, I = c.parentNode, me = c.nextSibling, Le = t, Ye = i.group, m.dragged = c, pe = { target: c, clientX: (n || e).clientX, clientY: (n || e).clientY }, Yt = pe.clientX - l.left, Vt = pe.clientY - l.top, this._lastX = (n || e).clientX, this._lastY = (n || e).clientY, c.style["will-change"] = "all", s = function() {
      if (W("delayEnded", o, { evt: e }), m.eventCanceled) {
        o._onDrop();
        return;
      }
      o._disableDelayedDragEvents(), !Mt && o.nativeDraggable && (c.draggable = true), o._triggerDragStart(e, n), U({ sortable: o, name: "choose", originalEvent: e }), $(c, i.chosenClass, true);
    }, i.ignore.split(",").forEach(function(u) {
      Kt(c, u.trim(), ct);
    }), C(a, "dragover", ge), C(a, "mousemove", ge), C(a, "touchmove", ge), C(a, "mouseup", o._onDrop), C(a, "touchend", o._onDrop), C(a, "touchcancel", o._onDrop), Mt && this.nativeDraggable && (this.options.touchStartThreshold = 4, c.draggable = true), W("delayStart", this, { evt: e }), i.delay && (!i.delayOnTouchOnly || n) && (!this.nativeDraggable || !(Me || ae))) {
      if (m.eventCanceled) {
        this._onDrop();
        return;
      }
      C(a, "mouseup", o._disableDelayedDrag), C(a, "touchend", o._disableDelayedDrag), C(a, "touchcancel", o._disableDelayedDrag), C(a, "mousemove", o._delayedDragTouchMoveHandler), C(a, "touchmove", o._delayedDragTouchMoveHandler), i.supportPointer && C(a, "pointermove", o._delayedDragTouchMoveHandler), o._dragStartTimer = setTimeout(s, i.delay);
    } else s();
  }
}, _delayedDragTouchMoveHandler: function(e) {
  var n = e.touches ? e.touches[0] : e;
  Math.max(Math.abs(n.clientX - this._lastX), Math.abs(n.clientY - this._lastY)) >= Math.floor(this.options.touchStartThreshold / (this.nativeDraggable && window.devicePixelRatio || 1)) && this._disableDelayedDrag();
}, _disableDelayedDrag: function() {
  c && ct(c), clearTimeout(this._dragStartTimer), this._disableDelayedDragEvents();
}, _disableDelayedDragEvents: function() {
  var e = this.el.ownerDocument;
  S(e, "mouseup", this._disableDelayedDrag), S(e, "touchend", this._disableDelayedDrag), S(e, "touchcancel", this._disableDelayedDrag), S(e, "mousemove", this._delayedDragTouchMoveHandler), S(e, "touchmove", this._delayedDragTouchMoveHandler), S(e, "pointermove", this._delayedDragTouchMoveHandler);
}, _triggerDragStart: function(e, n) {
  n = n || e.pointerType == "touch" && e, !this.nativeDraggable || n ? this.options.supportPointer ? C(document, "pointermove", this._onTouchMove) : n ? C(document, "touchmove", this._onTouchMove) : C(document, "mousemove", this._onTouchMove) : (C(c, "dragend", this), C(A, "dragstart", this._onDragStart));
  try {
    document.selection ? We(function() {
      document.selection.empty();
    }) : window.getSelection().removeAllRanges();
  } catch {
  }
}, _dragStarted: function(e, n) {
  if (ye = false, A && c) {
    W("dragStarted", this, { evt: n }), this.nativeDraggable && C(document, "dragover", lo);
    var t = this.options;
    !e && $(c, t.dragClass, false), $(c, t.ghostClass, true), m.active = this, e && this._appendGhost(), U({ sortable: this, name: "start", originalEvent: n });
  } else this._nulling();
}, _emulateDragOver: function() {
  if (Q) {
    this._lastX = Q.clientX, this._lastY = Q.clientY, ln();
    for (var e = document.elementFromPoint(Q.clientX, Q.clientY), n = e; e && e.shadowRoot && (e = e.shadowRoot.elementFromPoint(Q.clientX, Q.clientY), e !== n); ) n = e;
    if (c.parentNode[G]._isOutsideThisEl(e), n) do {
      if (n[G]) {
        var t = void 0;
        if (t = n[G]._onDragOver({ clientX: Q.clientX, clientY: Q.clientY, target: e, rootEl: n }), t && !this.options.dragoverBubble) break;
      }
      e = n;
    } while (n = n.parentNode);
    sn();
  }
}, _onTouchMove: function(e) {
  if (pe) {
    var n = this.options, t = n.fallbackTolerance, o = n.fallbackOffset, r = e.touches ? e.touches[0] : e, i = v && Se(v, true), a = v && i && i.a, s = v && i && i.d, l = Xe && L && Bt(L), u = (r.clientX - pe.clientX + o.x) / (a || 1) + (l ? l[0] - st[0] : 0) / (a || 1), d = (r.clientY - pe.clientY + o.y) / (s || 1) + (l ? l[1] - st[1] : 0) / (s || 1);
    if (!m.active && !ye) {
      if (t && Math.max(Math.abs(r.clientX - this._lastX), Math.abs(r.clientY - this._lastY)) < t) return;
      this._onDragStart(e, true);
    }
    if (v) {
      i ? (i.e += u - (at || 0), i.f += d - (lt || 0)) : i = { a: 1, b: 0, c: 0, d: 1, e: u, f: d };
      var f = "matrix(".concat(i.a, ",").concat(i.b, ",").concat(i.c, ",").concat(i.d, ",").concat(i.e, ",").concat(i.f, ")");
      g(v, "webkitTransform", f), g(v, "mozTransform", f), g(v, "msTransform", f), g(v, "transform", f), at = u, lt = d, Q = r;
    }
    e.cancelable && e.preventDefault();
  }
}, _appendGhost: function() {
  if (!v) {
    var e = this.options.fallbackOnBody ? document.body : A, n = V(c, true, Xe, true, e), t = this.options;
    if (Xe) {
      for (L = e; g(L, "position") === "static" && g(L, "transform") === "none" && L !== document; ) L = L.parentNode;
      L !== document.body && L !== document.documentElement ? (L === document && (L = ne()), n.top += L.scrollTop, n.left += L.scrollLeft) : L = ne(), st = Bt(L);
    }
    v = c.cloneNode(true), $(v, t.ghostClass, false), $(v, t.fallbackClass, true), $(v, t.dragClass, true), g(v, "transition", ""), g(v, "transform", ""), g(v, "box-sizing", "border-box"), g(v, "margin", 0), g(v, "top", n.top), g(v, "left", n.left), g(v, "width", n.width), g(v, "height", n.height), g(v, "opacity", "0.8"), g(v, "position", Xe ? "absolute" : "fixed"), g(v, "zIndex", "100000"), g(v, "pointerEvents", "none"), m.ghost = v, e.appendChild(v), g(v, "transform-origin", Yt / parseInt(v.style.width) * 100 + "% " + Vt / parseInt(v.style.height) * 100 + "%");
  }
}, _onDragStart: function(e, n) {
  var t = this, o = e.dataTransfer, r = t.options;
  if (W("dragStart", this, { evt: e }), m.eventCanceled) {
    this._onDrop();
    return;
  }
  W("setupClone", this), m.eventCanceled || (k = tn(c), k.removeAttribute("id"), k.draggable = false, k.style["will-change"] = "", this._hideClone(), $(k, this.options.chosenClass, false), m.clone = k), t.cloneId = We(function() {
    W("clone", t), !m.eventCanceled && (t.options.removeCloneOnHide || A.insertBefore(k, c), t._hideClone(), U({ sortable: t, name: "clone" }));
  }), !n && $(c, r.dragClass, true), n ? (Ge = true, t._loopId = setInterval(t._emulateDragOver, 50)) : (S(document, "mouseup", t._onDrop), S(document, "touchend", t._onDrop), S(document, "touchcancel", t._onDrop), o && (o.effectAllowed = "move", r.setData && r.setData.call(t, o, c)), C(document, "drop", t), g(c, "transform", "translateZ(0)")), ye = true, t._dragStartId = We(t._dragStarted.bind(t, n, e)), C(document, "selectstart", t), Ce = true, Oe && g(document.body, "user-select", "none");
}, _onDragOver: function(e) {
  var n = this.el, t = e.target, o, r, i, a = this.options, s = a.group, l = m.active, u = Ye === s, d = a.sort, f = F || l, E, h = this, O = false;
  if (pt) return;
  function _(de, et) {
    W(de, h, oe({ evt: e, isOwner: u, axis: E ? "vertical" : "horizontal", revert: i, dragRect: o, targetRect: r, canSort: d, fromSortable: f, target: t, completed: X, onMove: function(Et, fn) {
      return He(A, n, c, o, Et, V(Et), e, fn);
    }, changed: z }, et));
  }
  function j() {
    _("dragOverAnimationCapture"), h.captureAnimationState(), h !== f && f.captureAnimationState();
  }
  function X(de) {
    return _("dragOverCompleted", { insertion: de }), de && (u ? l._hideClone() : l._showClone(h), h !== f && ($(c, F ? F.options.ghostClass : l.options.ghostClass, false), $(c, a.ghostClass, true)), F !== h && h !== m.active ? F = h : h === m.active && F && (F = null), f === h && (h._ignoreWhileAnimating = t), h.animateAll(function() {
      _("dragOverAnimationComplete"), h._ignoreWhileAnimating = null;
    }), h !== f && (f.animateAll(), f._ignoreWhileAnimating = null)), (t === c && !c.animated || t === n && !t.animated) && (be = null), !a.dragoverBubble && !e.rootEl && t !== document && (c.parentNode[G]._isOutsideThisEl(e.target), !de && ge(e)), !a.dragoverBubble && e.stopPropagation && e.stopPropagation(), O = true;
  }
  function z() {
    q = J(c), se = J(c, a.draggable), U({ sortable: h, name: "change", toEl: n, newIndex: q, newDraggableIndex: se, originalEvent: e });
  }
  if (e.preventDefault !== void 0 && e.cancelable && e.preventDefault(), t = ee(t, a.draggable, n, true), _("dragOver"), m.eventCanceled) return O;
  if (c.contains(e.target) || t.animated && t.animatingX && t.animatingY || h._ignoreWhileAnimating === t) return X(false);
  if (Ge = false, l && !a.disabled && (u ? d || (i = I !== A) : F === this || (this.lastPutMode = Ye.checkPull(this, l, c, e)) && s.checkPut(this, l, c, e))) {
    if (E = this._getDirection(e, t) === "vertical", o = V(c), _("dragOverValid"), m.eventCanceled) return O;
    if (i) return I = A, j(), this._hideClone(), _("revert"), m.eventCanceled || (me ? A.insertBefore(c, me) : A.appendChild(c)), X(true);
    var M = wt(n, a.draggable);
    if (!M || fo(e, E, this) && !M.animated) {
      if (M === c) return X(false);
      if (M && n === e.target && (t = M), t && (r = V(t)), He(A, n, c, o, t, r, e, !!t) !== false) return j(), M && M.nextSibling ? n.insertBefore(c, M.nextSibling) : n.appendChild(c), I = n, z(), X(true);
    } else if (M && uo(e, E, this)) {
      var Z = Ee(n, 0, a, true);
      if (Z === c) return X(false);
      if (t = Z, r = V(t), He(A, n, c, o, t, r, e, false) !== false) return j(), n.insertBefore(c, Z), I = n, z(), X(true);
    } else if (t.parentNode === n) {
      r = V(t);
      var D = 0, w, P = c.parentNode !== n, p = !io(c.animated && c.toRect || o, t.animated && t.toRect || r, E), b = E ? "top" : "left", T = Rt(t, "top", "top") || Rt(c, "top", "top"), R = T ? T.scrollTop : void 0;
      be !== t && (w = r[b], Ie = false, Ve = !p && a.invertSwap || P), D = ho(e, t, r, E, p ? 1 : a.swapThreshold, a.invertedSwapThreshold == null ? a.swapThreshold : a.invertedSwapThreshold, Ve, be === t);
      var x;
      if (D !== 0) {
        var y = J(c);
        do
          y -= D, x = I.children[y];
        while (x && (g(x, "display") === "none" || x === v));
      }
      if (D === 0 || x === t) return X(false);
      be = t, Ne = D;
      var N = t.nextElementSibling, H = false;
      H = D === 1;
      var te = He(A, n, c, o, t, r, e, H);
      if (te !== false) return (te === 1 || te === -1) && (H = te === 1), pt = true, setTimeout(co, 30), j(), H && !N ? n.appendChild(c) : t.parentNode.insertBefore(c, H ? N : t), T && en(T, 0, R - T.scrollTop), I = c.parentNode, w !== void 0 && !Ve && (Ue = Math.abs(w - V(t)[b])), z(), X(true);
    }
    if (n.contains(c)) return X(false);
  }
  return false;
}, _ignoreWhileAnimating: null, _offMoveEvents: function() {
  S(document, "mousemove", this._onTouchMove), S(document, "touchmove", this._onTouchMove), S(document, "pointermove", this._onTouchMove), S(document, "dragover", ge), S(document, "mousemove", ge), S(document, "touchmove", ge);
}, _offUpEvents: function() {
  var e = this.el.ownerDocument;
  S(e, "mouseup", this._onDrop), S(e, "touchend", this._onDrop), S(e, "pointerup", this._onDrop), S(e, "touchcancel", this._onDrop), S(document, "selectstart", this);
}, _onDrop: function(e) {
  var n = this.el, t = this.options;
  if (q = J(c), se = J(c, t.draggable), W("drop", this, { evt: e }), I = c && c.parentNode, q = J(c), se = J(c, t.draggable), m.eventCanceled) {
    this._nulling();
    return;
  }
  ye = false, Ve = false, Ie = false, clearInterval(this._loopId), clearTimeout(this._dragStartTimer), gt(this.cloneId), gt(this._dragStartId), this.nativeDraggable && (S(document, "drop", this), S(n, "dragstart", this._onDragStart)), this._offMoveEvents(), this._offUpEvents(), Oe && g(document.body, "user-select", ""), g(c, "transform", ""), e && (Ce && (e.cancelable && e.preventDefault(), !t.dropBubble && e.stopPropagation()), v && v.parentNode && v.parentNode.removeChild(v), (A === I || F && F.lastPutMode !== "clone") && k && k.parentNode && k.parentNode.removeChild(k), c && (this.nativeDraggable && S(c, "dragend", this), ct(c), c.style["will-change"] = "", Ce && !ye && $(c, F ? F.options.ghostClass : this.options.ghostClass, false), $(c, this.options.chosenClass, false), U({ sortable: this, name: "unchoose", toEl: I, newIndex: null, newDraggableIndex: null, originalEvent: e }), A !== I ? (q >= 0 && (U({ rootEl: I, name: "add", toEl: I, fromEl: A, originalEvent: e }), U({ sortable: this, name: "remove", toEl: I, originalEvent: e }), U({ rootEl: I, name: "sort", toEl: I, fromEl: A, originalEvent: e }), U({ sortable: this, name: "sort", toEl: I, originalEvent: e })), F && F.save()) : q !== _e && q >= 0 && (U({ sortable: this, name: "update", toEl: I, originalEvent: e }), U({ sortable: this, name: "sort", toEl: I, originalEvent: e })), m.active && ((q == null || q === -1) && (q = _e, se = ke), U({ sortable: this, name: "end", toEl: I, originalEvent: e }), this.save()))), this._nulling();
}, _nulling: function() {
  W("nulling", this), A = c = I = v = me = k = Le = ce = pe = Q = Ce = q = se = _e = ke = be = Ne = F = Ye = m.dragged = m.ghost = m.clone = m.active = null, Je.forEach(function(e) {
    e.checked = true;
  }), Je.length = at = lt = 0;
}, handleEvent: function(e) {
  switch (e.type) {
    case "drop":
    case "dragend":
      this._onDrop(e);
      break;
    case "dragenter":
    case "dragover":
      c && (this._onDragOver(e), so(e));
      break;
    case "selectstart":
      e.preventDefault();
      break;
  }
}, toArray: function() {
  for (var e = [], n, t = this.el.children, o = 0, r = t.length, i = this.options; o < r; o++) n = t[o], ee(n, i.draggable, this.el, false) && e.push(n.getAttribute(i.dataIdAttr) || go(n));
  return e;
}, sort: function(e, n) {
  var t = {}, o = this.el;
  this.toArray().forEach(function(r, i) {
    var a = o.children[i];
    ee(a, this.options.draggable, o, false) && (t[r] = a);
  }, this), n && this.captureAnimationState(), e.forEach(function(r) {
    t[r] && (o.removeChild(t[r]), o.appendChild(t[r]));
  }), n && this.animateAll();
}, save: function() {
  var e = this.options.store;
  e && e.set && e.set(this);
}, closest: function(e, n) {
  return ee(e, n || this.options.draggable, this.el, false);
}, option: function(e, n) {
  var t = this.options;
  if (n === void 0) return t[e];
  var o = Pe.modifyOption(this, e, n);
  typeof o < "u" ? t[e] = o : t[e] = n, e === "group" && an(t);
}, destroy: function() {
  W("destroy", this);
  var e = this.el;
  e[G] = null, S(e, "mousedown", this._onTapStart), S(e, "touchstart", this._onTapStart), S(e, "pointerdown", this._onTapStart), this.nativeDraggable && (S(e, "dragover", this), S(e, "dragenter", this)), Array.prototype.forEach.call(e.querySelectorAll("[draggable]"), function(n) {
    n.removeAttribute("draggable");
  }), this._onDrop(), this._disableDelayedDragEvents(), Ze.splice(Ze.indexOf(this.el), 1), this.el = e = null;
}, _hideClone: function() {
  if (!ce) {
    if (W("hideClone", this), m.eventCanceled) return;
    g(k, "display", "none"), this.options.removeCloneOnHide && k.parentNode && k.parentNode.removeChild(k), ce = true;
  }
}, _showClone: function(e) {
  if (e.lastPutMode !== "clone") {
    this._hideClone();
    return;
  }
  if (ce) {
    if (W("showClone", this), m.eventCanceled) return;
    c.parentNode == A && !this.options.group.revertClone ? A.insertBefore(k, c) : me ? A.insertBefore(k, me) : A.appendChild(k), this.options.group.revertClone && this.animate(c, k), g(k, "display", ""), ce = false;
  }
} };
function so(e) {
  e.dataTransfer && (e.dataTransfer.dropEffect = "move"), e.cancelable && e.preventDefault();
}
function He(e, n, t, o, r, i, a, s) {
  var l, u = e[G], d = u.options.onMove, f;
  return window.CustomEvent && !ae && !Me ? l = new CustomEvent("move", { bubbles: true, cancelable: true }) : (l = document.createEvent("Event"), l.initEvent("move", true, true)), l.to = n, l.from = e, l.dragged = t, l.draggedRect = o, l.related = r || n, l.relatedRect = i || V(n), l.willInsertAfter = s, l.originalEvent = a, e.dispatchEvent(l), d && (f = d.call(u, l, a)), f;
}
function ct(e) {
  e.draggable = false;
}
function co() {
  pt = false;
}
function uo(e, n, t) {
  var o = V(Ee(t.el, 0, t.options, true)), r = nn(t.el, t.options, v), i = 10;
  return n ? e.clientX < r.left - i || e.clientY < o.top && e.clientX < o.right : e.clientY < r.top - i || e.clientY < o.bottom && e.clientX < o.left;
}
function fo(e, n, t) {
  var o = V(wt(t.el, t.options.draggable)), r = nn(t.el, t.options, v), i = 10;
  return n ? e.clientX > r.right + i || e.clientY > o.bottom && e.clientX > o.left : e.clientY > r.bottom + i || e.clientX > o.right && e.clientY > o.top;
}
function ho(e, n, t, o, r, i, a, s) {
  var l = o ? e.clientY : e.clientX, u = o ? t.height : t.width, d = o ? t.top : t.left, f = o ? t.bottom : t.right, E = false;
  if (!a) {
    if (s && Ue < u * r) {
      if (!Ie && (Ne === 1 ? l > d + u * i / 2 : l < f - u * i / 2) && (Ie = true), Ie) E = true;
      else if (Ne === 1 ? l < d + Ue : l > f - Ue) return -Ne;
    } else if (l > d + u * (1 - r) / 2 && l < f - u * (1 - r) / 2) return po(n);
  }
  return E = E || a, E && (l < d + u * i / 2 || l > f - u * i / 2) ? l > d + u / 2 ? 1 : -1 : 0;
}
function po(e) {
  return J(c) < J(e) ? 1 : -1;
}
function go(e) {
  for (var n = e.tagName + e.className + e.src + e.href + e.textContent, t = n.length, o = 0; t--; ) o += n.charCodeAt(t);
  return o.toString(36);
}
function mo(e) {
  Je.length = 0;
  for (var n = e.getElementsByTagName("input"), t = n.length; t--; ) {
    var o = n[t];
    o.checked && Je.push(o);
  }
}
function We(e) {
  return setTimeout(e, 0);
}
function gt(e) {
  return clearTimeout(e);
}
Qe && C(document, "touchmove", function(e) {
  (m.active || ye) && e.cancelable && e.preventDefault();
});
m.utils = { on: C, off: S, css: g, find: Kt, is: function(e, n) {
  return !!ee(e, n, e, false);
}, extend: Jn, throttle: Qt, closest: ee, toggleClass: $, clone: tn, index: J, nextTick: We, cancelNextTick: gt, detectDirection: rn, getChild: Ee };
m.get = function(e) {
  return e[G];
};
m.mount = function() {
  for (var e = arguments.length, n = new Array(e), t = 0; t < e; t++) n[t] = arguments[t];
  n[0].constructor === Array && (n = n[0]), n.forEach(function(o) {
    if (!o.prototype || !o.prototype.constructor) throw "Sortable: Mounted plugin must be a constructor function, not ".concat({}.toString.call(o));
    o.utils && (m.utils = oe(oe({}, m.utils), o.utils)), Pe.mount(o);
  });
};
m.create = function(e, n) {
  return new m(e, n);
};
m.version = qn;
var B = [], Te, mt, vt = false, ut, dt, Ke, xe;
function vo() {
  function e() {
    this.defaults = { scroll: true, forceAutoScrollFallback: false, scrollSensitivity: 30, scrollSpeed: 10, bubbleScroll: true };
    for (var n in this) n.charAt(0) === "_" && typeof this[n] == "function" && (this[n] = this[n].bind(this));
  }
  return e.prototype = { dragStarted: function(n) {
    var t = n.originalEvent;
    this.sortable.nativeDraggable ? C(document, "dragover", this._handleAutoScroll) : this.options.supportPointer ? C(document, "pointermove", this._handleFallbackAutoScroll) : t.touches ? C(document, "touchmove", this._handleFallbackAutoScroll) : C(document, "mousemove", this._handleFallbackAutoScroll);
  }, dragOverCompleted: function(n) {
    var t = n.originalEvent;
    !this.options.dragOverBubble && !t.rootEl && this._handleAutoScroll(t);
  }, drop: function() {
    this.sortable.nativeDraggable ? S(document, "dragover", this._handleAutoScroll) : (S(document, "pointermove", this._handleFallbackAutoScroll), S(document, "touchmove", this._handleFallbackAutoScroll), S(document, "mousemove", this._handleFallbackAutoScroll)), Ht(), ze(), Kn();
  }, nulling: function() {
    Ke = mt = Te = vt = xe = ut = dt = null, B.length = 0;
  }, _handleFallbackAutoScroll: function(n) {
    this._handleAutoScroll(n, true);
  }, _handleAutoScroll: function(n, t) {
    var o = this, r = (n.touches ? n.touches[0] : n).clientX, i = (n.touches ? n.touches[0] : n).clientY, a = document.elementFromPoint(r, i);
    if (Ke = n, t || this.options.forceAutoScrollFallback || Me || ae || Oe) {
      ft(n, this.options, a, t);
      var s = ue(a, true);
      vt && (!xe || r !== ut || i !== dt) && (xe && Ht(), xe = setInterval(function() {
        var l = ue(document.elementFromPoint(r, i), true);
        l !== s && (s = l, ze()), ft(n, o.options, l, t);
      }, 10), ut = r, dt = i);
    } else {
      if (!this.options.bubbleScroll || ue(a, true) === ne()) {
        ze();
        return;
      }
      ft(n, this.options, ue(a, false), false);
    }
  } }, ie(e, { pluginName: "scroll", initializeByDefault: true });
}
function ze() {
  B.forEach(function(e) {
    clearInterval(e.pid);
  }), B = [];
}
function Ht() {
  clearInterval(xe);
}
var ft = Qt(function(e, n, t, o) {
  if (n.scroll) {
    var r = (e.touches ? e.touches[0] : e).clientX, i = (e.touches ? e.touches[0] : e).clientY, a = n.scrollSensitivity, s = n.scrollSpeed, l = ne(), u = false, d;
    mt !== t && (mt = t, ze(), Te = n.scroll, d = n.scrollFn, Te === true && (Te = ue(t, true)));
    var f = 0, E = Te;
    do {
      var h = E, O = V(h), _ = O.top, j = O.bottom, X = O.left, z = O.right, M = O.width, Z = O.height, D = void 0, w = void 0, P = h.scrollWidth, p = h.scrollHeight, b = g(h), T = h.scrollLeft, R = h.scrollTop;
      h === l ? (D = M < P && (b.overflowX === "auto" || b.overflowX === "scroll" || b.overflowX === "visible"), w = Z < p && (b.overflowY === "auto" || b.overflowY === "scroll" || b.overflowY === "visible")) : (D = M < P && (b.overflowX === "auto" || b.overflowX === "scroll"), w = Z < p && (b.overflowY === "auto" || b.overflowY === "scroll"));
      var x = D && (Math.abs(z - r) <= a && T + M < P) - (Math.abs(X - r) <= a && !!T), y = w && (Math.abs(j - i) <= a && R + Z < p) - (Math.abs(_ - i) <= a && !!R);
      if (!B[f]) for (var N = 0; N <= f; N++) B[N] || (B[N] = {});
      (B[f].vx != x || B[f].vy != y || B[f].el !== h) && (B[f].el = h, B[f].vx = x, B[f].vy = y, clearInterval(B[f].pid), (x != 0 || y != 0) && (u = true, B[f].pid = setInterval((function() {
        o && this.layer === 0 && m.active._onTouchMove(Ke);
        var H = B[this.layer].vy ? B[this.layer].vy * s : 0, te = B[this.layer].vx ? B[this.layer].vx * s : 0;
        typeof d == "function" && d.call(m.dragged.parentNode[G], te, H, e, Ke, B[this.layer].el) !== "continue" || en(B[this.layer].el, te, H);
      }).bind({ layer: f }), 24))), f++;
    } while (n.bubbleScroll && E !== l && (E = ue(E, false)));
    vt = u;
  }
}, 30), cn = function(e) {
  var n = e.originalEvent, t = e.putSortable, o = e.dragEl, r = e.activeSortable, i = e.dispatchSortableEvent, a = e.hideGhostForTarget, s = e.unhideGhostForTarget;
  if (n) {
    var l = t || r;
    a();
    var u = n.changedTouches && n.changedTouches.length ? n.changedTouches[0] : n, d = document.elementFromPoint(u.clientX, u.clientY);
    s(), l && !l.el.contains(d) && (i("spill"), this.onSpill({ dragEl: o, putSortable: t }));
  }
};
function _t() {
}
_t.prototype = { startIndex: null, dragStart: function(e) {
  var n = e.oldDraggableIndex;
  this.startIndex = n;
}, onSpill: function(e) {
  var n = e.dragEl, t = e.putSortable;
  this.sortable.captureAnimationState(), t && t.captureAnimationState();
  var o = Ee(this.sortable.el, this.startIndex, this.options);
  o ? this.sortable.el.insertBefore(n, o) : this.sortable.el.appendChild(n), this.sortable.animateAll(), t && t.animateAll();
}, drop: cn };
ie(_t, { pluginName: "revertOnSpill" });
function St() {
}
St.prototype = { onSpill: function(e) {
  var n = e.dragEl, t = e.putSortable, o = t || this.sortable;
  o.captureAnimationState(), n.parentNode && n.parentNode.removeChild(n), o.animateAll();
}, drop: cn };
ie(St, { pluginName: "removeOnSpill" });
m.mount(new vo());
m.mount(St, _t);
function bo(e) {
  return e == null ? e : JSON.parse(JSON.stringify(e));
}
function yo(e) {
  yt() && vn(e);
}
function wo(e) {
  yt() ? bn(e) : Ut(e);
}
let un = null, dn = null;
function Ft(e = null, n = null) {
  un = e, dn = n;
}
function _o() {
  return { data: un, clonedData: dn };
}
const jt = /* @__PURE__ */ Symbol("cloneElement");
function So(...e) {
  var n, t;
  const o = (n = yt()) == null ? void 0 : n.proxy;
  let r = null;
  const i = e[0];
  let [, a, s] = e;
  Array.isArray(Y(a)) || (s = a, a = null);
  let l = null;
  const { immediate: u = true, clone: d = bo, customUpdate: f } = (t = Y(s)) != null ? t : {};
  function E(p) {
    var b;
    const { from: T, oldIndex: R, item: x } = p;
    r = Array.from(T.childNodes);
    const y = Y((b = Y(a)) == null ? void 0 : b[R]), N = d(y);
    Ft(y, N), x[jt] = N;
  }
  function h(p) {
    const b = p.item[jt];
    if (!Yn(b)) {
      if (ot(p.item), Fe(a)) {
        const T = [...Y(a)];
        a.value = At(T, p.newDraggableIndex, b);
        return;
      }
      At(Y(a), p.newDraggableIndex, b);
    }
  }
  function O(p) {
    const { from: b, item: T, oldIndex: R, oldDraggableIndex: x, pullMode: y, clone: N } = p;
    if (kt(b, T, R), y === "clone") {
      ot(N);
      return;
    }
    if (Fe(a)) {
      const H = [...Y(a)];
      a.value = Ot(H, x);
      return;
    }
    Ot(Y(a), x);
  }
  function _(p) {
    if (f) {
      f(p);
      return;
    }
    const { from: b, item: T, oldIndex: R, newIndex: x } = p;
    if (ot(T), kt(b, T, R), Fe(a)) {
      const y = [...Y(a)];
      a.value = xt(y, R, x);
      return;
    }
    xt(Y(a), R, x);
  }
  function j(p) {
    const { newIndex: b, oldIndex: T, from: R, to: x } = p;
    let y = null;
    const N = b === T && R === x;
    try {
      if (N) {
        let H = null;
        r == null || r.some((te, de) => {
          if (H && (r == null ? void 0 : r.length) !== x.childNodes.length) return R.insertBefore(H, te.nextSibling), true;
          const et = x.childNodes[de];
          H = x == null ? void 0 : x.replaceChild(te, et);
        });
      }
    } catch (H) {
      y = H;
    } finally {
      r = null;
    }
    Ut(() => {
      if (Ft(), y) throw y;
    });
  }
  const X = { onUpdate: _, onStart: E, onAdd: h, onRemove: O, onEnd: j };
  function z(p) {
    const b = Y(i);
    return p || (p = Vn(b) ? Xn(b, o == null ? void 0 : o.$el) : b), p && !jn(p) && (p = p.$el), p || Pn("Root element not found"), p;
  }
  function M() {
    var p;
    const b = (p = Y(s)) != null ? p : {}, T = $t(b, ["immediate", "clone"]);
    return Nt(T, (R, x) => {
      Ln(R) && (T[R] = (y, ...N) => {
        const H = _o();
        return Un(y, H), x(y, ...N);
      });
    }), Fn(a === null ? {} : X, T);
  }
  const Z = (p) => {
    p = z(p), l && D.destroy(), l = new m(p, M());
  };
  Lt(() => s, () => {
    l && Nt(M(), (p, b) => {
      l == null || l.option(p, b);
    });
  }, { deep: true });
  const D = { option: (p, b) => l == null ? void 0 : l.option(p, b), destroy: () => {
    l == null || l.destroy(), l = null;
  }, save: () => l == null ? void 0 : l.save(), toArray: () => l == null ? void 0 : l.toArray(), closest: (...p) => l == null ? void 0 : l.closest(...p) }, w = () => D == null ? void 0 : D.option("disabled", true), P = () => D == null ? void 0 : D.option("disabled", false);
  return wo(() => {
    u && Z();
  }), yo(D.destroy), we({ start: Z, pause: w, resume: P }, D);
}
const bt = ["update", "start", "add", "remove", "choose", "unchoose", "end", "sort", "filter", "clone", "move", "change"], Eo = ["clone", "animation", "ghostClass", "group", "sort", "disabled", "store", "handle", "draggable", "swapThreshold", "invertSwap", "invertedSwapThreshold", "removeCloneOnHide", "direction", "chosenClass", "dragClass", "ignore", "filter", "preventOnFilter", "easing", "setData", "dropBubble", "dragoverBubble", "dataIdAttr", "delay", "delayOnTouchOnly", "touchStartThreshold", "forceFallback", "fallbackClass", "fallbackOnBody", "fallbackTolerance", "fallbackOffset", "supportPointer", "emptyInsertThreshold", "scroll", "forceAutoScrollFallback", "scrollSensitivity", "scrollSpeed", "bubbleScroll", "modelValue", "tag", "target", "customUpdate", ...bt.map((e) => `on${e.replace(/^\S/, (n) => n.toUpperCase())}`)], Do = hn({ name: "VueDraggable", model: { prop: "modelValue", event: "update:modelValue" }, props: Eo, emits: ["update:modelValue", ...bt], setup(e, { slots: n, emit: t, expose: o, attrs: r }) {
  const i = bt.reduce((d, f) => {
    const E = `on${f.replace(/^\S/, (h) => h.toUpperCase())}`;
    return d[E] = (...h) => t(f, ...h), d;
  }, {}), a = Dt(() => {
    const d = pn(e), f = $t(d, ["modelValue"]), E = Object.entries(f).reduce((h, [O, _]) => {
      const j = Y(_);
      return j !== void 0 && (h[O] = j), h;
    }, {});
    return we(we({}, i), Bn(we(we({}, r), E)));
  }), s = Dt({ get: () => e.modelValue, set: (d) => t("update:modelValue", d) }), l = ht(), u = gn(So(e.target || l, s, a));
  return o(u), () => {
    var d;
    return mn(e.tag || "div", { ref: l }, (d = n == null ? void 0 : n.default) == null ? void 0 : d.call(n, u));
  };
} });
const Co = { class: "head-container", style: { float: "right" } }, To = { key: 1 }, xo = { __name: "push-level-setting", props: { visible: { type: Boolean, default: false }, detailList: { type: Array, default: () => [] } }, emits: ["update:visible", "success"], setup(e, { emit: n }) {
  const t = n, o = e, r = ht(false), i = ht({ id: void 0, list: [] }), { visible: a, handleClose: s } = On({ emit: t, props: o, field: "visible", showHook: u, closeHook: d }), { maxHeight: l } = An({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, a);
  Lt(() => o.visible, (D) => {
    var w;
    D && (i.value.list = [], o.detailList && o.detailList.length > 0 && (i.value.list = nt(o.detailList), (w = i.value.list) == null || w.forEach((P) => {
      P.level = String.fromCharCode(P.level);
    })));
  }, { immediate: true });
  function u() {
    var D;
    i.value = { id: void 0, list: [] }, E(i.value.list), o.detailList && o.detailList.length > 0 && (i.value.list = nt(o.detailList), (D = i.value.list) == null || D.forEach((w) => {
      w.level = String.fromCharCode(w.level);
    }));
  }
  function d() {
    r.value = false;
  }
  const f = { level: [{ required: true, message: "请输入等级", trigger: "change" }, { pattern: /^[A-Z] {0,1}$/, message: "请输入大小写字母", trigger: "blur" }], color: [{ required: true, message: "请选择颜色", trigger: "change" }] }, { init: E, addRow: h, removeRow: O } = Nn({}, 3), { tableValidate: _, cleanUpData: j, wrongCellMask: X } = kn({ rules: f });
  async function z() {
    try {
      const { validResult: D, dealList: w } = _(i.value.list), P = j(nt(w));
      if (console.log(P, "list"), D) {
        const p = P == null ? void 0 : P.map((b) => {
          var T;
          return { level: (T = b.level) == null ? void 0 : T.charCodeAt(), color: b.color, id: r.value ? b.id : void 0 };
        });
        console.log(p, "_list"), await Tn(p), Ct.success("推送等级设置成功"), t("success"), s();
      }
    } catch (D) {
      console.log(D, "推送等级设置成功失败");
    }
  }
  function M(D, w) {
    if (/^[A-Z]$/.test(w)) {
      D.isError = false;
      return;
    } else Ct.error("请输入一个大写字母!"), D.isError = true;
  }
  async function Z() {
    r.value = false, await u();
  }
  return (D, w) => {
    const P = tt("common-button"), p = En, b = Dn, T = Cn, R = tt("common-table"), x = tt("common-drawer");
    return le(), fe(x, { ref: "drawerRef", title: "推送等级设置", modelValue: Y(a), "onUpdate:modelValue": w[3] || (w[3] = (y) => Fe(a) ? a.value = y : null), direction: "rtl", "close-on-click-modal": false, "before-close": Y(s), size: "30%" }, { titleRight: K(() => [r.value ? De("", true) : (le(), fe(P, { key: 0, type: "primary", onClick: w[0] || (w[0] = Re((y) => r.value = true, ["stop"])) }, { default: K(() => w[4] || (w[4] = [Be(" 编辑 ")])), _: 1, __: [4] })), r.value ? (le(), fe(P, { key: 1, type: "warning", onClick: Re(Z, ["stop"]) }, { default: K(() => w[5] || (w[5] = [Be(" 取消编辑 ")])), _: 1, __: [5] })) : De("", true), r.value ? (le(), fe(P, { key: 2, type: "success", onClick: Re(z, ["stop"]) }, { default: K(() => w[6] || (w[6] = [Be(" 保存提交 ")])), _: 1, __: [6] })) : De("", true)]), content: K(() => [yn("div", Co, [r.value ? (le(), fe(P, { key: 0, type: "primary", icon: "el-icon-plus", onClick: w[1] || (w[1] = (y) => Y(h)(i.value.list)) }, { default: K(() => w[7] || (w[7] = [Be(" 添加一行 ")])), _: 1, __: [7] })) : De("", true)]), he(Y(Do), { modelValue: i.value.list, "onUpdate:modelValue": w[2] || (w[2] = (y) => i.value.list = y), target: "tbody", animation: 15 }, { default: K(() => [he(R, { ref: "table", data: i.value.list, "show-empty-symbol": false, "return-source-data": "", "empty-text": "暂无数据", "max-height": Y(l), "cell-class-name": Y(X) }, { default: K(() => [he(p, { label: "序号", type: "index", align: "center", width: "60" }), he(p, { prop: "level", "show-overflow-tooltip": true, label: "等级", align: "center", "min-width": "150" }, { default: K(({ row: y }) => [r.value ? (le(), fe(b, { key: 0, modelValue: y.level, "onUpdate:modelValue": (N) => y.level = N, modelModifiers: { trim: true }, clearable: "", placeholder: "等级", size: "default", class: wn(["input-underline", { error: y.isError }]), style: { width: "100%" }, onBlur: (N) => M(y, y.level) }, null, 8, ["modelValue", "onUpdate:modelValue", "class", "onBlur"])) : (le(), _n("span", To, Sn(y.level), 1))]), _: 1 }), he(p, { prop: "color", "show-overflow-tooltip": true, label: "颜色", align: "center" }, { default: K(({ row: y }) => [he(T, { disabled: !r.value, modelValue: y.color, "onUpdate:modelValue": (N) => y.color = N }, null, 8, ["disabled", "modelValue", "onUpdate:modelValue"])]), _: 1 }), r.value ? (le(), fe(p, { key: 0, label: "操作", width: "100px", align: "center", fixed: "right" }, { default: K(({ $index: y }) => [he(P, { type: "danger", icon: "el-icon-delete", size: "default", onClick: Re((N) => Y(O)(i.value.list, y), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })) : De("", true)]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])]), _: 1 }, 8, ["modelValue"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Mo = xn(xo, [["__scopeId", "data-v-bd894f7b"]]);
export {
  Mo as default
};
