import { mapGetters as Yr } from "vuex";
import { resolveComponent as Pi } from "vue";
import { openBlock as xe } from "vue";
import { createElementBlock as qr } from "vue";
import { createElementVNode as tt } from "vue";
import { createTextVNode as Si } from "vue";
import { createBlock as ze } from "vue";
import { withCtx as ie } from "vue";
import { createVNode as At } from "vue";
import { withKeys as Xr } from "vue";
import { createCommentVNode as Wr } from "vue";
import { withDirectives as Gr } from "vue";
import { vShow as Kr } from "vue";
import { toDisplayString as jr } from "vue";
import { ElInput as Qr } from "element-plus";
import { ElFormItem as Hr } from "element-plus";
import { ElTooltip as Zr } from "element-plus";
import { ElForm as Jr } from "element-plus";
import { $ as ve, _ as $r, a as tn } from "../../../shared/runtime.js";
import en from "./module/forgot-password.vue.js";
function gt(a15) {
  if (a15 === void 0) throw new ReferenceError("this hasn't been initialised - super() hasn't been called");
  return a15;
}
function qi(a15, t) {
  a15.prototype = Object.create(t.prototype), a15.prototype.constructor = a15, a15.__proto__ = t;
}
/*!
 * GSAP 3.13.0
 * https://gsap.com
 *
 * @license Copyright 2008-2025, GreenSock. All rights reserved.
 * Subject to the terms at https://gsap.com/standard-license
 * @author: Jack Doyle, jack@greensock.com
*/
var nt = { autoSleep: 120, force3D: "auto", nullTargetWarn: 1, units: { lineHeight: "" } }, jt = { duration: 0.5, overwrite: false, delay: 0 }, si, W, E, ut = 1e8, M = 1 / ut, Xe = Math.PI * 2, rn = Xe / 4, nn = 0, Xi = Math.sqrt, sn = Math.cos, on = Math.sin, q = function(t) {
  return typeof t == "string";
}, L = function(t) {
  return typeof t == "function";
}, xt = function(t) {
  return typeof t == "number";
}, oi = function(t) {
  return typeof t > "u";
}, pt = function(t) {
  return typeof t == "object";
}, Q = function(t) {
  return t !== false;
}, ai = function() {
  return typeof window < "u";
}, Te = function(t) {
  return L(t) || q(t);
}, Wi = typeof ArrayBuffer == "function" && ArrayBuffer.isView || function() {
}, K = Array.isArray, We = /(?:-?\.?\d|\.)+/gi, Gi = /[-+=.]*\d+[.e\-+]*\d*[e\-+]*\d*/g, qt = /[-+=.]*\d+[.e-]*\d*[a-z%]*/g, Le = /[-+=.]*\d+\.?\d*(?:e-|e\+)?\d*/gi, Ki = /[+-]=-?[.\d]+/, ji = /[^,'"\[\]\s]+/gi, an = /^[+\-=e\s\d]*\d+[.\d]*([a-z]*|%)\s*$/i, F, _t, Ge, ui, st = {}, Se = {}, Qi, Hi = function(t) {
  return (Se = Qt(t, st)) && $;
}, li = function(t, e) {
  return console.warn("Invalid property", t, "set to", e, "Missing plugin? gsap.registerPlugin()");
}, fe = function(t, e) {
  return !e && console.warn(t);
}, Zi = function(t, e) {
  return t && (st[t] = e) && Se && (Se[t] = e) || st;
}, he = function() {
  return 0;
}, un = { suppressEvents: true, isStart: true, kill: false }, we = { suppressEvents: true, kill: false }, ln = { suppressEvents: true }, fi = {}, Pt = [], Ke = {}, Ji, et = {}, Ie = {}, Oi = 30, be = [], hi = "", _i = function(t) {
  var e = t[0], i, r;
  if (pt(e) || L(e) || (t = [t]), !(i = (e._gsap || {}).harness)) {
    for (r = be.length; r-- && !be[r].targetTest(e); ) ;
    i = be[r];
  }
  for (r = t.length; r--; ) t[r] && (t[r]._gsap || (t[r]._gsap = new wr(t[r], i))) || t.splice(r, 1);
  return t;
}, Lt = function(t) {
  return t._gsap || _i(lt(t))[0]._gsap;
}, $i = function(t, e, i) {
  return (i = t[e]) && L(i) ? t[e]() : oi(i) && t.getAttribute && t.getAttribute(e) || i;
}, H = function(t, e) {
  return (t = t.split(",")).forEach(e) || t;
}, I = function(t) {
  return Math.round(t * 1e5) / 1e5 || 0;
}, N = function(t) {
  return Math.round(t * 1e7) / 1e7 || 0;
}, Wt = function(t, e) {
  var i = e.charAt(0), r = parseFloat(e.substr(2));
  return t = parseFloat(t), i === "+" ? t + r : i === "-" ? t - r : i === "*" ? t * r : t / r;
}, fn = function(t, e) {
  for (var i = e.length, r = 0; t.indexOf(e[r]) < 0 && ++r < i; ) ;
  return r < i;
}, Oe = function() {
  var t = Pt.length, e = Pt.slice(0), i, r;
  for (Ke = {}, Pt.length = 0, i = 0; i < t; i++) r = e[i], r && r._lazy && (r.render(r._lazy[0], r._lazy[1], true)._lazy = 0);
}, ci = function(t) {
  return !!(t._initted || t._startAt || t.add);
}, tr = function(t, e, i, r) {
  Pt.length && !W && Oe(), t.render(e, i, r || !!(W && e < 0 && ci(t))), Pt.length && !W && Oe();
}, er = function(t) {
  var e = parseFloat(t);
  return (e || e === 0) && (t + "").match(ji).length < 2 ? e : q(t) ? t.trim() : t;
}, ir = function(t) {
  return t;
}, ot = function(t, e) {
  for (var i in e) i in t || (t[i] = e[i]);
  return t;
}, hn = function(t) {
  return function(e, i) {
    for (var r in i) r in e || r === "duration" && t || r === "ease" || (e[r] = i[r]);
  };
}, Qt = function(t, e) {
  for (var i in e) t[i] = e[i];
  return t;
}, Ci = function a(t, e) {
  for (var i in e) i !== "__proto__" && i !== "constructor" && i !== "prototype" && (t[i] = pt(e[i]) ? a(t[i] || (t[i] = {}), e[i]) : e[i]);
  return t;
}, Ce = function(t, e) {
  var i = {}, r;
  for (r in t) r in e || (i[r] = t[r]);
  return i;
}, ae = function(t) {
  var e = t.parent || F, i = t.keyframes ? hn(K(t.keyframes)) : ot;
  if (Q(t.inherit)) for (; e; ) i(t, e.vars.defaults), e = e.parent || e._dp;
  return t;
}, _n = function(t, e) {
  for (var i = t.length, r = i === e.length; r && i-- && t[i] === e[i]; ) ;
  return i < 0;
}, rr = function(t, e, i, r, n) {
  i === void 0 && (i = "_first"), r === void 0 && (r = "_last");
  var s = t[r], o;
  if (n) for (o = e[n]; s && s[n] > o; ) s = s._prev;
  return s ? (e._next = s._next, s._next = e) : (e._next = t[i], t[i] = e), e._next ? e._next._prev = e : t[r] = e, e._prev = s, e.parent = e._dp = t, e;
}, Re = function(t, e, i, r) {
  i === void 0 && (i = "_first"), r === void 0 && (r = "_last");
  var n = e._prev, s = e._next;
  n ? n._next = s : t[i] === e && (t[i] = s), s ? s._prev = n : t[r] === e && (t[r] = n), e._next = e._prev = e.parent = null;
}, Ot = function(t, e) {
  t.parent && (!e || t.parent.autoRemoveChildren) && t.parent.remove && t.parent.remove(t), t._act = 0;
}, It = function(t, e) {
  if (t && (!e || e._end > t._dur || e._start < 0)) for (var i = t; i; ) i._dirty = 1, i = i.parent;
  return t;
}, cn = function(t) {
  for (var e = t.parent; e && e.parent; ) e._dirty = 1, e.totalDuration(), e = e.parent;
  return t;
}, je = function(t, e, i, r) {
  return t._startAt && (W ? t._startAt.revert(we) : t.vars.immediateRender && !t.vars.autoRevert || t._startAt.render(e, true, r));
}, dn = function a2(t) {
  return !t || t._ts && a2(t.parent);
}, ki = function(t) {
  return t._repeat ? Ht(t._tTime, t = t.duration() + t._rDelay) * t : 0;
}, Ht = function(t, e) {
  var i = Math.floor(t = N(t / e));
  return t && i === t ? i - 1 : i;
}, ke = function(t, e) {
  return (t - e._start) * e._ts + (e._ts >= 0 ? 0 : e._dirty ? e.totalDuration() : e._tDur);
}, Ee = function(t) {
  return t._end = N(t._start + (t._tDur / Math.abs(t._ts || t._rts || M) || 0));
}, Fe = function(t, e) {
  var i = t._dp;
  return i && i.smoothChildTiming && t._ts && (t._start = N(i._time - (t._ts > 0 ? e / t._ts : ((t._dirty ? t.totalDuration() : t._tDur) - e) / -t._ts)), Ee(t), i._dirty || It(i, t)), t;
}, nr = function(t, e) {
  var i;
  if ((e._time || !e._dur && e._initted || e._start < t._time && (e._dur || !e.add)) && (i = ke(t.rawTime(), e), (!e._dur || ge(0, e.totalDuration(), i) - e._tTime > M) && e.render(i, true)), It(t, e)._dp && t._initted && t._time >= t._dur && t._ts) {
    if (t._dur < t.duration()) for (i = t; i._dp; ) i.rawTime() >= 0 && i.totalTime(i._tTime), i = i._dp;
    t._zTime = -M;
  }
}, ct = function(t, e, i, r) {
  return e.parent && Ot(e), e._start = N((xt(i) ? i : i || t !== F ? at(t, i, e) : t._time) + e._delay), e._end = N(e._start + (e.totalDuration() / Math.abs(e.timeScale()) || 0)), rr(t, e, "_first", "_last", t._sort ? "_start" : 0), Qe(e) || (t._recent = e), r || nr(t, e), t._ts < 0 && Fe(t, t._tTime), t;
}, sr = function(t, e) {
  return (st.ScrollTrigger || li("scrollTrigger", e)) && st.ScrollTrigger.create(e, t);
}, or = function(t, e, i, r, n) {
  if (pi(t, e, n), !t._initted) return 1;
  if (!i && t._pt && !W && (t._dur && t.vars.lazy !== false || !t._dur && t.vars.lazy) && Ji !== it.frame) return Pt.push(t), t._lazy = [n, r], 1;
}, pn = function a3(t) {
  var e = t.parent;
  return e && e._ts && e._initted && !e._lock && (e.rawTime() < 0 || a3(e));
}, Qe = function(t) {
  var e = t.data;
  return e === "isFromStart" || e === "isStart";
}, mn = function(t, e, i, r) {
  var n = t.ratio, s = e < 0 || !e && (!t._start && pn(t) && !(!t._initted && Qe(t)) || (t._ts < 0 || t._dp._ts < 0) && !Qe(t)) ? 0 : 1, o = t._rDelay, u = 0, l, f, _;
  if (o && t._repeat && (u = ge(0, t._tDur, e), f = Ht(u, o), t._yoyo && f & 1 && (s = 1 - s), f !== Ht(t._tTime, o) && (n = 1 - s, t.vars.repeatRefresh && t._initted && t.invalidate())), s !== n || W || r || t._zTime === M || !e && t._zTime) {
    if (!t._initted && or(t, e, r, i, u)) return;
    for (_ = t._zTime, t._zTime = e || (i ? M : 0), i || (i = e && !_), t.ratio = s, t._from && (s = 1 - s), t._time = 0, t._tTime = u, l = t._pt; l; ) l.r(s, l.d), l = l._next;
    e < 0 && je(t, e, i, true), t._onUpdate && !i && rt(t, "onUpdate"), u && t._repeat && !i && t.parent && rt(t, "onRepeat"), (e >= t._tDur || e < 0) && t.ratio === s && (s && Ot(t, 1), !i && !W && (rt(t, s ? "onComplete" : "onReverseComplete", true), t._prom && t._prom()));
  } else t._zTime || (t._zTime = e);
}, gn = function(t, e, i) {
  var r;
  if (i > e) for (r = t._first; r && r._start <= i; ) {
    if (r.data === "isPause" && r._start > e) return r;
    r = r._next;
  }
  else for (r = t._last; r && r._start >= i; ) {
    if (r.data === "isPause" && r._start < e) return r;
    r = r._prev;
  }
}, Zt = function(t, e, i, r) {
  var n = t._repeat, s = N(e) || 0, o = t._tTime / t._tDur;
  return o && !r && (t._time *= s / t._dur), t._dur = s, t._tDur = n ? n < 0 ? 1e10 : N(s * (n + 1) + t._rDelay * n) : s, o > 0 && !r && Fe(t, t._tTime = t._tDur * o), t.parent && Ee(t), i || It(t.parent, t), t;
}, Mi = function(t) {
  return t instanceof j ? It(t) : Zt(t, t._dur);
}, yn = { _start: 0, endTime: he, totalDuration: he }, at = function a4(t, e, i) {
  var r = t.labels, n = t._recent || yn, s = t.duration() >= ut ? n.endTime(false) : t._dur, o, u, l;
  return q(e) && (isNaN(e) || e in r) ? (u = e.charAt(0), l = e.substr(-1) === "%", o = e.indexOf("="), u === "<" || u === ">" ? (o >= 0 && (e = e.replace(/=/, "")), (u === "<" ? n._start : n.endTime(n._repeat >= 0)) + (parseFloat(e.substr(1)) || 0) * (l ? (o < 0 ? n : i).totalDuration() / 100 : 1)) : o < 0 ? (e in r || (r[e] = s), r[e]) : (u = parseFloat(e.charAt(o - 1) + e.substr(o + 1)), l && i && (u = u / 100 * (K(i) ? i[0] : i).totalDuration()), o > 1 ? a4(t, e.substr(0, o - 1), i) + u : s + u)) : e == null ? s : +e;
}, ue = function(t, e, i) {
  var r = xt(e[1]), n = (r ? 2 : 1) + (t < 2 ? 0 : 1), s = e[n], o, u;
  if (r && (s.duration = e[1]), s.parent = i, t) {
    for (o = s, u = i; u && !("immediateRender" in o); ) o = u.vars.defaults || {}, u = Q(u.vars.inherit) && u.parent;
    s.immediateRender = Q(o.immediateRender), t < 2 ? s.runBackwards = 1 : s.startAt = e[n - 1];
  }
  return new V(e[0], s, e[n + 1]);
}, kt = function(t, e) {
  return t || t === 0 ? e(t) : e;
}, ge = function(t, e, i) {
  return i < t ? t : i > e ? e : i;
}, G = function(t, e) {
  return !q(t) || !(e = an.exec(t)) ? "" : e[1];
}, xn = function(t, e, i) {
  return kt(i, function(r) {
    return ge(t, e, r);
  });
}, He = [].slice, ar = function(t, e) {
  return t && pt(t) && "length" in t && (!e && !t.length || t.length - 1 in t && pt(t[0])) && !t.nodeType && t !== _t;
}, vn = function(t, e, i) {
  return i === void 0 && (i = []), t.forEach(function(r) {
    var n;
    return q(r) && !e || ar(r, 1) ? (n = i).push.apply(n, lt(r)) : i.push(r);
  }) || i;
}, lt = function(t, e, i) {
  return E && !e && E.selector ? E.selector(t) : q(t) && !i && (Ge || !Jt()) ? He.call((e || ui).querySelectorAll(t), 0) : K(t) ? vn(t, i) : ar(t) ? He.call(t, 0) : t ? [t] : [];
}, Ze = function(t) {
  return t = lt(t)[0] || fe("Invalid scope") || {}, function(e) {
    var i = t.current || t.nativeElement || t;
    return lt(e, i.querySelectorAll ? i : i === t ? fe("Invalid scope") || ui.createElement("div") : t);
  };
}, ur = function(t) {
  return t.sort(function() {
    return 0.5 - Math.random();
  });
}, lr = function(t) {
  if (L(t)) return t;
  var e = pt(t) ? t : { each: t }, i = Bt(e.ease), r = e.from || 0, n = parseFloat(e.base) || 0, s = {}, o = r > 0 && r < 1, u = isNaN(r) || o, l = e.axis, f = r, _ = r;
  return q(r) ? f = _ = { center: 0.5, edges: 0.5, end: 1 }[r] || 0 : !o && u && (f = r[0], _ = r[1]), function(d, c, p) {
    var h = (p || e).length, m = s[h], y, x, v, T, g, b, P, S, w;
    if (!m) {
      if (w = e.grid === "auto" ? 0 : (e.grid || [1, ut])[1], !w) {
        for (P = -ut; P < (P = p[w++].getBoundingClientRect().left) && w < h; ) ;
        w < h && w--;
      }
      for (m = s[h] = [], y = u ? Math.min(w, h) * f - 0.5 : r % w, x = w === ut ? 0 : u ? h * _ / w - 0.5 : r / w | 0, P = 0, S = ut, b = 0; b < h; b++) v = b % w - y, T = x - (b / w | 0), m[b] = g = l ? Math.abs(l === "y" ? T : v) : Xi(v * v + T * T), g > P && (P = g), g < S && (S = g);
      r === "random" && ur(m), m.max = P - S, m.min = S, m.v = h = (parseFloat(e.amount) || parseFloat(e.each) * (w > h ? h - 1 : l ? l === "y" ? h / w : w : Math.max(w, h / w)) || 0) * (r === "edges" ? -1 : 1), m.b = h < 0 ? n - h : n, m.u = G(e.amount || e.each) || 0, i = i && h < 0 ? xr(i) : i;
    }
    return h = (m[d] - m.min) / m.max || 0, N(m.b + (i ? i(h) : h) * m.v) + m.u;
  };
}, Je = function(t) {
  var e = Math.pow(10, ((t + "").split(".")[1] || "").length);
  return function(i) {
    var r = N(Math.round(parseFloat(i) / t) * t * e);
    return (r - r % 1) / e + (xt(i) ? 0 : G(i));
  };
}, fr = function(t, e) {
  var i = K(t), r, n;
  return !i && pt(t) && (r = i = t.radius || ut, t.values ? (t = lt(t.values), (n = !xt(t[0])) && (r *= r)) : t = Je(t.increment)), kt(e, i ? L(t) ? function(s) {
    return n = t(s), Math.abs(n - s) <= r ? n : s;
  } : function(s) {
    for (var o = parseFloat(n ? s.x : s), u = parseFloat(n ? s.y : 0), l = ut, f = 0, _ = t.length, d, c; _--; ) n ? (d = t[_].x - o, c = t[_].y - u, d = d * d + c * c) : d = Math.abs(t[_] - o), d < l && (l = d, f = _);
    return f = !r || l <= r ? t[f] : s, n || f === s || xt(s) ? f : f + G(s);
  } : Je(t));
}, hr = function(t, e, i, r) {
  return kt(K(t) ? !e : i === true ? !!(i = 0) : !r, function() {
    return K(t) ? t[~~(Math.random() * t.length)] : (i = i || 1e-5) && (r = i < 1 ? Math.pow(10, (i + "").length - 2) : 1) && Math.floor(Math.round((t - i / 2 + Math.random() * (e - t + i * 0.99)) / i) * i * r) / r;
  });
}, Tn = function() {
  for (var t = arguments.length, e = new Array(t), i = 0; i < t; i++) e[i] = arguments[i];
  return function(r) {
    return e.reduce(function(n, s) {
      return s(n);
    }, r);
  };
}, wn = function(t, e) {
  return function(i) {
    return t(parseFloat(i)) + (e || G(i));
  };
}, bn = function(t, e, i) {
  return cr(t, e, 0, 1, i);
}, _r = function(t, e, i) {
  return kt(i, function(r) {
    return t[~~e(r)];
  });
}, Pn = function a5(t, e, i) {
  var r = e - t;
  return K(t) ? _r(t, a5(0, t.length), e) : kt(i, function(n) {
    return (r + (n - t) % r) % r + t;
  });
}, Sn = function a6(t, e, i) {
  var r = e - t, n = r * 2;
  return K(t) ? _r(t, a6(0, t.length - 1), e) : kt(i, function(s) {
    return s = (n + (s - t) % n) % n || 0, t + (s > r ? n - s : s);
  });
}, _e = function(t) {
  for (var e = 0, i = "", r, n, s, o; ~(r = t.indexOf("random(", e)); ) s = t.indexOf(")", r), o = t.charAt(r + 7) === "[", n = t.substr(r + 7, s - r - 7).match(o ? ji : We), i += t.substr(e, r - e) + hr(o ? n : +n[0], o ? 0 : +n[1], +n[2] || 1e-5), e = s + 1;
  return i + t.substr(e, t.length - e);
}, cr = function(t, e, i, r, n) {
  var s = e - t, o = r - i;
  return kt(n, function(u) {
    return i + ((u - t) / s * o || 0);
  });
}, On = function a7(t, e, i, r) {
  var n = isNaN(t + e) ? 0 : function(c) {
    return (1 - c) * t + c * e;
  };
  if (!n) {
    var s = q(t), o = {}, u, l, f, _, d;
    if (i === true && (r = 1) && (i = null), s) t = { p: t }, e = { p: e };
    else if (K(t) && !K(e)) {
      for (f = [], _ = t.length, d = _ - 2, l = 1; l < _; l++) f.push(a7(t[l - 1], t[l]));
      _--, n = function(p) {
        p *= _;
        var h = Math.min(d, ~~p);
        return f[h](p - h);
      }, i = e;
    } else r || (t = Qt(K(t) ? [] : {}, t));
    if (!f) {
      for (u in e) di.call(o, t, u, "get", e[u]);
      n = function(p) {
        return yi(p, o) || (s ? t.p : t);
      };
    }
  }
  return kt(i, n);
}, Di = function(t, e, i) {
  var r = t.labels, n = ut, s, o, u;
  for (s in r) o = r[s] - e, o < 0 == !!i && o && n > (o = Math.abs(o)) && (u = s, n = o);
  return u;
}, rt = function(t, e, i) {
  var r = t.vars, n = r[e], s = E, o = t._ctx, u, l, f;
  if (n) return u = r[e + "Params"], l = r.callbackScope || t, i && Pt.length && Oe(), o && (E = o), f = u ? n.apply(l, u) : n.call(l), E = s, f;
}, se = function(t) {
  return Ot(t), t.scrollTrigger && t.scrollTrigger.kill(!!W), t.progress() < 1 && rt(t, "onInterrupt"), t;
}, Xt, dr = [], pr = function(t) {
  if (t) if (t = !t.name && t.default || t, ai() || t.headless) {
    var e = t.name, i = L(t), r = e && !i && t.init ? function() {
      this._props = [];
    } : t, n = { init: he, render: yi, add: di, kill: Yn, modifier: Un, rawVars: 0 }, s = { targetTest: 0, get: 0, getSetter: gi, aliases: {}, register: 0 };
    if (Jt(), t !== r) {
      if (et[e]) return;
      ot(r, ot(Ce(t, n), s)), Qt(r.prototype, Qt(n, Ce(t, s))), et[r.prop = e] = r, t.targetTest && (be.push(r), fi[e] = 1), e = (e === "css" ? "CSS" : e.charAt(0).toUpperCase() + e.substr(1)) + "Plugin";
    }
    Zi(e, r), t.register && t.register($, r, Z);
  } else dr.push(t);
}, k = 255, oe = { aqua: [0, k, k], lime: [0, k, 0], silver: [192, 192, 192], black: [0, 0, 0], maroon: [128, 0, 0], teal: [0, 128, 128], blue: [0, 0, k], navy: [0, 0, 128], white: [k, k, k], olive: [128, 128, 0], yellow: [k, k, 0], orange: [k, 165, 0], gray: [128, 128, 128], purple: [128, 0, 128], green: [0, 128, 0], red: [k, 0, 0], pink: [k, 192, 203], cyan: [0, k, k], transparent: [k, k, k, 0] }, Be = function(t, e, i) {
  return t += t < 0 ? 1 : t > 1 ? -1 : 0, (t * 6 < 1 ? e + (i - e) * t * 6 : t < 0.5 ? i : t * 3 < 2 ? e + (i - e) * (2 / 3 - t) * 6 : e) * k + 0.5 | 0;
}, mr = function(t, e, i) {
  var r = t ? xt(t) ? [t >> 16, t >> 8 & k, t & k] : 0 : oe.black, n, s, o, u, l, f, _, d, c, p;
  if (!r) {
    if (t.substr(-1) === "," && (t = t.substr(0, t.length - 1)), oe[t]) r = oe[t];
    else if (t.charAt(0) === "#") {
      if (t.length < 6 && (n = t.charAt(1), s = t.charAt(2), o = t.charAt(3), t = "#" + n + n + s + s + o + o + (t.length === 5 ? t.charAt(4) + t.charAt(4) : "")), t.length === 9) return r = parseInt(t.substr(1, 6), 16), [r >> 16, r >> 8 & k, r & k, parseInt(t.substr(7), 16) / 255];
      t = parseInt(t.substr(1), 16), r = [t >> 16, t >> 8 & k, t & k];
    } else if (t.substr(0, 3) === "hsl") {
      if (r = p = t.match(We), !e) u = +r[0] % 360 / 360, l = +r[1] / 100, f = +r[2] / 100, s = f <= 0.5 ? f * (l + 1) : f + l - f * l, n = f * 2 - s, r.length > 3 && (r[3] *= 1), r[0] = Be(u + 1 / 3, n, s), r[1] = Be(u, n, s), r[2] = Be(u - 1 / 3, n, s);
      else if (~t.indexOf("=")) return r = t.match(Gi), i && r.length < 4 && (r[3] = 1), r;
    } else r = t.match(We) || oe.transparent;
    r = r.map(Number);
  }
  return e && !p && (n = r[0] / k, s = r[1] / k, o = r[2] / k, _ = Math.max(n, s, o), d = Math.min(n, s, o), f = (_ + d) / 2, _ === d ? u = l = 0 : (c = _ - d, l = f > 0.5 ? c / (2 - _ - d) : c / (_ + d), u = _ === n ? (s - o) / c + (s < o ? 6 : 0) : _ === s ? (o - n) / c + 2 : (n - s) / c + 4, u *= 60), r[0] = ~~(u + 0.5), r[1] = ~~(l * 100 + 0.5), r[2] = ~~(f * 100 + 0.5)), i && r.length < 4 && (r[3] = 1), r;
}, gr = function(t) {
  var e = [], i = [], r = -1;
  return t.split(St).forEach(function(n) {
    var s = n.match(qt) || [];
    e.push.apply(e, s), i.push(r += s.length + 1);
  }), e.c = i, e;
}, Ai = function(t, e, i) {
  var r = "", n = (t + r).match(St), s = e ? "hsla(" : "rgba(", o = 0, u, l, f, _;
  if (!n) return t;
  if (n = n.map(function(d) {
    return (d = mr(d, e, 1)) && s + (e ? d[0] + "," + d[1] + "%," + d[2] + "%," + d[3] : d.join(",")) + ")";
  }), i && (f = gr(t), u = i.c, u.join(r) !== f.c.join(r))) for (l = t.replace(St, "1").split(qt), _ = l.length - 1; o < _; o++) r += l[o] + (~u.indexOf(o) ? n.shift() || s + "0,0,0,0)" : (f.length ? f : n.length ? n : i).shift());
  if (!l) for (l = t.split(St), _ = l.length - 1; o < _; o++) r += l[o] + n[o];
  return r + l[_];
}, St = (function() {
  var a15 = "(?:\\b(?:(?:rgb|rgba|hsl|hsla)\\(.+?\\))|\\B#(?:[0-9a-f]{3,4}){1,2}\\b", t;
  for (t in oe) a15 += "|" + t + "\\b";
  return new RegExp(a15 + ")", "gi");
})(), Cn = /hsl[a]?\(/, yr = function(t) {
  var e = t.join(" "), i;
  if (St.lastIndex = 0, St.test(e)) return i = Cn.test(e), t[1] = Ai(t[1], i), t[0] = Ai(t[0], i, gr(t[1])), true;
}, ce, it = (function() {
  var a15 = Date.now, t = 500, e = 33, i = a15(), r = i, n = 1e3 / 240, s = n, o = [], u, l, f, _, d, c, p = function h(m) {
    var y = a15() - r, x = m === true, v, T, g, b;
    if ((y > t || y < 0) && (i += y - e), r += y, g = r - i, v = g - s, (v > 0 || x) && (b = ++_.frame, d = g - _.time * 1e3, _.time = g = g / 1e3, s += v + (v >= n ? 4 : n - v), T = 1), x || (u = l(h)), T) for (c = 0; c < o.length; c++) o[c](g, d, b, m);
  };
  return _ = { time: 0, frame: 0, tick: function() {
    p(true);
  }, deltaRatio: function(m) {
    return d / (1e3 / (m || 60));
  }, wake: function() {
    Qi && (!Ge && ai() && (_t = Ge = window, ui = _t.document || {}, st.gsap = $, (_t.gsapVersions || (_t.gsapVersions = [])).push($.version), Hi(Se || _t.GreenSockGlobals || !_t.gsap && _t || {}), dr.forEach(pr)), f = typeof requestAnimationFrame < "u" && requestAnimationFrame, u && _.sleep(), l = f || function(m) {
      return setTimeout(m, s - _.time * 1e3 + 1 | 0);
    }, ce = 1, p(2));
  }, sleep: function() {
    (f ? cancelAnimationFrame : clearTimeout)(u), ce = 0, l = he;
  }, lagSmoothing: function(m, y) {
    t = m || 1 / 0, e = Math.min(y || 33, t);
  }, fps: function(m) {
    n = 1e3 / (m || 240), s = _.time * 1e3 + n;
  }, add: function(m, y, x) {
    var v = y ? function(T, g, b, P) {
      m(T, g, b, P), _.remove(v);
    } : m;
    return _.remove(m), o[x ? "unshift" : "push"](v), Jt(), v;
  }, remove: function(m, y) {
    ~(y = o.indexOf(m)) && o.splice(y, 1) && c >= y && c--;
  }, _listeners: o }, _;
})(), Jt = function() {
  return !ce && it.wake();
}, O = {}, kn = /^[\d.\-M][\d.\-,\s]/, Mn = /["']/g, Dn = function(t) {
  for (var e = {}, i = t.substr(1, t.length - 3).split(":"), r = i[0], n = 1, s = i.length, o, u, l; n < s; n++) u = i[n], o = n !== s - 1 ? u.lastIndexOf(",") : u.length, l = u.substr(0, o), e[r] = isNaN(l) ? l.replace(Mn, "").trim() : +l, r = u.substr(o + 1).trim();
  return e;
}, An = function(t) {
  var e = t.indexOf("(") + 1, i = t.indexOf(")"), r = t.indexOf("(", e);
  return t.substring(e, ~r && r < i ? t.indexOf(")", i + 1) : i);
}, Rn = function(t) {
  var e = (t + "").split("("), i = O[e[0]];
  return i && e.length > 1 && i.config ? i.config.apply(null, ~t.indexOf("{") ? [Dn(e[1])] : An(t).split(",").map(er)) : O._CE && kn.test(t) ? O._CE("", t) : i;
}, xr = function(t) {
  return function(e) {
    return 1 - t(1 - e);
  };
}, vr = function a8(t, e) {
  for (var i = t._first, r; i; ) i instanceof j ? a8(i, e) : i.vars.yoyoEase && (!i._yoyo || !i._repeat) && i._yoyo !== e && (i.timeline ? a8(i.timeline, e) : (r = i._ease, i._ease = i._yEase, i._yEase = r, i._yoyo = e)), i = i._next;
}, Bt = function(t, e) {
  return t && (L(t) ? t : O[t] || Rn(t)) || e;
}, Ut = function(t, e, i, r) {
  i === void 0 && (i = function(u) {
    return 1 - e(1 - u);
  }), r === void 0 && (r = function(u) {
    return u < 0.5 ? e(u * 2) / 2 : 1 - e((1 - u) * 2) / 2;
  });
  var n = { easeIn: e, easeOut: i, easeInOut: r }, s;
  return H(t, function(o) {
    O[o] = st[o] = n, O[s = o.toLowerCase()] = i;
    for (var u in n) O[s + (u === "easeIn" ? ".in" : u === "easeOut" ? ".out" : ".inOut")] = O[o + "." + u] = n[u];
  }), n;
}, Tr = function(t) {
  return function(e) {
    return e < 0.5 ? (1 - t(1 - e * 2)) / 2 : 0.5 + t((e - 0.5) * 2) / 2;
  };
}, Ve = function a9(t, e, i) {
  var r = e >= 1 ? e : 1, n = (i || (t ? 0.3 : 0.45)) / (e < 1 ? e : 1), s = n / Xe * (Math.asin(1 / r) || 0), o = function(f) {
    return f === 1 ? 1 : r * Math.pow(2, -10 * f) * on((f - s) * n) + 1;
  }, u = t === "out" ? o : t === "in" ? function(l) {
    return 1 - o(1 - l);
  } : Tr(o);
  return n = Xe / n, u.config = function(l, f) {
    return a9(t, l, f);
  }, u;
}, Ne = function a10(t, e) {
  e === void 0 && (e = 1.70158);
  var i = function(s) {
    return s ? --s * s * ((e + 1) * s + e) + 1 : 0;
  }, r = t === "out" ? i : t === "in" ? function(n) {
    return 1 - i(1 - n);
  } : Tr(i);
  return r.config = function(n) {
    return a10(t, n);
  }, r;
};
H("Linear,Quad,Cubic,Quart,Quint,Strong", function(a15, t) {
  var e = t < 5 ? t + 1 : t;
  Ut(a15 + ",Power" + (e - 1), t ? function(i) {
    return Math.pow(i, e);
  } : function(i) {
    return i;
  }, function(i) {
    return 1 - Math.pow(1 - i, e);
  }, function(i) {
    return i < 0.5 ? Math.pow(i * 2, e) / 2 : 1 - Math.pow((1 - i) * 2, e) / 2;
  });
});
O.Linear.easeNone = O.none = O.Linear.easeIn;
Ut("Elastic", Ve("in"), Ve("out"), Ve());
(function(a15, t) {
  var e = 1 / t, i = 2 * e, r = 2.5 * e, n = function(o) {
    return o < e ? a15 * o * o : o < i ? a15 * Math.pow(o - 1.5 / t, 2) + 0.75 : o < r ? a15 * (o -= 2.25 / t) * o + 0.9375 : a15 * Math.pow(o - 2.625 / t, 2) + 0.984375;
  };
  Ut("Bounce", function(s) {
    return 1 - n(1 - s);
  }, n);
})(7.5625, 2.75);
Ut("Expo", function(a15) {
  return Math.pow(2, 10 * (a15 - 1)) * a15 + a15 * a15 * a15 * a15 * a15 * a15 * (1 - a15);
});
Ut("Circ", function(a15) {
  return -(Xi(1 - a15 * a15) - 1);
});
Ut("Sine", function(a15) {
  return a15 === 1 ? 1 : -sn(a15 * rn) + 1;
});
Ut("Back", Ne("in"), Ne("out"), Ne());
O.SteppedEase = O.steps = st.SteppedEase = { config: function(t, e) {
  t === void 0 && (t = 1);
  var i = 1 / t, r = t + (e ? 0 : 1), n = e ? 1 : 0, s = 1 - M;
  return function(o) {
    return ((r * ge(0, s, o) | 0) + n) * i;
  };
} };
jt.ease = O["quad.out"];
H("onComplete,onUpdate,onStart,onRepeat,onReverseComplete,onInterrupt", function(a15) {
  return hi += a15 + "," + a15 + "Params,";
});
var wr = function(t, e) {
  this.id = nn++, t._gsap = this, this.target = t, this.harness = e, this.get = e ? e.get : $i, this.set = e ? e.getSetter : gi;
}, de = (function() {
  function a15(e) {
    this.vars = e, this._delay = +e.delay || 0, (this._repeat = e.repeat === 1 / 0 ? -2 : e.repeat || 0) && (this._rDelay = e.repeatDelay || 0, this._yoyo = !!e.yoyo || !!e.yoyoEase), this._ts = 1, Zt(this, +e.duration, 1, 1), this.data = e.data, E && (this._ctx = E, E.data.push(this)), ce || it.wake();
  }
  var t = a15.prototype;
  return t.delay = function(i) {
    return i || i === 0 ? (this.parent && this.parent.smoothChildTiming && this.startTime(this._start + i - this._delay), this._delay = i, this) : this._delay;
  }, t.duration = function(i) {
    return arguments.length ? this.totalDuration(this._repeat > 0 ? i + (i + this._rDelay) * this._repeat : i) : this.totalDuration() && this._dur;
  }, t.totalDuration = function(i) {
    return arguments.length ? (this._dirty = 0, Zt(this, this._repeat < 0 ? i : (i - this._repeat * this._rDelay) / (this._repeat + 1))) : this._tDur;
  }, t.totalTime = function(i, r) {
    if (Jt(), !arguments.length) return this._tTime;
    var n = this._dp;
    if (n && n.smoothChildTiming && this._ts) {
      for (Fe(this, i), !n._dp || n.parent || nr(n, this); n && n.parent; ) n.parent._time !== n._start + (n._ts >= 0 ? n._tTime / n._ts : (n.totalDuration() - n._tTime) / -n._ts) && n.totalTime(n._tTime, true), n = n.parent;
      !this.parent && this._dp.autoRemoveChildren && (this._ts > 0 && i < this._tDur || this._ts < 0 && i > 0 || !this._tDur && !i) && ct(this._dp, this, this._start - this._delay);
    }
    return (this._tTime !== i || !this._dur && !r || this._initted && Math.abs(this._zTime) === M || !i && !this._initted && (this.add || this._ptLookup)) && (this._ts || (this._pTime = i), tr(this, i, r)), this;
  }, t.time = function(i, r) {
    return arguments.length ? this.totalTime(Math.min(this.totalDuration(), i + ki(this)) % (this._dur + this._rDelay) || (i ? this._dur : 0), r) : this._time;
  }, t.totalProgress = function(i, r) {
    return arguments.length ? this.totalTime(this.totalDuration() * i, r) : this.totalDuration() ? Math.min(1, this._tTime / this._tDur) : this.rawTime() >= 0 && this._initted ? 1 : 0;
  }, t.progress = function(i, r) {
    return arguments.length ? this.totalTime(this.duration() * (this._yoyo && !(this.iteration() & 1) ? 1 - i : i) + ki(this), r) : this.duration() ? Math.min(1, this._time / this._dur) : this.rawTime() > 0 ? 1 : 0;
  }, t.iteration = function(i, r) {
    var n = this.duration() + this._rDelay;
    return arguments.length ? this.totalTime(this._time + (i - 1) * n, r) : this._repeat ? Ht(this._tTime, n) + 1 : 1;
  }, t.timeScale = function(i, r) {
    if (!arguments.length) return this._rts === -M ? 0 : this._rts;
    if (this._rts === i) return this;
    var n = this.parent && this._ts ? ke(this.parent._time, this) : this._tTime;
    return this._rts = +i || 0, this._ts = this._ps || i === -M ? 0 : this._rts, this.totalTime(ge(-Math.abs(this._delay), this.totalDuration(), n), r !== false), Ee(this), cn(this);
  }, t.paused = function(i) {
    return arguments.length ? (this._ps !== i && (this._ps = i, i ? (this._pTime = this._tTime || Math.max(-this._delay, this.rawTime()), this._ts = this._act = 0) : (Jt(), this._ts = this._rts, this.totalTime(this.parent && !this.parent.smoothChildTiming ? this.rawTime() : this._tTime || this._pTime, this.progress() === 1 && Math.abs(this._zTime) !== M && (this._tTime -= M)))), this) : this._ps;
  }, t.startTime = function(i) {
    if (arguments.length) {
      this._start = i;
      var r = this.parent || this._dp;
      return r && (r._sort || !this.parent) && ct(r, this, i - this._delay), this;
    }
    return this._start;
  }, t.endTime = function(i) {
    return this._start + (Q(i) ? this.totalDuration() : this.duration()) / Math.abs(this._ts || 1);
  }, t.rawTime = function(i) {
    var r = this.parent || this._dp;
    return r ? i && (!this._ts || this._repeat && this._time && this.totalProgress() < 1) ? this._tTime % (this._dur + this._rDelay) : this._ts ? ke(r.rawTime(i), this) : this._tTime : this._tTime;
  }, t.revert = function(i) {
    i === void 0 && (i = ln);
    var r = W;
    return W = i, ci(this) && (this.timeline && this.timeline.revert(i), this.totalTime(-0.01, i.suppressEvents)), this.data !== "nested" && i.kill !== false && this.kill(), W = r, this;
  }, t.globalTime = function(i) {
    for (var r = this, n = arguments.length ? i : r.rawTime(); r; ) n = r._start + n / (Math.abs(r._ts) || 1), r = r._dp;
    return !this.parent && this._sat ? this._sat.globalTime(i) : n;
  }, t.repeat = function(i) {
    return arguments.length ? (this._repeat = i === 1 / 0 ? -2 : i, Mi(this)) : this._repeat === -2 ? 1 / 0 : this._repeat;
  }, t.repeatDelay = function(i) {
    if (arguments.length) {
      var r = this._time;
      return this._rDelay = i, Mi(this), r ? this.time(r) : this;
    }
    return this._rDelay;
  }, t.yoyo = function(i) {
    return arguments.length ? (this._yoyo = i, this) : this._yoyo;
  }, t.seek = function(i, r) {
    return this.totalTime(at(this, i), Q(r));
  }, t.restart = function(i, r) {
    return this.play().totalTime(i ? -this._delay : 0, Q(r)), this._dur || (this._zTime = -M), this;
  }, t.play = function(i, r) {
    return i != null && this.seek(i, r), this.reversed(false).paused(false);
  }, t.reverse = function(i, r) {
    return i != null && this.seek(i || this.totalDuration(), r), this.reversed(true).paused(false);
  }, t.pause = function(i, r) {
    return i != null && this.seek(i, r), this.paused(true);
  }, t.resume = function() {
    return this.paused(false);
  }, t.reversed = function(i) {
    return arguments.length ? (!!i !== this.reversed() && this.timeScale(-this._rts || (i ? -M : 0)), this) : this._rts < 0;
  }, t.invalidate = function() {
    return this._initted = this._act = 0, this._zTime = -M, this;
  }, t.isActive = function() {
    var i = this.parent || this._dp, r = this._start, n;
    return !!(!i || this._ts && this._initted && i.isActive() && (n = i.rawTime(true)) >= r && n < this.endTime(true) - M);
  }, t.eventCallback = function(i, r, n) {
    var s = this.vars;
    return arguments.length > 1 ? (r ? (s[i] = r, n && (s[i + "Params"] = n), i === "onUpdate" && (this._onUpdate = r)) : delete s[i], this) : s[i];
  }, t.then = function(i) {
    var r = this;
    return new Promise(function(n) {
      var s = L(i) ? i : ir, o = function() {
        var l = r.then;
        r.then = null, L(s) && (s = s(r)) && (s.then || s === r) && (r.then = l), n(s), r.then = l;
      };
      r._initted && r.totalProgress() === 1 && r._ts >= 0 || !r._tTime && r._ts < 0 ? o() : r._prom = o;
    });
  }, t.kill = function() {
    se(this);
  }, a15;
})();
ot(de.prototype, { _time: 0, _start: 0, _end: 0, _tTime: 0, _tDur: 0, _dirty: 0, _repeat: 0, _yoyo: false, parent: null, _initted: false, _rDelay: 0, _ts: 1, _dp: 0, ratio: 0, _zTime: -M, _prom: 0, _ps: false, _rts: 1 });
var j = (function(a15) {
  qi(t, a15);
  function t(i, r) {
    var n;
    return i === void 0 && (i = {}), n = a15.call(this, i) || this, n.labels = {}, n.smoothChildTiming = !!i.smoothChildTiming, n.autoRemoveChildren = !!i.autoRemoveChildren, n._sort = Q(i.sortChildren), F && ct(i.parent || F, gt(n), r), i.reversed && n.reverse(), i.paused && n.paused(true), i.scrollTrigger && sr(gt(n), i.scrollTrigger), n;
  }
  var e = t.prototype;
  return e.to = function(r, n, s) {
    return ue(0, arguments, this), this;
  }, e.from = function(r, n, s) {
    return ue(1, arguments, this), this;
  }, e.fromTo = function(r, n, s, o) {
    return ue(2, arguments, this), this;
  }, e.set = function(r, n, s) {
    return n.duration = 0, n.parent = this, ae(n).repeatDelay || (n.repeat = 0), n.immediateRender = !!n.immediateRender, new V(r, n, at(this, s), 1), this;
  }, e.call = function(r, n, s) {
    return ct(this, V.delayedCall(0, r, n), s);
  }, e.staggerTo = function(r, n, s, o, u, l, f) {
    return s.duration = n, s.stagger = s.stagger || o, s.onComplete = l, s.onCompleteParams = f, s.parent = this, new V(r, s, at(this, u)), this;
  }, e.staggerFrom = function(r, n, s, o, u, l, f) {
    return s.runBackwards = 1, ae(s).immediateRender = Q(s.immediateRender), this.staggerTo(r, n, s, o, u, l, f);
  }, e.staggerFromTo = function(r, n, s, o, u, l, f, _) {
    return o.startAt = s, ae(o).immediateRender = Q(o.immediateRender), this.staggerTo(r, n, o, u, l, f, _);
  }, e.render = function(r, n, s) {
    var o = this._time, u = this._dirty ? this.totalDuration() : this._tDur, l = this._dur, f = r <= 0 ? 0 : N(r), _ = this._zTime < 0 != r < 0 && (this._initted || !l), d, c, p, h, m, y, x, v, T, g, b, P;
    if (this !== F && f > u && r >= 0 && (f = u), f !== this._tTime || s || _) {
      if (o !== this._time && l && (f += this._time - o, r += this._time - o), d = f, T = this._start, v = this._ts, y = !v, _ && (l || (o = this._zTime), (r || !n) && (this._zTime = r)), this._repeat) {
        if (b = this._yoyo, m = l + this._rDelay, this._repeat < -1 && r < 0) return this.totalTime(m * 100 + r, n, s);
        if (d = N(f % m), f === u ? (h = this._repeat, d = l) : (g = N(f / m), h = ~~g, h && h === g && (d = l, h--), d > l && (d = l)), g = Ht(this._tTime, m), !o && this._tTime && g !== h && this._tTime - g * m - this._dur <= 0 && (g = h), b && h & 1 && (d = l - d, P = 1), h !== g && !this._lock) {
          var S = b && g & 1, w = S === (b && h & 1);
          if (h < g && (S = !S), o = S ? 0 : f % l ? l : f, this._lock = 1, this.render(o || (P ? 0 : N(h * m)), n, !l)._lock = 0, this._tTime = f, !n && this.parent && rt(this, "onRepeat"), this.vars.repeatRefresh && !P && (this.invalidate()._lock = 1), o && o !== this._time || y !== !this._ts || this.vars.onRepeat && !this.parent && !this._act) return this;
          if (l = this._dur, u = this._tDur, w && (this._lock = 2, o = S ? l : -1e-4, this.render(o, true), this.vars.repeatRefresh && !P && this.invalidate()), this._lock = 0, !this._ts && !y) return this;
          vr(this, P);
        }
      }
      if (this._hasPause && !this._forcing && this._lock < 2 && (x = gn(this, N(o), N(d)), x && (f -= d - (d = x._start))), this._tTime = f, this._time = d, this._act = !v, this._initted || (this._onUpdate = this.vars.onUpdate, this._initted = 1, this._zTime = r, o = 0), !o && f && !n && !g && (rt(this, "onStart"), this._tTime !== f)) return this;
      if (d >= o && r >= 0) for (c = this._first; c; ) {
        if (p = c._next, (c._act || d >= c._start) && c._ts && x !== c) {
          if (c.parent !== this) return this.render(r, n, s);
          if (c.render(c._ts > 0 ? (d - c._start) * c._ts : (c._dirty ? c.totalDuration() : c._tDur) + (d - c._start) * c._ts, n, s), d !== this._time || !this._ts && !y) {
            x = 0, p && (f += this._zTime = -M);
            break;
          }
        }
        c = p;
      }
      else {
        c = this._last;
        for (var C = r < 0 ? r : d; c; ) {
          if (p = c._prev, (c._act || C <= c._end) && c._ts && x !== c) {
            if (c.parent !== this) return this.render(r, n, s);
            if (c.render(c._ts > 0 ? (C - c._start) * c._ts : (c._dirty ? c.totalDuration() : c._tDur) + (C - c._start) * c._ts, n, s || W && ci(c)), d !== this._time || !this._ts && !y) {
              x = 0, p && (f += this._zTime = C ? -M : M);
              break;
            }
          }
          c = p;
        }
      }
      if (x && !n && (this.pause(), x.render(d >= o ? 0 : -M)._zTime = d >= o ? 1 : -1, this._ts)) return this._start = T, Ee(this), this.render(r, n, s);
      this._onUpdate && !n && rt(this, "onUpdate", true), (f === u && this._tTime >= this.totalDuration() || !f && o) && (T === this._start || Math.abs(v) !== Math.abs(this._ts)) && (this._lock || ((r || !l) && (f === u && this._ts > 0 || !f && this._ts < 0) && Ot(this, 1), !n && !(r < 0 && !o) && (f || o || !u) && (rt(this, f === u && r >= 0 ? "onComplete" : "onReverseComplete", true), this._prom && !(f < u && this.timeScale() > 0) && this._prom())));
    }
    return this;
  }, e.add = function(r, n) {
    var s = this;
    if (xt(n) || (n = at(this, n, r)), !(r instanceof de)) {
      if (K(r)) return r.forEach(function(o) {
        return s.add(o, n);
      }), this;
      if (q(r)) return this.addLabel(r, n);
      if (L(r)) r = V.delayedCall(0, r);
      else return this;
    }
    return this !== r ? ct(this, r, n) : this;
  }, e.getChildren = function(r, n, s, o) {
    r === void 0 && (r = true), n === void 0 && (n = true), s === void 0 && (s = true), o === void 0 && (o = -ut);
    for (var u = [], l = this._first; l; ) l._start >= o && (l instanceof V ? n && u.push(l) : (s && u.push(l), r && u.push.apply(u, l.getChildren(true, n, s)))), l = l._next;
    return u;
  }, e.getById = function(r) {
    for (var n = this.getChildren(1, 1, 1), s = n.length; s--; ) if (n[s].vars.id === r) return n[s];
  }, e.remove = function(r) {
    return q(r) ? this.removeLabel(r) : L(r) ? this.killTweensOf(r) : (r.parent === this && Re(this, r), r === this._recent && (this._recent = this._last), It(this));
  }, e.totalTime = function(r, n) {
    return arguments.length ? (this._forcing = 1, !this._dp && this._ts && (this._start = N(it.time - (this._ts > 0 ? r / this._ts : (this.totalDuration() - r) / -this._ts))), a15.prototype.totalTime.call(this, r, n), this._forcing = 0, this) : this._tTime;
  }, e.addLabel = function(r, n) {
    return this.labels[r] = at(this, n), this;
  }, e.removeLabel = function(r) {
    return delete this.labels[r], this;
  }, e.addPause = function(r, n, s) {
    var o = V.delayedCall(0, n || he, s);
    return o.data = "isPause", this._hasPause = 1, ct(this, o, at(this, r));
  }, e.removePause = function(r) {
    var n = this._first;
    for (r = at(this, r); n; ) n._start === r && n.data === "isPause" && Ot(n), n = n._next;
  }, e.killTweensOf = function(r, n, s) {
    for (var o = this.getTweensOf(r, s), u = o.length; u--; ) Tt !== o[u] && o[u].kill(r, n);
    return this;
  }, e.getTweensOf = function(r, n) {
    for (var s = [], o = lt(r), u = this._first, l = xt(n), f; u; ) u instanceof V ? fn(u._targets, o) && (l ? (!Tt || u._initted && u._ts) && u.globalTime(0) <= n && u.globalTime(u.totalDuration()) > n : !n || u.isActive()) && s.push(u) : (f = u.getTweensOf(o, n)).length && s.push.apply(s, f), u = u._next;
    return s;
  }, e.tweenTo = function(r, n) {
    n = n || {};
    var s = this, o = at(s, r), u = n, l = u.startAt, f = u.onStart, _ = u.onStartParams, d = u.immediateRender, c, p = V.to(s, ot({ ease: n.ease || "none", lazy: false, immediateRender: false, time: o, overwrite: "auto", duration: n.duration || Math.abs((o - (l && "time" in l ? l.time : s._time)) / s.timeScale()) || M, onStart: function() {
      if (s.pause(), !c) {
        var m = n.duration || Math.abs((o - (l && "time" in l ? l.time : s._time)) / s.timeScale());
        p._dur !== m && Zt(p, m, 0, 1).render(p._time, true, true), c = 1;
      }
      f && f.apply(p, _ || []);
    } }, n));
    return d ? p.render(0) : p;
  }, e.tweenFromTo = function(r, n, s) {
    return this.tweenTo(n, ot({ startAt: { time: at(this, r) } }, s));
  }, e.recent = function() {
    return this._recent;
  }, e.nextLabel = function(r) {
    return r === void 0 && (r = this._time), Di(this, at(this, r));
  }, e.previousLabel = function(r) {
    return r === void 0 && (r = this._time), Di(this, at(this, r), 1);
  }, e.currentLabel = function(r) {
    return arguments.length ? this.seek(r, true) : this.previousLabel(this._time + M);
  }, e.shiftChildren = function(r, n, s) {
    s === void 0 && (s = 0);
    for (var o = this._first, u = this.labels, l; o; ) o._start >= s && (o._start += r, o._end += r), o = o._next;
    if (n) for (l in u) u[l] >= s && (u[l] += r);
    return It(this);
  }, e.invalidate = function(r) {
    var n = this._first;
    for (this._lock = 0; n; ) n.invalidate(r), n = n._next;
    return a15.prototype.invalidate.call(this, r);
  }, e.clear = function(r) {
    r === void 0 && (r = true);
    for (var n = this._first, s; n; ) s = n._next, this.remove(n), n = s;
    return this._dp && (this._time = this._tTime = this._pTime = 0), r && (this.labels = {}), It(this);
  }, e.totalDuration = function(r) {
    var n = 0, s = this, o = s._last, u = ut, l, f, _;
    if (arguments.length) return s.timeScale((s._repeat < 0 ? s.duration() : s.totalDuration()) / (s.reversed() ? -r : r));
    if (s._dirty) {
      for (_ = s.parent; o; ) l = o._prev, o._dirty && o.totalDuration(), f = o._start, f > u && s._sort && o._ts && !s._lock ? (s._lock = 1, ct(s, o, f - o._delay, 1)._lock = 0) : u = f, f < 0 && o._ts && (n -= f, (!_ && !s._dp || _ && _.smoothChildTiming) && (s._start += f / s._ts, s._time -= f, s._tTime -= f), s.shiftChildren(-f, false, -1 / 0), u = 0), o._end > n && o._ts && (n = o._end), o = l;
      Zt(s, s === F && s._time > n ? s._time : n, 1, 1), s._dirty = 0;
    }
    return s._tDur;
  }, t.updateRoot = function(r) {
    if (F._ts && (tr(F, ke(r, F)), Ji = it.frame), it.frame >= Oi) {
      Oi += nt.autoSleep || 120;
      var n = F._first;
      if ((!n || !n._ts) && nt.autoSleep && it._listeners.length < 2) {
        for (; n && !n._ts; ) n = n._next;
        n || it.sleep();
      }
    }
  }, t;
})(de);
ot(j.prototype, { _lock: 0, _hasPause: 0, _forcing: 0 });
var En = function(t, e, i, r, n, s, o) {
  var u = new Z(this._pt, t, e, 0, 1, kr, null, n), l = 0, f = 0, _, d, c, p, h, m, y, x;
  for (u.b = i, u.e = r, i += "", r += "", (y = ~r.indexOf("random(")) && (r = _e(r)), s && (x = [i, r], s(x, t, e), i = x[0], r = x[1]), d = i.match(Le) || []; _ = Le.exec(r); ) p = _[0], h = r.substring(l, _.index), c ? c = (c + 1) % 5 : h.substr(-5) === "rgba(" && (c = 1), p !== d[f++] && (m = parseFloat(d[f - 1]) || 0, u._pt = { _next: u._pt, p: h || f === 1 ? h : ",", s: m, c: p.charAt(1) === "=" ? Wt(m, p) - m : parseFloat(p) - m, m: c && c < 4 ? Math.round : 0 }, l = Le.lastIndex);
  return u.c = l < r.length ? r.substring(l, r.length) : "", u.fp = o, (Ki.test(r) || y) && (u.e = 0), this._pt = u, u;
}, di = function(t, e, i, r, n, s, o, u, l, f) {
  L(r) && (r = r(n || 0, t, s));
  var _ = t[e], d = i !== "get" ? i : L(_) ? l ? t[e.indexOf("set") || !L(t["get" + e.substr(3)]) ? e : "get" + e.substr(3)](l) : t[e]() : _, c = L(_) ? l ? Bn : Or : mi, p;
  if (q(r) && (~r.indexOf("random(") && (r = _e(r)), r.charAt(1) === "=" && (p = Wt(d, r) + (G(d) || 0), (p || p === 0) && (r = p))), !f || d !== r || $e) return !isNaN(d * r) && r !== "" ? (p = new Z(this._pt, t, e, +d || 0, r - (d || 0), typeof _ == "boolean" ? Nn : Cr, 0, c), l && (p.fp = l), o && p.modifier(o, this, t), this._pt = p) : (!_ && !(e in t) && li(e, r), En.call(this, t, e, d, r, c, u || nt.stringFilter, l));
}, Fn = function(t, e, i, r, n) {
  if (L(t) && (t = le(t, n, e, i, r)), !pt(t) || t.style && t.nodeType || K(t) || Wi(t)) return q(t) ? le(t, n, e, i, r) : t;
  var s = {}, o;
  for (o in t) s[o] = le(t[o], n, e, i, r);
  return s;
}, br = function(t, e, i, r, n, s) {
  var o, u, l, f;
  if (et[t] && (o = new et[t]()).init(n, o.rawVars ? e[t] : Fn(e[t], r, n, s, i), i, r, s) !== false && (i._pt = u = new Z(i._pt, n, t, 0, 1, o.render, o, 0, o.priority), i !== Xt)) for (l = i._ptLookup[i._targets.indexOf(n)], f = o._props.length; f--; ) l[o._props[f]] = u;
  return o;
}, Tt, $e, pi = function a11(t, e, i) {
  var r = t.vars, n = r.ease, s = r.startAt, o = r.immediateRender, u = r.lazy, l = r.onUpdate, f = r.runBackwards, _ = r.yoyoEase, d = r.keyframes, c = r.autoRevert, p = t._dur, h = t._startAt, m = t._targets, y = t.parent, x = y && y.data === "nested" ? y.vars.targets : m, v = t._overwrite === "auto" && !si, T = t.timeline, g, b, P, S, w, C, R, D, A, X, U, B, Y;
  if (T && (!d || !n) && (n = "none"), t._ease = Bt(n, jt.ease), t._yEase = _ ? xr(Bt(_ === true ? n : _, jt.ease)) : 0, _ && t._yoyo && !t._repeat && (_ = t._yEase, t._yEase = t._ease, t._ease = _), t._from = !T && !!r.runBackwards, !T || d && !r.stagger) {
    if (D = m[0] ? Lt(m[0]).harness : 0, B = D && r[D.prop], g = Ce(r, fi), h && (h._zTime < 0 && h.progress(1), e < 0 && f && o && !c ? h.render(-1, true) : h.revert(f && p ? we : un), h._lazy = 0), s) {
      if (Ot(t._startAt = V.set(m, ot({ data: "isStart", overwrite: false, parent: y, immediateRender: true, lazy: !h && Q(u), startAt: null, delay: 0, onUpdate: l && function() {
        return rt(t, "onUpdate");
      }, stagger: 0 }, s))), t._startAt._dp = 0, t._startAt._sat = t, e < 0 && (W || !o && !c) && t._startAt.revert(we), o && p && e <= 0 && i <= 0) {
        e && (t._zTime = e);
        return;
      }
    } else if (f && p && !h) {
      if (e && (o = false), P = ot({ overwrite: false, data: "isFromStart", lazy: o && !h && Q(u), immediateRender: o, stagger: 0, parent: y }, g), B && (P[D.prop] = B), Ot(t._startAt = V.set(m, P)), t._startAt._dp = 0, t._startAt._sat = t, e < 0 && (W ? t._startAt.revert(we) : t._startAt.render(-1, true)), t._zTime = e, !o) a11(t._startAt, M, M);
      else if (!e) return;
    }
    for (t._pt = t._ptCache = 0, u = p && Q(u) || u && !p, b = 0; b < m.length; b++) {
      if (w = m[b], R = w._gsap || _i(m)[b]._gsap, t._ptLookup[b] = X = {}, Ke[R.id] && Pt.length && Oe(), U = x === m ? b : x.indexOf(w), D && (A = new D()).init(w, B || g, t, U, x) !== false && (t._pt = S = new Z(t._pt, w, A.name, 0, 1, A.render, A, 0, A.priority), A._props.forEach(function(ht) {
        X[ht] = S;
      }), A.priority && (C = 1)), !D || B) for (P in g) et[P] && (A = br(P, g, t, U, w, x)) ? A.priority && (C = 1) : X[P] = S = di.call(t, w, P, "get", g[P], U, x, 0, r.stringFilter);
      t._op && t._op[b] && t.kill(w, t._op[b]), v && t._pt && (Tt = t, F.killTweensOf(w, X, t.globalTime(e)), Y = !t.parent, Tt = 0), t._pt && u && (Ke[R.id] = 1);
    }
    C && Mr(t), t._onInit && t._onInit(t);
  }
  t._onUpdate = l, t._initted = (!t._op || t._pt) && !Y, d && e <= 0 && T.render(ut, true, true);
}, zn = function(t, e, i, r, n, s, o, u) {
  var l = (t._pt && t._ptCache || (t._ptCache = {}))[e], f, _, d, c;
  if (!l) for (l = t._ptCache[e] = [], d = t._ptLookup, c = t._targets.length; c--; ) {
    if (f = d[c][e], f && f.d && f.d._pt) for (f = f.d._pt; f && f.p !== e && f.fp !== e; ) f = f._next;
    if (!f) return $e = 1, t.vars[e] = "+=0", pi(t, o), $e = 0, u ? fe(e + " not eligible for reset") : 1;
    l.push(f);
  }
  for (c = l.length; c--; ) _ = l[c], f = _._pt || _, f.s = (r || r === 0) && !n ? r : f.s + (r || 0) + s * f.c, f.c = i - f.s, _.e && (_.e = I(i) + G(_.e)), _.b && (_.b = f.s + G(_.b));
}, Ln = function(t, e) {
  var i = t[0] ? Lt(t[0]).harness : 0, r = i && i.aliases, n, s, o, u;
  if (!r) return e;
  n = Qt({}, e);
  for (s in r) if (s in n) for (u = r[s].split(","), o = u.length; o--; ) n[u[o]] = n[s];
  return n;
}, In = function(t, e, i, r) {
  var n = e.ease || r || "power1.inOut", s, o;
  if (K(e)) o = i[t] || (i[t] = []), e.forEach(function(u, l) {
    return o.push({ t: l / (e.length - 1) * 100, v: u, e: n });
  });
  else for (s in e) o = i[s] || (i[s] = []), s === "ease" || o.push({ t: parseFloat(t), v: e[s], e: n });
}, le = function(t, e, i, r, n) {
  return L(t) ? t.call(e, i, r, n) : q(t) && ~t.indexOf("random(") ? _e(t) : t;
}, Pr = hi + "repeat,repeatDelay,yoyo,repeatRefresh,yoyoEase,autoRevert", Sr = {};
H(Pr + ",id,stagger,delay,duration,paused,scrollTrigger", function(a15) {
  return Sr[a15] = 1;
});
var V = (function(a15) {
  qi(t, a15);
  function t(i, r, n, s) {
    var o;
    typeof r == "number" && (n.duration = r, r = n, n = null), o = a15.call(this, s ? r : ae(r)) || this;
    var u = o.vars, l = u.duration, f = u.delay, _ = u.immediateRender, d = u.stagger, c = u.overwrite, p = u.keyframes, h = u.defaults, m = u.scrollTrigger, y = u.yoyoEase, x = r.parent || F, v = (K(i) || Wi(i) ? xt(i[0]) : "length" in r) ? [i] : lt(i), T, g, b, P, S, w, C, R;
    if (o._targets = v.length ? _i(v) : fe("GSAP target " + i + " not found. https://gsap.com", !nt.nullTargetWarn) || [], o._ptLookup = [], o._overwrite = c, p || d || Te(l) || Te(f)) {
      if (r = o.vars, T = o.timeline = new j({ data: "nested", defaults: h || {}, targets: x && x.data === "nested" ? x.vars.targets : v }), T.kill(), T.parent = T._dp = gt(o), T._start = 0, d || Te(l) || Te(f)) {
        if (P = v.length, C = d && lr(d), pt(d)) for (S in d) ~Pr.indexOf(S) && (R || (R = {}), R[S] = d[S]);
        for (g = 0; g < P; g++) b = Ce(r, Sr), b.stagger = 0, y && (b.yoyoEase = y), R && Qt(b, R), w = v[g], b.duration = +le(l, gt(o), g, w, v), b.delay = (+le(f, gt(o), g, w, v) || 0) - o._delay, !d && P === 1 && b.delay && (o._delay = f = b.delay, o._start += f, b.delay = 0), T.to(w, b, C ? C(g, w, v) : 0), T._ease = O.none;
        T.duration() ? l = f = 0 : o.timeline = 0;
      } else if (p) {
        ae(ot(T.vars.defaults, { ease: "none" })), T._ease = Bt(p.ease || r.ease || "none");
        var D = 0, A, X, U;
        if (K(p)) p.forEach(function(B) {
          return T.to(v, B, ">");
        }), T.duration();
        else {
          b = {};
          for (S in p) S === "ease" || S === "easeEach" || In(S, p[S], b, p.easeEach);
          for (S in b) for (A = b[S].sort(function(B, Y) {
            return B.t - Y.t;
          }), D = 0, g = 0; g < A.length; g++) X = A[g], U = { ease: X.e, duration: (X.t - (g ? A[g - 1].t : 0)) / 100 * l }, U[S] = X.v, T.to(v, U, D), D += U.duration;
          T.duration() < l && T.to({}, { duration: l - T.duration() });
        }
      }
      l || o.duration(l = T.duration());
    } else o.timeline = 0;
    return c === true && !si && (Tt = gt(o), F.killTweensOf(v), Tt = 0), ct(x, gt(o), n), r.reversed && o.reverse(), r.paused && o.paused(true), (_ || !l && !p && o._start === N(x._time) && Q(_) && dn(gt(o)) && x.data !== "nested") && (o._tTime = -M, o.render(Math.max(0, -f) || 0)), m && sr(gt(o), m), o;
  }
  var e = t.prototype;
  return e.render = function(r, n, s) {
    var o = this._time, u = this._tDur, l = this._dur, f = r < 0, _ = r > u - M && !f ? u : r < M ? 0 : r, d, c, p, h, m, y, x, v, T;
    if (!l) mn(this, r, n, s);
    else if (_ !== this._tTime || !r || s || !this._initted && this._tTime || this._startAt && this._zTime < 0 !== f || this._lazy) {
      if (d = _, v = this.timeline, this._repeat) {
        if (h = l + this._rDelay, this._repeat < -1 && f) return this.totalTime(h * 100 + r, n, s);
        if (d = N(_ % h), _ === u ? (p = this._repeat, d = l) : (m = N(_ / h), p = ~~m, p && p === m ? (d = l, p--) : d > l && (d = l)), y = this._yoyo && p & 1, y && (T = this._yEase, d = l - d), m = Ht(this._tTime, h), d === o && !s && this._initted && p === m) return this._tTime = _, this;
        p !== m && (v && this._yEase && vr(v, y), this.vars.repeatRefresh && !y && !this._lock && d !== h && this._initted && (this._lock = s = 1, this.render(N(h * p), true).invalidate()._lock = 0));
      }
      if (!this._initted) {
        if (or(this, f ? r : d, s, n, _)) return this._tTime = 0, this;
        if (o !== this._time && !(s && this.vars.repeatRefresh && p !== m)) return this;
        if (l !== this._dur) return this.render(r, n, s);
      }
      if (this._tTime = _, this._time = d, !this._act && this._ts && (this._act = 1, this._lazy = 0), this.ratio = x = (T || this._ease)(d / l), this._from && (this.ratio = x = 1 - x), !o && _ && !n && !m && (rt(this, "onStart"), this._tTime !== _)) return this;
      for (c = this._pt; c; ) c.r(x, c.d), c = c._next;
      v && v.render(r < 0 ? r : v._dur * v._ease(d / this._dur), n, s) || this._startAt && (this._zTime = r), this._onUpdate && !n && (f && je(this, r, n, s), rt(this, "onUpdate")), this._repeat && p !== m && this.vars.onRepeat && !n && this.parent && rt(this, "onRepeat"), (_ === this._tDur || !_) && this._tTime === _ && (f && !this._onUpdate && je(this, r, true, true), (r || !l) && (_ === this._tDur && this._ts > 0 || !_ && this._ts < 0) && Ot(this, 1), !n && !(f && !o) && (_ || o || y) && (rt(this, _ === u ? "onComplete" : "onReverseComplete", true), this._prom && !(_ < u && this.timeScale() > 0) && this._prom()));
    }
    return this;
  }, e.targets = function() {
    return this._targets;
  }, e.invalidate = function(r) {
    return (!r || !this.vars.runBackwards) && (this._startAt = 0), this._pt = this._op = this._onUpdate = this._lazy = this.ratio = 0, this._ptLookup = [], this.timeline && this.timeline.invalidate(r), a15.prototype.invalidate.call(this, r);
  }, e.resetTo = function(r, n, s, o, u) {
    ce || it.wake(), this._ts || this.play();
    var l = Math.min(this._dur, (this._dp._time - this._start) * this._ts), f;
    return this._initted || pi(this, l), f = this._ease(l / this._dur), zn(this, r, n, s, o, f, l, u) ? this.resetTo(r, n, s, o, 1) : (Fe(this, 0), this.parent || rr(this._dp, this, "_first", "_last", this._dp._sort ? "_start" : 0), this.render(0));
  }, e.kill = function(r, n) {
    if (n === void 0 && (n = "all"), !r && (!n || n === "all")) return this._lazy = this._pt = 0, this.parent ? se(this) : this.scrollTrigger && this.scrollTrigger.kill(!!W), this;
    if (this.timeline) {
      var s = this.timeline.totalDuration();
      return this.timeline.killTweensOf(r, n, Tt && Tt.vars.overwrite !== true)._first || se(this), this.parent && s !== this.timeline.totalDuration() && Zt(this, this._dur * this.timeline._tDur / s, 0, 1), this;
    }
    var o = this._targets, u = r ? lt(r) : o, l = this._ptLookup, f = this._pt, _, d, c, p, h, m, y;
    if ((!n || n === "all") && _n(o, u)) return n === "all" && (this._pt = 0), se(this);
    for (_ = this._op = this._op || [], n !== "all" && (q(n) && (h = {}, H(n, function(x) {
      return h[x] = 1;
    }), n = h), n = Ln(o, n)), y = o.length; y--; ) if (~u.indexOf(o[y])) {
      d = l[y], n === "all" ? (_[y] = n, p = d, c = {}) : (c = _[y] = _[y] || {}, p = n);
      for (h in p) m = d && d[h], m && ((!("kill" in m.d) || m.d.kill(h) === true) && Re(this, m, "_pt"), delete d[h]), c !== "all" && (c[h] = 1);
    }
    return this._initted && !this._pt && f && se(this), this;
  }, t.to = function(r, n) {
    return new t(r, n, arguments[2]);
  }, t.from = function(r, n) {
    return ue(1, arguments);
  }, t.delayedCall = function(r, n, s, o) {
    return new t(n, 0, { immediateRender: false, lazy: false, overwrite: false, delay: r, onComplete: n, onReverseComplete: n, onCompleteParams: s, onReverseCompleteParams: s, callbackScope: o });
  }, t.fromTo = function(r, n, s) {
    return ue(2, arguments);
  }, t.set = function(r, n) {
    return n.duration = 0, n.repeatDelay || (n.repeat = 0), new t(r, n);
  }, t.killTweensOf = function(r, n, s) {
    return F.killTweensOf(r, n, s);
  }, t;
})(de);
ot(V.prototype, { _targets: [], _lazy: 0, _startAt: 0, _op: 0, _onInit: 0 });
H("staggerTo,staggerFrom,staggerFromTo", function(a15) {
  V[a15] = function() {
    var t = new j(), e = He.call(arguments, 0);
    return e.splice(a15 === "staggerFromTo" ? 5 : 4, 0, 0), t[a15].apply(t, e);
  };
});
var mi = function(t, e, i) {
  return t[e] = i;
}, Or = function(t, e, i) {
  return t[e](i);
}, Bn = function(t, e, i, r) {
  return t[e](r.fp, i);
}, Vn = function(t, e, i) {
  return t.setAttribute(e, i);
}, gi = function(t, e) {
  return L(t[e]) ? Or : oi(t[e]) && t.setAttribute ? Vn : mi;
}, Cr = function(t, e) {
  return e.set(e.t, e.p, Math.round((e.s + e.c * t) * 1e6) / 1e6, e);
}, Nn = function(t, e) {
  return e.set(e.t, e.p, !!(e.s + e.c * t), e);
}, kr = function(t, e) {
  var i = e._pt, r = "";
  if (!t && e.b) r = e.b;
  else if (t === 1 && e.e) r = e.e;
  else {
    for (; i; ) r = i.p + (i.m ? i.m(i.s + i.c * t) : Math.round((i.s + i.c * t) * 1e4) / 1e4) + r, i = i._next;
    r += e.c;
  }
  e.set(e.t, e.p, r, e);
}, yi = function(t, e) {
  for (var i = e._pt; i; ) i.r(t, i.d), i = i._next;
}, Un = function(t, e, i, r) {
  for (var n = this._pt, s; n; ) s = n._next, n.p === r && n.modifier(t, e, i), n = s;
}, Yn = function(t) {
  for (var e = this._pt, i, r; e; ) r = e._next, e.p === t && !e.op || e.op === t ? Re(this, e, "_pt") : e.dep || (i = 1), e = r;
  return !i;
}, qn = function(t, e, i, r) {
  r.mSet(t, e, r.m.call(r.tween, i, r.mt), r);
}, Mr = function(t) {
  for (var e = t._pt, i, r, n, s; e; ) {
    for (i = e._next, r = n; r && r.pr > e.pr; ) r = r._next;
    (e._prev = r ? r._prev : s) ? e._prev._next = e : n = e, (e._next = r) ? r._prev = e : s = e, e = i;
  }
  t._pt = n;
}, Z = (function() {
  function a15(e, i, r, n, s, o, u, l, f) {
    this.t = i, this.s = n, this.c = s, this.p = r, this.r = o || Cr, this.d = u || this, this.set = l || mi, this.pr = f || 0, this._next = e, e && (e._prev = this);
  }
  var t = a15.prototype;
  return t.modifier = function(i, r, n) {
    this.mSet = this.mSet || this.set, this.set = qn, this.m = i, this.mt = n, this.tween = r;
  }, a15;
})();
H(hi + "parent,duration,ease,delay,overwrite,runBackwards,startAt,yoyo,immediateRender,repeat,repeatDelay,data,paused,reversed,lazy,callbackScope,stringFilter,id,yoyoEase,stagger,inherit,repeatRefresh,keyframes,autoRevert,scrollTrigger", function(a15) {
  return fi[a15] = 1;
});
st.TweenMax = st.TweenLite = V;
st.TimelineLite = st.TimelineMax = j;
F = new j({ sortChildren: false, defaults: jt, autoRemoveChildren: true, id: "root", smoothChildTiming: true });
nt.stringFilter = yr;
var Vt = [], Pe = {}, Xn = [], Ri = 0, Wn = 0, Ue = function(t) {
  return (Pe[t] || Xn).map(function(e) {
    return e();
  });
}, ti = function() {
  var t = Date.now(), e = [];
  t - Ri > 2 && (Ue("matchMediaInit"), Vt.forEach(function(i) {
    var r = i.queries, n = i.conditions, s, o, u, l;
    for (o in r) s = _t.matchMedia(r[o]).matches, s && (u = 1), s !== n[o] && (n[o] = s, l = 1);
    l && (i.revert(), u && e.push(i));
  }), Ue("matchMediaRevert"), e.forEach(function(i) {
    return i.onMatch(i, function(r) {
      return i.add(null, r);
    });
  }), Ri = t, Ue("matchMedia"));
}, Dr = (function() {
  function a15(e, i) {
    this.selector = i && Ze(i), this.data = [], this._r = [], this.isReverted = false, this.id = Wn++, e && this.add(e);
  }
  var t = a15.prototype;
  return t.add = function(i, r, n) {
    L(i) && (n = r, r = i, i = L);
    var s = this, o = function() {
      var l = E, f = s.selector, _;
      return l && l !== s && l.data.push(s), n && (s.selector = Ze(n)), E = s, _ = r.apply(s, arguments), L(_) && s._r.push(_), E = l, s.selector = f, s.isReverted = false, _;
    };
    return s.last = o, i === L ? o(s, function(u) {
      return s.add(null, u);
    }) : i ? s[i] = o : o;
  }, t.ignore = function(i) {
    var r = E;
    E = null, i(this), E = r;
  }, t.getTweens = function() {
    var i = [];
    return this.data.forEach(function(r) {
      return r instanceof a15 ? i.push.apply(i, r.getTweens()) : r instanceof V && !(r.parent && r.parent.data === "nested") && i.push(r);
    }), i;
  }, t.clear = function() {
    this._r.length = this.data.length = 0;
  }, t.kill = function(i, r) {
    var n = this;
    if (i ? (function() {
      for (var o = n.getTweens(), u = n.data.length, l; u--; ) l = n.data[u], l.data === "isFlip" && (l.revert(), l.getChildren(true, true, false).forEach(function(f) {
        return o.splice(o.indexOf(f), 1);
      }));
      for (o.map(function(f) {
        return { g: f._dur || f._delay || f._sat && !f._sat.vars.immediateRender ? f.globalTime(0) : -1 / 0, t: f };
      }).sort(function(f, _) {
        return _.g - f.g || -1 / 0;
      }).forEach(function(f) {
        return f.t.revert(i);
      }), u = n.data.length; u--; ) l = n.data[u], l instanceof j ? l.data !== "nested" && (l.scrollTrigger && l.scrollTrigger.revert(), l.kill()) : !(l instanceof V) && l.revert && l.revert(i);
      n._r.forEach(function(f) {
        return f(i, n);
      }), n.isReverted = true;
    })() : this.data.forEach(function(o) {
      return o.kill && o.kill();
    }), this.clear(), r) for (var s = Vt.length; s--; ) Vt[s].id === this.id && Vt.splice(s, 1);
  }, t.revert = function(i) {
    this.kill(i || {});
  }, a15;
})(), Gn = (function() {
  function a15(e) {
    this.contexts = [], this.scope = e, E && E.data.push(this);
  }
  var t = a15.prototype;
  return t.add = function(i, r, n) {
    pt(i) || (i = { matches: i });
    var s = new Dr(0, n || this.scope), o = s.conditions = {}, u, l, f;
    E && !s.selector && (s.selector = E.selector), this.contexts.push(s), r = s.add("onMatch", r), s.queries = i;
    for (l in i) l === "all" ? f = 1 : (u = _t.matchMedia(i[l]), u && (Vt.indexOf(s) < 0 && Vt.push(s), (o[l] = u.matches) && (f = 1), u.addListener ? u.addListener(ti) : u.addEventListener("change", ti)));
    return f && r(s, function(_) {
      return s.add(null, _);
    }), this;
  }, t.revert = function(i) {
    this.kill(i || {});
  }, t.kill = function(i) {
    this.contexts.forEach(function(r) {
      return r.kill(i, true);
    });
  }, a15;
})(), Me = { registerPlugin: function() {
  for (var t = arguments.length, e = new Array(t), i = 0; i < t; i++) e[i] = arguments[i];
  e.forEach(function(r) {
    return pr(r);
  });
}, timeline: function(t) {
  return new j(t);
}, getTweensOf: function(t, e) {
  return F.getTweensOf(t, e);
}, getProperty: function(t, e, i, r) {
  q(t) && (t = lt(t)[0]);
  var n = Lt(t || {}).get, s = i ? ir : er;
  return i === "native" && (i = ""), t && (e ? s((et[e] && et[e].get || n)(t, e, i, r)) : function(o, u, l) {
    return s((et[o] && et[o].get || n)(t, o, u, l));
  });
}, quickSetter: function(t, e, i) {
  if (t = lt(t), t.length > 1) {
    var r = t.map(function(f) {
      return $.quickSetter(f, e, i);
    }), n = r.length;
    return function(f) {
      for (var _ = n; _--; ) r[_](f);
    };
  }
  t = t[0] || {};
  var s = et[e], o = Lt(t), u = o.harness && (o.harness.aliases || {})[e] || e, l = s ? function(f) {
    var _ = new s();
    Xt._pt = 0, _.init(t, i ? f + i : f, Xt, 0, [t]), _.render(1, _), Xt._pt && yi(1, Xt);
  } : o.set(t, u);
  return s ? l : function(f) {
    return l(t, u, i ? f + i : f, o, 1);
  };
}, quickTo: function(t, e, i) {
  var r, n = $.to(t, ot((r = {}, r[e] = "+=0.1", r.paused = true, r.stagger = 0, r), i || {})), s = function(u, l, f) {
    return n.resetTo(e, u, l, f);
  };
  return s.tween = n, s;
}, isTweening: function(t) {
  return F.getTweensOf(t, true).length > 0;
}, defaults: function(t) {
  return t && t.ease && (t.ease = Bt(t.ease, jt.ease)), Ci(jt, t || {});
}, config: function(t) {
  return Ci(nt, t || {});
}, registerEffect: function(t) {
  var e = t.name, i = t.effect, r = t.plugins, n = t.defaults, s = t.extendTimeline;
  (r || "").split(",").forEach(function(o) {
    return o && !et[o] && !st[o] && fe(e + " effect requires " + o + " plugin.");
  }), Ie[e] = function(o, u, l) {
    return i(lt(o), ot(u || {}, n), l);
  }, s && (j.prototype[e] = function(o, u, l) {
    return this.add(Ie[e](o, pt(u) ? u : (l = u) && {}, this), l);
  });
}, registerEase: function(t, e) {
  O[t] = Bt(e);
}, parseEase: function(t, e) {
  return arguments.length ? Bt(t, e) : O;
}, getById: function(t) {
  return F.getById(t);
}, exportRoot: function(t, e) {
  t === void 0 && (t = {});
  var i = new j(t), r, n;
  for (i.smoothChildTiming = Q(t.smoothChildTiming), F.remove(i), i._dp = 0, i._time = i._tTime = F._time, r = F._first; r; ) n = r._next, (e || !(!r._dur && r instanceof V && r.vars.onComplete === r._targets[0])) && ct(i, r, r._start - r._delay), r = n;
  return ct(F, i, 0), i;
}, context: function(t, e) {
  return t ? new Dr(t, e) : E;
}, matchMedia: function(t) {
  return new Gn(t);
}, matchMediaRefresh: function() {
  return Vt.forEach(function(t) {
    var e = t.conditions, i, r;
    for (r in e) e[r] && (e[r] = false, i = 1);
    i && t.revert();
  }) || ti();
}, addEventListener: function(t, e) {
  var i = Pe[t] || (Pe[t] = []);
  ~i.indexOf(e) || i.push(e);
}, removeEventListener: function(t, e) {
  var i = Pe[t], r = i && i.indexOf(e);
  r >= 0 && i.splice(r, 1);
}, utils: { wrap: Pn, wrapYoyo: Sn, distribute: lr, random: hr, snap: fr, normalize: bn, getUnit: G, clamp: xn, splitColor: mr, toArray: lt, selector: Ze, mapRange: cr, pipe: Tn, unitize: wn, interpolate: On, shuffle: ur }, install: Hi, effects: Ie, ticker: it, updateRoot: j.updateRoot, plugins: et, globalTimeline: F, core: { PropTween: Z, globals: Zi, Tween: V, Timeline: j, Animation: de, getCache: Lt, _removeLinkedListItem: Re, reverting: function() {
  return W;
}, context: function(t) {
  return t && E && (E.data.push(t), t._ctx = E), E;
}, suppressOverwrites: function(t) {
  return si = t;
} } };
H("to,from,fromTo,delayedCall,set,killTweensOf", function(a15) {
  return Me[a15] = V[a15];
});
it.add(j.updateRoot);
Xt = Me.to({}, { duration: 0 });
var Kn = function(t, e) {
  for (var i = t._pt; i && i.p !== e && i.op !== e && i.fp !== e; ) i = i._next;
  return i;
}, jn = function(t, e) {
  var i = t._targets, r, n, s;
  for (r in e) for (n = i.length; n--; ) s = t._ptLookup[n][r], s && (s = s.d) && (s._pt && (s = Kn(s, r)), s && s.modifier && s.modifier(e[r], t, i[n], r));
}, Ye = function(t, e) {
  return { name: t, headless: 1, rawVars: 1, init: function(r, n, s) {
    s._onInit = function(o) {
      var u, l;
      if (q(n) && (u = {}, H(n, function(f) {
        return u[f] = 1;
      }), n = u), e) {
        u = {};
        for (l in n) u[l] = e(n[l]);
        n = u;
      }
      jn(o, n);
    };
  } };
}, $ = Me.registerPlugin({ name: "attr", init: function(t, e, i, r, n) {
  var s, o, u;
  this.tween = i;
  for (s in e) u = t.getAttribute(s) || "", o = this.add(t, "setAttribute", (u || 0) + "", e[s], r, n, 0, 0, s), o.op = s, o.b = u, this._props.push(s);
}, render: function(t, e) {
  for (var i = e._pt; i; ) W ? i.set(i.t, i.p, i.b, i) : i.r(t, i.d), i = i._next;
} }, { name: "endArray", headless: 1, init: function(t, e) {
  for (var i = e.length; i--; ) this.add(t, i, t[i] || 0, e[i], 0, 0, 0, 0, 0, 1);
} }, Ye("roundProps", Je), Ye("modifiers"), Ye("snap", fr)) || Me;
V.version = j.version = $.version = "3.13.0";
Qi = 1;
ai() && Jt();
O.Power0;
var ks = O.Power1;
O.Power2;
O.Power3;
O.Power4;
O.Linear;
O.Quad;
O.Cubic;
O.Quart;
O.Quint;
O.Strong;
O.Elastic;
O.Back;
O.SteppedEase;
O.Bounce;
O.Sine;
O.Expo;
O.Circ;
/*!
 * CSSPlugin 3.13.0
 * https://gsap.com
 *
 * Copyright 2008-2025, GreenSock. All rights reserved.
 * Subject to the terms at https://gsap.com/standard-license
 * @author: Jack Doyle, jack@greensock.com
*/
var Ei, wt, Gt, xi, zt, Fi, vi, Qn = function() {
  return typeof window < "u";
}, vt = {}, Ft = 180 / Math.PI, Kt = Math.PI / 180, Yt = Math.atan2, zi = 1e8, Ti = /([A-Z])/g, Hn = /(left|right|width|margin|padding|x)/i, Zn = /[\s,\(]\S/, dt = { autoAlpha: "opacity,visibility", scale: "scaleX,scaleY", alpha: "opacity" }, ei = function(t, e) {
  return e.set(e.t, e.p, Math.round((e.s + e.c * t) * 1e4) / 1e4 + e.u, e);
}, Jn = function(t, e) {
  return e.set(e.t, e.p, t === 1 ? e.e : Math.round((e.s + e.c * t) * 1e4) / 1e4 + e.u, e);
}, $n = function(t, e) {
  return e.set(e.t, e.p, t ? Math.round((e.s + e.c * t) * 1e4) / 1e4 + e.u : e.b, e);
}, ts = function(t, e) {
  var i = e.s + e.c * t;
  e.set(e.t, e.p, ~~(i + (i < 0 ? -0.5 : 0.5)) + e.u, e);
}, Ar = function(t, e) {
  return e.set(e.t, e.p, t ? e.e : e.b, e);
}, Rr = function(t, e) {
  return e.set(e.t, e.p, t !== 1 ? e.b : e.e, e);
}, es = function(t, e, i) {
  return t.style[e] = i;
}, is = function(t, e, i) {
  return t.style.setProperty(e, i);
}, rs = function(t, e, i) {
  return t._gsap[e] = i;
}, ns = function(t, e, i) {
  return t._gsap.scaleX = t._gsap.scaleY = i;
}, ss = function(t, e, i, r, n) {
  var s = t._gsap;
  s.scaleX = s.scaleY = i, s.renderTransform(n, s);
}, os = function(t, e, i, r, n) {
  var s = t._gsap;
  s[e] = i, s.renderTransform(n, s);
}, z = "transform", J = z + "Origin", as = function a12(t, e) {
  var i = this, r = this.target, n = r.style, s = r._gsap;
  if (t in vt && n) {
    if (this.tfm = this.tfm || {}, t !== "transform") t = dt[t] || t, ~t.indexOf(",") ? t.split(",").forEach(function(o) {
      return i.tfm[o] = yt(r, o);
    }) : this.tfm[t] = s.x ? s[t] : yt(r, t), t === J && (this.tfm.zOrigin = s.zOrigin);
    else return dt.transform.split(",").forEach(function(o) {
      return a12.call(i, o, e);
    });
    if (this.props.indexOf(z) >= 0) return;
    s.svg && (this.svgo = r.getAttribute("data-svg-origin"), this.props.push(J, e, "")), t = z;
  }
  (n || e) && this.props.push(t, e, n[t]);
}, Er = function(t) {
  t.translate && (t.removeProperty("translate"), t.removeProperty("scale"), t.removeProperty("rotate"));
}, us = function() {
  var t = this.props, e = this.target, i = e.style, r = e._gsap, n, s;
  for (n = 0; n < t.length; n += 3) t[n + 1] ? t[n + 1] === 2 ? e[t[n]](t[n + 2]) : e[t[n]] = t[n + 2] : t[n + 2] ? i[t[n]] = t[n + 2] : i.removeProperty(t[n].substr(0, 2) === "--" ? t[n] : t[n].replace(Ti, "-$1").toLowerCase());
  if (this.tfm) {
    for (s in this.tfm) r[s] = this.tfm[s];
    r.svg && (r.renderTransform(), e.setAttribute("data-svg-origin", this.svgo || "")), n = vi(), (!n || !n.isStart) && !i[z] && (Er(i), r.zOrigin && i[J] && (i[J] += " " + r.zOrigin + "px", r.zOrigin = 0, r.renderTransform()), r.uncache = 1);
  }
}, Fr = function(t, e) {
  var i = { target: t, props: [], revert: us, save: as };
  return t._gsap || $.core.getCache(t), e && t.style && t.nodeType && e.split(",").forEach(function(r) {
    return i.save(r);
  }), i;
}, zr, ii = function(t, e) {
  var i = wt.createElementNS ? wt.createElementNS((e || "http://www.w3.org/1999/xhtml").replace(/^https/, "http"), t) : wt.createElement(t);
  return i && i.style ? i : wt.createElement(t);
}, ft = function a13(t, e, i) {
  var r = getComputedStyle(t);
  return r[e] || r.getPropertyValue(e.replace(Ti, "-$1").toLowerCase()) || r.getPropertyValue(e) || !i && a13(t, $t(e) || e, 1) || "";
}, Li = "O,Moz,ms,Ms,Webkit".split(","), $t = function(t, e, i) {
  var r = e || zt, n = r.style, s = 5;
  if (t in n && !i) return t;
  for (t = t.charAt(0).toUpperCase() + t.substr(1); s-- && !(Li[s] + t in n); ) ;
  return s < 0 ? null : (s === 3 ? "ms" : s >= 0 ? Li[s] : "") + t;
}, ri = function() {
  Qn() && window.document && (Ei = window, wt = Ei.document, Gt = wt.documentElement, zt = ii("div") || { style: {} }, ii("div"), z = $t(z), J = z + "Origin", zt.style.cssText = "border-width:0;line-height:0;position:absolute;padding:0", zr = !!$t("perspective"), vi = $.core.reverting, xi = 1);
}, Ii = function(t) {
  var e = t.ownerSVGElement, i = ii("svg", e && e.getAttribute("xmlns") || "http://www.w3.org/2000/svg"), r = t.cloneNode(true), n;
  r.style.display = "block", i.appendChild(r), Gt.appendChild(i);
  try {
    n = r.getBBox();
  } catch {
  }
  return i.removeChild(r), Gt.removeChild(i), n;
}, Bi = function(t, e) {
  for (var i = e.length; i--; ) if (t.hasAttribute(e[i])) return t.getAttribute(e[i]);
}, Lr = function(t) {
  var e, i;
  try {
    e = t.getBBox();
  } catch {
    e = Ii(t), i = 1;
  }
  return e && (e.width || e.height) || i || (e = Ii(t)), e && !e.width && !e.x && !e.y ? { x: +Bi(t, ["x", "cx", "x1"]) || 0, y: +Bi(t, ["y", "cy", "y1"]) || 0, width: 0, height: 0 } : e;
}, Ir = function(t) {
  return !!(t.getCTM && (!t.parentNode || t.ownerSVGElement) && Lr(t));
}, Nt = function(t, e) {
  if (e) {
    var i = t.style, r;
    e in vt && e !== J && (e = z), i.removeProperty ? (r = e.substr(0, 2), (r === "ms" || e.substr(0, 6) === "webkit") && (e = "-" + e), i.removeProperty(r === "--" ? e : e.replace(Ti, "-$1").toLowerCase())) : i.removeAttribute(e);
  }
}, bt = function(t, e, i, r, n, s) {
  var o = new Z(t._pt, e, i, 0, 1, s ? Rr : Ar);
  return t._pt = o, o.b = r, o.e = n, t._props.push(i), o;
}, Vi = { deg: 1, rad: 1, turn: 1 }, ls = { grid: 1, flex: 1 }, Ct = function a14(t, e, i, r) {
  var n = parseFloat(i) || 0, s = (i + "").trim().substr((n + "").length) || "px", o = zt.style, u = Hn.test(e), l = t.tagName.toLowerCase() === "svg", f = (l ? "client" : "offset") + (u ? "Width" : "Height"), _ = 100, d = r === "px", c = r === "%", p, h, m, y;
  if (r === s || !n || Vi[r] || Vi[s]) return n;
  if (s !== "px" && !d && (n = a14(t, e, i, "px")), y = t.getCTM && Ir(t), (c || s === "%") && (vt[e] || ~e.indexOf("adius"))) return p = y ? t.getBBox()[u ? "width" : "height"] : t[f], I(c ? n / p * _ : n / 100 * p);
  if (o[u ? "width" : "height"] = _ + (d ? s : r), h = r !== "rem" && ~e.indexOf("adius") || r === "em" && t.appendChild && !l ? t : t.parentNode, y && (h = (t.ownerSVGElement || {}).parentNode), (!h || h === wt || !h.appendChild) && (h = wt.body), m = h._gsap, m && c && m.width && u && m.time === it.time && !m.uncache) return I(n / m.width * _);
  if (c && (e === "height" || e === "width")) {
    var x = t.style[e];
    t.style[e] = _ + r, p = t[f], x ? t.style[e] = x : Nt(t, e);
  } else (c || s === "%") && !ls[ft(h, "display")] && (o.position = ft(t, "position")), h === t && (o.position = "static"), h.appendChild(zt), p = zt[f], h.removeChild(zt), o.position = "absolute";
  return u && c && (m = Lt(h), m.time = it.time, m.width = h[f]), I(d ? p * n / _ : p && n ? _ / p * n : 0);
}, yt = function(t, e, i, r) {
  var n;
  return xi || ri(), e in dt && e !== "transform" && (e = dt[e], ~e.indexOf(",") && (e = e.split(",")[0])), vt[e] && e !== "transform" ? (n = me(t, r), n = e !== "transformOrigin" ? n[e] : n.svg ? n.origin : Ae(ft(t, J)) + " " + n.zOrigin + "px") : (n = t.style[e], (!n || n === "auto" || r || ~(n + "").indexOf("calc(")) && (n = De[e] && De[e](t, e, i) || ft(t, e) || $i(t, e) || (e === "opacity" ? 1 : 0))), i && !~(n + "").trim().indexOf(" ") ? Ct(t, e, n, i) + i : n;
}, fs = function(t, e, i, r) {
  if (!i || i === "none") {
    var n = $t(e, t, 1), s = n && ft(t, n, 1);
    s && s !== i ? (e = n, i = s) : e === "borderColor" && (i = ft(t, "borderTopColor"));
  }
  var o = new Z(this._pt, t.style, e, 0, 1, kr), u = 0, l = 0, f, _, d, c, p, h, m, y, x, v, T, g;
  if (o.b = i, o.e = r, i += "", r += "", r.substring(0, 6) === "var(--" && (r = ft(t, r.substring(4, r.indexOf(")")))), r === "auto" && (h = t.style[e], t.style[e] = r, r = ft(t, e) || r, h ? t.style[e] = h : Nt(t, e)), f = [i, r], yr(f), i = f[0], r = f[1], d = i.match(qt) || [], g = r.match(qt) || [], g.length) {
    for (; _ = qt.exec(r); ) m = _[0], x = r.substring(u, _.index), p ? p = (p + 1) % 5 : (x.substr(-5) === "rgba(" || x.substr(-5) === "hsla(") && (p = 1), m !== (h = d[l++] || "") && (c = parseFloat(h) || 0, T = h.substr((c + "").length), m.charAt(1) === "=" && (m = Wt(c, m) + T), y = parseFloat(m), v = m.substr((y + "").length), u = qt.lastIndex - v.length, v || (v = v || nt.units[e] || T, u === r.length && (r += v, o.e += v)), T !== v && (c = Ct(t, e, h, v) || 0), o._pt = { _next: o._pt, p: x || l === 1 ? x : ",", s: c, c: y - c, m: p && p < 4 || e === "zIndex" ? Math.round : 0 });
    o.c = u < r.length ? r.substring(u, r.length) : "";
  } else o.r = e === "display" && r === "none" ? Rr : Ar;
  return Ki.test(r) && (o.e = 0), this._pt = o, o;
}, Ni = { top: "0%", bottom: "100%", left: "0%", right: "100%", center: "50%" }, hs = function(t) {
  var e = t.split(" "), i = e[0], r = e[1] || "50%";
  return (i === "top" || i === "bottom" || r === "left" || r === "right") && (t = i, i = r, r = t), e[0] = Ni[i] || i, e[1] = Ni[r] || r, e.join(" ");
}, _s = function(t, e) {
  if (e.tween && e.tween._time === e.tween._dur) {
    var i = e.t, r = i.style, n = e.u, s = i._gsap, o, u, l;
    if (n === "all" || n === true) r.cssText = "", u = 1;
    else for (n = n.split(","), l = n.length; --l > -1; ) o = n[l], vt[o] && (u = 1, o = o === "transformOrigin" ? J : z), Nt(i, o);
    u && (Nt(i, z), s && (s.svg && i.removeAttribute("transform"), r.scale = r.rotate = r.translate = "none", me(i, 1), s.uncache = 1, Er(r)));
  }
}, De = { clearProps: function(t, e, i, r, n) {
  if (n.data !== "isFromStart") {
    var s = t._pt = new Z(t._pt, e, i, 0, 0, _s);
    return s.u = r, s.pr = -10, s.tween = n, t._props.push(i), 1;
  }
} }, pe = [1, 0, 0, 1, 0, 0], Br = {}, Vr = function(t) {
  return t === "matrix(1, 0, 0, 1, 0, 0)" || t === "none" || !t;
}, Ui = function(t) {
  var e = ft(t, z);
  return Vr(e) ? pe : e.substr(7).match(Gi).map(I);
}, wi = function(t, e) {
  var i = t._gsap || Lt(t), r = t.style, n = Ui(t), s, o, u, l;
  return i.svg && t.getAttribute("transform") ? (u = t.transform.baseVal.consolidate().matrix, n = [u.a, u.b, u.c, u.d, u.e, u.f], n.join(",") === "1,0,0,1,0,0" ? pe : n) : (n === pe && !t.offsetParent && t !== Gt && !i.svg && (u = r.display, r.display = "block", s = t.parentNode, (!s || !t.offsetParent && !t.getBoundingClientRect().width) && (l = 1, o = t.nextElementSibling, Gt.appendChild(t)), n = Ui(t), u ? r.display = u : Nt(t, "display"), l && (o ? s.insertBefore(t, o) : s ? s.appendChild(t) : Gt.removeChild(t))), e && n.length > 6 ? [n[0], n[1], n[4], n[5], n[12], n[13]] : n);
}, ni = function(t, e, i, r, n, s) {
  var o = t._gsap, u = n || wi(t, true), l = o.xOrigin || 0, f = o.yOrigin || 0, _ = o.xOffset || 0, d = o.yOffset || 0, c = u[0], p = u[1], h = u[2], m = u[3], y = u[4], x = u[5], v = e.split(" "), T = parseFloat(v[0]) || 0, g = parseFloat(v[1]) || 0, b, P, S, w;
  i ? u !== pe && (P = c * m - p * h) && (S = T * (m / P) + g * (-h / P) + (h * x - m * y) / P, w = T * (-p / P) + g * (c / P) - (c * x - p * y) / P, T = S, g = w) : (b = Lr(t), T = b.x + (~v[0].indexOf("%") ? T / 100 * b.width : T), g = b.y + (~(v[1] || v[0]).indexOf("%") ? g / 100 * b.height : g)), r || r !== false && o.smooth ? (y = T - l, x = g - f, o.xOffset = _ + (y * c + x * h) - y, o.yOffset = d + (y * p + x * m) - x) : o.xOffset = o.yOffset = 0, o.xOrigin = T, o.yOrigin = g, o.smooth = !!r, o.origin = e, o.originIsAbsolute = !!i, t.style[J] = "0px 0px", s && (bt(s, o, "xOrigin", l, T), bt(s, o, "yOrigin", f, g), bt(s, o, "xOffset", _, o.xOffset), bt(s, o, "yOffset", d, o.yOffset)), t.setAttribute("data-svg-origin", T + " " + g);
}, me = function(t, e) {
  var i = t._gsap || new wr(t);
  if ("x" in i && !e && !i.uncache) return i;
  var r = t.style, n = i.scaleX < 0, s = "px", o = "deg", u = getComputedStyle(t), l = ft(t, J) || "0", f, _, d, c, p, h, m, y, x, v, T, g, b, P, S, w, C, R, D, A, X, U, B, Y, ht, ye, te, ee, Mt, bi, mt, Dt;
  return f = _ = d = h = m = y = x = v = T = 0, c = p = 1, i.svg = !!(t.getCTM && Ir(t)), u.translate && ((u.translate !== "none" || u.scale !== "none" || u.rotate !== "none") && (r[z] = (u.translate !== "none" ? "translate3d(" + (u.translate + " 0 0").split(" ").slice(0, 3).join(", ") + ") " : "") + (u.rotate !== "none" ? "rotate(" + u.rotate + ") " : "") + (u.scale !== "none" ? "scale(" + u.scale.split(" ").join(",") + ") " : "") + (u[z] !== "none" ? u[z] : "")), r.scale = r.rotate = r.translate = "none"), P = wi(t, i.svg), i.svg && (i.uncache ? (ht = t.getBBox(), l = i.xOrigin - ht.x + "px " + (i.yOrigin - ht.y) + "px", Y = "") : Y = !e && t.getAttribute("data-svg-origin"), ni(t, Y || l, !!Y || i.originIsAbsolute, i.smooth !== false, P)), g = i.xOrigin || 0, b = i.yOrigin || 0, P !== pe && (R = P[0], D = P[1], A = P[2], X = P[3], f = U = P[4], _ = B = P[5], P.length === 6 ? (c = Math.sqrt(R * R + D * D), p = Math.sqrt(X * X + A * A), h = R || D ? Yt(D, R) * Ft : 0, x = A || X ? Yt(A, X) * Ft + h : 0, x && (p *= Math.abs(Math.cos(x * Kt))), i.svg && (f -= g - (g * R + b * A), _ -= b - (g * D + b * X))) : (Dt = P[6], bi = P[7], te = P[8], ee = P[9], Mt = P[10], mt = P[11], f = P[12], _ = P[13], d = P[14], S = Yt(Dt, Mt), m = S * Ft, S && (w = Math.cos(-S), C = Math.sin(-S), Y = U * w + te * C, ht = B * w + ee * C, ye = Dt * w + Mt * C, te = U * -C + te * w, ee = B * -C + ee * w, Mt = Dt * -C + Mt * w, mt = bi * -C + mt * w, U = Y, B = ht, Dt = ye), S = Yt(-A, Mt), y = S * Ft, S && (w = Math.cos(-S), C = Math.sin(-S), Y = R * w - te * C, ht = D * w - ee * C, ye = A * w - Mt * C, mt = X * C + mt * w, R = Y, D = ht, A = ye), S = Yt(D, R), h = S * Ft, S && (w = Math.cos(S), C = Math.sin(S), Y = R * w + D * C, ht = U * w + B * C, D = D * w - R * C, B = B * w - U * C, R = Y, U = ht), m && Math.abs(m) + Math.abs(h) > 359.9 && (m = h = 0, y = 180 - y), c = I(Math.sqrt(R * R + D * D + A * A)), p = I(Math.sqrt(B * B + Dt * Dt)), S = Yt(U, B), x = Math.abs(S) > 2e-4 ? S * Ft : 0, T = mt ? 1 / (mt < 0 ? -mt : mt) : 0), i.svg && (Y = t.getAttribute("transform"), i.forceCSS = t.setAttribute("transform", "") || !Vr(ft(t, z)), Y && t.setAttribute("transform", Y))), Math.abs(x) > 90 && Math.abs(x) < 270 && (n ? (c *= -1, x += h <= 0 ? 180 : -180, h += h <= 0 ? 180 : -180) : (p *= -1, x += x <= 0 ? 180 : -180)), e = e || i.uncache, i.x = f - ((i.xPercent = f && (!e && i.xPercent || (Math.round(t.offsetWidth / 2) === Math.round(-f) ? -50 : 0))) ? t.offsetWidth * i.xPercent / 100 : 0) + s, i.y = _ - ((i.yPercent = _ && (!e && i.yPercent || (Math.round(t.offsetHeight / 2) === Math.round(-_) ? -50 : 0))) ? t.offsetHeight * i.yPercent / 100 : 0) + s, i.z = d + s, i.scaleX = I(c), i.scaleY = I(p), i.rotation = I(h) + o, i.rotationX = I(m) + o, i.rotationY = I(y) + o, i.skewX = x + o, i.skewY = v + o, i.transformPerspective = T + s, (i.zOrigin = parseFloat(l.split(" ")[2]) || !e && i.zOrigin || 0) && (r[J] = Ae(l)), i.xOffset = i.yOffset = 0, i.force3D = nt.force3D, i.renderTransform = i.svg ? ds : zr ? Nr : cs, i.uncache = 0, i;
}, Ae = function(t) {
  return (t = t.split(" "))[0] + " " + t[1];
}, qe = function(t, e, i) {
  var r = G(e);
  return I(parseFloat(e) + parseFloat(Ct(t, "x", i + "px", r))) + r;
}, cs = function(t, e) {
  e.z = "0px", e.rotationY = e.rotationX = "0deg", e.force3D = 0, Nr(t, e);
}, Rt = "0deg", re = "0px", Et = ") ", Nr = function(t, e) {
  var i = e || this, r = i.xPercent, n = i.yPercent, s = i.x, o = i.y, u = i.z, l = i.rotation, f = i.rotationY, _ = i.rotationX, d = i.skewX, c = i.skewY, p = i.scaleX, h = i.scaleY, m = i.transformPerspective, y = i.force3D, x = i.target, v = i.zOrigin, T = "", g = y === "auto" && t && t !== 1 || y === true;
  if (v && (_ !== Rt || f !== Rt)) {
    var b = parseFloat(f) * Kt, P = Math.sin(b), S = Math.cos(b), w;
    b = parseFloat(_) * Kt, w = Math.cos(b), s = qe(x, s, P * w * -v), o = qe(x, o, -Math.sin(b) * -v), u = qe(x, u, S * w * -v + v);
  }
  m !== re && (T += "perspective(" + m + Et), (r || n) && (T += "translate(" + r + "%, " + n + "%) "), (g || s !== re || o !== re || u !== re) && (T += u !== re || g ? "translate3d(" + s + ", " + o + ", " + u + ") " : "translate(" + s + ", " + o + Et), l !== Rt && (T += "rotate(" + l + Et), f !== Rt && (T += "rotateY(" + f + Et), _ !== Rt && (T += "rotateX(" + _ + Et), (d !== Rt || c !== Rt) && (T += "skew(" + d + ", " + c + Et), (p !== 1 || h !== 1) && (T += "scale(" + p + ", " + h + Et), x.style[z] = T || "translate(0, 0)";
}, ds = function(t, e) {
  var i = e || this, r = i.xPercent, n = i.yPercent, s = i.x, o = i.y, u = i.rotation, l = i.skewX, f = i.skewY, _ = i.scaleX, d = i.scaleY, c = i.target, p = i.xOrigin, h = i.yOrigin, m = i.xOffset, y = i.yOffset, x = i.forceCSS, v = parseFloat(s), T = parseFloat(o), g, b, P, S, w;
  u = parseFloat(u), l = parseFloat(l), f = parseFloat(f), f && (f = parseFloat(f), l += f, u += f), u || l ? (u *= Kt, l *= Kt, g = Math.cos(u) * _, b = Math.sin(u) * _, P = Math.sin(u - l) * -d, S = Math.cos(u - l) * d, l && (f *= Kt, w = Math.tan(l - f), w = Math.sqrt(1 + w * w), P *= w, S *= w, f && (w = Math.tan(f), w = Math.sqrt(1 + w * w), g *= w, b *= w)), g = I(g), b = I(b), P = I(P), S = I(S)) : (g = _, S = d, b = P = 0), (v && !~(s + "").indexOf("px") || T && !~(o + "").indexOf("px")) && (v = Ct(c, "x", s, "px"), T = Ct(c, "y", o, "px")), (p || h || m || y) && (v = I(v + p - (p * g + h * P) + m), T = I(T + h - (p * b + h * S) + y)), (r || n) && (w = c.getBBox(), v = I(v + r / 100 * w.width), T = I(T + n / 100 * w.height)), w = "matrix(" + g + "," + b + "," + P + "," + S + "," + v + "," + T + ")", c.setAttribute("transform", w), x && (c.style[z] = w);
}, ps = function(t, e, i, r, n) {
  var s = 360, o = q(n), u = parseFloat(n) * (o && ~n.indexOf("rad") ? Ft : 1), l = u - r, f = r + l + "deg", _, d;
  return o && (_ = n.split("_")[1], _ === "short" && (l %= s, l !== l % (s / 2) && (l += l < 0 ? s : -s)), _ === "cw" && l < 0 ? l = (l + s * zi) % s - ~~(l / s) * s : _ === "ccw" && l > 0 && (l = (l - s * zi) % s - ~~(l / s) * s)), t._pt = d = new Z(t._pt, e, i, r, l, Jn), d.e = f, d.u = "deg", t._props.push(i), d;
}, Yi = function(t, e) {
  for (var i in e) t[i] = e[i];
  return t;
}, ms = function(t, e, i) {
  var r = Yi({}, i._gsap), n = "perspective,force3D,transformOrigin,svgOrigin", s = i.style, o, u, l, f, _, d, c, p;
  r.svg ? (l = i.getAttribute("transform"), i.setAttribute("transform", ""), s[z] = e, o = me(i, 1), Nt(i, z), i.setAttribute("transform", l)) : (l = getComputedStyle(i)[z], s[z] = e, o = me(i, 1), s[z] = l);
  for (u in vt) l = r[u], f = o[u], l !== f && n.indexOf(u) < 0 && (c = G(l), p = G(f), _ = c !== p ? Ct(i, u, l, p) : parseFloat(l), d = parseFloat(f), t._pt = new Z(t._pt, o, u, _, d - _, ei), t._pt.u = p || 0, t._props.push(u));
  Yi(o, r);
};
H("padding,margin,Width,Radius", function(a15, t) {
  var e = "Top", i = "Right", r = "Bottom", n = "Left", s = (t < 3 ? [e, i, r, n] : [e + n, e + i, r + i, r + n]).map(function(o) {
    return t < 2 ? a15 + o : "border" + o + a15;
  });
  De[t > 1 ? "border" + a15 : a15] = function(o, u, l, f, _) {
    var d, c;
    if (arguments.length < 4) return d = s.map(function(p) {
      return yt(o, p, l);
    }), c = d.join(" "), c.split(d[0]).length === 5 ? d[0] : c;
    d = (f + "").split(" "), c = {}, s.forEach(function(p, h) {
      return c[p] = d[h] = d[h] || d[(h - 1) / 2 | 0];
    }), o.init(u, c, _);
  };
});
var Ur = { name: "css", register: ri, targetTest: function(t) {
  return t.style && t.nodeType;
}, init: function(t, e, i, r, n) {
  var s = this._props, o = t.style, u = i.vars.startAt, l, f, _, d, c, p, h, m, y, x, v, T, g, b, P, S;
  xi || ri(), this.styles = this.styles || Fr(t), S = this.styles.props, this.tween = i;
  for (h in e) if (h !== "autoRound" && (f = e[h], !(et[h] && br(h, e, i, r, t, n)))) {
    if (c = typeof f, p = De[h], c === "function" && (f = f.call(i, r, t, n), c = typeof f), c === "string" && ~f.indexOf("random(") && (f = _e(f)), p) p(this, t, h, f, i) && (P = 1);
    else if (h.substr(0, 2) === "--") l = (getComputedStyle(t).getPropertyValue(h) + "").trim(), f += "", St.lastIndex = 0, St.test(l) || (m = G(l), y = G(f)), y ? m !== y && (l = Ct(t, h, l, y) + y) : m && (f += m), this.add(o, "setProperty", l, f, r, n, 0, 0, h), s.push(h), S.push(h, 0, o[h]);
    else if (c !== "undefined") {
      if (u && h in u ? (l = typeof u[h] == "function" ? u[h].call(i, r, t, n) : u[h], q(l) && ~l.indexOf("random(") && (l = _e(l)), G(l + "") || l === "auto" || (l += nt.units[h] || G(yt(t, h)) || ""), (l + "").charAt(1) === "=" && (l = yt(t, h))) : l = yt(t, h), d = parseFloat(l), x = c === "string" && f.charAt(1) === "=" && f.substr(0, 2), x && (f = f.substr(2)), _ = parseFloat(f), h in dt && (h === "autoAlpha" && (d === 1 && yt(t, "visibility") === "hidden" && _ && (d = 0), S.push("visibility", 0, o.visibility), bt(this, o, "visibility", d ? "inherit" : "hidden", _ ? "inherit" : "hidden", !_)), h !== "scale" && h !== "transform" && (h = dt[h], ~h.indexOf(",") && (h = h.split(",")[0]))), v = h in vt, v) {
        if (this.styles.save(h), c === "string" && f.substring(0, 6) === "var(--" && (f = ft(t, f.substring(4, f.indexOf(")"))), _ = parseFloat(f)), T || (g = t._gsap, g.renderTransform && !e.parseTransform || me(t, e.parseTransform), b = e.smoothOrigin !== false && g.smooth, T = this._pt = new Z(this._pt, o, z, 0, 1, g.renderTransform, g, 0, -1), T.dep = 1), h === "scale") this._pt = new Z(this._pt, g, "scaleY", g.scaleY, (x ? Wt(g.scaleY, x + _) : _) - g.scaleY || 0, ei), this._pt.u = 0, s.push("scaleY", h), h += "X";
        else if (h === "transformOrigin") {
          S.push(J, 0, o[J]), f = hs(f), g.svg ? ni(t, f, 0, b, 0, this) : (y = parseFloat(f.split(" ")[2]) || 0, y !== g.zOrigin && bt(this, g, "zOrigin", g.zOrigin, y), bt(this, o, h, Ae(l), Ae(f)));
          continue;
        } else if (h === "svgOrigin") {
          ni(t, f, 1, b, 0, this);
          continue;
        } else if (h in Br) {
          ps(this, g, h, d, x ? Wt(d, x + f) : f);
          continue;
        } else if (h === "smoothOrigin") {
          bt(this, g, "smooth", g.smooth, f);
          continue;
        } else if (h === "force3D") {
          g[h] = f;
          continue;
        } else if (h === "transform") {
          ms(this, f, t);
          continue;
        }
      } else h in o || (h = $t(h) || h);
      if (v || (_ || _ === 0) && (d || d === 0) && !Zn.test(f) && h in o) m = (l + "").substr((d + "").length), _ || (_ = 0), y = G(f) || (h in nt.units ? nt.units[h] : m), m !== y && (d = Ct(t, h, l, y)), this._pt = new Z(this._pt, v ? g : o, h, d, (x ? Wt(d, x + _) : _) - d, !v && (y === "px" || h === "zIndex") && e.autoRound !== false ? ts : ei), this._pt.u = y || 0, m !== y && y !== "%" && (this._pt.b = l, this._pt.r = $n);
      else if (h in o) fs.call(this, t, h, l, x ? x + f : f);
      else if (h in t) this.add(t, h, l || t[h], x ? x + f : f, r, n);
      else if (h !== "parseTransform") {
        li(h, f);
        continue;
      }
      v || (h in o ? S.push(h, 0, o[h]) : typeof t[h] == "function" ? S.push(h, 2, t[h]()) : S.push(h, 1, l || t[h])), s.push(h);
    }
  }
  P && Mr(this);
}, render: function(t, e) {
  if (e.tween._time || !vi()) for (var i = e._pt; i; ) i.r(t, i.d), i = i._next;
  else e.styles.revert();
}, get: yt, aliases: dt, getSetter: function(t, e, i) {
  var r = dt[e];
  return r && r.indexOf(",") < 0 && (e = r), e in vt && e !== J && (t._gsap.x || yt(t, "x")) ? i && Fi === i ? e === "scale" ? ns : rs : (Fi = i || {}) && (e === "scale" ? ss : os) : t.style && !oi(t.style[e]) ? es : ~e.indexOf("-") ? is : gi(t, e);
}, core: { _removeProperty: Nt, _getMatrix: wi } };
$.utils.checkPrefix = $t;
$.core.getStyleSaver = Fr;
(function(a15, t, e, i) {
  var r = H(a15 + "," + t + "," + e, function(n) {
    vt[n] = 1;
  });
  H(t, function(n) {
    nt.units[n] = "deg", Br[n] = 1;
  }), dt[r[13]] = a15 + "," + t, H(i, function(n) {
    var s = n.split(":");
    dt[s[1]] = r[s[0]];
  });
})("x,y,z,scale,scaleX,scaleY,xPercent,yPercent", "rotation,rotationX,rotationY,skewX,skewY", "transform,transformOrigin,svgOrigin,force3D,smoothOrigin,transformPerspective", "0:translateX,1:translateY,2:translateZ,8:rotate,8:rotationZ,8:rotateZ,9:rotateX,10:rotateY");
H("x,y,z,top,right,bottom,left,width,height,fontSize,padding,margin,perspective", function(a15) {
  nt.units[a15] = "px";
});
$.registerPlugin(Ur);
var gs = $.registerPlugin(Ur) || $, ne = gs.core.Tween;
const ys = { name: "LoginLoginComponent", components: { ForgotPassword: en }, data() {
  return { waveColor: ["rgba(255, 255, 255, .3)", "rgba(255, 255, 255, .5)"], waveHeight: [40, 30], loginForm: { username: "", password: "", rememberMe: false }, loginRules: { username: [{ required: true, trigger: "blur", validator: (e, i, r) => {
    i ? r() : r(new Error("请填写用户名"));
  } }], password: [{ required: true, trigger: "blur", validator: (e, i, r) => {
    i.length < 6 ? r(new Error("密码不能小于6位")) : r();
  } }] }, passwordType: "password", showAuthent: false, authentText: "认证中，请稍后", capsTooltip: false, loading: false, showDialog: false, redirect: void 0, otherQuery: {}, loginTween: void 0, clientWidth: 0, model: "login" };
}, computed: { ...Yr(["token", "roles"]) }, mounted() {
  this.clientWidth = document.documentElement.clientHeight, window.addEventListener("resize", this.redraw, { passive: false });
}, methods: { resetPwd() {
  this.model = "forgotPassword";
}, redraw() {
  this.clientWidth = document.documentElement.clientHeight;
}, async clearRequestUrl() {
  await this.$store.dispatch("user/resetRequestUrl"), this.$emit("show-reg-company");
}, checkCapslock({ shiftKey: a15, key: t } = {}) {
  t && t.length === 1 && (a15 && t >= "a" && t <= "z" || !a15 && t >= "A" && t <= "Z" ? this.capsTooltip = true : this.capsTooltip = false), t === "CapsLock" && this.capsTooltip === true && (this.capsTooltip = false);
}, showPwd() {
  this.passwordType === "password" ? this.passwordType = "" : this.passwordType = "password", this.$nextTick(() => {
    this.$refs.password.focus();
  });
}, async login() {
  this.$refs.loginForm.validate(async (a15) => {
    if (a15) {
      this.loading = true, this.changeLoginBox(true), await this.changeAuthentBox(true);
      try {
        await this.$store.dispatch("user/login", this.loginForm), this.authentText = "认证成功", await this.$store.dispatch("user/getInfo"), await this.$store.dispatch("config/fetchConfigInfo"), await this.$store.dispatch("config/fetchClosingTimeConfig");
      } catch (t) {
        console.log("登录报错", t), this.authentText = "认证失败，请重新登录";
      } finally {
        this.loginResult();
      }
    } else return console.log("请填写正确的信息"), false;
  });
}, async loginResult() {
  await ve(1e3), this.loading = false, this.changeAuthentBox(false);
  const a15 = !!(this.token && this.roles && this.roles.length > 0);
  a15 ? await this.removeLoginBox() : (this.$store.dispatch("user/logout"), await this.changeLoginBox(false)), this.$emit("login", { success: a15 });
}, async removeLoginBox() {
  this.loginTween = new ne("#login-content", 1e3 / 1e3, { x: -500, alpha: 0 }), await ve(1e3);
}, async changeLoginBox(a15) {
  a15 ? this.loginTween = new ne("#login-content", 1e3 / 1e3, { x: -200, rotateX: 30, alpha: 0.3 }) : ne.to("#login-content", 1e3 / 1e3, { x: 0, rotateX: 0, alpha: 1 }), await ve(1e3);
}, async changeAuthentBox(a15) {
  a15 ? (this.authentText = "认证中，请稍后", this.showAuthent = true, ne.fromTo("#authent", 1e3 / 1e3, { x: 100, opacity: 0 }, { x: 300, opacity: 1 })) : ne.fromTo("#authent", 1e3 / 1e3, { x: 300, opacity: 1 }, { x: 500, opacity: 0 }), await ve(1e3), this.showAuthent = a15;
}, returnLogin(a15) {
  this.model = a15;
} } }, xs = { class: "login-container" }, vs = { id: "login-content", class: "login-content" }, Ts = { class: "forget-pwd-content" }, ws = { id: "authent", class: "authent" };
function bs(a15, t, e, i, r, n) {
  const s = Qr, o = Hr, u = tn, l = Zr, f = Pi("common-button"), _ = Jr, d = Pi("forgot-password");
  return xe(), qr("div", xs, [tt("div", vs, [t[10] || (t[10] = tt("div", { class: "title-container" }, [tt("h3", { class: "title" }, [tt("span", { class: "login-title-text" }, [Si("钢结构工业互联网平台"), tt("span", { class: "replica-edition" }, "复刻版")]), tt("span", { class: "edition" }, "集团联营版")])], -1)), r.model === "login" ? (xe(), ze(_, { key: 0, ref: "loginForm", model: r.loginForm, rules: r.loginRules, "auto-complete": "off", class: "login-form", "label-position": "left" }, { default: ie(() => [At(o, { label: "账号：", prop: "username" }, { default: ie(() => [At(s, { ref: "username", modelValue: r.loginForm.username, "onUpdate:modelValue": t[0] || (t[0] = (c) => r.loginForm.username = c), "auto-complete": "off", name: "username", placeholder: "员工编号/手机号/邮箱", size: "default", tabindex: "1", type: "text" }, null, 8, ["modelValue"])]), _: 1 }), At(l, { modelValue: r.capsTooltip, "onUpdate:modelValue": t[4] || (t[4] = (c) => r.capsTooltip = c), content: "大写锁定", manual: "", placement: "right" }, { default: ie(() => [At(o, { label: "密码：", prop: "password" }, { default: ie(() => [(xe(), ze(s, { key: r.passwordType, ref: "password", modelValue: r.loginForm.password, "onUpdate:modelValue": t[1] || (t[1] = (c) => r.loginForm.password = c), type: r.passwordType, "auto-complete": "off", name: "password", placeholder: "密码", tabindex: "2", onBlur: t[2] || (t[2] = (c) => r.capsTooltip = false), onKeyup: [n.checkCapslock, Xr(n.login, ["enter"])] }, null, 8, ["modelValue", "type", "onKeyup"])), tt("span", { class: "show-pwd", onClick: t[3] || (t[3] = (...c) => n.showPwd && n.showPwd(...c)) }, [At(u, { "icon-class": r.passwordType === "password" ? "eye" : "eye-open" }, null, 8, ["icon-class"])])]), _: 1 })]), _: 1 }, 8, ["modelValue"]), tt("div", Ts, [tt("span", { class: "change-title", onClick: t[5] || (t[5] = (...c) => n.clearRequestUrl && n.clearRequestUrl(...c)) }, "更换域名"), t[8] || (t[8] = tt("span", null, null, -1)), tt("div", null, [tt("span", { onClick: t[6] || (t[6] = (...c) => n.resetPwd && n.resetPwd(...c)) }, "忘记密码？"), t[7] || (t[7] = tt("span", null, null, -1))])]), At(f, { loading: r.loading, size: "default", style: { width: "396px", "margin-bottom": "30px", "margin-left": "54px" }, type: "primary", onClick: n.login }, { default: ie(() => t[9] || (t[9] = [Si(" 登录 ")])), _: 1, __: [9] }, 8, ["loading", "onClick"])]), _: 1 }, 8, ["model", "rules"])) : r.model === "forgotPassword" ? (xe(), ze(d, { key: 1, onReturnLogin: n.returnLogin }, null, 8, ["onReturnLogin"])) : Wr("", true)]), Gr(tt("div", ws, [At(u, { "icon-class": "puff" }), tt("p", null, jr(r.authentText), 1)], 512), [[Kr, r.showAuthent]])]);
}
const Ps = $r(ys, [["render", bs], ["__scopeId", "data-v-bee6a0d8"]]), Ms = Object.freeze(Object.defineProperty({ __proto__: null, default: Ps }, Symbol.toStringTag, { value: "Module" }));
export {
  Ps as L,
  ks as P,
  ne as T,
  Ms as i
};
