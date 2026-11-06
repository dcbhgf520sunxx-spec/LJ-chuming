var k1 = Object.defineProperty;
var P1 = (t3, n, e) => n in t3 ? k1(t3, n, { enumerable: true, configurable: true, writable: true, value: e }) : t3[n] = e;
var Pe = (t3, n, e) => (P1(t3, typeof n != "symbol" ? n + "" : n, e), e);
import C1 from "../../../../../../modules/html2canvas.esm-e0a7d97b.js";
import { j0 as vl, _ as E1, p as bl, $ as su } from "../../../../../../shared/runtime.js";
import { ref as cs } from "vue";
import { resolveDirective as I1 } from "vue";
import { openBlock as Gt } from "vue";
import { createElementBlock as Zt } from "vue";
import { createElementVNode as Ft } from "vue";
import { withDirectives as ce } from "vue";
import { createTextVNode as fe } from "vue";
import { toDisplayString as de } from "vue";
import { Fragment as wl } from "vue";
import { renderList as _l } from "vue";
import { createCommentVNode as lu } from "vue";
import { unref as hu } from "vue";
function Ce(t3) {
  "@babel/helpers - typeof";
  return Ce = typeof Symbol == "function" && typeof Symbol.iterator == "symbol" ? function(n) {
    return typeof n;
  } : function(n) {
    return n && typeof Symbol == "function" && n.constructor === Symbol && n !== Symbol.prototype ? "symbol" : typeof n;
  }, Ce(t3);
}
var gr = Uint8Array, Yn = Uint16Array, ch = Int32Array, fh = new gr([0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 0, 0, 0, 0]), dh = new gr([0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13, 0, 0]), uu = new gr([16, 17, 18, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, 14, 1, 15]), Tc = function(t3, n) {
  for (var e = new Yn(31), r = 0; r < 31; ++r) e[r] = n += 1 << t3[r - 1];
  for (var i = new ch(e[30]), r = 1; r < 30; ++r) for (var o = e[r]; o < e[r + 1]; ++o) i[o] = o - e[r] << 5 | r;
  return { b: e, r: i };
}, Rc = Tc(fh, 2), F1 = Rc.b, Yl = Rc.r;
F1[28] = 258, Yl[258] = 28;
var O1 = Tc(dh, 0), cu = O1.r, $l = new Yn(32768);
for (var qe = 0; qe < 32768; ++qe) {
  var di = (qe & 43690) >> 1 | (qe & 21845) << 1;
  di = (di & 52428) >> 2 | (di & 13107) << 2, di = (di & 61680) >> 4 | (di & 3855) << 4, $l[qe] = ((di & 65280) >> 8 | (di & 255) << 8) >> 1;
}
var po = function(t3, n, e) {
  for (var r = t3.length, i = 0, o = new Yn(n); i < r; ++i) t3[i] && ++o[t3[i] - 1];
  var u = new Yn(n);
  for (i = 1; i < n; ++i) u[i] = u[i - 1] + o[i - 1] << 1;
  var l;
  if (e) {
    l = new Yn(1 << n);
    var f = 15 - n;
    for (i = 0; i < r; ++i) if (t3[i]) for (var c = i << 4 | t3[i], p = n - t3[i], x = u[t3[i] - 1]++ << p, L = x | (1 << p) - 1; x <= L; ++x) l[$l[x] >> f] = c;
  } else for (l = new Yn(r), i = 0; i < r; ++i) t3[i] && (l[i] = $l[u[t3[i] - 1]++] >> 15 - t3[i]);
  return l;
}, Ji = new gr(288);
for (var qe = 0; qe < 144; ++qe) Ji[qe] = 8;
for (var qe = 144; qe < 256; ++qe) Ji[qe] = 9;
for (var qe = 256; qe < 280; ++qe) Ji[qe] = 7;
for (var qe = 280; qe < 288; ++qe) Ji[qe] = 8;
var Cs = new gr(32);
for (var qe = 0; qe < 32; ++qe) Cs[qe] = 5;
var T1 = po(Ji, 9, 0), R1 = po(Cs, 5, 0), Mc = function(t3) {
  return (t3 + 7) / 8 | 0;
}, M1 = function(t3, n, e) {
  return (n == null || n < 0) && (n = 0), (e == null || e > t3.length) && (e = t3.length), new gr(t3.subarray(n, e));
}, Gr = function(t3, n, e) {
  e <<= n & 7;
  var r = n / 8 | 0;
  t3[r] |= e, t3[r + 1] |= e >> 8;
}, lo = function(t3, n, e) {
  e <<= n & 7;
  var r = n / 8 | 0;
  t3[r] |= e, t3[r + 1] |= e >> 8, t3[r + 2] |= e >> 16;
}, yl = function(t3, n) {
  for (var e = [], r = 0; r < t3.length; ++r) t3[r] && e.push({ s: r, f: t3[r] });
  var i = e.length, o = e.slice();
  if (!i) return { t: jc, l: 0 };
  if (i == 1) {
    var u = new gr(e[0].s + 1);
    return u[e[0].s] = 1, { t: u, l: 1 };
  }
  e.sort(function(it, bt) {
    return it.f - bt.f;
  }), e.push({ s: -1, f: 25001 });
  var l = e[0], f = e[1], c = 0, p = 1, x = 2;
  for (e[0] = { s: -1, f: l.f + f.f, l, r: f }; p != i - 1; ) l = e[e[c].f < e[x].f ? c++ : x++], f = e[c != p && e[c].f < e[x].f ? c++ : x++], e[p++] = { s: -1, f: l.f + f.f, l, r: f };
  for (var L = o[0].s, r = 1; r < i; ++r) o[r].s > L && (L = o[r].s);
  var g = new Yn(L + 1), O = Kl(e[p - 1], g, 0);
  if (O > n) {
    var r = 0, P = 0, M = O - n, k = 1 << M;
    for (o.sort(function(bt, dt) {
      return g[dt.s] - g[bt.s] || bt.f - dt.f;
    }); r < i; ++r) {
      var V = o[r].s;
      if (g[V] > n) P += k - (1 << O - g[V]), g[V] = n;
      else break;
    }
    for (P >>= M; P > 0; ) {
      var G = o[r].s;
      g[G] < n ? P -= 1 << n - g[G]++ - 1 : ++r;
    }
    for (; r >= 0 && P; --r) {
      var D = o[r].s;
      g[D] == n && (--g[D], ++P);
    }
    O = n;
  }
  return { t: new gr(g), l: O };
}, Kl = function(t3, n, e) {
  return t3.s == -1 ? Math.max(Kl(t3.l, n, e + 1), Kl(t3.r, n, e + 1)) : n[t3.s] = e;
}, fu = function(t3) {
  for (var n = t3.length; n && !t3[--n]; ) ;
  for (var e = new Yn(++n), r = 0, i = t3[0], o = 1, u = function(f) {
    e[r++] = f;
  }, l = 1; l <= n; ++l) if (t3[l] == i && l != n) ++o;
  else {
    if (!i && o > 2) {
      for (; o > 138; o -= 138) u(32754);
      o > 2 && (u(o > 10 ? o - 11 << 5 | 28690 : o - 3 << 5 | 12305), o = 0);
    } else if (o > 3) {
      for (u(i), --o; o > 6; o -= 6) u(8304);
      o > 2 && (u(o - 3 << 5 | 8208), o = 0);
    }
    for (; o--; ) u(i);
    o = 1, i = t3[l];
  }
  return { c: e.subarray(0, r), n };
}, ho = function(t3, n) {
  for (var e = 0, r = 0; r < n.length; ++r) e += t3[r] * n[r];
  return e;
}, Bc = function(t3, n, e) {
  var r = e.length, i = Mc(n + 2);
  t3[i] = r & 255, t3[i + 1] = r >> 8, t3[i + 2] = t3[i] ^ 255, t3[i + 3] = t3[i + 1] ^ 255;
  for (var o = 0; o < r; ++o) t3[i + o + 4] = e[o];
  return (i + 4 + r) * 8;
}, du = function(t3, n, e, r, i, o, u, l, f, c, p) {
  Gr(n, p++, e), ++i[256];
  for (var x = yl(i, 15), L = x.t, g = x.l, O = yl(o, 15), P = O.t, M = O.l, k = fu(L), V = k.c, G = k.n, D = fu(P), it = D.c, bt = D.n, dt = new Yn(19), $ = 0; $ < V.length; ++$) ++dt[V[$] & 31];
  for (var $ = 0; $ < it.length; ++$) ++dt[it[$] & 31];
  for (var j = yl(dt, 7), J = j.t, N = j.l, C = 19; C > 4 && !J[uu[C - 1]]; --C) ;
  var z = c + 5 << 3, q = ho(i, Ji) + ho(o, Cs) + u, rt = ho(i, L) + ho(o, P) + u + 14 + 3 * C + ho(dt, J) + 2 * dt[16] + 3 * dt[17] + 7 * dt[18];
  if (f >= 0 && z <= q && z <= rt) return Bc(n, p, t3.subarray(f, f + c));
  var st, ht, tt, ft;
  if (Gr(n, p, 1 + (rt < q)), p += 2, rt < q) {
    st = po(L, g, 0), ht = L, tt = po(P, M, 0), ft = P;
    var Lt = po(J, N, 0);
    Gr(n, p, G - 257), Gr(n, p + 5, bt - 1), Gr(n, p + 10, C - 4), p += 14;
    for (var $ = 0; $ < C; ++$) Gr(n, p + 3 * $, J[uu[$]]);
    p += 3 * C;
    for (var lt = [V, it], _ = 0; _ < 2; ++_) for (var T = lt[_], $ = 0; $ < T.length; ++$) {
      var B = T[$] & 31;
      Gr(n, p, Lt[B]), p += J[B], B > 15 && (Gr(n, p, T[$] >> 5 & 127), p += T[$] >> 12);
    }
  } else st = T1, ht = Ji, tt = R1, ft = Cs;
  for (var $ = 0; $ < l; ++$) {
    var H = r[$];
    if (H > 255) {
      var B = H >> 18 & 31;
      lo(n, p, st[B + 257]), p += ht[B + 257], B > 7 && (Gr(n, p, H >> 23 & 31), p += fh[B]);
      var Y = H & 31;
      lo(n, p, tt[Y]), p += ft[Y], Y > 3 && (lo(n, p, H >> 5 & 8191), p += dh[Y]);
    } else lo(n, p, st[H]), p += ht[H];
  }
  return lo(n, p, st[256]), p + ht[256];
}, B1 = new ch([65540, 131080, 131088, 131104, 262176, 1048704, 1048832, 2114560, 2117632]), jc = new gr(0), j1 = function(t3, n, e, r, i, o) {
  var u = o.z || t3.length, l = new gr(r + u + 5 * (1 + Math.ceil(u / 7e3)) + i), f = l.subarray(r, l.length - i), c = o.l, p = (o.r || 0) & 7;
  if (n) {
    p && (f[0] = o.r >> 3);
    for (var x = B1[n - 1], L = x >> 13, g = x & 8191, O = (1 << e) - 1, P = o.p || new Yn(32768), M = o.h || new Yn(O + 1), k = Math.ceil(e / 3), V = 2 * k, G = function(ut) {
      return (t3[ut] ^ t3[ut + 1] << k ^ t3[ut + 2] << V) & O;
    }, D = new ch(25e3), it = new Yn(288), bt = new Yn(32), dt = 0, $ = 0, j = o.i || 0, J = 0, N = o.w || 0, C = 0; j + 2 < u; ++j) {
      var z = G(j), q = j & 32767, rt = M[z];
      if (P[q] = rt, M[z] = q, N <= j) {
        var st = u - j;
        if ((dt > 7e3 || J > 24576) && (st > 423 || !c)) {
          p = du(t3, f, 0, D, it, bt, $, J, C, j - C, p), J = dt = $ = 0, C = j;
          for (var ht = 0; ht < 286; ++ht) it[ht] = 0;
          for (var ht = 0; ht < 30; ++ht) bt[ht] = 0;
        }
        var tt = 2, ft = 0, Lt = g, lt = q - rt & 32767;
        if (st > 2 && z == G(j - lt)) for (var _ = Math.min(L, st) - 1, T = Math.min(32767, j), B = Math.min(258, st); lt <= T && --Lt && q != rt; ) {
          if (t3[j + tt] == t3[j + tt - lt]) {
            for (var H = 0; H < B && t3[j + H] == t3[j + H - lt]; ++H) ;
            if (H > tt) {
              if (tt = H, ft = lt, H > _) break;
              for (var Y = Math.min(lt, H - 2), nt = 0, ht = 0; ht < Y; ++ht) {
                var ot = j - lt + ht & 32767, at = P[ot], vt = ot - at & 32767;
                vt > nt && (nt = vt, rt = ot);
              }
            }
          }
          q = rt, rt = P[q], lt += q - rt & 32767;
        }
        if (ft) {
          D[J++] = 268435456 | Yl[tt] << 18 | cu[ft];
          var xt = Yl[tt] & 31, kt = cu[ft] & 31;
          $ += fh[xt] + dh[kt], ++it[257 + xt], ++bt[kt], N = j + tt, ++dt;
        } else D[J++] = t3[j], ++it[t3[j]];
      }
    }
    for (j = Math.max(j, N); j < u; ++j) D[J++] = t3[j], ++it[t3[j]];
    p = du(t3, f, c, D, it, bt, $, J, C, j - C, p), c || (o.r = p & 7 | f[p / 8 | 0] << 3, p -= 7, o.h = M, o.p = P, o.i = j, o.w = N);
  } else {
    for (var j = o.w || 0; j < u + c; j += 65535) {
      var Pt = j + 65535;
      Pt >= u && (f[p / 8 | 0] = c, Pt = u), p = Bc(f, p + 1, t3.subarray(j, Pt));
    }
    o.i = u;
  }
  return M1(l, 0, r + Mc(p) + i);
}, Dc = function() {
  var t3 = 1, n = 0;
  return { p: function(e) {
    for (var r = t3, i = n, o = e.length | 0, u = 0; u != o; ) {
      for (var l = Math.min(u + 2655, o); u < l; ++u) i += r += e[u];
      r = (r & 65535) + 15 * (r >> 16), i = (i & 65535) + 15 * (i >> 16);
    }
    t3 = r, n = i;
  }, d: function() {
    return t3 %= 65521, n %= 65521, (t3 & 255) << 24 | (t3 & 65280) << 8 | (n & 255) << 8 | n >> 8;
  } };
}, D1 = function(t3, n, e, r, i) {
  if (!i && (i = { l: 1 }, n.dictionary)) {
    var o = n.dictionary.subarray(-32768), u = new gr(o.length + t3.length);
    u.set(o), u.set(t3, o.length), t3 = u, i.w = o.length;
  }
  return j1(t3, n.level == null ? 6 : n.level, n.mem == null ? i.l ? Math.ceil(Math.max(8, Math.min(13, Math.log(t3.length))) * 1.5) : 20 : 12 + n.mem, e, r, i);
}, qc = function(t3, n, e) {
  for (; e; ++n) t3[n] = e, e >>>= 8;
}, q1 = function(t3, n) {
  var e = n.level, r = e == 0 ? 0 : e < 6 ? 1 : e == 9 ? 3 : 2;
  if (t3[0] = 120, t3[1] = r << 6 | (n.dictionary && 32), t3[1] |= 31 - (t3[0] << 8 | t3[1]) % 31, n.dictionary) {
    var i = Dc();
    i.p(n.dictionary), qc(t3, 2, i.d());
  }
};
function Xl(t3, n) {
  n || (n = {});
  var e = Dc();
  e.p(t3);
  var r = D1(t3, n, n.dictionary ? 6 : 2, 4);
  return q1(r, n), qc(r, r.length - 4, e.d()), r;
}
var U1 = typeof TextDecoder < "u" && new TextDecoder(), z1 = 0;
try {
  U1.decode(jc, { stream: true }), z1 = 1;
} catch {
}
function H1(t3) {
  if (Array.isArray(t3)) return t3;
}
function W1(t3, n) {
  var e = t3 == null ? null : typeof Symbol < "u" && t3[Symbol.iterator] || t3["@@iterator"];
  if (e != null) {
    var r, i, o, u, l = [], f = true, c = false;
    try {
      if (o = (e = e.call(t3)).next, n === 0) {
        if (Object(e) !== e) return;
        f = false;
      } else for (; !(f = (r = o.call(e)).done) && (l.push(r.value), l.length !== n); f = true) ;
    } catch (p) {
      c = true, i = p;
    } finally {
      try {
        if (!f && e.return != null && (u = e.return(), Object(u) !== u)) return;
      } finally {
        if (c) throw i;
      }
    }
    return l;
  }
}
function pu(t3, n) {
  (n == null || n > t3.length) && (n = t3.length);
  for (var e = 0, r = Array(n); e < n; e++) r[e] = t3[e];
  return r;
}
function V1(t3, n) {
  if (t3) {
    if (typeof t3 == "string") return pu(t3, n);
    var e = {}.toString.call(t3).slice(8, -1);
    return e === "Object" && t3.constructor && (e = t3.constructor.name), e === "Map" || e === "Set" ? Array.from(t3) : e === "Arguments" || /^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(e) ? pu(t3, n) : void 0;
  }
}
function G1() {
  throw new TypeError(`Invalid attempt to destructure non-iterable instance.
In order to be iterable, non-array objects must have a [Symbol.iterator]() method.`);
}
function gu(t3, n) {
  return H1(t3) || W1(t3, n) || V1(t3, n) || G1();
}
function mu(t3, n = "utf8") {
  return new TextDecoder(n).decode(t3);
}
const Z1 = new TextEncoder();
function Y1(t3) {
  return Z1.encode(t3);
}
const $1 = 1024 * 8, K1 = (() => {
  const t3 = new Uint8Array(4), n = new Uint32Array(t3.buffer);
  return !((n[0] = 1) & t3[0]);
})(), xl = { int8: globalThis.Int8Array, uint8: globalThis.Uint8Array, int16: globalThis.Int16Array, uint16: globalThis.Uint16Array, int32: globalThis.Int32Array, uint32: globalThis.Uint32Array, uint64: globalThis.BigUint64Array, int64: globalThis.BigInt64Array, float32: globalThis.Float32Array, float64: globalThis.Float64Array };
class ph {
  constructor(n = $1, e = {}) {
    Pe(this, "buffer");
    Pe(this, "byteLength");
    Pe(this, "byteOffset");
    Pe(this, "length");
    Pe(this, "offset");
    Pe(this, "lastWrittenByte");
    Pe(this, "littleEndian");
    Pe(this, "_data");
    Pe(this, "_mark");
    Pe(this, "_marks");
    let r = false;
    typeof n == "number" ? n = new ArrayBuffer(n) : (r = true, this.lastWrittenByte = n.byteLength);
    const i = e.offset ? e.offset >>> 0 : 0, o = n.byteLength - i;
    let u = i;
    (ArrayBuffer.isView(n) || n instanceof ph) && (n.byteLength !== n.buffer.byteLength && (u = n.byteOffset + i), n = n.buffer), r ? this.lastWrittenByte = o : this.lastWrittenByte = 0, this.buffer = n, this.length = o, this.byteLength = o, this.byteOffset = u, this.offset = 0, this.littleEndian = true, this._data = new DataView(this.buffer, u, o), this._mark = 0, this._marks = [];
  }
  available(n = 1) {
    return this.offset + n <= this.length;
  }
  isLittleEndian() {
    return this.littleEndian;
  }
  setLittleEndian() {
    return this.littleEndian = true, this;
  }
  isBigEndian() {
    return !this.littleEndian;
  }
  setBigEndian() {
    return this.littleEndian = false, this;
  }
  skip(n = 1) {
    return this.offset += n, this;
  }
  back(n = 1) {
    return this.offset -= n, this;
  }
  seek(n) {
    return this.offset = n, this;
  }
  mark() {
    return this._mark = this.offset, this;
  }
  reset() {
    return this.offset = this._mark, this;
  }
  pushMark() {
    return this._marks.push(this.offset), this;
  }
  popMark() {
    const n = this._marks.pop();
    if (n === void 0) throw new Error("Mark stack empty");
    return this.seek(n), this;
  }
  rewind() {
    return this.offset = 0, this;
  }
  ensureAvailable(n = 1) {
    if (!this.available(n)) {
      const r = (this.offset + n) * 2, i = new Uint8Array(r);
      i.set(new Uint8Array(this.buffer)), this.buffer = i.buffer, this.length = r, this.byteLength = r, this._data = new DataView(this.buffer);
    }
    return this;
  }
  readBoolean() {
    return this.readUint8() !== 0;
  }
  readInt8() {
    return this._data.getInt8(this.offset++);
  }
  readUint8() {
    return this._data.getUint8(this.offset++);
  }
  readByte() {
    return this.readUint8();
  }
  readBytes(n = 1) {
    return this.readArray(n, "uint8");
  }
  readArray(n, e) {
    const r = xl[e].BYTES_PER_ELEMENT * n, i = this.byteOffset + this.offset, o = this.buffer.slice(i, i + r);
    if (this.littleEndian === K1 && e !== "uint8" && e !== "int8") {
      const l = new Uint8Array(this.buffer.slice(i, i + r));
      l.reverse();
      const f = new xl[e](l.buffer);
      return this.offset += r, f.reverse(), f;
    }
    const u = new xl[e](o);
    return this.offset += r, u;
  }
  readInt16() {
    const n = this._data.getInt16(this.offset, this.littleEndian);
    return this.offset += 2, n;
  }
  readUint16() {
    const n = this._data.getUint16(this.offset, this.littleEndian);
    return this.offset += 2, n;
  }
  readInt32() {
    const n = this._data.getInt32(this.offset, this.littleEndian);
    return this.offset += 4, n;
  }
  readUint32() {
    const n = this._data.getUint32(this.offset, this.littleEndian);
    return this.offset += 4, n;
  }
  readFloat32() {
    const n = this._data.getFloat32(this.offset, this.littleEndian);
    return this.offset += 4, n;
  }
  readFloat64() {
    const n = this._data.getFloat64(this.offset, this.littleEndian);
    return this.offset += 8, n;
  }
  readBigInt64() {
    const n = this._data.getBigInt64(this.offset, this.littleEndian);
    return this.offset += 8, n;
  }
  readBigUint64() {
    const n = this._data.getBigUint64(this.offset, this.littleEndian);
    return this.offset += 8, n;
  }
  readChar() {
    return String.fromCharCode(this.readInt8());
  }
  readChars(n = 1) {
    let e = "";
    for (let r = 0; r < n; r++) e += this.readChar();
    return e;
  }
  readUtf8(n = 1) {
    return mu(this.readBytes(n));
  }
  decodeText(n = 1, e = "utf8") {
    return mu(this.readBytes(n), e);
  }
  writeBoolean(n) {
    return this.writeUint8(n ? 255 : 0), this;
  }
  writeInt8(n) {
    return this.ensureAvailable(1), this._data.setInt8(this.offset++, n), this._updateLastWrittenByte(), this;
  }
  writeUint8(n) {
    return this.ensureAvailable(1), this._data.setUint8(this.offset++, n), this._updateLastWrittenByte(), this;
  }
  writeByte(n) {
    return this.writeUint8(n);
  }
  writeBytes(n) {
    this.ensureAvailable(n.length);
    for (let e = 0; e < n.length; e++) this._data.setUint8(this.offset++, n[e]);
    return this._updateLastWrittenByte(), this;
  }
  writeInt16(n) {
    return this.ensureAvailable(2), this._data.setInt16(this.offset, n, this.littleEndian), this.offset += 2, this._updateLastWrittenByte(), this;
  }
  writeUint16(n) {
    return this.ensureAvailable(2), this._data.setUint16(this.offset, n, this.littleEndian), this.offset += 2, this._updateLastWrittenByte(), this;
  }
  writeInt32(n) {
    return this.ensureAvailable(4), this._data.setInt32(this.offset, n, this.littleEndian), this.offset += 4, this._updateLastWrittenByte(), this;
  }
  writeUint32(n) {
    return this.ensureAvailable(4), this._data.setUint32(this.offset, n, this.littleEndian), this.offset += 4, this._updateLastWrittenByte(), this;
  }
  writeFloat32(n) {
    return this.ensureAvailable(4), this._data.setFloat32(this.offset, n, this.littleEndian), this.offset += 4, this._updateLastWrittenByte(), this;
  }
  writeFloat64(n) {
    return this.ensureAvailable(8), this._data.setFloat64(this.offset, n, this.littleEndian), this.offset += 8, this._updateLastWrittenByte(), this;
  }
  writeBigInt64(n) {
    return this.ensureAvailable(8), this._data.setBigInt64(this.offset, n, this.littleEndian), this.offset += 8, this._updateLastWrittenByte(), this;
  }
  writeBigUint64(n) {
    return this.ensureAvailable(8), this._data.setBigUint64(this.offset, n, this.littleEndian), this.offset += 8, this._updateLastWrittenByte(), this;
  }
  writeChar(n) {
    return this.writeUint8(n.charCodeAt(0));
  }
  writeChars(n) {
    for (let e = 0; e < n.length; e++) this.writeUint8(n.charCodeAt(e));
    return this;
  }
  writeUtf8(n) {
    return this.writeBytes(Y1(n));
  }
  toArray() {
    return new Uint8Array(this.buffer, this.byteOffset, this.lastWrittenByte);
  }
  getWrittenByteLength() {
    return this.lastWrittenByte - this.byteOffset;
  }
  _updateLastWrittenByte() {
    this.offset > this.lastWrittenByte && (this.lastWrittenByte = this.offset);
  }
}
/*! pako 2.1.0 https://github.com/nodeca/pako @license (MIT AND Zlib) */
const X1 = 4, vu = 0, bu = 1, J1 = 2;
function Ia(t3) {
  let n = t3.length;
  for (; --n >= 0; ) t3[n] = 0;
}
const Q1 = 0, Uc = 1, t2 = 2, e2 = 3, n2 = 258, gh = 29, So = 256, bo = So + 1 + gh, Aa = 30, mh = 19, zc = 2 * bo + 1, Yi = 15, Al = 16, r2 = 7, vh = 256, Hc = 16, Wc = 17, Vc = 18, Jl = new Uint8Array([0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 0]), xs = new Uint8Array([0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13]), i2 = new Uint8Array([0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 7]), Gc = new Uint8Array([16, 17, 18, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, 14, 1, 15]), a2 = 512, Yr = new Array((bo + 2) * 2);
Ia(Yr);
const go = new Array(Aa * 2);
Ia(go);
const wo = new Array(a2);
Ia(wo);
const _o = new Array(n2 - e2 + 1);
Ia(_o);
const bh = new Array(gh);
Ia(bh);
const Es = new Array(Aa);
Ia(Es);
function Ll(t3, n, e, r, i) {
  this.static_tree = t3, this.extra_bits = n, this.extra_base = e, this.elems = r, this.max_length = i, this.has_stree = t3 && t3.length;
}
let Zc, Yc, $c;
function Nl(t3, n) {
  this.dyn_tree = t3, this.max_code = 0, this.stat_desc = n;
}
const Kc = (t3) => t3 < 256 ? wo[t3] : wo[256 + (t3 >>> 7)], yo = (t3, n) => {
  t3.pending_buf[t3.pending++] = n & 255, t3.pending_buf[t3.pending++] = n >>> 8 & 255;
}, Mn = (t3, n, e) => {
  t3.bi_valid > Al - e ? (t3.bi_buf |= n << t3.bi_valid & 65535, yo(t3, t3.bi_buf), t3.bi_buf = n >> Al - t3.bi_valid, t3.bi_valid += e - Al) : (t3.bi_buf |= n << t3.bi_valid & 65535, t3.bi_valid += e);
}, kr = (t3, n, e) => {
  Mn(t3, e[n * 2], e[n * 2 + 1]);
}, Xc = (t3, n) => {
  let e = 0;
  do
    e |= t3 & 1, t3 >>>= 1, e <<= 1;
  while (--n > 0);
  return e >>> 1;
}, o2 = (t3) => {
  t3.bi_valid === 16 ? (yo(t3, t3.bi_buf), t3.bi_buf = 0, t3.bi_valid = 0) : t3.bi_valid >= 8 && (t3.pending_buf[t3.pending++] = t3.bi_buf & 255, t3.bi_buf >>= 8, t3.bi_valid -= 8);
}, s2 = (t3, n) => {
  const e = n.dyn_tree, r = n.max_code, i = n.stat_desc.static_tree, o = n.stat_desc.has_stree, u = n.stat_desc.extra_bits, l = n.stat_desc.extra_base, f = n.stat_desc.max_length;
  let c, p, x, L, g, O, P = 0;
  for (L = 0; L <= Yi; L++) t3.bl_count[L] = 0;
  for (e[t3.heap[t3.heap_max] * 2 + 1] = 0, c = t3.heap_max + 1; c < zc; c++) p = t3.heap[c], L = e[e[p * 2 + 1] * 2 + 1] + 1, L > f && (L = f, P++), e[p * 2 + 1] = L, !(p > r) && (t3.bl_count[L]++, g = 0, p >= l && (g = u[p - l]), O = e[p * 2], t3.opt_len += O * (L + g), o && (t3.static_len += O * (i[p * 2 + 1] + g)));
  if (P !== 0) {
    do {
      for (L = f - 1; t3.bl_count[L] === 0; ) L--;
      t3.bl_count[L]--, t3.bl_count[L + 1] += 2, t3.bl_count[f]--, P -= 2;
    } while (P > 0);
    for (L = f; L !== 0; L--) for (p = t3.bl_count[L]; p !== 0; ) x = t3.heap[--c], !(x > r) && (e[x * 2 + 1] !== L && (t3.opt_len += (L - e[x * 2 + 1]) * e[x * 2], e[x * 2 + 1] = L), p--);
  }
}, Jc = (t3, n, e) => {
  const r = new Array(Yi + 1);
  let i = 0, o, u;
  for (o = 1; o <= Yi; o++) i = i + e[o - 1] << 1, r[o] = i;
  for (u = 0; u <= n; u++) {
    let l = t3[u * 2 + 1];
    l !== 0 && (t3[u * 2] = Xc(r[l]++, l));
  }
}, l2 = () => {
  let t3, n, e, r, i;
  const o = new Array(Yi + 1);
  for (e = 0, r = 0; r < gh - 1; r++) for (bh[r] = e, t3 = 0; t3 < 1 << Jl[r]; t3++) _o[e++] = r;
  for (_o[e - 1] = r, i = 0, r = 0; r < 16; r++) for (Es[r] = i, t3 = 0; t3 < 1 << xs[r]; t3++) wo[i++] = r;
  for (i >>= 7; r < Aa; r++) for (Es[r] = i << 7, t3 = 0; t3 < 1 << xs[r] - 7; t3++) wo[256 + i++] = r;
  for (n = 0; n <= Yi; n++) o[n] = 0;
  for (t3 = 0; t3 <= 143; ) Yr[t3 * 2 + 1] = 8, t3++, o[8]++;
  for (; t3 <= 255; ) Yr[t3 * 2 + 1] = 9, t3++, o[9]++;
  for (; t3 <= 279; ) Yr[t3 * 2 + 1] = 7, t3++, o[7]++;
  for (; t3 <= 287; ) Yr[t3 * 2 + 1] = 8, t3++, o[8]++;
  for (Jc(Yr, bo + 1, o), t3 = 0; t3 < Aa; t3++) go[t3 * 2 + 1] = 5, go[t3 * 2] = Xc(t3, 5);
  Zc = new Ll(Yr, Jl, So + 1, bo, Yi), Yc = new Ll(go, xs, 0, Aa, Yi), $c = new Ll(new Array(0), i2, 0, mh, r2);
}, Qc = (t3) => {
  let n;
  for (n = 0; n < bo; n++) t3.dyn_ltree[n * 2] = 0;
  for (n = 0; n < Aa; n++) t3.dyn_dtree[n * 2] = 0;
  for (n = 0; n < mh; n++) t3.bl_tree[n * 2] = 0;
  t3.dyn_ltree[vh * 2] = 1, t3.opt_len = t3.static_len = 0, t3.sym_next = t3.matches = 0;
}, tf = (t3) => {
  t3.bi_valid > 8 ? yo(t3, t3.bi_buf) : t3.bi_valid > 0 && (t3.pending_buf[t3.pending++] = t3.bi_buf), t3.bi_buf = 0, t3.bi_valid = 0;
}, wu = (t3, n, e, r) => {
  const i = n * 2, o = e * 2;
  return t3[i] < t3[o] || t3[i] === t3[o] && r[n] <= r[e];
}, Sl = (t3, n, e) => {
  const r = t3.heap[e];
  let i = e << 1;
  for (; i <= t3.heap_len && (i < t3.heap_len && wu(n, t3.heap[i + 1], t3.heap[i], t3.depth) && i++, !wu(n, r, t3.heap[i], t3.depth)); ) t3.heap[e] = t3.heap[i], e = i, i <<= 1;
  t3.heap[e] = r;
}, _u = (t3, n, e) => {
  let r, i, o = 0, u, l;
  if (t3.sym_next !== 0) do
    r = t3.pending_buf[t3.sym_buf + o++] & 255, r += (t3.pending_buf[t3.sym_buf + o++] & 255) << 8, i = t3.pending_buf[t3.sym_buf + o++], r === 0 ? kr(t3, i, n) : (u = _o[i], kr(t3, u + So + 1, n), l = Jl[u], l !== 0 && (i -= bh[u], Mn(t3, i, l)), r--, u = Kc(r), kr(t3, u, e), l = xs[u], l !== 0 && (r -= Es[u], Mn(t3, r, l)));
  while (o < t3.sym_next);
  kr(t3, vh, n);
}, Ql = (t3, n) => {
  const e = n.dyn_tree, r = n.stat_desc.static_tree, i = n.stat_desc.has_stree, o = n.stat_desc.elems;
  let u, l, f = -1, c;
  for (t3.heap_len = 0, t3.heap_max = zc, u = 0; u < o; u++) e[u * 2] !== 0 ? (t3.heap[++t3.heap_len] = f = u, t3.depth[u] = 0) : e[u * 2 + 1] = 0;
  for (; t3.heap_len < 2; ) c = t3.heap[++t3.heap_len] = f < 2 ? ++f : 0, e[c * 2] = 1, t3.depth[c] = 0, t3.opt_len--, i && (t3.static_len -= r[c * 2 + 1]);
  for (n.max_code = f, u = t3.heap_len >> 1; u >= 1; u--) Sl(t3, e, u);
  c = o;
  do
    u = t3.heap[1], t3.heap[1] = t3.heap[t3.heap_len--], Sl(t3, e, 1), l = t3.heap[1], t3.heap[--t3.heap_max] = u, t3.heap[--t3.heap_max] = l, e[c * 2] = e[u * 2] + e[l * 2], t3.depth[c] = (t3.depth[u] >= t3.depth[l] ? t3.depth[u] : t3.depth[l]) + 1, e[u * 2 + 1] = e[l * 2 + 1] = c, t3.heap[1] = c++, Sl(t3, e, 1);
  while (t3.heap_len >= 2);
  t3.heap[--t3.heap_max] = t3.heap[1], s2(t3, n), Jc(e, f, t3.bl_count);
}, yu = (t3, n, e) => {
  let r, i = -1, o, u = n[0 * 2 + 1], l = 0, f = 7, c = 4;
  for (u === 0 && (f = 138, c = 3), n[(e + 1) * 2 + 1] = 65535, r = 0; r <= e; r++) o = u, u = n[(r + 1) * 2 + 1], !(++l < f && o === u) && (l < c ? t3.bl_tree[o * 2] += l : o !== 0 ? (o !== i && t3.bl_tree[o * 2]++, t3.bl_tree[Hc * 2]++) : l <= 10 ? t3.bl_tree[Wc * 2]++ : t3.bl_tree[Vc * 2]++, l = 0, i = o, u === 0 ? (f = 138, c = 3) : o === u ? (f = 6, c = 3) : (f = 7, c = 4));
}, xu = (t3, n, e) => {
  let r, i = -1, o, u = n[0 * 2 + 1], l = 0, f = 7, c = 4;
  for (u === 0 && (f = 138, c = 3), r = 0; r <= e; r++) if (o = u, u = n[(r + 1) * 2 + 1], !(++l < f && o === u)) {
    if (l < c) do
      kr(t3, o, t3.bl_tree);
    while (--l !== 0);
    else o !== 0 ? (o !== i && (kr(t3, o, t3.bl_tree), l--), kr(t3, Hc, t3.bl_tree), Mn(t3, l - 3, 2)) : l <= 10 ? (kr(t3, Wc, t3.bl_tree), Mn(t3, l - 3, 3)) : (kr(t3, Vc, t3.bl_tree), Mn(t3, l - 11, 7));
    l = 0, i = o, u === 0 ? (f = 138, c = 3) : o === u ? (f = 6, c = 3) : (f = 7, c = 4);
  }
}, h2 = (t3) => {
  let n;
  for (yu(t3, t3.dyn_ltree, t3.l_desc.max_code), yu(t3, t3.dyn_dtree, t3.d_desc.max_code), Ql(t3, t3.bl_desc), n = mh - 1; n >= 3 && t3.bl_tree[Gc[n] * 2 + 1] === 0; n--) ;
  return t3.opt_len += 3 * (n + 1) + 5 + 5 + 4, n;
}, u2 = (t3, n, e, r) => {
  let i;
  for (Mn(t3, n - 257, 5), Mn(t3, e - 1, 5), Mn(t3, r - 4, 4), i = 0; i < r; i++) Mn(t3, t3.bl_tree[Gc[i] * 2 + 1], 3);
  xu(t3, t3.dyn_ltree, n - 1), xu(t3, t3.dyn_dtree, e - 1);
}, c2 = (t3) => {
  let n = 4093624447, e;
  for (e = 0; e <= 31; e++, n >>>= 1) if (n & 1 && t3.dyn_ltree[e * 2] !== 0) return vu;
  if (t3.dyn_ltree[9 * 2] !== 0 || t3.dyn_ltree[10 * 2] !== 0 || t3.dyn_ltree[13 * 2] !== 0) return bu;
  for (e = 32; e < So; e++) if (t3.dyn_ltree[e * 2] !== 0) return bu;
  return vu;
};
let Au = false;
const f2 = (t3) => {
  Au || (l2(), Au = true), t3.l_desc = new Nl(t3.dyn_ltree, Zc), t3.d_desc = new Nl(t3.dyn_dtree, Yc), t3.bl_desc = new Nl(t3.bl_tree, $c), t3.bi_buf = 0, t3.bi_valid = 0, Qc(t3);
}, ef = (t3, n, e, r) => {
  Mn(t3, (Q1 << 1) + (r ? 1 : 0), 3), tf(t3), yo(t3, e), yo(t3, ~e), e && t3.pending_buf.set(t3.window.subarray(n, n + e), t3.pending), t3.pending += e;
}, d2 = (t3) => {
  Mn(t3, Uc << 1, 3), kr(t3, vh, Yr), o2(t3);
}, p2 = (t3, n, e, r) => {
  let i, o, u = 0;
  t3.level > 0 ? (t3.strm.data_type === J1 && (t3.strm.data_type = c2(t3)), Ql(t3, t3.l_desc), Ql(t3, t3.d_desc), u = h2(t3), i = t3.opt_len + 3 + 7 >>> 3, o = t3.static_len + 3 + 7 >>> 3, o <= i && (i = o)) : i = o = e + 5, e + 4 <= i && n !== -1 ? ef(t3, n, e, r) : t3.strategy === X1 || o === i ? (Mn(t3, (Uc << 1) + (r ? 1 : 0), 3), _u(t3, Yr, go)) : (Mn(t3, (t2 << 1) + (r ? 1 : 0), 3), u2(t3, t3.l_desc.max_code + 1, t3.d_desc.max_code + 1, u + 1), _u(t3, t3.dyn_ltree, t3.dyn_dtree)), Qc(t3), r && tf(t3);
}, g2 = (t3, n, e) => (t3.pending_buf[t3.sym_buf + t3.sym_next++] = n, t3.pending_buf[t3.sym_buf + t3.sym_next++] = n >> 8, t3.pending_buf[t3.sym_buf + t3.sym_next++] = e, n === 0 ? t3.dyn_ltree[e * 2]++ : (t3.matches++, n--, t3.dyn_ltree[(_o[e] + So + 1) * 2]++, t3.dyn_dtree[Kc(n) * 2]++), t3.sym_next === t3.sym_end);
var m2 = f2, v2 = ef, b2 = p2, w2 = g2, _2 = d2, y2 = { _tr_init: m2, _tr_stored_block: v2, _tr_flush_block: b2, _tr_tally: w2, _tr_align: _2 };
const x2 = (t3, n, e, r) => {
  let i = t3 & 65535 | 0, o = t3 >>> 16 & 65535 | 0, u = 0;
  for (; e !== 0; ) {
    u = e > 2e3 ? 2e3 : e, e -= u;
    do
      i = i + n[r++] | 0, o = o + i | 0;
    while (--u);
    i %= 65521, o %= 65521;
  }
  return i | o << 16 | 0;
};
var xo = x2;
const A2 = () => {
  let t3, n = [];
  for (var e = 0; e < 256; e++) {
    t3 = e;
    for (var r = 0; r < 8; r++) t3 = t3 & 1 ? 3988292384 ^ t3 >>> 1 : t3 >>> 1;
    n[e] = t3;
  }
  return n;
}, L2 = new Uint32Array(A2()), N2 = (t3, n, e, r) => {
  const i = L2, o = r + e;
  t3 ^= -1;
  for (let u = r; u < o; u++) t3 = t3 >>> 8 ^ i[(t3 ^ n[u]) & 255];
  return t3 ^ -1;
};
var pn = N2, Pa = { 2: "need dictionary", 1: "stream end", 0: "", "-1": "file error", "-2": "stream error", "-3": "data error", "-4": "insufficient memory", "-5": "buffer error", "-6": "incompatible version" }, ko = { Z_NO_FLUSH: 0, Z_PARTIAL_FLUSH: 1, Z_SYNC_FLUSH: 2, Z_FULL_FLUSH: 3, Z_FINISH: 4, Z_BLOCK: 5, Z_TREES: 6, Z_OK: 0, Z_STREAM_END: 1, Z_NEED_DICT: 2, Z_ERRNO: -1, Z_STREAM_ERROR: -2, Z_DATA_ERROR: -3, Z_MEM_ERROR: -4, Z_BUF_ERROR: -5, Z_NO_COMPRESSION: 0, Z_BEST_SPEED: 1, Z_BEST_COMPRESSION: 9, Z_DEFAULT_COMPRESSION: -1, Z_FILTERED: 1, Z_HUFFMAN_ONLY: 2, Z_RLE: 3, Z_FIXED: 4, Z_DEFAULT_STRATEGY: 0, Z_BINARY: 0, Z_TEXT: 1, Z_UNKNOWN: 2, Z_DEFLATED: 8 };
const { _tr_init: S2, _tr_stored_block: th, _tr_flush_block: k2, _tr_tally: bi, _tr_align: P2 } = y2, { Z_NO_FLUSH: wi, Z_PARTIAL_FLUSH: C2, Z_FULL_FLUSH: E2, Z_FINISH: ar, Z_BLOCK: Lu, Z_OK: yn, Z_STREAM_END: Nu, Z_STREAM_ERROR: Cr, Z_DATA_ERROR: I2, Z_BUF_ERROR: kl, Z_DEFAULT_COMPRESSION: F2, Z_FILTERED: O2, Z_HUFFMAN_ONLY: fs, Z_RLE: T2, Z_FIXED: R2, Z_DEFAULT_STRATEGY: M2, Z_UNKNOWN: B2, Z_DEFLATED: Rs } = ko, j2 = 9, D2 = 15, q2 = 8, U2 = 29, z2 = 256, eh = z2 + 1 + U2, H2 = 30, W2 = 19, V2 = 2 * eh + 1, G2 = 15, ve = 3, mi = 258, Er = mi + ve + 1, Z2 = 32, Ca = 42, wh = 57, nh = 69, rh = 73, ih = 91, ah = 103, $i = 113, co = 666, Fn = 1, Fa = 2, Qi = 3, Oa = 4, Y2 = 3, Ki = (t3, n) => (t3.msg = Pa[n], n), Su = (t3) => t3 * 2 - (t3 > 4 ? 9 : 0), gi = (t3) => {
  let n = t3.length;
  for (; --n >= 0; ) t3[n] = 0;
}, $2 = (t3) => {
  let n, e, r, i = t3.w_size;
  n = t3.hash_size, r = n;
  do
    e = t3.head[--r], t3.head[r] = e >= i ? e - i : 0;
  while (--n);
  n = i, r = n;
  do
    e = t3.prev[--r], t3.prev[r] = e >= i ? e - i : 0;
  while (--n);
};
let K2 = (t3, n, e) => (n << t3.hash_shift ^ e) & t3.hash_mask, _i = K2;
const Zn = (t3) => {
  const n = t3.state;
  let e = n.pending;
  e > t3.avail_out && (e = t3.avail_out), e !== 0 && (t3.output.set(n.pending_buf.subarray(n.pending_out, n.pending_out + e), t3.next_out), t3.next_out += e, n.pending_out += e, t3.total_out += e, t3.avail_out -= e, n.pending -= e, n.pending === 0 && (n.pending_out = 0));
}, $n = (t3, n) => {
  k2(t3, t3.block_start >= 0 ? t3.block_start : -1, t3.strstart - t3.block_start, n), t3.block_start = t3.strstart, Zn(t3.strm);
}, Ae = (t3, n) => {
  t3.pending_buf[t3.pending++] = n;
}, uo = (t3, n) => {
  t3.pending_buf[t3.pending++] = n >>> 8 & 255, t3.pending_buf[t3.pending++] = n & 255;
}, oh = (t3, n, e, r) => {
  let i = t3.avail_in;
  return i > r && (i = r), i === 0 ? 0 : (t3.avail_in -= i, n.set(t3.input.subarray(t3.next_in, t3.next_in + i), e), t3.state.wrap === 1 ? t3.adler = xo(t3.adler, n, i, e) : t3.state.wrap === 2 && (t3.adler = pn(t3.adler, n, i, e)), t3.next_in += i, t3.total_in += i, i);
}, nf = (t3, n) => {
  let e = t3.max_chain_length, r = t3.strstart, i, o, u = t3.prev_length, l = t3.nice_match;
  const f = t3.strstart > t3.w_size - Er ? t3.strstart - (t3.w_size - Er) : 0, c = t3.window, p = t3.w_mask, x = t3.prev, L = t3.strstart + mi;
  let g = c[r + u - 1], O = c[r + u];
  t3.prev_length >= t3.good_match && (e >>= 2), l > t3.lookahead && (l = t3.lookahead);
  do
    if (i = n, !(c[i + u] !== O || c[i + u - 1] !== g || c[i] !== c[r] || c[++i] !== c[r + 1])) {
      r += 2, i++;
      do
        ;
      while (c[++r] === c[++i] && c[++r] === c[++i] && c[++r] === c[++i] && c[++r] === c[++i] && c[++r] === c[++i] && c[++r] === c[++i] && c[++r] === c[++i] && c[++r] === c[++i] && r < L);
      if (o = mi - (L - r), r = L - mi, o > u) {
        if (t3.match_start = n, u = o, o >= l) break;
        g = c[r + u - 1], O = c[r + u];
      }
    }
  while ((n = x[n & p]) > f && --e !== 0);
  return u <= t3.lookahead ? u : t3.lookahead;
}, Ea = (t3) => {
  const n = t3.w_size;
  let e, r, i;
  do {
    if (r = t3.window_size - t3.lookahead - t3.strstart, t3.strstart >= n + (n - Er) && (t3.window.set(t3.window.subarray(n, n + n - r), 0), t3.match_start -= n, t3.strstart -= n, t3.block_start -= n, t3.insert > t3.strstart && (t3.insert = t3.strstart), $2(t3), r += n), t3.strm.avail_in === 0) break;
    if (e = oh(t3.strm, t3.window, t3.strstart + t3.lookahead, r), t3.lookahead += e, t3.lookahead + t3.insert >= ve) for (i = t3.strstart - t3.insert, t3.ins_h = t3.window[i], t3.ins_h = _i(t3, t3.ins_h, t3.window[i + 1]); t3.insert && (t3.ins_h = _i(t3, t3.ins_h, t3.window[i + ve - 1]), t3.prev[i & t3.w_mask] = t3.head[t3.ins_h], t3.head[t3.ins_h] = i, i++, t3.insert--, !(t3.lookahead + t3.insert < ve)); ) ;
  } while (t3.lookahead < Er && t3.strm.avail_in !== 0);
}, rf = (t3, n) => {
  let e = t3.pending_buf_size - 5 > t3.w_size ? t3.w_size : t3.pending_buf_size - 5, r, i, o, u = 0, l = t3.strm.avail_in;
  do {
    if (r = 65535, o = t3.bi_valid + 42 >> 3, t3.strm.avail_out < o || (o = t3.strm.avail_out - o, i = t3.strstart - t3.block_start, r > i + t3.strm.avail_in && (r = i + t3.strm.avail_in), r > o && (r = o), r < e && (r === 0 && n !== ar || n === wi || r !== i + t3.strm.avail_in))) break;
    u = n === ar && r === i + t3.strm.avail_in ? 1 : 0, th(t3, 0, 0, u), t3.pending_buf[t3.pending - 4] = r, t3.pending_buf[t3.pending - 3] = r >> 8, t3.pending_buf[t3.pending - 2] = ~r, t3.pending_buf[t3.pending - 1] = ~r >> 8, Zn(t3.strm), i && (i > r && (i = r), t3.strm.output.set(t3.window.subarray(t3.block_start, t3.block_start + i), t3.strm.next_out), t3.strm.next_out += i, t3.strm.avail_out -= i, t3.strm.total_out += i, t3.block_start += i, r -= i), r && (oh(t3.strm, t3.strm.output, t3.strm.next_out, r), t3.strm.next_out += r, t3.strm.avail_out -= r, t3.strm.total_out += r);
  } while (u === 0);
  return l -= t3.strm.avail_in, l && (l >= t3.w_size ? (t3.matches = 2, t3.window.set(t3.strm.input.subarray(t3.strm.next_in - t3.w_size, t3.strm.next_in), 0), t3.strstart = t3.w_size, t3.insert = t3.strstart) : (t3.window_size - t3.strstart <= l && (t3.strstart -= t3.w_size, t3.window.set(t3.window.subarray(t3.w_size, t3.w_size + t3.strstart), 0), t3.matches < 2 && t3.matches++, t3.insert > t3.strstart && (t3.insert = t3.strstart)), t3.window.set(t3.strm.input.subarray(t3.strm.next_in - l, t3.strm.next_in), t3.strstart), t3.strstart += l, t3.insert += l > t3.w_size - t3.insert ? t3.w_size - t3.insert : l), t3.block_start = t3.strstart), t3.high_water < t3.strstart && (t3.high_water = t3.strstart), u ? Oa : n !== wi && n !== ar && t3.strm.avail_in === 0 && t3.strstart === t3.block_start ? Fa : (o = t3.window_size - t3.strstart, t3.strm.avail_in > o && t3.block_start >= t3.w_size && (t3.block_start -= t3.w_size, t3.strstart -= t3.w_size, t3.window.set(t3.window.subarray(t3.w_size, t3.w_size + t3.strstart), 0), t3.matches < 2 && t3.matches++, o += t3.w_size, t3.insert > t3.strstart && (t3.insert = t3.strstart)), o > t3.strm.avail_in && (o = t3.strm.avail_in), o && (oh(t3.strm, t3.window, t3.strstart, o), t3.strstart += o, t3.insert += o > t3.w_size - t3.insert ? t3.w_size - t3.insert : o), t3.high_water < t3.strstart && (t3.high_water = t3.strstart), o = t3.bi_valid + 42 >> 3, o = t3.pending_buf_size - o > 65535 ? 65535 : t3.pending_buf_size - o, e = o > t3.w_size ? t3.w_size : o, i = t3.strstart - t3.block_start, (i >= e || (i || n === ar) && n !== wi && t3.strm.avail_in === 0 && i <= o) && (r = i > o ? o : i, u = n === ar && t3.strm.avail_in === 0 && r === i ? 1 : 0, th(t3, t3.block_start, r, u), t3.block_start += r, Zn(t3.strm)), u ? Qi : Fn);
}, Pl = (t3, n) => {
  let e, r;
  for (; ; ) {
    if (t3.lookahead < Er) {
      if (Ea(t3), t3.lookahead < Er && n === wi) return Fn;
      if (t3.lookahead === 0) break;
    }
    if (e = 0, t3.lookahead >= ve && (t3.ins_h = _i(t3, t3.ins_h, t3.window[t3.strstart + ve - 1]), e = t3.prev[t3.strstart & t3.w_mask] = t3.head[t3.ins_h], t3.head[t3.ins_h] = t3.strstart), e !== 0 && t3.strstart - e <= t3.w_size - Er && (t3.match_length = nf(t3, e)), t3.match_length >= ve) if (r = bi(t3, t3.strstart - t3.match_start, t3.match_length - ve), t3.lookahead -= t3.match_length, t3.match_length <= t3.max_lazy_match && t3.lookahead >= ve) {
      t3.match_length--;
      do
        t3.strstart++, t3.ins_h = _i(t3, t3.ins_h, t3.window[t3.strstart + ve - 1]), e = t3.prev[t3.strstart & t3.w_mask] = t3.head[t3.ins_h], t3.head[t3.ins_h] = t3.strstart;
      while (--t3.match_length !== 0);
      t3.strstart++;
    } else t3.strstart += t3.match_length, t3.match_length = 0, t3.ins_h = t3.window[t3.strstart], t3.ins_h = _i(t3, t3.ins_h, t3.window[t3.strstart + 1]);
    else r = bi(t3, 0, t3.window[t3.strstart]), t3.lookahead--, t3.strstart++;
    if (r && ($n(t3, false), t3.strm.avail_out === 0)) return Fn;
  }
  return t3.insert = t3.strstart < ve - 1 ? t3.strstart : ve - 1, n === ar ? ($n(t3, true), t3.strm.avail_out === 0 ? Qi : Oa) : t3.sym_next && ($n(t3, false), t3.strm.avail_out === 0) ? Fn : Fa;
}, ma = (t3, n) => {
  let e, r, i;
  for (; ; ) {
    if (t3.lookahead < Er) {
      if (Ea(t3), t3.lookahead < Er && n === wi) return Fn;
      if (t3.lookahead === 0) break;
    }
    if (e = 0, t3.lookahead >= ve && (t3.ins_h = _i(t3, t3.ins_h, t3.window[t3.strstart + ve - 1]), e = t3.prev[t3.strstart & t3.w_mask] = t3.head[t3.ins_h], t3.head[t3.ins_h] = t3.strstart), t3.prev_length = t3.match_length, t3.prev_match = t3.match_start, t3.match_length = ve - 1, e !== 0 && t3.prev_length < t3.max_lazy_match && t3.strstart - e <= t3.w_size - Er && (t3.match_length = nf(t3, e), t3.match_length <= 5 && (t3.strategy === O2 || t3.match_length === ve && t3.strstart - t3.match_start > 4096) && (t3.match_length = ve - 1)), t3.prev_length >= ve && t3.match_length <= t3.prev_length) {
      i = t3.strstart + t3.lookahead - ve, r = bi(t3, t3.strstart - 1 - t3.prev_match, t3.prev_length - ve), t3.lookahead -= t3.prev_length - 1, t3.prev_length -= 2;
      do
        ++t3.strstart <= i && (t3.ins_h = _i(t3, t3.ins_h, t3.window[t3.strstart + ve - 1]), e = t3.prev[t3.strstart & t3.w_mask] = t3.head[t3.ins_h], t3.head[t3.ins_h] = t3.strstart);
      while (--t3.prev_length !== 0);
      if (t3.match_available = 0, t3.match_length = ve - 1, t3.strstart++, r && ($n(t3, false), t3.strm.avail_out === 0)) return Fn;
    } else if (t3.match_available) {
      if (r = bi(t3, 0, t3.window[t3.strstart - 1]), r && $n(t3, false), t3.strstart++, t3.lookahead--, t3.strm.avail_out === 0) return Fn;
    } else t3.match_available = 1, t3.strstart++, t3.lookahead--;
  }
  return t3.match_available && (r = bi(t3, 0, t3.window[t3.strstart - 1]), t3.match_available = 0), t3.insert = t3.strstart < ve - 1 ? t3.strstart : ve - 1, n === ar ? ($n(t3, true), t3.strm.avail_out === 0 ? Qi : Oa) : t3.sym_next && ($n(t3, false), t3.strm.avail_out === 0) ? Fn : Fa;
}, X2 = (t3, n) => {
  let e, r, i, o;
  const u = t3.window;
  for (; ; ) {
    if (t3.lookahead <= mi) {
      if (Ea(t3), t3.lookahead <= mi && n === wi) return Fn;
      if (t3.lookahead === 0) break;
    }
    if (t3.match_length = 0, t3.lookahead >= ve && t3.strstart > 0 && (i = t3.strstart - 1, r = u[i], r === u[++i] && r === u[++i] && r === u[++i])) {
      o = t3.strstart + mi;
      do
        ;
      while (r === u[++i] && r === u[++i] && r === u[++i] && r === u[++i] && r === u[++i] && r === u[++i] && r === u[++i] && r === u[++i] && i < o);
      t3.match_length = mi - (o - i), t3.match_length > t3.lookahead && (t3.match_length = t3.lookahead);
    }
    if (t3.match_length >= ve ? (e = bi(t3, 1, t3.match_length - ve), t3.lookahead -= t3.match_length, t3.strstart += t3.match_length, t3.match_length = 0) : (e = bi(t3, 0, t3.window[t3.strstart]), t3.lookahead--, t3.strstart++), e && ($n(t3, false), t3.strm.avail_out === 0)) return Fn;
  }
  return t3.insert = 0, n === ar ? ($n(t3, true), t3.strm.avail_out === 0 ? Qi : Oa) : t3.sym_next && ($n(t3, false), t3.strm.avail_out === 0) ? Fn : Fa;
}, J2 = (t3, n) => {
  let e;
  for (; ; ) {
    if (t3.lookahead === 0 && (Ea(t3), t3.lookahead === 0)) {
      if (n === wi) return Fn;
      break;
    }
    if (t3.match_length = 0, e = bi(t3, 0, t3.window[t3.strstart]), t3.lookahead--, t3.strstart++, e && ($n(t3, false), t3.strm.avail_out === 0)) return Fn;
  }
  return t3.insert = 0, n === ar ? ($n(t3, true), t3.strm.avail_out === 0 ? Qi : Oa) : t3.sym_next && ($n(t3, false), t3.strm.avail_out === 0) ? Fn : Fa;
};
function Nr(t3, n, e, r, i) {
  this.good_length = t3, this.max_lazy = n, this.nice_length = e, this.max_chain = r, this.func = i;
}
const fo = [new Nr(0, 0, 0, 0, rf), new Nr(4, 4, 8, 4, Pl), new Nr(4, 5, 16, 8, Pl), new Nr(4, 6, 32, 32, Pl), new Nr(4, 4, 16, 16, ma), new Nr(8, 16, 32, 32, ma), new Nr(8, 16, 128, 128, ma), new Nr(8, 32, 128, 256, ma), new Nr(32, 128, 258, 1024, ma), new Nr(32, 258, 258, 4096, ma)], Q2 = (t3) => {
  t3.window_size = 2 * t3.w_size, gi(t3.head), t3.max_lazy_match = fo[t3.level].max_lazy, t3.good_match = fo[t3.level].good_length, t3.nice_match = fo[t3.level].nice_length, t3.max_chain_length = fo[t3.level].max_chain, t3.strstart = 0, t3.block_start = 0, t3.lookahead = 0, t3.insert = 0, t3.match_length = t3.prev_length = ve - 1, t3.match_available = 0, t3.ins_h = 0;
};
function t0() {
  this.strm = null, this.status = 0, this.pending_buf = null, this.pending_buf_size = 0, this.pending_out = 0, this.pending = 0, this.wrap = 0, this.gzhead = null, this.gzindex = 0, this.method = Rs, this.last_flush = -1, this.w_size = 0, this.w_bits = 0, this.w_mask = 0, this.window = null, this.window_size = 0, this.prev = null, this.head = null, this.ins_h = 0, this.hash_size = 0, this.hash_bits = 0, this.hash_mask = 0, this.hash_shift = 0, this.block_start = 0, this.match_length = 0, this.prev_match = 0, this.match_available = 0, this.strstart = 0, this.match_start = 0, this.lookahead = 0, this.prev_length = 0, this.max_chain_length = 0, this.max_lazy_match = 0, this.level = 0, this.strategy = 0, this.good_match = 0, this.nice_match = 0, this.dyn_ltree = new Uint16Array(V2 * 2), this.dyn_dtree = new Uint16Array((2 * H2 + 1) * 2), this.bl_tree = new Uint16Array((2 * W2 + 1) * 2), gi(this.dyn_ltree), gi(this.dyn_dtree), gi(this.bl_tree), this.l_desc = null, this.d_desc = null, this.bl_desc = null, this.bl_count = new Uint16Array(G2 + 1), this.heap = new Uint16Array(2 * eh + 1), gi(this.heap), this.heap_len = 0, this.heap_max = 0, this.depth = new Uint16Array(2 * eh + 1), gi(this.depth), this.sym_buf = 0, this.lit_bufsize = 0, this.sym_next = 0, this.sym_end = 0, this.opt_len = 0, this.static_len = 0, this.matches = 0, this.insert = 0, this.bi_buf = 0, this.bi_valid = 0;
}
const Po = (t3) => {
  if (!t3) return 1;
  const n = t3.state;
  return !n || n.strm !== t3 || n.status !== Ca && n.status !== wh && n.status !== nh && n.status !== rh && n.status !== ih && n.status !== ah && n.status !== $i && n.status !== co ? 1 : 0;
}, af = (t3) => {
  if (Po(t3)) return Ki(t3, Cr);
  t3.total_in = t3.total_out = 0, t3.data_type = B2;
  const n = t3.state;
  return n.pending = 0, n.pending_out = 0, n.wrap < 0 && (n.wrap = -n.wrap), n.status = n.wrap === 2 ? wh : n.wrap ? Ca : $i, t3.adler = n.wrap === 2 ? 0 : 1, n.last_flush = -2, S2(n), yn;
}, of = (t3) => {
  const n = af(t3);
  return n === yn && Q2(t3.state), n;
}, e0 = (t3, n) => Po(t3) || t3.state.wrap !== 2 ? Cr : (t3.state.gzhead = n, yn), sf = (t3, n, e, r, i, o) => {
  if (!t3) return Cr;
  let u = 1;
  if (n === F2 && (n = 6), r < 0 ? (u = 0, r = -r) : r > 15 && (u = 2, r -= 16), i < 1 || i > j2 || e !== Rs || r < 8 || r > 15 || n < 0 || n > 9 || o < 0 || o > R2 || r === 8 && u !== 1) return Ki(t3, Cr);
  r === 8 && (r = 9);
  const l = new t0();
  return t3.state = l, l.strm = t3, l.status = Ca, l.wrap = u, l.gzhead = null, l.w_bits = r, l.w_size = 1 << l.w_bits, l.w_mask = l.w_size - 1, l.hash_bits = i + 7, l.hash_size = 1 << l.hash_bits, l.hash_mask = l.hash_size - 1, l.hash_shift = ~~((l.hash_bits + ve - 1) / ve), l.window = new Uint8Array(l.w_size * 2), l.head = new Uint16Array(l.hash_size), l.prev = new Uint16Array(l.w_size), l.lit_bufsize = 1 << i + 6, l.pending_buf_size = l.lit_bufsize * 4, l.pending_buf = new Uint8Array(l.pending_buf_size), l.sym_buf = l.lit_bufsize, l.sym_end = (l.lit_bufsize - 1) * 3, l.level = n, l.strategy = o, l.method = e, of(t3);
}, n0 = (t3, n) => sf(t3, n, Rs, D2, q2, M2), r0 = (t3, n) => {
  if (Po(t3) || n > Lu || n < 0) return t3 ? Ki(t3, Cr) : Cr;
  const e = t3.state;
  if (!t3.output || t3.avail_in !== 0 && !t3.input || e.status === co && n !== ar) return Ki(t3, t3.avail_out === 0 ? kl : Cr);
  const r = e.last_flush;
  if (e.last_flush = n, e.pending !== 0) {
    if (Zn(t3), t3.avail_out === 0) return e.last_flush = -1, yn;
  } else if (t3.avail_in === 0 && Su(n) <= Su(r) && n !== ar) return Ki(t3, kl);
  if (e.status === co && t3.avail_in !== 0) return Ki(t3, kl);
  if (e.status === Ca && e.wrap === 0 && (e.status = $i), e.status === Ca) {
    let i = Rs + (e.w_bits - 8 << 4) << 8, o = -1;
    if (e.strategy >= fs || e.level < 2 ? o = 0 : e.level < 6 ? o = 1 : e.level === 6 ? o = 2 : o = 3, i |= o << 6, e.strstart !== 0 && (i |= Z2), i += 31 - i % 31, uo(e, i), e.strstart !== 0 && (uo(e, t3.adler >>> 16), uo(e, t3.adler & 65535)), t3.adler = 1, e.status = $i, Zn(t3), e.pending !== 0) return e.last_flush = -1, yn;
  }
  if (e.status === wh) {
    if (t3.adler = 0, Ae(e, 31), Ae(e, 139), Ae(e, 8), e.gzhead) Ae(e, (e.gzhead.text ? 1 : 0) + (e.gzhead.hcrc ? 2 : 0) + (e.gzhead.extra ? 4 : 0) + (e.gzhead.name ? 8 : 0) + (e.gzhead.comment ? 16 : 0)), Ae(e, e.gzhead.time & 255), Ae(e, e.gzhead.time >> 8 & 255), Ae(e, e.gzhead.time >> 16 & 255), Ae(e, e.gzhead.time >> 24 & 255), Ae(e, e.level === 9 ? 2 : e.strategy >= fs || e.level < 2 ? 4 : 0), Ae(e, e.gzhead.os & 255), e.gzhead.extra && e.gzhead.extra.length && (Ae(e, e.gzhead.extra.length & 255), Ae(e, e.gzhead.extra.length >> 8 & 255)), e.gzhead.hcrc && (t3.adler = pn(t3.adler, e.pending_buf, e.pending, 0)), e.gzindex = 0, e.status = nh;
    else if (Ae(e, 0), Ae(e, 0), Ae(e, 0), Ae(e, 0), Ae(e, 0), Ae(e, e.level === 9 ? 2 : e.strategy >= fs || e.level < 2 ? 4 : 0), Ae(e, Y2), e.status = $i, Zn(t3), e.pending !== 0) return e.last_flush = -1, yn;
  }
  if (e.status === nh) {
    if (e.gzhead.extra) {
      let i = e.pending, o = (e.gzhead.extra.length & 65535) - e.gzindex;
      for (; e.pending + o > e.pending_buf_size; ) {
        let l = e.pending_buf_size - e.pending;
        if (e.pending_buf.set(e.gzhead.extra.subarray(e.gzindex, e.gzindex + l), e.pending), e.pending = e.pending_buf_size, e.gzhead.hcrc && e.pending > i && (t3.adler = pn(t3.adler, e.pending_buf, e.pending - i, i)), e.gzindex += l, Zn(t3), e.pending !== 0) return e.last_flush = -1, yn;
        i = 0, o -= l;
      }
      let u = new Uint8Array(e.gzhead.extra);
      e.pending_buf.set(u.subarray(e.gzindex, e.gzindex + o), e.pending), e.pending += o, e.gzhead.hcrc && e.pending > i && (t3.adler = pn(t3.adler, e.pending_buf, e.pending - i, i)), e.gzindex = 0;
    }
    e.status = rh;
  }
  if (e.status === rh) {
    if (e.gzhead.name) {
      let i = e.pending, o;
      do {
        if (e.pending === e.pending_buf_size) {
          if (e.gzhead.hcrc && e.pending > i && (t3.adler = pn(t3.adler, e.pending_buf, e.pending - i, i)), Zn(t3), e.pending !== 0) return e.last_flush = -1, yn;
          i = 0;
        }
        e.gzindex < e.gzhead.name.length ? o = e.gzhead.name.charCodeAt(e.gzindex++) & 255 : o = 0, Ae(e, o);
      } while (o !== 0);
      e.gzhead.hcrc && e.pending > i && (t3.adler = pn(t3.adler, e.pending_buf, e.pending - i, i)), e.gzindex = 0;
    }
    e.status = ih;
  }
  if (e.status === ih) {
    if (e.gzhead.comment) {
      let i = e.pending, o;
      do {
        if (e.pending === e.pending_buf_size) {
          if (e.gzhead.hcrc && e.pending > i && (t3.adler = pn(t3.adler, e.pending_buf, e.pending - i, i)), Zn(t3), e.pending !== 0) return e.last_flush = -1, yn;
          i = 0;
        }
        e.gzindex < e.gzhead.comment.length ? o = e.gzhead.comment.charCodeAt(e.gzindex++) & 255 : o = 0, Ae(e, o);
      } while (o !== 0);
      e.gzhead.hcrc && e.pending > i && (t3.adler = pn(t3.adler, e.pending_buf, e.pending - i, i));
    }
    e.status = ah;
  }
  if (e.status === ah) {
    if (e.gzhead.hcrc) {
      if (e.pending + 2 > e.pending_buf_size && (Zn(t3), e.pending !== 0)) return e.last_flush = -1, yn;
      Ae(e, t3.adler & 255), Ae(e, t3.adler >> 8 & 255), t3.adler = 0;
    }
    if (e.status = $i, Zn(t3), e.pending !== 0) return e.last_flush = -1, yn;
  }
  if (t3.avail_in !== 0 || e.lookahead !== 0 || n !== wi && e.status !== co) {
    let i = e.level === 0 ? rf(e, n) : e.strategy === fs ? J2(e, n) : e.strategy === T2 ? X2(e, n) : fo[e.level].func(e, n);
    if ((i === Qi || i === Oa) && (e.status = co), i === Fn || i === Qi) return t3.avail_out === 0 && (e.last_flush = -1), yn;
    if (i === Fa && (n === C2 ? P2(e) : n !== Lu && (th(e, 0, 0, false), n === E2 && (gi(e.head), e.lookahead === 0 && (e.strstart = 0, e.block_start = 0, e.insert = 0))), Zn(t3), t3.avail_out === 0)) return e.last_flush = -1, yn;
  }
  return n !== ar ? yn : e.wrap <= 0 ? Nu : (e.wrap === 2 ? (Ae(e, t3.adler & 255), Ae(e, t3.adler >> 8 & 255), Ae(e, t3.adler >> 16 & 255), Ae(e, t3.adler >> 24 & 255), Ae(e, t3.total_in & 255), Ae(e, t3.total_in >> 8 & 255), Ae(e, t3.total_in >> 16 & 255), Ae(e, t3.total_in >> 24 & 255)) : (uo(e, t3.adler >>> 16), uo(e, t3.adler & 65535)), Zn(t3), e.wrap > 0 && (e.wrap = -e.wrap), e.pending !== 0 ? yn : Nu);
}, i0 = (t3) => {
  if (Po(t3)) return Cr;
  const n = t3.state.status;
  return t3.state = null, n === $i ? Ki(t3, I2) : yn;
}, a0 = (t3, n) => {
  let e = n.length;
  if (Po(t3)) return Cr;
  const r = t3.state, i = r.wrap;
  if (i === 2 || i === 1 && r.status !== Ca || r.lookahead) return Cr;
  if (i === 1 && (t3.adler = xo(t3.adler, n, e, 0)), r.wrap = 0, e >= r.w_size) {
    i === 0 && (gi(r.head), r.strstart = 0, r.block_start = 0, r.insert = 0);
    let f = new Uint8Array(r.w_size);
    f.set(n.subarray(e - r.w_size, e), 0), n = f, e = r.w_size;
  }
  const o = t3.avail_in, u = t3.next_in, l = t3.input;
  for (t3.avail_in = e, t3.next_in = 0, t3.input = n, Ea(r); r.lookahead >= ve; ) {
    let f = r.strstart, c = r.lookahead - (ve - 1);
    do
      r.ins_h = _i(r, r.ins_h, r.window[f + ve - 1]), r.prev[f & r.w_mask] = r.head[r.ins_h], r.head[r.ins_h] = f, f++;
    while (--c);
    r.strstart = f, r.lookahead = ve - 1, Ea(r);
  }
  return r.strstart += r.lookahead, r.block_start = r.strstart, r.insert = r.lookahead, r.lookahead = 0, r.match_length = r.prev_length = ve - 1, r.match_available = 0, t3.next_in = u, t3.input = l, t3.avail_in = o, r.wrap = i, yn;
};
var o0 = n0, s0 = sf, l0 = of, h0 = af, u0 = e0, c0 = r0, f0 = i0, d0 = a0, p0 = "pako deflate (from Nodeca project)", mo = { deflateInit: o0, deflateInit2: s0, deflateReset: l0, deflateResetKeep: h0, deflateSetHeader: u0, deflate: c0, deflateEnd: f0, deflateSetDictionary: d0, deflateInfo: p0 };
const g0 = (t3, n) => Object.prototype.hasOwnProperty.call(t3, n);
var m0 = function(t3) {
  const n = Array.prototype.slice.call(arguments, 1);
  for (; n.length; ) {
    const e = n.shift();
    if (e) {
      if (typeof e != "object") throw new TypeError(e + "must be non-object");
      for (const r in e) g0(e, r) && (t3[r] = e[r]);
    }
  }
  return t3;
}, v0 = (t3) => {
  let n = 0;
  for (let r = 0, i = t3.length; r < i; r++) n += t3[r].length;
  const e = new Uint8Array(n);
  for (let r = 0, i = 0, o = t3.length; r < o; r++) {
    let u = t3[r];
    e.set(u, i), i += u.length;
  }
  return e;
}, Ms = { assign: m0, flattenChunks: v0 };
let lf = true;
try {
  String.fromCharCode.apply(null, new Uint8Array(1));
} catch {
  lf = false;
}
const Ao = new Uint8Array(256);
for (let t3 = 0; t3 < 256; t3++) Ao[t3] = t3 >= 252 ? 6 : t3 >= 248 ? 5 : t3 >= 240 ? 4 : t3 >= 224 ? 3 : t3 >= 192 ? 2 : 1;
Ao[254] = Ao[254] = 1;
var b0 = (t3) => {
  if (typeof TextEncoder == "function" && TextEncoder.prototype.encode) return new TextEncoder().encode(t3);
  let n, e, r, i, o, u = t3.length, l = 0;
  for (i = 0; i < u; i++) e = t3.charCodeAt(i), (e & 64512) === 55296 && i + 1 < u && (r = t3.charCodeAt(i + 1), (r & 64512) === 56320 && (e = 65536 + (e - 55296 << 10) + (r - 56320), i++)), l += e < 128 ? 1 : e < 2048 ? 2 : e < 65536 ? 3 : 4;
  for (n = new Uint8Array(l), o = 0, i = 0; o < l; i++) e = t3.charCodeAt(i), (e & 64512) === 55296 && i + 1 < u && (r = t3.charCodeAt(i + 1), (r & 64512) === 56320 && (e = 65536 + (e - 55296 << 10) + (r - 56320), i++)), e < 128 ? n[o++] = e : e < 2048 ? (n[o++] = 192 | e >>> 6, n[o++] = 128 | e & 63) : e < 65536 ? (n[o++] = 224 | e >>> 12, n[o++] = 128 | e >>> 6 & 63, n[o++] = 128 | e & 63) : (n[o++] = 240 | e >>> 18, n[o++] = 128 | e >>> 12 & 63, n[o++] = 128 | e >>> 6 & 63, n[o++] = 128 | e & 63);
  return n;
};
const w0 = (t3, n) => {
  if (n < 65534 && t3.subarray && lf) return String.fromCharCode.apply(null, t3.length === n ? t3 : t3.subarray(0, n));
  let e = "";
  for (let r = 0; r < n; r++) e += String.fromCharCode(t3[r]);
  return e;
};
var _0 = (t3, n) => {
  const e = n || t3.length;
  if (typeof TextDecoder == "function" && TextDecoder.prototype.decode) return new TextDecoder().decode(t3.subarray(0, n));
  let r, i;
  const o = new Array(e * 2);
  for (i = 0, r = 0; r < e; ) {
    let u = t3[r++];
    if (u < 128) {
      o[i++] = u;
      continue;
    }
    let l = Ao[u];
    if (l > 4) {
      o[i++] = 65533, r += l - 1;
      continue;
    }
    for (u &= l === 2 ? 31 : l === 3 ? 15 : 7; l > 1 && r < e; ) u = u << 6 | t3[r++] & 63, l--;
    if (l > 1) {
      o[i++] = 65533;
      continue;
    }
    u < 65536 ? o[i++] = u : (u -= 65536, o[i++] = 55296 | u >> 10 & 1023, o[i++] = 56320 | u & 1023);
  }
  return w0(o, i);
}, y0 = (t3, n) => {
  n = n || t3.length, n > t3.length && (n = t3.length);
  let e = n - 1;
  for (; e >= 0 && (t3[e] & 192) === 128; ) e--;
  return e < 0 || e === 0 ? n : e + Ao[t3[e]] > n ? e : n;
}, Lo = { string2buf: b0, buf2string: _0, utf8border: y0 };
function x0() {
  this.input = null, this.next_in = 0, this.avail_in = 0, this.total_in = 0, this.output = null, this.next_out = 0, this.avail_out = 0, this.total_out = 0, this.msg = "", this.state = null, this.data_type = 2, this.adler = 0;
}
var hf = x0;
const uf = Object.prototype.toString, { Z_NO_FLUSH: A0, Z_SYNC_FLUSH: L0, Z_FULL_FLUSH: N0, Z_FINISH: S0, Z_OK: Is, Z_STREAM_END: k0, Z_DEFAULT_COMPRESSION: P0, Z_DEFAULT_STRATEGY: C0, Z_DEFLATED: E0 } = ko;
function _h(t3) {
  this.options = Ms.assign({ level: P0, method: E0, chunkSize: 16384, windowBits: 15, memLevel: 8, strategy: C0 }, t3 || {});
  let n = this.options;
  n.raw && n.windowBits > 0 ? n.windowBits = -n.windowBits : n.gzip && n.windowBits > 0 && n.windowBits < 16 && (n.windowBits += 16), this.err = 0, this.msg = "", this.ended = false, this.chunks = [], this.strm = new hf(), this.strm.avail_out = 0;
  let e = mo.deflateInit2(this.strm, n.level, n.method, n.windowBits, n.memLevel, n.strategy);
  if (e !== Is) throw new Error(Pa[e]);
  if (n.header && mo.deflateSetHeader(this.strm, n.header), n.dictionary) {
    let r;
    if (typeof n.dictionary == "string" ? r = Lo.string2buf(n.dictionary) : uf.call(n.dictionary) === "[object ArrayBuffer]" ? r = new Uint8Array(n.dictionary) : r = n.dictionary, e = mo.deflateSetDictionary(this.strm, r), e !== Is) throw new Error(Pa[e]);
    this._dict_set = true;
  }
}
_h.prototype.push = function(t3, n) {
  const e = this.strm, r = this.options.chunkSize;
  let i, o;
  if (this.ended) return false;
  for (n === ~~n ? o = n : o = n === true ? S0 : A0, typeof t3 == "string" ? e.input = Lo.string2buf(t3) : uf.call(t3) === "[object ArrayBuffer]" ? e.input = new Uint8Array(t3) : e.input = t3, e.next_in = 0, e.avail_in = e.input.length; ; ) {
    if (e.avail_out === 0 && (e.output = new Uint8Array(r), e.next_out = 0, e.avail_out = r), (o === L0 || o === N0) && e.avail_out <= 6) {
      this.onData(e.output.subarray(0, e.next_out)), e.avail_out = 0;
      continue;
    }
    if (i = mo.deflate(e, o), i === k0) return e.next_out > 0 && this.onData(e.output.subarray(0, e.next_out)), i = mo.deflateEnd(this.strm), this.onEnd(i), this.ended = true, i === Is;
    if (e.avail_out === 0) {
      this.onData(e.output);
      continue;
    }
    if (o > 0 && e.next_out > 0) {
      this.onData(e.output.subarray(0, e.next_out)), e.avail_out = 0;
      continue;
    }
    if (e.avail_in === 0) break;
  }
  return true;
};
_h.prototype.onData = function(t3) {
  this.chunks.push(t3);
};
_h.prototype.onEnd = function(t3) {
  t3 === Is && (this.result = Ms.flattenChunks(this.chunks)), this.chunks = [], this.err = t3, this.msg = this.strm.msg;
};
const ds = 16209, I0 = 16191;
var F0 = function(n, e) {
  let r, i, o, u, l, f, c, p, x, L, g, O, P, M, k, V, G, D, it, bt, dt, $, j, J;
  const N = n.state;
  r = n.next_in, j = n.input, i = r + (n.avail_in - 5), o = n.next_out, J = n.output, u = o - (e - n.avail_out), l = o + (n.avail_out - 257), f = N.dmax, c = N.wsize, p = N.whave, x = N.wnext, L = N.window, g = N.hold, O = N.bits, P = N.lencode, M = N.distcode, k = (1 << N.lenbits) - 1, V = (1 << N.distbits) - 1;
  t: do {
    O < 15 && (g += j[r++] << O, O += 8, g += j[r++] << O, O += 8), G = P[g & k];
    e: for (; ; ) {
      if (D = G >>> 24, g >>>= D, O -= D, D = G >>> 16 & 255, D === 0) J[o++] = G & 65535;
      else if (D & 16) {
        it = G & 65535, D &= 15, D && (O < D && (g += j[r++] << O, O += 8), it += g & (1 << D) - 1, g >>>= D, O -= D), O < 15 && (g += j[r++] << O, O += 8, g += j[r++] << O, O += 8), G = M[g & V];
        n: for (; ; ) {
          if (D = G >>> 24, g >>>= D, O -= D, D = G >>> 16 & 255, D & 16) {
            if (bt = G & 65535, D &= 15, O < D && (g += j[r++] << O, O += 8, O < D && (g += j[r++] << O, O += 8)), bt += g & (1 << D) - 1, bt > f) {
              n.msg = "invalid distance too far back", N.mode = ds;
              break t;
            }
            if (g >>>= D, O -= D, D = o - u, bt > D) {
              if (D = bt - D, D > p && N.sane) {
                n.msg = "invalid distance too far back", N.mode = ds;
                break t;
              }
              if (dt = 0, $ = L, x === 0) {
                if (dt += c - D, D < it) {
                  it -= D;
                  do
                    J[o++] = L[dt++];
                  while (--D);
                  dt = o - bt, $ = J;
                }
              } else if (x < D) {
                if (dt += c + x - D, D -= x, D < it) {
                  it -= D;
                  do
                    J[o++] = L[dt++];
                  while (--D);
                  if (dt = 0, x < it) {
                    D = x, it -= D;
                    do
                      J[o++] = L[dt++];
                    while (--D);
                    dt = o - bt, $ = J;
                  }
                }
              } else if (dt += x - D, D < it) {
                it -= D;
                do
                  J[o++] = L[dt++];
                while (--D);
                dt = o - bt, $ = J;
              }
              for (; it > 2; ) J[o++] = $[dt++], J[o++] = $[dt++], J[o++] = $[dt++], it -= 3;
              it && (J[o++] = $[dt++], it > 1 && (J[o++] = $[dt++]));
            } else {
              dt = o - bt;
              do
                J[o++] = J[dt++], J[o++] = J[dt++], J[o++] = J[dt++], it -= 3;
              while (it > 2);
              it && (J[o++] = J[dt++], it > 1 && (J[o++] = J[dt++]));
            }
          } else if (D & 64) {
            n.msg = "invalid distance code", N.mode = ds;
            break t;
          } else {
            G = M[(G & 65535) + (g & (1 << D) - 1)];
            continue n;
          }
          break;
        }
      } else if (D & 64) if (D & 32) {
        N.mode = I0;
        break t;
      } else {
        n.msg = "invalid literal/length code", N.mode = ds;
        break t;
      }
      else {
        G = P[(G & 65535) + (g & (1 << D) - 1)];
        continue e;
      }
      break;
    }
  } while (r < i && o < l);
  it = O >> 3, r -= it, O -= it << 3, g &= (1 << O) - 1, n.next_in = r, n.next_out = o, n.avail_in = r < i ? 5 + (i - r) : 5 - (r - i), n.avail_out = o < l ? 257 + (l - o) : 257 - (o - l), N.hold = g, N.bits = O;
};
const va = 15, ku = 852, Pu = 592, Cu = 0, Cl = 1, Eu = 2, O0 = new Uint16Array([3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 15, 17, 19, 23, 27, 31, 35, 43, 51, 59, 67, 83, 99, 115, 131, 163, 195, 227, 258, 0, 0]), T0 = new Uint8Array([16, 16, 16, 16, 16, 16, 16, 16, 17, 17, 17, 17, 18, 18, 18, 18, 19, 19, 19, 19, 20, 20, 20, 20, 21, 21, 21, 21, 16, 72, 78]), R0 = new Uint16Array([1, 2, 3, 4, 5, 7, 9, 13, 17, 25, 33, 49, 65, 97, 129, 193, 257, 385, 513, 769, 1025, 1537, 2049, 3073, 4097, 6145, 8193, 12289, 16385, 24577, 0, 0]), M0 = new Uint8Array([16, 16, 16, 16, 17, 17, 18, 18, 19, 19, 20, 20, 21, 21, 22, 22, 23, 23, 24, 24, 25, 25, 26, 26, 27, 27, 28, 28, 29, 29, 64, 64]), B0 = (t3, n, e, r, i, o, u, l) => {
  const f = l.bits;
  let c = 0, p = 0, x = 0, L = 0, g = 0, O = 0, P = 0, M = 0, k = 0, V = 0, G, D, it, bt, dt, $ = null, j;
  const J = new Uint16Array(va + 1), N = new Uint16Array(va + 1);
  let C = null, z, q, rt;
  for (c = 0; c <= va; c++) J[c] = 0;
  for (p = 0; p < r; p++) J[n[e + p]]++;
  for (g = f, L = va; L >= 1 && J[L] === 0; L--) ;
  if (g > L && (g = L), L === 0) return i[o++] = 1 << 24 | 64 << 16 | 0, i[o++] = 1 << 24 | 64 << 16 | 0, l.bits = 1, 0;
  for (x = 1; x < L && J[x] === 0; x++) ;
  for (g < x && (g = x), M = 1, c = 1; c <= va; c++) if (M <<= 1, M -= J[c], M < 0) return -1;
  if (M > 0 && (t3 === Cu || L !== 1)) return -1;
  for (N[1] = 0, c = 1; c < va; c++) N[c + 1] = N[c] + J[c];
  for (p = 0; p < r; p++) n[e + p] !== 0 && (u[N[n[e + p]]++] = p);
  if (t3 === Cu ? ($ = C = u, j = 20) : t3 === Cl ? ($ = O0, C = T0, j = 257) : ($ = R0, C = M0, j = 0), V = 0, p = 0, c = x, dt = o, O = g, P = 0, it = -1, k = 1 << g, bt = k - 1, t3 === Cl && k > ku || t3 === Eu && k > Pu) return 1;
  for (; ; ) {
    z = c - P, u[p] + 1 < j ? (q = 0, rt = u[p]) : u[p] >= j ? (q = C[u[p] - j], rt = $[u[p] - j]) : (q = 32 + 64, rt = 0), G = 1 << c - P, D = 1 << O, x = D;
    do
      D -= G, i[dt + (V >> P) + D] = z << 24 | q << 16 | rt | 0;
    while (D !== 0);
    for (G = 1 << c - 1; V & G; ) G >>= 1;
    if (G !== 0 ? (V &= G - 1, V += G) : V = 0, p++, --J[c] === 0) {
      if (c === L) break;
      c = n[e + u[p]];
    }
    if (c > g && (V & bt) !== it) {
      for (P === 0 && (P = g), dt += x, O = c - P, M = 1 << O; O + P < L && (M -= J[O + P], !(M <= 0)); ) O++, M <<= 1;
      if (k += 1 << O, t3 === Cl && k > ku || t3 === Eu && k > Pu) return 1;
      it = V & bt, i[it] = g << 24 | O << 16 | dt - o | 0;
    }
  }
  return V !== 0 && (i[dt + V] = c - P << 24 | 64 << 16 | 0), l.bits = g, 0;
};
var vo = B0;
const j0 = 0, cf = 1, ff = 2, { Z_FINISH: Iu, Z_BLOCK: D0, Z_TREES: ps, Z_OK: ta, Z_STREAM_END: q0, Z_NEED_DICT: U0, Z_STREAM_ERROR: or, Z_DATA_ERROR: df, Z_MEM_ERROR: pf, Z_BUF_ERROR: z0, Z_DEFLATED: Fu } = ko, Bs = 16180, Ou = 16181, Tu = 16182, Ru = 16183, Mu = 16184, Bu = 16185, ju = 16186, Du = 16187, qu = 16188, Uu = 16189, Fs = 16190, Zr = 16191, El = 16192, zu = 16193, Il = 16194, Hu = 16195, Wu = 16196, Vu = 16197, Gu = 16198, gs = 16199, ms = 16200, Zu = 16201, Yu = 16202, $u = 16203, Ku = 16204, Xu = 16205, Fl = 16206, Ju = 16207, Qu = 16208, Ue = 16209, gf = 16210, mf = 16211, H0 = 852, W0 = 592, V0 = 15, G0 = V0, tc = (t3) => (t3 >>> 24 & 255) + (t3 >>> 8 & 65280) + ((t3 & 65280) << 8) + ((t3 & 255) << 24);
function Z0() {
  this.strm = null, this.mode = 0, this.last = false, this.wrap = 0, this.havedict = false, this.flags = 0, this.dmax = 0, this.check = 0, this.total = 0, this.head = null, this.wbits = 0, this.wsize = 0, this.whave = 0, this.wnext = 0, this.window = null, this.hold = 0, this.bits = 0, this.length = 0, this.offset = 0, this.extra = 0, this.lencode = null, this.distcode = null, this.lenbits = 0, this.distbits = 0, this.ncode = 0, this.nlen = 0, this.ndist = 0, this.have = 0, this.next = null, this.lens = new Uint16Array(320), this.work = new Uint16Array(288), this.lendyn = null, this.distdyn = null, this.sane = 0, this.back = 0, this.was = 0;
}
const ea = (t3) => {
  if (!t3) return 1;
  const n = t3.state;
  return !n || n.strm !== t3 || n.mode < Bs || n.mode > mf ? 1 : 0;
}, vf = (t3) => {
  if (ea(t3)) return or;
  const n = t3.state;
  return t3.total_in = t3.total_out = n.total = 0, t3.msg = "", n.wrap && (t3.adler = n.wrap & 1), n.mode = Bs, n.last = 0, n.havedict = 0, n.flags = -1, n.dmax = 32768, n.head = null, n.hold = 0, n.bits = 0, n.lencode = n.lendyn = new Int32Array(H0), n.distcode = n.distdyn = new Int32Array(W0), n.sane = 1, n.back = -1, ta;
}, bf = (t3) => {
  if (ea(t3)) return or;
  const n = t3.state;
  return n.wsize = 0, n.whave = 0, n.wnext = 0, vf(t3);
}, wf = (t3, n) => {
  let e;
  if (ea(t3)) return or;
  const r = t3.state;
  return n < 0 ? (e = 0, n = -n) : (e = (n >> 4) + 5, n < 48 && (n &= 15)), n && (n < 8 || n > 15) ? or : (r.window !== null && r.wbits !== n && (r.window = null), r.wrap = e, r.wbits = n, bf(t3));
}, _f = (t3, n) => {
  if (!t3) return or;
  const e = new Z0();
  t3.state = e, e.strm = t3, e.window = null, e.mode = Bs;
  const r = wf(t3, n);
  return r !== ta && (t3.state = null), r;
}, Y0 = (t3) => _f(t3, G0);
let ec = true, Ol, Tl;
const $0 = (t3) => {
  if (ec) {
    Ol = new Int32Array(512), Tl = new Int32Array(32);
    let n = 0;
    for (; n < 144; ) t3.lens[n++] = 8;
    for (; n < 256; ) t3.lens[n++] = 9;
    for (; n < 280; ) t3.lens[n++] = 7;
    for (; n < 288; ) t3.lens[n++] = 8;
    for (vo(cf, t3.lens, 0, 288, Ol, 0, t3.work, { bits: 9 }), n = 0; n < 32; ) t3.lens[n++] = 5;
    vo(ff, t3.lens, 0, 32, Tl, 0, t3.work, { bits: 5 }), ec = false;
  }
  t3.lencode = Ol, t3.lenbits = 9, t3.distcode = Tl, t3.distbits = 5;
}, yf = (t3, n, e, r) => {
  let i;
  const o = t3.state;
  return o.window === null && (o.wsize = 1 << o.wbits, o.wnext = 0, o.whave = 0, o.window = new Uint8Array(o.wsize)), r >= o.wsize ? (o.window.set(n.subarray(e - o.wsize, e), 0), o.wnext = 0, o.whave = o.wsize) : (i = o.wsize - o.wnext, i > r && (i = r), o.window.set(n.subarray(e - r, e - r + i), o.wnext), r -= i, r ? (o.window.set(n.subarray(e - r, e), 0), o.wnext = r, o.whave = o.wsize) : (o.wnext += i, o.wnext === o.wsize && (o.wnext = 0), o.whave < o.wsize && (o.whave += i))), 0;
}, K0 = (t3, n) => {
  let e, r, i, o, u, l, f, c, p, x, L, g, O, P, M = 0, k, V, G, D, it, bt, dt, $;
  const j = new Uint8Array(4);
  let J, N;
  const C = new Uint8Array([16, 17, 18, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, 14, 1, 15]);
  if (ea(t3) || !t3.output || !t3.input && t3.avail_in !== 0) return or;
  e = t3.state, e.mode === Zr && (e.mode = El), u = t3.next_out, i = t3.output, f = t3.avail_out, o = t3.next_in, r = t3.input, l = t3.avail_in, c = e.hold, p = e.bits, x = l, L = f, $ = ta;
  t: for (; ; ) switch (e.mode) {
    case Bs:
      if (e.wrap === 0) {
        e.mode = El;
        break;
      }
      for (; p < 16; ) {
        if (l === 0) break t;
        l--, c += r[o++] << p, p += 8;
      }
      if (e.wrap & 2 && c === 35615) {
        e.wbits === 0 && (e.wbits = 15), e.check = 0, j[0] = c & 255, j[1] = c >>> 8 & 255, e.check = pn(e.check, j, 2, 0), c = 0, p = 0, e.mode = Ou;
        break;
      }
      if (e.head && (e.head.done = false), !(e.wrap & 1) || (((c & 255) << 8) + (c >> 8)) % 31) {
        t3.msg = "incorrect header check", e.mode = Ue;
        break;
      }
      if ((c & 15) !== Fu) {
        t3.msg = "unknown compression method", e.mode = Ue;
        break;
      }
      if (c >>>= 4, p -= 4, dt = (c & 15) + 8, e.wbits === 0 && (e.wbits = dt), dt > 15 || dt > e.wbits) {
        t3.msg = "invalid window size", e.mode = Ue;
        break;
      }
      e.dmax = 1 << e.wbits, e.flags = 0, t3.adler = e.check = 1, e.mode = c & 512 ? Uu : Zr, c = 0, p = 0;
      break;
    case Ou:
      for (; p < 16; ) {
        if (l === 0) break t;
        l--, c += r[o++] << p, p += 8;
      }
      if (e.flags = c, (e.flags & 255) !== Fu) {
        t3.msg = "unknown compression method", e.mode = Ue;
        break;
      }
      if (e.flags & 57344) {
        t3.msg = "unknown header flags set", e.mode = Ue;
        break;
      }
      e.head && (e.head.text = c >> 8 & 1), e.flags & 512 && e.wrap & 4 && (j[0] = c & 255, j[1] = c >>> 8 & 255, e.check = pn(e.check, j, 2, 0)), c = 0, p = 0, e.mode = Tu;
    case Tu:
      for (; p < 32; ) {
        if (l === 0) break t;
        l--, c += r[o++] << p, p += 8;
      }
      e.head && (e.head.time = c), e.flags & 512 && e.wrap & 4 && (j[0] = c & 255, j[1] = c >>> 8 & 255, j[2] = c >>> 16 & 255, j[3] = c >>> 24 & 255, e.check = pn(e.check, j, 4, 0)), c = 0, p = 0, e.mode = Ru;
    case Ru:
      for (; p < 16; ) {
        if (l === 0) break t;
        l--, c += r[o++] << p, p += 8;
      }
      e.head && (e.head.xflags = c & 255, e.head.os = c >> 8), e.flags & 512 && e.wrap & 4 && (j[0] = c & 255, j[1] = c >>> 8 & 255, e.check = pn(e.check, j, 2, 0)), c = 0, p = 0, e.mode = Mu;
    case Mu:
      if (e.flags & 1024) {
        for (; p < 16; ) {
          if (l === 0) break t;
          l--, c += r[o++] << p, p += 8;
        }
        e.length = c, e.head && (e.head.extra_len = c), e.flags & 512 && e.wrap & 4 && (j[0] = c & 255, j[1] = c >>> 8 & 255, e.check = pn(e.check, j, 2, 0)), c = 0, p = 0;
      } else e.head && (e.head.extra = null);
      e.mode = Bu;
    case Bu:
      if (e.flags & 1024 && (g = e.length, g > l && (g = l), g && (e.head && (dt = e.head.extra_len - e.length, e.head.extra || (e.head.extra = new Uint8Array(e.head.extra_len)), e.head.extra.set(r.subarray(o, o + g), dt)), e.flags & 512 && e.wrap & 4 && (e.check = pn(e.check, r, g, o)), l -= g, o += g, e.length -= g), e.length)) break t;
      e.length = 0, e.mode = ju;
    case ju:
      if (e.flags & 2048) {
        if (l === 0) break t;
        g = 0;
        do
          dt = r[o + g++], e.head && dt && e.length < 65536 && (e.head.name += String.fromCharCode(dt));
        while (dt && g < l);
        if (e.flags & 512 && e.wrap & 4 && (e.check = pn(e.check, r, g, o)), l -= g, o += g, dt) break t;
      } else e.head && (e.head.name = null);
      e.length = 0, e.mode = Du;
    case Du:
      if (e.flags & 4096) {
        if (l === 0) break t;
        g = 0;
        do
          dt = r[o + g++], e.head && dt && e.length < 65536 && (e.head.comment += String.fromCharCode(dt));
        while (dt && g < l);
        if (e.flags & 512 && e.wrap & 4 && (e.check = pn(e.check, r, g, o)), l -= g, o += g, dt) break t;
      } else e.head && (e.head.comment = null);
      e.mode = qu;
    case qu:
      if (e.flags & 512) {
        for (; p < 16; ) {
          if (l === 0) break t;
          l--, c += r[o++] << p, p += 8;
        }
        if (e.wrap & 4 && c !== (e.check & 65535)) {
          t3.msg = "header crc mismatch", e.mode = Ue;
          break;
        }
        c = 0, p = 0;
      }
      e.head && (e.head.hcrc = e.flags >> 9 & 1, e.head.done = true), t3.adler = e.check = 0, e.mode = Zr;
      break;
    case Uu:
      for (; p < 32; ) {
        if (l === 0) break t;
        l--, c += r[o++] << p, p += 8;
      }
      t3.adler = e.check = tc(c), c = 0, p = 0, e.mode = Fs;
    case Fs:
      if (e.havedict === 0) return t3.next_out = u, t3.avail_out = f, t3.next_in = o, t3.avail_in = l, e.hold = c, e.bits = p, U0;
      t3.adler = e.check = 1, e.mode = Zr;
    case Zr:
      if (n === D0 || n === ps) break t;
    case El:
      if (e.last) {
        c >>>= p & 7, p -= p & 7, e.mode = Fl;
        break;
      }
      for (; p < 3; ) {
        if (l === 0) break t;
        l--, c += r[o++] << p, p += 8;
      }
      switch (e.last = c & 1, c >>>= 1, p -= 1, c & 3) {
        case 0:
          e.mode = zu;
          break;
        case 1:
          if ($0(e), e.mode = gs, n === ps) {
            c >>>= 2, p -= 2;
            break t;
          }
          break;
        case 2:
          e.mode = Wu;
          break;
        case 3:
          t3.msg = "invalid block type", e.mode = Ue;
      }
      c >>>= 2, p -= 2;
      break;
    case zu:
      for (c >>>= p & 7, p -= p & 7; p < 32; ) {
        if (l === 0) break t;
        l--, c += r[o++] << p, p += 8;
      }
      if ((c & 65535) !== (c >>> 16 ^ 65535)) {
        t3.msg = "invalid stored block lengths", e.mode = Ue;
        break;
      }
      if (e.length = c & 65535, c = 0, p = 0, e.mode = Il, n === ps) break t;
    case Il:
      e.mode = Hu;
    case Hu:
      if (g = e.length, g) {
        if (g > l && (g = l), g > f && (g = f), g === 0) break t;
        i.set(r.subarray(o, o + g), u), l -= g, o += g, f -= g, u += g, e.length -= g;
        break;
      }
      e.mode = Zr;
      break;
    case Wu:
      for (; p < 14; ) {
        if (l === 0) break t;
        l--, c += r[o++] << p, p += 8;
      }
      if (e.nlen = (c & 31) + 257, c >>>= 5, p -= 5, e.ndist = (c & 31) + 1, c >>>= 5, p -= 5, e.ncode = (c & 15) + 4, c >>>= 4, p -= 4, e.nlen > 286 || e.ndist > 30) {
        t3.msg = "too many length or distance symbols", e.mode = Ue;
        break;
      }
      e.have = 0, e.mode = Vu;
    case Vu:
      for (; e.have < e.ncode; ) {
        for (; p < 3; ) {
          if (l === 0) break t;
          l--, c += r[o++] << p, p += 8;
        }
        e.lens[C[e.have++]] = c & 7, c >>>= 3, p -= 3;
      }
      for (; e.have < 19; ) e.lens[C[e.have++]] = 0;
      if (e.lencode = e.lendyn, e.lenbits = 7, J = { bits: e.lenbits }, $ = vo(j0, e.lens, 0, 19, e.lencode, 0, e.work, J), e.lenbits = J.bits, $) {
        t3.msg = "invalid code lengths set", e.mode = Ue;
        break;
      }
      e.have = 0, e.mode = Gu;
    case Gu:
      for (; e.have < e.nlen + e.ndist; ) {
        for (; M = e.lencode[c & (1 << e.lenbits) - 1], k = M >>> 24, V = M >>> 16 & 255, G = M & 65535, !(k <= p); ) {
          if (l === 0) break t;
          l--, c += r[o++] << p, p += 8;
        }
        if (G < 16) c >>>= k, p -= k, e.lens[e.have++] = G;
        else {
          if (G === 16) {
            for (N = k + 2; p < N; ) {
              if (l === 0) break t;
              l--, c += r[o++] << p, p += 8;
            }
            if (c >>>= k, p -= k, e.have === 0) {
              t3.msg = "invalid bit length repeat", e.mode = Ue;
              break;
            }
            dt = e.lens[e.have - 1], g = 3 + (c & 3), c >>>= 2, p -= 2;
          } else if (G === 17) {
            for (N = k + 3; p < N; ) {
              if (l === 0) break t;
              l--, c += r[o++] << p, p += 8;
            }
            c >>>= k, p -= k, dt = 0, g = 3 + (c & 7), c >>>= 3, p -= 3;
          } else {
            for (N = k + 7; p < N; ) {
              if (l === 0) break t;
              l--, c += r[o++] << p, p += 8;
            }
            c >>>= k, p -= k, dt = 0, g = 11 + (c & 127), c >>>= 7, p -= 7;
          }
          if (e.have + g > e.nlen + e.ndist) {
            t3.msg = "invalid bit length repeat", e.mode = Ue;
            break;
          }
          for (; g--; ) e.lens[e.have++] = dt;
        }
      }
      if (e.mode === Ue) break;
      if (e.lens[256] === 0) {
        t3.msg = "invalid code -- missing end-of-block", e.mode = Ue;
        break;
      }
      if (e.lenbits = 9, J = { bits: e.lenbits }, $ = vo(cf, e.lens, 0, e.nlen, e.lencode, 0, e.work, J), e.lenbits = J.bits, $) {
        t3.msg = "invalid literal/lengths set", e.mode = Ue;
        break;
      }
      if (e.distbits = 6, e.distcode = e.distdyn, J = { bits: e.distbits }, $ = vo(ff, e.lens, e.nlen, e.ndist, e.distcode, 0, e.work, J), e.distbits = J.bits, $) {
        t3.msg = "invalid distances set", e.mode = Ue;
        break;
      }
      if (e.mode = gs, n === ps) break t;
    case gs:
      e.mode = ms;
    case ms:
      if (l >= 6 && f >= 258) {
        t3.next_out = u, t3.avail_out = f, t3.next_in = o, t3.avail_in = l, e.hold = c, e.bits = p, F0(t3, L), u = t3.next_out, i = t3.output, f = t3.avail_out, o = t3.next_in, r = t3.input, l = t3.avail_in, c = e.hold, p = e.bits, e.mode === Zr && (e.back = -1);
        break;
      }
      for (e.back = 0; M = e.lencode[c & (1 << e.lenbits) - 1], k = M >>> 24, V = M >>> 16 & 255, G = M & 65535, !(k <= p); ) {
        if (l === 0) break t;
        l--, c += r[o++] << p, p += 8;
      }
      if (V && !(V & 240)) {
        for (D = k, it = V, bt = G; M = e.lencode[bt + ((c & (1 << D + it) - 1) >> D)], k = M >>> 24, V = M >>> 16 & 255, G = M & 65535, !(D + k <= p); ) {
          if (l === 0) break t;
          l--, c += r[o++] << p, p += 8;
        }
        c >>>= D, p -= D, e.back += D;
      }
      if (c >>>= k, p -= k, e.back += k, e.length = G, V === 0) {
        e.mode = Xu;
        break;
      }
      if (V & 32) {
        e.back = -1, e.mode = Zr;
        break;
      }
      if (V & 64) {
        t3.msg = "invalid literal/length code", e.mode = Ue;
        break;
      }
      e.extra = V & 15, e.mode = Zu;
    case Zu:
      if (e.extra) {
        for (N = e.extra; p < N; ) {
          if (l === 0) break t;
          l--, c += r[o++] << p, p += 8;
        }
        e.length += c & (1 << e.extra) - 1, c >>>= e.extra, p -= e.extra, e.back += e.extra;
      }
      e.was = e.length, e.mode = Yu;
    case Yu:
      for (; M = e.distcode[c & (1 << e.distbits) - 1], k = M >>> 24, V = M >>> 16 & 255, G = M & 65535, !(k <= p); ) {
        if (l === 0) break t;
        l--, c += r[o++] << p, p += 8;
      }
      if (!(V & 240)) {
        for (D = k, it = V, bt = G; M = e.distcode[bt + ((c & (1 << D + it) - 1) >> D)], k = M >>> 24, V = M >>> 16 & 255, G = M & 65535, !(D + k <= p); ) {
          if (l === 0) break t;
          l--, c += r[o++] << p, p += 8;
        }
        c >>>= D, p -= D, e.back += D;
      }
      if (c >>>= k, p -= k, e.back += k, V & 64) {
        t3.msg = "invalid distance code", e.mode = Ue;
        break;
      }
      e.offset = G, e.extra = V & 15, e.mode = $u;
    case $u:
      if (e.extra) {
        for (N = e.extra; p < N; ) {
          if (l === 0) break t;
          l--, c += r[o++] << p, p += 8;
        }
        e.offset += c & (1 << e.extra) - 1, c >>>= e.extra, p -= e.extra, e.back += e.extra;
      }
      if (e.offset > e.dmax) {
        t3.msg = "invalid distance too far back", e.mode = Ue;
        break;
      }
      e.mode = Ku;
    case Ku:
      if (f === 0) break t;
      if (g = L - f, e.offset > g) {
        if (g = e.offset - g, g > e.whave && e.sane) {
          t3.msg = "invalid distance too far back", e.mode = Ue;
          break;
        }
        g > e.wnext ? (g -= e.wnext, O = e.wsize - g) : O = e.wnext - g, g > e.length && (g = e.length), P = e.window;
      } else P = i, O = u - e.offset, g = e.length;
      g > f && (g = f), f -= g, e.length -= g;
      do
        i[u++] = P[O++];
      while (--g);
      e.length === 0 && (e.mode = ms);
      break;
    case Xu:
      if (f === 0) break t;
      i[u++] = e.length, f--, e.mode = ms;
      break;
    case Fl:
      if (e.wrap) {
        for (; p < 32; ) {
          if (l === 0) break t;
          l--, c |= r[o++] << p, p += 8;
        }
        if (L -= f, t3.total_out += L, e.total += L, e.wrap & 4 && L && (t3.adler = e.check = e.flags ? pn(e.check, i, L, u - L) : xo(e.check, i, L, u - L)), L = f, e.wrap & 4 && (e.flags ? c : tc(c)) !== e.check) {
          t3.msg = "incorrect data check", e.mode = Ue;
          break;
        }
        c = 0, p = 0;
      }
      e.mode = Ju;
    case Ju:
      if (e.wrap && e.flags) {
        for (; p < 32; ) {
          if (l === 0) break t;
          l--, c += r[o++] << p, p += 8;
        }
        if (e.wrap & 4 && c !== (e.total & 4294967295)) {
          t3.msg = "incorrect length check", e.mode = Ue;
          break;
        }
        c = 0, p = 0;
      }
      e.mode = Qu;
    case Qu:
      $ = q0;
      break t;
    case Ue:
      $ = df;
      break t;
    case gf:
      return pf;
    case mf:
    default:
      return or;
  }
  return t3.next_out = u, t3.avail_out = f, t3.next_in = o, t3.avail_in = l, e.hold = c, e.bits = p, (e.wsize || L !== t3.avail_out && e.mode < Ue && (e.mode < Fl || n !== Iu)) && yf(t3, t3.output, t3.next_out, L - t3.avail_out), x -= t3.avail_in, L -= t3.avail_out, t3.total_in += x, t3.total_out += L, e.total += L, e.wrap & 4 && L && (t3.adler = e.check = e.flags ? pn(e.check, i, L, t3.next_out - L) : xo(e.check, i, L, t3.next_out - L)), t3.data_type = e.bits + (e.last ? 64 : 0) + (e.mode === Zr ? 128 : 0) + (e.mode === gs || e.mode === Il ? 256 : 0), (x === 0 && L === 0 || n === Iu) && $ === ta && ($ = z0), $;
}, X0 = (t3) => {
  if (ea(t3)) return or;
  let n = t3.state;
  return n.window && (n.window = null), t3.state = null, ta;
}, J0 = (t3, n) => {
  if (ea(t3)) return or;
  const e = t3.state;
  return e.wrap & 2 ? (e.head = n, n.done = false, ta) : or;
}, Q0 = (t3, n) => {
  const e = n.length;
  let r, i, o;
  return ea(t3) || (r = t3.state, r.wrap !== 0 && r.mode !== Fs) ? or : r.mode === Fs && (i = 1, i = xo(i, n, e, 0), i !== r.check) ? df : (o = yf(t3, n, e, e), o ? (r.mode = gf, pf) : (r.havedict = 1, ta));
};
var t5 = bf, e5 = wf, n5 = vf, r5 = Y0, i5 = _f, a5 = K0, o5 = X0, s5 = J0, l5 = Q0, h5 = "pako inflate (from Nodeca project)", $r = { inflateReset: t5, inflateReset2: e5, inflateResetKeep: n5, inflateInit: r5, inflateInit2: i5, inflate: a5, inflateEnd: o5, inflateGetHeader: s5, inflateSetDictionary: l5, inflateInfo: h5 };
function u5() {
  this.text = 0, this.time = 0, this.xflags = 0, this.os = 0, this.extra = null, this.extra_len = 0, this.name = "", this.comment = "", this.hcrc = 0, this.done = false;
}
var c5 = u5;
const xf = Object.prototype.toString, { Z_NO_FLUSH: f5, Z_FINISH: d5, Z_OK: No, Z_STREAM_END: Rl, Z_NEED_DICT: Ml, Z_STREAM_ERROR: p5, Z_DATA_ERROR: nc, Z_MEM_ERROR: g5 } = ko;
function Co(t3) {
  this.options = Ms.assign({ chunkSize: 1024 * 64, windowBits: 15, to: "" }, t3 || {});
  const n = this.options;
  n.raw && n.windowBits >= 0 && n.windowBits < 16 && (n.windowBits = -n.windowBits, n.windowBits === 0 && (n.windowBits = -15)), n.windowBits >= 0 && n.windowBits < 16 && !(t3 && t3.windowBits) && (n.windowBits += 32), n.windowBits > 15 && n.windowBits < 48 && (n.windowBits & 15 || (n.windowBits |= 15)), this.err = 0, this.msg = "", this.ended = false, this.chunks = [], this.strm = new hf(), this.strm.avail_out = 0;
  let e = $r.inflateInit2(this.strm, n.windowBits);
  if (e !== No) throw new Error(Pa[e]);
  if (this.header = new c5(), $r.inflateGetHeader(this.strm, this.header), n.dictionary && (typeof n.dictionary == "string" ? n.dictionary = Lo.string2buf(n.dictionary) : xf.call(n.dictionary) === "[object ArrayBuffer]" && (n.dictionary = new Uint8Array(n.dictionary)), n.raw && (e = $r.inflateSetDictionary(this.strm, n.dictionary), e !== No))) throw new Error(Pa[e]);
}
Co.prototype.push = function(t3, n) {
  const e = this.strm, r = this.options.chunkSize, i = this.options.dictionary;
  let o, u, l;
  if (this.ended) return false;
  for (n === ~~n ? u = n : u = n === true ? d5 : f5, xf.call(t3) === "[object ArrayBuffer]" ? e.input = new Uint8Array(t3) : e.input = t3, e.next_in = 0, e.avail_in = e.input.length; ; ) {
    for (e.avail_out === 0 && (e.output = new Uint8Array(r), e.next_out = 0, e.avail_out = r), o = $r.inflate(e, u), o === Ml && i && (o = $r.inflateSetDictionary(e, i), o === No ? o = $r.inflate(e, u) : o === nc && (o = Ml)); e.avail_in > 0 && o === Rl && e.state.wrap > 0 && t3[e.next_in] !== 0; ) $r.inflateReset(e), o = $r.inflate(e, u);
    switch (o) {
      case p5:
      case nc:
      case Ml:
      case g5:
        return this.onEnd(o), this.ended = true, false;
    }
    if (l = e.avail_out, e.next_out && (e.avail_out === 0 || o === Rl)) if (this.options.to === "string") {
      let f = Lo.utf8border(e.output, e.next_out), c = e.next_out - f, p = Lo.buf2string(e.output, f);
      e.next_out = c, e.avail_out = r - c, c && e.output.set(e.output.subarray(f, f + c), 0), this.onData(p);
    } else this.onData(e.output.length === e.next_out ? e.output : e.output.subarray(0, e.next_out));
    if (!(o === No && l === 0)) {
      if (o === Rl) return o = $r.inflateEnd(this.strm), this.onEnd(o), this.ended = true, true;
      if (e.avail_in === 0) break;
    }
  }
  return true;
};
Co.prototype.onData = function(t3) {
  this.chunks.push(t3);
};
Co.prototype.onEnd = function(t3) {
  t3 === No && (this.options.to === "string" ? this.result = this.chunks.join("") : this.result = Ms.flattenChunks(this.chunks)), this.chunks = [], this.err = t3, this.msg = this.strm.msg;
};
function yh(t3, n) {
  const e = new Co(n);
  if (e.push(t3), e.err) throw e.msg || Pa[e.err];
  return e.result;
}
function m5(t3, n) {
  return n = n || {}, n.raw = true, yh(t3, n);
}
var v5 = Co, b5 = yh, w5 = m5, _5 = yh, y5 = ko, x5 = { Inflate: v5, inflate: b5, inflateRaw: w5, ungzip: _5, constants: y5 };
const { Inflate: A5, inflate: L5, inflateRaw: mp, ungzip: vp } = x5;
var rc = A5, N5 = L5;
const Af = [];
for (let t3 = 0; t3 < 256; t3++) {
  let n = t3;
  for (let e = 0; e < 8; e++) n & 1 ? n = 3988292384 ^ n >>> 1 : n = n >>> 1;
  Af[t3] = n;
}
const ic = 4294967295;
function S5(t3, n, e) {
  let r = t3;
  for (let i = 0; i < e; i++) r = Af[(r ^ n[i]) & 255] ^ r >>> 8;
  return r;
}
function k5(t3, n) {
  return (S5(ic, t3, n) ^ ic) >>> 0;
}
function ac(t3, n, e) {
  const r = t3.readUint32(), i = k5(new Uint8Array(t3.buffer, t3.byteOffset + t3.offset - n - 4, n), n);
  if (i !== r) throw new Error(`CRC mismatch for chunk ${e}. Expected ${r}, found ${i}`);
}
function Lf(t3, n, e) {
  for (let r = 0; r < e; r++) n[r] = t3[r];
}
function Nf(t3, n, e, r) {
  let i = 0;
  for (; i < r; i++) n[i] = t3[i];
  for (; i < e; i++) n[i] = t3[i] + n[i - r] & 255;
}
function Sf(t3, n, e, r) {
  let i = 0;
  if (e.length === 0) for (; i < r; i++) n[i] = t3[i];
  else for (; i < r; i++) n[i] = t3[i] + e[i] & 255;
}
function kf(t3, n, e, r, i) {
  let o = 0;
  if (e.length === 0) {
    for (; o < i; o++) n[o] = t3[o];
    for (; o < r; o++) n[o] = t3[o] + (n[o - i] >> 1) & 255;
  } else {
    for (; o < i; o++) n[o] = t3[o] + (e[o] >> 1) & 255;
    for (; o < r; o++) n[o] = t3[o] + (n[o - i] + e[o] >> 1) & 255;
  }
}
function Pf(t3, n, e, r, i) {
  let o = 0;
  if (e.length === 0) {
    for (; o < i; o++) n[o] = t3[o];
    for (; o < r; o++) n[o] = t3[o] + n[o - i] & 255;
  } else {
    for (; o < i; o++) n[o] = t3[o] + e[o] & 255;
    for (; o < r; o++) n[o] = t3[o] + P5(n[o - i], e[o], e[o - i]) & 255;
  }
}
function P5(t3, n, e) {
  const r = t3 + n - e, i = Math.abs(r - t3), o = Math.abs(r - n), u = Math.abs(r - e);
  return i <= o && i <= u ? t3 : o <= u ? n : e;
}
function C5(t3, n, e, r, i, o) {
  switch (t3) {
    case 0:
      Lf(n, e, i);
      break;
    case 1:
      Nf(n, e, i, o);
      break;
    case 2:
      Sf(n, e, r, i);
      break;
    case 3:
      kf(n, e, r, i, o);
      break;
    case 4:
      Pf(n, e, r, i, o);
      break;
    default:
      throw new Error(`Unsupported filter: ${t3}`);
  }
}
const E5 = new Uint16Array([255]), I5 = new Uint8Array(E5.buffer), F5 = I5[0] === 255;
function O5(t3) {
  const { data: n, width: e, height: r, channels: i, depth: o } = t3, u = [{ x: 0, y: 0, xStep: 8, yStep: 8 }, { x: 4, y: 0, xStep: 8, yStep: 8 }, { x: 0, y: 4, xStep: 4, yStep: 8 }, { x: 2, y: 0, xStep: 4, yStep: 4 }, { x: 0, y: 2, xStep: 2, yStep: 4 }, { x: 1, y: 0, xStep: 2, yStep: 2 }, { x: 0, y: 1, xStep: 1, yStep: 2 }], l = Math.ceil(o / 8) * i, f = new Uint8Array(r * e * l);
  let c = 0;
  for (let p = 0; p < 7; p++) {
    const x = u[p], L = Math.ceil((e - x.x) / x.xStep), g = Math.ceil((r - x.y) / x.yStep);
    if (L <= 0 || g <= 0) continue;
    const O = L * l, P = new Uint8Array(O);
    for (let M = 0; M < g; M++) {
      const k = n[c++], V = n.subarray(c, c + O);
      c += O;
      const G = new Uint8Array(O);
      C5(k, V, G, P, O, l), P.set(G);
      for (let D = 0; D < L; D++) {
        const it = x.x + D * x.xStep, bt = x.y + M * x.yStep;
        if (!(it >= e || bt >= r)) for (let dt = 0; dt < l; dt++) f[(bt * e + it) * l + dt] = G[D * l + dt];
      }
    }
  }
  if (o === 16) {
    const p = new Uint16Array(f.buffer);
    if (F5) for (let x = 0; x < p.length; x++) p[x] = T5(p[x]);
    return p;
  } else return f;
}
function T5(t3) {
  return (t3 & 255) << 8 | t3 >> 8 & 255;
}
const R5 = new Uint16Array([255]), M5 = new Uint8Array(R5.buffer), B5 = M5[0] === 255, j5 = new Uint8Array(0);
function oc(t3) {
  const { data: n, width: e, height: r, channels: i, depth: o } = t3, u = Math.ceil(o / 8) * i, l = Math.ceil(o / 8 * i * e), f = new Uint8Array(r * l);
  let c = j5, p = 0, x, L;
  for (let g = 0; g < r; g++) {
    switch (x = n.subarray(p + 1, p + 1 + l), L = f.subarray(g * l, (g + 1) * l), n[p]) {
      case 0:
        Lf(x, L, l);
        break;
      case 1:
        Nf(x, L, l, u);
        break;
      case 2:
        Sf(x, L, c, l);
        break;
      case 3:
        kf(x, L, c, l, u);
        break;
      case 4:
        Pf(x, L, c, l, u);
        break;
      default:
        throw new Error(`Unsupported filter: ${n[p]}`);
    }
    c = L, p += l + 1;
  }
  if (o === 16) {
    const g = new Uint16Array(f.buffer);
    if (B5) for (let O = 0; O < g.length; O++) g[O] = D5(g[O]);
    return g;
  } else return f;
}
function D5(t3) {
  return (t3 & 255) << 8 | t3 >> 8 & 255;
}
const As = Uint8Array.of(137, 80, 78, 71, 13, 10, 26, 10);
function sc(t3) {
  if (!q5(t3.readBytes(As.length))) throw new Error("wrong PNG signature");
}
function q5(t3) {
  if (t3.length < As.length) return false;
  for (let n = 0; n < As.length; n++) if (t3[n] !== As[n]) return false;
  return true;
}
const U5 = "tEXt", z5 = 0, Cf = new TextDecoder("latin1");
function H5(t3) {
  if (V5(t3), t3.length === 0 || t3.length > 79) throw new Error("keyword length must be between 1 and 79");
}
const W5 = /^[\u0000-\u00FF]*$/;
function V5(t3) {
  if (!W5.test(t3)) throw new Error("invalid latin1 text");
}
function G5(t3, n, e) {
  const r = Ef(n);
  t3[r] = Z5(n, e - r.length - 1);
}
function Ef(t3) {
  for (t3.mark(); t3.readByte() !== z5; ) ;
  const n = t3.offset;
  t3.reset();
  const e = Cf.decode(t3.readBytes(n - t3.offset - 1));
  return t3.skip(1), H5(e), e;
}
function Z5(t3, n) {
  return Cf.decode(t3.readBytes(n));
}
const Gn = { UNKNOWN: -1, GREYSCALE: 0, TRUECOLOUR: 2, INDEXED_COLOUR: 3, GREYSCALE_ALPHA: 4, TRUECOLOUR_ALPHA: 6 }, Bl = { UNKNOWN: -1, DEFLATE: 0 }, lc = { UNKNOWN: -1, ADAPTIVE: 0 }, jl = { UNKNOWN: -1, NO_INTERLACE: 0, ADAM7: 1 }, vs = { NONE: 0, BACKGROUND: 1, PREVIOUS: 2 }, Dl = { SOURCE: 0, OVER: 1 };
class Y5 extends ph {
  constructor(e, r = {}) {
    super(e);
    Pe(this, "_checkCrc");
    Pe(this, "_inflator");
    Pe(this, "_png");
    Pe(this, "_apng");
    Pe(this, "_end");
    Pe(this, "_hasPalette");
    Pe(this, "_palette");
    Pe(this, "_hasTransparency");
    Pe(this, "_transparency");
    Pe(this, "_compressionMethod");
    Pe(this, "_filterMethod");
    Pe(this, "_interlaceMethod");
    Pe(this, "_colorType");
    Pe(this, "_isAnimated");
    Pe(this, "_numberOfFrames");
    Pe(this, "_numberOfPlays");
    Pe(this, "_frames");
    Pe(this, "_writingDataChunks");
    const { checkCrc: i = false } = r;
    this._checkCrc = i, this._inflator = new rc(), this._png = { width: -1, height: -1, channels: -1, data: new Uint8Array(0), depth: 1, text: {} }, this._apng = { width: -1, height: -1, channels: -1, depth: 1, numberOfFrames: 1, numberOfPlays: 0, text: {}, frames: [] }, this._end = false, this._hasPalette = false, this._palette = [], this._hasTransparency = false, this._transparency = new Uint16Array(0), this._compressionMethod = Bl.UNKNOWN, this._filterMethod = lc.UNKNOWN, this._interlaceMethod = jl.UNKNOWN, this._colorType = Gn.UNKNOWN, this._isAnimated = false, this._numberOfFrames = 1, this._numberOfPlays = 0, this._frames = [], this._writingDataChunks = false, this.setBigEndian();
  }
  decode() {
    for (sc(this); !this._end; ) {
      const e = this.readUint32(), r = this.readChars(4);
      this.decodeChunk(e, r);
    }
    return this.decodeImage(), this._png;
  }
  decodeApng() {
    for (sc(this); !this._end; ) {
      const e = this.readUint32(), r = this.readChars(4);
      this.decodeApngChunk(e, r);
    }
    return this.decodeApngImage(), this._apng;
  }
  decodeChunk(e, r) {
    const i = this.offset;
    switch (r) {
      case "IHDR":
        this.decodeIHDR();
        break;
      case "PLTE":
        this.decodePLTE(e);
        break;
      case "IDAT":
        this.decodeIDAT(e);
        break;
      case "IEND":
        this._end = true;
        break;
      case "tRNS":
        this.decodetRNS(e);
        break;
      case "iCCP":
        this.decodeiCCP(e);
        break;
      case U5:
        G5(this._png.text, this, e);
        break;
      case "pHYs":
        this.decodepHYs();
        break;
      default:
        this.skip(e);
        break;
    }
    if (this.offset - i !== e) throw new Error(`Length mismatch while decoding chunk ${r}`);
    this._checkCrc ? ac(this, e + 4, r) : this.skip(4);
  }
  decodeApngChunk(e, r) {
    const i = this.offset;
    switch (r !== "fdAT" && r !== "IDAT" && this._writingDataChunks && this.pushDataToFrame(), r) {
      case "acTL":
        this.decodeACTL();
        break;
      case "fcTL":
        this.decodeFCTL();
        break;
      case "fdAT":
        this.decodeFDAT(e);
        break;
      default:
        this.decodeChunk(e, r), this.offset = i + e;
        break;
    }
    if (this.offset - i !== e) throw new Error(`Length mismatch while decoding chunk ${r}`);
    this._checkCrc ? ac(this, e + 4, r) : this.skip(4);
  }
  decodeIHDR() {
    const e = this._png;
    e.width = this.readUint32(), e.height = this.readUint32(), e.depth = $5(this.readUint8());
    const r = this.readUint8();
    this._colorType = r;
    let i;
    switch (r) {
      case Gn.GREYSCALE:
        i = 1;
        break;
      case Gn.TRUECOLOUR:
        i = 3;
        break;
      case Gn.INDEXED_COLOUR:
        i = 1;
        break;
      case Gn.GREYSCALE_ALPHA:
        i = 2;
        break;
      case Gn.TRUECOLOUR_ALPHA:
        i = 4;
        break;
      case Gn.UNKNOWN:
      default:
        throw new Error(`Unknown color type: ${r}`);
    }
    if (this._png.channels = i, this._compressionMethod = this.readUint8(), this._compressionMethod !== Bl.DEFLATE) throw new Error(`Unsupported compression method: ${this._compressionMethod}`);
    this._filterMethod = this.readUint8(), this._interlaceMethod = this.readUint8();
  }
  decodeACTL() {
    this._numberOfFrames = this.readUint32(), this._numberOfPlays = this.readUint32(), this._isAnimated = true;
  }
  decodeFCTL() {
    const e = { sequenceNumber: this.readUint32(), width: this.readUint32(), height: this.readUint32(), xOffset: this.readUint32(), yOffset: this.readUint32(), delayNumber: this.readUint16(), delayDenominator: this.readUint16(), disposeOp: this.readUint8(), blendOp: this.readUint8(), data: new Uint8Array(0) };
    this._frames.push(e);
  }
  decodePLTE(e) {
    if (e % 3 !== 0) throw new RangeError(`PLTE field length must be a multiple of 3. Got ${e}`);
    const r = e / 3;
    this._hasPalette = true;
    const i = [];
    this._palette = i;
    for (let o = 0; o < r; o++) i.push([this.readUint8(), this.readUint8(), this.readUint8()]);
  }
  decodeIDAT(e) {
    this._writingDataChunks = true;
    const r = e, i = this.offset + this.byteOffset;
    if (this._inflator.push(new Uint8Array(this.buffer, i, r)), this._inflator.err) throw new Error(`Error while decompressing the data: ${this._inflator.err}`);
    this.skip(e);
  }
  decodeFDAT(e) {
    this._writingDataChunks = true;
    let r = e, i = this.offset + this.byteOffset;
    if (i += 4, r -= 4, this._inflator.push(new Uint8Array(this.buffer, i, r)), this._inflator.err) throw new Error(`Error while decompressing the data: ${this._inflator.err}`);
    this.skip(e);
  }
  decodetRNS(e) {
    switch (this._colorType) {
      case Gn.GREYSCALE:
      case Gn.TRUECOLOUR: {
        if (e % 2 !== 0) throw new RangeError(`tRNS chunk length must be a multiple of 2. Got ${e}`);
        if (e / 2 > this._png.width * this._png.height) throw new Error(`tRNS chunk contains more alpha values than there are pixels (${e / 2} vs ${this._png.width * this._png.height})`);
        this._hasTransparency = true, this._transparency = new Uint16Array(e / 2);
        for (let r = 0; r < e / 2; r++) this._transparency[r] = this.readUint16();
        break;
      }
      case Gn.INDEXED_COLOUR: {
        if (e > this._palette.length) throw new Error(`tRNS chunk contains more alpha values than there are palette colors (${e} vs ${this._palette.length})`);
        let r = 0;
        for (; r < e; r++) {
          const i = this.readByte();
          this._palette[r].push(i);
        }
        for (; r < this._palette.length; r++) this._palette[r].push(255);
        break;
      }
      case Gn.UNKNOWN:
      case Gn.GREYSCALE_ALPHA:
      case Gn.TRUECOLOUR_ALPHA:
      default:
        throw new Error(`tRNS chunk is not supported for color type ${this._colorType}`);
    }
  }
  decodeiCCP(e) {
    const r = Ef(this), i = this.readUint8();
    if (i !== Bl.DEFLATE) throw new Error(`Unsupported iCCP compression method: ${i}`);
    const o = this.readBytes(e - r.length - 2);
    this._png.iccEmbeddedProfile = { name: r, profile: N5(o) };
  }
  decodepHYs() {
    const e = this.readUint32(), r = this.readUint32(), i = this.readByte();
    this._png.resolution = { x: e, y: r, unit: i };
  }
  decodeApngImage() {
    this._apng.width = this._png.width, this._apng.height = this._png.height, this._apng.channels = this._png.channels, this._apng.depth = this._png.depth, this._apng.numberOfFrames = this._numberOfFrames, this._apng.numberOfPlays = this._numberOfPlays, this._apng.text = this._png.text, this._apng.resolution = this._png.resolution;
    for (let e = 0; e < this._numberOfFrames; e++) {
      const r = { sequenceNumber: this._frames[e].sequenceNumber, delayNumber: this._frames[e].delayNumber, delayDenominator: this._frames[e].delayDenominator, data: this._apng.depth === 8 ? new Uint8Array(this._apng.width * this._apng.height * this._apng.channels) : new Uint16Array(this._apng.width * this._apng.height * this._apng.channels) }, i = this._frames.at(e);
      if (i) {
        if (i.data = oc({ data: i.data, width: i.width, height: i.height, channels: this._apng.channels, depth: this._apng.depth }), this._hasPalette && (this._apng.palette = this._palette), this._hasTransparency && (this._apng.transparency = this._transparency), e === 0 || i.xOffset === 0 && i.yOffset === 0 && i.width === this._png.width && i.height === this._png.height) r.data = i.data;
        else {
          const o = this._apng.frames.at(e - 1);
          this.disposeFrame(i, o, r), this.addFrameDataToCanvas(r, i);
        }
        this._apng.frames.push(r);
      }
    }
    return this._apng;
  }
  disposeFrame(e, r, i) {
    switch (e.disposeOp) {
      case vs.NONE:
        break;
      case vs.BACKGROUND:
        for (let o = 0; o < this._png.height; o++) for (let u = 0; u < this._png.width; u++) {
          const l = (o * e.width + u) * this._png.channels;
          for (let f = 0; f < this._png.channels; f++) i.data[l + f] = 0;
        }
        break;
      case vs.PREVIOUS:
        i.data.set(r.data);
        break;
      default:
        throw new Error("Unknown disposeOp");
    }
  }
  addFrameDataToCanvas(e, r) {
    const i = 1 << this._png.depth, o = (u, l) => {
      const f = ((u + r.yOffset) * this._png.width + r.xOffset + l) * this._png.channels, c = (u * r.width + l) * this._png.channels;
      return { index: f, frameIndex: c };
    };
    switch (r.blendOp) {
      case Dl.SOURCE:
        for (let u = 0; u < r.height; u++) for (let l = 0; l < r.width; l++) {
          const { index: f, frameIndex: c } = o(u, l);
          for (let p = 0; p < this._png.channels; p++) e.data[f + p] = r.data[c + p];
        }
        break;
      case Dl.OVER:
        for (let u = 0; u < r.height; u++) for (let l = 0; l < r.width; l++) {
          const { index: f, frameIndex: c } = o(u, l);
          for (let p = 0; p < this._png.channels; p++) {
            const x = r.data[c + this._png.channels - 1] / i, L = p % (this._png.channels - 1) === 0 ? 1 : r.data[c + p], g = Math.floor(x * L + (1 - x) * e.data[f + p]);
            e.data[f + p] += g;
          }
        }
        break;
      default:
        throw new Error("Unknown blendOp");
    }
  }
  decodeImage() {
    var r;
    if (this._inflator.err) throw new Error(`Error while decompressing the data: ${this._inflator.err}`);
    const e = this._isAnimated ? ((r = this._frames) == null ? void 0 : r.at(0)).data : this._inflator.result;
    if (this._filterMethod !== lc.ADAPTIVE) throw new Error(`Filter method ${this._filterMethod} not supported`);
    if (this._interlaceMethod === jl.NO_INTERLACE) this._png.data = oc({ data: e, width: this._png.width, height: this._png.height, channels: this._png.channels, depth: this._png.depth });
    else if (this._interlaceMethod === jl.ADAM7) this._png.data = O5({ data: e, width: this._png.width, height: this._png.height, channels: this._png.channels, depth: this._png.depth });
    else throw new Error(`Interlace method ${this._interlaceMethod} not supported`);
    this._hasPalette && (this._png.palette = this._palette), this._hasTransparency && (this._png.transparency = this._transparency);
  }
  pushDataToFrame() {
    const e = this._inflator.result, r = this._frames.at(-1);
    r ? r.data = e : this._frames.push({ sequenceNumber: 0, width: this._png.width, height: this._png.height, xOffset: 0, yOffset: 0, delayNumber: 0, delayDenominator: 0, disposeOp: vs.NONE, blendOp: Dl.SOURCE, data: e }), this._inflator = new rc(), this._writingDataChunks = false;
  }
}
function $5(t3) {
  if (t3 !== 1 && t3 !== 2 && t3 !== 4 && t3 !== 8 && t3 !== 16) throw new Error(`invalid bit depth: ${t3}`);
  return t3;
}
var hc;
(function(t3) {
  t3[t3.UNKNOWN = 0] = "UNKNOWN", t3[t3.METRE = 1] = "METRE";
})(hc || (hc = {}));
function K5(t3, n) {
  return new Y5(t3, n).decode();
}
var $t = /* @__PURE__ */ (function() {
  return typeof window < "u" ? window : typeof global < "u" ? global : typeof self < "u" ? self : this;
})();
function ql() {
  $t.console && typeof $t.console.log == "function" && $t.console.log.apply($t.console, arguments);
}
var Re = { log: ql, warn: function(t3) {
  $t.console && (typeof $t.console.warn == "function" ? $t.console.warn.apply($t.console, arguments) : ql.call(null, arguments));
}, error: function(t3) {
  $t.console && (typeof $t.console.error == "function" ? $t.console.error.apply($t.console, arguments) : ql(t3));
} };
function Ul(t3, n, e) {
  var r = new XMLHttpRequest();
  r.open("GET", t3), r.responseType = "blob", r.onload = function() {
    Gi(r.response, n, e);
  }, r.onerror = function() {
    Re.error("could not download file");
  }, r.send();
}
function uc(t3) {
  var n = new XMLHttpRequest();
  n.open("HEAD", t3, false);
  try {
    n.send();
  } catch {
  }
  return n.status >= 200 && n.status <= 299;
}
function bs(t3) {
  try {
    t3.dispatchEvent(new MouseEvent("click"));
  } catch {
    var n = document.createEvent("MouseEvents");
    n.initMouseEvent("click", true, true, window, 0, 0, 0, 80, 20, false, false, false, false, 0, null), t3.dispatchEvent(n);
  }
}
var Gi = $t.saveAs || ((typeof window > "u" ? "undefined" : Ce(window)) !== "object" || window !== $t ? function() {
} : typeof HTMLAnchorElement < "u" && "download" in HTMLAnchorElement.prototype ? function(t3, n, e) {
  var r = $t.URL || $t.webkitURL, i = document.createElement("a");
  n = n || t3.name || "download", i.download = n, i.rel = "noopener", typeof t3 == "string" ? (i.href = t3, i.origin !== location.origin ? uc(i.href) ? Ul(t3, n, e) : bs(i, i.target = "_blank") : bs(i)) : (i.href = r.createObjectURL(t3), setTimeout(function() {
    r.revokeObjectURL(i.href);
  }, 4e4), setTimeout(function() {
    bs(i);
  }, 0));
} : "msSaveOrOpenBlob" in navigator ? function(t3, n, e) {
  if (n = n || t3.name || "download", typeof t3 == "string") if (uc(t3)) Ul(t3, n, e);
  else {
    var r = document.createElement("a");
    r.href = t3, r.target = "_blank", setTimeout(function() {
      bs(r);
    });
  }
  else navigator.msSaveOrOpenBlob((function(i, o) {
    return o === void 0 ? o = { autoBom: false } : Ce(o) !== "object" && (Re.warn("Deprecated: Expected third argument to be a object"), o = { autoBom: !o }), o.autoBom && /^\s*(?:text\/\S*|application\/xml|\S*\/\S*\+xml)\s*;.*charset\s*=\s*utf-8/i.test(i.type) ? new Blob([String.fromCharCode(65279), i], { type: i.type }) : i;
  })(t3, e), n);
} : function(t3, n, e, r) {
  if ((r = r || open("", "_blank")) && (r.document.title = r.document.body.innerText = "downloading..."), typeof t3 == "string") return Ul(t3, n, e);
  var i = t3.type === "application/octet-stream", o = /constructor/i.test($t.HTMLElement) || $t.safari, u = /CriOS\/[\d]+/.test(navigator.userAgent);
  if ((u || i && o) && (typeof FileReader > "u" ? "undefined" : Ce(FileReader)) === "object") {
    var l = new FileReader();
    l.onloadend = function() {
      var p = l.result;
      p = u ? p : p.replace(/^data:[^;]*;/, "data:attachment/file;"), r ? r.location.href = p : location = p, r = null;
    }, l.readAsDataURL(t3);
  } else {
    var f = $t.URL || $t.webkitURL, c = f.createObjectURL(t3);
    r ? r.location = c : location.href = c, r = null, setTimeout(function() {
      f.revokeObjectURL(c);
    }, 4e4);
  }
});
/**
* A class to parse color values
* @author Stoyan Stefanov <sstoo@gmail.com>
* {@link   http://www.phpied.com/rgb-color-parser-in-javascript/}
* @license Use it if you like it
*/
function If(t3) {
  var n;
  t3 = t3 || "", this.ok = false, t3.charAt(0) == "#" && (t3 = t3.substr(1, 6)), t3 = { aliceblue: "f0f8ff", antiquewhite: "faebd7", aqua: "00ffff", aquamarine: "7fffd4", azure: "f0ffff", beige: "f5f5dc", bisque: "ffe4c4", black: "000000", blanchedalmond: "ffebcd", blue: "0000ff", blueviolet: "8a2be2", brown: "a52a2a", burlywood: "deb887", cadetblue: "5f9ea0", chartreuse: "7fff00", chocolate: "d2691e", coral: "ff7f50", cornflowerblue: "6495ed", cornsilk: "fff8dc", crimson: "dc143c", cyan: "00ffff", darkblue: "00008b", darkcyan: "008b8b", darkgoldenrod: "b8860b", darkgray: "a9a9a9", darkgreen: "006400", darkkhaki: "bdb76b", darkmagenta: "8b008b", darkolivegreen: "556b2f", darkorange: "ff8c00", darkorchid: "9932cc", darkred: "8b0000", darksalmon: "e9967a", darkseagreen: "8fbc8f", darkslateblue: "483d8b", darkslategray: "2f4f4f", darkturquoise: "00ced1", darkviolet: "9400d3", deeppink: "ff1493", deepskyblue: "00bfff", dimgray: "696969", dodgerblue: "1e90ff", feldspar: "d19275", firebrick: "b22222", floralwhite: "fffaf0", forestgreen: "228b22", fuchsia: "ff00ff", gainsboro: "dcdcdc", ghostwhite: "f8f8ff", gold: "ffd700", goldenrod: "daa520", gray: "808080", green: "008000", greenyellow: "adff2f", honeydew: "f0fff0", hotpink: "ff69b4", indianred: "cd5c5c", indigo: "4b0082", ivory: "fffff0", khaki: "f0e68c", lavender: "e6e6fa", lavenderblush: "fff0f5", lawngreen: "7cfc00", lemonchiffon: "fffacd", lightblue: "add8e6", lightcoral: "f08080", lightcyan: "e0ffff", lightgoldenrodyellow: "fafad2", lightgrey: "d3d3d3", lightgreen: "90ee90", lightpink: "ffb6c1", lightsalmon: "ffa07a", lightseagreen: "20b2aa", lightskyblue: "87cefa", lightslateblue: "8470ff", lightslategray: "778899", lightsteelblue: "b0c4de", lightyellow: "ffffe0", lime: "00ff00", limegreen: "32cd32", linen: "faf0e6", magenta: "ff00ff", maroon: "800000", mediumaquamarine: "66cdaa", mediumblue: "0000cd", mediumorchid: "ba55d3", mediumpurple: "9370d8", mediumseagreen: "3cb371", mediumslateblue: "7b68ee", mediumspringgreen: "00fa9a", mediumturquoise: "48d1cc", mediumvioletred: "c71585", midnightblue: "191970", mintcream: "f5fffa", mistyrose: "ffe4e1", moccasin: "ffe4b5", navajowhite: "ffdead", navy: "000080", oldlace: "fdf5e6", olive: "808000", olivedrab: "6b8e23", orange: "ffa500", orangered: "ff4500", orchid: "da70d6", palegoldenrod: "eee8aa", palegreen: "98fb98", paleturquoise: "afeeee", palevioletred: "d87093", papayawhip: "ffefd5", peachpuff: "ffdab9", peru: "cd853f", pink: "ffc0cb", plum: "dda0dd", powderblue: "b0e0e6", purple: "800080", red: "ff0000", rosybrown: "bc8f8f", royalblue: "4169e1", saddlebrown: "8b4513", salmon: "fa8072", sandybrown: "f4a460", seagreen: "2e8b57", seashell: "fff5ee", sienna: "a0522d", silver: "c0c0c0", skyblue: "87ceeb", slateblue: "6a5acd", slategray: "708090", snow: "fffafa", springgreen: "00ff7f", steelblue: "4682b4", tan: "d2b48c", teal: "008080", thistle: "d8bfd8", tomato: "ff6347", turquoise: "40e0d0", violet: "ee82ee", violetred: "d02090", wheat: "f5deb3", white: "ffffff", whitesmoke: "f5f5f5", yellow: "ffff00", yellowgreen: "9acd32" }[t3 = (t3 = t3.replace(/ /g, "")).toLowerCase()] || t3;
  for (var e = [{ re: /^rgb\((\d{1,3}),\s*(\d{1,3}),\s*(\d{1,3})\)$/, example: ["rgb(123, 234, 45)", "rgb(255,234,245)"], process: function(l) {
    return [parseInt(l[1]), parseInt(l[2]), parseInt(l[3])];
  } }, { re: /^(\w{2})(\w{2})(\w{2})$/, example: ["#00ff00", "336699"], process: function(l) {
    return [parseInt(l[1], 16), parseInt(l[2], 16), parseInt(l[3], 16)];
  } }, { re: /^(\w{1})(\w{1})(\w{1})$/, example: ["#fb0", "f0f"], process: function(l) {
    return [parseInt(l[1] + l[1], 16), parseInt(l[2] + l[2], 16), parseInt(l[3] + l[3], 16)];
  } }], r = 0; r < e.length; r++) {
    var i = e[r].re, o = e[r].process, u = i.exec(t3);
    u && (n = o(u), this.r = n[0], this.g = n[1], this.b = n[2], this.ok = true);
  }
  this.r = this.r < 0 || isNaN(this.r) ? 0 : this.r > 255 ? 255 : this.r, this.g = this.g < 0 || isNaN(this.g) ? 0 : this.g > 255 ? 255 : this.g, this.b = this.b < 0 || isNaN(this.b) ? 0 : this.b > 255 ? 255 : this.b, this.toRGB = function() {
    return "rgb(" + this.r + ", " + this.g + ", " + this.b + ")";
  }, this.toHex = function() {
    var l = this.r.toString(16), f = this.g.toString(16), c = this.b.toString(16);
    return l.length == 1 && (l = "0" + l), f.length == 1 && (f = "0" + f), c.length == 1 && (c = "0" + c), "#" + l + f + c;
  };
}
var Ls = $t.atob.bind($t), cc = $t.btoa.bind($t);
/**
* @license
* Joseph Myers does not specify a particular license for his work.
*
* Author: Joseph Myers
* Accessed from: http://www.myersdaily.org/joseph/javascript/md5.js
*
* Modified by: Owen Leong
*/
function zl(t3, n) {
  var e = t3[0], r = t3[1], i = t3[2], o = t3[3];
  e = Nn(e, r, i, o, n[0], 7, -680876936), o = Nn(o, e, r, i, n[1], 12, -389564586), i = Nn(i, o, e, r, n[2], 17, 606105819), r = Nn(r, i, o, e, n[3], 22, -1044525330), e = Nn(e, r, i, o, n[4], 7, -176418897), o = Nn(o, e, r, i, n[5], 12, 1200080426), i = Nn(i, o, e, r, n[6], 17, -1473231341), r = Nn(r, i, o, e, n[7], 22, -45705983), e = Nn(e, r, i, o, n[8], 7, 1770035416), o = Nn(o, e, r, i, n[9], 12, -1958414417), i = Nn(i, o, e, r, n[10], 17, -42063), r = Nn(r, i, o, e, n[11], 22, -1990404162), e = Nn(e, r, i, o, n[12], 7, 1804603682), o = Nn(o, e, r, i, n[13], 12, -40341101), i = Nn(i, o, e, r, n[14], 17, -1502002290), e = Sn(e, r = Nn(r, i, o, e, n[15], 22, 1236535329), i, o, n[1], 5, -165796510), o = Sn(o, e, r, i, n[6], 9, -1069501632), i = Sn(i, o, e, r, n[11], 14, 643717713), r = Sn(r, i, o, e, n[0], 20, -373897302), e = Sn(e, r, i, o, n[5], 5, -701558691), o = Sn(o, e, r, i, n[10], 9, 38016083), i = Sn(i, o, e, r, n[15], 14, -660478335), r = Sn(r, i, o, e, n[4], 20, -405537848), e = Sn(e, r, i, o, n[9], 5, 568446438), o = Sn(o, e, r, i, n[14], 9, -1019803690), i = Sn(i, o, e, r, n[3], 14, -187363961), r = Sn(r, i, o, e, n[8], 20, 1163531501), e = Sn(e, r, i, o, n[13], 5, -1444681467), o = Sn(o, e, r, i, n[2], 9, -51403784), i = Sn(i, o, e, r, n[7], 14, 1735328473), e = kn(e, r = Sn(r, i, o, e, n[12], 20, -1926607734), i, o, n[5], 4, -378558), o = kn(o, e, r, i, n[8], 11, -2022574463), i = kn(i, o, e, r, n[11], 16, 1839030562), r = kn(r, i, o, e, n[14], 23, -35309556), e = kn(e, r, i, o, n[1], 4, -1530992060), o = kn(o, e, r, i, n[4], 11, 1272893353), i = kn(i, o, e, r, n[7], 16, -155497632), r = kn(r, i, o, e, n[10], 23, -1094730640), e = kn(e, r, i, o, n[13], 4, 681279174), o = kn(o, e, r, i, n[0], 11, -358537222), i = kn(i, o, e, r, n[3], 16, -722521979), r = kn(r, i, o, e, n[6], 23, 76029189), e = kn(e, r, i, o, n[9], 4, -640364487), o = kn(o, e, r, i, n[12], 11, -421815835), i = kn(i, o, e, r, n[15], 16, 530742520), e = Pn(e, r = kn(r, i, o, e, n[2], 23, -995338651), i, o, n[0], 6, -198630844), o = Pn(o, e, r, i, n[7], 10, 1126891415), i = Pn(i, o, e, r, n[14], 15, -1416354905), r = Pn(r, i, o, e, n[5], 21, -57434055), e = Pn(e, r, i, o, n[12], 6, 1700485571), o = Pn(o, e, r, i, n[3], 10, -1894986606), i = Pn(i, o, e, r, n[10], 15, -1051523), r = Pn(r, i, o, e, n[1], 21, -2054922799), e = Pn(e, r, i, o, n[8], 6, 1873313359), o = Pn(o, e, r, i, n[15], 10, -30611744), i = Pn(i, o, e, r, n[6], 15, -1560198380), r = Pn(r, i, o, e, n[13], 21, 1309151649), e = Pn(e, r, i, o, n[4], 6, -145523070), o = Pn(o, e, r, i, n[11], 10, -1120210379), i = Pn(i, o, e, r, n[2], 15, 718787259), r = Pn(r, i, o, e, n[9], 21, -343485551), t3[0] = vi(e, t3[0]), t3[1] = vi(r, t3[1]), t3[2] = vi(i, t3[2]), t3[3] = vi(o, t3[3]);
}
function js(t3, n, e, r, i, o) {
  return n = vi(vi(n, t3), vi(r, o)), vi(n << i | n >>> 32 - i, e);
}
function Nn(t3, n, e, r, i, o, u) {
  return js(n & e | ~n & r, t3, n, i, o, u);
}
function Sn(t3, n, e, r, i, o, u) {
  return js(n & r | e & ~r, t3, n, i, o, u);
}
function kn(t3, n, e, r, i, o, u) {
  return js(n ^ e ^ r, t3, n, i, o, u);
}
function Pn(t3, n, e, r, i, o, u) {
  return js(e ^ (n | ~r), t3, n, i, o, u);
}
function Ff(t3) {
  var n, e = t3.length, r = [1732584193, -271733879, -1732584194, 271733878];
  for (n = 64; n <= t3.length; n += 64) zl(r, X5(t3.substring(n - 64, n)));
  t3 = t3.substring(n - 64);
  var i = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
  for (n = 0; n < t3.length; n++) i[n >> 2] |= t3.charCodeAt(n) << (n % 4 << 3);
  if (i[n >> 2] |= 128 << (n % 4 << 3), n > 55) for (zl(r, i), n = 0; n < 16; n++) i[n] = 0;
  return i[14] = 8 * e, zl(r, i), r;
}
function X5(t3) {
  var n, e = [];
  for (n = 0; n < 64; n += 4) e[n >> 2] = t3.charCodeAt(n) + (t3.charCodeAt(n + 1) << 8) + (t3.charCodeAt(n + 2) << 16) + (t3.charCodeAt(n + 3) << 24);
  return e;
}
var fc = "0123456789abcdef".split("");
function J5(t3) {
  for (var n = "", e = 0; e < 4; e++) n += fc[t3 >> 8 * e + 4 & 15] + fc[t3 >> 8 * e & 15];
  return n;
}
function Q5(t3) {
  return String.fromCharCode(255 & t3, (65280 & t3) >> 8, (16711680 & t3) >> 16, (4278190080 & t3) >> 24);
}
function sh(t3) {
  return Ff(t3).map(Q5).join("");
}
var td = (function(t3) {
  for (var n = 0; n < t3.length; n++) t3[n] = J5(t3[n]);
  return t3.join("");
})(Ff("hello")) != "5d41402abc4b2a76b9719d911017c592";
function vi(t3, n) {
  if (td) {
    var e = (65535 & t3) + (65535 & n);
    return (t3 >> 16) + (n >> 16) + (e >> 16) << 16 | 65535 & e;
  }
  return t3 + n & 4294967295;
}
/**
* @license
* FPDF is released under a permissive license: there is no usage restriction.
* You may embed it freely in your application (commercial or not), with or
* without modifications.
*
* Reference: http://www.fpdf.org/en/script/script37.php
*/
function lh(t3, n) {
  var e, r, i, o;
  if (t3 !== e) {
    for (var u = (i = t3, o = 1 + (256 / t3.length | 0), new Array(o + 1).join(i)), l = [], f = 0; f < 256; f++) l[f] = f;
    var c = 0;
    for (f = 0; f < 256; f++) {
      var p = l[f];
      c = (c + p + u.charCodeAt(f)) % 256, l[f] = l[c], l[c] = p;
    }
    e = t3, r = l;
  } else l = r;
  var x = n.length, L = 0, g = 0, O = "";
  for (f = 0; f < x; f++) g = (g + (p = l[L = (L + 1) % 256])) % 256, l[L] = l[g], l[g] = p, u = l[(l[L] + l[g]) % 256], O += String.fromCharCode(n.charCodeAt(f) ^ u);
  return O;
}
/**
* @license
* Licensed under the MIT License.
* http://opensource.org/licenses/mit-license
* Author: Owen Leong (@owenl131)
* Date: 15 Oct 2020
* References:
* https://www.cs.cmu.edu/~dst/Adobe/Gallery/anon21jul01-pdf-encryption.txt
* https://github.com/foliojs/pdfkit/blob/master/lib/security.js
* http://www.fpdf.org/en/script/script37.php
*/
var dc = { print: 4, modify: 8, copy: 16, "annot-forms": 32 };
function _a(t3, n, e, r) {
  this.v = 1, this.r = 2;
  var i = 192;
  t3.forEach(function(l) {
    if (dc.perm !== void 0) throw new Error("Invalid permission: " + l);
    i += dc[l];
  }), this.padding = "(¿N^NuAd\0NVÿú\b..\0¶Ðh>/\f©þdSiz";
  var o = (n + this.padding).substr(0, 32), u = (e + this.padding).substr(0, 32);
  this.O = this.processOwnerPassword(o, u), this.P = -(1 + (255 ^ i)), this.encryptionKey = sh(o + this.O + this.lsbFirstWord(this.P) + this.hexToBytes(r)).substr(0, 5), this.U = lh(this.encryptionKey, this.padding);
}
function ya(t3) {
  if (/[^\u0000-\u00ff]/.test(t3)) throw new Error("Invalid PDF Name Object: " + t3 + ", Only accept ASCII characters.");
  for (var n = "", e = t3.length, r = 0; r < e; r++) {
    var i = t3.charCodeAt(r);
    n += i < 33 || i === 35 || i === 37 || i === 40 || i === 41 || i === 47 || i === 60 || i === 62 || i === 91 || i === 93 || i === 123 || i === 125 || i > 126 ? "#" + ("0" + i.toString(16)).slice(-2) : t3[r];
  }
  return n;
}
function pc(t3) {
  if (Ce(t3) !== "object") throw new Error("Invalid Context passed to initialize PubSub (jsPDF-module)");
  var n = {};
  this.subscribe = function(e, r, i) {
    if (i = i || false, typeof e != "string" || typeof r != "function" || typeof i != "boolean") throw new Error("Invalid arguments passed to PubSub.subscribe (jsPDF-module)");
    n.hasOwnProperty(e) || (n[e] = {});
    var o = Math.random().toString(35);
    return n[e][o] = [r, !!i], o;
  }, this.unsubscribe = function(e) {
    for (var r in n) if (n[r][e]) return delete n[r][e], Object.keys(n[r]).length === 0 && delete n[r], true;
    return false;
  }, this.publish = function(e) {
    if (n.hasOwnProperty(e)) {
      var r = Array.prototype.slice.call(arguments, 1), i = [];
      for (var o in n[e]) {
        var u = n[e][o];
        try {
          u[0].apply(t3, r);
        } catch (l) {
          $t.console && Re.error("jsPDF PubSub Error", l.message, l);
        }
        u[1] && i.push(o);
      }
      i.length && i.forEach(this.unsubscribe);
    }
  }, this.getTopics = function() {
    return n;
  };
}
function Os(t3) {
  if (!(this instanceof Os)) return new Os(t3);
  var n = "opacity,stroke-opacity".split(",");
  for (var e in t3) t3.hasOwnProperty(e) && n.indexOf(e) >= 0 && (this[e] = t3[e]);
  this.id = "", this.objectNumber = -1;
}
function Of(t3, n) {
  this.gState = t3, this.matrix = n, this.id = "", this.objectNumber = -1;
}
function Zi(t3, n, e, r, i) {
  if (!(this instanceof Zi)) return new Zi(t3, n, e, r, i);
  this.type = t3 === "axial" ? 2 : 3, this.coords = n, this.colors = e, Of.call(this, r, i);
}
function xa(t3, n, e, r, i) {
  if (!(this instanceof xa)) return new xa(t3, n, e, r, i);
  this.boundingBox = t3, this.xStep = n, this.yStep = e, this.stream = "", this.cloneIndex = 0, Of.call(this, r, i);
}
function jt(t3) {
  var n, e = typeof arguments[0] == "string" ? arguments[0] : "p", r = arguments[1], i = arguments[2], o = arguments[3], u = [], l = 1, f = 16, c = "S", p = null;
  Ce(t3 = t3 || {}) === "object" && (e = t3.orientation, r = t3.unit || r, i = t3.format || i, o = t3.compress || t3.compressPdf || o, (p = t3.encryption || null) !== null && (p.userPassword = p.userPassword || "", p.ownerPassword = p.ownerPassword || "", p.userPermissions = p.userPermissions || []), l = typeof t3.userUnit == "number" ? Math.abs(t3.userUnit) : 1, t3.precision !== void 0 && (n = t3.precision), t3.floatPrecision !== void 0 && (f = t3.floatPrecision), c = t3.defaultPathOperation || "S"), u = t3.filters || (o === true ? ["FlateEncode"] : u), r = r || "mm", e = ("" + (e || "P")).toLowerCase();
  var x = t3.putOnlyUsedFonts || false, L = {}, g = { internal: {}, __private__: {} };
  g.__private__.PubSub = pc;
  var O = "1.3", P = g.__private__.getPdfVersion = function() {
    return O;
  };
  g.__private__.setPdfVersion = function(h) {
    O = h;
  };
  var M = { a0: [2383.94, 3370.39], a1: [1683.78, 2383.94], a2: [1190.55, 1683.78], a3: [841.89, 1190.55], a4: [595.28, 841.89], a5: [419.53, 595.28], a6: [297.64, 419.53], a7: [209.76, 297.64], a8: [147.4, 209.76], a9: [104.88, 147.4], a10: [73.7, 104.88], b0: [2834.65, 4008.19], b1: [2004.09, 2834.65], b2: [1417.32, 2004.09], b3: [1000.63, 1417.32], b4: [708.66, 1000.63], b5: [498.9, 708.66], b6: [354.33, 498.9], b7: [249.45, 354.33], b8: [175.75, 249.45], b9: [124.72, 175.75], b10: [87.87, 124.72], c0: [2599.37, 3676.54], c1: [1836.85, 2599.37], c2: [1298.27, 1836.85], c3: [918.43, 1298.27], c4: [649.13, 918.43], c5: [459.21, 649.13], c6: [323.15, 459.21], c7: [229.61, 323.15], c8: [161.57, 229.61], c9: [113.39, 161.57], c10: [79.37, 113.39], dl: [311.81, 623.62], letter: [612, 792], "government-letter": [576, 756], legal: [612, 1008], "junior-legal": [576, 360], ledger: [1224, 792], tabloid: [792, 1224], "credit-card": [153, 243] };
  g.__private__.getPageFormats = function() {
    return M;
  };
  var k = g.__private__.getPageFormat = function(h) {
    return M[h];
  };
  i = i || "a4";
  var V = "compat", G = "advanced", D = V;
  function it() {
    this.saveGraphicsState(), R(new Vt(Yt, 0, 0, -Yt, 0, Ti() * Yt).toString() + " cm"), this.setFontSize(this.getFontSize() / Yt), c = "n", D = G;
  }
  function bt() {
    this.restoreGraphicsState(), c = "S", D = V;
  }
  var dt = g.__private__.combineFontStyleAndFontWeight = function(h, v) {
    if (h == "bold" && v == "normal" || h == "bold" && v == 400 || h == "normal" && v == "italic" || h == "bold" && v == "italic") throw new Error("Invalid Combination of fontweight and fontstyle");
    return v && (h = v == 400 || v === "normal" ? h === "italic" ? "italic" : "normal" : v != 700 && v !== "bold" || h !== "normal" ? (v == 700 ? "bold" : v) + "" + h : "bold"), h;
  };
  g.advancedAPI = function(h) {
    var v = D === V;
    return v && it.call(this), typeof h != "function" || (h(this), v && bt.call(this)), this;
  }, g.compatAPI = function(h) {
    var v = D === G;
    return v && bt.call(this), typeof h != "function" || (h(this), v && it.call(this)), this;
  }, g.isAdvancedAPI = function() {
    return D === G;
  };
  var $, j = function(h) {
    if (D !== G) throw new Error(h + " is only available in 'advanced' API mode. You need to call advancedAPI() first.");
  }, J = g.roundToPrecision = g.__private__.roundToPrecision = function(h, v) {
    var F = n || v;
    if (isNaN(h) || isNaN(F)) throw new Error("Invalid argument passed to jsPDF.roundToPrecision");
    return h.toFixed(F).replace(/0+$/, "");
  };
  $ = g.hpf = g.__private__.hpf = typeof f == "number" ? function(h) {
    if (isNaN(h)) throw new Error("Invalid argument passed to jsPDF.hpf");
    return J(h, f);
  } : f === "smart" ? function(h) {
    if (isNaN(h)) throw new Error("Invalid argument passed to jsPDF.hpf");
    return J(h, h > -1 && h < 1 ? 16 : 5);
  } : function(h) {
    if (isNaN(h)) throw new Error("Invalid argument passed to jsPDF.hpf");
    return J(h, 16);
  };
  var N = g.f2 = g.__private__.f2 = function(h) {
    if (isNaN(h)) throw new Error("Invalid argument passed to jsPDF.f2");
    return J(h, 2);
  }, C = g.__private__.f3 = function(h) {
    if (isNaN(h)) throw new Error("Invalid argument passed to jsPDF.f3");
    return J(h, 3);
  }, z = g.scale = g.__private__.scale = function(h) {
    if (isNaN(h)) throw new Error("Invalid argument passed to jsPDF.scale");
    return D === V ? h * Yt : D === G ? h : void 0;
  }, q = function(h) {
    return z((function(v) {
      return D === V ? Ti() - v : D === G ? v : void 0;
    })(h));
  };
  g.__private__.setPrecision = g.setPrecision = function(h) {
    typeof parseInt(h, 10) == "number" && (n = parseInt(h, 10));
  };
  var rt, st = "00000000000000000000000000000000", ht = g.__private__.getFileId = function() {
    return st;
  }, tt = g.__private__.setFileId = function(h) {
    return st = h !== void 0 && /^[a-fA-F0-9]{32}$/.test(h) ? h.toUpperCase() : st.split("").map(function() {
      return "ABCDEF0123456789".charAt(Math.floor(16 * Math.random()));
    }).join(""), p !== null && ($e = new _a(p.userPermissions, p.userPassword, p.ownerPassword, st)), st;
  };
  g.setFileId = function(h) {
    return tt(h), this;
  }, g.getFileId = function() {
    return ht();
  };
  var ft = g.__private__.convertDateToPDFDate = function(h) {
    var v = h.getTimezoneOffset(), F = v < 0 ? "+" : "-", U = Math.floor(Math.abs(v / 60)), K = Math.abs(v % 60), gt = [F, B(U), "'", B(K), "'"].join("");
    return ["D:", h.getFullYear(), B(h.getMonth() + 1), B(h.getDate()), B(h.getHours()), B(h.getMinutes()), B(h.getSeconds()), gt].join("");
  }, Lt = g.__private__.convertPDFDateToDate = function(h) {
    var v = parseInt(h.substr(2, 4), 10), F = parseInt(h.substr(6, 2), 10) - 1, U = parseInt(h.substr(8, 2), 10), K = parseInt(h.substr(10, 2), 10), gt = parseInt(h.substr(12, 2), 10), _t = parseInt(h.substr(14, 2), 10);
    return new Date(v, F, U, K, gt, _t, 0);
  }, lt = g.__private__.setCreationDate = function(h) {
    var v;
    if (h === void 0 && (h = /* @__PURE__ */ new Date()), h instanceof Date) v = ft(h);
    else {
      if (!/^D:(20[0-2][0-9]|203[0-7]|19[7-9][0-9])(0[0-9]|1[0-2])([0-2][0-9]|3[0-1])(0[0-9]|1[0-9]|2[0-3])(0[0-9]|[1-5][0-9])(0[0-9]|[1-5][0-9])(\+0[0-9]|\+1[0-4]|-0[0-9]|-1[0-1])'(0[0-9]|[1-5][0-9])'?$/.test(h)) throw new Error("Invalid argument passed to jsPDF.setCreationDate");
      v = h;
    }
    return rt = v;
  }, _ = g.__private__.getCreationDate = function(h) {
    var v = rt;
    return h === "jsDate" && (v = Lt(rt)), v;
  };
  g.setCreationDate = function(h) {
    return lt(h), this;
  }, g.getCreationDate = function(h) {
    return _(h);
  };
  var T, B = g.__private__.padd2 = function(h) {
    return ("0" + parseInt(h)).slice(-2);
  }, H = g.__private__.padd2Hex = function(h) {
    return ("00" + (h = h.toString())).substr(h.length);
  }, Y = 0, nt = [], ot = [], at = 0, vt = [], xt = [], kt = false, Pt = ot;
  g.__private__.setCustomOutputDestination = function(h) {
    kt = true, Pt = h;
  };
  var ut = function(h) {
    kt || (Pt = h);
  };
  g.__private__.resetCustomOutputDestination = function() {
    kt = false, Pt = ot;
  };
  var R = g.__private__.out = function(h) {
    return h = h.toString(), at += h.length + 1, Pt.push(h), Pt;
  }, pe = g.__private__.write = function(h) {
    return R(arguments.length === 1 ? h.toString() : Array.prototype.join.call(arguments, " "));
  }, oe = g.__private__.getArrayBuffer = function(h) {
    for (var v = h.length, F = new ArrayBuffer(v), U = new Uint8Array(F); v--; ) U[v] = h.charCodeAt(v);
    return F;
  }, Ht = [["Helvetica", "helvetica", "normal", "WinAnsiEncoding"], ["Helvetica-Bold", "helvetica", "bold", "WinAnsiEncoding"], ["Helvetica-Oblique", "helvetica", "italic", "WinAnsiEncoding"], ["Helvetica-BoldOblique", "helvetica", "bolditalic", "WinAnsiEncoding"], ["Courier", "courier", "normal", "WinAnsiEncoding"], ["Courier-Bold", "courier", "bold", "WinAnsiEncoding"], ["Courier-Oblique", "courier", "italic", "WinAnsiEncoding"], ["Courier-BoldOblique", "courier", "bolditalic", "WinAnsiEncoding"], ["Times-Roman", "times", "normal", "WinAnsiEncoding"], ["Times-Bold", "times", "bold", "WinAnsiEncoding"], ["Times-Italic", "times", "italic", "WinAnsiEncoding"], ["Times-BoldItalic", "times", "bolditalic", "WinAnsiEncoding"], ["ZapfDingbats", "zapfdingbats", "normal", null], ["Symbol", "symbol", "normal", null]];
  g.__private__.getStandardFonts = function() {
    return Ht;
  };
  var At = t3.fontSize || 16;
  g.__private__.setFontSize = g.setFontSize = function(h) {
    return At = D === G ? h / Yt : h, this;
  };
  var Dt, St = g.__private__.getFontSize = g.getFontSize = function() {
    return D === V ? At : At * Yt;
  }, se = t3.R2L || false;
  g.__private__.setR2L = g.setR2L = function(h) {
    return se = h, this;
  }, g.__private__.getR2L = g.getR2L = function() {
    return se;
  };
  var zt, _e = g.__private__.setZoomMode = function(h) {
    if (/^(?:\d+\.\d*|\d*\.\d+|\d+)%$/.test(h)) Dt = h;
    else if (isNaN(h)) {
      if ([void 0, null, "fullwidth", "fullheight", "fullpage", "original"].indexOf(h) === -1) throw new Error('zoom must be Integer (e.g. 2), a percentage Value (e.g. 300%) or fullwidth, fullheight, fullpage, original. "' + h + '" is not recognized.');
      Dt = h;
    } else Dt = parseInt(h, 10);
  };
  g.__private__.getZoomMode = function() {
    return Dt;
  };
  var ee, ne = g.__private__.setPageMode = function(h) {
    if ([void 0, null, "UseNone", "UseOutlines", "UseThumbs", "FullScreen"].indexOf(h) == -1) throw new Error('Page mode must be one of UseNone, UseOutlines, UseThumbs, or FullScreen. "' + h + '" is not recognized.');
    zt = h;
  };
  g.__private__.getPageMode = function() {
    return zt;
  };
  var Ee = g.__private__.setLayoutMode = function(h) {
    if ([void 0, null, "continuous", "single", "twoleft", "tworight", "two"].indexOf(h) == -1) throw new Error('Layout mode must be one of continuous, single, twoleft, tworight. "' + h + '" is not recognized.');
    ee = h;
  };
  g.__private__.getLayoutMode = function() {
    return ee;
  }, g.__private__.setDisplayMode = g.setDisplayMode = function(h, v, F) {
    return _e(h), Ee(v), ne(F), this;
  };
  var le = { title: "", subject: "", author: "", keywords: "", creator: "" };
  g.__private__.getDocumentProperty = function(h) {
    if (Object.keys(le).indexOf(h) === -1) throw new Error("Invalid argument passed to jsPDF.getDocumentProperty");
    return le[h];
  }, g.__private__.getDocumentProperties = function() {
    return le;
  }, g.__private__.setDocumentProperties = g.setProperties = g.setDocumentProperties = function(h) {
    for (var v in le) le.hasOwnProperty(v) && h[v] && (le[v] = h[v]);
    return this;
  }, g.__private__.setDocumentProperty = function(h, v) {
    if (Object.keys(le).indexOf(h) === -1) throw new Error("Invalid arguments passed to jsPDF.setDocumentProperty");
    return le[h] = v;
  };
  var qt, Yt, Ut, Me, ye, Mt = {}, re = {}, Ie = [], Wt = {}, ge = {}, ie = {}, Ye = {}, sn = null, Fe = 0, Xt = [], Le = new pc(g), xi = t3.hotfixes || [], xn = {}, Fr = {}, br = [], Vt = function h(v, F, U, K, gt, _t) {
    if (!(this instanceof h)) return new h(v, F, U, K, gt, _t);
    isNaN(v) && (v = 1), isNaN(F) && (F = 0), isNaN(U) && (U = 0), isNaN(K) && (K = 1), isNaN(gt) && (gt = 0), isNaN(_t) && (_t = 0), this._matrix = [v, F, U, K, gt, _t];
  };
  Object.defineProperty(Vt.prototype, "sx", { get: function() {
    return this._matrix[0];
  }, set: function(h) {
    this._matrix[0] = h;
  } }), Object.defineProperty(Vt.prototype, "shy", { get: function() {
    return this._matrix[1];
  }, set: function(h) {
    this._matrix[1] = h;
  } }), Object.defineProperty(Vt.prototype, "shx", { get: function() {
    return this._matrix[2];
  }, set: function(h) {
    this._matrix[2] = h;
  } }), Object.defineProperty(Vt.prototype, "sy", { get: function() {
    return this._matrix[3];
  }, set: function(h) {
    this._matrix[3] = h;
  } }), Object.defineProperty(Vt.prototype, "tx", { get: function() {
    return this._matrix[4];
  }, set: function(h) {
    this._matrix[4] = h;
  } }), Object.defineProperty(Vt.prototype, "ty", { get: function() {
    return this._matrix[5];
  }, set: function(h) {
    this._matrix[5] = h;
  } }), Object.defineProperty(Vt.prototype, "a", { get: function() {
    return this._matrix[0];
  }, set: function(h) {
    this._matrix[0] = h;
  } }), Object.defineProperty(Vt.prototype, "b", { get: function() {
    return this._matrix[1];
  }, set: function(h) {
    this._matrix[1] = h;
  } }), Object.defineProperty(Vt.prototype, "c", { get: function() {
    return this._matrix[2];
  }, set: function(h) {
    this._matrix[2] = h;
  } }), Object.defineProperty(Vt.prototype, "d", { get: function() {
    return this._matrix[3];
  }, set: function(h) {
    this._matrix[3] = h;
  } }), Object.defineProperty(Vt.prototype, "e", { get: function() {
    return this._matrix[4];
  }, set: function(h) {
    this._matrix[4] = h;
  } }), Object.defineProperty(Vt.prototype, "f", { get: function() {
    return this._matrix[5];
  }, set: function(h) {
    this._matrix[5] = h;
  } }), Object.defineProperty(Vt.prototype, "rotation", { get: function() {
    return Math.atan2(this.shx, this.sx);
  } }), Object.defineProperty(Vt.prototype, "scaleX", { get: function() {
    return this.decompose().scale.sx;
  } }), Object.defineProperty(Vt.prototype, "scaleY", { get: function() {
    return this.decompose().scale.sy;
  } }), Object.defineProperty(Vt.prototype, "isIdentity", { get: function() {
    return this.sx === 1 && this.shy === 0 && this.shx === 0 && this.sy === 1 && this.tx === 0 && this.ty === 0;
  } }), Vt.prototype.join = function(h) {
    return [this.sx, this.shy, this.shx, this.sy, this.tx, this.ty].map($).join(h);
  }, Vt.prototype.multiply = function(h) {
    var v = h.sx * this.sx + h.shy * this.shx, F = h.sx * this.shy + h.shy * this.sy, U = h.shx * this.sx + h.sy * this.shx, K = h.shx * this.shy + h.sy * this.sy, gt = h.tx * this.sx + h.ty * this.shx + this.tx, _t = h.tx * this.shy + h.ty * this.sy + this.ty;
    return new Vt(v, F, U, K, gt, _t);
  }, Vt.prototype.decompose = function() {
    var h = this.sx, v = this.shy, F = this.shx, U = this.sy, K = this.tx, gt = this.ty, _t = Math.sqrt(h * h + v * v), It = (h /= _t) * F + (v /= _t) * U;
    F -= h * It, U -= v * It;
    var Rt = Math.sqrt(F * F + U * U);
    return It /= Rt, h * (U /= Rt) < v * (F /= Rt) && (h = -h, v = -v, It = -It, _t = -_t), { scale: new Vt(_t, 0, 0, Rt, 0, 0), translate: new Vt(1, 0, 0, 1, K, gt), rotate: new Vt(h, v, -v, h, 0, 0), skew: new Vt(1, 0, It, 1, 0, 0) };
  }, Vt.prototype.toString = function(h) {
    return this.join(" ");
  }, Vt.prototype.inversed = function() {
    var h = this.sx, v = this.shy, F = this.shx, U = this.sy, K = this.tx, gt = this.ty, _t = 1 / (h * U - v * F), It = U * _t, Rt = -v * _t, Kt = -F * _t, Qt = h * _t;
    return new Vt(It, Rt, Kt, Qt, -It * K - Kt * gt, -Rt * K - Qt * gt);
  }, Vt.prototype.applyToPoint = function(h) {
    var v = h.x * this.sx + h.y * this.shx + this.tx, F = h.x * this.shy + h.y * this.sy + this.ty;
    return new Fi(v, F);
  }, Vt.prototype.applyToRectangle = function(h) {
    var v = this.applyToPoint(h), F = this.applyToPoint(new Fi(h.x + h.w, h.y + h.h));
    return new Wa(v.x, v.y, F.x - v.x, F.y - v.y);
  }, Vt.prototype.clone = function() {
    var h = this.sx, v = this.shy, F = this.shx, U = this.sy, K = this.tx, gt = this.ty;
    return new Vt(h, v, F, U, K, gt);
  }, g.Matrix = Vt;
  var Or = g.matrixMult = function(h, v) {
    return v.multiply(h);
  }, Tr = new Vt(1, 0, 0, 1, 0, 0);
  g.unitMatrix = g.identityMatrix = Tr;
  var Kn = function(h, v) {
    if (!ge[h]) {
      var F = (v instanceof Zi ? "Sh" : "P") + (Object.keys(Wt).length + 1).toString(10);
      v.id = F, ge[h] = F, Wt[F] = v, Le.publish("addPattern", v);
    }
  };
  g.ShadingPattern = Zi, g.TilingPattern = xa, g.addShadingPattern = function(h, v) {
    return j("addShadingPattern()"), Kn(h, v), this;
  }, g.beginTilingPattern = function(h) {
    j("beginTilingPattern()"), Va(h.boundingBox[0], h.boundingBox[1], h.boundingBox[2] - h.boundingBox[0], h.boundingBox[3] - h.boundingBox[1], h.matrix);
  }, g.endTilingPattern = function(h, v) {
    j("endTilingPattern()"), v.stream = xt[T].join(`
`), Kn(h, v), Le.publish("endTilingPattern", v), br.pop().restore();
  };
  var Xn, He = g.__private__.newObject = function() {
    var h = dn();
    return mn(h, true), h;
  }, dn = g.__private__.newObjectDeferred = function() {
    return Y++, nt[Y] = function() {
      return at;
    }, Y;
  }, mn = function(h, v) {
    return v = typeof v == "boolean" && v, nt[h] = at, v && R(h + " 0 obj"), h;
  }, Ai = g.__private__.newAdditionalObject = function() {
    var h = { objId: dn(), content: "" };
    return vt.push(h), h;
  }, Kr = dn(), sr = dn(), wr = g.__private__.decodeColorString = function(h) {
    var v = h.split(" ");
    if (v.length !== 2 || v[1] !== "g" && v[1] !== "G") v.length !== 5 || v[4] !== "k" && v[4] !== "K" || (v = [(1 - v[0]) * (1 - v[3]), (1 - v[1]) * (1 - v[3]), (1 - v[2]) * (1 - v[3]), "r"]);
    else {
      var F = parseFloat(v[0]);
      v = [F, F, F, "r"];
    }
    for (var U = "#", K = 0; K < 3; K++) U += ("0" + Math.floor(255 * parseFloat(v[K])).toString(16)).slice(-2);
    return U;
  }, lr = g.__private__.encodeColorString = function(h) {
    var v;
    typeof h == "string" && (h = { ch1: h });
    var F = h.ch1, U = h.ch2, K = h.ch3, gt = h.ch4, _t = h.pdfColorType === "draw" ? ["G", "RG", "K"] : ["g", "rg", "k"];
    if (typeof F == "string" && F.charAt(0) !== "#") {
      var It = new If(F);
      if (It.ok) F = It.toHex();
      else if (!/^\d*\.?\d*$/.test(F)) throw new Error('Invalid color "' + F + '" passed to jsPDF.encodeColorString.');
    }
    if (typeof F == "string" && /^#[0-9A-Fa-f]{3}$/.test(F) && (F = "#" + F[1] + F[1] + F[2] + F[2] + F[3] + F[3]), typeof F == "string" && /^#[0-9A-Fa-f]{6}$/.test(F)) {
      var Rt = parseInt(F.substr(1), 16);
      F = Rt >> 16 & 255, U = Rt >> 8 & 255, K = 255 & Rt;
    }
    if (U === void 0 || gt === void 0 && F === U && U === K) v = typeof F == "string" ? F + " " + _t[0] : h.precision === 2 ? N(F / 255) + " " + _t[0] : C(F / 255) + " " + _t[0];
    else if (gt === void 0 || Ce(gt) === "object") {
      if (gt && !isNaN(gt.a) && gt.a === 0) return ["1.", "1.", "1.", _t[1]].join(" ");
      v = typeof F == "string" ? [F, U, K, _t[1]].join(" ") : h.precision === 2 ? [N(F / 255), N(U / 255), N(K / 255), _t[1]].join(" ") : [C(F / 255), C(U / 255), C(K / 255), _t[1]].join(" ");
    } else v = typeof F == "string" ? [F, U, K, gt, _t[2]].join(" ") : h.precision === 2 ? [N(F), N(U), N(K), N(gt), _t[2]].join(" ") : [C(F), C(U), C(K), C(gt), _t[2]].join(" ");
    return v;
  }, hr = g.__private__.getFilters = function() {
    return u;
  }, Jn = g.__private__.putStream = function(h) {
    var v = (h = h || {}).data || "", F = h.filters || hr(), U = h.alreadyAppliedFilters || [], K = h.addLength1 || false, gt = v.length, _t = h.objectId, It = function(ln) {
      return ln;
    };
    if (p !== null && _t === void 0) throw new Error("ObjectId must be passed to putStream for file encryption");
    p !== null && (It = $e.encryptor(_t, 0));
    var Rt = {};
    F === true && (F = ["FlateEncode"]);
    var Kt = h.additionalKeyValues || [], Qt = (Rt = jt.API.processDataByFilters !== void 0 ? jt.API.processDataByFilters(v, F) : { data: v, reverseChain: [] }).reverseChain + (Array.isArray(U) ? U.join(" ") : U.toString());
    if (Rt.data.length !== 0 && (Kt.push({ key: "Length", value: Rt.data.length }), K === true && Kt.push({ key: "Length1", value: gt })), Qt.length != 0) if (Qt.split("/").length - 1 == 1) Kt.push({ key: "Filter", value: Qt });
    else {
      Kt.push({ key: "Filter", value: "[" + Qt + "]" });
      for (var xe = 0; xe < Kt.length; xe += 1) if (Kt[xe].key === "DecodeParms") {
        for (var ze = [], an = 0; an < Rt.reverseChain.split("/").length - 1; an += 1) ze.push("null");
        ze.push(Kt[xe].value), Kt[xe].value = "[" + ze.join(" ") + "]";
      }
    }
    R("<<");
    for (var Be = 0; Be < Kt.length; Be++) R("/" + Kt[Be].key + " " + Kt[Be].value);
    R(">>"), Rt.data.length !== 0 && (R("stream"), R(It(Rt.data)), R("endstream"));
  }, Li = g.__private__.putPage = function(h) {
    var v = h.number, F = h.data, U = h.objId, K = h.contentsObjId;
    mn(U, true), R("<</Type /Page"), R("/Parent " + h.rootDictionaryObjId + " 0 R"), R("/Resources " + h.resourceDictionaryObjId + " 0 R"), R("/MediaBox [" + parseFloat($(h.mediaBox.bottomLeftX)) + " " + parseFloat($(h.mediaBox.bottomLeftY)) + " " + $(h.mediaBox.topRightX) + " " + $(h.mediaBox.topRightY) + "]"), h.cropBox !== null && R("/CropBox [" + $(h.cropBox.bottomLeftX) + " " + $(h.cropBox.bottomLeftY) + " " + $(h.cropBox.topRightX) + " " + $(h.cropBox.topRightY) + "]"), h.bleedBox !== null && R("/BleedBox [" + $(h.bleedBox.bottomLeftX) + " " + $(h.bleedBox.bottomLeftY) + " " + $(h.bleedBox.topRightX) + " " + $(h.bleedBox.topRightY) + "]"), h.trimBox !== null && R("/TrimBox [" + $(h.trimBox.bottomLeftX) + " " + $(h.trimBox.bottomLeftY) + " " + $(h.trimBox.topRightX) + " " + $(h.trimBox.topRightY) + "]"), h.artBox !== null && R("/ArtBox [" + $(h.artBox.bottomLeftX) + " " + $(h.artBox.bottomLeftY) + " " + $(h.artBox.topRightX) + " " + $(h.artBox.topRightY) + "]"), typeof h.userUnit == "number" && h.userUnit !== 1 && R("/UserUnit " + h.userUnit), Le.publish("putPage", { objId: U, pageContext: Xt[v], pageNumber: v, page: F }), R("/Contents " + K + " 0 R"), R(">>"), R("endobj");
    var gt = F.join(`
`);
    return D === G && (gt += `
Q`), mn(K, true), Jn({ data: gt, filters: hr(), objectId: K }), R("endobj"), U;
  }, _r = g.__private__.putPages = function() {
    var h, v, F = [];
    for (h = 1; h <= Fe; h++) Xt[h].objId = dn(), Xt[h].contentsObjId = dn();
    for (h = 1; h <= Fe; h++) F.push(Li({ number: h, data: xt[h], objId: Xt[h].objId, contentsObjId: Xt[h].contentsObjId, mediaBox: Xt[h].mediaBox, cropBox: Xt[h].cropBox, bleedBox: Xt[h].bleedBox, trimBox: Xt[h].trimBox, artBox: Xt[h].artBox, userUnit: Xt[h].userUnit, rootDictionaryObjId: Kr, resourceDictionaryObjId: sr }));
    mn(Kr, true), R("<</Type /Pages");
    var U = "/Kids [";
    for (v = 0; v < Fe; v++) U += F[v] + " 0 R ";
    R(U + "]"), R("/Count " + Fe), R(">>"), R("endobj"), Le.publish("postPutPages");
  }, Ni = function(h) {
    Le.publish("putFont", { font: h, out: R, newObject: He, putStream: Jn }), h.isAlreadyPutted !== true && (h.objectNumber = He(), R("<<"), R("/Type /Font"), R("/BaseFont /" + ya(h.postScriptName)), R("/Subtype /Type1"), typeof h.encoding == "string" && R("/Encoding /" + h.encoding), R("/FirstChar 32"), R("/LastChar 255"), R(">>"), R("endobj"));
  }, ra = function(h) {
    h.objectNumber = He();
    var v = [];
    v.push({ key: "Type", value: "/XObject" }), v.push({ key: "Subtype", value: "/Form" }), v.push({ key: "BBox", value: "[" + [$(h.x), $(h.y), $(h.x + h.width), $(h.y + h.height)].join(" ") + "]" }), v.push({ key: "Matrix", value: "[" + h.matrix.toString() + "]" });
    var F = h.pages[1].join(`
`);
    Jn({ data: F, additionalKeyValues: v, objectId: h.objectNumber }), R("endobj");
  }, ia = function(h, v) {
    v || (v = 21);
    var F = He(), U = (function(_t, It) {
      var Rt, Kt = [], Qt = 1 / (It - 1);
      for (Rt = 0; Rt < 1; Rt += Qt) Kt.push(Rt);
      if (Kt.push(1), _t[0].offset != 0) {
        var xe = { offset: 0, color: _t[0].color };
        _t.unshift(xe);
      }
      if (_t[_t.length - 1].offset != 1) {
        var ze = { offset: 1, color: _t[_t.length - 1].color };
        _t.push(ze);
      }
      for (var an = "", Be = 0, ln = 0; ln < Kt.length; ln++) {
        for (Rt = Kt[ln]; Rt > _t[Be + 1].offset; ) Be++;
        var on = _t[Be].offset, vn = (Rt - on) / (_t[Be + 1].offset - on), tr = _t[Be].color, On = _t[Be + 1].color;
        an += H(Math.round((1 - vn) * tr[0] + vn * On[0]).toString(16)) + H(Math.round((1 - vn) * tr[1] + vn * On[1]).toString(16)) + H(Math.round((1 - vn) * tr[2] + vn * On[2]).toString(16));
      }
      return an.trim();
    })(h.colors, v), K = [];
    K.push({ key: "FunctionType", value: "0" }), K.push({ key: "Domain", value: "[0.0 1.0]" }), K.push({ key: "Size", value: "[" + v + "]" }), K.push({ key: "BitsPerSample", value: "8" }), K.push({ key: "Range", value: "[0.0 1.0 0.0 1.0 0.0 1.0]" }), K.push({ key: "Decode", value: "[0.0 1.0 0.0 1.0 0.0 1.0]" }), Jn({ data: U, additionalKeyValues: K, alreadyAppliedFilters: ["/ASCIIHexDecode"], objectId: F }), R("endobj"), h.objectNumber = He(), R("<< /ShadingType " + h.type), R("/ColorSpace /DeviceRGB");
    var gt = "/Coords [" + $(parseFloat(h.coords[0])) + " " + $(parseFloat(h.coords[1])) + " ";
    h.type === 2 ? gt += $(parseFloat(h.coords[2])) + " " + $(parseFloat(h.coords[3])) : gt += $(parseFloat(h.coords[2])) + " " + $(parseFloat(h.coords[3])) + " " + $(parseFloat(h.coords[4])) + " " + $(parseFloat(h.coords[5])), R(gt += "]"), h.matrix && R("/Matrix [" + h.matrix.toString() + "]"), R("/Function " + F + " 0 R"), R("/Extend [true true]"), R(">>"), R("endobj");
  }, aa = function(h, v) {
    var F = dn(), U = He();
    v.push({ resourcesOid: F, objectOid: U }), h.objectNumber = U;
    var K = [];
    K.push({ key: "Type", value: "/Pattern" }), K.push({ key: "PatternType", value: "1" }), K.push({ key: "PaintType", value: "1" }), K.push({ key: "TilingType", value: "1" }), K.push({ key: "BBox", value: "[" + h.boundingBox.map($).join(" ") + "]" }), K.push({ key: "XStep", value: $(h.xStep) }), K.push({ key: "YStep", value: $(h.yStep) }), K.push({ key: "Resources", value: F + " 0 R" }), h.matrix && K.push({ key: "Matrix", value: "[" + h.matrix.toString() + "]" }), Jn({ data: h.stream, additionalKeyValues: K, objectId: h.objectNumber }), R("endobj");
  }, Ds = function(h) {
    for (var v in h.objectNumber = He(), R("<<"), h) switch (v) {
      case "opacity":
        R("/ca " + N(h[v]));
        break;
      case "stroke-opacity":
        R("/CA " + N(h[v]));
    }
    R(">>"), R("endobj");
  }, Ta = function(h) {
    mn(h.resourcesOid, true), R("<<"), R("/ProcSet [/PDF /Text /ImageB /ImageC /ImageI]"), (function() {
      for (var v in R("/Font <<"), Mt) Mt.hasOwnProperty(v) && (x === false || x === true && L.hasOwnProperty(v)) && R("/" + v + " " + Mt[v].objectNumber + " 0 R");
      R(">>");
    })(), (function() {
      if (Object.keys(Wt).length > 0) {
        for (var v in R("/Shading <<"), Wt) Wt.hasOwnProperty(v) && Wt[v] instanceof Zi && Wt[v].objectNumber >= 0 && R("/" + v + " " + Wt[v].objectNumber + " 0 R");
        Le.publish("putShadingPatternDict"), R(">>");
      }
    })(), (function(v) {
      if (Object.keys(Wt).length > 0) {
        for (var F in R("/Pattern <<"), Wt) Wt.hasOwnProperty(F) && Wt[F] instanceof g.TilingPattern && Wt[F].objectNumber >= 0 && Wt[F].objectNumber < v && R("/" + F + " " + Wt[F].objectNumber + " 0 R");
        Le.publish("putTilingPatternDict"), R(">>");
      }
    })(h.objectOid), (function() {
      if (Object.keys(ie).length > 0) {
        var v;
        for (v in R("/ExtGState <<"), ie) ie.hasOwnProperty(v) && ie[v].objectNumber >= 0 && R("/" + v + " " + ie[v].objectNumber + " 0 R");
        Le.publish("putGStateDict"), R(">>");
      }
    })(), (function() {
      for (var v in R("/XObject <<"), xn) xn.hasOwnProperty(v) && xn[v].objectNumber >= 0 && R("/" + v + " " + xn[v].objectNumber + " 0 R");
      Le.publish("putXobjectDict"), R(">>");
    })(), R(">>"), R("endobj");
  }, Eo = function(h) {
    re[h.fontName] = re[h.fontName] || {}, re[h.fontName][h.fontStyle] = h.id;
  }, Io = function(h, v, F, U, K) {
    var gt = { id: "F" + (Object.keys(Mt).length + 1).toString(10), postScriptName: h, fontName: v, fontStyle: F, encoding: U, isStandardFont: K || false, metadata: {} };
    return Le.publish("addFont", { font: gt, instance: this }), Mt[gt.id] = gt, Eo(gt), gt.id;
  }, Qn = g.__private__.pdfEscape = g.pdfEscape = function(h, v) {
    return (function(F, U) {
      var K, gt, _t, It, Rt, Kt, Qt, xe, ze;
      if (_t = (U = U || {}).sourceEncoding || "Unicode", Rt = U.outputEncoding, (U.autoencode || Rt) && Mt[qt].metadata && Mt[qt].metadata[_t] && Mt[qt].metadata[_t].encoding && (It = Mt[qt].metadata[_t].encoding, !Rt && Mt[qt].encoding && (Rt = Mt[qt].encoding), !Rt && It.codePages && (Rt = It.codePages[0]), typeof Rt == "string" && (Rt = It[Rt]), Rt)) {
        for (Qt = false, Kt = [], K = 0, gt = F.length; K < gt; K++) (xe = Rt[F.charCodeAt(K)]) ? Kt.push(String.fromCharCode(xe)) : Kt.push(F[K]), Kt[K].charCodeAt(0) >> 8 && (Qt = true);
        F = Kt.join("");
      }
      for (K = F.length; Qt === void 0 && K !== 0; ) F.charCodeAt(K - 1) >> 8 && (Qt = true), K--;
      if (!Qt) return F;
      for (Kt = U.noBOM ? [] : [254, 255], K = 0, gt = F.length; K < gt; K++) {
        if ((ze = (xe = F.charCodeAt(K)) >> 8) >> 8) throw new Error("Character at position " + K + " of string '" + F + "' exceeds 16bits. Cannot be encoded into UCS-2 BE");
        Kt.push(ze), Kt.push(xe - (ze << 8));
      }
      return String.fromCharCode.apply(void 0, Kt);
    })(h, v).replace(/\\/g, "\\\\").replace(/\(/g, "\\(").replace(/\)/g, "\\)");
  }, Ra = g.__private__.beginPage = function(h) {
    xt[++Fe] = [], Xt[Fe] = { objId: 0, contentsObjId: 0, userUnit: Number(l), artBox: null, bleedBox: null, cropBox: null, trimBox: null, mediaBox: { bottomLeftX: 0, bottomLeftY: 0, topRightX: Number(h[0]), topRightY: Number(h[1]) } }, Oo(Fe), ut(xt[T]);
  }, Fo = function(h, v) {
    var F, U, K;
    switch (e = v || e, typeof h == "string" && (F = k(h.toLowerCase()), Array.isArray(F) && (U = F[0], K = F[1])), Array.isArray(h) && (U = h[0] * Yt, K = h[1] * Yt), isNaN(U) && (U = i[0], K = i[1]), (U > 14400 || K > 14400) && (Re.warn("A page in a PDF can not be wider or taller than 14400 userUnit. jsPDF limits the width/height to 14400"), U = Math.min(14400, U), K = Math.min(14400, K)), i = [U, K], e.substr(0, 1)) {
      case "l":
        K > U && (i = [K, U]);
        break;
      case "p":
        U > K && (i = [K, U]);
    }
    Ra(i), Ys(qa), R(sa), za !== 0 && R(za + " J"), Ha !== 0 && R(Ha + " j"), Le.publish("addPage", { pageNumber: Fe });
  }, Ma = function(h) {
    h > 0 && h <= Fe && (xt.splice(h, 1), Xt.splice(h, 1), Fe--, T > Fe && (T = Fe), this.setPage(T));
  }, Oo = function(h) {
    h > 0 && h <= Fe && (T = h);
  }, To = g.__private__.getNumberOfPages = g.getNumberOfPages = function() {
    return xt.length - 1;
  }, Ro = function(h, v, F) {
    var U, K = void 0;
    return F = F || {}, h = h !== void 0 ? h : Mt[qt].fontName, v = v !== void 0 ? v : Mt[qt].fontStyle, U = h.toLowerCase(), re[U] !== void 0 && re[U][v] !== void 0 ? K = re[U][v] : re[h] !== void 0 && re[h][v] !== void 0 ? K = re[h][v] : F.disableWarning === false && Re.warn("Unable to look up font label for font '" + h + "', '" + v + "'. Refer to getFontList() for available fonts."), K || F.noFallback || (K = re.times[v]) == null && (K = re.times.normal), K;
  }, oa = g.__private__.putInfo = function() {
    var h = He(), v = function(U) {
      return U;
    };
    for (var F in p !== null && (v = $e.encryptor(h, 0)), R("<<"), R("/Producer (" + Qn(v("jsPDF " + jt.version)) + ")"), le) le.hasOwnProperty(F) && le[F] && R("/" + F.substr(0, 1).toUpperCase() + F.substr(1) + " (" + Qn(v(le[F])) + ")");
    R("/CreationDate (" + Qn(v(rt)) + ")"), R(">>"), R("endobj");
  }, qs = g.__private__.putCatalog = function(h) {
    var v = (h = h || {}).rootDictionaryObjId || Kr;
    switch (He(), R("<<"), R("/Type /Catalog"), R("/Pages " + v + " 0 R"), Dt || (Dt = "fullwidth"), Dt) {
      case "fullwidth":
        R("/OpenAction [3 0 R /FitH null]");
        break;
      case "fullheight":
        R("/OpenAction [3 0 R /FitV null]");
        break;
      case "fullpage":
        R("/OpenAction [3 0 R /Fit]");
        break;
      case "original":
        R("/OpenAction [3 0 R /XYZ null null 1]");
        break;
      default:
        var F = "" + Dt;
        F.substr(F.length - 1) === "%" && (Dt = parseInt(Dt) / 100), typeof Dt == "number" && R("/OpenAction [3 0 R /XYZ null null " + N(Dt) + "]");
    }
    switch (ee || (ee = "continuous"), ee) {
      case "continuous":
        R("/PageLayout /OneColumn");
        break;
      case "single":
        R("/PageLayout /SinglePage");
        break;
      case "two":
      case "twoleft":
        R("/PageLayout /TwoColumnLeft");
        break;
      case "tworight":
        R("/PageLayout /TwoColumnRight");
    }
    zt && R("/PageMode /" + zt), Le.publish("putCatalog"), R(">>"), R("endobj");
  }, rn = g.__private__.putTrailer = function() {
    R("trailer"), R("<<"), R("/Size " + (Y + 1)), R("/Root " + Y + " 0 R"), R("/Info " + (Y - 1) + " 0 R"), p !== null && R("/Encrypt " + $e.oid + " 0 R"), R("/ID [ <" + st + "> <" + st + "> ]"), R(">>");
  }, Mo = g.__private__.putHeader = function() {
    R("%PDF-" + O), R("%ºß¬à");
  }, Bo = g.__private__.putXRef = function() {
    var h = "0000000000";
    R("xref"), R("0 " + (Y + 1)), R("0000000000 65535 f ");
    for (var v = 1; v <= Y; v++) typeof nt[v] == "function" ? R((h + nt[v]()).slice(-10) + " 00000 n ") : nt[v] !== void 0 ? R((h + nt[v]).slice(-10) + " 00000 n ") : R("0000000000 00000 n ");
  }, Rr = g.__private__.buildDocument = function() {
    var h;
    Y = 0, at = 0, ot = [], nt = [], vt = [], Kr = dn(), sr = dn(), ut(ot), Le.publish("buildDocument"), Mo(), _r(), (function() {
      Le.publish("putAdditionalObjects");
      for (var F = 0; F < vt.length; F++) {
        var U = vt[F];
        mn(U.objId, true), R(U.content), R("endobj");
      }
      Le.publish("postPutAdditionalObjects");
    })(), h = [], (function() {
      for (var F in Mt) Mt.hasOwnProperty(F) && (x === false || x === true && L.hasOwnProperty(F)) && Ni(Mt[F]);
    })(), (function() {
      var F;
      for (F in ie) ie.hasOwnProperty(F) && Ds(ie[F]);
    })(), (function() {
      for (var F in xn) xn.hasOwnProperty(F) && ra(xn[F]);
    })(), (function(F) {
      var U;
      for (U in Wt) Wt.hasOwnProperty(U) && (Wt[U] instanceof Zi ? ia(Wt[U]) : Wt[U] instanceof xa && aa(Wt[U], F));
    })(h), Le.publish("putResources"), h.forEach(Ta), Ta({ resourcesOid: sr, objectOid: Number.MAX_SAFE_INTEGER }), Le.publish("postPutResources"), p !== null && ($e.oid = He(), R("<<"), R("/Filter /Standard"), R("/V " + $e.v), R("/R " + $e.r), R("/U <" + $e.toHexString($e.U) + ">"), R("/O <" + $e.toHexString($e.O) + ">"), R("/P " + $e.P), R(">>"), R("endobj")), oa(), qs();
    var v = at;
    return Bo(), rn(), R("startxref"), R("" + v), R("%%EOF"), ut(xt[T]), ot.join(`
`);
  }, Si = g.__private__.getBlob = function(h) {
    return new Blob([oe(h)], { type: "application/pdf" });
  }, ur = g.output = g.__private__.output = (Xn = function(h, v) {
    switch (typeof (v = v || {}) == "string" ? v = { filename: v } : v.filename = v.filename || "generated.pdf", h) {
      case void 0:
        return Rr();
      case "save":
        g.save(v.filename);
        break;
      case "arraybuffer":
        return oe(Rr());
      case "blob":
        return Si(Rr());
      case "bloburi":
      case "bloburl":
        if ($t.URL !== void 0 && typeof $t.URL.createObjectURL == "function") return $t.URL && $t.URL.createObjectURL(Si(Rr())) || void 0;
        Re.warn("bloburl is not supported by your system, because URL.createObjectURL is not supported by your browser.");
        break;
      case "datauristring":
      case "dataurlstring":
        var F = "", U = Rr();
        try {
          F = cc(U);
        } catch {
          F = cc(unescape(encodeURIComponent(U)));
        }
        return "data:application/pdf;filename=" + v.filename + ";base64," + F;
      case "pdfobjectnewwindow":
        if (Object.prototype.toString.call($t) === "[object Window]") {
          var K = "https://cdnjs.cloudflare.com/ajax/libs/pdfobject/2.1.1/pdfobject.min.js", gt = ' integrity="sha512-4ze/a9/4jqu+tX9dfOqJYSvyYd5M6qum/3HpCLr+/Jqf0whc37VUbkpNGHR7/8pSnCFw47T1fmIpwBV7UySh3g==" crossorigin="anonymous"';
          v.pdfObjectUrl && (K = v.pdfObjectUrl, gt = "");
          var _t = '<html><style>html, body { padding: 0; margin: 0; } iframe { width: 100%; height: 100%; border: 0;}  </style><body><script src="' + K + '"' + gt + '><\/script><script >PDFObject.embed("' + this.output("dataurlstring") + '", ' + JSON.stringify(v) + ");<\/script></body></html>", It = $t.open();
          return It !== null && It.document.write(_t), It;
        }
        throw new Error("The option pdfobjectnewwindow just works in a browser-environment.");
      case "pdfjsnewwindow":
        if (Object.prototype.toString.call($t) === "[object Window]") {
          var Rt = '<html><style>html, body { padding: 0; margin: 0; } iframe { width: 100%; height: 100%; border: 0;}  </style><body><iframe id="pdfViewer" src="' + (v.pdfJsUrl || "examples/PDF.js/web/viewer.html") + "?file=&downloadName=" + v.filename + '" width="500px" height="400px" /></body></html>', Kt = $t.open();
          if (Kt !== null) {
            Kt.document.write(Rt);
            var Qt = this;
            Kt.document.documentElement.querySelector("#pdfViewer").onload = function() {
              Kt.document.title = v.filename, Kt.document.documentElement.querySelector("#pdfViewer").contentWindow.PDFViewerApplication.open(Qt.output("bloburl"));
            };
          }
          return Kt;
        }
        throw new Error("The option pdfjsnewwindow just works in a browser-environment.");
      case "dataurlnewwindow":
        if (Object.prototype.toString.call($t) !== "[object Window]") throw new Error("The option dataurlnewwindow just works in a browser-environment.");
        var xe = '<html><style>html, body { padding: 0; margin: 0; } iframe { width: 100%; height: 100%; border: 0;}  </style><body><iframe src="' + this.output("datauristring", v) + '"></iframe></body></html>', ze = $t.open();
        if (ze !== null && (ze.document.write(xe), ze.document.title = v.filename), ze || typeof safari > "u") return ze;
        break;
      case "datauri":
      case "dataurl":
        return $t.document.location.href = this.output("datauristring", v);
      default:
        return null;
    }
  }, Xn.foo = function() {
    try {
      return Xn.apply(this, arguments);
    } catch (F) {
      var h = F.stack || "";
      ~h.indexOf(" at ") && (h = h.split(" at ")[1]);
      var v = "Error in function " + h.split(`
`)[0].split("<")[0] + ": " + F.message;
      if (!$t.console) throw new Error(v);
      $t.console.error(v, F), $t.alert && alert(v);
    }
  }, Xn.foo.bar = Xn, Xn.foo), ki = function(h) {
    return Array.isArray(xi) === true && xi.indexOf(h) > -1;
  };
  switch (r) {
    case "pt":
      Yt = 1;
      break;
    case "mm":
      Yt = 72 / 25.4;
      break;
    case "cm":
      Yt = 72 / 2.54;
      break;
    case "in":
      Yt = 72;
      break;
    case "px":
      Yt = ki("px_scaling") == 1 ? 0.75 : 96 / 72;
      break;
    case "pc":
    case "em":
      Yt = 12;
      break;
    case "ex":
      Yt = 6;
      break;
    default:
      if (typeof r != "number") throw new Error("Invalid unit: " + r);
      Yt = r;
  }
  var $e = null;
  lt(), tt();
  var Ba = g.__private__.getPageInfo = g.getPageInfo = function(h) {
    if (isNaN(h) || h % 1 != 0) throw new Error("Invalid argument passed to jsPDF.getPageInfo");
    return { objId: Xt[h].objId, pageNumber: h, pageContext: Xt[h] };
  }, Us = g.__private__.getPageInfoByObjId = function(h) {
    if (isNaN(h) || h % 1 != 0) throw new Error("Invalid argument passed to jsPDF.getPageInfoByObjId");
    for (var v in Xt) if (Xt[v].objId === h) break;
    return Ba(v);
  }, zs = g.__private__.getCurrentPageInfo = g.getCurrentPageInfo = function() {
    return { objId: Xt[T].objId, pageNumber: T, pageContext: Xt[T] };
  };
  g.addPage = function() {
    return Fo.apply(this, arguments), this;
  }, g.setPage = function() {
    return Oo.apply(this, arguments), ut.call(this, xt[T]), this;
  }, g.insertPage = function(h) {
    return this.addPage(), this.movePage(T, h), this;
  }, g.movePage = function(h, v) {
    var F, U;
    if (h > v) {
      F = xt[h], U = Xt[h];
      for (var K = h; K > v; K--) xt[K] = xt[K - 1], Xt[K] = Xt[K - 1];
      xt[v] = F, Xt[v] = U, this.setPage(v);
    } else if (h < v) {
      F = xt[h], U = Xt[h];
      for (var gt = h; gt < v; gt++) xt[gt] = xt[gt + 1], Xt[gt] = Xt[gt + 1];
      xt[v] = F, Xt[v] = U, this.setPage(v);
    }
    return this;
  }, g.deletePage = function() {
    return Ma.apply(this, arguments), this;
  }, g.__private__.text = g.text = function(h, v, F, U, K) {
    var gt, _t, It, Rt, Kt, Qt, xe, ze, an, Be = (U = U || {}).scope || this;
    if (typeof h == "number" && typeof v == "number" && (typeof F == "string" || Array.isArray(F))) {
      var ln = F;
      F = v, v = h, h = ln;
    }
    if (arguments[3] instanceof Vt == 0 ? (It = arguments[4], Rt = arguments[5], Ce(xe = arguments[3]) === "object" && xe !== null || (typeof It == "string" && (Rt = It, It = null), typeof xe == "string" && (Rt = xe, xe = null), typeof xe == "number" && (It = xe, xe = null), U = { flags: xe, angle: It, align: Rt })) : (j("The transform parameter of text() with a Matrix value"), an = K), isNaN(v) || isNaN(F) || h == null) throw new Error("Invalid arguments passed to jsPDF.text");
    if (h.length === 0) return Be;
    var on, vn = "", tr = typeof U.lineHeightFactor == "number" ? U.lineHeightFactor : Ci, On = Be.internal.scaleFactor;
    function Vo(Ne) {
      return Ne = Ne.split("	").join(Array(U.TabLen || 9).join(" ")), Qn(Ne, xe);
    }
    function ca(Ne) {
      for (var Oe, Xe = Ne.concat(), hn = [], zr = Xe.length; zr--; ) typeof (Oe = Xe.shift()) == "string" ? hn.push(Oe) : Array.isArray(Ne) && (Oe.length === 1 || Oe[1] === void 0 && Oe[2] === void 0) ? hn.push(Oe[0]) : hn.push([Oe[0], Oe[1], Oe[2]]);
      return hn;
    }
    function Ri(Ne, Oe) {
      var Xe;
      if (typeof Ne == "string") Xe = Oe(Ne)[0];
      else if (Array.isArray(Ne)) {
        for (var hn, zr, eo = Ne.concat(), pa = [], Yo = eo.length; Yo--; ) typeof (hn = eo.shift()) == "string" ? pa.push(Oe(hn)[0]) : Array.isArray(hn) && typeof hn[0] == "string" && (zr = Oe(hn[0], hn[1], hn[2]), pa.push([zr[0], zr[1], zr[2]]));
        Xe = pa;
      }
      return Xe;
    }
    var Qr = false, Mi = true;
    if (typeof h == "string") Qr = true;
    else if (Array.isArray(h)) {
      var Bi = h.concat();
      _t = [];
      for (var ji, An = Bi.length; An--; ) (typeof (ji = Bi.shift()) != "string" || Array.isArray(ji) && typeof ji[0] != "string") && (Mi = false);
      Qr = Mi;
    }
    if (Qr === false) throw new Error('Type of text must be string or Array. "' + h + '" is not recognized.');
    typeof h == "string" && (h = h.match(/[\r?\n]/) ? h.split(/\r\n|\r|\n/g) : [h]);
    var Di = At / Be.internal.scaleFactor, qi = Di * (tr - 1);
    switch (U.baseline) {
      case "bottom":
        F -= qi;
        break;
      case "top":
        F += Di - qi;
        break;
      case "hanging":
        F += Di - 2 * qi;
        break;
      case "middle":
        F += Di / 2 - qi;
    }
    if ((Qt = U.maxWidth || 0) > 0 && (typeof h == "string" ? h = Be.splitTextToSize(h, Qt) : Object.prototype.toString.call(h) === "[object Array]" && (h = h.reduce(function(Ne, Oe) {
      return Ne.concat(Be.splitTextToSize(Oe, Qt));
    }, []))), gt = { text: h, x: v, y: F, options: U, mutex: { pdfEscape: Qn, activeFontKey: qt, fonts: Mt, activeFontSize: At } }, Le.publish("preProcessText", gt), h = gt.text, It = (U = gt.options).angle, an instanceof Vt == 0 && It && typeof It == "number") {
      It *= Math.PI / 180, U.rotationDirection === 0 && (It = -It), D === G && (It = -It);
      var Ga = Math.cos(It), Za = Math.sin(It);
      an = new Vt(Ga, Za, -Za, Ga, 0, 0);
    } else It && It instanceof Vt && (an = It);
    D !== G || an || (an = Tr), (Kt = U.charSpace || ha) !== void 0 && (vn += $(z(Kt)) + ` Tc
`, this.setCharSpace(this.getCharSpace() || 0)), (ze = U.horizontalScale) !== void 0 && (vn += $(100 * ze) + ` Tz
`), U.lang;
    var We = -1, qr = U.renderingMode !== void 0 ? U.renderingMode : U.stroke, fa = Be.internal.getCurrentPageInfo().pageContext;
    switch (qr) {
      case 0:
      case false:
      case "fill":
        We = 0;
        break;
      case 1:
      case true:
      case "stroke":
        We = 1;
        break;
      case 2:
      case "fillThenStroke":
        We = 2;
        break;
      case 3:
      case "invisible":
        We = 3;
        break;
      case 4:
      case "fillAndAddForClipping":
        We = 4;
        break;
      case 5:
      case "strokeAndAddPathForClipping":
        We = 5;
        break;
      case 6:
      case "fillThenStrokeAndAddToPathForClipping":
        We = 6;
        break;
      case 7:
      case "addToPathForClipping":
        We = 7;
    }
    var Go = fa.usedRenderingMode !== void 0 ? fa.usedRenderingMode : -1;
    We !== -1 ? vn += We + ` Tr
` : Go !== -1 && (vn += `0 Tr
`), We !== -1 && (fa.usedRenderingMode = We), Rt = U.align || "left";
    var er, Ui = At * tr, Ya = Be.internal.pageSize.getWidth(), $a = Mt[qt];
    Kt = U.charSpace || ha, Qt = U.maxWidth || 0, xe = Object.assign({ autoencode: true, noBOM: true }, U.flags);
    var ti = [], zi = function(Ne) {
      return Be.getStringUnitWidth(Ne, { font: $a, charSpace: Kt, fontSize: At, doKerning: false }) * At / On;
    };
    if (Object.prototype.toString.call(h) === "[object Array]") {
      var jn;
      _t = ca(h), Rt !== "left" && (er = _t.map(zi));
      var Dn, ei = 0;
      if (Rt === "right") {
        v -= er[0], h = [], An = _t.length;
        for (var Ur = 0; Ur < An; Ur++) Ur === 0 ? (Dn = Mr(v), jn = Br(F)) : (Dn = z(ei - er[Ur]), jn = -Ui), h.push([_t[Ur], Dn, jn]), ei = er[Ur];
      } else if (Rt === "center") {
        v -= er[0] / 2, h = [], An = _t.length;
        for (var ni = 0; ni < An; ni++) ni === 0 ? (Dn = Mr(v), jn = Br(F)) : (Dn = z((ei - er[ni]) / 2), jn = -Ui), h.push([_t[ni], Dn, jn]), ei = er[ni];
      } else if (Rt === "left") {
        h = [], An = _t.length;
        for (var Ka = 0; Ka < An; Ka++) h.push(_t[Ka]);
      } else if (Rt === "justify" && $a.encoding === "Identity-H") {
        h = [], An = _t.length, Qt = Qt !== 0 ? Qt : Ya;
        for (var da = 0, Ke = 0; Ke < An; Ke++) if (jn = Ke === 0 ? Br(F) : -Ui, Dn = Ke === 0 ? Mr(v) : da, Ke < An - 1) {
          var Zo = z((Qt - er[Ke]) / (_t[Ke].split(" ").length - 1)), xr = _t[Ke].split(" ");
          h.push([xr[0] + " ", Dn, jn]), da = 0;
          for (var Ar = 1; Ar < xr.length; Ar++) {
            var Xa = (zi(xr[Ar - 1] + " " + xr[Ar]) - zi(xr[Ar])) * On + Zo;
            Ar == xr.length - 1 ? h.push([xr[Ar], Xa, 0]) : h.push([xr[Ar] + " ", Xa, 0]), da -= Xa;
          }
        } else h.push([_t[Ke], Dn, jn]);
        h.push(["", da, 0]);
      } else {
        if (Rt !== "justify") throw new Error('Unrecognized alignment option, use "left", "center", "right" or "justify".');
        for (h = [], An = _t.length, Qt = Qt !== 0 ? Qt : Ya, Ke = 0; Ke < An; Ke++) {
          jn = Ke === 0 ? Br(F) : -Ui, Dn = Ke === 0 ? Mr(v) : 0;
          var Ja = _t[Ke].split(" ").length - 1, Qa = Ja > 0 ? (Qt - er[Ke]) / Ja : 0;
          Ke < An - 1 ? ti.push($(z(Qa))) : ti.push(0), h.push([_t[Ke], Dn, jn]);
        }
      }
    }
    (typeof U.R2L == "boolean" ? U.R2L : se) === true && (h = Ri(h, function(Ne, Oe, Xe) {
      return [Ne.split("").reverse().join(""), Oe, Xe];
    })), gt = { text: h, x: v, y: F, options: U, mutex: { pdfEscape: Qn, activeFontKey: qt, fonts: Mt, activeFontSize: At } }, Le.publish("postProcessText", gt), h = gt.text, on = gt.mutex.isHex || false;
    var to = Mt[qt].encoding;
    to !== "WinAnsiEncoding" && to !== "StandardEncoding" || (h = Ri(h, function(Ne, Oe, Xe) {
      return [Vo(Ne), Oe, Xe];
    })), _t = ca(h), h = [];
    for (var ri, ii, ai, Hi = Array.isArray(_t[0]) ? 1 : 0, oi = "", Wi = function(Ne, Oe, Xe) {
      var hn = "";
      return Xe instanceof Vt ? (Xe = typeof U.angle == "number" ? Or(Xe, new Vt(1, 0, 0, 1, Ne, Oe)) : Or(new Vt(1, 0, 0, 1, Ne, Oe), Xe), D === G && (Xe = Or(new Vt(1, 0, 0, -1, 0, 0), Xe)), hn = Xe.join(" ") + ` Tm
`) : hn = $(Ne) + " " + $(Oe) + ` Td
`, hn;
    }, nr = 0; nr < _t.length; nr++) {
      switch (oi = "", Hi) {
        case 1:
          ai = (on ? "<" : "(") + _t[nr][0] + (on ? ">" : ")"), ri = parseFloat(_t[nr][1]), ii = parseFloat(_t[nr][2]);
          break;
        case 0:
          ai = (on ? "<" : "(") + _t[nr] + (on ? ">" : ")"), ri = Mr(v), ii = Br(F);
      }
      ti !== void 0 && ti[nr] !== void 0 && (oi = ti[nr] + ` Tw
`), nr === 0 ? h.push(oi + Wi(ri, ii, an) + ai) : Hi === 0 ? h.push(oi + ai) : Hi === 1 && h.push(oi + Wi(ri, ii, an) + ai);
    }
    h = Hi === 0 ? h.join(` Tj
T* `) : h.join(` Tj
`), h += ` Tj
`;
    var Lr = `BT
/`;
    return Lr += qt + " " + At + ` Tf
`, Lr += $(At * tr) + ` TL
`, Lr += Ei + `
`, Lr += vn, Lr += h, R(Lr += "ET"), L[qt] = true, Be;
  };
  var Hs = g.__private__.clip = g.clip = function(h) {
    return R(h === "evenodd" ? "W*" : "W"), this;
  };
  g.clipEvenOdd = function() {
    return Hs("evenodd");
  }, g.__private__.discardPath = g.discardPath = function() {
    return R("n"), this;
  };
  var yr = g.__private__.isValidStyle = function(h) {
    var v = false;
    return [void 0, null, "S", "D", "F", "DF", "FD", "f", "f*", "B", "B*", "n"].indexOf(h) !== -1 && (v = true), v;
  };
  g.__private__.setDefaultPathOperation = g.setDefaultPathOperation = function(h) {
    return yr(h) && (c = h), this;
  };
  var jo = g.__private__.getStyle = g.getStyle = function(h) {
    var v = c;
    switch (h) {
      case "D":
      case "S":
        v = "S";
        break;
      case "F":
        v = "f";
        break;
      case "FD":
      case "DF":
        v = "B";
        break;
      case "f":
      case "f*":
      case "B":
      case "B*":
        v = h;
    }
    return v;
  }, Do = g.close = function() {
    return R("h"), this;
  };
  g.stroke = function() {
    return R("S"), this;
  }, g.fill = function(h) {
    return Xr("f", h), this;
  }, g.fillEvenOdd = function(h) {
    return Xr("f*", h), this;
  }, g.fillStroke = function(h) {
    return Xr("B", h), this;
  }, g.fillStrokeEvenOdd = function(h) {
    return Xr("B*", h), this;
  };
  var Xr = function(h, v) {
    Ce(v) === "object" ? Vs(v, h) : R(h);
  }, ja = function(h) {
    h === null || D === G && h === void 0 || (h = jo(h), R(h));
  };
  function Ws(h, v, F, U, K) {
    var gt = new xa(v || this.boundingBox, F || this.xStep, U || this.yStep, this.gState, K || this.matrix);
    gt.stream = this.stream;
    var _t = h + "$$" + this.cloneIndex++ + "$$";
    return Kn(_t, gt), gt;
  }
  var Vs = function(h, v) {
    var F = ge[h.key], U = Wt[F];
    if (U instanceof Zi) R("q"), R(Gs(v)), U.gState && g.setGState(U.gState), R(h.matrix.toString() + " cm"), R("/" + F + " sh"), R("Q");
    else if (U instanceof xa) {
      var K = new Vt(1, 0, 0, -1, 0, Ti());
      h.matrix && (K = K.multiply(h.matrix || Tr), F = Ws.call(U, h.key, h.boundingBox, h.xStep, h.yStep, K).id), R("q"), R("/Pattern cs"), R("/" + F + " scn"), U.gState && g.setGState(U.gState), R(v), R("Q");
    }
  }, Gs = function(h) {
    switch (h) {
      case "f":
      case "F":
      case "n":
        return "W n";
      case "f*":
        return "W* n";
      case "B":
      case "S":
        return "W S";
      case "B*":
        return "W* S";
    }
  }, Da = g.moveTo = function(h, v) {
    return R($(z(h)) + " " + $(q(v)) + " m"), this;
  }, Pi = g.lineTo = function(h, v) {
    return R($(z(h)) + " " + $(q(v)) + " l"), this;
  }, Jr = g.curveTo = function(h, v, F, U, K, gt) {
    return R([$(z(h)), $(q(v)), $(z(F)), $(q(U)), $(z(K)), $(q(gt)), "c"].join(" ")), this;
  };
  g.__private__.line = g.line = function(h, v, F, U, K) {
    if (isNaN(h) || isNaN(v) || isNaN(F) || isNaN(U) || !yr(K)) throw new Error("Invalid arguments passed to jsPDF.line");
    return D === V ? this.lines([[F - h, U - v]], h, v, [1, 1], K || "S") : this.lines([[F - h, U - v]], h, v, [1, 1]).stroke();
  }, g.__private__.lines = g.lines = function(h, v, F, U, K, gt) {
    var _t, It, Rt, Kt, Qt, xe, ze, an, Be, ln, on, vn;
    if (typeof h == "number" && (vn = F, F = v, v = h, h = vn), U = U || [1, 1], gt = gt || false, isNaN(v) || isNaN(F) || !Array.isArray(h) || !Array.isArray(U) || !yr(K) || typeof gt != "boolean") throw new Error("Invalid arguments passed to jsPDF.lines");
    for (Da(v, F), _t = U[0], It = U[1], Kt = h.length, ln = v, on = F, Rt = 0; Rt < Kt; Rt++) (Qt = h[Rt]).length === 2 ? (ln = Qt[0] * _t + ln, on = Qt[1] * It + on, Pi(ln, on)) : (xe = Qt[0] * _t + ln, ze = Qt[1] * It + on, an = Qt[2] * _t + ln, Be = Qt[3] * It + on, ln = Qt[4] * _t + ln, on = Qt[5] * It + on, Jr(xe, ze, an, Be, ln, on));
    return gt && Do(), ja(K), this;
  }, g.path = function(h) {
    for (var v = 0; v < h.length; v++) {
      var F = h[v], U = F.c;
      switch (F.op) {
        case "m":
          Da(U[0], U[1]);
          break;
        case "l":
          Pi(U[0], U[1]);
          break;
        case "c":
          Jr.apply(this, U);
          break;
        case "h":
          Do();
      }
    }
    return this;
  }, g.__private__.rect = g.rect = function(h, v, F, U, K) {
    if (isNaN(h) || isNaN(v) || isNaN(F) || isNaN(U) || !yr(K)) throw new Error("Invalid arguments passed to jsPDF.rect");
    return D === V && (U = -U), R([$(z(h)), $(q(v)), $(z(F)), $(z(U)), "re"].join(" ")), ja(K), this;
  }, g.__private__.triangle = g.triangle = function(h, v, F, U, K, gt, _t) {
    if (isNaN(h) || isNaN(v) || isNaN(F) || isNaN(U) || isNaN(K) || isNaN(gt) || !yr(_t)) throw new Error("Invalid arguments passed to jsPDF.triangle");
    return this.lines([[F - h, U - v], [K - F, gt - U], [h - K, v - gt]], h, v, [1, 1], _t, true), this;
  }, g.__private__.roundedRect = g.roundedRect = function(h, v, F, U, K, gt, _t) {
    if (isNaN(h) || isNaN(v) || isNaN(F) || isNaN(U) || isNaN(K) || isNaN(gt) || !yr(_t)) throw new Error("Invalid arguments passed to jsPDF.roundedRect");
    var It = 4 / 3 * (Math.SQRT2 - 1);
    return K = Math.min(K, 0.5 * F), gt = Math.min(gt, 0.5 * U), this.lines([[F - 2 * K, 0], [K * It, 0, K, gt - gt * It, K, gt], [0, U - 2 * gt], [0, gt * It, -K * It, gt, -K, gt], [2 * K - F, 0], [-K * It, 0, -K, -gt * It, -K, -gt], [0, 2 * gt - U], [0, -gt * It, K * It, -gt, K, -gt]], h + K, v, [1, 1], _t, true), this;
  }, g.__private__.ellipse = g.ellipse = function(h, v, F, U, K) {
    if (isNaN(h) || isNaN(v) || isNaN(F) || isNaN(U) || !yr(K)) throw new Error("Invalid arguments passed to jsPDF.ellipse");
    var gt = 4 / 3 * (Math.SQRT2 - 1) * F, _t = 4 / 3 * (Math.SQRT2 - 1) * U;
    return Da(h + F, v), Jr(h + F, v - _t, h + gt, v - U, h, v - U), Jr(h - gt, v - U, h - F, v - _t, h - F, v), Jr(h - F, v + _t, h - gt, v + U, h, v + U), Jr(h + gt, v + U, h + F, v + _t, h + F, v), ja(K), this;
  }, g.__private__.circle = g.circle = function(h, v, F, U) {
    if (isNaN(h) || isNaN(v) || isNaN(F) || !yr(U)) throw new Error("Invalid arguments passed to jsPDF.circle");
    return this.ellipse(h, v, F, F, U);
  }, g.setFont = function(h, v, F) {
    return F && (v = dt(v, F)), qt = Ro(h, v, { disableWarning: false }), this;
  };
  var Zs = g.__private__.getFont = g.getFont = function() {
    return Mt[Ro.apply(g, arguments)];
  };
  g.__private__.getFontList = g.getFontList = function() {
    var h, v, F = {};
    for (h in re) if (re.hasOwnProperty(h)) for (v in F[h] = [], re[h]) re[h].hasOwnProperty(v) && F[h].push(v);
    return F;
  }, g.addFont = function(h, v, F, U, K) {
    var gt = ["StandardEncoding", "MacRomanEncoding", "Identity-H", "WinAnsiEncoding"];
    return arguments[3] && gt.indexOf(arguments[3]) !== -1 ? K = arguments[3] : arguments[3] && gt.indexOf(arguments[3]) == -1 && (F = dt(F, U)), Io.call(this, h, v, F, K = K || "Identity-H");
  };
  var Ci, qa = t3.lineWidth || 0.200025, Jt = g.__private__.getLineWidth = g.getLineWidth = function() {
    return qa;
  }, Ys = g.__private__.setLineWidth = g.setLineWidth = function(h) {
    return qa = h, R($(z(h)) + " w"), this;
  };
  g.__private__.setLineDash = jt.API.setLineDash = jt.API.setLineDashPattern = function(h, v) {
    if (h = h || [], v = v || 0, isNaN(v) || !Array.isArray(h)) throw new Error("Invalid arguments passed to jsPDF.setLineDash");
    return h = h.map(function(F) {
      return $(z(F));
    }).join(" "), v = $(z(v)), R("[" + h + "] " + v + " d"), this;
  };
  var $s = g.__private__.getLineHeight = g.getLineHeight = function() {
    return At * Ci;
  };
  g.__private__.getLineHeight = g.getLineHeight = function() {
    return At * Ci;
  };
  var Ks = g.__private__.setLineHeightFactor = g.setLineHeightFactor = function(h) {
    return typeof (h = h || 1.15) == "number" && (Ci = h), this;
  }, Xs = g.__private__.getLineHeightFactor = g.getLineHeightFactor = function() {
    return Ci;
  };
  Ks(t3.lineHeight);
  var Mr = g.__private__.getHorizontalCoordinate = function(h) {
    return z(h);
  }, Br = g.__private__.getVerticalCoordinate = function(h) {
    return D === G ? h : Xt[T].mediaBox.topRightY - Xt[T].mediaBox.bottomLeftY - z(h);
  }, Js = g.__private__.getHorizontalCoordinateString = g.getHorizontalCoordinateString = function(h) {
    return $(Mr(h));
  }, Qs = g.__private__.getVerticalCoordinateString = g.getVerticalCoordinateString = function(h) {
    return $(Br(h));
  }, sa = t3.strokeColor || "0 G";
  g.__private__.getStrokeColor = g.getDrawColor = function() {
    return wr(sa);
  }, g.__private__.setStrokeColor = g.setDrawColor = function(h, v, F, U) {
    return sa = lr({ ch1: h, ch2: v, ch3: F, ch4: U, pdfColorType: "draw", precision: 2 }), R(sa), this;
  };
  var Ua = t3.fillColor || "0 g";
  g.__private__.getFillColor = g.getFillColor = function() {
    return wr(Ua);
  }, g.__private__.setFillColor = g.setFillColor = function(h, v, F, U) {
    return Ua = lr({ ch1: h, ch2: v, ch3: F, ch4: U, pdfColorType: "fill", precision: 2 }), R(Ua), this;
  };
  var Ei = t3.textColor || "0 g", la = g.__private__.getTextColor = g.getTextColor = function() {
    return wr(Ei);
  };
  g.__private__.setTextColor = g.setTextColor = function(h, v, F, U) {
    return Ei = lr({ ch1: h, ch2: v, ch3: F, ch4: U, pdfColorType: "text", precision: 3 }), this;
  };
  var ha = t3.charSpace, tl = g.__private__.getCharSpace = g.getCharSpace = function() {
    return parseFloat(ha || 0);
  };
  g.__private__.setCharSpace = g.setCharSpace = function(h) {
    if (isNaN(h)) throw new Error("Invalid argument passed to jsPDF.setCharSpace");
    return ha = h, this;
  };
  var za = 0;
  g.CapJoinStyles = { 0: 0, butt: 0, but: 0, miter: 0, 1: 1, round: 1, rounded: 1, circle: 1, 2: 2, projecting: 2, project: 2, square: 2, bevel: 2 }, g.__private__.setLineCap = g.setLineCap = function(h) {
    var v = g.CapJoinStyles[h];
    if (v === void 0) throw new Error("Line cap style of '" + h + "' is not recognized. See or extend .CapJoinStyles property for valid styles");
    return za = v, R(v + " J"), this;
  };
  var Ha = 0;
  g.__private__.setLineJoin = g.setLineJoin = function(h) {
    var v = g.CapJoinStyles[h];
    if (v === void 0) throw new Error("Line join style of '" + h + "' is not recognized. See or extend .CapJoinStyles property for valid styles");
    return Ha = v, R(v + " j"), this;
  }, g.__private__.setLineMiterLimit = g.__private__.setMiterLimit = g.setLineMiterLimit = g.setMiterLimit = function(h) {
    if (h = h || 0, isNaN(h)) throw new Error("Invalid argument passed to jsPDF.setLineMiterLimit");
    return R($(z(h)) + " M"), this;
  }, g.GState = Os, g.setGState = function(h) {
    (h = typeof h == "string" ? ie[Ye[h]] : Ii(null, h)).equals(sn) || (R("/" + h.id + " gs"), sn = h);
  };
  var Ii = function(h, v) {
    if (!h || !Ye[h]) {
      var F = false;
      for (var U in ie) if (ie.hasOwnProperty(U) && ie[U].equals(v)) {
        F = true;
        break;
      }
      if (F) v = ie[U];
      else {
        var K = "GS" + (Object.keys(ie).length + 1).toString(10);
        ie[K] = v, v.id = K;
      }
      return h && (Ye[h] = v.id), Le.publish("addGState", v), v;
    }
  };
  g.addGState = function(h, v) {
    return Ii(h, v), this;
  }, g.saveGraphicsState = function() {
    return R("q"), Ie.push({ key: qt, size: At, color: Ei }), this;
  }, g.restoreGraphicsState = function() {
    R("Q");
    var h = Ie.pop();
    return qt = h.key, At = h.size, Ei = h.color, sn = null, this;
  }, g.setCurrentTransformationMatrix = function(h) {
    return R(h.toString() + " cm"), this;
  }, g.comment = function(h) {
    return R("#" + h), this;
  };
  var Fi = function(h, v) {
    var F = h || 0;
    Object.defineProperty(this, "x", { enumerable: true, get: function() {
      return F;
    }, set: function(gt) {
      isNaN(gt) || (F = parseFloat(gt));
    } });
    var U = v || 0;
    Object.defineProperty(this, "y", { enumerable: true, get: function() {
      return U;
    }, set: function(gt) {
      isNaN(gt) || (U = parseFloat(gt));
    } });
    var K = "pt";
    return Object.defineProperty(this, "type", { enumerable: true, get: function() {
      return K;
    }, set: function(gt) {
      K = gt.toString();
    } }), this;
  }, Wa = function(h, v, F, U) {
    Fi.call(this, h, v), this.type = "rect";
    var K = F || 0;
    Object.defineProperty(this, "w", { enumerable: true, get: function() {
      return K;
    }, set: function(_t) {
      isNaN(_t) || (K = parseFloat(_t));
    } });
    var gt = U || 0;
    return Object.defineProperty(this, "h", { enumerable: true, get: function() {
      return gt;
    }, set: function(_t) {
      isNaN(_t) || (gt = parseFloat(_t));
    } }), this;
  }, ua = function() {
    this.page = Fe, this.currentPage = T, this.pages = xt.slice(0), this.pagesContext = Xt.slice(0), this.x = Ut, this.y = Me, this.matrix = ye, this.width = qo(T), this.height = jr(T), this.outputDestination = Pt, this.id = "", this.objectNumber = -1;
  };
  ua.prototype.restore = function() {
    Fe = this.page, T = this.currentPage, Xt = this.pagesContext, xt = this.pages, Ut = this.x, Me = this.y, ye = this.matrix, Uo(T, this.width), Dr(T, this.height), Pt = this.outputDestination;
  };
  var Va = function(h, v, F, U, K) {
    br.push(new ua()), Fe = T = 0, xt = [], Ut = h, Me = v, ye = K, Ra([F, U]);
  };
  for (var Oi in g.beginFormObject = function(h, v, F, U, K) {
    return Va(h, v, F, U, K), this;
  }, g.endFormObject = function(h) {
    return (function(v) {
      if (Fr[v]) br.pop().restore();
      else {
        var F = new ua(), U = "Xo" + (Object.keys(xn).length + 1).toString(10);
        F.id = U, Fr[v] = U, xn[U] = F, Le.publish("addFormObject", F), br.pop().restore();
      }
    })(h), this;
  }, g.doFormObject = function(h, v) {
    var F = xn[Fr[h]];
    return R("q"), R(v.toString() + " cm"), R("/" + F.id + " Do"), R("Q"), this;
  }, g.getFormObject = function(h) {
    var v = xn[Fr[h]];
    return { x: v.x, y: v.y, width: v.width, height: v.height, matrix: v.matrix };
  }, g.save = function(h, v) {
    return h = h || "generated.pdf", (v = v || {}).returnPromise = v.returnPromise || false, v.returnPromise === false ? (Gi(Si(Rr()), h), typeof Gi.unload == "function" && $t.setTimeout && setTimeout(Gi.unload, 911), this) : new Promise(function(F, U) {
      try {
        var K = Gi(Si(Rr()), h);
        typeof Gi.unload == "function" && $t.setTimeout && setTimeout(Gi.unload, 911), F(K);
      } catch (gt) {
        U(gt.message);
      }
    });
  }, jt.API) jt.API.hasOwnProperty(Oi) && (Oi === "events" && jt.API.events.length ? (function(h, v) {
    var F, U, K;
    for (K = v.length - 1; K !== -1; K--) F = v[K][0], U = v[K][1], h.subscribe.apply(h, [F].concat(typeof U == "function" ? [U] : U));
  })(Le, jt.API.events) : g[Oi] = jt.API[Oi]);
  function qo(h) {
    return Xt[h].mediaBox.topRightX - Xt[h].mediaBox.bottomLeftX;
  }
  function Uo(h, v) {
    Xt[h].mediaBox.topRightX = v + Xt[h].mediaBox.bottomLeftX;
  }
  function jr(h) {
    return Xt[h].mediaBox.topRightY - Xt[h].mediaBox.bottomLeftY;
  }
  function Dr(h, v) {
    Xt[h].mediaBox.topRightY = v + Xt[h].mediaBox.bottomLeftY;
  }
  var zo = g.getPageWidth = function(h) {
    return qo(h = h || T) / Yt;
  }, Ho = g.setPageWidth = function(h, v) {
    Uo(h, v * Yt);
  }, Ti = g.getPageHeight = function(h) {
    return jr(h = h || T) / Yt;
  }, Wo = g.setPageHeight = function(h, v) {
    Dr(h, v * Yt);
  };
  return g.internal = { pdfEscape: Qn, getStyle: jo, getFont: Zs, getFontSize: St, getCharSpace: tl, getTextColor: la, getLineHeight: $s, getLineHeightFactor: Xs, getLineWidth: Jt, write: pe, getHorizontalCoordinate: Mr, getVerticalCoordinate: Br, getCoordinateString: Js, getVerticalCoordinateString: Qs, collections: {}, newObject: He, newAdditionalObject: Ai, newObjectDeferred: dn, newObjectDeferredBegin: mn, getFilters: hr, putStream: Jn, events: Le, scaleFactor: Yt, pageSize: { getWidth: function() {
    return zo(T);
  }, setWidth: function(h) {
    Ho(T, h);
  }, getHeight: function() {
    return Ti(T);
  }, setHeight: function(h) {
    Wo(T, h);
  } }, encryptionOptions: p, encryption: $e, getEncryptor: function(h) {
    return p !== null ? $e.encryptor(h, 0) : function(v) {
      return v;
    };
  }, output: ur, getNumberOfPages: To, pages: xt, out: R, f2: N, f3: C, getPageInfo: Ba, getPageInfoByObjId: Us, getCurrentPageInfo: zs, getPDFVersion: P, Point: Fi, Rectangle: Wa, Matrix: Vt, hasHotfix: ki }, Object.defineProperty(g.internal.pageSize, "width", { get: function() {
    return zo(T);
  }, set: function(h) {
    Ho(T, h);
  }, enumerable: true, configurable: true }), Object.defineProperty(g.internal.pageSize, "height", { get: function() {
    return Ti(T);
  }, set: function(h) {
    Wo(T, h);
  }, enumerable: true, configurable: true }), (function(h) {
    for (var v = 0, F = Ht.length; v < F; v++) {
      var U = Io.call(this, h[v][0], h[v][1], h[v][2], Ht[v][3], true);
      x === false && (L[U] = true);
      var K = h[v][0].split("-");
      Eo({ id: U, fontName: K[0], fontStyle: K[1] || "" });
    }
    Le.publish("addFonts", { fonts: Mt, dictionary: re });
  }).call(g, Ht), qt = "F1", Fo(i, e), Le.publish("initialized"), g;
}
_a.prototype.lsbFirstWord = function(t3) {
  return String.fromCharCode(255 & t3, t3 >> 8 & 255, t3 >> 16 & 255, t3 >> 24 & 255);
}, _a.prototype.toHexString = function(t3) {
  return t3.split("").map(function(n) {
    return ("0" + (255 & n.charCodeAt(0)).toString(16)).slice(-2);
  }).join("");
}, _a.prototype.hexToBytes = function(t3) {
  for (var n = [], e = 0; e < t3.length; e += 2) n.push(String.fromCharCode(parseInt(t3.substr(e, 2), 16)));
  return n.join("");
}, _a.prototype.processOwnerPassword = function(t3, n) {
  return lh(sh(n).substr(0, 5), t3);
}, _a.prototype.encryptor = function(t3, n) {
  var e = sh(this.encryptionKey + String.fromCharCode(255 & t3, t3 >> 8 & 255, t3 >> 16 & 255, 255 & n, n >> 8 & 255)).substr(0, 10);
  return function(r) {
    return lh(e, r);
  };
}, Os.prototype.equals = function(t3) {
  var n, e = "id,objectNumber,equals";
  if (!t3 || Ce(t3) !== Ce(this)) return false;
  var r = 0;
  for (n in this) if (!(e.indexOf(n) >= 0)) {
    if (this.hasOwnProperty(n) && !t3.hasOwnProperty(n) || this[n] !== t3[n]) return false;
    r++;
  }
  for (n in t3) t3.hasOwnProperty(n) && e.indexOf(n) < 0 && r--;
  return r === 0;
}, jt.API = { events: [] }, jt.version = "3.0.3";
var Ze = jt.API, xh = 1, na = function(t3) {
  return t3.replace(/\\/g, "\\\\").replace(/\(/g, "\\(").replace(/\)/g, "\\)");
}, ba = function(t3) {
  return t3.replace(/\\\\/g, "\\").replace(/\\\(/g, "(").replace(/\\\)/g, ")");
}, te = function(t3) {
  return t3.toFixed(2);
}, pi = function(t3) {
  return t3.toFixed(5);
};
Ze.__acroform__ = {};
var Bn = function(t3, n) {
  t3.prototype = Object.create(n.prototype), t3.prototype.constructor = t3;
}, gc = function(t3) {
  return t3 * xh;
}, Sr = function(t3) {
  var n = new Rf(), e = Et.internal.getHeight(t3) || 0, r = Et.internal.getWidth(t3) || 0;
  return n.BBox = [0, 0, Number(te(r)), Number(te(e))], n;
}, ed = Ze.__acroform__.setBit = function(t3, n) {
  if (t3 = t3 || 0, n = n || 0, isNaN(t3) || isNaN(n)) throw new Error("Invalid arguments passed to jsPDF.API.__acroform__.setBit");
  return t3 | 1 << n;
}, nd = Ze.__acroform__.clearBit = function(t3, n) {
  if (t3 = t3 || 0, n = n || 0, isNaN(t3) || isNaN(n)) throw new Error("Invalid arguments passed to jsPDF.API.__acroform__.clearBit");
  return t3 & ~(1 << n);
}, rd = Ze.__acroform__.getBit = function(t3, n) {
  if (isNaN(t3) || isNaN(n)) throw new Error("Invalid arguments passed to jsPDF.API.__acroform__.getBit");
  return t3 & 1 << n ? 1 : 0;
}, tn = Ze.__acroform__.getBitForPdf = function(t3, n) {
  if (isNaN(t3) || isNaN(n)) throw new Error("Invalid arguments passed to jsPDF.API.__acroform__.getBitForPdf");
  return rd(t3, n - 1);
}, en = Ze.__acroform__.setBitForPdf = function(t3, n) {
  if (isNaN(t3) || isNaN(n)) throw new Error("Invalid arguments passed to jsPDF.API.__acroform__.setBitForPdf");
  return ed(t3, n - 1);
}, nn = Ze.__acroform__.clearBitForPdf = function(t3, n) {
  if (isNaN(t3) || isNaN(n)) throw new Error("Invalid arguments passed to jsPDF.API.__acroform__.clearBitForPdf");
  return nd(t3, n - 1);
}, id = Ze.__acroform__.calculateCoordinates = function(t3, n) {
  var e = n.internal.getHorizontalCoordinate, r = n.internal.getVerticalCoordinate, i = t3[0], o = t3[1], u = t3[2], l = t3[3], f = {};
  return f.lowerLeft_X = e(i) || 0, f.lowerLeft_Y = r(o + l) || 0, f.upperRight_X = e(i + u) || 0, f.upperRight_Y = r(o) || 0, [Number(te(f.lowerLeft_X)), Number(te(f.lowerLeft_Y)), Number(te(f.upperRight_X)), Number(te(f.upperRight_Y))];
}, ad = function(t3) {
  if (t3.appearanceStreamContent) return t3.appearanceStreamContent;
  if (t3.V || t3.DV) {
    var n = [], e = t3._V || t3.DV, r = hh(t3, e), i = t3.scope.internal.getFont(t3.fontName, t3.fontStyle).id;
    n.push("/Tx BMC"), n.push("q"), n.push("BT"), n.push(t3.scope.__private__.encodeColorString(t3.color)), n.push("/" + i + " " + te(r.fontSize) + " Tf"), n.push("1 0 0 1 0 0 Tm"), n.push(r.text), n.push("ET"), n.push("Q"), n.push("EMC");
    var o = Sr(t3);
    return o.scope = t3.scope, o.stream = n.join(`
`), o;
  }
}, hh = function(t3, n) {
  var e = t3.fontSize === 0 ? t3.maxFontSize : t3.fontSize, r = { text: "", fontSize: "" }, i = (n = (n = n.substr(0, 1) == "(" ? n.substr(1) : n).substr(n.length - 1) == ")" ? n.substr(0, n.length - 1) : n).split(" ");
  i = t3.multiline ? i.map(function(N) {
    return N.split(`
`);
  }) : i.map(function(N) {
    return [N];
  });
  var o = e, u = Et.internal.getHeight(t3) || 0;
  u = u < 0 ? -u : u;
  var l = Et.internal.getWidth(t3) || 0;
  l = l < 0 ? -l : l;
  var f = function(N, C, z) {
    if (N + 1 < i.length) {
      var q = C + " " + i[N + 1][0];
      return ws(q, t3, z).width <= l - 4;
    }
    return false;
  };
  o++;
  t: for (; o > 0; ) {
    n = "", o--;
    var c, p, x = ws("3", t3, o).height, L = t3.multiline ? u - o : (u - x) / 2, g = L += 2, O = 0, P = 0, M = 0;
    if (o <= 0) {
      n = `(...) Tj
`, n += "% Width of Text: " + ws(n, t3, o = 12).width + ", FieldWidth:" + l + `
`;
      break;
    }
    for (var k = "", V = 0, G = 0; G < i.length; G++) if (i.hasOwnProperty(G)) {
      var D = false;
      if (i[G].length !== 1 && M !== i[G].length - 1) {
        if ((x + 2) * (V + 2) + 2 > u) continue t;
        k += i[G][M], D = true, P = G, G--;
      } else {
        k = (k += i[G][M] + " ").substr(k.length - 1) == " " ? k.substr(0, k.length - 1) : k;
        var it = parseInt(G), bt = f(it, k, o), dt = G >= i.length - 1;
        if (bt && !dt) {
          k += " ", M = 0;
          continue;
        }
        if (bt || dt) {
          if (dt) P = it;
          else if (t3.multiline && (x + 2) * (V + 2) + 2 > u) continue t;
        } else {
          if (!t3.multiline || (x + 2) * (V + 2) + 2 > u) continue t;
          P = it;
        }
      }
      for (var $ = "", j = O; j <= P; j++) {
        var J = i[j];
        if (t3.multiline) {
          if (j === P) {
            $ += J[M] + " ", M = (M + 1) % J.length;
            continue;
          }
          if (j === O) {
            $ += J[J.length - 1] + " ";
            continue;
          }
        }
        $ += J[0] + " ";
      }
      switch ($ = $.substr($.length - 1) == " " ? $.substr(0, $.length - 1) : $, p = ws($, t3, o).width, t3.textAlign) {
        case "right":
          c = l - p - 2;
          break;
        case "center":
          c = (l - p) / 2;
          break;
        default:
          c = 2;
      }
      n += te(c) + " " + te(g) + ` Td
`, n += "(" + na($) + `) Tj
`, n += -te(c) + ` 0 Td
`, g = -(o + 2), p = 0, O = D ? P : P + 1, V++, k = "";
    }
    break;
  }
  return r.text = n, r.fontSize = o, r;
}, ws = function(t3, n, e) {
  var r = n.scope.internal.getFont(n.fontName, n.fontStyle), i = n.scope.getStringUnitWidth(t3, { font: r, fontSize: parseFloat(e), charSpace: 0 }) * parseFloat(e);
  return { height: n.scope.getStringUnitWidth("3", { font: r, fontSize: parseFloat(e), charSpace: 0 }) * parseFloat(e) * 1.5, width: i };
}, od = { fields: [], xForms: [], acroFormDictionaryRoot: null, printedOut: false, internal: null, isInitialized: false }, sd = function(t3, n) {
  var e = { type: "reference", object: t3 };
  n.internal.getPageInfo(t3.page).pageContext.annotations.find(function(r) {
    return r.type === e.type && r.object === e.object;
  }) === void 0 && n.internal.getPageInfo(t3.page).pageContext.annotations.push(e);
}, ld = function(t3, n) {
  if (n.scope = t3, t3.internal !== void 0 && (t3.internal.acroformPlugin === void 0 || t3.internal.acroformPlugin.isInitialized === false)) {
    if (mr.FieldNum = 0, t3.internal.acroformPlugin = JSON.parse(JSON.stringify(od)), t3.internal.acroformPlugin.acroFormDictionaryRoot) throw new Error("Exception while creating AcroformDictionary");
    xh = t3.internal.scaleFactor, t3.internal.acroformPlugin.acroFormDictionaryRoot = new Mf(), t3.internal.acroformPlugin.acroFormDictionaryRoot.scope = t3, t3.internal.acroformPlugin.acroFormDictionaryRoot._eventID = t3.internal.events.subscribe("postPutResources", function() {
      (function(e) {
        e.internal.events.unsubscribe(e.internal.acroformPlugin.acroFormDictionaryRoot._eventID), delete e.internal.acroformPlugin.acroFormDictionaryRoot._eventID, e.internal.acroformPlugin.printedOut = true;
      })(t3);
    }), t3.internal.events.subscribe("buildDocument", function() {
      (function(e) {
        e.internal.acroformPlugin.acroFormDictionaryRoot.objId = void 0;
        var r = e.internal.acroformPlugin.acroFormDictionaryRoot.Fields;
        for (var i in r) if (r.hasOwnProperty(i)) {
          var o = r[i];
          o.objId = void 0, o.hasAnnotation && sd(o, e);
        }
      })(t3);
    }), t3.internal.events.subscribe("putCatalog", function() {
      (function(e) {
        if (e.internal.acroformPlugin.acroFormDictionaryRoot === void 0) throw new Error("putCatalogCallback: Root missing.");
        e.internal.write("/AcroForm " + e.internal.acroformPlugin.acroFormDictionaryRoot.objId + " 0 R");
      })(t3);
    }), t3.internal.events.subscribe("postPutPages", function(e) {
      (function(r, i) {
        var o = !r;
        for (var u in r || (i.internal.newObjectDeferredBegin(i.internal.acroformPlugin.acroFormDictionaryRoot.objId, true), i.internal.acroformPlugin.acroFormDictionaryRoot.putStream()), r = r || i.internal.acroformPlugin.acroFormDictionaryRoot.Kids) if (r.hasOwnProperty(u)) {
          var l = r[u], f = [], c = l.Rect;
          if (l.Rect && (l.Rect = id(l.Rect, i)), i.internal.newObjectDeferredBegin(l.objId, true), l.DA = Et.createDefaultAppearanceStream(l), Ce(l) === "object" && typeof l.getKeyValueListForStream == "function" && (f = l.getKeyValueListForStream()), l.Rect = c, l.hasAppearanceStream && !l.appearanceStreamContent) {
            var p = ad(l);
            f.push({ key: "AP", value: "<</N " + p + ">>" }), i.internal.acroformPlugin.xForms.push(p);
          }
          if (l.appearanceStreamContent) {
            var x = "";
            for (var L in l.appearanceStreamContent) if (l.appearanceStreamContent.hasOwnProperty(L)) {
              var g = l.appearanceStreamContent[L];
              if (x += "/" + L + " ", x += "<<", Object.keys(g).length >= 1 || Array.isArray(g)) {
                for (var u in g) if (g.hasOwnProperty(u)) {
                  var O = g[u];
                  typeof O == "function" && (O = O.call(i, l)), x += "/" + u + " " + O + " ", i.internal.acroformPlugin.xForms.indexOf(O) >= 0 || i.internal.acroformPlugin.xForms.push(O);
                }
              } else typeof (O = g) == "function" && (O = O.call(i, l)), x += "/" + u + " " + O, i.internal.acroformPlugin.xForms.indexOf(O) >= 0 || i.internal.acroformPlugin.xForms.push(O);
              x += ">>";
            }
            f.push({ key: "AP", value: `<<
` + x + ">>" });
          }
          i.internal.putStream({ additionalKeyValues: f, objectId: l.objId }), i.internal.out("endobj");
        }
        o && (function(P, M) {
          for (var k in P) if (P.hasOwnProperty(k)) {
            var V = k, G = P[k];
            M.internal.newObjectDeferredBegin(G.objId, true), Ce(G) === "object" && typeof G.putStream == "function" && G.putStream(), delete P[V];
          }
        })(i.internal.acroformPlugin.xForms, i);
      })(e, t3);
    }), t3.internal.acroformPlugin.isInitialized = true;
  }
}, Tf = Ze.__acroform__.arrayToPdfArray = function(t3, n, e) {
  var r = function(u) {
    return u;
  };
  if (Array.isArray(t3)) {
    for (var i = "[", o = 0; o < t3.length; o++) switch (o !== 0 && (i += " "), Ce(t3[o])) {
      case "boolean":
      case "number":
      case "object":
        i += t3[o].toString();
        break;
      case "string":
        t3[o].substr(0, 1) !== "/" ? (n !== void 0 && e && (r = e.internal.getEncryptor(n)), i += "(" + na(r(t3[o].toString())) + ")") : i += t3[o].toString();
    }
    return i + "]";
  }
  throw new Error("Invalid argument passed to jsPDF.__acroform__.arrayToPdfArray");
}, Hl = function(t3, n, e) {
  var r = function(i) {
    return i;
  };
  return n !== void 0 && e && (r = e.internal.getEncryptor(n)), (t3 = t3 || "").toString(), "(" + na(r(t3)) + ")";
}, Pr = function() {
  this._objId = void 0, this._scope = void 0, Object.defineProperty(this, "objId", { get: function() {
    if (this._objId === void 0) {
      if (this.scope === void 0) return;
      this._objId = this.scope.internal.newObjectDeferred();
    }
    return this._objId;
  }, set: function(t3) {
    this._objId = t3;
  } }), Object.defineProperty(this, "scope", { value: this._scope, writable: true });
};
Pr.prototype.toString = function() {
  return this.objId + " 0 R";
}, Pr.prototype.putStream = function() {
  var t3 = this.getKeyValueListForStream();
  this.scope.internal.putStream({ data: this.stream, additionalKeyValues: t3, objectId: this.objId }), this.scope.internal.out("endobj");
}, Pr.prototype.getKeyValueListForStream = function() {
  var t3 = [], n = Object.getOwnPropertyNames(this).filter(function(o) {
    return o != "content" && o != "appearanceStreamContent" && o != "scope" && o != "objId" && o.substring(0, 1) != "_";
  });
  for (var e in n) if (Object.getOwnPropertyDescriptor(this, n[e]).configurable === false) {
    var r = n[e], i = this[r];
    i && (Array.isArray(i) ? t3.push({ key: r, value: Tf(i, this.objId, this.scope) }) : i instanceof Pr ? (i.scope = this.scope, t3.push({ key: r, value: i.objId + " 0 R" })) : typeof i != "function" && t3.push({ key: r, value: i }));
  }
  return t3;
};
var Rf = function() {
  Pr.call(this), Object.defineProperty(this, "Type", { value: "/XObject", configurable: false, writable: true }), Object.defineProperty(this, "Subtype", { value: "/Form", configurable: false, writable: true }), Object.defineProperty(this, "FormType", { value: 1, configurable: false, writable: true });
  var t3, n = [];
  Object.defineProperty(this, "BBox", { configurable: false, get: function() {
    return n;
  }, set: function(e) {
    n = e;
  } }), Object.defineProperty(this, "Resources", { value: "2 0 R", configurable: false, writable: true }), Object.defineProperty(this, "stream", { enumerable: false, configurable: true, set: function(e) {
    t3 = e.trim();
  }, get: function() {
    return t3 || null;
  } });
};
Bn(Rf, Pr);
var Mf = function() {
  Pr.call(this);
  var t3, n = [];
  Object.defineProperty(this, "Kids", { enumerable: false, configurable: true, get: function() {
    return n.length > 0 ? n : void 0;
  } }), Object.defineProperty(this, "Fields", { enumerable: false, configurable: false, get: function() {
    return n;
  } }), Object.defineProperty(this, "DA", { enumerable: false, configurable: false, get: function() {
    if (t3) {
      var e = function(r) {
        return r;
      };
      return this.scope && (e = this.scope.internal.getEncryptor(this.objId)), "(" + na(e(t3)) + ")";
    }
  }, set: function(e) {
    t3 = e;
  } });
};
Bn(Mf, Pr);
var mr = function t() {
  Pr.call(this);
  var n = 4;
  Object.defineProperty(this, "F", { enumerable: false, configurable: false, get: function() {
    return n;
  }, set: function(k) {
    if (isNaN(k)) throw new Error('Invalid value "' + k + '" for attribute F supplied.');
    n = k;
  } }), Object.defineProperty(this, "showWhenPrinted", { enumerable: true, configurable: true, get: function() {
    return !!tn(n, 3);
  }, set: function(k) {
    k ? this.F = en(n, 3) : this.F = nn(n, 3);
  } });
  var e = 0;
  Object.defineProperty(this, "Ff", { enumerable: false, configurable: false, get: function() {
    return e;
  }, set: function(k) {
    if (isNaN(k)) throw new Error('Invalid value "' + k + '" for attribute Ff supplied.');
    e = k;
  } });
  var r = [];
  Object.defineProperty(this, "Rect", { enumerable: false, configurable: false, get: function() {
    if (r.length !== 0) return r;
  }, set: function(k) {
    r = k !== void 0 ? k : [];
  } }), Object.defineProperty(this, "x", { enumerable: true, configurable: true, get: function() {
    return !r || isNaN(r[0]) ? 0 : r[0];
  }, set: function(k) {
    r[0] = k;
  } }), Object.defineProperty(this, "y", { enumerable: true, configurable: true, get: function() {
    return !r || isNaN(r[1]) ? 0 : r[1];
  }, set: function(k) {
    r[1] = k;
  } }), Object.defineProperty(this, "width", { enumerable: true, configurable: true, get: function() {
    return !r || isNaN(r[2]) ? 0 : r[2];
  }, set: function(k) {
    r[2] = k;
  } }), Object.defineProperty(this, "height", { enumerable: true, configurable: true, get: function() {
    return !r || isNaN(r[3]) ? 0 : r[3];
  }, set: function(k) {
    r[3] = k;
  } });
  var i = "";
  Object.defineProperty(this, "FT", { enumerable: true, configurable: false, get: function() {
    return i;
  }, set: function(k) {
    switch (k) {
      case "/Btn":
      case "/Tx":
      case "/Ch":
      case "/Sig":
        i = k;
        break;
      default:
        throw new Error('Invalid value "' + k + '" for attribute FT supplied.');
    }
  } });
  var o = null;
  Object.defineProperty(this, "T", { enumerable: true, configurable: false, get: function() {
    if (!o || o.length < 1) {
      if (this instanceof Ts) return;
      o = "FieldObject" + t.FieldNum++;
    }
    var k = function(V) {
      return V;
    };
    return this.scope && (k = this.scope.internal.getEncryptor(this.objId)), "(" + na(k(o)) + ")";
  }, set: function(k) {
    o = k.toString();
  } }), Object.defineProperty(this, "fieldName", { configurable: true, enumerable: true, get: function() {
    return o;
  }, set: function(k) {
    o = k;
  } });
  var u = "helvetica";
  Object.defineProperty(this, "fontName", { enumerable: true, configurable: true, get: function() {
    return u;
  }, set: function(k) {
    u = k;
  } });
  var l = "normal";
  Object.defineProperty(this, "fontStyle", { enumerable: true, configurable: true, get: function() {
    return l;
  }, set: function(k) {
    l = k;
  } });
  var f = 0;
  Object.defineProperty(this, "fontSize", { enumerable: true, configurable: true, get: function() {
    return f;
  }, set: function(k) {
    f = k;
  } });
  var c = void 0;
  Object.defineProperty(this, "maxFontSize", { enumerable: true, configurable: true, get: function() {
    return c === void 0 ? 50 / xh : c;
  }, set: function(k) {
    c = k;
  } });
  var p = "black";
  Object.defineProperty(this, "color", { enumerable: true, configurable: true, get: function() {
    return p;
  }, set: function(k) {
    p = k;
  } });
  var x = "/F1 0 Tf 0 g";
  Object.defineProperty(this, "DA", { enumerable: true, configurable: false, get: function() {
    if (!(!x || this instanceof Ts || this instanceof Xi)) return Hl(x, this.objId, this.scope);
  }, set: function(k) {
    k = k.toString(), x = k;
  } });
  var L = null;
  Object.defineProperty(this, "DV", { enumerable: false, configurable: false, get: function() {
    if (L) return this instanceof gn == 0 ? Hl(L, this.objId, this.scope) : L;
  }, set: function(k) {
    k = k.toString(), L = this instanceof gn == 0 ? k.substr(0, 1) === "(" ? ba(k.substr(1, k.length - 2)) : ba(k) : k;
  } }), Object.defineProperty(this, "defaultValue", { enumerable: true, configurable: true, get: function() {
    return this instanceof gn == 1 ? ba(L.substr(1, L.length - 1)) : L;
  }, set: function(k) {
    k = k.toString(), L = this instanceof gn == 1 ? "/" + k : k;
  } });
  var g = null;
  Object.defineProperty(this, "_V", { enumerable: false, configurable: false, get: function() {
    if (g) return g;
  }, set: function(k) {
    this.V = k;
  } }), Object.defineProperty(this, "V", { enumerable: false, configurable: false, get: function() {
    if (g) return this instanceof gn == 0 ? Hl(g, this.objId, this.scope) : g;
  }, set: function(k) {
    k = k.toString(), g = this instanceof gn == 0 ? k.substr(0, 1) === "(" ? ba(k.substr(1, k.length - 2)) : ba(k) : k;
  } }), Object.defineProperty(this, "value", { enumerable: true, configurable: true, get: function() {
    return this instanceof gn == 1 ? ba(g.substr(1, g.length - 1)) : g;
  }, set: function(k) {
    k = k.toString(), g = this instanceof gn == 1 ? "/" + k : k;
  } }), Object.defineProperty(this, "hasAnnotation", { enumerable: true, configurable: true, get: function() {
    return this.Rect;
  } }), Object.defineProperty(this, "Type", { enumerable: true, configurable: false, get: function() {
    return this.hasAnnotation ? "/Annot" : null;
  } }), Object.defineProperty(this, "Subtype", { enumerable: true, configurable: false, get: function() {
    return this.hasAnnotation ? "/Widget" : null;
  } });
  var O, P = false;
  Object.defineProperty(this, "hasAppearanceStream", { enumerable: true, configurable: true, get: function() {
    return P;
  }, set: function(k) {
    k = !!k, P = k;
  } }), Object.defineProperty(this, "page", { enumerable: true, configurable: true, get: function() {
    if (O) return O;
  }, set: function(k) {
    O = k;
  } }), Object.defineProperty(this, "readOnly", { enumerable: true, configurable: true, get: function() {
    return !!tn(this.Ff, 1);
  }, set: function(k) {
    k ? this.Ff = en(this.Ff, 1) : this.Ff = nn(this.Ff, 1);
  } }), Object.defineProperty(this, "required", { enumerable: true, configurable: true, get: function() {
    return !!tn(this.Ff, 2);
  }, set: function(k) {
    k ? this.Ff = en(this.Ff, 2) : this.Ff = nn(this.Ff, 2);
  } }), Object.defineProperty(this, "noExport", { enumerable: true, configurable: true, get: function() {
    return !!tn(this.Ff, 3);
  }, set: function(k) {
    k ? this.Ff = en(this.Ff, 3) : this.Ff = nn(this.Ff, 3);
  } });
  var M = null;
  Object.defineProperty(this, "Q", { enumerable: true, configurable: false, get: function() {
    if (M !== null) return M;
  }, set: function(k) {
    if ([0, 1, 2].indexOf(k) === -1) throw new Error('Invalid value "' + k + '" for attribute Q supplied.');
    M = k;
  } }), Object.defineProperty(this, "textAlign", { get: function() {
    var k;
    switch (M) {
      case 0:
      default:
        k = "left";
        break;
      case 1:
        k = "center";
        break;
      case 2:
        k = "right";
    }
    return k;
  }, configurable: true, enumerable: true, set: function(k) {
    switch (k) {
      case "right":
      case 2:
        M = 2;
        break;
      case "center":
      case 1:
        M = 1;
        break;
      default:
        M = 0;
    }
  } });
};
Bn(mr, Pr);
var La = function() {
  mr.call(this), this.FT = "/Ch", this.V = "()", this.fontName = "zapfdingbats";
  var t3 = 0;
  Object.defineProperty(this, "TI", { enumerable: true, configurable: false, get: function() {
    return t3;
  }, set: function(e) {
    t3 = e;
  } }), Object.defineProperty(this, "topIndex", { enumerable: true, configurable: true, get: function() {
    return t3;
  }, set: function(e) {
    t3 = e;
  } });
  var n = [];
  Object.defineProperty(this, "Opt", { enumerable: true, configurable: false, get: function() {
    return Tf(n, this.objId, this.scope);
  }, set: function(e) {
    var r, i;
    i = [], typeof (r = e) == "string" && (i = (function(o, u, l) {
      l || (l = 1);
      for (var f, c = []; f = u.exec(o); ) c.push(f[l]);
      return c;
    })(r, /\((.*?)\)/g)), n = i;
  } }), this.getOptions = function() {
    return n;
  }, this.setOptions = function(e) {
    n = e, this.sort && n.sort();
  }, this.addOption = function(e) {
    e = (e = e || "").toString(), n.push(e), this.sort && n.sort();
  }, this.removeOption = function(e, r) {
    for (r = r || false, e = (e = e || "").toString(); n.indexOf(e) !== -1 && (n.splice(n.indexOf(e), 1), r !== false); ) ;
  }, Object.defineProperty(this, "combo", { enumerable: true, configurable: true, get: function() {
    return !!tn(this.Ff, 18);
  }, set: function(e) {
    e ? this.Ff = en(this.Ff, 18) : this.Ff = nn(this.Ff, 18);
  } }), Object.defineProperty(this, "edit", { enumerable: true, configurable: true, get: function() {
    return !!tn(this.Ff, 19);
  }, set: function(e) {
    this.combo === true && (e ? this.Ff = en(this.Ff, 19) : this.Ff = nn(this.Ff, 19));
  } }), Object.defineProperty(this, "sort", { enumerable: true, configurable: true, get: function() {
    return !!tn(this.Ff, 20);
  }, set: function(e) {
    e ? (this.Ff = en(this.Ff, 20), n.sort()) : this.Ff = nn(this.Ff, 20);
  } }), Object.defineProperty(this, "multiSelect", { enumerable: true, configurable: true, get: function() {
    return !!tn(this.Ff, 22);
  }, set: function(e) {
    e ? this.Ff = en(this.Ff, 22) : this.Ff = nn(this.Ff, 22);
  } }), Object.defineProperty(this, "doNotSpellCheck", { enumerable: true, configurable: true, get: function() {
    return !!tn(this.Ff, 23);
  }, set: function(e) {
    e ? this.Ff = en(this.Ff, 23) : this.Ff = nn(this.Ff, 23);
  } }), Object.defineProperty(this, "commitOnSelChange", { enumerable: true, configurable: true, get: function() {
    return !!tn(this.Ff, 27);
  }, set: function(e) {
    e ? this.Ff = en(this.Ff, 27) : this.Ff = nn(this.Ff, 27);
  } }), this.hasAppearanceStream = false;
};
Bn(La, mr);
var Na = function() {
  La.call(this), this.fontName = "helvetica", this.combo = false;
};
Bn(Na, La);
var Sa = function() {
  Na.call(this), this.combo = true;
};
Bn(Sa, Na);
var Ns = function() {
  Sa.call(this), this.edit = true;
};
Bn(Ns, Sa);
var gn = function() {
  mr.call(this), this.FT = "/Btn", Object.defineProperty(this, "noToggleToOff", { enumerable: true, configurable: true, get: function() {
    return !!tn(this.Ff, 15);
  }, set: function(e) {
    e ? this.Ff = en(this.Ff, 15) : this.Ff = nn(this.Ff, 15);
  } }), Object.defineProperty(this, "radio", { enumerable: true, configurable: true, get: function() {
    return !!tn(this.Ff, 16);
  }, set: function(e) {
    e ? this.Ff = en(this.Ff, 16) : this.Ff = nn(this.Ff, 16);
  } }), Object.defineProperty(this, "pushButton", { enumerable: true, configurable: true, get: function() {
    return !!tn(this.Ff, 17);
  }, set: function(e) {
    e ? this.Ff = en(this.Ff, 17) : this.Ff = nn(this.Ff, 17);
  } }), Object.defineProperty(this, "radioIsUnison", { enumerable: true, configurable: true, get: function() {
    return !!tn(this.Ff, 26);
  }, set: function(e) {
    e ? this.Ff = en(this.Ff, 26) : this.Ff = nn(this.Ff, 26);
  } });
  var t3, n = {};
  Object.defineProperty(this, "MK", { enumerable: false, configurable: false, get: function() {
    var e = function(o) {
      return o;
    };
    if (this.scope && (e = this.scope.internal.getEncryptor(this.objId)), Object.keys(n).length !== 0) {
      var r, i = [];
      for (r in i.push("<<"), n) i.push("/" + r + " (" + na(e(n[r])) + ")");
      return i.push(">>"), i.join(`
`);
    }
  }, set: function(e) {
    Ce(e) === "object" && (n = e);
  } }), Object.defineProperty(this, "caption", { enumerable: true, configurable: true, get: function() {
    return n.CA || "";
  }, set: function(e) {
    typeof e == "string" && (n.CA = e);
  } }), Object.defineProperty(this, "AS", { enumerable: false, configurable: false, get: function() {
    return t3;
  }, set: function(e) {
    t3 = e;
  } }), Object.defineProperty(this, "appearanceState", { enumerable: true, configurable: true, get: function() {
    return t3.substr(1, t3.length - 1);
  }, set: function(e) {
    t3 = "/" + e;
  } });
};
Bn(gn, mr);
var Ss = function() {
  gn.call(this), this.pushButton = true;
};
Bn(Ss, gn);
var ka = function() {
  gn.call(this), this.radio = true, this.pushButton = false;
  var t3 = [];
  Object.defineProperty(this, "Kids", { enumerable: true, configurable: false, get: function() {
    return t3;
  }, set: function(n) {
    t3 = n !== void 0 ? n : [];
  } });
};
Bn(ka, gn);
var Ts = function() {
  var t3, n;
  mr.call(this), Object.defineProperty(this, "Parent", { enumerable: false, configurable: false, get: function() {
    return t3;
  }, set: function(i) {
    t3 = i;
  } }), Object.defineProperty(this, "optionName", { enumerable: false, configurable: true, get: function() {
    return n;
  }, set: function(i) {
    n = i;
  } });
  var e, r = {};
  Object.defineProperty(this, "MK", { enumerable: false, configurable: false, get: function() {
    var i = function(l) {
      return l;
    };
    this.scope && (i = this.scope.internal.getEncryptor(this.objId));
    var o, u = [];
    for (o in u.push("<<"), r) u.push("/" + o + " (" + na(i(r[o])) + ")");
    return u.push(">>"), u.join(`
`);
  }, set: function(i) {
    Ce(i) === "object" && (r = i);
  } }), Object.defineProperty(this, "caption", { enumerable: true, configurable: true, get: function() {
    return r.CA || "";
  }, set: function(i) {
    typeof i == "string" && (r.CA = i);
  } }), Object.defineProperty(this, "AS", { enumerable: false, configurable: false, get: function() {
    return e;
  }, set: function(i) {
    e = i;
  } }), Object.defineProperty(this, "appearanceState", { enumerable: true, configurable: true, get: function() {
    return e.substr(1, e.length - 1);
  }, set: function(i) {
    e = "/" + i;
  } }), this.caption = "l", this.appearanceState = "Off", this._AppearanceType = Et.RadioButton.Circle, this.appearanceStreamContent = this._AppearanceType.createAppearanceStream(this.optionName);
};
Bn(Ts, mr), ka.prototype.setAppearance = function(t3) {
  if (!("createAppearanceStream" in t3) || !("getCA" in t3)) throw new Error("Couldn't assign Appearance to RadioButton. Appearance was Invalid!");
  for (var n in this.Kids) if (this.Kids.hasOwnProperty(n)) {
    var e = this.Kids[n];
    e.appearanceStreamContent = t3.createAppearanceStream(e.optionName), e.caption = t3.getCA();
  }
}, ka.prototype.createOption = function(t3) {
  var n = new Ts();
  return n.Parent = this, n.optionName = t3, this.Kids.push(n), hd.call(this.scope, n), n;
};
var ks = function() {
  gn.call(this), this.fontName = "zapfdingbats", this.caption = "3", this.appearanceState = "On", this.value = "On", this.textAlign = "center", this.appearanceStreamContent = Et.CheckBox.createAppearanceStream();
};
Bn(ks, gn);
var Xi = function() {
  mr.call(this), this.FT = "/Tx", Object.defineProperty(this, "multiline", { enumerable: true, configurable: true, get: function() {
    return !!tn(this.Ff, 13);
  }, set: function(n) {
    n ? this.Ff = en(this.Ff, 13) : this.Ff = nn(this.Ff, 13);
  } }), Object.defineProperty(this, "fileSelect", { enumerable: true, configurable: true, get: function() {
    return !!tn(this.Ff, 21);
  }, set: function(n) {
    n ? this.Ff = en(this.Ff, 21) : this.Ff = nn(this.Ff, 21);
  } }), Object.defineProperty(this, "doNotSpellCheck", { enumerable: true, configurable: true, get: function() {
    return !!tn(this.Ff, 23);
  }, set: function(n) {
    n ? this.Ff = en(this.Ff, 23) : this.Ff = nn(this.Ff, 23);
  } }), Object.defineProperty(this, "doNotScroll", { enumerable: true, configurable: true, get: function() {
    return !!tn(this.Ff, 24);
  }, set: function(n) {
    n ? this.Ff = en(this.Ff, 24) : this.Ff = nn(this.Ff, 24);
  } }), Object.defineProperty(this, "comb", { enumerable: true, configurable: true, get: function() {
    return !!tn(this.Ff, 25);
  }, set: function(n) {
    n ? this.Ff = en(this.Ff, 25) : this.Ff = nn(this.Ff, 25);
  } }), Object.defineProperty(this, "richText", { enumerable: true, configurable: true, get: function() {
    return !!tn(this.Ff, 26);
  }, set: function(n) {
    n ? this.Ff = en(this.Ff, 26) : this.Ff = nn(this.Ff, 26);
  } });
  var t3 = null;
  Object.defineProperty(this, "MaxLen", { enumerable: true, configurable: false, get: function() {
    return t3;
  }, set: function(n) {
    t3 = n;
  } }), Object.defineProperty(this, "maxLength", { enumerable: true, configurable: true, get: function() {
    return t3;
  }, set: function(n) {
    Number.isInteger(n) && (t3 = n);
  } }), Object.defineProperty(this, "hasAppearanceStream", { enumerable: true, configurable: true, get: function() {
    return this.V || this.DV;
  } });
};
Bn(Xi, mr);
var Ps = function() {
  Xi.call(this), Object.defineProperty(this, "password", { enumerable: true, configurable: true, get: function() {
    return !!tn(this.Ff, 14);
  }, set: function(t3) {
    t3 ? this.Ff = en(this.Ff, 14) : this.Ff = nn(this.Ff, 14);
  } }), this.password = true;
};
Bn(Ps, Xi);
var Et = { CheckBox: { createAppearanceStream: function() {
  return { N: { On: Et.CheckBox.YesNormal }, D: { On: Et.CheckBox.YesPushDown, Off: Et.CheckBox.OffPushDown } };
}, YesPushDown: function(t3) {
  var n = Sr(t3);
  n.scope = t3.scope;
  var e = [], r = t3.scope.internal.getFont(t3.fontName, t3.fontStyle).id, i = t3.scope.__private__.encodeColorString(t3.color), o = hh(t3, t3.caption);
  return e.push("0.749023 g"), e.push("0 0 " + te(Et.internal.getWidth(t3)) + " " + te(Et.internal.getHeight(t3)) + " re"), e.push("f"), e.push("BMC"), e.push("q"), e.push("0 0 1 rg"), e.push("/" + r + " " + te(o.fontSize) + " Tf " + i), e.push("BT"), e.push(o.text), e.push("ET"), e.push("Q"), e.push("EMC"), n.stream = e.join(`
`), n;
}, YesNormal: function(t3) {
  var n = Sr(t3);
  n.scope = t3.scope;
  var e = t3.scope.internal.getFont(t3.fontName, t3.fontStyle).id, r = t3.scope.__private__.encodeColorString(t3.color), i = [], o = Et.internal.getHeight(t3), u = Et.internal.getWidth(t3), l = hh(t3, t3.caption);
  return i.push("1 g"), i.push("0 0 " + te(u) + " " + te(o) + " re"), i.push("f"), i.push("q"), i.push("0 0 1 rg"), i.push("0 0 " + te(u - 1) + " " + te(o - 1) + " re"), i.push("W"), i.push("n"), i.push("0 g"), i.push("BT"), i.push("/" + e + " " + te(l.fontSize) + " Tf " + r), i.push(l.text), i.push("ET"), i.push("Q"), n.stream = i.join(`
`), n;
}, OffPushDown: function(t3) {
  var n = Sr(t3);
  n.scope = t3.scope;
  var e = [];
  return e.push("0.749023 g"), e.push("0 0 " + te(Et.internal.getWidth(t3)) + " " + te(Et.internal.getHeight(t3)) + " re"), e.push("f"), n.stream = e.join(`
`), n;
} }, RadioButton: { Circle: { createAppearanceStream: function(t3) {
  var n = { D: { Off: Et.RadioButton.Circle.OffPushDown }, N: {} };
  return n.N[t3] = Et.RadioButton.Circle.YesNormal, n.D[t3] = Et.RadioButton.Circle.YesPushDown, n;
}, getCA: function() {
  return "l";
}, YesNormal: function(t3) {
  var n = Sr(t3);
  n.scope = t3.scope;
  var e = [], r = Et.internal.getWidth(t3) <= Et.internal.getHeight(t3) ? Et.internal.getWidth(t3) / 4 : Et.internal.getHeight(t3) / 4;
  r = Number((0.9 * r).toFixed(5));
  var i = Et.internal.Bezier_C, o = Number((r * i).toFixed(5));
  return e.push("q"), e.push("1 0 0 1 " + pi(Et.internal.getWidth(t3) / 2) + " " + pi(Et.internal.getHeight(t3) / 2) + " cm"), e.push(r + " 0 m"), e.push(r + " " + o + " " + o + " " + r + " 0 " + r + " c"), e.push("-" + o + " " + r + " -" + r + " " + o + " -" + r + " 0 c"), e.push("-" + r + " -" + o + " -" + o + " -" + r + " 0 -" + r + " c"), e.push(o + " -" + r + " " + r + " -" + o + " " + r + " 0 c"), e.push("f"), e.push("Q"), n.stream = e.join(`
`), n;
}, YesPushDown: function(t3) {
  var n = Sr(t3);
  n.scope = t3.scope;
  var e = [], r = Et.internal.getWidth(t3) <= Et.internal.getHeight(t3) ? Et.internal.getWidth(t3) / 4 : Et.internal.getHeight(t3) / 4;
  r = Number((0.9 * r).toFixed(5));
  var i = Number((2 * r).toFixed(5)), o = Number((i * Et.internal.Bezier_C).toFixed(5)), u = Number((r * Et.internal.Bezier_C).toFixed(5));
  return e.push("0.749023 g"), e.push("q"), e.push("1 0 0 1 " + pi(Et.internal.getWidth(t3) / 2) + " " + pi(Et.internal.getHeight(t3) / 2) + " cm"), e.push(i + " 0 m"), e.push(i + " " + o + " " + o + " " + i + " 0 " + i + " c"), e.push("-" + o + " " + i + " -" + i + " " + o + " -" + i + " 0 c"), e.push("-" + i + " -" + o + " -" + o + " -" + i + " 0 -" + i + " c"), e.push(o + " -" + i + " " + i + " -" + o + " " + i + " 0 c"), e.push("f"), e.push("Q"), e.push("0 g"), e.push("q"), e.push("1 0 0 1 " + pi(Et.internal.getWidth(t3) / 2) + " " + pi(Et.internal.getHeight(t3) / 2) + " cm"), e.push(r + " 0 m"), e.push(r + " " + u + " " + u + " " + r + " 0 " + r + " c"), e.push("-" + u + " " + r + " -" + r + " " + u + " -" + r + " 0 c"), e.push("-" + r + " -" + u + " -" + u + " -" + r + " 0 -" + r + " c"), e.push(u + " -" + r + " " + r + " -" + u + " " + r + " 0 c"), e.push("f"), e.push("Q"), n.stream = e.join(`
`), n;
}, OffPushDown: function(t3) {
  var n = Sr(t3);
  n.scope = t3.scope;
  var e = [], r = Et.internal.getWidth(t3) <= Et.internal.getHeight(t3) ? Et.internal.getWidth(t3) / 4 : Et.internal.getHeight(t3) / 4;
  r = Number((0.9 * r).toFixed(5));
  var i = Number((2 * r).toFixed(5)), o = Number((i * Et.internal.Bezier_C).toFixed(5));
  return e.push("0.749023 g"), e.push("q"), e.push("1 0 0 1 " + pi(Et.internal.getWidth(t3) / 2) + " " + pi(Et.internal.getHeight(t3) / 2) + " cm"), e.push(i + " 0 m"), e.push(i + " " + o + " " + o + " " + i + " 0 " + i + " c"), e.push("-" + o + " " + i + " -" + i + " " + o + " -" + i + " 0 c"), e.push("-" + i + " -" + o + " -" + o + " -" + i + " 0 -" + i + " c"), e.push(o + " -" + i + " " + i + " -" + o + " " + i + " 0 c"), e.push("f"), e.push("Q"), n.stream = e.join(`
`), n;
} }, Cross: { createAppearanceStream: function(t3) {
  var n = { D: { Off: Et.RadioButton.Cross.OffPushDown }, N: {} };
  return n.N[t3] = Et.RadioButton.Cross.YesNormal, n.D[t3] = Et.RadioButton.Cross.YesPushDown, n;
}, getCA: function() {
  return "8";
}, YesNormal: function(t3) {
  var n = Sr(t3);
  n.scope = t3.scope;
  var e = [], r = Et.internal.calculateCross(t3);
  return e.push("q"), e.push("1 1 " + te(Et.internal.getWidth(t3) - 2) + " " + te(Et.internal.getHeight(t3) - 2) + " re"), e.push("W"), e.push("n"), e.push(te(r.x1.x) + " " + te(r.x1.y) + " m"), e.push(te(r.x2.x) + " " + te(r.x2.y) + " l"), e.push(te(r.x4.x) + " " + te(r.x4.y) + " m"), e.push(te(r.x3.x) + " " + te(r.x3.y) + " l"), e.push("s"), e.push("Q"), n.stream = e.join(`
`), n;
}, YesPushDown: function(t3) {
  var n = Sr(t3);
  n.scope = t3.scope;
  var e = Et.internal.calculateCross(t3), r = [];
  return r.push("0.749023 g"), r.push("0 0 " + te(Et.internal.getWidth(t3)) + " " + te(Et.internal.getHeight(t3)) + " re"), r.push("f"), r.push("q"), r.push("1 1 " + te(Et.internal.getWidth(t3) - 2) + " " + te(Et.internal.getHeight(t3) - 2) + " re"), r.push("W"), r.push("n"), r.push(te(e.x1.x) + " " + te(e.x1.y) + " m"), r.push(te(e.x2.x) + " " + te(e.x2.y) + " l"), r.push(te(e.x4.x) + " " + te(e.x4.y) + " m"), r.push(te(e.x3.x) + " " + te(e.x3.y) + " l"), r.push("s"), r.push("Q"), n.stream = r.join(`
`), n;
}, OffPushDown: function(t3) {
  var n = Sr(t3);
  n.scope = t3.scope;
  var e = [];
  return e.push("0.749023 g"), e.push("0 0 " + te(Et.internal.getWidth(t3)) + " " + te(Et.internal.getHeight(t3)) + " re"), e.push("f"), n.stream = e.join(`
`), n;
} } }, createDefaultAppearanceStream: function(t3) {
  var n = t3.scope.internal.getFont(t3.fontName, t3.fontStyle).id, e = t3.scope.__private__.encodeColorString(t3.color);
  return "/" + n + " " + t3.fontSize + " Tf " + e;
} };
Et.internal = { Bezier_C: 0.551915024494, calculateCross: function(t3) {
  var n = Et.internal.getWidth(t3), e = Et.internal.getHeight(t3), r = Math.min(n, e);
  return { x1: { x: (n - r) / 2, y: (e - r) / 2 + r }, x2: { x: (n - r) / 2 + r, y: (e - r) / 2 }, x3: { x: (n - r) / 2, y: (e - r) / 2 }, x4: { x: (n - r) / 2 + r, y: (e - r) / 2 + r } };
} }, Et.internal.getWidth = function(t3) {
  var n = 0;
  return Ce(t3) === "object" && (n = gc(t3.Rect[2])), n;
}, Et.internal.getHeight = function(t3) {
  var n = 0;
  return Ce(t3) === "object" && (n = gc(t3.Rect[3])), n;
};
var hd = Ze.addField = function(t3) {
  if (ld(this, t3), !(t3 instanceof mr)) throw new Error("Invalid argument passed to jsPDF.addField.");
  var n;
  return (n = t3).scope.internal.acroformPlugin.printedOut && (n.scope.internal.acroformPlugin.printedOut = false, n.scope.internal.acroformPlugin.acroFormDictionaryRoot = null), n.scope.internal.acroformPlugin.acroFormDictionaryRoot.Fields.push(n), t3.page = t3.scope.internal.getCurrentPageInfo().pageNumber, this;
};
Ze.AcroFormChoiceField = La, Ze.AcroFormListBox = Na, Ze.AcroFormComboBox = Sa, Ze.AcroFormEditBox = Ns, Ze.AcroFormButton = gn, Ze.AcroFormPushButton = Ss, Ze.AcroFormRadioButton = ka, Ze.AcroFormCheckBox = ks, Ze.AcroFormTextField = Xi, Ze.AcroFormPasswordField = Ps, Ze.AcroFormAppearance = Et, Ze.AcroForm = { ChoiceField: La, ListBox: Na, ComboBox: Sa, EditBox: Ns, Button: gn, PushButton: Ss, RadioButton: ka, CheckBox: ks, TextField: Xi, PasswordField: Ps, Appearance: Et }, jt.AcroForm = { ChoiceField: La, ListBox: Na, ComboBox: Sa, EditBox: Ns, Button: gn, PushButton: Ss, RadioButton: ka, CheckBox: ks, TextField: Xi, PasswordField: Ps, Appearance: Et };
function Bf(t3) {
  return t3.reduce(function(n, e, r) {
    return n[e] = r, n;
  }, {});
}
(function(t3) {
  var n = "addImage_";
  t3.__addimage__ = {};
  var e = "UNKNOWN", r = { PNG: [[137, 80, 78, 71]], TIFF: [[77, 77, 0, 42], [73, 73, 42, 0]], JPEG: [[255, 216, 255, 224, void 0, void 0, 74, 70, 73, 70, 0], [255, 216, 255, 225, void 0, void 0, 69, 120, 105, 102, 0, 0], [255, 216, 255, 219], [255, 216, 255, 238]], JPEG2000: [[0, 0, 0, 12, 106, 80, 32, 32]], GIF87a: [[71, 73, 70, 56, 55, 97]], GIF89a: [[71, 73, 70, 56, 57, 97]], WEBP: [[82, 73, 70, 70, void 0, void 0, void 0, void 0, 87, 69, 66, 80]], BMP: [[66, 77], [66, 65], [67, 73], [67, 80], [73, 67], [80, 84]] }, i = t3.__addimage__.getImageFileTypeByImageData = function(N, C) {
    var z, q, rt, st, ht, tt = e;
    if ((C = C || e) === "RGBA" || N.data !== void 0 && N.data instanceof Uint8ClampedArray && "height" in N && "width" in N) return "RGBA";
    if (bt(N)) for (ht in r) for (rt = r[ht], z = 0; z < rt.length; z += 1) {
      for (st = true, q = 0; q < rt[z].length; q += 1) if (rt[z][q] !== void 0 && rt[z][q] !== N[q]) {
        st = false;
        break;
      }
      if (st === true) {
        tt = ht;
        break;
      }
    }
    else for (ht in r) for (rt = r[ht], z = 0; z < rt.length; z += 1) {
      for (st = true, q = 0; q < rt[z].length; q += 1) if (rt[z][q] !== void 0 && rt[z][q] !== N.charCodeAt(q)) {
        st = false;
        break;
      }
      if (st === true) {
        tt = ht;
        break;
      }
    }
    return tt === e && C !== e && (tt = C), tt;
  }, o = function N(C) {
    for (var z = this.internal.write, q = this.internal.putStream, rt = (0, this.internal.getFilters)(); rt.indexOf("FlateEncode") !== -1; ) rt.splice(rt.indexOf("FlateEncode"), 1);
    C.objectId = this.internal.newObject();
    var st = [];
    if (st.push({ key: "Type", value: "/XObject" }), st.push({ key: "Subtype", value: "/Image" }), st.push({ key: "Width", value: C.width }), st.push({ key: "Height", value: C.height }), C.colorSpace === k.INDEXED ? st.push({ key: "ColorSpace", value: "[/Indexed /DeviceRGB " + (C.palette.length / 3 - 1) + " " + ("sMask" in C && C.sMask !== void 0 ? C.objectId + 2 : C.objectId + 1) + " 0 R]" }) : (st.push({ key: "ColorSpace", value: "/" + C.colorSpace }), C.colorSpace === k.DEVICE_CMYK && st.push({ key: "Decode", value: "[1 0 1 0 1 0 1 0]" })), st.push({ key: "BitsPerComponent", value: C.bitsPerComponent }), "decodeParameters" in C && C.decodeParameters !== void 0 && st.push({ key: "DecodeParms", value: "<<" + C.decodeParameters + ">>" }), "transparency" in C && Array.isArray(C.transparency) && C.transparency.length > 0) {
      for (var ht = "", tt = 0, ft = C.transparency.length; tt < ft; tt++) ht += C.transparency[tt] + " " + C.transparency[tt] + " ";
      st.push({ key: "Mask", value: "[" + ht + "]" });
    }
    C.sMask !== void 0 && st.push({ key: "SMask", value: C.objectId + 1 + " 0 R" });
    var Lt = C.filter !== void 0 ? ["/" + C.filter] : void 0;
    if (q({ data: C.data, additionalKeyValues: st, alreadyAppliedFilters: Lt, objectId: C.objectId }), z("endobj"), "sMask" in C && C.sMask !== void 0) {
      var lt, _ = (lt = C.sMaskBitsPerComponent) !== null && lt !== void 0 ? lt : C.bitsPerComponent, T = { width: C.width, height: C.height, colorSpace: "DeviceGray", bitsPerComponent: _, data: C.sMask };
      "filter" in C && (T.decodeParameters = "/Predictor ".concat(C.predictor, " /Colors 1 /BitsPerComponent ").concat(_, " /Columns ").concat(C.width), T.filter = C.filter), N.call(this, T);
    }
    if (C.colorSpace === k.INDEXED) {
      var B = this.internal.newObject();
      q({ data: $(new Uint8Array(C.palette)), objectId: B }), z("endobj");
    }
  }, u = function() {
    var N = this.internal.collections[n + "images"];
    for (var C in N) o.call(this, N[C]);
  }, l = function() {
    var N, C = this.internal.collections[n + "images"], z = this.internal.write;
    for (var q in C) z("/I" + (N = C[q]).index, N.objectId, "0", "R");
  }, f = function() {
    this.internal.collections[n + "images"] || (this.internal.collections[n + "images"] = {}, this.internal.events.subscribe("putResources", u), this.internal.events.subscribe("putXobjectDict", l));
  }, c = function() {
    var N = this.internal.collections[n + "images"];
    return f.call(this), N;
  }, p = function() {
    return Object.keys(this.internal.collections[n + "images"]).length;
  }, x = function(N) {
    return typeof t3["process" + N.toUpperCase()] == "function";
  }, L = function(N) {
    return Ce(N) === "object" && N.nodeType === 1;
  }, g = function(N, C) {
    if (N.nodeName === "IMG" && N.hasAttribute("src")) {
      var z = "" + N.getAttribute("src");
      if (z.indexOf("data:image/") === 0) return Ls(unescape(z).split("base64,").pop());
      var q = t3.loadFile(z, true);
      if (q !== void 0) return q;
    }
    if (N.nodeName === "CANVAS") {
      if (N.width === 0 || N.height === 0) throw new Error("Given canvas must have data. Canvas width: " + N.width + ", height: " + N.height);
      var rt;
      switch (C) {
        case "PNG":
          rt = "image/png";
          break;
        case "WEBP":
          rt = "image/webp";
          break;
        default:
          rt = "image/jpeg";
      }
      return Ls(N.toDataURL(rt, 1).split("base64,").pop());
    }
  }, O = function(N) {
    var C = this.internal.collections[n + "images"];
    if (C) {
      for (var z in C) if (N === C[z].alias) return C[z];
    }
  }, P = function(N, C, z) {
    return N || C || (N = -96, C = -96), N < 0 && (N = -1 * z.width * 72 / N / this.internal.scaleFactor), C < 0 && (C = -1 * z.height * 72 / C / this.internal.scaleFactor), N === 0 && (N = C * z.width / z.height), C === 0 && (C = N * z.height / z.width), [N, C];
  }, M = function(N, C, z, q, rt, st) {
    var ht = P.call(this, z, q, rt), tt = this.internal.getCoordinateString, ft = this.internal.getVerticalCoordinateString, Lt = c.call(this);
    if (z = ht[0], q = ht[1], Lt[rt.index] = rt, st) {
      st *= Math.PI / 180;
      var lt = Math.cos(st), _ = Math.sin(st), T = function(H) {
        return H.toFixed(4);
      }, B = [T(lt), T(_), T(-1 * _), T(lt), 0, 0, "cm"];
    }
    this.internal.write("q"), st ? (this.internal.write([1, "0", "0", 1, tt(N), ft(C + q), "cm"].join(" ")), this.internal.write(B.join(" ")), this.internal.write([tt(z), "0", "0", tt(q), "0", "0", "cm"].join(" "))) : this.internal.write([tt(z), "0", "0", tt(q), tt(N), ft(C + q), "cm"].join(" ")), this.isAdvancedAPI() && this.internal.write([1, 0, 0, -1, 0, 0, "cm"].join(" ")), this.internal.write("/I" + rt.index + " Do"), this.internal.write("Q");
  }, k = t3.color_spaces = { DEVICE_RGB: "DeviceRGB", DEVICE_GRAY: "DeviceGray", DEVICE_CMYK: "DeviceCMYK", CAL_GREY: "CalGray", CAL_RGB: "CalRGB", LAB: "Lab", ICC_BASED: "ICCBased", INDEXED: "Indexed", PATTERN: "Pattern", SEPARATION: "Separation", DEVICE_N: "DeviceN" };
  t3.decode = { DCT_DECODE: "DCTDecode", FLATE_DECODE: "FlateDecode", LZW_DECODE: "LZWDecode", JPX_DECODE: "JPXDecode", JBIG2_DECODE: "JBIG2Decode", ASCII85_DECODE: "ASCII85Decode", ASCII_HEX_DECODE: "ASCIIHexDecode", RUN_LENGTH_DECODE: "RunLengthDecode", CCITT_FAX_DECODE: "CCITTFaxDecode" };
  var V = t3.image_compression = { NONE: "NONE", FAST: "FAST", MEDIUM: "MEDIUM", SLOW: "SLOW" }, G = t3.__addimage__.sHashCode = function(N) {
    var C, z, q = 0;
    if (typeof N == "string") for (z = N.length, C = 0; C < z; C++) q = (q << 5) - q + N.charCodeAt(C), q |= 0;
    else if (bt(N)) for (z = N.byteLength / 2, C = 0; C < z; C++) q = (q << 5) - q + N[C], q |= 0;
    return q;
  }, D = t3.__addimage__.validateStringAsBase64 = function(N) {
    (N = N || "").toString().trim();
    var C = true;
    return N.length === 0 && (C = false), N.length % 4 != 0 && (C = false), /^[A-Za-z0-9+/]+$/.test(N.substr(0, N.length - 2)) === false && (C = false), /^[A-Za-z0-9/][A-Za-z0-9+/]|[A-Za-z0-9+/]=|==$/.test(N.substr(-2)) === false && (C = false), C;
  }, it = t3.__addimage__.extractImageFromDataUrl = function(N) {
    if (N == null || !(N = N.trim()).startsWith("data:")) return null;
    var C = N.indexOf(",");
    return C < 0 ? null : N.substring(0, C).trim().endsWith("base64") ? N.substring(C + 1) : null;
  };
  t3.__addimage__.isArrayBuffer = function(N) {
    return N instanceof ArrayBuffer;
  };
  var bt = t3.__addimage__.isArrayBufferView = function(N) {
    return N instanceof Int8Array || N instanceof Uint8Array || N instanceof Uint8ClampedArray || N instanceof Int16Array || N instanceof Uint16Array || N instanceof Int32Array || N instanceof Uint32Array || N instanceof Float32Array || N instanceof Float64Array;
  }, dt = t3.__addimage__.binaryStringToUint8Array = function(N) {
    for (var C = N.length, z = new Uint8Array(C), q = 0; q < C; q++) z[q] = N.charCodeAt(q);
    return z;
  }, $ = t3.__addimage__.arrayBufferToBinaryString = function(N) {
    for (var C = "", z = bt(N) ? N : new Uint8Array(N), q = 0; q < z.length; q += 8192) C += String.fromCharCode.apply(null, z.subarray(q, q + 8192));
    return C;
  };
  t3.addImage = function() {
    var N, C, z, q, rt, st, ht, tt, ft;
    if (typeof arguments[1] == "number" ? (C = e, z = arguments[1], q = arguments[2], rt = arguments[3], st = arguments[4], ht = arguments[5], tt = arguments[6], ft = arguments[7]) : (C = arguments[1], z = arguments[2], q = arguments[3], rt = arguments[4], st = arguments[5], ht = arguments[6], tt = arguments[7], ft = arguments[8]), Ce(N = arguments[0]) === "object" && !L(N) && "imageData" in N) {
      var Lt = N;
      N = Lt.imageData, C = Lt.format || C || e, z = Lt.x || z || 0, q = Lt.y || q || 0, rt = Lt.w || Lt.width || rt, st = Lt.h || Lt.height || st, ht = Lt.alias || ht, tt = Lt.compression || tt, ft = Lt.rotation || Lt.angle || ft;
    }
    var lt = this.internal.getFilters();
    if (tt === void 0 && lt.indexOf("FlateEncode") !== -1 && (tt = "SLOW"), isNaN(z) || isNaN(q)) throw new Error("Invalid coordinates passed to jsPDF.addImage");
    f.call(this);
    var _ = j.call(this, N, C, ht, tt);
    return M.call(this, z, q, rt, st, _, ft), this;
  };
  var j = function(N, C, z, q) {
    var rt, st, ht;
    if (typeof N == "string" && i(N) === e) {
      N = unescape(N);
      var tt = J(N, false);
      (tt !== "" || (tt = t3.loadFile(N, true)) !== void 0) && (N = tt);
    }
    if (L(N) && (N = g(N, C)), C = i(N, C), !x(C)) throw new Error("addImage does not support files of type '" + C + "', please ensure that a plugin for '" + C + "' support is added.");
    if (((ht = z) == null || ht.length === 0) && (z = (function(ft) {
      return typeof ft == "string" || bt(ft) ? G(ft) : bt(ft.data) ? G(ft.data) : null;
    })(N)), (rt = O.call(this, z)) || (N instanceof Uint8Array || C === "RGBA" || (st = N, N = dt(N)), rt = this["process" + C.toUpperCase()](N, p.call(this), z, (function(ft) {
      return ft && typeof ft == "string" && (ft = ft.toUpperCase()), ft in t3.image_compression ? ft : V.NONE;
    })(q), st)), !rt) throw new Error("An unknown error occurred whilst processing the image.");
    return rt;
  }, J = t3.__addimage__.convertBase64ToBinaryString = function(N, C) {
    C = typeof C != "boolean" || C;
    var z, q = "";
    if (typeof N == "string") {
      var rt;
      z = (rt = it(N)) !== null && rt !== void 0 ? rt : N;
      try {
        q = Ls(z);
      } catch (st) {
        if (C) throw D(z) ? new Error("atob-Error in jsPDF.convertBase64ToBinaryString " + st.message) : new Error("Supplied Data is not a valid base64-String jsPDF.convertBase64ToBinaryString ");
      }
    }
    return q;
  };
  t3.getImageProperties = function(N) {
    var C, z, q = "";
    if (L(N) && (N = g(N)), typeof N == "string" && i(N) === e && ((q = J(N, false)) === "" && (q = t3.loadFile(N) || ""), N = q), z = i(N), !x(z)) throw new Error("addImage does not support files of type '" + z + "', please ensure that a plugin for '" + z + "' support is added.");
    if (N instanceof Uint8Array || (N = dt(N)), !(C = this["process" + z.toUpperCase()](N))) throw new Error("An unknown error occurred whilst processing the image");
    return C.fileType = z, C;
  };
})(jt.API), (function(t3) {
  var n = function(e) {
    if (e !== void 0 && e != "") return true;
  };
  jt.API.events.push(["addPage", function(e) {
    this.internal.getPageInfo(e.pageNumber).pageContext.annotations = [];
  }]), t3.events.push(["putPage", function(e) {
    for (var r, i, o, u = this.internal.getCoordinateString, l = this.internal.getVerticalCoordinateString, f = this.internal.getPageInfoByObjId(e.objId), c = e.pageContext.annotations, p = false, x = 0; x < c.length && !p; x++) switch ((r = c[x]).type) {
      case "link":
        (n(r.options.url) || n(r.options.pageNumber)) && (p = true);
        break;
      case "reference":
      case "text":
      case "freetext":
        p = true;
    }
    if (p != 0) {
      this.internal.write("/Annots [");
      for (var L = 0; L < c.length; L++) {
        r = c[L];
        var g = this.internal.pdfEscape, O = this.internal.getEncryptor(e.objId);
        switch (r.type) {
          case "reference":
            this.internal.write(" " + r.object.objId + " 0 R ");
            break;
          case "text":
            var P = this.internal.newAdditionalObject(), M = this.internal.newAdditionalObject(), k = this.internal.getEncryptor(P.objId), V = r.title || "Note";
            o = "<</Type /Annot /Subtype /Text " + (i = "/Rect [" + u(r.bounds.x) + " " + l(r.bounds.y + r.bounds.h) + " " + u(r.bounds.x + r.bounds.w) + " " + l(r.bounds.y) + "] ") + "/Contents (" + g(k(r.contents)) + ")", o += " /Popup " + M.objId + " 0 R", o += " /P " + f.objId + " 0 R", o += " /T (" + g(k(V)) + ") >>", P.content = o;
            var G = P.objId + " 0 R";
            o = "<</Type /Annot /Subtype /Popup " + (i = "/Rect [" + u(r.bounds.x + 30) + " " + l(r.bounds.y + r.bounds.h) + " " + u(r.bounds.x + r.bounds.w + 30) + " " + l(r.bounds.y) + "] ") + " /Parent " + G, r.open && (o += " /Open true"), o += " >>", M.content = o, this.internal.write(P.objId, "0 R", M.objId, "0 R");
            break;
          case "freetext":
            i = "/Rect [" + u(r.bounds.x) + " " + l(r.bounds.y) + " " + u(r.bounds.x + r.bounds.w) + " " + l(r.bounds.y + r.bounds.h) + "] ";
            var D = r.color || "#000000";
            o = "<</Type /Annot /Subtype /FreeText " + i + "/Contents (" + g(O(r.contents)) + ")", o += " /DS(font: Helvetica,sans-serif 12.0pt; text-align:left; color:#" + D + ")", o += " /Border [0 0 0]", o += " >>", this.internal.write(o);
            break;
          case "link":
            if (r.options.name) {
              var it = this.annotations._nameMap[r.options.name];
              r.options.pageNumber = it.page, r.options.top = it.y;
            } else r.options.top || (r.options.top = 0);
            if (i = "/Rect [" + r.finalBounds.x + " " + r.finalBounds.y + " " + r.finalBounds.w + " " + r.finalBounds.h + "] ", o = "", r.options.url) o = "<</Type /Annot /Subtype /Link " + i + "/Border [0 0 0] /A <</S /URI /URI (" + g(O(r.options.url)) + ") >>";
            else if (r.options.pageNumber) switch (o = "<</Type /Annot /Subtype /Link " + i + "/Border [0 0 0] /Dest [" + this.internal.getPageInfo(r.options.pageNumber).objId + " 0 R", r.options.magFactor = r.options.magFactor || "XYZ", r.options.magFactor) {
              case "Fit":
                o += " /Fit]";
                break;
              case "FitH":
                o += " /FitH " + r.options.top + "]";
                break;
              case "FitV":
                r.options.left = r.options.left || 0, o += " /FitV " + r.options.left + "]";
                break;
              default:
                var bt = l(r.options.top);
                r.options.left = r.options.left || 0, r.options.zoom === void 0 && (r.options.zoom = 0), o += " /XYZ " + r.options.left + " " + bt + " " + r.options.zoom + "]";
            }
            o != "" && (o += " >>", this.internal.write(o));
        }
      }
      this.internal.write("]");
    }
  }]), t3.createAnnotation = function(e) {
    var r = this.internal.getCurrentPageInfo();
    switch (e.type) {
      case "link":
        this.link(e.bounds.x, e.bounds.y, e.bounds.w, e.bounds.h, e);
        break;
      case "text":
      case "freetext":
        r.pageContext.annotations.push(e);
    }
  }, t3.link = function(e, r, i, o, u) {
    var l = this.internal.getCurrentPageInfo(), f = this.internal.getCoordinateString, c = this.internal.getVerticalCoordinateString;
    l.pageContext.annotations.push({ finalBounds: { x: f(e), y: c(r), w: f(e + i), h: c(r + o) }, options: u, type: "link" });
  }, t3.textWithLink = function(e, r, i, o) {
    var u, l, f = this.getTextWidth(e), c = this.internal.getLineHeight() / this.internal.scaleFactor;
    if (o.maxWidth !== void 0) {
      l = o.maxWidth;
      var p = this.splitTextToSize(e, l).length;
      u = Math.ceil(c * p);
    } else l = f, u = c;
    return this.text(e, r, i, o), i += 0.2 * c, o.align === "center" && (r -= f / 2), o.align === "right" && (r -= f), this.link(r, i - c, l, u, o), f;
  }, t3.getTextWidth = function(e) {
    var r = this.internal.getFontSize();
    return this.getStringUnitWidth(e) * r / this.internal.scaleFactor;
  };
})(jt.API), (function(t3) {
  var n = { 1569: [65152], 1570: [65153, 65154], 1571: [65155, 65156], 1572: [65157, 65158], 1573: [65159, 65160], 1574: [65161, 65162, 65163, 65164], 1575: [65165, 65166], 1576: [65167, 65168, 65169, 65170], 1577: [65171, 65172], 1578: [65173, 65174, 65175, 65176], 1579: [65177, 65178, 65179, 65180], 1580: [65181, 65182, 65183, 65184], 1581: [65185, 65186, 65187, 65188], 1582: [65189, 65190, 65191, 65192], 1583: [65193, 65194], 1584: [65195, 65196], 1585: [65197, 65198], 1586: [65199, 65200], 1587: [65201, 65202, 65203, 65204], 1588: [65205, 65206, 65207, 65208], 1589: [65209, 65210, 65211, 65212], 1590: [65213, 65214, 65215, 65216], 1591: [65217, 65218, 65219, 65220], 1592: [65221, 65222, 65223, 65224], 1593: [65225, 65226, 65227, 65228], 1594: [65229, 65230, 65231, 65232], 1601: [65233, 65234, 65235, 65236], 1602: [65237, 65238, 65239, 65240], 1603: [65241, 65242, 65243, 65244], 1604: [65245, 65246, 65247, 65248], 1605: [65249, 65250, 65251, 65252], 1606: [65253, 65254, 65255, 65256], 1607: [65257, 65258, 65259, 65260], 1608: [65261, 65262], 1609: [65263, 65264, 64488, 64489], 1610: [65265, 65266, 65267, 65268], 1649: [64336, 64337], 1655: [64477], 1657: [64358, 64359, 64360, 64361], 1658: [64350, 64351, 64352, 64353], 1659: [64338, 64339, 64340, 64341], 1662: [64342, 64343, 64344, 64345], 1663: [64354, 64355, 64356, 64357], 1664: [64346, 64347, 64348, 64349], 1667: [64374, 64375, 64376, 64377], 1668: [64370, 64371, 64372, 64373], 1670: [64378, 64379, 64380, 64381], 1671: [64382, 64383, 64384, 64385], 1672: [64392, 64393], 1676: [64388, 64389], 1677: [64386, 64387], 1678: [64390, 64391], 1681: [64396, 64397], 1688: [64394, 64395], 1700: [64362, 64363, 64364, 64365], 1702: [64366, 64367, 64368, 64369], 1705: [64398, 64399, 64400, 64401], 1709: [64467, 64468, 64469, 64470], 1711: [64402, 64403, 64404, 64405], 1713: [64410, 64411, 64412, 64413], 1715: [64406, 64407, 64408, 64409], 1722: [64414, 64415], 1723: [64416, 64417, 64418, 64419], 1726: [64426, 64427, 64428, 64429], 1728: [64420, 64421], 1729: [64422, 64423, 64424, 64425], 1733: [64480, 64481], 1734: [64473, 64474], 1735: [64471, 64472], 1736: [64475, 64476], 1737: [64482, 64483], 1739: [64478, 64479], 1740: [64508, 64509, 64510, 64511], 1744: [64484, 64485, 64486, 64487], 1746: [64430, 64431], 1747: [64432, 64433] }, e = { 65247: { 65154: 65269, 65156: 65271, 65160: 65273, 65166: 65275 }, 65248: { 65154: 65270, 65156: 65272, 65160: 65274, 65166: 65276 }, 65165: { 65247: { 65248: { 65258: 65010 } } }, 1617: { 1612: 64606, 1613: 64607, 1614: 64608, 1615: 64609, 1616: 64610 } }, r = { 1612: 64606, 1613: 64607, 1614: 64608, 1615: 64609, 1616: 64610 }, i = [1570, 1571, 1573, 1575];
  t3.__arabicParser__ = {};
  var o = t3.__arabicParser__.isInArabicSubstitutionA = function(P) {
    return n[P.charCodeAt(0)] !== void 0;
  }, u = t3.__arabicParser__.isArabicLetter = function(P) {
    return typeof P == "string" && /^[\u0600-\u06FF\u0750-\u077F\u08A0-\u08FF\uFB50-\uFDFF\uFE70-\uFEFF]+$/.test(P);
  }, l = t3.__arabicParser__.isArabicEndLetter = function(P) {
    return u(P) && o(P) && n[P.charCodeAt(0)].length <= 2;
  }, f = t3.__arabicParser__.isArabicAlfLetter = function(P) {
    return u(P) && i.indexOf(P.charCodeAt(0)) >= 0;
  };
  t3.__arabicParser__.arabicLetterHasIsolatedForm = function(P) {
    return u(P) && o(P) && n[P.charCodeAt(0)].length >= 1;
  };
  var c = t3.__arabicParser__.arabicLetterHasFinalForm = function(P) {
    return u(P) && o(P) && n[P.charCodeAt(0)].length >= 2;
  };
  t3.__arabicParser__.arabicLetterHasInitialForm = function(P) {
    return u(P) && o(P) && n[P.charCodeAt(0)].length >= 3;
  };
  var p = t3.__arabicParser__.arabicLetterHasMedialForm = function(P) {
    return u(P) && o(P) && n[P.charCodeAt(0)].length == 4;
  }, x = t3.__arabicParser__.resolveLigatures = function(P) {
    var M = 0, k = e, V = "", G = 0;
    for (M = 0; M < P.length; M += 1) k[P.charCodeAt(M)] !== void 0 ? (G++, typeof (k = k[P.charCodeAt(M)]) == "number" && (V += String.fromCharCode(k), k = e, G = 0), M === P.length - 1 && (k = e, V += P.charAt(M - (G - 1)), M -= G - 1, G = 0)) : (k = e, V += P.charAt(M - G), M -= G, G = 0);
    return V;
  };
  t3.__arabicParser__.isArabicDiacritic = function(P) {
    return P !== void 0 && r[P.charCodeAt(0)] !== void 0;
  };
  var L = t3.__arabicParser__.getCorrectForm = function(P, M, k) {
    return u(P) ? o(P) === false ? -1 : !c(P) || !u(M) && !u(k) || !u(k) && l(M) || l(P) && !u(M) || l(P) && f(M) || l(P) && l(M) ? 0 : p(P) && u(M) && !l(M) && u(k) && c(k) ? 3 : l(P) || !u(k) ? 1 : 2 : -1;
  }, g = function(P) {
    var M = 0, k = 0, V = 0, G = "", D = "", it = "", bt = (P = P || "").split("\\s+"), dt = [];
    for (M = 0; M < bt.length; M += 1) {
      for (dt.push(""), k = 0; k < bt[M].length; k += 1) G = bt[M][k], D = bt[M][k - 1], it = bt[M][k + 1], u(G) ? (V = L(G, D, it), dt[M] += V !== -1 ? String.fromCharCode(n[G.charCodeAt(0)][V]) : G) : dt[M] += G;
      dt[M] = x(dt[M]);
    }
    return dt.join(" ");
  }, O = t3.__arabicParser__.processArabic = t3.processArabic = function() {
    var P, M = typeof arguments[0] == "string" ? arguments[0] : arguments[0].text, k = [];
    if (Array.isArray(M)) {
      var V = 0;
      for (k = [], V = 0; V < M.length; V += 1) Array.isArray(M[V]) ? k.push([g(M[V][0]), M[V][1], M[V][2]]) : k.push([g(M[V])]);
      P = k;
    } else P = g(M);
    return typeof arguments[0] == "string" ? P : (arguments[0].text = P, arguments[0]);
  };
  t3.events.push(["preProcessText", O]);
})(jt.API), jt.API.autoPrint = function(t3) {
  var n;
  return (t3 = t3 || {}).variant = t3.variant || "non-conform", t3.variant === "javascript" ? this.addJS("print({});") : (this.internal.events.subscribe("postPutResources", function() {
    n = this.internal.newObject(), this.internal.out("<<"), this.internal.out("/S /Named"), this.internal.out("/Type /Action"), this.internal.out("/N /Print"), this.internal.out(">>"), this.internal.out("endobj");
  }), this.internal.events.subscribe("putCatalog", function() {
    this.internal.out("/OpenAction " + n + " 0 R");
  })), this;
}, (function(t3) {
  var n = function() {
    var e = void 0;
    Object.defineProperty(this, "pdf", { get: function() {
      return e;
    }, set: function(l) {
      e = l;
    } });
    var r = 150;
    Object.defineProperty(this, "width", { get: function() {
      return r;
    }, set: function(l) {
      r = isNaN(l) || Number.isInteger(l) === false || l < 0 ? 150 : l, this.getContext("2d").pageWrapXEnabled && (this.getContext("2d").pageWrapX = r + 1);
    } });
    var i = 300;
    Object.defineProperty(this, "height", { get: function() {
      return i;
    }, set: function(l) {
      i = isNaN(l) || Number.isInteger(l) === false || l < 0 ? 300 : l, this.getContext("2d").pageWrapYEnabled && (this.getContext("2d").pageWrapY = i + 1);
    } });
    var o = [];
    Object.defineProperty(this, "childNodes", { get: function() {
      return o;
    }, set: function(l) {
      o = l;
    } });
    var u = {};
    Object.defineProperty(this, "style", { get: function() {
      return u;
    }, set: function(l) {
      u = l;
    } }), Object.defineProperty(this, "parentNode", {});
  };
  n.prototype.getContext = function(e, r) {
    var i;
    if ((e = e || "2d") !== "2d") return null;
    for (i in r) this.pdf.context2d.hasOwnProperty(i) && (this.pdf.context2d[i] = r[i]);
    return this.pdf.context2d._canvas = this, this.pdf.context2d;
  }, n.prototype.toDataURL = function() {
    throw new Error("toDataURL is not implemented.");
  }, t3.events.push(["initialized", function() {
    this.canvas = new n(), this.canvas.pdf = this;
  }]);
})(jt.API), (function(t3) {
  var n = { left: 0, top: 0, bottom: 0, right: 0 }, e = false, r = function() {
    this.internal.__cell__ === void 0 && (this.internal.__cell__ = {}, this.internal.__cell__.padding = 3, this.internal.__cell__.headerFunction = void 0, this.internal.__cell__.margins = Object.assign({}, n), this.internal.__cell__.margins.width = this.getPageWidth(), i.call(this));
  }, i = function() {
    this.internal.__cell__.lastCell = new o(), this.internal.__cell__.pages = 1;
  }, o = function() {
    var f = arguments[0];
    Object.defineProperty(this, "x", { enumerable: true, get: function() {
      return f;
    }, set: function(P) {
      f = P;
    } });
    var c = arguments[1];
    Object.defineProperty(this, "y", { enumerable: true, get: function() {
      return c;
    }, set: function(P) {
      c = P;
    } });
    var p = arguments[2];
    Object.defineProperty(this, "width", { enumerable: true, get: function() {
      return p;
    }, set: function(P) {
      p = P;
    } });
    var x = arguments[3];
    Object.defineProperty(this, "height", { enumerable: true, get: function() {
      return x;
    }, set: function(P) {
      x = P;
    } });
    var L = arguments[4];
    Object.defineProperty(this, "text", { enumerable: true, get: function() {
      return L;
    }, set: function(P) {
      L = P;
    } });
    var g = arguments[5];
    Object.defineProperty(this, "lineNumber", { enumerable: true, get: function() {
      return g;
    }, set: function(P) {
      g = P;
    } });
    var O = arguments[6];
    return Object.defineProperty(this, "align", { enumerable: true, get: function() {
      return O;
    }, set: function(P) {
      O = P;
    } }), this;
  };
  o.prototype.clone = function() {
    return new o(this.x, this.y, this.width, this.height, this.text, this.lineNumber, this.align);
  }, o.prototype.toArray = function() {
    return [this.x, this.y, this.width, this.height, this.text, this.lineNumber, this.align];
  }, t3.setHeaderFunction = function(f) {
    return r.call(this), this.internal.__cell__.headerFunction = typeof f == "function" ? f : void 0, this;
  }, t3.getTextDimensions = function(f, c) {
    r.call(this);
    var p = (c = c || {}).fontSize || this.getFontSize(), x = c.font || this.getFont(), L = c.scaleFactor || this.internal.scaleFactor, g = 0, O = 0, P = 0, M = this;
    if (!Array.isArray(f) && typeof f != "string") {
      if (typeof f != "number") throw new Error("getTextDimensions expects text-parameter to be of type String or type Number or an Array of Strings.");
      f = String(f);
    }
    var k = c.maxWidth;
    k > 0 ? typeof f == "string" ? f = this.splitTextToSize(f, k) : Object.prototype.toString.call(f) === "[object Array]" && (f = f.reduce(function(G, D) {
      return G.concat(M.splitTextToSize(D, k));
    }, [])) : f = Array.isArray(f) ? f : [f];
    for (var V = 0; V < f.length; V++) g < (P = this.getStringUnitWidth(f[V], { font: x }) * p) && (g = P);
    return g !== 0 && (O = f.length), { w: g /= L, h: Math.max((O * p * this.getLineHeightFactor() - p * (this.getLineHeightFactor() - 1)) / L, 0) };
  }, t3.cellAddPage = function() {
    r.call(this), this.addPage();
    var f = this.internal.__cell__.margins || n;
    return this.internal.__cell__.lastCell = new o(f.left, f.top, void 0, void 0), this.internal.__cell__.pages += 1, this;
  };
  var u = t3.cell = function() {
    var f;
    f = arguments[0] instanceof o ? arguments[0] : new o(arguments[0], arguments[1], arguments[2], arguments[3], arguments[4], arguments[5]), r.call(this);
    var c = this.internal.__cell__.lastCell, p = this.internal.__cell__.padding, x = this.internal.__cell__.margins || n, L = this.internal.__cell__.tableHeaderRow, g = this.internal.__cell__.printHeaders;
    return c.lineNumber !== void 0 && (c.lineNumber === f.lineNumber ? (f.x = (c.x || 0) + (c.width || 0), f.y = c.y || 0) : c.y + c.height + f.height + x.bottom > this.getPageHeight() ? (this.cellAddPage(), f.y = x.top, g && L && (this.printHeaderRow(f.lineNumber, true), f.y += L[0].height)) : f.y = c.y + c.height || f.y), f.text[0] !== void 0 && (this.rect(f.x, f.y, f.width, f.height, e === true ? "FD" : void 0), f.align === "right" ? this.text(f.text, f.x + f.width - p, f.y + p, { align: "right", baseline: "top" }) : f.align === "center" ? this.text(f.text, f.x + f.width / 2, f.y + p, { align: "center", baseline: "top", maxWidth: f.width - p - p }) : this.text(f.text, f.x + p, f.y + p, { align: "left", baseline: "top", maxWidth: f.width - p - p })), this.internal.__cell__.lastCell = f, this;
  };
  t3.table = function(f, c, p, x, L) {
    if (r.call(this), !p) throw new Error("No data for PDF table.");
    var g, O, P, M, k = [], V = [], G = [], D = {}, it = {}, bt = [], dt = [], $ = (L = L || {}).autoSize || false, j = L.printHeaders !== false, J = L.css && L.css["font-size"] !== void 0 ? 16 * L.css["font-size"] : L.fontSize || 12, N = L.margins || Object.assign({ width: this.getPageWidth() }, n), C = typeof L.padding == "number" ? L.padding : 3, z = L.headerBackgroundColor || "#c8c8c8", q = L.headerTextColor || "#000";
    if (i.call(this), this.internal.__cell__.printHeaders = j, this.internal.__cell__.margins = N, this.internal.__cell__.table_font_size = J, this.internal.__cell__.padding = C, this.internal.__cell__.headerBackgroundColor = z, this.internal.__cell__.headerTextColor = q, this.setFontSize(J), x == null) V = k = Object.keys(p[0]), G = k.map(function() {
      return "left";
    });
    else if (Array.isArray(x) && Ce(x[0]) === "object") for (k = x.map(function(Lt) {
      return Lt.name;
    }), V = x.map(function(Lt) {
      return Lt.prompt || Lt.name || "";
    }), G = x.map(function(Lt) {
      return Lt.align || "left";
    }), g = 0; g < x.length; g += 1) it[x[g].name] = 0.7499990551181103 * x[g].width;
    else Array.isArray(x) && typeof x[0] == "string" && (V = k = x, G = k.map(function() {
      return "left";
    }));
    if ($ || Array.isArray(x) && typeof x[0] == "string") for (g = 0; g < k.length; g += 1) {
      for (D[M = k[g]] = p.map(function(Lt) {
        return Lt[M];
      }), this.setFont(void 0, "bold"), bt.push(this.getTextDimensions(V[g], { fontSize: this.internal.__cell__.table_font_size, scaleFactor: this.internal.scaleFactor }).w), O = D[M], this.setFont(void 0, "normal"), P = 0; P < O.length; P += 1) bt.push(this.getTextDimensions(O[P], { fontSize: this.internal.__cell__.table_font_size, scaleFactor: this.internal.scaleFactor }).w);
      it[M] = Math.max.apply(null, bt) + C + C, bt = [];
    }
    if (j) {
      var rt = {};
      for (g = 0; g < k.length; g += 1) rt[k[g]] = {}, rt[k[g]].text = V[g], rt[k[g]].align = G[g];
      var st = l.call(this, rt, it);
      dt = k.map(function(Lt) {
        return new o(f, c, it[Lt], st, rt[Lt].text, void 0, rt[Lt].align);
      }), this.setTableHeaderRow(dt), this.printHeaderRow(1, false);
    }
    var ht = x.reduce(function(Lt, lt) {
      return Lt[lt.name] = lt.align, Lt;
    }, {});
    for (g = 0; g < p.length; g += 1) {
      "rowStart" in L && L.rowStart instanceof Function && L.rowStart({ row: g, data: p[g] }, this);
      var tt = l.call(this, p[g], it);
      for (P = 0; P < k.length; P += 1) {
        var ft = p[g][k[P]];
        "cellStart" in L && L.cellStart instanceof Function && L.cellStart({ row: g, col: P, data: ft }, this), u.call(this, new o(f, c, it[k[P]], tt, ft, g + 2, ht[k[P]]));
      }
    }
    return this.internal.__cell__.table_x = f, this.internal.__cell__.table_y = c, this;
  };
  var l = function(f, c) {
    var p = this.internal.__cell__.padding, x = this.internal.__cell__.table_font_size, L = this.internal.scaleFactor;
    return Object.keys(f).map(function(g) {
      var O = f[g];
      return this.splitTextToSize(O.hasOwnProperty("text") ? O.text : O, c[g] - p - p);
    }, this).map(function(g) {
      return this.getLineHeightFactor() * g.length * x / L + p + p;
    }, this).reduce(function(g, O) {
      return Math.max(g, O);
    }, 0);
  };
  t3.setTableHeaderRow = function(f) {
    r.call(this), this.internal.__cell__.tableHeaderRow = f;
  }, t3.printHeaderRow = function(f, c) {
    if (r.call(this), !this.internal.__cell__.tableHeaderRow) throw new Error("Property tableHeaderRow does not exist.");
    var p;
    if (e = true, typeof this.internal.__cell__.headerFunction == "function") {
      var x = this.internal.__cell__.headerFunction(this, this.internal.__cell__.pages);
      this.internal.__cell__.lastCell = new o(x[0], x[1], x[2], x[3], void 0, -1);
    }
    this.setFont(void 0, "bold");
    for (var L = [], g = 0; g < this.internal.__cell__.tableHeaderRow.length; g += 1) {
      p = this.internal.__cell__.tableHeaderRow[g].clone(), c && (p.y = this.internal.__cell__.margins.top || 0, L.push(p)), p.lineNumber = f;
      var O = this.getTextColor();
      this.setTextColor(this.internal.__cell__.headerTextColor), this.setFillColor(this.internal.__cell__.headerBackgroundColor), u.call(this, p), this.setTextColor(O);
    }
    L.length > 0 && this.setTableHeaderRow(L), this.setFont(void 0, "normal"), e = false;
  };
})(jt.API);
var jf = { italic: ["italic", "oblique", "normal"], oblique: ["oblique", "italic", "normal"], normal: ["normal", "oblique", "italic"] }, Df = ["ultra-condensed", "extra-condensed", "condensed", "semi-condensed", "normal", "semi-expanded", "expanded", "extra-expanded", "ultra-expanded"], uh = Bf(Df), qf = [100, 200, 300, 400, 500, 600, 700, 800, 900], ud = Bf(qf);
function Wl(t3) {
  var n = t3.family.replace(/"|'/g, "").toLowerCase(), e = (function(o) {
    return jf[o = o || "normal"] ? o : "normal";
  })(t3.style), r = (function(o) {
    return o ? typeof o == "number" ? o >= 100 && o <= 900 && o % 100 == 0 ? o : 400 : /^\d00$/.test(o) ? parseInt(o) : o === "bold" ? 700 : 400 : 400;
  })(t3.weight), i = (function(o) {
    return typeof uh[o = o || "normal"] == "number" ? o : "normal";
  })(t3.stretch);
  return { family: n, style: e, weight: r, stretch: i, src: t3.src || [], ref: t3.ref || { name: n, style: [i, e, r].join(" ") } };
}
function mc(t3, n, e, r) {
  var i;
  for (i = e; i >= 0 && i < n.length; i += r) if (t3[n[i]]) return t3[n[i]];
  for (i = e; i >= 0 && i < n.length; i -= r) if (t3[n[i]]) return t3[n[i]];
}
var cd = { "sans-serif": "helvetica", fixed: "courier", monospace: "courier", terminal: "courier", cursive: "times", fantasy: "times", serif: "times" }, vc = { caption: "times", icon: "times", menu: "times", "message-box": "times", "small-caption": "times", "status-bar": "times" };
function bc(t3) {
  return [t3.stretch, t3.style, t3.weight, t3.family].join(" ");
}
function wc(t3) {
  return t3.trimLeft();
}
function fd(t3, n) {
  for (var e = 0; e < t3.length; ) {
    if (t3.charAt(e) === n) return [t3.substring(0, e), t3.substring(e + 1)];
    e += 1;
  }
  return null;
}
function dd(t3) {
  var n = t3.match(/^(-[a-z_]|[a-z_])[a-z0-9_-]*/i);
  return n === null ? null : [n[0], t3.substring(n[0].length)];
}
var _s, _c, yc, wa, ys, xc, Ac, Lc, Vl = ["times"];
function Nc(t3, n, e, r, i) {
  var o = 4, u = kc;
  switch (i) {
    case jt.API.image_compression.FAST:
      o = 1, u = Sc;
      break;
    case jt.API.image_compression.MEDIUM:
      o = 6, u = Pc;
      break;
    case jt.API.image_compression.SLOW:
      o = 9, u = Cc;
  }
  t3 = (function(f, c, p, x) {
    for (var L, g = f.length / c, O = new Uint8Array(f.length + g), P = [pd, Sc, kc, Pc, Cc], M = 0; M < g; M += 1) {
      var k = M * c, V = f.subarray(k, k + c);
      if (x) O.set(x(V, p, L), k + M);
      else {
        for (var G = P.length, D = [], it = 0; it < G; it += 1) D[it] = P[it](V, p, L);
        var bt = md(D.concat());
        O.set(D[bt], k + M);
      }
      L = V;
    }
    return O;
  })(t3, n, Math.ceil(e * r / 8), u);
  var l = Xl(t3, { level: o });
  return jt.API.__addimage__.arrayBufferToBinaryString(l);
}
function pd(t3) {
  var n = Array.apply([], t3);
  return n.unshift(0), n;
}
function Sc(t3, n) {
  var e = t3.length, r = [];
  r[0] = 1;
  for (var i = 0; i < e; i += 1) {
    var o = t3[i - n] || 0;
    r[i + 1] = t3[i] - o + 256 & 255;
  }
  return r;
}
function kc(t3, n, e) {
  var r = t3.length, i = [];
  i[0] = 2;
  for (var o = 0; o < r; o += 1) {
    var u = e && e[o] || 0;
    i[o + 1] = t3[o] - u + 256 & 255;
  }
  return i;
}
function Pc(t3, n, e) {
  var r = t3.length, i = [];
  i[0] = 3;
  for (var o = 0; o < r; o += 1) {
    var u = t3[o - n] || 0, l = e && e[o] || 0;
    i[o + 1] = t3[o] + 256 - (u + l >>> 1) & 255;
  }
  return i;
}
function Cc(t3, n, e) {
  var r = t3.length, i = [];
  i[0] = 4;
  for (var o = 0; o < r; o += 1) {
    var u = gd(t3[o - n] || 0, e && e[o] || 0, e && e[o - n] || 0);
    i[o + 1] = t3[o] - u + 256 & 255;
  }
  return i;
}
function gd(t3, n, e) {
  if (t3 === n && n === e) return t3;
  var r = Math.abs(n - e), i = Math.abs(t3 - e), o = Math.abs(t3 + n - e - e);
  return r <= i && r <= o ? t3 : i <= o ? n : e;
}
function md(t3) {
  var n = t3.map(function(e) {
    return e.reduce(function(r, i) {
      return r + Math.abs(i);
    }, 0);
  });
  return n.indexOf(Math.min.apply(null, n));
}
function Gl(t3, n, e) {
  var r = n * e, i = Math.floor(r / 8), o = 16 - (r - 8 * i + e), u = (1 << e) - 1;
  return Uf(t3, i) >> o & u;
}
function Ec(t3, n, e, r) {
  var i = e * r, o = Math.floor(i / 8), u = 16 - (i - 8 * o + r), l = (1 << r) - 1, f = (n & l) << u;
  (function(c, p, x) {
    if (p + 1 < c.byteLength) c.setUint16(p, x, false);
    else {
      var L = x >> 8 & 255;
      c.setUint8(p, L);
    }
  })(t3, o, Uf(t3, o) & ~(l << u) & 65535 | f);
}
function Uf(t3, n) {
  return n + 1 < t3.byteLength ? t3.getUint16(n, false) : t3.getUint8(n) << 8;
}
function vd(t3) {
  var n = 0;
  if (t3[n++] !== 71 || t3[n++] !== 73 || t3[n++] !== 70 || t3[n++] !== 56 || (t3[n++] + 1 & 253) != 56 || t3[n++] !== 97) throw new Error("Invalid GIF 87a/89a header.");
  var e = t3[n++] | t3[n++] << 8, r = t3[n++] | t3[n++] << 8, i = t3[n++], o = i >> 7, u = 1 << 1 + (7 & i);
  t3[n++], t3[n++];
  var l = null, f = null;
  o && (l = n, f = u, n += 3 * u);
  var c = true, p = [], x = 0, L = null, g = 0, O = null;
  for (this.width = e, this.height = r; c && n < t3.length; ) switch (t3[n++]) {
    case 33:
      switch (t3[n++]) {
        case 255:
          if (t3[n] !== 11 || t3[n + 1] == 78 && t3[n + 2] == 69 && t3[n + 3] == 84 && t3[n + 4] == 83 && t3[n + 5] == 67 && t3[n + 6] == 65 && t3[n + 7] == 80 && t3[n + 8] == 69 && t3[n + 9] == 50 && t3[n + 10] == 46 && t3[n + 11] == 48 && t3[n + 12] == 3 && t3[n + 13] == 1 && t3[n + 16] == 0) n += 14, O = t3[n++] | t3[n++] << 8, n++;
          else for (n += 12; ; ) {
            if (!((N = t3[n++]) >= 0)) throw Error("Invalid block size");
            if (N === 0) break;
            n += N;
          }
          break;
        case 249:
          if (t3[n++] !== 4 || t3[n + 4] !== 0) throw new Error("Invalid graphics extension block.");
          var P = t3[n++];
          x = t3[n++] | t3[n++] << 8, L = t3[n++], 1 & P || (L = null), g = P >> 2 & 7, n++;
          break;
        case 254:
          for (; ; ) {
            if (!((N = t3[n++]) >= 0)) throw Error("Invalid block size");
            if (N === 0) break;
            n += N;
          }
          break;
        default:
          throw new Error("Unknown graphic control label: 0x" + t3[n - 1].toString(16));
      }
      break;
    case 44:
      var M = t3[n++] | t3[n++] << 8, k = t3[n++] | t3[n++] << 8, V = t3[n++] | t3[n++] << 8, G = t3[n++] | t3[n++] << 8, D = t3[n++], it = D >> 6 & 1, bt = 1 << 1 + (7 & D), dt = l, $ = f, j = false;
      D >> 7 && (j = true, dt = n, $ = bt, n += 3 * bt);
      var J = n;
      for (n++; ; ) {
        var N;
        if (!((N = t3[n++]) >= 0)) throw Error("Invalid block size");
        if (N === 0) break;
        n += N;
      }
      p.push({ x: M, y: k, width: V, height: G, has_local_palette: j, palette_offset: dt, palette_size: $, data_offset: J, data_length: n - J, transparent_index: L, interlaced: !!it, delay: x, disposal: g });
      break;
    case 59:
      c = false;
      break;
    default:
      throw new Error("Unknown gif block: 0x" + t3[n - 1].toString(16));
  }
  this.numFrames = function() {
    return p.length;
  }, this.loopCount = function() {
    return O;
  }, this.frameInfo = function(C) {
    if (C < 0 || C >= p.length) throw new Error("Frame index out of range.");
    return p[C];
  }, this.decodeAndBlitFrameBGRA = function(C, z) {
    var q = this.frameInfo(C), rt = q.width * q.height, st = new Uint8Array(rt);
    Ic(t3, q.data_offset, st, rt);
    var ht = q.palette_offset, tt = q.transparent_index;
    tt === null && (tt = 256);
    var ft = q.width, Lt = e - ft, lt = ft, _ = 4 * (q.y * e + q.x), T = 4 * ((q.y + q.height) * e + q.x), B = _, H = 4 * Lt;
    q.interlaced === true && (H += 4 * e * 7);
    for (var Y = 8, nt = 0, ot = st.length; nt < ot; ++nt) {
      var at = st[nt];
      if (lt === 0 && (lt = ft, (B += H) >= T && (H = 4 * Lt + 4 * e * (Y - 1), B = _ + (ft + Lt) * (Y << 1), Y >>= 1)), at === tt) B += 4;
      else {
        var vt = t3[ht + 3 * at], xt = t3[ht + 3 * at + 1], kt = t3[ht + 3 * at + 2];
        z[B++] = kt, z[B++] = xt, z[B++] = vt, z[B++] = 255;
      }
      --lt;
    }
  }, this.decodeAndBlitFrameRGBA = function(C, z) {
    var q = this.frameInfo(C), rt = q.width * q.height, st = new Uint8Array(rt);
    Ic(t3, q.data_offset, st, rt);
    var ht = q.palette_offset, tt = q.transparent_index;
    tt === null && (tt = 256);
    var ft = q.width, Lt = e - ft, lt = ft, _ = 4 * (q.y * e + q.x), T = 4 * ((q.y + q.height) * e + q.x), B = _, H = 4 * Lt;
    q.interlaced === true && (H += 4 * e * 7);
    for (var Y = 8, nt = 0, ot = st.length; nt < ot; ++nt) {
      var at = st[nt];
      if (lt === 0 && (lt = ft, (B += H) >= T && (H = 4 * Lt + 4 * e * (Y - 1), B = _ + (ft + Lt) * (Y << 1), Y >>= 1)), at === tt) B += 4;
      else {
        var vt = t3[ht + 3 * at], xt = t3[ht + 3 * at + 1], kt = t3[ht + 3 * at + 2];
        z[B++] = vt, z[B++] = xt, z[B++] = kt, z[B++] = 255;
      }
      --lt;
    }
  };
}
function Ic(t3, n, e, r) {
  for (var i = t3[n++], o = 1 << i, u = o + 1, l = u + 1, f = i + 1, c = (1 << f) - 1, p = 0, x = 0, L = 0, g = t3[n++], O = new Int32Array(4096), P = null; ; ) {
    for (; p < 16 && g !== 0; ) x |= t3[n++] << p, p += 8, g === 1 ? g = t3[n++] : --g;
    if (p < f) break;
    var M = x & c;
    if (x >>= f, p -= f, M !== o) {
      if (M === u) break;
      for (var k = M < l ? M : P, V = 0, G = k; G > o; ) G = O[G] >> 8, ++V;
      var D = G;
      if (L + V + (k !== M ? 1 : 0) > r) return void Re.log("Warning, gif stream longer than expected.");
      e[L++] = D;
      var it = L += V;
      for (k !== M && (e[L++] = D), G = k; V--; ) G = O[G], e[--it] = 255 & G, G >>= 8;
      P !== null && l < 4096 && (O[l++] = P << 8 | D, l >= c + 1 && f < 12 && (++f, c = c << 1 | 1)), P = M;
    } else l = u + 1, c = (1 << (f = i + 1)) - 1, P = null;
  }
  return L !== r && Re.log("Warning, gif stream shorter than expected."), e;
}
/**
 * @license
  Copyright (c) 2008, Adobe Systems Incorporated
  All rights reserved.

  Redistribution and use in source and binary forms, with or without 
  modification, are permitted provided that the following conditions are
  met:

  * Redistributions of source code must retain the above copyright notice, 
    this list of conditions and the following disclaimer.
  
  * Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the 
    documentation and/or other materials provided with the distribution.
  
  * Neither the name of Adobe Systems Incorporated nor the names of its 
    contributors may be used to endorse or promote products derived from 
    this software without specific prior written permission.

  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
  IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
  THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
  PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR 
  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
function Zl(t3) {
  var n, e, r, i, o, u = Math.floor, l = new Array(64), f = new Array(64), c = new Array(64), p = new Array(64), x = new Array(65535), L = new Array(65535), g = new Array(64), O = new Array(64), P = [], M = 0, k = 7, V = new Array(64), G = new Array(64), D = new Array(64), it = new Array(256), bt = new Array(2048), dt = [0, 1, 5, 6, 14, 15, 27, 28, 2, 4, 7, 13, 16, 26, 29, 42, 3, 8, 12, 17, 25, 30, 41, 43, 9, 11, 18, 24, 31, 40, 44, 53, 10, 19, 23, 32, 39, 45, 52, 54, 20, 22, 33, 38, 46, 51, 55, 60, 21, 34, 37, 47, 50, 56, 59, 61, 35, 36, 48, 49, 57, 58, 62, 63], $ = [0, 0, 1, 5, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0], j = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11], J = [0, 0, 2, 1, 3, 3, 2, 4, 3, 5, 5, 4, 4, 0, 0, 1, 125], N = [1, 2, 3, 0, 4, 17, 5, 18, 33, 49, 65, 6, 19, 81, 97, 7, 34, 113, 20, 50, 129, 145, 161, 8, 35, 66, 177, 193, 21, 82, 209, 240, 36, 51, 98, 114, 130, 9, 10, 22, 23, 24, 25, 26, 37, 38, 39, 40, 41, 42, 52, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, 120, 121, 122, 131, 132, 133, 134, 135, 136, 137, 138, 146, 147, 148, 149, 150, 151, 152, 153, 154, 162, 163, 164, 165, 166, 167, 168, 169, 170, 178, 179, 180, 181, 182, 183, 184, 185, 186, 194, 195, 196, 197, 198, 199, 200, 201, 202, 210, 211, 212, 213, 214, 215, 216, 217, 218, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250], C = [0, 0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0], z = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11], q = [0, 0, 2, 1, 2, 4, 4, 3, 4, 7, 5, 4, 4, 0, 1, 2, 119], rt = [0, 1, 2, 3, 17, 4, 5, 33, 49, 6, 18, 65, 81, 7, 97, 113, 19, 34, 50, 129, 8, 20, 66, 145, 161, 177, 193, 9, 35, 51, 82, 240, 21, 98, 114, 209, 10, 22, 36, 52, 225, 37, 241, 23, 24, 25, 26, 38, 39, 40, 41, 42, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, 120, 121, 122, 130, 131, 132, 133, 134, 135, 136, 137, 138, 146, 147, 148, 149, 150, 151, 152, 153, 154, 162, 163, 164, 165, 166, 167, 168, 169, 170, 178, 179, 180, 181, 182, 183, 184, 185, 186, 194, 195, 196, 197, 198, 199, 200, 201, 202, 210, 211, 212, 213, 214, 215, 216, 217, 218, 226, 227, 228, 229, 230, 231, 232, 233, 234, 242, 243, 244, 245, 246, 247, 248, 249, 250];
  function st(_, T) {
    for (var B = 0, H = 0, Y = new Array(), nt = 1; nt <= 16; nt++) {
      for (var ot = 1; ot <= _[nt]; ot++) Y[T[H]] = [], Y[T[H]][0] = B, Y[T[H]][1] = nt, H++, B++;
      B *= 2;
    }
    return Y;
  }
  function ht(_) {
    for (var T = _[0], B = _[1] - 1; B >= 0; ) T & 1 << B && (M |= 1 << k), B--, --k < 0 && (M == 255 ? (tt(255), tt(0)) : tt(M), k = 7, M = 0);
  }
  function tt(_) {
    P.push(_);
  }
  function ft(_) {
    tt(_ >> 8 & 255), tt(255 & _);
  }
  function Lt(_, T, B, H, Y) {
    for (var nt, ot = Y[0], at = Y[240], vt = (function(At, Dt) {
      var St, se, zt, _e, ee, ne, Ee, le, qt, Yt, Ut = 0;
      for (qt = 0; qt < 8; ++qt) {
        St = At[Ut], se = At[Ut + 1], zt = At[Ut + 2], _e = At[Ut + 3], ee = At[Ut + 4], ne = At[Ut + 5], Ee = At[Ut + 6];
        var Me = St + (le = At[Ut + 7]), ye = St - le, Mt = se + Ee, re = se - Ee, Ie = zt + ne, Wt = zt - ne, ge = _e + ee, ie = _e - ee, Ye = Me + ge, sn = Me - ge, Fe = Mt + Ie, Xt = Mt - Ie;
        At[Ut] = Ye + Fe, At[Ut + 4] = Ye - Fe;
        var Le = 0.707106781 * (Xt + sn);
        At[Ut + 2] = sn + Le, At[Ut + 6] = sn - Le;
        var xi = 0.382683433 * ((Ye = ie + Wt) - (Xt = re + ye)), xn = 0.5411961 * Ye + xi, Fr = 1.306562965 * Xt + xi, br = 0.707106781 * (Fe = Wt + re), Vt = ye + br, Or = ye - br;
        At[Ut + 5] = Or + xn, At[Ut + 3] = Or - xn, At[Ut + 1] = Vt + Fr, At[Ut + 7] = Vt - Fr, Ut += 8;
      }
      for (Ut = 0, qt = 0; qt < 8; ++qt) {
        St = At[Ut], se = At[Ut + 8], zt = At[Ut + 16], _e = At[Ut + 24], ee = At[Ut + 32], ne = At[Ut + 40], Ee = At[Ut + 48];
        var Tr = St + (le = At[Ut + 56]), Kn = St - le, Xn = se + Ee, He = se - Ee, dn = zt + ne, mn = zt - ne, Ai = _e + ee, Kr = _e - ee, sr = Tr + Ai, wr = Tr - Ai, lr = Xn + dn, hr = Xn - dn;
        At[Ut] = sr + lr, At[Ut + 32] = sr - lr;
        var Jn = 0.707106781 * (hr + wr);
        At[Ut + 16] = wr + Jn, At[Ut + 48] = wr - Jn;
        var Li = 0.382683433 * ((sr = Kr + mn) - (hr = He + Kn)), _r = 0.5411961 * sr + Li, Ni = 1.306562965 * hr + Li, ra = 0.707106781 * (lr = mn + He), ia = Kn + ra, aa = Kn - ra;
        At[Ut + 40] = aa + _r, At[Ut + 24] = aa - _r, At[Ut + 8] = ia + Ni, At[Ut + 56] = ia - Ni, Ut++;
      }
      for (qt = 0; qt < 64; ++qt) Yt = At[qt] * Dt[qt], g[qt] = Yt > 0 ? Yt + 0.5 | 0 : Yt - 0.5 | 0;
      return g;
    })(_, T), xt = 0; xt < 64; ++xt) O[dt[xt]] = vt[xt];
    var kt = O[0] - B;
    B = O[0], kt == 0 ? ht(H[0]) : (ht(H[L[nt = 32767 + kt]]), ht(x[nt]));
    for (var Pt = 63; Pt > 0 && O[Pt] == 0; ) Pt--;
    if (Pt == 0) return ht(ot), B;
    for (var ut, R = 1; R <= Pt; ) {
      for (var pe = R; O[R] == 0 && R <= Pt; ) ++R;
      var oe = R - pe;
      if (oe >= 16) {
        ut = oe >> 4;
        for (var Ht = 1; Ht <= ut; ++Ht) ht(at);
        oe &= 15;
      }
      nt = 32767 + O[R], ht(Y[(oe << 4) + L[nt]]), ht(x[nt]), R++;
    }
    return Pt != 63 && ht(ot), B;
  }
  function lt(_) {
    _ = Math.min(Math.max(_, 1), 100), o != _ && ((function(T) {
      for (var B = [16, 11, 10, 16, 24, 40, 51, 61, 12, 12, 14, 19, 26, 58, 60, 55, 14, 13, 16, 24, 40, 57, 69, 56, 14, 17, 22, 29, 51, 87, 80, 62, 18, 22, 37, 56, 68, 109, 103, 77, 24, 35, 55, 64, 81, 104, 113, 92, 49, 64, 78, 87, 103, 121, 120, 101, 72, 92, 95, 98, 112, 100, 103, 99], H = 0; H < 64; H++) {
        var Y = u((B[H] * T + 50) / 100);
        Y = Math.min(Math.max(Y, 1), 255), l[dt[H]] = Y;
      }
      for (var nt = [17, 18, 24, 47, 99, 99, 99, 99, 18, 21, 26, 66, 99, 99, 99, 99, 24, 26, 56, 99, 99, 99, 99, 99, 47, 66, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99], ot = 0; ot < 64; ot++) {
        var at = u((nt[ot] * T + 50) / 100);
        at = Math.min(Math.max(at, 1), 255), f[dt[ot]] = at;
      }
      for (var vt = [1, 1.387039845, 1.306562965, 1.175875602, 1, 0.785694958, 0.5411961, 0.275899379], xt = 0, kt = 0; kt < 8; kt++) for (var Pt = 0; Pt < 8; Pt++) c[xt] = 1 / (l[dt[xt]] * vt[kt] * vt[Pt] * 8), p[xt] = 1 / (f[dt[xt]] * vt[kt] * vt[Pt] * 8), xt++;
    })(_ < 50 ? Math.floor(5e3 / _) : Math.floor(200 - 2 * _)), o = _);
  }
  this.encode = function(_, T) {
    T && lt(T), P = new Array(), M = 0, k = 7, ft(65496), ft(65504), ft(16), tt(74), tt(70), tt(73), tt(70), tt(0), tt(1), tt(1), tt(0), ft(1), ft(1), tt(0), tt(0), (function() {
      ft(65499), ft(132), tt(0);
      for (var se = 0; se < 64; se++) tt(l[se]);
      tt(1);
      for (var zt = 0; zt < 64; zt++) tt(f[zt]);
    })(), (function(se, zt) {
      ft(65472), ft(17), tt(8), ft(zt), ft(se), tt(3), tt(1), tt(17), tt(0), tt(2), tt(17), tt(1), tt(3), tt(17), tt(1);
    })(_.width, _.height), (function() {
      ft(65476), ft(418), tt(0);
      for (var se = 0; se < 16; se++) tt($[se + 1]);
      for (var zt = 0; zt <= 11; zt++) tt(j[zt]);
      tt(16);
      for (var _e = 0; _e < 16; _e++) tt(J[_e + 1]);
      for (var ee = 0; ee <= 161; ee++) tt(N[ee]);
      tt(1);
      for (var ne = 0; ne < 16; ne++) tt(C[ne + 1]);
      for (var Ee = 0; Ee <= 11; Ee++) tt(z[Ee]);
      tt(17);
      for (var le = 0; le < 16; le++) tt(q[le + 1]);
      for (var qt = 0; qt <= 161; qt++) tt(rt[qt]);
    })(), ft(65498), ft(12), tt(3), tt(1), tt(0), tt(2), tt(17), tt(3), tt(17), tt(0), tt(63), tt(0);
    var B = 0, H = 0, Y = 0;
    M = 0, k = 7, this.encode.displayName = "_encode_";
    for (var nt, ot, at, vt, xt, kt, Pt, ut, R, pe = _.data, oe = _.width, Ht = _.height, At = 4 * oe, Dt = 0; Dt < Ht; ) {
      for (nt = 0; nt < At; ) {
        for (xt = At * Dt + nt, Pt = -1, ut = 0, R = 0; R < 64; R++) kt = xt + (ut = R >> 3) * At + (Pt = 4 * (7 & R)), Dt + ut >= Ht && (kt -= At * (Dt + 1 + ut - Ht)), nt + Pt >= At && (kt -= nt + Pt - At + 4), ot = pe[kt++], at = pe[kt++], vt = pe[kt++], V[R] = (bt[ot] + bt[at + 256 | 0] + bt[vt + 512 | 0] >> 16) - 128, G[R] = (bt[ot + 768 | 0] + bt[at + 1024 | 0] + bt[vt + 1280 | 0] >> 16) - 128, D[R] = (bt[ot + 1280 | 0] + bt[at + 1536 | 0] + bt[vt + 1792 | 0] >> 16) - 128;
        B = Lt(V, c, B, n, r), H = Lt(G, p, H, e, i), Y = Lt(D, p, Y, e, i), nt += 32;
      }
      Dt += 8;
    }
    if (k >= 0) {
      var St = [];
      St[1] = k + 1, St[0] = (1 << k + 1) - 1, ht(St);
    }
    return ft(65497), new Uint8Array(P);
  }, t3 = t3 || 50, (function() {
    for (var _ = String.fromCharCode, T = 0; T < 256; T++) it[T] = _(T);
  })(), n = st($, j), e = st(C, z), r = st(J, N), i = st(q, rt), (function() {
    for (var _ = 1, T = 2, B = 1; B <= 15; B++) {
      for (var H = _; H < T; H++) L[32767 + H] = B, x[32767 + H] = [], x[32767 + H][1] = B, x[32767 + H][0] = H;
      for (var Y = -(T - 1); Y <= -_; Y++) L[32767 + Y] = B, x[32767 + Y] = [], x[32767 + Y][1] = B, x[32767 + Y][0] = T - 1 + Y;
      _ <<= 1, T <<= 1;
    }
  })(), (function() {
    for (var _ = 0; _ < 256; _++) bt[_] = 19595 * _, bt[_ + 256 | 0] = 38470 * _, bt[_ + 512 | 0] = 7471 * _ + 32768, bt[_ + 768 | 0] = -11059 * _, bt[_ + 1024 | 0] = -21709 * _, bt[_ + 1280 | 0] = 32768 * _ + 8421375, bt[_ + 1536 | 0] = -27439 * _, bt[_ + 1792 | 0] = -5329 * _;
  })(), lt(t3);
}
/**
* @license
* Copyright (c) 2017 Aras Abbasi
*
* Licensed under the MIT License.
* http://opensource.org/licenses/mit-license
*/
function pr(t3, n) {
  if (this.pos = 0, this.buffer = t3, this.datav = new DataView(t3.buffer), this.is_with_alpha = !!n, this.bottom_up = true, this.flag = String.fromCharCode(this.buffer[0]) + String.fromCharCode(this.buffer[1]), this.pos += 2, ["BM", "BA", "CI", "CP", "IC", "PT"].indexOf(this.flag) === -1) throw new Error("Invalid BMP File");
  this.parseHeader(), this.parseBGR();
}
function Fc(t3) {
  function n(j) {
    if (!j) throw Error("assert :P");
  }
  function e(j, J, N) {
    for (var C = 0; 4 > C; C++) if (j[J + C] != N.charCodeAt(C)) return true;
    return false;
  }
  function r(j, J, N, C, z) {
    for (var q = 0; q < z; q++) j[J + q] = N[C + q];
  }
  function i(j, J, N, C) {
    for (var z = 0; z < C; z++) j[J + z] = N;
  }
  function o(j) {
    return new Int32Array(j);
  }
  function u(j, J) {
    for (var N = [], C = 0; C < j; C++) N.push(new J());
    return N;
  }
  function l(j, J) {
    var N = [];
    return (function C(z, q, rt) {
      for (var st = rt[q], ht = 0; ht < st && (z.push(rt.length > q + 1 ? [] : new J()), !(rt.length < q + 1)); ht++) C(z[ht], q + 1, rt);
    })(N, 0, j), N;
  }
  var f = function() {
    var j = this;
    function J(a, s) {
      for (var d = 1 << s - 1 >>> 0; a & d; ) d >>>= 1;
      return d ? (a & d - 1) + d : a;
    }
    function N(a, s, d, m, b) {
      n(!(m % d));
      do
        a[s + (m -= d)] = b;
      while (0 < m);
    }
    function C(a, s, d, m, b) {
      if (n(2328 >= b), 512 >= b) var w = o(512);
      else if ((w = o(b)) == null) return 0;
      return (function(y, A, S, E, W, et) {
        var I, Z, X = A, ct = 1 << S, Q = o(16), pt = o(16);
        for (n(W != 0), n(E != null), n(y != null), n(0 < S), Z = 0; Z < W; ++Z) {
          if (15 < E[Z]) return 0;
          ++Q[E[Z]];
        }
        if (Q[0] == W) return 0;
        for (pt[1] = 0, I = 1; 15 > I; ++I) {
          if (Q[I] > 1 << I) return 0;
          pt[I + 1] = pt[I] + Q[I];
        }
        for (Z = 0; Z < W; ++Z) I = E[Z], 0 < E[Z] && (et[pt[I]++] = Z);
        if (pt[15] == 1) return (E = new z()).g = 0, E.value = et[0], N(y, X, 1, ct, E), ct;
        var mt, yt = -1, wt = ct - 1, Bt = 0, Ct = 1, he = 1, Ot = 1 << S;
        for (Z = 0, I = 1, W = 2; I <= S; ++I, W <<= 1) {
          if (Ct += he <<= 1, 0 > (he -= Q[I])) return 0;
          for (; 0 < Q[I]; --Q[I]) (E = new z()).g = I, E.value = et[Z++], N(y, X + Bt, W, Ot, E), Bt = J(Bt, I);
        }
        for (I = S + 1, W = 2; 15 >= I; ++I, W <<= 1) {
          if (Ct += he <<= 1, 0 > (he -= Q[I])) return 0;
          for (; 0 < Q[I]; --Q[I]) {
            if (E = new z(), (Bt & wt) != yt) {
              for (X += Ot, mt = 1 << (yt = I) - S; 15 > yt && !(0 >= (mt -= Q[yt])); ) ++yt, mt <<= 1;
              ct += Ot = 1 << (mt = yt - S), y[A + (yt = Bt & wt)].g = mt + S, y[A + yt].value = X - A - yt;
            }
            E.g = I - S, E.value = et[Z++], N(y, X + (Bt >> S), W, Ot, E), Bt = J(Bt, I);
          }
        }
        return Ct != 2 * pt[15] - 1 ? 0 : ct;
      })(a, s, d, m, b, w);
    }
    function z() {
      this.value = this.g = 0;
    }
    function q() {
      this.value = this.g = 0;
    }
    function rt() {
      this.G = u(5, z), this.H = o(5), this.jc = this.Qb = this.qb = this.nd = 0, this.pd = u(zi, q);
    }
    function st(a, s, d, m) {
      n(a != null), n(s != null), n(2147483648 > m), a.Ca = 254, a.I = 0, a.b = -8, a.Ka = 0, a.oa = s, a.pa = d, a.Jd = s, a.Yc = d + m, a.Zc = 4 <= m ? d + m - 4 + 1 : d, ot(a);
    }
    function ht(a, s) {
      for (var d = 0; 0 < s--; ) d |= vt(a, 128) << s;
      return d;
    }
    function tt(a, s) {
      var d = ht(a, s);
      return at(a) ? -d : d;
    }
    function ft(a, s, d, m) {
      var b, w = 0;
      for (n(a != null), n(s != null), n(4294967288 > m), a.Sb = m, a.Ra = 0, a.u = 0, a.h = 0, 4 < m && (m = 4), b = 0; b < m; ++b) w += s[d + b] << 8 * b;
      a.Ra = w, a.bb = m, a.oa = s, a.pa = d;
    }
    function Lt(a) {
      for (; 8 <= a.u && a.bb < a.Sb; ) a.Ra >>>= 8, a.Ra += a.oa[a.pa + a.bb] << ei - 8 >>> 0, ++a.bb, a.u -= 8;
      H(a) && (a.h = 1, a.u = 0);
    }
    function lt(a, s) {
      if (n(0 <= s), !a.h && s <= Dn) {
        var d = B(a) & jn[s];
        return a.u += s, Lt(a), d;
      }
      return a.h = 1, a.u = 0;
    }
    function _() {
      this.b = this.Ca = this.I = 0, this.oa = [], this.pa = 0, this.Jd = [], this.Yc = 0, this.Zc = [], this.Ka = 0;
    }
    function T() {
      this.Ra = 0, this.oa = [], this.h = this.u = this.bb = this.Sb = this.pa = 0;
    }
    function B(a) {
      return a.Ra >>> (a.u & ei - 1) >>> 0;
    }
    function H(a) {
      return n(a.bb <= a.Sb), a.h || a.bb == a.Sb && a.u > ei;
    }
    function Y(a, s) {
      a.u = s, a.h = H(a);
    }
    function nt(a) {
      a.u >= Ur && (n(a.u >= Ur), Lt(a));
    }
    function ot(a) {
      n(a != null && a.oa != null), a.pa < a.Zc ? (a.I = (a.oa[a.pa++] | a.I << 8) >>> 0, a.b += 8) : (n(a != null && a.oa != null), a.pa < a.Yc ? (a.b += 8, a.I = a.oa[a.pa++] | a.I << 8) : a.Ka ? a.b = 0 : (a.I <<= 8, a.b += 8, a.Ka = 1));
    }
    function at(a) {
      return ht(a, 1);
    }
    function vt(a, s) {
      var d = a.Ca;
      0 > a.b && ot(a);
      var m = a.b, b = d * s >>> 8, w = (a.I >>> m > b) + 0;
      for (w ? (d -= b, a.I -= b + 1 << m >>> 0) : d = b + 1, m = d, b = 0; 256 <= m; ) b += 8, m >>= 8;
      return m = 7 ^ b + ni[m], a.b -= m, a.Ca = (d << m) - 1, w;
    }
    function xt(a, s, d) {
      a[s + 0] = d >> 24 & 255, a[s + 1] = d >> 16 & 255, a[s + 2] = d >> 8 & 255, a[s + 3] = 255 & d;
    }
    function kt(a, s) {
      return a[s + 0] | a[s + 1] << 8;
    }
    function Pt(a, s) {
      return kt(a, s) | a[s + 2] << 16;
    }
    function ut(a, s) {
      return kt(a, s) | kt(a, s + 2) << 16;
    }
    function R(a, s) {
      var d = 1 << s;
      return n(a != null), n(0 < s), a.X = o(d), a.X == null ? 0 : (a.Mb = 32 - s, a.Xa = s, 1);
    }
    function pe(a, s) {
      n(a != null), n(s != null), n(a.Xa == s.Xa), r(s.X, 0, a.X, 0, 1 << s.Xa);
    }
    function oe() {
      this.X = [], this.Xa = this.Mb = 0;
    }
    function Ht(a, s, d, m) {
      n(d != null), n(m != null);
      var b = d[0], w = m[0];
      return b == 0 && (b = (a * w + s / 2) / s), w == 0 && (w = (s * b + a / 2) / a), 0 >= b || 0 >= w ? 0 : (d[0] = b, m[0] = w, 1);
    }
    function At(a, s) {
      return a + (1 << s) - 1 >>> s;
    }
    function Dt(a, s) {
      return ((4278255360 & a) + (4278255360 & s) >>> 0 & 4278255360) + ((16711935 & a) + (16711935 & s) >>> 0 & 16711935) >>> 0;
    }
    function St(a, s) {
      j[s] = function(d, m, b, w, y, A, S) {
        var E;
        for (E = 0; E < y; ++E) {
          var W = j[a](A[S + E - 1], b, w + E);
          A[S + E] = Dt(d[m + E], W);
        }
      };
    }
    function se() {
      this.ud = this.hd = this.jd = 0;
    }
    function zt(a, s) {
      return ((4278124286 & (a ^ s)) >>> 1) + (a & s) >>> 0;
    }
    function _e(a) {
      return 0 <= a && 256 > a ? a : 0 > a ? 0 : 255 < a ? 255 : void 0;
    }
    function ee(a, s) {
      return _e(a + (a - s + 0.5 >> 1));
    }
    function ne(a, s, d) {
      return Math.abs(s - d) - Math.abs(a - d);
    }
    function Ee(a, s, d, m, b, w, y) {
      for (m = w[y - 1], d = 0; d < b; ++d) w[y + d] = m = Dt(a[s + d], m);
    }
    function le(a, s, d, m, b) {
      var w;
      for (w = 0; w < d; ++w) {
        var y = a[s + w], A = y >> 8 & 255, S = 16711935 & (S = (S = 16711935 & y) + ((A << 16) + A));
        m[b + w] = (4278255360 & y) + S >>> 0;
      }
    }
    function qt(a, s) {
      s.jd = 255 & a, s.hd = a >> 8 & 255, s.ud = a >> 16 & 255;
    }
    function Yt(a, s, d, m, b, w) {
      var y;
      for (y = 0; y < m; ++y) {
        var A = s[d + y], S = A >>> 8, E = A, W = 255 & (W = (W = A >>> 16) + ((a.jd << 24 >> 24) * (S << 24 >> 24) >>> 5));
        E = 255 & (E = (E += (a.hd << 24 >> 24) * (S << 24 >> 24) >>> 5) + ((a.ud << 24 >> 24) * (W << 24 >> 24) >>> 5)), b[w + y] = (4278255360 & A) + (W << 16) + E;
      }
    }
    function Ut(a, s, d, m, b) {
      j[s] = function(w, y, A, S, E, W, et, I, Z) {
        for (S = et; S < I; ++S) for (et = 0; et < Z; ++et) E[W++] = b(A[m(w[y++])]);
      }, j[a] = function(w, y, A, S, E, W, et) {
        var I = 8 >> w.b, Z = w.Ea, X = w.K[0], ct = w.w;
        if (8 > I) for (w = (1 << w.b) - 1, ct = (1 << I) - 1; y < A; ++y) {
          var Q, pt = 0;
          for (Q = 0; Q < Z; ++Q) Q & w || (pt = m(S[E++])), W[et++] = b(X[pt & ct]), pt >>= I;
        }
        else j["VP8LMapColor" + d](S, E, X, ct, W, et, y, A, Z);
      };
    }
    function Me(a, s, d, m, b) {
      for (d = s + d; s < d; ) {
        var w = a[s++];
        m[b++] = w >> 16 & 255, m[b++] = w >> 8 & 255, m[b++] = 255 & w;
      }
    }
    function ye(a, s, d, m, b) {
      for (d = s + d; s < d; ) {
        var w = a[s++];
        m[b++] = w >> 16 & 255, m[b++] = w >> 8 & 255, m[b++] = 255 & w, m[b++] = w >> 24 & 255;
      }
    }
    function Mt(a, s, d, m, b) {
      for (d = s + d; s < d; ) {
        var w = (y = a[s++]) >> 16 & 240 | y >> 12 & 15, y = 240 & y | y >> 28 & 15;
        m[b++] = w, m[b++] = y;
      }
    }
    function re(a, s, d, m, b) {
      for (d = s + d; s < d; ) {
        var w = (y = a[s++]) >> 16 & 248 | y >> 13 & 7, y = y >> 5 & 224 | y >> 3 & 31;
        m[b++] = w, m[b++] = y;
      }
    }
    function Ie(a, s, d, m, b) {
      for (d = s + d; s < d; ) {
        var w = a[s++];
        m[b++] = 255 & w, m[b++] = w >> 8 & 255, m[b++] = w >> 16 & 255;
      }
    }
    function Wt(a, s, d, m, b, w) {
      if (w == 0) for (d = s + d; s < d; ) xt(m, ((w = a[s++])[0] >> 24 | w[1] >> 8 & 65280 | w[2] << 8 & 16711680 | w[3] << 24) >>> 0), b += 32;
      else r(m, b, a, s, d);
    }
    function ge(a, s) {
      j[s][0] = j[a + "0"], j[s][1] = j[a + "1"], j[s][2] = j[a + "2"], j[s][3] = j[a + "3"], j[s][4] = j[a + "4"], j[s][5] = j[a + "5"], j[s][6] = j[a + "6"], j[s][7] = j[a + "7"], j[s][8] = j[a + "8"], j[s][9] = j[a + "9"], j[s][10] = j[a + "10"], j[s][11] = j[a + "11"], j[s][12] = j[a + "12"], j[s][13] = j[a + "13"], j[s][14] = j[a + "0"], j[s][15] = j[a + "0"];
    }
    function ie(a) {
      return a == rl || a == il || a == ts || a == al;
    }
    function Ye() {
      this.eb = [], this.size = this.A = this.fb = 0;
    }
    function sn() {
      this.y = [], this.f = [], this.ea = [], this.F = [], this.Tc = this.Ed = this.Cd = this.Fd = this.lb = this.Db = this.Ab = this.fa = this.J = this.W = this.N = this.O = 0;
    }
    function Fe() {
      this.Rd = this.height = this.width = this.S = 0, this.f = {}, this.f.RGBA = new Ye(), this.f.kb = new sn(), this.sd = null;
    }
    function Xt() {
      this.width = [0], this.height = [0], this.Pd = [0], this.Qd = [0], this.format = [0];
    }
    function Le() {
      this.Id = this.fd = this.Md = this.hb = this.ib = this.da = this.bd = this.cd = this.j = this.v = this.Da = this.Sd = this.ob = 0;
    }
    function xi(a) {
      return alert("todo:WebPSamplerProcessPlane"), a.T;
    }
    function xn(a, s) {
      var d = a.T, m = s.ba.f.RGBA, b = m.eb, w = m.fb + a.ka * m.A, y = ir[s.ba.S], A = a.y, S = a.O, E = a.f, W = a.N, et = a.ea, I = a.W, Z = s.cc, X = s.dc, ct = s.Mc, Q = s.Nc, pt = a.ka, mt = a.ka + a.T, yt = a.U, wt = yt + 1 >> 1;
      for (pt == 0 ? y(A, S, null, null, E, W, et, I, E, W, et, I, b, w, null, null, yt) : (y(s.ec, s.fc, A, S, Z, X, ct, Q, E, W, et, I, b, w - m.A, b, w, yt), ++d); pt + 2 < mt; pt += 2) Z = E, X = W, ct = et, Q = I, W += a.Rc, I += a.Rc, w += 2 * m.A, y(A, (S += 2 * a.fa) - a.fa, A, S, Z, X, ct, Q, E, W, et, I, b, w - m.A, b, w, yt);
      return S += a.fa, a.j + mt < a.o ? (r(s.ec, s.fc, A, S, yt), r(s.cc, s.dc, E, W, wt), r(s.Mc, s.Nc, et, I, wt), d--) : 1 & mt || y(A, S, null, null, E, W, et, I, E, W, et, I, b, w + m.A, null, null, yt), d;
    }
    function Fr(a, s, d) {
      var m = a.F, b = [a.J];
      if (m != null) {
        var w = a.U, y = s.ba.S, A = y == Qo || y == ts;
        s = s.ba.f.RGBA;
        var S = [0], E = a.ka;
        S[0] = a.T, a.Kb && (E == 0 ? --S[0] : (--E, b[0] -= a.width), a.j + a.ka + a.T == a.o && (S[0] = a.o - a.j - E));
        var W = s.eb;
        E = s.fb + E * s.A, a = Eh(m, b[0], a.width, w, S, W, E + (A ? 0 : 3), s.A), n(d == S), a && ie(y) && no(W, E, A, w, S, s.A);
      }
      return 0;
    }
    function br(a) {
      var s = a.ma, d = s.ba.S, m = 11 > d, b = d == Xo || d == Jo || d == Qo || d == nl || d == 12 || ie(d);
      if (s.memory = null, s.Ib = null, s.Jb = null, s.Nd = null, !Ya(s.Oa, a, b ? 11 : 12)) return 0;
      if (b && ie(d) && Vo(), a.da) alert("todo:use_scaling");
      else {
        if (m) {
          if (s.Ib = xi, a.Kb) {
            if (d = a.U + 1 >> 1, s.memory = o(a.U + 2 * d), s.memory == null) return 0;
            s.ec = s.memory, s.fc = 0, s.cc = s.ec, s.dc = s.fc + a.U, s.Mc = s.cc, s.Nc = s.dc + d, s.Ib = xn, Vo();
          }
        } else alert("todo:EmitYUV");
        b && (s.Jb = Fr, m && tr());
      }
      if (m && !Zh) {
        for (a = 0; 256 > a; ++a) l1[a] = 89858 * (a - 128) + ns >> es, c1[a] = -22014 * (a - 128) + ns, u1[a] = -45773 * (a - 128), h1[a] = 113618 * (a - 128) + ns >> es;
        for (a = io; a < ll; ++a) s = 76283 * (a - 16) + ns >> es, f1[a - io] = We(s, 255), d1[a - io] = We(s + 8 >> 4, 15);
        Zh = 1;
      }
      return 1;
    }
    function Vt(a) {
      var s = a.ma, d = a.U, m = a.T;
      return n(!(1 & a.ka)), 0 >= d || 0 >= m ? 0 : (d = s.Ib(a, s), s.Jb != null && s.Jb(a, s, d), s.Dc += d, 1);
    }
    function Or(a) {
      a.ma.memory = null;
    }
    function Tr(a, s, d, m) {
      return lt(a, 8) != 47 ? 0 : (s[0] = lt(a, 14) + 1, d[0] = lt(a, 14) + 1, m[0] = lt(a, 1), lt(a, 3) != 0 ? 0 : !a.h);
    }
    function Kn(a, s) {
      if (4 > a) return a + 1;
      var d = a - 2 >> 1;
      return (2 + (1 & a) << d) + lt(s, d) + 1;
    }
    function Xn(a, s) {
      return 120 < s ? s - 120 : 1 <= (d = ((d = Yf[s - 1]) >> 4) * a + (8 - (15 & d))) ? d : 1;
      var d;
    }
    function He(a, s, d) {
      var m = B(d), b = a[s += 255 & m].g - 8;
      return 0 < b && (Y(d, d.u + 8), m = B(d), s += a[s].value, s += m & (1 << b) - 1), Y(d, d.u + a[s].g), a[s].value;
    }
    function dn(a, s, d) {
      return d.g += a.g, d.value += a.value << s >>> 0, n(8 >= d.g), a.g;
    }
    function mn(a, s, d) {
      var m = a.xc;
      return n((s = m == 0 ? 0 : a.vc[a.md * (d >> m) + (s >> m)]) < a.Wb), a.Ya[s];
    }
    function Ai(a, s, d, m) {
      var b = a.ab, w = a.c * s, y = a.C;
      s = y + s;
      var A = d, S = m;
      for (m = a.Ta, d = a.Ua; 0 < b--; ) {
        var E = a.gc[b], W = y, et = s, I = A, Z = S, X = (S = m, A = d, E.Ea);
        switch (n(W < et), n(et <= E.nc), E.hc) {
          case 2:
            Ke(I, Z, (et - W) * X, S, A);
            break;
          case 0:
            var ct = W, Q = et, pt = S, mt = A, yt = (Ot = E).Ea;
            ct == 0 && (Ka(I, Z, null, null, 1, pt, mt), Ee(I, Z + 1, 0, 0, yt - 1, pt, mt + 1), Z += yt, mt += yt, ++ct);
            for (var wt = 1 << Ot.b, Bt = wt - 1, Ct = At(yt, Ot.b), he = Ot.K, Ot = Ot.w + (ct >> Ot.b) * Ct; ct < Q; ) {
              var me = he, un = Ot, ue = 1;
              for (da(I, Z, pt, mt - yt, 1, pt, mt); ue < yt; ) {
                var Tt = (ue & ~Bt) + wt;
                Tt > yt && (Tt = yt), (0, Ja[me[un++] >> 8 & 15])(I, Z + +ue, pt, mt + ue - yt, Tt - ue, pt, mt + ue), ue = Tt;
              }
              Z += yt, mt += yt, ++ct & Bt || (Ot += Ct);
            }
            et != E.nc && r(S, A - X, S, A + (et - W - 1) * X, X);
            break;
          case 1:
            for (X = I, Q = Z, yt = (I = E.Ea) - (mt = I & ~(pt = (Z = 1 << E.b) - 1)), ct = At(I, E.b), wt = E.K, E = E.w + (W >> E.b) * ct; W < et; ) {
              for (Bt = wt, Ct = E, he = new se(), Ot = Q + mt, me = Q + I; Q < Ot; ) qt(Bt[Ct++], he), Qa(he, X, Q, Z, S, A), Q += Z, A += Z;
              Q < me && (qt(Bt[Ct++], he), Qa(he, X, Q, yt, S, A), Q += yt, A += yt), ++W & pt || (E += ct);
            }
            break;
          case 3:
            if (I == S && Z == A && 0 < E.b) {
              for (Q = S, I = X = A + (et - W) * X - (mt = (et - W) * At(E.Ea, E.b)), Z = S, pt = A, ct = [], mt = (yt = mt) - 1; 0 <= mt; --mt) ct[mt] = Z[pt + mt];
              for (mt = yt - 1; 0 <= mt; --mt) Q[I + mt] = ct[mt];
              Zo(E, W, et, S, X, S, A);
            } else Zo(E, W, et, I, Z, S, A);
        }
        A = m, S = d;
      }
      S != d && r(m, d, A, S, w);
    }
    function Kr(a, s) {
      var d = a.V, m = a.Ba + a.c * a.C, b = s - a.C;
      if (n(s <= a.l.o), n(16 >= b), 0 < b) {
        var w = a.l, y = a.Ta, A = a.Ua, S = w.width;
        if (Ai(a, b, d, m), b = A = [A], n((d = a.C) < (m = s)), n(w.v < w.va), m > w.o && (m = w.o), d < w.j) {
          var E = w.j - d;
          d = w.j, b[0] += E * S;
        }
        if (d >= m ? d = 0 : (b[0] += 4 * w.v, w.ka = d - w.j, w.U = w.va - w.v, w.T = m - d, d = 1), d) {
          if (A = A[0], 11 > (d = a.ca).S) {
            var W = d.f.RGBA, et = (m = d.S, b = w.U, w = w.T, E = W.eb, W.A), I = w;
            for (W = W.fb + a.Ma * W.A; 0 < I--; ) {
              var Z = y, X = A, ct = b, Q = E, pt = W;
              switch (m) {
                case Ko:
                  to(Z, X, ct, Q, pt);
                  break;
                case Xo:
                  ri(Z, X, ct, Q, pt);
                  break;
                case rl:
                  ri(Z, X, ct, Q, pt), no(Q, pt, 0, ct, 1, 0);
                  break;
                case Bh:
                  Hi(Z, X, ct, Q, pt);
                  break;
                case Jo:
                  Wt(Z, X, ct, Q, pt, 1);
                  break;
                case il:
                  Wt(Z, X, ct, Q, pt, 1), no(Q, pt, 0, ct, 1, 0);
                  break;
                case Qo:
                  Wt(Z, X, ct, Q, pt, 0);
                  break;
                case ts:
                  Wt(Z, X, ct, Q, pt, 0), no(Q, pt, 1, ct, 1, 0);
                  break;
                case nl:
                  ii(Z, X, ct, Q, pt);
                  break;
                case al:
                  ii(Z, X, ct, Q, pt), Ch(Q, pt, ct, 1, 0);
                  break;
                case jh:
                  ai(Z, X, ct, Q, pt);
                  break;
                default:
                  n(0);
              }
              A += S, W += et;
            }
            a.Ma += w;
          } else alert("todo:EmitRescaledRowsYUVA");
          n(a.Ma <= d.height);
        }
      }
      a.C = s, n(a.C <= a.i);
    }
    function sr(a) {
      var s;
      if (0 < a.ua) return 0;
      for (s = 0; s < a.Wb; ++s) {
        var d = a.Ya[s].G, m = a.Ya[s].H;
        if (0 < d[1][m[1] + 0].g || 0 < d[2][m[2] + 0].g || 0 < d[3][m[3] + 0].g) return 0;
      }
      return 1;
    }
    function wr(a, s, d, m, b, w) {
      if (a.Z != 0) {
        var y = a.qd, A = a.rd;
        for (n(li[a.Z] != null); s < d; ++s) li[a.Z](y, A, m, b, m, b, w), y = m, A = b, b += w;
        a.qd = y, a.rd = A;
      }
    }
    function lr(a, s) {
      var d = a.l.ma, m = d.Z == 0 || d.Z == 1 ? a.l.j : a.C;
      if (m = a.C < m ? m : a.C, n(s <= a.l.o), s > m) {
        var b = a.l.width, w = d.ca, y = d.tb + b * m, A = a.V, S = a.Ba + a.c * m, E = a.gc;
        n(a.ab == 1), n(E[0].hc == 3), Ar(E[0], m, s, A, S, w, y), wr(d, m, s, w, y, b);
      }
      a.C = a.Ma = s;
    }
    function hr(a, s, d, m, b, w, y) {
      var A = a.$ / m, S = a.$ % m, E = a.m, W = a.s, et = d + a.$, I = et;
      b = d + m * b;
      var Z = d + m * w, X = 280 + W.ua, ct = a.Pb ? A : 16777216, Q = 0 < W.ua ? W.Wa : null, pt = W.wc, mt = et < Z ? mn(W, S, A) : null;
      n(a.C < w), n(Z <= b);
      var yt = false;
      t: for (; ; ) {
        for (; yt || et < Z; ) {
          var wt = 0;
          if (A >= ct) {
            var Bt = et - d;
            n((ct = a).Pb), ct.wd = ct.m, ct.xd = Bt, 0 < ct.s.ua && pe(ct.s.Wa, ct.s.vb), ct = A + Kf;
          }
          if (S & pt || (mt = mn(W, S, A)), n(mt != null), mt.Qb && (s[et] = mt.qb, yt = true), !yt) if (nt(E), mt.jc) {
            wt = E, Bt = s;
            var Ct = et, he = mt.pd[B(wt) & zi - 1];
            n(mt.jc), 256 > he.g ? (Y(wt, wt.u + he.g), Bt[Ct] = he.value, wt = 0) : (Y(wt, wt.u + he.g - 256), n(256 <= he.value), wt = he.value), wt == 0 && (yt = true);
          } else wt = He(mt.G[0], mt.H[0], E);
          if (E.h) break;
          if (yt || 256 > wt) {
            if (!yt) if (mt.nd) s[et] = (mt.qb | wt << 8) >>> 0;
            else {
              if (nt(E), yt = He(mt.G[1], mt.H[1], E), nt(E), Bt = He(mt.G[2], mt.H[2], E), Ct = He(mt.G[3], mt.H[3], E), E.h) break;
              s[et] = (Ct << 24 | yt << 16 | wt << 8 | Bt) >>> 0;
            }
            if (yt = false, ++et, ++S >= m && (S = 0, ++A, y != null && A <= w && !(A % 16) && y(a, A), Q != null)) for (; I < et; ) wt = s[I++], Q.X[(506832829 * wt & 4294967295) >>> Q.Mb] = wt;
          } else if (280 > wt) {
            if (wt = Kn(wt - 256, E), Bt = He(mt.G[4], mt.H[4], E), nt(E), Bt = Xn(m, Bt = Kn(Bt, E)), E.h) break;
            if (et - d < Bt || b - et < wt) break t;
            for (Ct = 0; Ct < wt; ++Ct) s[et + Ct] = s[et + Ct - Bt];
            for (et += wt, S += wt; S >= m; ) S -= m, ++A, y != null && A <= w && !(A % 16) && y(a, A);
            if (n(et <= b), S & pt && (mt = mn(W, S, A)), Q != null) for (; I < et; ) wt = s[I++], Q.X[(506832829 * wt & 4294967295) >>> Q.Mb] = wt;
          } else {
            if (!(wt < X)) break t;
            for (yt = wt - 280, n(Q != null); I < et; ) wt = s[I++], Q.X[(506832829 * wt & 4294967295) >>> Q.Mb] = wt;
            wt = et, n(!(yt >>> (Bt = Q).Xa)), s[wt] = Bt.X[yt], yt = true;
          }
          yt || n(E.h == H(E));
        }
        if (a.Pb && E.h && et < b) n(a.m.h), a.a = 5, a.m = a.wd, a.$ = a.xd, 0 < a.s.ua && pe(a.s.vb, a.s.Wa);
        else {
          if (E.h) break t;
          y != null && y(a, A > w ? w : A), a.a = 0, a.$ = et - d;
        }
        return 1;
      }
      return a.a = 3, 0;
    }
    function Jn(a) {
      n(a != null), a.vc = null, a.yc = null, a.Ya = null;
      var s = a.Wa;
      s != null && (s.X = null), a.vb = null, n(a != null);
    }
    function Li() {
      var a = new Rt();
      return a == null ? null : (a.a = 0, a.xb = Uh, ge("Predictor", "VP8LPredictors"), ge("Predictor", "VP8LPredictors_C"), ge("PredictorAdd", "VP8LPredictorsAdd"), ge("PredictorAdd", "VP8LPredictorsAdd_C"), Ke = le, Qa = Yt, to = Me, ri = ye, ii = Mt, ai = re, Hi = Ie, j.VP8LMapColor32b = xr, j.VP8LMapColor8b = Xa, a);
    }
    function _r(a, s, d, m, b) {
      var w = 1, y = [a], A = [s], S = m.m, E = m.s, W = null, et = 0;
      t: for (; ; ) {
        if (d) for (; w && lt(S, 1); ) {
          var I = y, Z = A, X = m, ct = 1, Q = X.m, pt = X.gc[X.ab], mt = lt(Q, 2);
          if (X.Oc & 1 << mt) w = 0;
          else {
            switch (X.Oc |= 1 << mt, pt.hc = mt, pt.Ea = I[0], pt.nc = Z[0], pt.K = [null], ++X.ab, n(4 >= X.ab), mt) {
              case 0:
              case 1:
                pt.b = lt(Q, 3) + 2, ct = _r(At(pt.Ea, pt.b), At(pt.nc, pt.b), 0, X, pt.K), pt.K = pt.K[0];
                break;
              case 3:
                var yt, wt = lt(Q, 8) + 1, Bt = 16 < wt ? 0 : 4 < wt ? 1 : 2 < wt ? 2 : 3;
                if (I[0] = At(pt.Ea, Bt), pt.b = Bt, yt = ct = _r(wt, 1, 0, X, pt.K)) {
                  var Ct, he = wt, Ot = pt, me = 1 << (8 >> Ot.b), un = o(me);
                  if (un == null) yt = 0;
                  else {
                    var ue = Ot.K[0], Tt = Ot.w;
                    for (un[0] = Ot.K[0][0], Ct = 1; Ct < 1 * he; ++Ct) un[Ct] = Dt(ue[Tt + Ct], un[Ct - 1]);
                    for (; Ct < 4 * me; ++Ct) un[Ct] = 0;
                    Ot.K[0] = null, Ot.K[0] = un, yt = 1;
                  }
                }
                ct = yt;
                break;
              case 2:
                break;
              default:
                n(0);
            }
            w = ct;
          }
        }
        if (y = y[0], A = A[0], w && lt(S, 1) && !(w = 1 <= (et = lt(S, 4)) && 11 >= et)) {
          m.a = 3;
          break t;
        }
        var Nt;
        if (Nt = w) e: {
          var Je, ae, be, De = m, bn = y, Cn = A, Ve = et, Ln = d, En = De.m, cn = De.s, we = [null], Se = 1, Ge = 0, ke = $f[Ve];
          n: for (; ; ) {
            if (Ln && lt(En, 1)) {
              var wn = lt(En, 3) + 2, fr = At(bn, wn), Qe = At(Cn, wn), Tn = fr * Qe;
              if (!_r(fr, Qe, 0, De, we)) break n;
              for (we = we[0], cn.xc = wn, Je = 0; Je < Tn; ++Je) {
                var Te = we[Je] >> 8 & 65535;
                we[Je] = Te, Te >= Se && (Se = Te + 1);
              }
            }
            if (En.h) break n;
            for (ae = 0; 5 > ae; ++ae) {
              var fn = Dh[ae];
              !ae && 0 < Ve && (fn += 1 << Ve), Ge < fn && (Ge = fn);
            }
            var Un = u(Se * ke, z), In = Se, zn = u(In, rt);
            if (zn == null) var Hn = null;
            else n(65536 >= In), Hn = zn;
            var Rn = o(Ge);
            if (Hn == null || Rn == null || Un == null) {
              De.a = 1;
              break n;
            }
            var Wn = Un;
            for (Je = be = 0; Je < Se; ++Je) {
              var je = Hn[Je], Vn = je.G, dr = je.H, Vi = 0, Wr = 1, _n = 0;
              for (ae = 0; 5 > ae; ++ae) {
                fn = Dh[ae], Vn[ae] = Wn, dr[ae] = be, !ae && 0 < Ve && (fn += 1 << Ve);
                i: {
                  var is, hl = fn, as = De, ao = Rn, m1 = Wn, v1 = be, ul = 0, hi = as.m, b1 = lt(hi, 1);
                  if (i(ao, 0, 0, hl), b1) {
                    var w1 = lt(hi, 1) + 1, _1 = lt(hi, 1), Kh = lt(hi, _1 == 0 ? 1 : 8);
                    ao[Kh] = 1, w1 == 2 && (ao[Kh = lt(hi, 8)] = 1);
                    var os = 1;
                  } else {
                    var Xh = o(19), Jh = lt(hi, 4) + 4;
                    if (19 < Jh) {
                      as.a = 3;
                      var ss = 0;
                      break i;
                    }
                    for (is = 0; is < Jh; ++is) Xh[Zf[is]] = lt(hi, 3);
                    var cl = void 0, oo = void 0, Qh = as, y1 = Xh, ls = hl, tu = ao, fl = 0, ui = Qh.m, eu = 8, nu = u(128, z);
                    r: for (; C(nu, 0, 7, y1, 19); ) {
                      if (lt(ui, 1)) {
                        var x1 = 2 + 2 * lt(ui, 3);
                        if ((cl = 2 + lt(ui, x1)) > ls) break r;
                      } else cl = ls;
                      for (oo = 0; oo < ls && cl--; ) {
                        nt(ui);
                        var ru = nu[0 + (127 & B(ui))];
                        Y(ui, ui.u + ru.g);
                        var ga = ru.value;
                        if (16 > ga) tu[oo++] = ga, ga != 0 && (eu = ga);
                        else {
                          var A1 = ga == 16, iu = ga - 16, L1 = Vf[iu], au = lt(ui, Wf[iu]) + L1;
                          if (oo + au > ls) break r;
                          for (var N1 = A1 ? eu : 0; 0 < au--; ) tu[oo++] = N1;
                        }
                      }
                      fl = 1;
                      break r;
                    }
                    fl || (Qh.a = 3), os = fl;
                  }
                  (os = os && !hi.h) && (ul = C(m1, v1, 8, ao, hl)), os && ul != 0 ? ss = ul : (as.a = 3, ss = 0);
                }
                if (ss == 0) break n;
                if (Wr && Gf[ae] == 1 && (Wr = Wn[be].g == 0), Vi += Wn[be].g, be += ss, 3 >= ae) {
                  var so, dl = Rn[0];
                  for (so = 1; so < fn; ++so) Rn[so] > dl && (dl = Rn[so]);
                  _n += dl;
                }
              }
              if (je.nd = Wr, je.Qb = 0, Wr && (je.qb = (Vn[3][dr[3] + 0].value << 24 | Vn[1][dr[1] + 0].value << 16 | Vn[2][dr[2] + 0].value) >>> 0, Vi == 0 && 256 > Vn[0][dr[0] + 0].value && (je.Qb = 1, je.qb += Vn[0][dr[0] + 0].value << 8)), je.jc = !je.Qb && 6 > _n, je.jc) {
                var hs, Vr = je;
                for (hs = 0; hs < zi; ++hs) {
                  var ci = hs, fi = Vr.pd[ci], us = Vr.G[0][Vr.H[0] + ci];
                  256 <= us.value ? (fi.g = us.g + 256, fi.value = us.value) : (fi.g = 0, fi.value = 0, ci >>= dn(us, 8, fi), ci >>= dn(Vr.G[1][Vr.H[1] + ci], 16, fi), ci >>= dn(Vr.G[2][Vr.H[2] + ci], 0, fi), dn(Vr.G[3][Vr.H[3] + ci], 24, fi));
                }
              }
            }
            cn.vc = we, cn.Wb = Se, cn.Ya = Hn, cn.yc = Un, Nt = 1;
            break e;
          }
          Nt = 0;
        }
        if (!(w = Nt)) {
          m.a = 3;
          break t;
        }
        if (0 < et) {
          if (E.ua = 1 << et, !R(E.Wa, et)) {
            m.a = 1, w = 0;
            break t;
          }
        } else E.ua = 0;
        var pl = m, ou = y, S1 = A, gl = pl.s, ml = gl.xc;
        if (pl.c = ou, pl.i = S1, gl.md = At(ou, ml), gl.wc = ml == 0 ? -1 : (1 << ml) - 1, d) {
          m.xb = r1;
          break t;
        }
        if ((W = o(y * A)) == null) {
          m.a = 1, w = 0;
          break t;
        }
        w = (w = hr(m, W, 0, y, A, A, null)) && !S.h;
        break t;
      }
      return w ? (b != null ? b[0] = W : (n(W == null), n(d)), m.$ = 0, d || Jn(E)) : Jn(E), w;
    }
    function Ni(a, s) {
      var d = a.c * a.i, m = d + s + 16 * s;
      return n(a.c <= s), a.V = o(m), a.V == null ? (a.Ta = null, a.Ua = 0, a.a = 1, 0) : (a.Ta = a.V, a.Ua = a.Ba + d + s, 1);
    }
    function ra(a, s) {
      var d = a.C, m = s - d, b = a.V, w = a.Ba + a.c * d;
      for (n(s <= a.l.o); 0 < m; ) {
        var y = 16 < m ? 16 : m, A = a.l.ma, S = a.l.width, E = S * y, W = A.ca, et = A.tb + S * d, I = a.Ta, Z = a.Ua;
        Ai(a, y, b, w), Ih(I, Z, W, et, E), wr(A, d, d + y, W, et, S), m -= y, b += y * a.c, d += y;
      }
      n(d == s), a.C = a.Ma = s;
    }
    function ia() {
      this.ub = this.yd = this.td = this.Rb = 0;
    }
    function aa() {
      this.Kd = this.Ld = this.Ud = this.Td = this.i = this.c = 0;
    }
    function Ds() {
      this.Fb = this.Bb = this.Cb = 0, this.Zb = o(4), this.Lb = o(4);
    }
    function Ta() {
      this.Yb = (function() {
        var a = [];
        return (function s(d, m, b) {
          for (var w = b[m], y = 0; y < w && (d.push(b.length > m + 1 ? [] : 0), !(b.length < m + 1)); y++) s(d[y], m + 1, b);
        })(a, 0, [3, 11]), a;
      })();
    }
    function Eo() {
      this.jb = o(3), this.Wc = l([4, 8], Ta), this.Xc = l([4, 17], Ta);
    }
    function Io() {
      this.Pc = this.wb = this.Tb = this.zd = 0, this.vd = new o(4), this.od = new o(4);
    }
    function Qn() {
      this.ld = this.La = this.dd = this.tc = 0;
    }
    function Ra() {
      this.Na = this.la = 0;
    }
    function Fo() {
      this.Sc = [0, 0], this.Eb = [0, 0], this.Qc = [0, 0], this.ia = this.lc = 0;
    }
    function Ma() {
      this.ad = o(384), this.Za = 0, this.Ob = o(16), this.$b = this.Ad = this.ia = this.Gc = this.Hc = this.Dd = 0;
    }
    function Oo() {
      this.uc = this.M = this.Nb = 0, this.wa = Array(new Qn()), this.Y = 0, this.ya = Array(new Ma()), this.aa = 0, this.l = new oa();
    }
    function To() {
      this.y = o(16), this.f = o(8), this.ea = o(8);
    }
    function Ro() {
      this.cb = this.a = 0, this.sc = "", this.m = new _(), this.Od = new ia(), this.Kc = new aa(), this.ed = new Io(), this.Qa = new Ds(), this.Ic = this.$c = this.Aa = 0, this.D = new Oo(), this.Xb = this.Va = this.Hb = this.zb = this.yb = this.Ub = this.za = 0, this.Jc = u(8, _), this.ia = 0, this.pb = u(4, Fo), this.Pa = new Eo(), this.Bd = this.kc = 0, this.Ac = [], this.Bc = 0, this.zc = [0, 0, 0, 0], this.Gd = Array(new To()), this.Hd = 0, this.rb = Array(new Ra()), this.sb = 0, this.wa = Array(new Qn()), this.Y = 0, this.oc = [], this.pc = 0, this.sa = [], this.ta = 0, this.qa = [], this.ra = 0, this.Ha = [], this.B = this.R = this.Ia = 0, this.Ec = [], this.M = this.ja = this.Vb = this.Fc = 0, this.ya = Array(new Ma()), this.L = this.aa = 0, this.gd = l([4, 2], Qn), this.ga = null, this.Fa = [], this.Cc = this.qc = this.P = 0, this.Gb = [], this.Uc = 0, this.mb = [], this.nb = 0, this.rc = [], this.Ga = this.Vc = 0;
    }
    function oa() {
      this.T = this.U = this.ka = this.height = this.width = 0, this.y = [], this.f = [], this.ea = [], this.Rc = this.fa = this.W = this.N = this.O = 0, this.ma = "void", this.put = "VP8IoPutHook", this.ac = "VP8IoSetupHook", this.bc = "VP8IoTeardownHook", this.ha = this.Kb = 0, this.data = [], this.hb = this.ib = this.da = this.o = this.j = this.va = this.v = this.Da = this.ob = this.w = 0, this.F = [], this.J = 0;
    }
    function qs() {
      var a = new Ro();
      return a != null && (a.a = 0, a.sc = "OK", a.cb = 0, a.Xb = 0, ro || (ro = Rr)), a;
    }
    function rn(a, s, d) {
      return a.a == 0 && (a.a = s, a.sc = d, a.cb = 0), 0;
    }
    function Mo(a, s, d) {
      return 3 <= d && a[s + 0] == 157 && a[s + 1] == 1 && a[s + 2] == 42;
    }
    function Bo(a, s) {
      if (a == null) return 0;
      if (a.a = 0, a.sc = "OK", s == null) return rn(a, 2, "null VP8Io passed to VP8GetHeaders()");
      var d = s.data, m = s.w, b = s.ha;
      if (4 > b) return rn(a, 7, "Truncated header.");
      var w = d[m + 0] | d[m + 1] << 8 | d[m + 2] << 16, y = a.Od;
      if (y.Rb = !(1 & w), y.td = w >> 1 & 7, y.yd = w >> 4 & 1, y.ub = w >> 5, 3 < y.td) return rn(a, 3, "Incorrect keyframe parameters.");
      if (!y.yd) return rn(a, 4, "Frame not displayable.");
      m += 3, b -= 3;
      var A = a.Kc;
      if (y.Rb) {
        if (7 > b) return rn(a, 7, "cannot parse picture header");
        if (!Mo(d, m, b)) return rn(a, 3, "Bad code word");
        A.c = 16383 & (d[m + 4] << 8 | d[m + 3]), A.Td = d[m + 4] >> 6, A.i = 16383 & (d[m + 6] << 8 | d[m + 5]), A.Ud = d[m + 6] >> 6, m += 7, b -= 7, a.za = A.c + 15 >> 4, a.Ub = A.i + 15 >> 4, s.width = A.c, s.height = A.i, s.Da = 0, s.j = 0, s.v = 0, s.va = s.width, s.o = s.height, s.da = 0, s.ib = s.width, s.hb = s.height, s.U = s.width, s.T = s.height, i((w = a.Pa).jb, 0, 255, w.jb.length), n((w = a.Qa) != null), w.Cb = 0, w.Bb = 0, w.Fb = 1, i(w.Zb, 0, 0, w.Zb.length), i(w.Lb, 0, 0, w.Lb);
      }
      if (y.ub > b) return rn(a, 7, "bad partition length");
      st(w = a.m, d, m, y.ub), m += y.ub, b -= y.ub, y.Rb && (A.Ld = at(w), A.Kd = at(w)), A = a.Qa;
      var S, E = a.Pa;
      if (n(w != null), n(A != null), A.Cb = at(w), A.Cb) {
        if (A.Bb = at(w), at(w)) {
          for (A.Fb = at(w), S = 0; 4 > S; ++S) A.Zb[S] = at(w) ? tt(w, 7) : 0;
          for (S = 0; 4 > S; ++S) A.Lb[S] = at(w) ? tt(w, 6) : 0;
        }
        if (A.Bb) for (S = 0; 3 > S; ++S) E.jb[S] = at(w) ? ht(w, 8) : 255;
      } else A.Bb = 0;
      if (w.Ka) return rn(a, 3, "cannot parse segment header");
      if ((A = a.ed).zd = at(w), A.Tb = ht(w, 6), A.wb = ht(w, 3), A.Pc = at(w), A.Pc && at(w)) {
        for (E = 0; 4 > E; ++E) at(w) && (A.vd[E] = tt(w, 6));
        for (E = 0; 4 > E; ++E) at(w) && (A.od[E] = tt(w, 6));
      }
      if (a.L = A.Tb == 0 ? 0 : A.zd ? 1 : 2, w.Ka) return rn(a, 3, "cannot parse filter header");
      var W = b;
      if (b = S = m, m = S + W, A = W, a.Xb = (1 << ht(a.m, 2)) - 1, W < 3 * (E = a.Xb)) d = 7;
      else {
        for (S += 3 * E, A -= 3 * E, W = 0; W < E; ++W) {
          var et = d[b + 0] | d[b + 1] << 8 | d[b + 2] << 16;
          et > A && (et = A), st(a.Jc[+W], d, S, et), S += et, A -= et, b += 3;
        }
        st(a.Jc[+E], d, S, A), d = S < m ? 0 : 5;
      }
      if (d != 0) return rn(a, d, "cannot parse partitions");
      for (d = ht(S = a.m, 7), b = at(S) ? tt(S, 4) : 0, m = at(S) ? tt(S, 4) : 0, A = at(S) ? tt(S, 4) : 0, E = at(S) ? tt(S, 4) : 0, S = at(S) ? tt(S, 4) : 0, W = a.Qa, et = 0; 4 > et; ++et) {
        if (W.Cb) {
          var I = W.Zb[et];
          W.Fb || (I += d);
        } else {
          if (0 < et) {
            a.pb[et] = a.pb[0];
            continue;
          }
          I = d;
        }
        var Z = a.pb[et];
        Z.Sc[0] = ol[We(I + b, 127)], Z.Sc[1] = sl[We(I + 0, 127)], Z.Eb[0] = 2 * ol[We(I + m, 127)], Z.Eb[1] = 101581 * sl[We(I + A, 127)] >> 16, 8 > Z.Eb[1] && (Z.Eb[1] = 8), Z.Qc[0] = ol[We(I + E, 117)], Z.Qc[1] = sl[We(I + S, 127)], Z.lc = I + S;
      }
      if (!y.Rb) return rn(a, 4, "Not a key frame.");
      for (at(w), y = a.Pa, d = 0; 4 > d; ++d) {
        for (b = 0; 8 > b; ++b) for (m = 0; 3 > m; ++m) for (A = 0; 11 > A; ++A) E = vt(w, e1[d][b][m][A]) ? ht(w, 8) : Qf[d][b][m][A], y.Wc[d][b].Yb[m][A] = E;
        for (b = 0; 17 > b; ++b) y.Xc[d][b] = y.Wc[d][n1[b]];
      }
      return a.kc = at(w), a.kc && (a.Bd = ht(w, 8)), a.cb = 1;
    }
    function Rr(a, s, d, m, b, w, y) {
      var A = s[b].Yb[d];
      for (d = 0; 16 > b; ++b) {
        if (!vt(a, A[d + 0])) return b;
        for (; !vt(a, A[d + 1]); ) if (A = s[++b].Yb[0], d = 0, b == 16) return 16;
        var S = s[b + 1].Yb;
        if (vt(a, A[d + 2])) {
          var E = a, W = 0;
          if (vt(E, (I = A)[(et = d) + 3])) if (vt(E, I[et + 6])) {
            for (A = 0, et = 2 * (W = vt(E, I[et + 8])) + (I = vt(E, I[et + 9 + W])), W = 0, I = Xf[et]; I[A]; ++A) W += W + vt(E, I[A]);
            W += 3 + (8 << et);
          } else vt(E, I[et + 7]) ? (W = 7 + 2 * vt(E, 165), W += vt(E, 145)) : W = 5 + vt(E, 159);
          else W = vt(E, I[et + 4]) ? 3 + vt(E, I[et + 5]) : 2;
          A = S[2];
        } else W = 1, A = S[1];
        S = y + Jf[b], 0 > (E = a).b && ot(E);
        var et, I = E.b, Z = (et = E.Ca >> 1) - (E.I >> I) >> 31;
        --E.b, E.Ca += Z, E.Ca |= 1, E.I -= (et + 1 & Z) << I, w[S] = ((W ^ Z) - Z) * m[(0 < b) + 0];
      }
      return 16;
    }
    function Si(a) {
      var s = a.rb[a.sb - 1];
      s.la = 0, s.Na = 0, i(a.zc, 0, 0, a.zc.length), a.ja = 0;
    }
    function ur(a, s, d, m, b) {
      b = a[s + d + 32 * m] + (b >> 3), a[s + d + 32 * m] = -256 & b ? 0 > b ? 0 : 255 : b;
    }
    function ki(a, s, d, m, b, w) {
      ur(a, s, 0, d, m + b), ur(a, s, 1, d, m + w), ur(a, s, 2, d, m - w), ur(a, s, 3, d, m - b);
    }
    function $e(a) {
      return (20091 * a >> 16) + a;
    }
    function Ba(a, s, d, m) {
      var b, w = 0, y = o(16);
      for (b = 0; 4 > b; ++b) {
        var A = a[s + 0] + a[s + 8], S = a[s + 0] - a[s + 8], E = (35468 * a[s + 4] >> 16) - $e(a[s + 12]), W = $e(a[s + 4]) + (35468 * a[s + 12] >> 16);
        y[w + 0] = A + W, y[w + 1] = S + E, y[w + 2] = S - E, y[w + 3] = A - W, w += 4, s++;
      }
      for (b = w = 0; 4 > b; ++b) A = (a = y[w + 0] + 4) + y[w + 8], S = a - y[w + 8], E = (35468 * y[w + 4] >> 16) - $e(y[w + 12]), ur(d, m, 0, 0, A + (W = $e(y[w + 4]) + (35468 * y[w + 12] >> 16))), ur(d, m, 1, 0, S + E), ur(d, m, 2, 0, S - E), ur(d, m, 3, 0, A - W), w++, m += 32;
    }
    function Us(a, s, d, m) {
      var b = a[s + 0] + 4, w = 35468 * a[s + 4] >> 16, y = $e(a[s + 4]), A = 35468 * a[s + 1] >> 16;
      ki(d, m, 0, b + y, a = $e(a[s + 1]), A), ki(d, m, 1, b + w, a, A), ki(d, m, 2, b - w, a, A), ki(d, m, 3, b - y, a, A);
    }
    function zs(a, s, d, m, b) {
      Ba(a, s, d, m), b && Ba(a, s + 16, d, m + 4);
    }
    function Hs(a, s, d, m) {
      Wi(a, s + 0, d, m, 1), Wi(a, s + 32, d, m + 128, 1);
    }
    function yr(a, s, d, m) {
      var b;
      for (a = a[s + 0] + 4, b = 0; 4 > b; ++b) for (s = 0; 4 > s; ++s) ur(d, m, s, b, a);
    }
    function jo(a, s, d, m) {
      a[s + 0] && Ne(a, s + 0, d, m), a[s + 16] && Ne(a, s + 16, d, m + 4), a[s + 32] && Ne(a, s + 32, d, m + 128), a[s + 48] && Ne(a, s + 48, d, m + 128 + 4);
    }
    function Do(a, s, d, m) {
      var b, w = o(16);
      for (b = 0; 4 > b; ++b) {
        var y = a[s + 0 + b] + a[s + 12 + b], A = a[s + 4 + b] + a[s + 8 + b], S = a[s + 4 + b] - a[s + 8 + b], E = a[s + 0 + b] - a[s + 12 + b];
        w[0 + b] = y + A, w[8 + b] = y - A, w[4 + b] = E + S, w[12 + b] = E - S;
      }
      for (b = 0; 4 > b; ++b) y = (a = w[0 + 4 * b] + 3) + w[3 + 4 * b], A = w[1 + 4 * b] + w[2 + 4 * b], S = w[1 + 4 * b] - w[2 + 4 * b], E = a - w[3 + 4 * b], d[m + 0] = y + A >> 3, d[m + 16] = E + S >> 3, d[m + 32] = y - A >> 3, d[m + 48] = E - S >> 3, m += 64;
    }
    function Xr(a, s, d) {
      var m, b = s - 32, w = qn, y = 255 - a[b - 1];
      for (m = 0; m < d; ++m) {
        var A, S = w, E = y + a[s - 1];
        for (A = 0; A < d; ++A) a[s + A] = S[E + a[b + A]];
        s += 32;
      }
    }
    function ja(a, s) {
      Xr(a, s, 4);
    }
    function Ws(a, s) {
      Xr(a, s, 8);
    }
    function Vs(a, s) {
      Xr(a, s, 16);
    }
    function Gs(a, s) {
      var d;
      for (d = 0; 16 > d; ++d) r(a, s + 32 * d, a, s - 32, 16);
    }
    function Da(a, s) {
      var d;
      for (d = 16; 0 < d; --d) i(a, s, a[s - 1], 16), s += 32;
    }
    function Pi(a, s, d) {
      var m;
      for (m = 0; 16 > m; ++m) i(s, d + 32 * m, a, 16);
    }
    function Jr(a, s) {
      var d, m = 16;
      for (d = 0; 16 > d; ++d) m += a[s - 1 + 32 * d] + a[s + d - 32];
      Pi(m >> 5, a, s);
    }
    function Zs(a, s) {
      var d, m = 8;
      for (d = 0; 16 > d; ++d) m += a[s - 1 + 32 * d];
      Pi(m >> 4, a, s);
    }
    function Ci(a, s) {
      var d, m = 8;
      for (d = 0; 16 > d; ++d) m += a[s + d - 32];
      Pi(m >> 4, a, s);
    }
    function qa(a, s) {
      Pi(128, a, s);
    }
    function Jt(a, s, d) {
      return a + 2 * s + d + 2 >> 2;
    }
    function Ys(a, s) {
      var d, m = s - 32;
      for (m = new Uint8Array([Jt(a[m - 1], a[m + 0], a[m + 1]), Jt(a[m + 0], a[m + 1], a[m + 2]), Jt(a[m + 1], a[m + 2], a[m + 3]), Jt(a[m + 2], a[m + 3], a[m + 4])]), d = 0; 4 > d; ++d) r(a, s + 32 * d, m, 0, m.length);
    }
    function $s(a, s) {
      var d = a[s - 1], m = a[s - 1 + 32], b = a[s - 1 + 64], w = a[s - 1 + 96];
      xt(a, s + 0, 16843009 * Jt(a[s - 1 - 32], d, m)), xt(a, s + 32, 16843009 * Jt(d, m, b)), xt(a, s + 64, 16843009 * Jt(m, b, w)), xt(a, s + 96, 16843009 * Jt(b, w, w));
    }
    function Ks(a, s) {
      var d, m = 4;
      for (d = 0; 4 > d; ++d) m += a[s + d - 32] + a[s - 1 + 32 * d];
      for (m >>= 3, d = 0; 4 > d; ++d) i(a, s + 32 * d, m, 4);
    }
    function Xs(a, s) {
      var d = a[s - 1 + 0], m = a[s - 1 + 32], b = a[s - 1 + 64], w = a[s - 1 - 32], y = a[s + 0 - 32], A = a[s + 1 - 32], S = a[s + 2 - 32], E = a[s + 3 - 32];
      a[s + 0 + 96] = Jt(m, b, a[s - 1 + 96]), a[s + 1 + 96] = a[s + 0 + 64] = Jt(d, m, b), a[s + 2 + 96] = a[s + 1 + 64] = a[s + 0 + 32] = Jt(w, d, m), a[s + 3 + 96] = a[s + 2 + 64] = a[s + 1 + 32] = a[s + 0 + 0] = Jt(y, w, d), a[s + 3 + 64] = a[s + 2 + 32] = a[s + 1 + 0] = Jt(A, y, w), a[s + 3 + 32] = a[s + 2 + 0] = Jt(S, A, y), a[s + 3 + 0] = Jt(E, S, A);
    }
    function Mr(a, s) {
      var d = a[s + 1 - 32], m = a[s + 2 - 32], b = a[s + 3 - 32], w = a[s + 4 - 32], y = a[s + 5 - 32], A = a[s + 6 - 32], S = a[s + 7 - 32];
      a[s + 0 + 0] = Jt(a[s + 0 - 32], d, m), a[s + 1 + 0] = a[s + 0 + 32] = Jt(d, m, b), a[s + 2 + 0] = a[s + 1 + 32] = a[s + 0 + 64] = Jt(m, b, w), a[s + 3 + 0] = a[s + 2 + 32] = a[s + 1 + 64] = a[s + 0 + 96] = Jt(b, w, y), a[s + 3 + 32] = a[s + 2 + 64] = a[s + 1 + 96] = Jt(w, y, A), a[s + 3 + 64] = a[s + 2 + 96] = Jt(y, A, S), a[s + 3 + 96] = Jt(A, S, S);
    }
    function Br(a, s) {
      var d = a[s - 1 + 0], m = a[s - 1 + 32], b = a[s - 1 + 64], w = a[s - 1 - 32], y = a[s + 0 - 32], A = a[s + 1 - 32], S = a[s + 2 - 32], E = a[s + 3 - 32];
      a[s + 0 + 0] = a[s + 1 + 64] = w + y + 1 >> 1, a[s + 1 + 0] = a[s + 2 + 64] = y + A + 1 >> 1, a[s + 2 + 0] = a[s + 3 + 64] = A + S + 1 >> 1, a[s + 3 + 0] = S + E + 1 >> 1, a[s + 0 + 96] = Jt(b, m, d), a[s + 0 + 64] = Jt(m, d, w), a[s + 0 + 32] = a[s + 1 + 96] = Jt(d, w, y), a[s + 1 + 32] = a[s + 2 + 96] = Jt(w, y, A), a[s + 2 + 32] = a[s + 3 + 96] = Jt(y, A, S), a[s + 3 + 32] = Jt(A, S, E);
    }
    function Js(a, s) {
      var d = a[s + 0 - 32], m = a[s + 1 - 32], b = a[s + 2 - 32], w = a[s + 3 - 32], y = a[s + 4 - 32], A = a[s + 5 - 32], S = a[s + 6 - 32], E = a[s + 7 - 32];
      a[s + 0 + 0] = d + m + 1 >> 1, a[s + 1 + 0] = a[s + 0 + 64] = m + b + 1 >> 1, a[s + 2 + 0] = a[s + 1 + 64] = b + w + 1 >> 1, a[s + 3 + 0] = a[s + 2 + 64] = w + y + 1 >> 1, a[s + 0 + 32] = Jt(d, m, b), a[s + 1 + 32] = a[s + 0 + 96] = Jt(m, b, w), a[s + 2 + 32] = a[s + 1 + 96] = Jt(b, w, y), a[s + 3 + 32] = a[s + 2 + 96] = Jt(w, y, A), a[s + 3 + 64] = Jt(y, A, S), a[s + 3 + 96] = Jt(A, S, E);
    }
    function Qs(a, s) {
      var d = a[s - 1 + 0], m = a[s - 1 + 32], b = a[s - 1 + 64], w = a[s - 1 + 96];
      a[s + 0 + 0] = d + m + 1 >> 1, a[s + 2 + 0] = a[s + 0 + 32] = m + b + 1 >> 1, a[s + 2 + 32] = a[s + 0 + 64] = b + w + 1 >> 1, a[s + 1 + 0] = Jt(d, m, b), a[s + 3 + 0] = a[s + 1 + 32] = Jt(m, b, w), a[s + 3 + 32] = a[s + 1 + 64] = Jt(b, w, w), a[s + 3 + 64] = a[s + 2 + 64] = a[s + 0 + 96] = a[s + 1 + 96] = a[s + 2 + 96] = a[s + 3 + 96] = w;
    }
    function sa(a, s) {
      var d = a[s - 1 + 0], m = a[s - 1 + 32], b = a[s - 1 + 64], w = a[s - 1 + 96], y = a[s - 1 - 32], A = a[s + 0 - 32], S = a[s + 1 - 32], E = a[s + 2 - 32];
      a[s + 0 + 0] = a[s + 2 + 32] = d + y + 1 >> 1, a[s + 0 + 32] = a[s + 2 + 64] = m + d + 1 >> 1, a[s + 0 + 64] = a[s + 2 + 96] = b + m + 1 >> 1, a[s + 0 + 96] = w + b + 1 >> 1, a[s + 3 + 0] = Jt(A, S, E), a[s + 2 + 0] = Jt(y, A, S), a[s + 1 + 0] = a[s + 3 + 32] = Jt(d, y, A), a[s + 1 + 32] = a[s + 3 + 64] = Jt(m, d, y), a[s + 1 + 64] = a[s + 3 + 96] = Jt(b, m, d), a[s + 1 + 96] = Jt(w, b, m);
    }
    function Ua(a, s) {
      var d;
      for (d = 0; 8 > d; ++d) r(a, s + 32 * d, a, s - 32, 8);
    }
    function Ei(a, s) {
      var d;
      for (d = 0; 8 > d; ++d) i(a, s, a[s - 1], 8), s += 32;
    }
    function la(a, s, d) {
      var m;
      for (m = 0; 8 > m; ++m) i(s, d + 32 * m, a, 8);
    }
    function ha(a, s) {
      var d, m = 8;
      for (d = 0; 8 > d; ++d) m += a[s + d - 32] + a[s - 1 + 32 * d];
      la(m >> 4, a, s);
    }
    function tl(a, s) {
      var d, m = 4;
      for (d = 0; 8 > d; ++d) m += a[s + d - 32];
      la(m >> 3, a, s);
    }
    function za(a, s) {
      var d, m = 4;
      for (d = 0; 8 > d; ++d) m += a[s - 1 + 32 * d];
      la(m >> 3, a, s);
    }
    function Ha(a, s) {
      la(128, a, s);
    }
    function Ii(a, s, d) {
      var m = a[s - d], b = a[s + 0], w = 3 * (b - m) + el[1020 + a[s - 2 * d] - a[s + d]], y = $o[112 + (w + 4 >> 3)];
      a[s - d] = qn[255 + m + $o[112 + (w + 3 >> 3)]], a[s + 0] = qn[255 + b - y];
    }
    function Fi(a, s, d, m) {
      var b = a[s + 0], w = a[s + d];
      return rr[255 + a[s - 2 * d] - a[s - d]] > m || rr[255 + w - b] > m;
    }
    function Wa(a, s, d, m) {
      return 4 * rr[255 + a[s - d] - a[s + 0]] + rr[255 + a[s - 2 * d] - a[s + d]] <= m;
    }
    function ua(a, s, d, m, b) {
      var w = a[s - 3 * d], y = a[s - 2 * d], A = a[s - d], S = a[s + 0], E = a[s + d], W = a[s + 2 * d], et = a[s + 3 * d];
      return 4 * rr[255 + A - S] + rr[255 + y - E] > m ? 0 : rr[255 + a[s - 4 * d] - w] <= b && rr[255 + w - y] <= b && rr[255 + y - A] <= b && rr[255 + et - W] <= b && rr[255 + W - E] <= b && rr[255 + E - S] <= b;
    }
    function Va(a, s, d, m) {
      var b = 2 * m + 1;
      for (m = 0; 16 > m; ++m) Wa(a, s + m, d, b) && Ii(a, s + m, d);
    }
    function Oi(a, s, d, m) {
      var b = 2 * m + 1;
      for (m = 0; 16 > m; ++m) Wa(a, s + m * d, 1, b) && Ii(a, s + m * d, 1);
    }
    function qo(a, s, d, m) {
      var b;
      for (b = 3; 0 < b; --b) Va(a, s += 4 * d, d, m);
    }
    function Uo(a, s, d, m) {
      var b;
      for (b = 3; 0 < b; --b) Oi(a, s += 4, d, m);
    }
    function jr(a, s, d, m, b, w, y, A) {
      for (w = 2 * w + 1; 0 < b--; ) {
        if (ua(a, s, d, w, y)) if (Fi(a, s, d, A)) Ii(a, s, d);
        else {
          var S = a, E = s, W = d, et = S[E - 2 * W], I = S[E - W], Z = S[E + 0], X = S[E + W], ct = S[E + 2 * W], Q = 27 * (mt = el[1020 + 3 * (Z - I) + el[1020 + et - X]]) + 63 >> 7, pt = 18 * mt + 63 >> 7, mt = 9 * mt + 63 >> 7;
          S[E - 3 * W] = qn[255 + S[E - 3 * W] + mt], S[E - 2 * W] = qn[255 + et + pt], S[E - W] = qn[255 + I + Q], S[E + 0] = qn[255 + Z - Q], S[E + W] = qn[255 + X - pt], S[E + 2 * W] = qn[255 + ct - mt];
        }
        s += m;
      }
    }
    function Dr(a, s, d, m, b, w, y, A) {
      for (w = 2 * w + 1; 0 < b--; ) {
        if (ua(a, s, d, w, y)) if (Fi(a, s, d, A)) Ii(a, s, d);
        else {
          var S = a, E = s, W = d, et = S[E - W], I = S[E + 0], Z = S[E + W], X = $o[112 + (4 + (ct = 3 * (I - et)) >> 3)], ct = $o[112 + (ct + 3 >> 3)], Q = X + 1 >> 1;
          S[E - 2 * W] = qn[255 + S[E - 2 * W] + Q], S[E - W] = qn[255 + et + ct], S[E + 0] = qn[255 + I - X], S[E + W] = qn[255 + Z - Q];
        }
        s += m;
      }
    }
    function zo(a, s, d, m, b, w) {
      jr(a, s, d, 1, 16, m, b, w);
    }
    function Ho(a, s, d, m, b, w) {
      jr(a, s, 1, d, 16, m, b, w);
    }
    function Ti(a, s, d, m, b, w) {
      var y;
      for (y = 3; 0 < y; --y) Dr(a, s += 4 * d, d, 1, 16, m, b, w);
    }
    function Wo(a, s, d, m, b, w) {
      var y;
      for (y = 3; 0 < y; --y) Dr(a, s += 4, 1, d, 16, m, b, w);
    }
    function h(a, s, d, m, b, w, y, A) {
      jr(a, s, b, 1, 8, w, y, A), jr(d, m, b, 1, 8, w, y, A);
    }
    function v(a, s, d, m, b, w, y, A) {
      jr(a, s, 1, b, 8, w, y, A), jr(d, m, 1, b, 8, w, y, A);
    }
    function F(a, s, d, m, b, w, y, A) {
      Dr(a, s + 4 * b, b, 1, 8, w, y, A), Dr(d, m + 4 * b, b, 1, 8, w, y, A);
    }
    function U(a, s, d, m, b, w, y, A) {
      Dr(a, s + 4, 1, b, 8, w, y, A), Dr(d, m + 4, 1, b, 8, w, y, A);
    }
    function K() {
      this.ba = new Fe(), this.ec = [], this.cc = [], this.Mc = [], this.Dc = this.Nc = this.dc = this.fc = 0, this.Oa = new Le(), this.memory = 0, this.Ib = "OutputFunc", this.Jb = "OutputAlphaFunc", this.Nd = "OutputRowFunc";
    }
    function gt() {
      this.data = [], this.offset = this.kd = this.ha = this.w = 0, this.na = [], this.xa = this.gb = this.Ja = this.Sa = this.P = 0;
    }
    function _t() {
      this.nc = this.Ea = this.b = this.hc = 0, this.K = [], this.w = 0;
    }
    function It() {
      this.ua = 0, this.Wa = new oe(), this.vb = new oe(), this.md = this.xc = this.wc = 0, this.vc = [], this.Wb = 0, this.Ya = new rt(), this.yc = new z();
    }
    function Rt() {
      this.xb = this.a = 0, this.l = new oa(), this.ca = new Fe(), this.V = [], this.Ba = 0, this.Ta = [], this.Ua = 0, this.m = new T(), this.Pb = 0, this.wd = new T(), this.Ma = this.$ = this.C = this.i = this.c = this.xd = 0, this.s = new It(), this.ab = 0, this.gc = u(4, _t), this.Oc = 0;
    }
    function Kt() {
      this.Lc = this.Z = this.$a = this.i = this.c = 0, this.l = new oa(), this.ic = 0, this.ca = [], this.tb = 0, this.qd = null, this.rd = 0;
    }
    function Qt(a, s, d, m, b, w, y) {
      for (a = a == null ? 0 : a[s + 0], s = 0; s < y; ++s) b[w + s] = a + d[m + s] & 255, a = b[w + s];
    }
    function xe(a, s, d, m, b, w, y) {
      var A;
      if (a == null) Qt(null, null, d, m, b, w, y);
      else for (A = 0; A < y; ++A) b[w + A] = a[s + A] + d[m + A] & 255;
    }
    function ze(a, s, d, m, b, w, y) {
      if (a == null) Qt(null, null, d, m, b, w, y);
      else {
        var A, S = a[s + 0], E = S, W = S;
        for (A = 0; A < y; ++A) E = W + (S = a[s + A]) - E, W = d[m + A] + (-256 & E ? 0 > E ? 0 : 255 : E) & 255, E = S, b[w + A] = W;
      }
    }
    function an(a, s, d, m) {
      var b = s.width, w = s.o;
      if (n(a != null && s != null), 0 > d || 0 >= m || d + m > w) return null;
      if (!a.Cc) {
        if (a.ga == null) {
          var y;
          if (a.ga = new Kt(), (y = a.ga == null) || (y = s.width * s.o, n(a.Gb.length == 0), a.Gb = o(y), a.Uc = 0, a.Gb == null ? y = 0 : (a.mb = a.Gb, a.nb = a.Uc, a.rc = null, y = 1), y = !y), !y) {
            y = a.ga;
            var A = a.Fa, S = a.P, E = a.qc, W = a.mb, et = a.nb, I = S + 1, Z = E - 1, X = y.l;
            if (n(A != null && W != null && s != null), li[0] = null, li[1] = Qt, li[2] = xe, li[3] = ze, y.ca = W, y.tb = et, y.c = s.width, y.i = s.height, n(0 < y.c && 0 < y.i), 1 >= E) s = 0;
            else if (y.$a = 3 & A[S + 0], y.Z = A[S + 0] >> 2 & 3, y.Lc = A[S + 0] >> 4 & 3, S = A[S + 0] >> 6 & 3, 0 > y.$a || 1 < y.$a || 4 <= y.Z || 1 < y.Lc || S) s = 0;
            else if (X.put = Vt, X.ac = br, X.bc = Or, X.ma = y, X.width = s.width, X.height = s.height, X.Da = s.Da, X.v = s.v, X.va = s.va, X.j = s.j, X.o = s.o, y.$a) t: {
              n(y.$a == 1), s = Li();
              e: for (; ; ) {
                if (s == null) {
                  s = 0;
                  break t;
                }
                if (n(y != null), y.mc = s, s.c = y.c, s.i = y.i, s.l = y.l, s.l.ma = y, s.l.width = y.c, s.l.height = y.i, s.a = 0, ft(s.m, A, I, Z), !_r(y.c, y.i, 1, s, null) || (s.ab == 1 && s.gc[0].hc == 3 && sr(s.s) ? (y.ic = 1, A = s.c * s.i, s.Ta = null, s.Ua = 0, s.V = o(A), s.Ba = 0, s.V == null ? (s.a = 1, s = 0) : s = 1) : (y.ic = 0, s = Ni(s, y.c)), !s)) break e;
                s = 1;
                break t;
              }
              y.mc = null, s = 0;
            }
            else s = Z >= y.c * y.i;
            y = !s;
          }
          if (y) return null;
          a.ga.Lc != 1 ? a.Ga = 0 : m = w - d;
        }
        n(a.ga != null), n(d + m <= w);
        t: {
          if (s = (A = a.ga).c, w = A.l.o, A.$a == 0) {
            if (I = a.rc, Z = a.Vc, X = a.Fa, S = a.P + 1 + d * s, E = a.mb, W = a.nb + d * s, n(S <= a.P + a.qc), A.Z != 0) for (n(li[A.Z] != null), y = 0; y < m; ++y) li[A.Z](I, Z, X, S, E, W, s), I = E, Z = W, W += s, S += s;
            else for (y = 0; y < m; ++y) r(E, W, X, S, s), I = E, Z = W, W += s, S += s;
            a.rc = I, a.Vc = Z;
          } else {
            if (n(A.mc != null), s = d + m, n((y = A.mc) != null), n(s <= y.i), y.C >= s) s = 1;
            else if (A.ic || tr(), A.ic) {
              A = y.V, I = y.Ba, Z = y.c;
              var ct = y.i, Q = (X = 1, S = y.$ / Z, E = y.$ % Z, W = y.m, et = y.s, y.$), pt = Z * ct, mt = Z * s, yt = et.wc, wt = Q < mt ? mn(et, E, S) : null;
              n(Q <= pt), n(s <= ct), n(sr(et));
              e: for (; ; ) {
                for (; !W.h && Q < mt; ) {
                  if (E & yt || (wt = mn(et, E, S)), n(wt != null), nt(W), 256 > (ct = He(wt.G[0], wt.H[0], W))) A[I + Q] = ct, ++Q, ++E >= Z && (E = 0, ++S <= s && !(S % 16) && lr(y, S));
                  else {
                    if (!(280 > ct)) {
                      X = 0;
                      break e;
                    }
                    ct = Kn(ct - 256, W);
                    var Bt, Ct = He(wt.G[4], wt.H[4], W);
                    if (nt(W), !(Q >= (Ct = Xn(Z, Ct = Kn(Ct, W))) && pt - Q >= ct)) {
                      X = 0;
                      break e;
                    }
                    for (Bt = 0; Bt < ct; ++Bt) A[I + Q + Bt] = A[I + Q + Bt - Ct];
                    for (Q += ct, E += ct; E >= Z; ) E -= Z, ++S <= s && !(S % 16) && lr(y, S);
                    Q < mt && E & yt && (wt = mn(et, E, S));
                  }
                  n(W.h == H(W));
                }
                lr(y, S > s ? s : S);
                break e;
              }
              !X || W.h && Q < pt ? (X = 0, y.a = W.h ? 5 : 3) : y.$ = Q, s = X;
            } else s = hr(y, y.V, y.Ba, y.c, y.i, s, ra);
            if (!s) {
              m = 0;
              break t;
            }
          }
          d + m >= w && (a.Cc = 1), m = 1;
        }
        if (!m) return null;
        if (a.Cc && ((m = a.ga) != null && (m.mc = null), a.ga = null, 0 < a.Ga)) return alert("todo:WebPDequantizeLevels"), null;
      }
      return a.nb + d * b;
    }
    function Be(a, s, d, m, b, w) {
      for (; 0 < b--; ) {
        var y, A = a, S = s + (d ? 1 : 0), E = a, W = s + (d ? 0 : 3);
        for (y = 0; y < m; ++y) {
          var et = E[W + 4 * y];
          et != 255 && (et *= 32897, A[S + 4 * y + 0] = A[S + 4 * y + 0] * et >> 23, A[S + 4 * y + 1] = A[S + 4 * y + 1] * et >> 23, A[S + 4 * y + 2] = A[S + 4 * y + 2] * et >> 23);
        }
        s += w;
      }
    }
    function ln(a, s, d, m, b) {
      for (; 0 < m--; ) {
        var w;
        for (w = 0; w < d; ++w) {
          var y = a[s + 2 * w + 0], A = 15 & (E = a[s + 2 * w + 1]), S = 4369 * A, E = (240 & E | E >> 4) * S >> 16;
          a[s + 2 * w + 0] = (240 & y | y >> 4) * S >> 16 & 240 | (15 & y | y << 4) * S >> 16 >> 4 & 15, a[s + 2 * w + 1] = 240 & E | A;
        }
        s += b;
      }
    }
    function on(a, s, d, m, b, w, y, A) {
      var S, E, W = 255;
      for (E = 0; E < b; ++E) {
        for (S = 0; S < m; ++S) {
          var et = a[s + S];
          w[y + 4 * S] = et, W &= et;
        }
        s += d, y += A;
      }
      return W != 255;
    }
    function vn(a, s, d, m, b) {
      var w;
      for (w = 0; w < b; ++w) d[m + w] = a[s + w] >> 8;
    }
    function tr() {
      no = Be, Ch = ln, Eh = on, Ih = vn;
    }
    function On(a, s, d) {
      j[a] = function(m, b, w, y, A, S, E, W, et, I, Z, X, ct, Q, pt, mt, yt) {
        var wt, Bt = yt - 1 >> 1, Ct = A[S + 0] | E[W + 0] << 16, he = et[I + 0] | Z[X + 0] << 16;
        n(m != null);
        var Ot = 3 * Ct + he + 131074 >> 2;
        for (s(m[b + 0], 255 & Ot, Ot >> 16, ct, Q), w != null && (Ot = 3 * he + Ct + 131074 >> 2, s(w[y + 0], 255 & Ot, Ot >> 16, pt, mt)), wt = 1; wt <= Bt; ++wt) {
          var me = A[S + wt] | E[W + wt] << 16, un = et[I + wt] | Z[X + wt] << 16, ue = Ct + me + he + un + 524296, Tt = ue + 2 * (me + he) >> 3;
          Ot = Tt + Ct >> 1, Ct = (ue = ue + 2 * (Ct + un) >> 3) + me >> 1, s(m[b + 2 * wt - 1], 255 & Ot, Ot >> 16, ct, Q + (2 * wt - 1) * d), s(m[b + 2 * wt - 0], 255 & Ct, Ct >> 16, ct, Q + (2 * wt - 0) * d), w != null && (Ot = ue + he >> 1, Ct = Tt + un >> 1, s(w[y + 2 * wt - 1], 255 & Ot, Ot >> 16, pt, mt + (2 * wt - 1) * d), s(w[y + 2 * wt + 0], 255 & Ct, Ct >> 16, pt, mt + (2 * wt + 0) * d)), Ct = me, he = un;
        }
        1 & yt || (Ot = 3 * Ct + he + 131074 >> 2, s(m[b + yt - 1], 255 & Ot, Ot >> 16, ct, Q + (yt - 1) * d), w != null && (Ot = 3 * he + Ct + 131074 >> 2, s(w[y + yt - 1], 255 & Ot, Ot >> 16, pt, mt + (yt - 1) * d)));
      };
    }
    function Vo() {
      ir[Ko] = i1, ir[Xo] = zh, ir[Bh] = a1, ir[Jo] = Hh, ir[Qo] = Wh, ir[nl] = Vh, ir[jh] = o1, ir[rl] = zh, ir[il] = Hh, ir[ts] = Wh, ir[al] = Vh;
    }
    function ca(a) {
      return a & ~s1 ? 0 > a ? 0 : 255 : a >> Gh;
    }
    function Ri(a, s) {
      return ca((19077 * a >> 8) + (26149 * s >> 8) - 14234);
    }
    function Qr(a, s, d) {
      return ca((19077 * a >> 8) - (6419 * s >> 8) - (13320 * d >> 8) + 8708);
    }
    function Mi(a, s) {
      return ca((19077 * a >> 8) + (33050 * s >> 8) - 17685);
    }
    function Bi(a, s, d, m, b) {
      m[b + 0] = Ri(a, d), m[b + 1] = Qr(a, s, d), m[b + 2] = Mi(a, s);
    }
    function ji(a, s, d, m, b) {
      m[b + 0] = Mi(a, s), m[b + 1] = Qr(a, s, d), m[b + 2] = Ri(a, d);
    }
    function An(a, s, d, m, b) {
      var w = Qr(a, s, d);
      s = w << 3 & 224 | Mi(a, s) >> 3, m[b + 0] = 248 & Ri(a, d) | w >> 5, m[b + 1] = s;
    }
    function Di(a, s, d, m, b) {
      var w = 240 & Mi(a, s) | 15;
      m[b + 0] = 240 & Ri(a, d) | Qr(a, s, d) >> 4, m[b + 1] = w;
    }
    function qi(a, s, d, m, b) {
      m[b + 0] = 255, Bi(a, s, d, m, b + 1);
    }
    function Ga(a, s, d, m, b) {
      ji(a, s, d, m, b), m[b + 3] = 255;
    }
    function Za(a, s, d, m, b) {
      Bi(a, s, d, m, b), m[b + 3] = 255;
    }
    function We(a, s) {
      return 0 > a ? 0 : a > s ? s : a;
    }
    function qr(a, s, d) {
      j[a] = function(m, b, w, y, A, S, E, W, et) {
        for (var I = W + (-2 & et) * d; W != I; ) s(m[b + 0], w[y + 0], A[S + 0], E, W), s(m[b + 1], w[y + 0], A[S + 0], E, W + d), b += 2, ++y, ++S, W += 2 * d;
        1 & et && s(m[b + 0], w[y + 0], A[S + 0], E, W);
      };
    }
    function fa(a, s, d) {
      return d == 0 ? a == 0 ? s == 0 ? 6 : 5 : s == 0 ? 4 : 0 : d;
    }
    function Go(a, s, d, m, b) {
      switch (a >>> 30) {
        case 3:
          Wi(s, d, m, b, 0);
          break;
        case 2:
          nr(s, d, m, b);
          break;
        case 1:
          Ne(s, d, m, b);
      }
    }
    function er(a, s) {
      var d, m, b = s.M, w = s.Nb, y = a.oc, A = a.pc + 40, S = a.oc, E = a.pc + 584, W = a.oc, et = a.pc + 600;
      for (d = 0; 16 > d; ++d) y[A + 32 * d - 1] = 129;
      for (d = 0; 8 > d; ++d) S[E + 32 * d - 1] = 129, W[et + 32 * d - 1] = 129;
      for (0 < b ? y[A - 1 - 32] = S[E - 1 - 32] = W[et - 1 - 32] = 129 : (i(y, A - 32 - 1, 127, 21), i(S, E - 32 - 1, 127, 9), i(W, et - 32 - 1, 127, 9)), m = 0; m < a.za; ++m) {
        var I = s.ya[s.aa + m];
        if (0 < m) {
          for (d = -1; 16 > d; ++d) r(y, A + 32 * d - 4, y, A + 32 * d + 12, 4);
          for (d = -1; 8 > d; ++d) r(S, E + 32 * d - 4, S, E + 32 * d + 4, 4), r(W, et + 32 * d - 4, W, et + 32 * d + 4, 4);
        }
        var Z = a.Gd, X = a.Hd + m, ct = I.ad, Q = I.Hc;
        if (0 < b && (r(y, A - 32, Z[X].y, 0, 16), r(S, E - 32, Z[X].f, 0, 8), r(W, et - 32, Z[X].ea, 0, 8)), I.Za) {
          var pt = y, mt = A - 32 + 16;
          for (0 < b && (m >= a.za - 1 ? i(pt, mt, Z[X].y[15], 4) : r(pt, mt, Z[X + 1].y, 0, 4)), d = 0; 4 > d; d++) pt[mt + 128 + d] = pt[mt + 256 + d] = pt[mt + 384 + d] = pt[mt + 0 + d];
          for (d = 0; 16 > d; ++d, Q <<= 2) pt = y, mt = A + Yh[d], cr[I.Ob[d]](pt, mt), Go(Q, ct, 16 * +d, pt, mt);
        } else if (pt = fa(m, b, I.Ob[0]), si[pt](y, A), Q != 0) for (d = 0; 16 > d; ++d, Q <<= 2) Go(Q, ct, 16 * +d, y, A + Yh[d]);
        for (d = I.Gc, pt = fa(m, b, I.Dd), Hr[pt](S, E), Hr[pt](W, et), Q = ct, pt = S, mt = E, 255 & (I = 0 | d) && (170 & I ? Lr(Q, 256, pt, mt) : Oe(Q, 256, pt, mt)), I = W, Q = et, 255 & (d >>= 8) && (170 & d ? Lr(ct, 320, I, Q) : Oe(ct, 320, I, Q)), b < a.Ub - 1 && (r(Z[X].y, 0, y, A + 480, 16), r(Z[X].f, 0, S, E + 224, 8), r(Z[X].ea, 0, W, et + 224, 8)), d = 8 * w * a.B, Z = a.sa, X = a.ta + 16 * m + 16 * w * a.R, ct = a.qa, I = a.ra + 8 * m + d, Q = a.Ha, pt = a.Ia + 8 * m + d, d = 0; 16 > d; ++d) r(Z, X + d * a.R, y, A + 32 * d, 16);
        for (d = 0; 8 > d; ++d) r(ct, I + d * a.B, S, E + 32 * d, 8), r(Q, pt + d * a.B, W, et + 32 * d, 8);
      }
    }
    function Ui(a, s, d, m, b, w, y, A, S) {
      var E = [0], W = [0], et = 0, I = S != null ? S.kd : 0, Z = S ?? new gt();
      if (a == null || 12 > d) return 7;
      Z.data = a, Z.w = s, Z.ha = d, s = [s], d = [d], Z.gb = [Z.gb];
      t: {
        var X = s, ct = d, Q = Z.gb;
        if (n(a != null), n(ct != null), n(Q != null), Q[0] = 0, 12 <= ct[0] && !e(a, X[0], "RIFF")) {
          if (e(a, X[0] + 8, "WEBP")) {
            Q = 3;
            break t;
          }
          var pt = ut(a, X[0] + 4);
          if (12 > pt || 4294967286 < pt) {
            Q = 3;
            break t;
          }
          if (I && pt > ct[0] - 8) {
            Q = 7;
            break t;
          }
          Q[0] = pt, X[0] += 12, ct[0] -= 12;
        }
        Q = 0;
      }
      if (Q != 0) return Q;
      for (pt = 0 < Z.gb[0], d = d[0]; ; ) {
        t: {
          var mt = a;
          ct = s, Q = d;
          var yt = E, wt = W, Bt = X = [0];
          if ((Ot = et = [et])[0] = 0, 8 > Q[0]) Q = 7;
          else {
            if (!e(mt, ct[0], "VP8X")) {
              if (ut(mt, ct[0] + 4) != 10) {
                Q = 3;
                break t;
              }
              if (18 > Q[0]) {
                Q = 7;
                break t;
              }
              var Ct = ut(mt, ct[0] + 8), he = 1 + Pt(mt, ct[0] + 12);
              if (2147483648 <= he * (mt = 1 + Pt(mt, ct[0] + 15))) {
                Q = 3;
                break t;
              }
              Bt != null && (Bt[0] = Ct), yt != null && (yt[0] = he), wt != null && (wt[0] = mt), ct[0] += 18, Q[0] -= 18, Ot[0] = 1;
            }
            Q = 0;
          }
        }
        if (et = et[0], X = X[0], Q != 0) return Q;
        if (ct = !!(2 & X), !pt && et) return 3;
        if (w != null && (w[0] = !!(16 & X)), y != null && (y[0] = ct), A != null && (A[0] = 0), y = E[0], X = W[0], et && ct && S == null) {
          Q = 0;
          break;
        }
        if (4 > d) {
          Q = 7;
          break;
        }
        if (pt && et || !pt && !et && !e(a, s[0], "ALPH")) {
          d = [d], Z.na = [Z.na], Z.P = [Z.P], Z.Sa = [Z.Sa];
          t: {
            Ct = a, Q = s, pt = d;
            var Ot = Z.gb;
            yt = Z.na, wt = Z.P, Bt = Z.Sa, he = 22, n(Ct != null), n(pt != null), mt = Q[0];
            var me = pt[0];
            for (n(yt != null), n(Bt != null), yt[0] = null, wt[0] = null, Bt[0] = 0; ; ) {
              if (Q[0] = mt, pt[0] = me, 8 > me) {
                Q = 7;
                break t;
              }
              var un = ut(Ct, mt + 4);
              if (4294967286 < un) {
                Q = 3;
                break t;
              }
              var ue = 8 + un + 1 & -2;
              if (he += ue, 0 < Ot && he > Ot) {
                Q = 3;
                break t;
              }
              if (!e(Ct, mt, "VP8 ") || !e(Ct, mt, "VP8L")) {
                Q = 0;
                break t;
              }
              if (me[0] < ue) {
                Q = 7;
                break t;
              }
              e(Ct, mt, "ALPH") || (yt[0] = Ct, wt[0] = mt + 8, Bt[0] = un), mt += ue, me -= ue;
            }
          }
          if (d = d[0], Z.na = Z.na[0], Z.P = Z.P[0], Z.Sa = Z.Sa[0], Q != 0) break;
        }
        d = [d], Z.Ja = [Z.Ja], Z.xa = [Z.xa];
        t: if (Ot = a, Q = s, pt = d, yt = Z.gb[0], wt = Z.Ja, Bt = Z.xa, Ct = Q[0], mt = !e(Ot, Ct, "VP8 "), he = !e(Ot, Ct, "VP8L"), n(Ot != null), n(pt != null), n(wt != null), n(Bt != null), 8 > pt[0]) Q = 7;
        else {
          if (mt || he) {
            if (Ot = ut(Ot, Ct + 4), 12 <= yt && Ot > yt - 12) {
              Q = 3;
              break t;
            }
            if (I && Ot > pt[0] - 8) {
              Q = 7;
              break t;
            }
            wt[0] = Ot, Q[0] += 8, pt[0] -= 8, Bt[0] = he;
          } else Bt[0] = 5 <= pt[0] && Ot[Ct + 0] == 47 && !(Ot[Ct + 4] >> 5), wt[0] = pt[0];
          Q = 0;
        }
        if (d = d[0], Z.Ja = Z.Ja[0], Z.xa = Z.xa[0], s = s[0], Q != 0) break;
        if (4294967286 < Z.Ja) return 3;
        if (A == null || ct || (A[0] = Z.xa ? 2 : 1), y = [y], X = [X], Z.xa) {
          if (5 > d) {
            Q = 7;
            break;
          }
          A = y, I = X, ct = w, a == null || 5 > d ? a = 0 : 5 <= d && a[s + 0] == 47 && !(a[s + 4] >> 5) ? (pt = [0], Ot = [0], yt = [0], ft(wt = new T(), a, s, d), Tr(wt, pt, Ot, yt) ? (A != null && (A[0] = pt[0]), I != null && (I[0] = Ot[0]), ct != null && (ct[0] = yt[0]), a = 1) : a = 0) : a = 0;
        } else {
          if (10 > d) {
            Q = 7;
            break;
          }
          A = X, a == null || 10 > d || !Mo(a, s + 3, d - 3) ? a = 0 : (I = a[s + 0] | a[s + 1] << 8 | a[s + 2] << 16, ct = 16383 & (a[s + 7] << 8 | a[s + 6]), a = 16383 & (a[s + 9] << 8 | a[s + 8]), 1 & I || 3 < (I >> 1 & 7) || !(I >> 4 & 1) || I >> 5 >= Z.Ja || !ct || !a ? a = 0 : (y && (y[0] = ct), A && (A[0] = a), a = 1));
        }
        if (!a || (y = y[0], X = X[0], et && (E[0] != y || W[0] != X))) return 3;
        S != null && (S[0] = Z, S.offset = s - S.w, n(4294967286 > s - S.w), n(S.offset == S.ha - d));
        break;
      }
      return Q == 0 || Q == 7 && et && S == null ? (w != null && (w[0] |= Z.na != null && 0 < Z.na.length), m != null && (m[0] = y), b != null && (b[0] = X), 0) : Q;
    }
    function Ya(a, s, d) {
      var m = s.width, b = s.height, w = 0, y = 0, A = m, S = b;
      if (s.Da = a != null && 0 < a.Da, s.Da && (A = a.cd, S = a.bd, w = a.v, y = a.j, 11 > d || (w &= -2, y &= -2), 0 > w || 0 > y || 0 >= A || 0 >= S || w + A > m || y + S > b)) return 0;
      if (s.v = w, s.j = y, s.va = w + A, s.o = y + S, s.U = A, s.T = S, s.da = a != null && 0 < a.da, s.da) {
        if (!Ht(A, S, d = [a.ib], w = [a.hb])) return 0;
        s.ib = d[0], s.hb = w[0];
      }
      return s.ob = a != null && a.ob, s.Kb = a == null || !a.Sd, s.da && (s.ob = s.ib < 3 * m / 4 && s.hb < 3 * b / 4, s.Kb = 0), 1;
    }
    function $a(a) {
      if (a == null) return 2;
      if (11 > a.S) {
        var s = a.f.RGBA;
        s.fb += (a.height - 1) * s.A, s.A = -s.A;
      } else s = a.f.kb, a = a.height, s.O += (a - 1) * s.fa, s.fa = -s.fa, s.N += (a - 1 >> 1) * s.Ab, s.Ab = -s.Ab, s.W += (a - 1 >> 1) * s.Db, s.Db = -s.Db, s.F != null && (s.J += (a - 1) * s.lb, s.lb = -s.lb);
      return 0;
    }
    function ti(a, s, d, m) {
      if (m == null || 0 >= a || 0 >= s) return 2;
      if (d != null) {
        if (d.Da) {
          var b = d.cd, w = d.bd, y = -2 & d.v, A = -2 & d.j;
          if (0 > y || 0 > A || 0 >= b || 0 >= w || y + b > a || A + w > s) return 2;
          a = b, s = w;
        }
        if (d.da) {
          if (!Ht(a, s, b = [d.ib], w = [d.hb])) return 2;
          a = b[0], s = w[0];
        }
      }
      m.width = a, m.height = s;
      t: {
        var S = m.width, E = m.height;
        if (a = m.S, 0 >= S || 0 >= E || !(a >= Ko && 13 > a)) a = 2;
        else {
          if (0 >= m.Rd && m.sd == null) {
            y = w = b = s = 0;
            var W = (A = S * $h[a]) * E;
            if (11 > a || (w = (E + 1) / 2 * (s = (S + 1) / 2), a == 12 && (y = (b = S) * E)), (E = o(W + 2 * w + y)) == null) {
              a = 1;
              break t;
            }
            m.sd = E, 11 > a ? ((S = m.f.RGBA).eb = E, S.fb = 0, S.A = A, S.size = W) : ((S = m.f.kb).y = E, S.O = 0, S.fa = A, S.Fd = W, S.f = E, S.N = 0 + W, S.Ab = s, S.Cd = w, S.ea = E, S.W = 0 + W + w, S.Db = s, S.Ed = w, a == 12 && (S.F = E, S.J = 0 + W + 2 * w), S.Tc = y, S.lb = b);
          }
          if (s = 1, b = m.S, w = m.width, y = m.height, b >= Ko && 13 > b) if (11 > b) a = m.f.RGBA, s &= (A = Math.abs(a.A)) * (y - 1) + w <= a.size, s &= A >= w * $h[b], s &= a.eb != null;
          else {
            a = m.f.kb, A = (w + 1) / 2, W = (y + 1) / 2, S = Math.abs(a.fa), E = Math.abs(a.Ab);
            var et = Math.abs(a.Db), I = Math.abs(a.lb), Z = I * (y - 1) + w;
            s &= S * (y - 1) + w <= a.Fd, s &= E * (W - 1) + A <= a.Cd, s = (s &= et * (W - 1) + A <= a.Ed) & S >= w & E >= A & et >= A, s &= a.y != null, s &= a.f != null, s &= a.ea != null, b == 12 && (s &= I >= w, s &= Z <= a.Tc, s &= a.F != null);
          }
          else s = 0;
          a = s ? 0 : 2;
        }
      }
      return a != 0 || d != null && d.fd && (a = $a(m)), a;
    }
    var zi = 64, jn = [0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215], Dn = 24, ei = 32, Ur = 8, ni = [0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7];
    St("Predictor0", "PredictorAdd0"), j.Predictor0 = function() {
      return 4278190080;
    }, j.Predictor1 = function(a) {
      return a;
    }, j.Predictor2 = function(a, s, d) {
      return s[d + 0];
    }, j.Predictor3 = function(a, s, d) {
      return s[d + 1];
    }, j.Predictor4 = function(a, s, d) {
      return s[d - 1];
    }, j.Predictor5 = function(a, s, d) {
      return zt(zt(a, s[d + 1]), s[d + 0]);
    }, j.Predictor6 = function(a, s, d) {
      return zt(a, s[d - 1]);
    }, j.Predictor7 = function(a, s, d) {
      return zt(a, s[d + 0]);
    }, j.Predictor8 = function(a, s, d) {
      return zt(s[d - 1], s[d + 0]);
    }, j.Predictor9 = function(a, s, d) {
      return zt(s[d + 0], s[d + 1]);
    }, j.Predictor10 = function(a, s, d) {
      return zt(zt(a, s[d - 1]), zt(s[d + 0], s[d + 1]));
    }, j.Predictor11 = function(a, s, d) {
      var m = s[d + 0];
      return 0 >= ne(m >> 24 & 255, a >> 24 & 255, (s = s[d - 1]) >> 24 & 255) + ne(m >> 16 & 255, a >> 16 & 255, s >> 16 & 255) + ne(m >> 8 & 255, a >> 8 & 255, s >> 8 & 255) + ne(255 & m, 255 & a, 255 & s) ? m : a;
    }, j.Predictor12 = function(a, s, d) {
      var m = s[d + 0];
      return (_e((a >> 24 & 255) + (m >> 24 & 255) - ((s = s[d - 1]) >> 24 & 255)) << 24 | _e((a >> 16 & 255) + (m >> 16 & 255) - (s >> 16 & 255)) << 16 | _e((a >> 8 & 255) + (m >> 8 & 255) - (s >> 8 & 255)) << 8 | _e((255 & a) + (255 & m) - (255 & s))) >>> 0;
    }, j.Predictor13 = function(a, s, d) {
      var m = s[d - 1];
      return (ee((a = zt(a, s[d + 0])) >> 24 & 255, m >> 24 & 255) << 24 | ee(a >> 16 & 255, m >> 16 & 255) << 16 | ee(a >> 8 & 255, m >> 8 & 255) << 8 | ee(255 & a, 255 & m)) >>> 0;
    };
    var Ka = j.PredictorAdd0;
    j.PredictorAdd1 = Ee, St("Predictor2", "PredictorAdd2"), St("Predictor3", "PredictorAdd3"), St("Predictor4", "PredictorAdd4"), St("Predictor5", "PredictorAdd5"), St("Predictor6", "PredictorAdd6"), St("Predictor7", "PredictorAdd7"), St("Predictor8", "PredictorAdd8"), St("Predictor9", "PredictorAdd9"), St("Predictor10", "PredictorAdd10"), St("Predictor11", "PredictorAdd11"), St("Predictor12", "PredictorAdd12"), St("Predictor13", "PredictorAdd13");
    var da = j.PredictorAdd2;
    Ut("ColorIndexInverseTransform", "MapARGB", "32b", function(a) {
      return a >> 8 & 255;
    }, function(a) {
      return a;
    }), Ut("VP8LColorIndexInverseTransformAlpha", "MapAlpha", "8b", function(a) {
      return a;
    }, function(a) {
      return a >> 8 & 255;
    });
    var Ke, Zo = j.ColorIndexInverseTransform, xr = j.MapARGB, Ar = j.VP8LColorIndexInverseTransformAlpha, Xa = j.MapAlpha, Ja = j.VP8LPredictorsAdd = [];
    Ja.length = 16, (j.VP8LPredictors = []).length = 16, (j.VP8LPredictorsAdd_C = []).length = 16, (j.VP8LPredictors_C = []).length = 16;
    var Qa, to, ri, ii, ai, Hi, oi, Wi, nr, Lr, Ne, Oe, Xe, hn, zr, eo, pa, Yo, Ah, Lh, Nh, Sh, kh, Ph, no, Ch, Eh, Ih, Fh = o(511), Oh = o(2041), Th = o(225), Rh = o(767), Mh = 0, el = Oh, $o = Th, qn = Rh, rr = Fh, Ko = 0, Xo = 1, Bh = 2, Jo = 3, Qo = 4, nl = 5, jh = 6, rl = 7, il = 8, ts = 9, al = 10, Wf = [2, 3, 7], Vf = [3, 3, 11], Dh = [280, 256, 256, 256, 40], Gf = [0, 1, 1, 1, 0], Zf = [17, 18, 0, 1, 2, 3, 4, 5, 16, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15], Yf = [24, 7, 23, 25, 40, 6, 39, 41, 22, 26, 38, 42, 56, 5, 55, 57, 21, 27, 54, 58, 37, 43, 72, 4, 71, 73, 20, 28, 53, 59, 70, 74, 36, 44, 88, 69, 75, 52, 60, 3, 87, 89, 19, 29, 86, 90, 35, 45, 68, 76, 85, 91, 51, 61, 104, 2, 103, 105, 18, 30, 102, 106, 34, 46, 84, 92, 67, 77, 101, 107, 50, 62, 120, 1, 119, 121, 83, 93, 17, 31, 100, 108, 66, 78, 118, 122, 33, 47, 117, 123, 49, 63, 99, 109, 82, 94, 0, 116, 124, 65, 79, 16, 32, 98, 110, 48, 115, 125, 81, 95, 64, 114, 126, 97, 111, 80, 113, 127, 96, 112], $f = [2954, 2956, 2958, 2962, 2970, 2986, 3018, 3082, 3212, 3468, 3980, 5004], Kf = 8, ol = [4, 5, 6, 7, 8, 9, 10, 10, 11, 12, 13, 14, 15, 16, 17, 17, 18, 19, 20, 20, 21, 21, 22, 22, 23, 23, 24, 25, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 91, 93, 95, 96, 98, 100, 101, 102, 104, 106, 108, 110, 112, 114, 116, 118, 122, 124, 126, 128, 130, 132, 134, 136, 138, 140, 143, 145, 148, 151, 154, 157], sl = [4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 60, 62, 64, 66, 68, 70, 72, 74, 76, 78, 80, 82, 84, 86, 88, 90, 92, 94, 96, 98, 100, 102, 104, 106, 108, 110, 112, 114, 116, 119, 122, 125, 128, 131, 134, 137, 140, 143, 146, 149, 152, 155, 158, 161, 164, 167, 170, 173, 177, 181, 185, 189, 193, 197, 201, 205, 209, 213, 217, 221, 225, 229, 234, 239, 245, 249, 254, 259, 264, 269, 274, 279, 284], ro = null, Xf = [[173, 148, 140, 0], [176, 155, 140, 135, 0], [180, 157, 141, 134, 130, 0], [254, 254, 243, 230, 196, 177, 153, 140, 133, 130, 129, 0]], Jf = [0, 1, 4, 8, 5, 2, 3, 6, 9, 12, 13, 10, 7, 11, 14, 15], qh = [-0, 1, -1, 2, -2, 3, 4, 6, -3, 5, -4, -5, -6, 7, -7, 8, -8, -9], Qf = [[[[128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128], [128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128], [128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128]], [[253, 136, 254, 255, 228, 219, 128, 128, 128, 128, 128], [189, 129, 242, 255, 227, 213, 255, 219, 128, 128, 128], [106, 126, 227, 252, 214, 209, 255, 255, 128, 128, 128]], [[1, 98, 248, 255, 236, 226, 255, 255, 128, 128, 128], [181, 133, 238, 254, 221, 234, 255, 154, 128, 128, 128], [78, 134, 202, 247, 198, 180, 255, 219, 128, 128, 128]], [[1, 185, 249, 255, 243, 255, 128, 128, 128, 128, 128], [184, 150, 247, 255, 236, 224, 128, 128, 128, 128, 128], [77, 110, 216, 255, 236, 230, 128, 128, 128, 128, 128]], [[1, 101, 251, 255, 241, 255, 128, 128, 128, 128, 128], [170, 139, 241, 252, 236, 209, 255, 255, 128, 128, 128], [37, 116, 196, 243, 228, 255, 255, 255, 128, 128, 128]], [[1, 204, 254, 255, 245, 255, 128, 128, 128, 128, 128], [207, 160, 250, 255, 238, 128, 128, 128, 128, 128, 128], [102, 103, 231, 255, 211, 171, 128, 128, 128, 128, 128]], [[1, 152, 252, 255, 240, 255, 128, 128, 128, 128, 128], [177, 135, 243, 255, 234, 225, 128, 128, 128, 128, 128], [80, 129, 211, 255, 194, 224, 128, 128, 128, 128, 128]], [[1, 1, 255, 128, 128, 128, 128, 128, 128, 128, 128], [246, 1, 255, 128, 128, 128, 128, 128, 128, 128, 128], [255, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128]]], [[[198, 35, 237, 223, 193, 187, 162, 160, 145, 155, 62], [131, 45, 198, 221, 172, 176, 220, 157, 252, 221, 1], [68, 47, 146, 208, 149, 167, 221, 162, 255, 223, 128]], [[1, 149, 241, 255, 221, 224, 255, 255, 128, 128, 128], [184, 141, 234, 253, 222, 220, 255, 199, 128, 128, 128], [81, 99, 181, 242, 176, 190, 249, 202, 255, 255, 128]], [[1, 129, 232, 253, 214, 197, 242, 196, 255, 255, 128], [99, 121, 210, 250, 201, 198, 255, 202, 128, 128, 128], [23, 91, 163, 242, 170, 187, 247, 210, 255, 255, 128]], [[1, 200, 246, 255, 234, 255, 128, 128, 128, 128, 128], [109, 178, 241, 255, 231, 245, 255, 255, 128, 128, 128], [44, 130, 201, 253, 205, 192, 255, 255, 128, 128, 128]], [[1, 132, 239, 251, 219, 209, 255, 165, 128, 128, 128], [94, 136, 225, 251, 218, 190, 255, 255, 128, 128, 128], [22, 100, 174, 245, 186, 161, 255, 199, 128, 128, 128]], [[1, 182, 249, 255, 232, 235, 128, 128, 128, 128, 128], [124, 143, 241, 255, 227, 234, 128, 128, 128, 128, 128], [35, 77, 181, 251, 193, 211, 255, 205, 128, 128, 128]], [[1, 157, 247, 255, 236, 231, 255, 255, 128, 128, 128], [121, 141, 235, 255, 225, 227, 255, 255, 128, 128, 128], [45, 99, 188, 251, 195, 217, 255, 224, 128, 128, 128]], [[1, 1, 251, 255, 213, 255, 128, 128, 128, 128, 128], [203, 1, 248, 255, 255, 128, 128, 128, 128, 128, 128], [137, 1, 177, 255, 224, 255, 128, 128, 128, 128, 128]]], [[[253, 9, 248, 251, 207, 208, 255, 192, 128, 128, 128], [175, 13, 224, 243, 193, 185, 249, 198, 255, 255, 128], [73, 17, 171, 221, 161, 179, 236, 167, 255, 234, 128]], [[1, 95, 247, 253, 212, 183, 255, 255, 128, 128, 128], [239, 90, 244, 250, 211, 209, 255, 255, 128, 128, 128], [155, 77, 195, 248, 188, 195, 255, 255, 128, 128, 128]], [[1, 24, 239, 251, 218, 219, 255, 205, 128, 128, 128], [201, 51, 219, 255, 196, 186, 128, 128, 128, 128, 128], [69, 46, 190, 239, 201, 218, 255, 228, 128, 128, 128]], [[1, 191, 251, 255, 255, 128, 128, 128, 128, 128, 128], [223, 165, 249, 255, 213, 255, 128, 128, 128, 128, 128], [141, 124, 248, 255, 255, 128, 128, 128, 128, 128, 128]], [[1, 16, 248, 255, 255, 128, 128, 128, 128, 128, 128], [190, 36, 230, 255, 236, 255, 128, 128, 128, 128, 128], [149, 1, 255, 128, 128, 128, 128, 128, 128, 128, 128]], [[1, 226, 255, 128, 128, 128, 128, 128, 128, 128, 128], [247, 192, 255, 128, 128, 128, 128, 128, 128, 128, 128], [240, 128, 255, 128, 128, 128, 128, 128, 128, 128, 128]], [[1, 134, 252, 255, 255, 128, 128, 128, 128, 128, 128], [213, 62, 250, 255, 255, 128, 128, 128, 128, 128, 128], [55, 93, 255, 128, 128, 128, 128, 128, 128, 128, 128]], [[128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128], [128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128], [128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128]]], [[[202, 24, 213, 235, 186, 191, 220, 160, 240, 175, 255], [126, 38, 182, 232, 169, 184, 228, 174, 255, 187, 128], [61, 46, 138, 219, 151, 178, 240, 170, 255, 216, 128]], [[1, 112, 230, 250, 199, 191, 247, 159, 255, 255, 128], [166, 109, 228, 252, 211, 215, 255, 174, 128, 128, 128], [39, 77, 162, 232, 172, 180, 245, 178, 255, 255, 128]], [[1, 52, 220, 246, 198, 199, 249, 220, 255, 255, 128], [124, 74, 191, 243, 183, 193, 250, 221, 255, 255, 128], [24, 71, 130, 219, 154, 170, 243, 182, 255, 255, 128]], [[1, 182, 225, 249, 219, 240, 255, 224, 128, 128, 128], [149, 150, 226, 252, 216, 205, 255, 171, 128, 128, 128], [28, 108, 170, 242, 183, 194, 254, 223, 255, 255, 128]], [[1, 81, 230, 252, 204, 203, 255, 192, 128, 128, 128], [123, 102, 209, 247, 188, 196, 255, 233, 128, 128, 128], [20, 95, 153, 243, 164, 173, 255, 203, 128, 128, 128]], [[1, 222, 248, 255, 216, 213, 128, 128, 128, 128, 128], [168, 175, 246, 252, 235, 205, 255, 255, 128, 128, 128], [47, 116, 215, 255, 211, 212, 255, 255, 128, 128, 128]], [[1, 121, 236, 253, 212, 214, 255, 255, 128, 128, 128], [141, 84, 213, 252, 201, 202, 255, 219, 128, 128, 128], [42, 80, 160, 240, 162, 185, 255, 205, 128, 128, 128]], [[1, 1, 255, 128, 128, 128, 128, 128, 128, 128, 128], [244, 1, 255, 128, 128, 128, 128, 128, 128, 128, 128], [238, 1, 255, 128, 128, 128, 128, 128, 128, 128, 128]]]], t1 = [[[231, 120, 48, 89, 115, 113, 120, 152, 112], [152, 179, 64, 126, 170, 118, 46, 70, 95], [175, 69, 143, 80, 85, 82, 72, 155, 103], [56, 58, 10, 171, 218, 189, 17, 13, 152], [114, 26, 17, 163, 44, 195, 21, 10, 173], [121, 24, 80, 195, 26, 62, 44, 64, 85], [144, 71, 10, 38, 171, 213, 144, 34, 26], [170, 46, 55, 19, 136, 160, 33, 206, 71], [63, 20, 8, 114, 114, 208, 12, 9, 226], [81, 40, 11, 96, 182, 84, 29, 16, 36]], [[134, 183, 89, 137, 98, 101, 106, 165, 148], [72, 187, 100, 130, 157, 111, 32, 75, 80], [66, 102, 167, 99, 74, 62, 40, 234, 128], [41, 53, 9, 178, 241, 141, 26, 8, 107], [74, 43, 26, 146, 73, 166, 49, 23, 157], [65, 38, 105, 160, 51, 52, 31, 115, 128], [104, 79, 12, 27, 217, 255, 87, 17, 7], [87, 68, 71, 44, 114, 51, 15, 186, 23], [47, 41, 14, 110, 182, 183, 21, 17, 194], [66, 45, 25, 102, 197, 189, 23, 18, 22]], [[88, 88, 147, 150, 42, 46, 45, 196, 205], [43, 97, 183, 117, 85, 38, 35, 179, 61], [39, 53, 200, 87, 26, 21, 43, 232, 171], [56, 34, 51, 104, 114, 102, 29, 93, 77], [39, 28, 85, 171, 58, 165, 90, 98, 64], [34, 22, 116, 206, 23, 34, 43, 166, 73], [107, 54, 32, 26, 51, 1, 81, 43, 31], [68, 25, 106, 22, 64, 171, 36, 225, 114], [34, 19, 21, 102, 132, 188, 16, 76, 124], [62, 18, 78, 95, 85, 57, 50, 48, 51]], [[193, 101, 35, 159, 215, 111, 89, 46, 111], [60, 148, 31, 172, 219, 228, 21, 18, 111], [112, 113, 77, 85, 179, 255, 38, 120, 114], [40, 42, 1, 196, 245, 209, 10, 25, 109], [88, 43, 29, 140, 166, 213, 37, 43, 154], [61, 63, 30, 155, 67, 45, 68, 1, 209], [100, 80, 8, 43, 154, 1, 51, 26, 71], [142, 78, 78, 16, 255, 128, 34, 197, 171], [41, 40, 5, 102, 211, 183, 4, 1, 221], [51, 50, 17, 168, 209, 192, 23, 25, 82]], [[138, 31, 36, 171, 27, 166, 38, 44, 229], [67, 87, 58, 169, 82, 115, 26, 59, 179], [63, 59, 90, 180, 59, 166, 93, 73, 154], [40, 40, 21, 116, 143, 209, 34, 39, 175], [47, 15, 16, 183, 34, 223, 49, 45, 183], [46, 17, 33, 183, 6, 98, 15, 32, 183], [57, 46, 22, 24, 128, 1, 54, 17, 37], [65, 32, 73, 115, 28, 128, 23, 128, 205], [40, 3, 9, 115, 51, 192, 18, 6, 223], [87, 37, 9, 115, 59, 77, 64, 21, 47]], [[104, 55, 44, 218, 9, 54, 53, 130, 226], [64, 90, 70, 205, 40, 41, 23, 26, 57], [54, 57, 112, 184, 5, 41, 38, 166, 213], [30, 34, 26, 133, 152, 116, 10, 32, 134], [39, 19, 53, 221, 26, 114, 32, 73, 255], [31, 9, 65, 234, 2, 15, 1, 118, 73], [75, 32, 12, 51, 192, 255, 160, 43, 51], [88, 31, 35, 67, 102, 85, 55, 186, 85], [56, 21, 23, 111, 59, 205, 45, 37, 192], [55, 38, 70, 124, 73, 102, 1, 34, 98]], [[125, 98, 42, 88, 104, 85, 117, 175, 82], [95, 84, 53, 89, 128, 100, 113, 101, 45], [75, 79, 123, 47, 51, 128, 81, 171, 1], [57, 17, 5, 71, 102, 57, 53, 41, 49], [38, 33, 13, 121, 57, 73, 26, 1, 85], [41, 10, 67, 138, 77, 110, 90, 47, 114], [115, 21, 2, 10, 102, 255, 166, 23, 6], [101, 29, 16, 10, 85, 128, 101, 196, 26], [57, 18, 10, 102, 102, 213, 34, 20, 43], [117, 20, 15, 36, 163, 128, 68, 1, 26]], [[102, 61, 71, 37, 34, 53, 31, 243, 192], [69, 60, 71, 38, 73, 119, 28, 222, 37], [68, 45, 128, 34, 1, 47, 11, 245, 171], [62, 17, 19, 70, 146, 85, 55, 62, 70], [37, 43, 37, 154, 100, 163, 85, 160, 1], [63, 9, 92, 136, 28, 64, 32, 201, 85], [75, 15, 9, 9, 64, 255, 184, 119, 16], [86, 6, 28, 5, 64, 255, 25, 248, 1], [56, 8, 17, 132, 137, 255, 55, 116, 128], [58, 15, 20, 82, 135, 57, 26, 121, 40]], [[164, 50, 31, 137, 154, 133, 25, 35, 218], [51, 103, 44, 131, 131, 123, 31, 6, 158], [86, 40, 64, 135, 148, 224, 45, 183, 128], [22, 26, 17, 131, 240, 154, 14, 1, 209], [45, 16, 21, 91, 64, 222, 7, 1, 197], [56, 21, 39, 155, 60, 138, 23, 102, 213], [83, 12, 13, 54, 192, 255, 68, 47, 28], [85, 26, 85, 85, 128, 128, 32, 146, 171], [18, 11, 7, 63, 144, 171, 4, 4, 246], [35, 27, 10, 146, 174, 171, 12, 26, 128]], [[190, 80, 35, 99, 180, 80, 126, 54, 45], [85, 126, 47, 87, 176, 51, 41, 20, 32], [101, 75, 128, 139, 118, 146, 116, 128, 85], [56, 41, 15, 176, 236, 85, 37, 9, 62], [71, 30, 17, 119, 118, 255, 17, 18, 138], [101, 38, 60, 138, 55, 70, 43, 26, 142], [146, 36, 19, 30, 171, 255, 97, 27, 20], [138, 45, 61, 62, 219, 1, 81, 188, 64], [32, 41, 20, 117, 151, 142, 20, 21, 163], [112, 19, 12, 61, 195, 128, 48, 4, 24]]], e1 = [[[[255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255], [255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255], [255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255]], [[176, 246, 255, 255, 255, 255, 255, 255, 255, 255, 255], [223, 241, 252, 255, 255, 255, 255, 255, 255, 255, 255], [249, 253, 253, 255, 255, 255, 255, 255, 255, 255, 255]], [[255, 244, 252, 255, 255, 255, 255, 255, 255, 255, 255], [234, 254, 254, 255, 255, 255, 255, 255, 255, 255, 255], [253, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255]], [[255, 246, 254, 255, 255, 255, 255, 255, 255, 255, 255], [239, 253, 254, 255, 255, 255, 255, 255, 255, 255, 255], [254, 255, 254, 255, 255, 255, 255, 255, 255, 255, 255]], [[255, 248, 254, 255, 255, 255, 255, 255, 255, 255, 255], [251, 255, 254, 255, 255, 255, 255, 255, 255, 255, 255], [255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255]], [[255, 253, 254, 255, 255, 255, 255, 255, 255, 255, 255], [251, 254, 254, 255, 255, 255, 255, 255, 255, 255, 255], [254, 255, 254, 255, 255, 255, 255, 255, 255, 255, 255]], [[255, 254, 253, 255, 254, 255, 255, 255, 255, 255, 255], [250, 255, 254, 255, 254, 255, 255, 255, 255, 255, 255], [254, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255]], [[255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255], [255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255], [255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255]]], [[[217, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255], [225, 252, 241, 253, 255, 255, 254, 255, 255, 255, 255], [234, 250, 241, 250, 253, 255, 253, 254, 255, 255, 255]], [[255, 254, 255, 255, 255, 255, 255, 255, 255, 255, 255], [223, 254, 254, 255, 255, 255, 255, 255, 255, 255, 255], [238, 253, 254, 254, 255, 255, 255, 255, 255, 255, 255]], [[255, 248, 254, 255, 255, 255, 255, 255, 255, 255, 255], [249, 254, 255, 255, 255, 255, 255, 255, 255, 255, 255], [255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255]], [[255, 253, 255, 255, 255, 255, 255, 255, 255, 255, 255], [247, 254, 255, 255, 255, 255, 255, 255, 255, 255, 255], [255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255]], [[255, 253, 254, 255, 255, 255, 255, 255, 255, 255, 255], [252, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255], [255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255]], [[255, 254, 254, 255, 255, 255, 255, 255, 255, 255, 255], [253, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255], [255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255]], [[255, 254, 253, 255, 255, 255, 255, 255, 255, 255, 255], [250, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255], [254, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255]], [[255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255], [255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255], [255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255]]], [[[186, 251, 250, 255, 255, 255, 255, 255, 255, 255, 255], [234, 251, 244, 254, 255, 255, 255, 255, 255, 255, 255], [251, 251, 243, 253, 254, 255, 254, 255, 255, 255, 255]], [[255, 253, 254, 255, 255, 255, 255, 255, 255, 255, 255], [236, 253, 254, 255, 255, 255, 255, 255, 255, 255, 255], [251, 253, 253, 254, 254, 255, 255, 255, 255, 255, 255]], [[255, 254, 254, 255, 255, 255, 255, 255, 255, 255, 255], [254, 254, 254, 255, 255, 255, 255, 255, 255, 255, 255], [255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255]], [[255, 254, 255, 255, 255, 255, 255, 255, 255, 255, 255], [254, 254, 255, 255, 255, 255, 255, 255, 255, 255, 255], [254, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255]], [[255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255], [254, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255], [255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255]], [[255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255], [255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255], [255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255]], [[255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255], [255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255], [255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255]], [[255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255], [255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255], [255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255]]], [[[248, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255], [250, 254, 252, 254, 255, 255, 255, 255, 255, 255, 255], [248, 254, 249, 253, 255, 255, 255, 255, 255, 255, 255]], [[255, 253, 253, 255, 255, 255, 255, 255, 255, 255, 255], [246, 253, 253, 255, 255, 255, 255, 255, 255, 255, 255], [252, 254, 251, 254, 254, 255, 255, 255, 255, 255, 255]], [[255, 254, 252, 255, 255, 255, 255, 255, 255, 255, 255], [248, 254, 253, 255, 255, 255, 255, 255, 255, 255, 255], [253, 255, 254, 254, 255, 255, 255, 255, 255, 255, 255]], [[255, 251, 254, 255, 255, 255, 255, 255, 255, 255, 255], [245, 251, 254, 255, 255, 255, 255, 255, 255, 255, 255], [253, 253, 254, 255, 255, 255, 255, 255, 255, 255, 255]], [[255, 251, 253, 255, 255, 255, 255, 255, 255, 255, 255], [252, 253, 254, 255, 255, 255, 255, 255, 255, 255, 255], [255, 254, 255, 255, 255, 255, 255, 255, 255, 255, 255]], [[255, 252, 255, 255, 255, 255, 255, 255, 255, 255, 255], [249, 255, 254, 255, 255, 255, 255, 255, 255, 255, 255], [255, 255, 254, 255, 255, 255, 255, 255, 255, 255, 255]], [[255, 255, 253, 255, 255, 255, 255, 255, 255, 255, 255], [250, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255], [255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255]], [[255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255], [254, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255], [255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255]]]], n1 = [0, 1, 2, 3, 6, 4, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 0], si = [], cr = [], Hr = [], r1 = 1, Uh = 2, li = [], ir = [];
    On("UpsampleRgbLinePair", Bi, 3), On("UpsampleBgrLinePair", ji, 3), On("UpsampleRgbaLinePair", Za, 4), On("UpsampleBgraLinePair", Ga, 4), On("UpsampleArgbLinePair", qi, 4), On("UpsampleRgba4444LinePair", Di, 2), On("UpsampleRgb565LinePair", An, 2);
    var i1 = j.UpsampleRgbLinePair, a1 = j.UpsampleBgrLinePair, zh = j.UpsampleRgbaLinePair, Hh = j.UpsampleBgraLinePair, Wh = j.UpsampleArgbLinePair, Vh = j.UpsampleRgba4444LinePair, o1 = j.UpsampleRgb565LinePair, es = 16, ns = 1 << es - 1, io = -227, ll = 482, Gh = 6, s1 = (256 << Gh) - 1, Zh = 0, l1 = o(256), h1 = o(256), u1 = o(256), c1 = o(256), f1 = o(ll - io), d1 = o(ll - io);
    qr("YuvToRgbRow", Bi, 3), qr("YuvToBgrRow", ji, 3), qr("YuvToRgbaRow", Za, 4), qr("YuvToBgraRow", Ga, 4), qr("YuvToArgbRow", qi, 4), qr("YuvToRgba4444Row", Di, 2), qr("YuvToRgb565Row", An, 2);
    var Yh = [0, 4, 8, 12, 128, 132, 136, 140, 256, 260, 264, 268, 384, 388, 392, 396], rs = [0, 2, 8], p1 = [8, 7, 6, 4, 4, 2, 2, 2, 1, 1, 1, 1], g1 = 1;
    this.WebPDecodeRGBA = function(a, s, d, m, b) {
      var w = Xo, y = new K(), A = new Fe();
      y.ba = A, A.S = w, A.width = [A.width], A.height = [A.height];
      var S = A.width, E = A.height, W = new Xt();
      if (W == null || a == null) var et = 2;
      else n(W != null), et = Ui(a, s, d, W.width, W.height, W.Pd, W.Qd, W.format, null);
      if (et != 0 ? S = 0 : (S != null && (S[0] = W.width[0]), E != null && (E[0] = W.height[0]), S = 1), S) {
        A.width = A.width[0], A.height = A.height[0], m != null && (m[0] = A.width), b != null && (b[0] = A.height);
        t: {
          if (m = new oa(), (b = new gt()).data = a, b.w = s, b.ha = d, b.kd = 1, s = [0], n(b != null), ((a = Ui(b.data, b.w, b.ha, null, null, null, s, null, b)) == 0 || a == 7) && s[0] && (a = 4), (s = a) == 0) {
            if (n(y != null), m.data = b.data, m.w = b.w + b.offset, m.ha = b.ha - b.offset, m.put = Vt, m.ac = br, m.bc = Or, m.ma = y, b.xa) {
              if ((a = Li()) == null) {
                y = 1;
                break t;
              }
              if ((function(I, Z) {
                var X = [0], ct = [0], Q = [0];
                e: for (; ; ) {
                  if (I == null) return 0;
                  if (Z == null) return I.a = 2, 0;
                  if (I.l = Z, I.a = 0, ft(I.m, Z.data, Z.w, Z.ha), !Tr(I.m, X, ct, Q)) {
                    I.a = 3;
                    break e;
                  }
                  if (I.xb = Uh, Z.width = X[0], Z.height = ct[0], !_r(X[0], ct[0], 1, I, null)) break e;
                  return 1;
                }
                return n(I.a != 0), 0;
              })(a, m)) {
                if (m = (s = ti(m.width, m.height, y.Oa, y.ba)) == 0) {
                  e: {
                    m = a;
                    n: for (; ; ) {
                      if (m == null) {
                        m = 0;
                        break e;
                      }
                      if (n(m.s.yc != null), n(m.s.Ya != null), n(0 < m.s.Wb), n((d = m.l) != null), n((b = d.ma) != null), m.xb != 0) {
                        if (m.ca = b.ba, m.tb = b.tb, n(m.ca != null), !Ya(b.Oa, d, Jo)) {
                          m.a = 2;
                          break n;
                        }
                        if (!Ni(m, d.width) || d.da) break n;
                        if ((d.da || ie(m.ca.S)) && tr(), 11 > m.ca.S || (alert("todo:WebPInitConvertARGBToYUV"), m.ca.f.kb.F != null && tr()), m.Pb && 0 < m.s.ua && m.s.vb.X == null && !R(m.s.vb, m.s.Wa.Xa)) {
                          m.a = 1;
                          break n;
                        }
                        m.xb = 0;
                      }
                      if (!hr(m, m.V, m.Ba, m.c, m.i, d.o, Kr)) break n;
                      b.Dc = m.Ma, m = 1;
                      break e;
                    }
                    n(m.a != 0), m = 0;
                  }
                  m = !m;
                }
                m && (s = a.a);
              } else s = a.a;
            } else {
              if ((a = new qs()) == null) {
                y = 1;
                break t;
              }
              if (a.Fa = b.na, a.P = b.P, a.qc = b.Sa, Bo(a, m)) {
                if ((s = ti(m.width, m.height, y.Oa, y.ba)) == 0) {
                  if (a.Aa = 0, d = y.Oa, n((b = a) != null), d != null) {
                    if (0 < (S = 0 > (S = d.Md) ? 0 : 100 < S ? 255 : 255 * S / 100)) {
                      for (E = W = 0; 4 > E; ++E) 12 > (et = b.pb[E]).lc && (et.ia = S * p1[0 > et.lc ? 0 : et.lc] >> 3), W |= et.ia;
                      W && (alert("todo:VP8InitRandom"), b.ia = 1);
                    }
                    b.Ga = d.Id, 100 < b.Ga ? b.Ga = 100 : 0 > b.Ga && (b.Ga = 0);
                  }
                  (function(I, Z) {
                    if (I == null) return 0;
                    if (Z == null) return rn(I, 2, "NULL VP8Io parameter in VP8Decode().");
                    if (!I.cb && !Bo(I, Z)) return 0;
                    if (n(I.cb), Z.ac == null || Z.ac(Z)) {
                      Z.ob && (I.L = 0);
                      var X = rs[I.L];
                      if (I.L == 2 ? (I.yb = 0, I.zb = 0) : (I.yb = Z.v - X >> 4, I.zb = Z.j - X >> 4, 0 > I.yb && (I.yb = 0), 0 > I.zb && (I.zb = 0)), I.Va = Z.o + 15 + X >> 4, I.Hb = Z.va + 15 + X >> 4, I.Hb > I.za && (I.Hb = I.za), I.Va > I.Ub && (I.Va = I.Ub), 0 < I.L) {
                        var ct = I.ed;
                        for (X = 0; 4 > X; ++X) {
                          var Q;
                          if (I.Qa.Cb) {
                            var pt = I.Qa.Lb[X];
                            I.Qa.Fb || (pt += ct.Tb);
                          } else pt = ct.Tb;
                          for (Q = 0; 1 >= Q; ++Q) {
                            var mt = I.gd[X][Q], yt = pt;
                            if (ct.Pc && (yt += ct.vd[0], Q && (yt += ct.od[0])), 0 < (yt = 0 > yt ? 0 : 63 < yt ? 63 : yt)) {
                              var wt = yt;
                              0 < ct.wb && (wt = 4 < ct.wb ? wt >> 2 : wt >> 1) > 9 - ct.wb && (wt = 9 - ct.wb), 1 > wt && (wt = 1), mt.dd = wt, mt.tc = 2 * yt + wt, mt.ld = 40 <= yt ? 2 : 15 <= yt ? 1 : 0;
                            } else mt.tc = 0;
                            mt.La = Q;
                          }
                        }
                      }
                      X = 0;
                    } else rn(I, 6, "Frame setup failed"), X = I.a;
                    if (X = X == 0) {
                      if (X) {
                        I.$c = 0, 0 < I.Aa || (I.Ic = g1);
                        e: {
                          X = I.Ic, ct = 4 * (wt = I.za);
                          var Bt = 32 * wt, Ct = wt + 1, he = 0 < I.L ? wt * (0 < I.Aa ? 2 : 1) : 0, Ot = (I.Aa == 2 ? 2 : 1) * wt;
                          if ((mt = ct + 832 + (Q = 3 * (16 * X + rs[I.L]) / 2 * Bt) + (pt = I.Fa != null && 0 < I.Fa.length ? I.Kc.c * I.Kc.i : 0)) != mt) X = 0;
                          else {
                            if (mt > I.Vb) {
                              if (I.Vb = 0, I.Ec = o(mt), I.Fc = 0, I.Ec == null) {
                                X = rn(I, 1, "no memory during frame initialization.");
                                break e;
                              }
                              I.Vb = mt;
                            }
                            mt = I.Ec, yt = I.Fc, I.Ac = mt, I.Bc = yt, yt += ct, I.Gd = u(Bt, To), I.Hd = 0, I.rb = u(Ct + 1, Ra), I.sb = 1, I.wa = he ? u(he, Qn) : null, I.Y = 0, I.D.Nb = 0, I.D.wa = I.wa, I.D.Y = I.Y, 0 < I.Aa && (I.D.Y += wt), n(true), I.oc = mt, I.pc = yt, yt += 832, I.ya = u(Ot, Ma), I.aa = 0, I.D.ya = I.ya, I.D.aa = I.aa, I.Aa == 2 && (I.D.aa += wt), I.R = 16 * wt, I.B = 8 * wt, wt = (Bt = rs[I.L]) * I.R, Bt = Bt / 2 * I.B, I.sa = mt, I.ta = yt + wt, I.qa = I.sa, I.ra = I.ta + 16 * X * I.R + Bt, I.Ha = I.qa, I.Ia = I.ra + 8 * X * I.B + Bt, I.$c = 0, yt += Q, I.mb = pt ? mt : null, I.nb = pt ? yt : null, n(yt + pt <= I.Fc + I.Vb), Si(I), i(I.Ac, I.Bc, 0, ct), X = 1;
                          }
                        }
                        if (X) {
                          if (Z.ka = 0, Z.y = I.sa, Z.O = I.ta, Z.f = I.qa, Z.N = I.ra, Z.ea = I.Ha, Z.Vd = I.Ia, Z.fa = I.R, Z.Rc = I.B, Z.F = null, Z.J = 0, !Mh) {
                            for (X = -255; 255 >= X; ++X) Fh[255 + X] = 0 > X ? -X : X;
                            for (X = -1020; 1020 >= X; ++X) Oh[1020 + X] = -128 > X ? -128 : 127 < X ? 127 : X;
                            for (X = -112; 112 >= X; ++X) Th[112 + X] = -16 > X ? -16 : 15 < X ? 15 : X;
                            for (X = -255; 510 >= X; ++X) Rh[255 + X] = 0 > X ? 0 : 255 < X ? 255 : X;
                            Mh = 1;
                          }
                          oi = Do, Wi = zs, Lr = Hs, Ne = yr, Oe = jo, nr = Us, Xe = zo, hn = Ho, zr = h, eo = v, pa = Ti, Yo = Wo, Ah = F, Lh = U, Nh = Va, Sh = Oi, kh = qo, Ph = Uo, cr[0] = Ks, cr[1] = ja, cr[2] = Ys, cr[3] = $s, cr[4] = Xs, cr[5] = Br, cr[6] = Mr, cr[7] = Js, cr[8] = sa, cr[9] = Qs, si[0] = Jr, si[1] = Vs, si[2] = Gs, si[3] = Da, si[4] = Zs, si[5] = Ci, si[6] = qa, Hr[0] = ha, Hr[1] = Ws, Hr[2] = Ua, Hr[3] = Ei, Hr[4] = za, Hr[5] = tl, Hr[6] = Ha, X = 1;
                        } else X = 0;
                      }
                      X && (X = (function(me, un) {
                        for (me.M = 0; me.M < me.Va; ++me.M) {
                          var ue, Tt = me.Jc[me.M & me.Xb], Nt = me.m, Je = me;
                          for (ue = 0; ue < Je.za; ++ue) {
                            var ae = Nt, be = Je, De = be.Ac, bn = be.Bc + 4 * ue, Cn = be.zc, Ve = be.ya[be.aa + ue];
                            if (be.Qa.Bb ? Ve.$b = vt(ae, be.Pa.jb[0]) ? 2 + vt(ae, be.Pa.jb[2]) : vt(ae, be.Pa.jb[1]) : Ve.$b = 0, be.kc && (Ve.Ad = vt(ae, be.Bd)), Ve.Za = !vt(ae, 145) + 0, Ve.Za) {
                              var Ln = Ve.Ob, En = 0;
                              for (be = 0; 4 > be; ++be) {
                                var cn, we = Cn[0 + be];
                                for (cn = 0; 4 > cn; ++cn) {
                                  we = t1[De[bn + cn]][we];
                                  for (var Se = qh[vt(ae, we[0])]; 0 < Se; ) Se = qh[2 * Se + vt(ae, we[Se])];
                                  we = -Se, De[bn + cn] = we;
                                }
                                r(Ln, En, De, bn, 4), En += 4, Cn[0 + be] = we;
                              }
                            } else we = vt(ae, 156) ? vt(ae, 128) ? 1 : 3 : vt(ae, 163) ? 2 : 0, Ve.Ob[0] = we, i(De, bn, we, 4), i(Cn, 0, we, 4);
                            Ve.Dd = vt(ae, 142) ? vt(ae, 114) ? vt(ae, 183) ? 1 : 3 : 2 : 0;
                          }
                          if (Je.m.Ka) return rn(me, 7, "Premature end-of-partition0 encountered.");
                          for (; me.ja < me.za; ++me.ja) {
                            if (Je = Tt, ae = (Nt = me).rb[Nt.sb - 1], De = Nt.rb[Nt.sb + Nt.ja], ue = Nt.ya[Nt.aa + Nt.ja], bn = Nt.kc ? ue.Ad : 0) ae.la = De.la = 0, ue.Za || (ae.Na = De.Na = 0), ue.Hc = 0, ue.Gc = 0, ue.ia = 0;
                            else {
                              var Ge, ke;
                              if (ae = De, De = Je, bn = Nt.Pa.Xc, Cn = Nt.ya[Nt.aa + Nt.ja], Ve = Nt.pb[Cn.$b], be = Cn.ad, Ln = 0, En = Nt.rb[Nt.sb - 1], we = cn = 0, i(be, Ln, 0, 384), Cn.Za) var wn = 0, fr = bn[3];
                              else {
                                Se = o(16);
                                var Qe = ae.Na + En.Na;
                                if (Qe = ro(De, bn[1], Qe, Ve.Eb, 0, Se, 0), ae.Na = En.Na = (0 < Qe) + 0, 1 < Qe) oi(Se, 0, be, Ln);
                                else {
                                  var Tn = Se[0] + 3 >> 3;
                                  for (Se = 0; 256 > Se; Se += 16) be[Ln + Se] = Tn;
                                }
                                wn = 1, fr = bn[0];
                              }
                              var Te = 15 & ae.la, fn = 15 & En.la;
                              for (Se = 0; 4 > Se; ++Se) {
                                var Un = 1 & fn;
                                for (Tn = ke = 0; 4 > Tn; ++Tn) Te = Te >> 1 | (Un = (Qe = ro(De, fr, Qe = Un + (1 & Te), Ve.Sc, wn, be, Ln)) > wn) << 7, ke = ke << 2 | (3 < Qe ? 3 : 1 < Qe ? 2 : be[Ln + 0] != 0), Ln += 16;
                                Te >>= 4, fn = fn >> 1 | Un << 7, cn = (cn << 8 | ke) >>> 0;
                              }
                              for (fr = Te, wn = fn >> 4, Ge = 0; 4 > Ge; Ge += 2) {
                                for (ke = 0, Te = ae.la >> 4 + Ge, fn = En.la >> 4 + Ge, Se = 0; 2 > Se; ++Se) {
                                  for (Un = 1 & fn, Tn = 0; 2 > Tn; ++Tn) Qe = Un + (1 & Te), Te = Te >> 1 | (Un = 0 < (Qe = ro(De, bn[2], Qe, Ve.Qc, 0, be, Ln))) << 3, ke = ke << 2 | (3 < Qe ? 3 : 1 < Qe ? 2 : be[Ln + 0] != 0), Ln += 16;
                                  Te >>= 2, fn = fn >> 1 | Un << 5;
                                }
                                we |= ke << 4 * Ge, fr |= Te << 4 << Ge, wn |= (240 & fn) << Ge;
                              }
                              ae.la = fr, En.la = wn, Cn.Hc = cn, Cn.Gc = we, Cn.ia = 43690 & we ? 0 : Ve.ia, bn = !(cn | we);
                            }
                            if (0 < Nt.L && (Nt.wa[Nt.Y + Nt.ja] = Nt.gd[ue.$b][ue.Za], Nt.wa[Nt.Y + Nt.ja].La |= !bn), Je.Ka) return rn(me, 7, "Premature end-of-file encountered.");
                          }
                          if (Si(me), Nt = un, Je = 1, ue = (Tt = me).D, ae = 0 < Tt.L && Tt.M >= Tt.zb && Tt.M <= Tt.Va, Tt.Aa == 0) e: {
                            if (ue.M = Tt.M, ue.uc = ae, er(Tt, ue), Je = 1, ue = (ke = Tt.D).Nb, ae = (we = rs[Tt.L]) * Tt.R, De = we / 2 * Tt.B, Se = 16 * ue * Tt.R, Tn = 8 * ue * Tt.B, bn = Tt.sa, Cn = Tt.ta - ae + Se, Ve = Tt.qa, be = Tt.ra - De + Tn, Ln = Tt.Ha, En = Tt.Ia - De + Tn, fn = (Te = ke.M) == 0, cn = Te >= Tt.Va - 1, Tt.Aa == 2 && er(Tt, ke), ke.uc) for (Un = (Qe = Tt).D.M, n(Qe.D.uc), ke = Qe.yb; ke < Qe.Hb; ++ke) {
                              wn = ke, fr = Un;
                              var In = (zn = (_n = Qe).D).Nb;
                              Ge = _n.R;
                              var zn = zn.wa[zn.Y + wn], Hn = _n.sa, Rn = _n.ta + 16 * In * Ge + 16 * wn, Wn = zn.dd, je = zn.tc;
                              if (je != 0) if (n(3 <= je), _n.L == 1) 0 < wn && Sh(Hn, Rn, Ge, je + 4), zn.La && Ph(Hn, Rn, Ge, je), 0 < fr && Nh(Hn, Rn, Ge, je + 4), zn.La && kh(Hn, Rn, Ge, je);
                              else {
                                var Vn = _n.B, dr = _n.qa, Vi = _n.ra + 8 * In * Vn + 8 * wn, Wr = _n.Ha, _n = _n.Ia + 8 * In * Vn + 8 * wn;
                                In = zn.ld, 0 < wn && (hn(Hn, Rn, Ge, je + 4, Wn, In), eo(dr, Vi, Wr, _n, Vn, je + 4, Wn, In)), zn.La && (Yo(Hn, Rn, Ge, je, Wn, In), Lh(dr, Vi, Wr, _n, Vn, je, Wn, In)), 0 < fr && (Xe(Hn, Rn, Ge, je + 4, Wn, In), zr(dr, Vi, Wr, _n, Vn, je + 4, Wn, In)), zn.La && (pa(Hn, Rn, Ge, je, Wn, In), Ah(dr, Vi, Wr, _n, Vn, je, Wn, In));
                              }
                            }
                            if (Tt.ia && alert("todo:DitherRow"), Nt.put != null) {
                              if (ke = 16 * Te, Te = 16 * (Te + 1), fn ? (Nt.y = Tt.sa, Nt.O = Tt.ta + Se, Nt.f = Tt.qa, Nt.N = Tt.ra + Tn, Nt.ea = Tt.Ha, Nt.W = Tt.Ia + Tn) : (ke -= we, Nt.y = bn, Nt.O = Cn, Nt.f = Ve, Nt.N = be, Nt.ea = Ln, Nt.W = En), cn || (Te -= we), Te > Nt.o && (Te = Nt.o), Nt.F = null, Nt.J = null, Tt.Fa != null && 0 < Tt.Fa.length && ke < Te && (Nt.J = an(Tt, Nt, ke, Te - ke), Nt.F = Tt.mb, Nt.F == null && Nt.F.length == 0)) {
                                Je = rn(Tt, 3, "Could not decode alpha data.");
                                break e;
                              }
                              ke < Nt.j && (we = Nt.j - ke, ke = Nt.j, n(!(1 & we)), Nt.O += Tt.R * we, Nt.N += Tt.B * (we >> 1), Nt.W += Tt.B * (we >> 1), Nt.F != null && (Nt.J += Nt.width * we)), ke < Te && (Nt.O += Nt.v, Nt.N += Nt.v >> 1, Nt.W += Nt.v >> 1, Nt.F != null && (Nt.J += Nt.v), Nt.ka = ke - Nt.j, Nt.U = Nt.va - Nt.v, Nt.T = Te - ke, Je = Nt.put(Nt));
                            }
                            ue + 1 != Tt.Ic || cn || (r(Tt.sa, Tt.ta - ae, bn, Cn + 16 * Tt.R, ae), r(Tt.qa, Tt.ra - De, Ve, be + 8 * Tt.B, De), r(Tt.Ha, Tt.Ia - De, Ln, En + 8 * Tt.B, De));
                          }
                          if (!Je) return rn(me, 6, "Output aborted.");
                        }
                        return 1;
                      })(I, Z)), Z.bc != null && Z.bc(Z), X &= 1;
                    }
                    return X ? (I.cb = 0, X) : 0;
                  })(a, m) || (s = a.a);
                }
              } else s = a.a;
            }
            s == 0 && y.Oa != null && y.Oa.fd && (s = $a(y.ba));
          }
          y = s;
        }
        w = y != 0 ? null : 11 > w ? A.f.RGBA.eb : A.f.kb.y;
      } else w = null;
      return w;
    };
    var $h = [3, 4, 3, 4, 4, 2, 2, 4, 4, 4, 2, 1, 1];
  };
  function c(j, J) {
    for (var N = "", C = 0; C < 4; C++) N += String.fromCharCode(j[J++]);
    return N;
  }
  function p(j, J) {
    return j[J + 0] | j[J + 1] << 8;
  }
  function x(j, J) {
    return (j[J + 0] | j[J + 1] << 8 | j[J + 2] << 16) >>> 0;
  }
  function L(j, J) {
    return (j[J + 0] | j[J + 1] << 8 | j[J + 2] << 16 | j[J + 3] << 24) >>> 0;
  }
  new f();
  var g = [0], O = [0], P = [], M = new f(), k = t3, V = (function(j, J) {
    var N = {}, C = 0, z = false, q = 0, rt = 0;
    if (N.frames = [], !(function(_, T) {
      for (var B = 0; B < 4; B++) if (_[T + B] != "RIFF".charCodeAt(B)) return true;
      return false;
    })(j, J)) {
      for (L(j, J += 4), J += 8; J < j.length; ) {
        var st = c(j, J), ht = L(j, J += 4);
        J += 4;
        var tt = ht + (1 & ht);
        switch (st) {
          case "VP8 ":
          case "VP8L":
            N.frames[C] === void 0 && (N.frames[C] = {}), (lt = N.frames[C]).src_off = z ? rt : J - 8, lt.src_size = q + ht + 8, C++, z && (z = false, q = 0, rt = 0);
            break;
          case "VP8X":
            (lt = N.header = {}).feature_flags = j[J];
            var ft = J + 4;
            lt.canvas_width = 1 + x(j, ft), ft += 3, lt.canvas_height = 1 + x(j, ft), ft += 3;
            break;
          case "ALPH":
            z = true, q = tt + 8, rt = J - 8;
            break;
          case "ANIM":
            (lt = N.header).bgcolor = L(j, J), ft = J + 4, lt.loop_count = p(j, ft), ft += 2;
            break;
          case "ANMF":
            var Lt, lt;
            (lt = N.frames[C] = {}).offset_x = 2 * x(j, J), J += 3, lt.offset_y = 2 * x(j, J), J += 3, lt.width = 1 + x(j, J), J += 3, lt.height = 1 + x(j, J), J += 3, lt.duration = x(j, J), J += 3, Lt = j[J++], lt.dispose = 1 & Lt, lt.blend = Lt >> 1 & 1;
        }
        st != "ANMF" && (J += tt);
      }
      return N;
    }
  })(k, 0);
  V.response = k, V.rgbaoutput = true, V.dataurl = false;
  var G = V.header ? V.header : null, D = V.frames ? V.frames : null;
  if (G) {
    G.loop_counter = G.loop_count, g = [G.canvas_height], O = [G.canvas_width];
    for (var it = 0; it < D.length && D[it].blend != 0; it++) ;
  }
  var bt = D[0], dt = M.WebPDecodeRGBA(k, bt.src_off, bt.src_size, O, g);
  bt.rgba = dt, bt.imgwidth = O[0], bt.imgheight = g[0];
  for (var $ = 0; $ < O[0] * g[0] * 4; $++) P[$] = dt[$];
  return this.width = O, this.height = g, this.data = P, this;
}
(function(t3) {
  var n, e, r, i, o, u, l, f, c, p = function(_) {
    return _ = _ || {}, this.isStrokeTransparent = _.isStrokeTransparent || false, this.strokeOpacity = _.strokeOpacity || 1, this.strokeStyle = _.strokeStyle || "#000000", this.fillStyle = _.fillStyle || "#000000", this.isFillTransparent = _.isFillTransparent || false, this.fillOpacity = _.fillOpacity || 1, this.font = _.font || "10px sans-serif", this.textBaseline = _.textBaseline || "alphabetic", this.textAlign = _.textAlign || "left", this.lineWidth = _.lineWidth || 1, this.lineJoin = _.lineJoin || "miter", this.lineCap = _.lineCap || "butt", this.path = _.path || [], this.transform = _.transform !== void 0 ? _.transform.clone() : new f(), this.globalCompositeOperation = _.globalCompositeOperation || "normal", this.globalAlpha = _.globalAlpha || 1, this.clip_path = _.clip_path || [], this.currentPoint = _.currentPoint || new u(), this.miterLimit = _.miterLimit || 10, this.lastPoint = _.lastPoint || new u(), this.lineDashOffset = _.lineDashOffset || 0, this.lineDash = _.lineDash || [], this.margin = _.margin || [0, 0, 0, 0], this.prevPageLastElemOffset = _.prevPageLastElemOffset || 0, this.ignoreClearRect = typeof _.ignoreClearRect != "boolean" || _.ignoreClearRect, this;
  };
  t3.events.push(["initialized", function() {
    this.context2d = new x(this), n = this.internal.f2, e = this.internal.getCoordinateString, r = this.internal.getVerticalCoordinateString, i = this.internal.getHorizontalCoordinate, o = this.internal.getVerticalCoordinate, u = this.internal.Point, l = this.internal.Rectangle, f = this.internal.Matrix, c = new p();
  }]);
  var x = function(_) {
    Object.defineProperty(this, "canvas", { get: function() {
      return { parentNode: false, style: false };
    } });
    var T = _;
    Object.defineProperty(this, "pdf", { get: function() {
      return T;
    } });
    var B = false;
    Object.defineProperty(this, "pageWrapXEnabled", { get: function() {
      return B;
    }, set: function(ut) {
      B = !!ut;
    } });
    var H = false;
    Object.defineProperty(this, "pageWrapYEnabled", { get: function() {
      return H;
    }, set: function(ut) {
      H = !!ut;
    } });
    var Y = 0;
    Object.defineProperty(this, "posX", { get: function() {
      return Y;
    }, set: function(ut) {
      isNaN(ut) || (Y = ut);
    } });
    var nt = 0;
    Object.defineProperty(this, "posY", { get: function() {
      return nt;
    }, set: function(ut) {
      isNaN(ut) || (nt = ut);
    } }), Object.defineProperty(this, "margin", { get: function() {
      return c.margin;
    }, set: function(ut) {
      var R;
      typeof ut == "number" ? R = [ut, ut, ut, ut] : ((R = new Array(4))[0] = ut[0], R[1] = ut.length >= 2 ? ut[1] : R[0], R[2] = ut.length >= 3 ? ut[2] : R[0], R[3] = ut.length >= 4 ? ut[3] : R[1]), c.margin = R;
    } });
    var ot = false;
    Object.defineProperty(this, "autoPaging", { get: function() {
      return ot;
    }, set: function(ut) {
      ot = ut;
    } });
    var at = 0;
    Object.defineProperty(this, "lastBreak", { get: function() {
      return at;
    }, set: function(ut) {
      at = ut;
    } });
    var vt = [];
    Object.defineProperty(this, "pageBreaks", { get: function() {
      return vt;
    }, set: function(ut) {
      vt = ut;
    } }), Object.defineProperty(this, "ctx", { get: function() {
      return c;
    }, set: function(ut) {
      ut instanceof p && (c = ut);
    } }), Object.defineProperty(this, "path", { get: function() {
      return c.path;
    }, set: function(ut) {
      c.path = ut;
    } });
    var xt = [];
    Object.defineProperty(this, "ctxStack", { get: function() {
      return xt;
    }, set: function(ut) {
      xt = ut;
    } }), Object.defineProperty(this, "fillStyle", { get: function() {
      return this.ctx.fillStyle;
    }, set: function(ut) {
      var R;
      R = L(ut), this.ctx.fillStyle = R.style, this.ctx.isFillTransparent = R.a === 0, this.ctx.fillOpacity = R.a, this.pdf.setFillColor(R.r, R.g, R.b, { a: R.a }), this.pdf.setTextColor(R.r, R.g, R.b, { a: R.a });
    } }), Object.defineProperty(this, "strokeStyle", { get: function() {
      return this.ctx.strokeStyle;
    }, set: function(ut) {
      var R = L(ut);
      this.ctx.strokeStyle = R.style, this.ctx.isStrokeTransparent = R.a === 0, this.ctx.strokeOpacity = R.a, R.a === 0 ? this.pdf.setDrawColor(255, 255, 255) : (R.a, this.pdf.setDrawColor(R.r, R.g, R.b));
    } }), Object.defineProperty(this, "lineCap", { get: function() {
      return this.ctx.lineCap;
    }, set: function(ut) {
      ["butt", "round", "square"].indexOf(ut) !== -1 && (this.ctx.lineCap = ut, this.pdf.setLineCap(ut));
    } }), Object.defineProperty(this, "lineWidth", { get: function() {
      return this.ctx.lineWidth;
    }, set: function(ut) {
      isNaN(ut) || (this.ctx.lineWidth = ut, this.pdf.setLineWidth(ut));
    } }), Object.defineProperty(this, "lineJoin", { get: function() {
      return this.ctx.lineJoin;
    }, set: function(ut) {
      ["bevel", "round", "miter"].indexOf(ut) !== -1 && (this.ctx.lineJoin = ut, this.pdf.setLineJoin(ut));
    } }), Object.defineProperty(this, "miterLimit", { get: function() {
      return this.ctx.miterLimit;
    }, set: function(ut) {
      isNaN(ut) || (this.ctx.miterLimit = ut, this.pdf.setMiterLimit(ut));
    } }), Object.defineProperty(this, "textBaseline", { get: function() {
      return this.ctx.textBaseline;
    }, set: function(ut) {
      this.ctx.textBaseline = ut;
    } }), Object.defineProperty(this, "textAlign", { get: function() {
      return this.ctx.textAlign;
    }, set: function(ut) {
      ["right", "end", "center", "left", "start"].indexOf(ut) !== -1 && (this.ctx.textAlign = ut);
    } });
    var kt = null, Pt = null;
    Object.defineProperty(this, "fontFaces", { get: function() {
      return Pt;
    }, set: function(ut) {
      kt = null, Pt = ut;
    } }), Object.defineProperty(this, "font", { get: function() {
      return this.ctx.font;
    }, set: function(ut) {
      var R;
      if (this.ctx.font = ut, (R = /^\s*(?=(?:(?:[-a-z]+\s*){0,2}(italic|oblique))?)(?=(?:(?:[-a-z]+\s*){0,2}(small-caps))?)(?=(?:(?:[-a-z]+\s*){0,2}(bold(?:er)?|lighter|[1-9]00))?)(?:(?:normal|\1|\2|\3)\s*){0,3}((?:xx?-)?(?:small|large)|medium|smaller|larger|[.\d]+(?:\%|in|[cem]m|ex|p[ctx]))(?:\s*\/\s*(normal|[.\d]+(?:\%|in|[cem]m|ex|p[ctx])))?\s*([-_,\"\'\sa-z]+?)\s*$/i.exec(ut)) !== null) {
        var pe = R[1];
        R[2];
        var oe = R[3], Ht = R[4];
        R[5];
        var At = R[6], Dt = /^([.\d]+)((?:%|in|[cem]m|ex|p[ctx]))$/i.exec(Ht)[2];
        Ht = Math.floor(Dt === "px" ? parseFloat(Ht) * this.pdf.internal.scaleFactor : Dt === "em" ? parseFloat(Ht) * this.pdf.getFontSize() : parseFloat(Ht) * this.pdf.internal.scaleFactor), this.pdf.setFontSize(Ht);
        var St = (function(Yt) {
          var Ut, Me, ye = [], Mt = Yt.trim();
          if (Mt === "") return Vl;
          if (Mt in vc) return [vc[Mt]];
          for (; Mt !== ""; ) {
            switch (Me = null, Ut = (Mt = wc(Mt)).charAt(0)) {
              case '"':
              case "'":
                Me = fd(Mt.substring(1), Ut);
                break;
              default:
                Me = dd(Mt);
            }
            if (Me === null || (ye.push(Me[0]), (Mt = wc(Me[1])) !== "" && Mt.charAt(0) !== ",")) return Vl;
            Mt = Mt.replace(/^,/, "");
          }
          return ye;
        })(At);
        if (this.fontFaces) {
          var se = (function(Yt, Ut) {
            if (kt === null) {
              var Me = (function(ye) {
                var Mt = [];
                return Object.keys(ye).forEach(function(re) {
                  ye[re].forEach(function(Ie) {
                    var Wt = null;
                    switch (Ie) {
                      case "bold":
                        Wt = { family: re, weight: "bold" };
                        break;
                      case "italic":
                        Wt = { family: re, style: "italic" };
                        break;
                      case "bolditalic":
                        Wt = { family: re, weight: "bold", style: "italic" };
                        break;
                      case "":
                      case "normal":
                        Wt = { family: re };
                    }
                    Wt !== null && (Wt.ref = { name: re, style: Ie }, Mt.push(Wt));
                  });
                }), Mt;
              })(Yt.getFontList());
              kt = (function(ye) {
                for (var Mt = {}, re = 0; re < ye.length; ++re) {
                  var Ie = Wl(ye[re]), Wt = Ie.family, ge = Ie.stretch, ie = Ie.style, Ye = Ie.weight;
                  Mt[Wt] = Mt[Wt] || {}, Mt[Wt][ge] = Mt[Wt][ge] || {}, Mt[Wt][ge][ie] = Mt[Wt][ge][ie] || {}, Mt[Wt][ge][ie][Ye] = Ie;
                }
                return Mt;
              })(Me.concat(Ut));
            }
            return kt;
          })(this.pdf, this.fontFaces), zt = St.map(function(Yt) {
            return { family: Yt, stretch: "normal", weight: oe, style: pe };
          }), _e = (function(Yt, Ut, Me) {
            for (var ye = (Me = Me || {}).defaultFontFamily || "times", Mt = Object.assign({}, cd, Me.genericFontFamilies || {}), re = null, Ie = null, Wt = 0; Wt < Ut.length; ++Wt) if (Mt[(re = Wl(Ut[Wt])).family] && (re.family = Mt[re.family]), Yt.hasOwnProperty(re.family)) {
              Ie = Yt[re.family];
              break;
            }
            if (!(Ie = Ie || Yt[ye])) throw new Error("Could not find a font-family for the rule '" + bc(re) + "' and default family '" + ye + "'.");
            if (Ie = (function(ge, ie) {
              if (ie[ge]) return ie[ge];
              var Ye = uh[ge], sn = Ye <= uh.normal ? -1 : 1, Fe = mc(ie, Df, Ye, sn);
              if (!Fe) throw new Error("Could not find a matching font-stretch value for " + ge);
              return Fe;
            })(re.stretch, Ie), Ie = (function(ge, ie) {
              if (ie[ge]) return ie[ge];
              for (var Ye = jf[ge], sn = 0; sn < Ye.length; ++sn) if (ie[Ye[sn]]) return ie[Ye[sn]];
              throw new Error("Could not find a matching font-style for " + ge);
            })(re.style, Ie), !(Ie = (function(ge, ie) {
              if (ie[ge]) return ie[ge];
              if (ge === 400 && ie[500]) return ie[500];
              if (ge === 500 && ie[400]) return ie[400];
              var Ye = ud[ge], sn = mc(ie, qf, Ye, ge < 400 ? -1 : 1);
              if (!sn) throw new Error("Could not find a matching font-weight for value " + ge);
              return sn;
            })(re.weight, Ie))) throw new Error("Failed to resolve a font for the rule '" + bc(re) + "'.");
            return Ie;
          })(se, zt);
          this.pdf.setFont(_e.ref.name, _e.ref.style);
        } else {
          var ee = "";
          (oe === "bold" || parseInt(oe, 10) >= 700 || pe === "bold") && (ee = "bold"), pe === "italic" && (ee += "italic"), ee.length === 0 && (ee = "normal");
          for (var ne = "", Ee = { arial: "Helvetica", Arial: "Helvetica", verdana: "Helvetica", Verdana: "Helvetica", helvetica: "Helvetica", Helvetica: "Helvetica", "sans-serif": "Helvetica", fixed: "Courier", monospace: "Courier", terminal: "Courier", cursive: "Times", fantasy: "Times", serif: "Times" }, le = 0; le < St.length; le++) {
            if (this.pdf.internal.getFont(St[le], ee, { noFallback: true, disableWarning: true }) !== void 0) {
              ne = St[le];
              break;
            }
            if (ee === "bolditalic" && this.pdf.internal.getFont(St[le], "bold", { noFallback: true, disableWarning: true }) !== void 0) ne = St[le], ee = "bold";
            else if (this.pdf.internal.getFont(St[le], "normal", { noFallback: true, disableWarning: true }) !== void 0) {
              ne = St[le], ee = "normal";
              break;
            }
          }
          if (ne === "") {
            for (var qt = 0; qt < St.length; qt++) if (Ee[St[qt]]) {
              ne = Ee[St[qt]];
              break;
            }
          }
          ne = ne === "" ? "Times" : ne, this.pdf.setFont(ne, ee);
        }
      }
    } }), Object.defineProperty(this, "globalCompositeOperation", { get: function() {
      return this.ctx.globalCompositeOperation;
    }, set: function(ut) {
      this.ctx.globalCompositeOperation = ut;
    } }), Object.defineProperty(this, "globalAlpha", { get: function() {
      return this.ctx.globalAlpha;
    }, set: function(ut) {
      this.ctx.globalAlpha = ut;
    } }), Object.defineProperty(this, "lineDashOffset", { get: function() {
      return this.ctx.lineDashOffset;
    }, set: function(ut) {
      this.ctx.lineDashOffset = ut, lt.call(this);
    } }), Object.defineProperty(this, "lineDash", { get: function() {
      return this.ctx.lineDash;
    }, set: function(ut) {
      this.ctx.lineDash = ut, lt.call(this);
    } }), Object.defineProperty(this, "ignoreClearRect", { get: function() {
      return this.ctx.ignoreClearRect;
    }, set: function(ut) {
      this.ctx.ignoreClearRect = !!ut;
    } });
  };
  x.prototype.setLineDash = function(_) {
    this.lineDash = _;
  }, x.prototype.getLineDash = function() {
    return this.lineDash.length % 2 ? this.lineDash.concat(this.lineDash) : this.lineDash.slice();
  }, x.prototype.fill = function() {
    D.call(this, "fill", false);
  }, x.prototype.stroke = function() {
    D.call(this, "stroke", false);
  }, x.prototype.beginPath = function() {
    this.path = [{ type: "begin" }];
  }, x.prototype.moveTo = function(_, T) {
    if (isNaN(_) || isNaN(T)) throw Re.error("jsPDF.context2d.moveTo: Invalid arguments", arguments), new Error("Invalid arguments passed to jsPDF.context2d.moveTo");
    var B = this.ctx.transform.applyToPoint(new u(_, T));
    this.path.push({ type: "mt", x: B.x, y: B.y }), this.ctx.lastPoint = new u(_, T);
  }, x.prototype.closePath = function() {
    var _ = new u(0, 0), T = 0;
    for (T = this.path.length - 1; T !== -1; T--) if (this.path[T].type === "begin" && Ce(this.path[T + 1]) === "object" && typeof this.path[T + 1].x == "number") {
      _ = new u(this.path[T + 1].x, this.path[T + 1].y);
      break;
    }
    this.path.push({ type: "close" }), this.ctx.lastPoint = new u(_.x, _.y);
  }, x.prototype.lineTo = function(_, T) {
    if (isNaN(_) || isNaN(T)) throw Re.error("jsPDF.context2d.lineTo: Invalid arguments", arguments), new Error("Invalid arguments passed to jsPDF.context2d.lineTo");
    var B = this.ctx.transform.applyToPoint(new u(_, T));
    this.path.push({ type: "lt", x: B.x, y: B.y }), this.ctx.lastPoint = new u(B.x, B.y);
  }, x.prototype.clip = function() {
    this.ctx.clip_path = JSON.parse(JSON.stringify(this.path)), D.call(this, null, true);
  }, x.prototype.quadraticCurveTo = function(_, T, B, H) {
    if (isNaN(B) || isNaN(H) || isNaN(_) || isNaN(T)) throw Re.error("jsPDF.context2d.quadraticCurveTo: Invalid arguments", arguments), new Error("Invalid arguments passed to jsPDF.context2d.quadraticCurveTo");
    var Y = this.ctx.transform.applyToPoint(new u(B, H)), nt = this.ctx.transform.applyToPoint(new u(_, T));
    this.path.push({ type: "qct", x1: nt.x, y1: nt.y, x: Y.x, y: Y.y }), this.ctx.lastPoint = new u(Y.x, Y.y);
  }, x.prototype.bezierCurveTo = function(_, T, B, H, Y, nt) {
    if (isNaN(Y) || isNaN(nt) || isNaN(_) || isNaN(T) || isNaN(B) || isNaN(H)) throw Re.error("jsPDF.context2d.bezierCurveTo: Invalid arguments", arguments), new Error("Invalid arguments passed to jsPDF.context2d.bezierCurveTo");
    var ot = this.ctx.transform.applyToPoint(new u(Y, nt)), at = this.ctx.transform.applyToPoint(new u(_, T)), vt = this.ctx.transform.applyToPoint(new u(B, H));
    this.path.push({ type: "bct", x1: at.x, y1: at.y, x2: vt.x, y2: vt.y, x: ot.x, y: ot.y }), this.ctx.lastPoint = new u(ot.x, ot.y);
  }, x.prototype.arc = function(_, T, B, H, Y, nt) {
    if (isNaN(_) || isNaN(T) || isNaN(B) || isNaN(H) || isNaN(Y)) throw Re.error("jsPDF.context2d.arc: Invalid arguments", arguments), new Error("Invalid arguments passed to jsPDF.context2d.arc");
    if (nt = !!nt, !this.ctx.transform.isIdentity) {
      var ot = this.ctx.transform.applyToPoint(new u(_, T));
      _ = ot.x, T = ot.y;
      var at = this.ctx.transform.applyToPoint(new u(0, B)), vt = this.ctx.transform.applyToPoint(new u(0, 0));
      B = Math.sqrt(Math.pow(at.x - vt.x, 2) + Math.pow(at.y - vt.y, 2));
    }
    Math.abs(Y - H) >= 2 * Math.PI && (H = 0, Y = 2 * Math.PI), this.path.push({ type: "arc", x: _, y: T, radius: B, startAngle: H, endAngle: Y, counterclockwise: nt });
  }, x.prototype.arcTo = function(_, T, B, H, Y) {
    throw new Error("arcTo not implemented.");
  }, x.prototype.rect = function(_, T, B, H) {
    if (isNaN(_) || isNaN(T) || isNaN(B) || isNaN(H)) throw Re.error("jsPDF.context2d.rect: Invalid arguments", arguments), new Error("Invalid arguments passed to jsPDF.context2d.rect");
    this.moveTo(_, T), this.lineTo(_ + B, T), this.lineTo(_ + B, T + H), this.lineTo(_, T + H), this.lineTo(_, T), this.lineTo(_ + B, T), this.lineTo(_, T);
  }, x.prototype.fillRect = function(_, T, B, H) {
    if (isNaN(_) || isNaN(T) || isNaN(B) || isNaN(H)) throw Re.error("jsPDF.context2d.fillRect: Invalid arguments", arguments), new Error("Invalid arguments passed to jsPDF.context2d.fillRect");
    if (!g.call(this)) {
      var Y = {};
      this.lineCap !== "butt" && (Y.lineCap = this.lineCap, this.lineCap = "butt"), this.lineJoin !== "miter" && (Y.lineJoin = this.lineJoin, this.lineJoin = "miter"), this.beginPath(), this.rect(_, T, B, H), this.fill(), Y.hasOwnProperty("lineCap") && (this.lineCap = Y.lineCap), Y.hasOwnProperty("lineJoin") && (this.lineJoin = Y.lineJoin);
    }
  }, x.prototype.strokeRect = function(_, T, B, H) {
    if (isNaN(_) || isNaN(T) || isNaN(B) || isNaN(H)) throw Re.error("jsPDF.context2d.strokeRect: Invalid arguments", arguments), new Error("Invalid arguments passed to jsPDF.context2d.strokeRect");
    O.call(this) || (this.beginPath(), this.rect(_, T, B, H), this.stroke());
  }, x.prototype.clearRect = function(_, T, B, H) {
    if (isNaN(_) || isNaN(T) || isNaN(B) || isNaN(H)) throw Re.error("jsPDF.context2d.clearRect: Invalid arguments", arguments), new Error("Invalid arguments passed to jsPDF.context2d.clearRect");
    this.ignoreClearRect || (this.fillStyle = "#ffffff", this.fillRect(_, T, B, H));
  }, x.prototype.save = function(_) {
    _ = typeof _ != "boolean" || _;
    for (var T = this.pdf.internal.getCurrentPageInfo().pageNumber, B = 0; B < this.pdf.internal.getNumberOfPages(); B++) this.pdf.setPage(B + 1), this.pdf.internal.out("q");
    if (this.pdf.setPage(T), _) {
      this.ctx.fontSize = this.pdf.internal.getFontSize();
      var H = new p(this.ctx);
      this.ctxStack.push(this.ctx), this.ctx = H;
    }
  }, x.prototype.restore = function(_) {
    _ = typeof _ != "boolean" || _;
    for (var T = this.pdf.internal.getCurrentPageInfo().pageNumber, B = 0; B < this.pdf.internal.getNumberOfPages(); B++) this.pdf.setPage(B + 1), this.pdf.internal.out("Q");
    this.pdf.setPage(T), _ && this.ctxStack.length !== 0 && (this.ctx = this.ctxStack.pop(), this.fillStyle = this.ctx.fillStyle, this.strokeStyle = this.ctx.strokeStyle, this.font = this.ctx.font, this.lineCap = this.ctx.lineCap, this.lineWidth = this.ctx.lineWidth, this.lineJoin = this.ctx.lineJoin, this.lineDash = this.ctx.lineDash, this.lineDashOffset = this.ctx.lineDashOffset);
  }, x.prototype.toDataURL = function() {
    throw new Error("toDataUrl not implemented.");
  };
  var L = function(_) {
    var T, B, H, Y;
    if (_.isCanvasGradient === true && (_ = _.getColor()), !_) return { r: 0, g: 0, b: 0, a: 0, style: _ };
    if (/transparent|rgba\s*\(\s*(\d+)\s*,\s*(\d+)\s*,\s*(\d+)\s*,\s*0+\s*\)/.test(_)) T = 0, B = 0, H = 0, Y = 0;
    else {
      var nt = /rgb\s*\(\s*(\d+)\s*,\s*(\d+)\s*,\s*(\d+)\s*\)/.exec(_);
      if (nt !== null) T = parseInt(nt[1]), B = parseInt(nt[2]), H = parseInt(nt[3]), Y = 1;
      else if ((nt = /rgba\s*\(\s*(\d+)\s*,\s*(\d+)\s*,\s*(\d+)\s*,\s*([\d.]+)\s*\)/.exec(_)) !== null) T = parseInt(nt[1]), B = parseInt(nt[2]), H = parseInt(nt[3]), Y = parseFloat(nt[4]);
      else {
        if (Y = 1, typeof _ == "string" && _.charAt(0) !== "#") {
          var ot = new If(_);
          _ = ot.ok ? ot.toHex() : "#000000";
        }
        _.length === 4 ? (T = _.substring(1, 2), T += T, B = _.substring(2, 3), B += B, H = _.substring(3, 4), H += H) : (T = _.substring(1, 3), B = _.substring(3, 5), H = _.substring(5, 7)), T = parseInt(T, 16), B = parseInt(B, 16), H = parseInt(H, 16);
      }
    }
    return { r: T, g: B, b: H, a: Y, style: _ };
  }, g = function() {
    return this.ctx.isFillTransparent || this.globalAlpha == 0;
  }, O = function() {
    return !!(this.ctx.isStrokeTransparent || this.globalAlpha == 0);
  };
  x.prototype.fillText = function(_, T, B, H) {
    if (isNaN(T) || isNaN(B) || typeof _ != "string") throw Re.error("jsPDF.context2d.fillText: Invalid arguments", arguments), new Error("Invalid arguments passed to jsPDF.context2d.fillText");
    if (H = isNaN(H) ? void 0 : H, !g.call(this)) {
      var Y = tt(this.ctx.transform.rotation), nt = this.ctx.transform.scaleX;
      C.call(this, { text: _, x: T, y: B, scale: nt, angle: Y, align: this.textAlign, maxWidth: H });
    }
  }, x.prototype.strokeText = function(_, T, B, H) {
    if (isNaN(T) || isNaN(B) || typeof _ != "string") throw Re.error("jsPDF.context2d.strokeText: Invalid arguments", arguments), new Error("Invalid arguments passed to jsPDF.context2d.strokeText");
    if (!O.call(this)) {
      H = isNaN(H) ? void 0 : H;
      var Y = tt(this.ctx.transform.rotation), nt = this.ctx.transform.scaleX;
      C.call(this, { text: _, x: T, y: B, scale: nt, renderingMode: "stroke", angle: Y, align: this.textAlign, maxWidth: H });
    }
  }, x.prototype.measureText = function(_) {
    if (typeof _ != "string") throw Re.error("jsPDF.context2d.measureText: Invalid arguments", arguments), new Error("Invalid arguments passed to jsPDF.context2d.measureText");
    var T = this.pdf, B = this.pdf.internal.scaleFactor, H = T.internal.getFontSize(), Y = T.getStringUnitWidth(_) * H / T.internal.scaleFactor;
    return new function(nt) {
      var ot = (nt = nt || {}).width || 0;
      return Object.defineProperty(this, "width", { get: function() {
        return ot;
      } }), this;
    }({ width: Y *= Math.round(96 * B / 72 * 1e4) / 1e4 });
  }, x.prototype.scale = function(_, T) {
    if (isNaN(_) || isNaN(T)) throw Re.error("jsPDF.context2d.scale: Invalid arguments", arguments), new Error("Invalid arguments passed to jsPDF.context2d.scale");
    var B = new f(_, 0, 0, T, 0, 0);
    this.ctx.transform = this.ctx.transform.multiply(B);
  }, x.prototype.rotate = function(_) {
    if (isNaN(_)) throw Re.error("jsPDF.context2d.rotate: Invalid arguments", arguments), new Error("Invalid arguments passed to jsPDF.context2d.rotate");
    var T = new f(Math.cos(_), Math.sin(_), -Math.sin(_), Math.cos(_), 0, 0);
    this.ctx.transform = this.ctx.transform.multiply(T);
  }, x.prototype.translate = function(_, T) {
    if (isNaN(_) || isNaN(T)) throw Re.error("jsPDF.context2d.translate: Invalid arguments", arguments), new Error("Invalid arguments passed to jsPDF.context2d.translate");
    var B = new f(1, 0, 0, 1, _, T);
    this.ctx.transform = this.ctx.transform.multiply(B);
  }, x.prototype.transform = function(_, T, B, H, Y, nt) {
    if (isNaN(_) || isNaN(T) || isNaN(B) || isNaN(H) || isNaN(Y) || isNaN(nt)) throw Re.error("jsPDF.context2d.transform: Invalid arguments", arguments), new Error("Invalid arguments passed to jsPDF.context2d.transform");
    var ot = new f(_, T, B, H, Y, nt);
    this.ctx.transform = this.ctx.transform.multiply(ot);
  }, x.prototype.setTransform = function(_, T, B, H, Y, nt) {
    _ = isNaN(_) ? 1 : _, T = isNaN(T) ? 0 : T, B = isNaN(B) ? 0 : B, H = isNaN(H) ? 1 : H, Y = isNaN(Y) ? 0 : Y, nt = isNaN(nt) ? 0 : nt, this.ctx.transform = new f(_, T, B, H, Y, nt);
  };
  var P = function() {
    return this.margin[0] > 0 || this.margin[1] > 0 || this.margin[2] > 0 || this.margin[3] > 0;
  };
  x.prototype.drawImage = function(_, T, B, H, Y, nt, ot, at, vt) {
    var xt = this.pdf.getImageProperties(_), kt = 1, Pt = 1, ut = 1, R = 1;
    H !== void 0 && at !== void 0 && (ut = at / H, R = vt / Y, kt = xt.width / H * at / H, Pt = xt.height / Y * vt / Y), nt === void 0 && (nt = T, ot = B, T = 0, B = 0), H !== void 0 && at === void 0 && (at = H, vt = Y), H === void 0 && at === void 0 && (at = xt.width, vt = xt.height);
    for (var pe, oe = this.ctx.transform.decompose(), Ht = tt(oe.rotate.shx), At = new f(), Dt = (At = (At = (At = At.multiply(oe.translate)).multiply(oe.skew)).multiply(oe.scale)).applyToRectangle(new l(nt - T * ut, ot - B * R, H * kt, Y * Pt)), St = M.call(this, Dt), se = [], zt = 0; zt < St.length; zt += 1) se.indexOf(St[zt]) === -1 && se.push(St[zt]);
    if (G(se), this.autoPaging) for (var _e = se[0], ee = se[se.length - 1], ne = _e; ne < ee + 1; ne++) {
      this.pdf.setPage(ne);
      var Ee = this.pdf.internal.pageSize.width - this.margin[3] - this.margin[1], le = ne === 1 ? this.posY + this.margin[0] : this.margin[0], qt = this.pdf.internal.pageSize.height - this.posY - this.margin[0] - this.margin[2], Yt = this.pdf.internal.pageSize.height - this.margin[0] - this.margin[2], Ut = ne === 1 ? 0 : qt + (ne - 2) * Yt;
      if (this.ctx.clip_path.length !== 0) {
        var Me = this.path;
        pe = JSON.parse(JSON.stringify(this.ctx.clip_path)), this.path = V(pe, this.posX + this.margin[3], -Ut + le + this.ctx.prevPageLastElemOffset), it.call(this, "fill", true), this.path = Me;
      }
      var ye = JSON.parse(JSON.stringify(Dt));
      ye = V([ye], this.posX + this.margin[3], -Ut + le + this.ctx.prevPageLastElemOffset)[0];
      var Mt = (ne > _e || ne < ee) && P.call(this);
      Mt && (this.pdf.saveGraphicsState(), this.pdf.rect(this.margin[3], this.margin[0], Ee, Yt, null).clip().discardPath()), this.pdf.addImage(_, "JPEG", ye.x, ye.y, ye.w, ye.h, null, null, Ht), Mt && this.pdf.restoreGraphicsState();
    }
    else this.pdf.addImage(_, "JPEG", Dt.x, Dt.y, Dt.w, Dt.h, null, null, Ht);
  };
  var M = function(_, T, B) {
    var H = [];
    T = T || this.pdf.internal.pageSize.width, B = B || this.pdf.internal.pageSize.height - this.margin[0] - this.margin[2];
    var Y = this.posY + this.ctx.prevPageLastElemOffset;
    switch (_.type) {
      default:
      case "mt":
      case "lt":
        H.push(Math.floor((_.y + Y) / B) + 1);
        break;
      case "arc":
        H.push(Math.floor((_.y + Y - _.radius) / B) + 1), H.push(Math.floor((_.y + Y + _.radius) / B) + 1);
        break;
      case "qct":
        var nt = ft(this.ctx.lastPoint.x, this.ctx.lastPoint.y, _.x1, _.y1, _.x, _.y);
        H.push(Math.floor((nt.y + Y) / B) + 1), H.push(Math.floor((nt.y + nt.h + Y) / B) + 1);
        break;
      case "bct":
        var ot = Lt(this.ctx.lastPoint.x, this.ctx.lastPoint.y, _.x1, _.y1, _.x2, _.y2, _.x, _.y);
        H.push(Math.floor((ot.y + Y) / B) + 1), H.push(Math.floor((ot.y + ot.h + Y) / B) + 1);
        break;
      case "rect":
        H.push(Math.floor((_.y + Y) / B) + 1), H.push(Math.floor((_.y + _.h + Y) / B) + 1);
    }
    for (var at = 0; at < H.length; at += 1) for (; this.pdf.internal.getNumberOfPages() < H[at]; ) k.call(this);
    return H;
  }, k = function() {
    var _ = this.fillStyle, T = this.strokeStyle, B = this.font, H = this.lineCap, Y = this.lineWidth, nt = this.lineJoin;
    this.pdf.addPage(), this.fillStyle = _, this.strokeStyle = T, this.font = B, this.lineCap = H, this.lineWidth = Y, this.lineJoin = nt;
  }, V = function(_, T, B) {
    for (var H = 0; H < _.length; H++) switch (_[H].type) {
      case "bct":
        _[H].x2 += T, _[H].y2 += B;
      case "qct":
        _[H].x1 += T, _[H].y1 += B;
      default:
        _[H].x += T, _[H].y += B;
    }
    return _;
  }, G = function(_) {
    return _.sort(function(T, B) {
      return T - B;
    });
  }, D = function(_, T) {
    for (var B, H, Y = this.fillStyle, nt = this.strokeStyle, ot = this.lineCap, at = this.lineWidth, vt = Math.abs(at * this.ctx.transform.scaleX), xt = this.lineJoin, kt = JSON.parse(JSON.stringify(this.path)), Pt = JSON.parse(JSON.stringify(this.path)), ut = [], R = 0; R < Pt.length; R++) if (Pt[R].x !== void 0) for (var pe = M.call(this, Pt[R]), oe = 0; oe < pe.length; oe += 1) ut.indexOf(pe[oe]) === -1 && ut.push(pe[oe]);
    for (var Ht = 0; Ht < ut.length; Ht++) for (; this.pdf.internal.getNumberOfPages() < ut[Ht]; ) k.call(this);
    if (G(ut), this.autoPaging) for (var At = ut[0], Dt = ut[ut.length - 1], St = At; St < Dt + 1; St++) {
      this.pdf.setPage(St), this.fillStyle = Y, this.strokeStyle = nt, this.lineCap = ot, this.lineWidth = vt, this.lineJoin = xt;
      var se = this.pdf.internal.pageSize.width - this.margin[3] - this.margin[1], zt = St === 1 ? this.posY + this.margin[0] : this.margin[0], _e = this.pdf.internal.pageSize.height - this.posY - this.margin[0] - this.margin[2], ee = this.pdf.internal.pageSize.height - this.margin[0] - this.margin[2], ne = St === 1 ? 0 : _e + (St - 2) * ee;
      if (this.ctx.clip_path.length !== 0) {
        var Ee = this.path;
        B = JSON.parse(JSON.stringify(this.ctx.clip_path)), this.path = V(B, this.posX + this.margin[3], -ne + zt + this.ctx.prevPageLastElemOffset), it.call(this, _, true), this.path = Ee;
      }
      if (H = JSON.parse(JSON.stringify(kt)), this.path = V(H, this.posX + this.margin[3], -ne + zt + this.ctx.prevPageLastElemOffset), T === false || St === 0) {
        var le = (St > At || St < Dt) && P.call(this);
        le && (this.pdf.saveGraphicsState(), this.pdf.rect(this.margin[3], this.margin[0], se, ee, null).clip().discardPath()), it.call(this, _, T), le && this.pdf.restoreGraphicsState();
      }
      this.lineWidth = at;
    }
    else this.lineWidth = vt, it.call(this, _, T), this.lineWidth = at;
    this.path = kt;
  }, it = function(_, T) {
    if ((_ !== "stroke" || T || !O.call(this)) && (_ === "stroke" || T || !g.call(this))) {
      for (var B, H, Y = [], nt = this.path, ot = 0; ot < nt.length; ot++) {
        var at = nt[ot];
        switch (at.type) {
          case "begin":
            Y.push({ begin: true });
            break;
          case "close":
            Y.push({ close: true });
            break;
          case "mt":
            Y.push({ start: at, deltas: [], abs: [] });
            break;
          case "lt":
            var vt = Y.length;
            if (nt[ot - 1] && !isNaN(nt[ot - 1].x) && (B = [at.x - nt[ot - 1].x, at.y - nt[ot - 1].y], vt > 0)) {
              for (; vt >= 0; vt--) if (Y[vt - 1].close !== true && Y[vt - 1].begin !== true) {
                Y[vt - 1].deltas.push(B), Y[vt - 1].abs.push(at);
                break;
              }
            }
            break;
          case "bct":
            B = [at.x1 - nt[ot - 1].x, at.y1 - nt[ot - 1].y, at.x2 - nt[ot - 1].x, at.y2 - nt[ot - 1].y, at.x - nt[ot - 1].x, at.y - nt[ot - 1].y], Y[Y.length - 1].deltas.push(B);
            break;
          case "qct":
            var xt = nt[ot - 1].x + 2 / 3 * (at.x1 - nt[ot - 1].x), kt = nt[ot - 1].y + 2 / 3 * (at.y1 - nt[ot - 1].y), Pt = at.x + 2 / 3 * (at.x1 - at.x), ut = at.y + 2 / 3 * (at.y1 - at.y), R = at.x, pe = at.y;
            B = [xt - nt[ot - 1].x, kt - nt[ot - 1].y, Pt - nt[ot - 1].x, ut - nt[ot - 1].y, R - nt[ot - 1].x, pe - nt[ot - 1].y], Y[Y.length - 1].deltas.push(B);
            break;
          case "arc":
            Y.push({ deltas: [], abs: [], arc: true }), Array.isArray(Y[Y.length - 1].abs) && Y[Y.length - 1].abs.push(at);
        }
      }
      H = T ? null : _ === "stroke" ? "stroke" : "fill";
      for (var oe = false, Ht = 0; Ht < Y.length; Ht++) if (Y[Ht].arc) for (var At = Y[Ht].abs, Dt = 0; Dt < At.length; Dt++) {
        var St = At[Dt];
        St.type === "arc" ? $.call(this, St.x, St.y, St.radius, St.startAngle, St.endAngle, St.counterclockwise, void 0, T, !oe) : z.call(this, St.x, St.y), oe = true;
      }
      else if (Y[Ht].close === true) this.pdf.internal.out("h"), oe = false;
      else if (Y[Ht].begin !== true) {
        var se = Y[Ht].start.x, zt = Y[Ht].start.y;
        q.call(this, Y[Ht].deltas, se, zt), oe = true;
      }
      H && j.call(this, H), T && J.call(this);
    }
  }, bt = function(_) {
    var T = this.pdf.internal.getFontSize() / this.pdf.internal.scaleFactor, B = T * (this.pdf.internal.getLineHeightFactor() - 1);
    switch (this.ctx.textBaseline) {
      case "bottom":
        return _ - B;
      case "top":
        return _ + T - B;
      case "hanging":
        return _ + T - 2 * B;
      case "middle":
        return _ + T / 2 - B;
      default:
        return _;
    }
  }, dt = function(_) {
    return _ + this.pdf.internal.getFontSize() / this.pdf.internal.scaleFactor * (this.pdf.internal.getLineHeightFactor() - 1);
  };
  x.prototype.createLinearGradient = function() {
    var _ = function() {
    };
    return _.colorStops = [], _.addColorStop = function(T, B) {
      this.colorStops.push([T, B]);
    }, _.getColor = function() {
      return this.colorStops.length === 0 ? "#000000" : this.colorStops[0][1];
    }, _.isCanvasGradient = true, _;
  }, x.prototype.createPattern = function() {
    return this.createLinearGradient();
  }, x.prototype.createRadialGradient = function() {
    return this.createLinearGradient();
  };
  var $ = function(_, T, B, H, Y, nt, ot, at, vt) {
    for (var xt = st.call(this, B, H, Y, nt), kt = 0; kt < xt.length; kt++) {
      var Pt = xt[kt];
      kt === 0 && (vt ? N.call(this, Pt.x1 + _, Pt.y1 + T) : z.call(this, Pt.x1 + _, Pt.y1 + T)), rt.call(this, _, T, Pt.x2, Pt.y2, Pt.x3, Pt.y3, Pt.x4, Pt.y4);
    }
    at ? J.call(this) : j.call(this, ot);
  }, j = function(_) {
    switch (_) {
      case "stroke":
        this.pdf.internal.out("S");
        break;
      case "fill":
        this.pdf.internal.out("f");
    }
  }, J = function() {
    this.pdf.clip(), this.pdf.discardPath();
  }, N = function(_, T) {
    this.pdf.internal.out(e(_) + " " + r(T) + " m");
  }, C = function(_) {
    var T;
    switch (_.align) {
      case "right":
      case "end":
        T = "right";
        break;
      case "center":
        T = "center";
        break;
      default:
        T = "left";
    }
    var B = this.pdf.getTextDimensions(_.text), H = bt.call(this, _.y), Y = dt.call(this, H) - B.h, nt = this.ctx.transform.applyToPoint(new u(_.x, H)), ot = this.ctx.transform.decompose(), at = new f();
    at = (at = (at = at.multiply(ot.translate)).multiply(ot.skew)).multiply(ot.scale);
    for (var vt, xt, kt, Pt = this.ctx.transform.applyToRectangle(new l(_.x, H, B.w, B.h)), ut = at.applyToRectangle(new l(_.x, Y, B.w, B.h)), R = M.call(this, ut), pe = [], oe = 0; oe < R.length; oe += 1) pe.indexOf(R[oe]) === -1 && pe.push(R[oe]);
    if (G(pe), this.autoPaging) for (var Ht = pe[0], At = pe[pe.length - 1], Dt = Ht; Dt < At + 1; Dt++) {
      this.pdf.setPage(Dt);
      var St = Dt === 1 ? this.posY + this.margin[0] : this.margin[0], se = this.pdf.internal.pageSize.height - this.posY - this.margin[0] - this.margin[2], zt = this.pdf.internal.pageSize.height - this.margin[2], _e = zt - this.margin[0], ee = this.pdf.internal.pageSize.width - this.margin[1], ne = ee - this.margin[3], Ee = Dt === 1 ? 0 : se + (Dt - 2) * _e;
      if (this.ctx.clip_path.length !== 0) {
        var le = this.path;
        vt = JSON.parse(JSON.stringify(this.ctx.clip_path)), this.path = V(vt, this.posX + this.margin[3], -1 * Ee + St), it.call(this, "fill", true), this.path = le;
      }
      var qt = V([JSON.parse(JSON.stringify(ut))], this.posX + this.margin[3], -Ee + St + this.ctx.prevPageLastElemOffset)[0];
      _.scale >= 0.01 && (xt = this.pdf.internal.getFontSize(), this.pdf.setFontSize(xt * _.scale), kt = this.lineWidth, this.lineWidth = kt * _.scale);
      var Yt = this.autoPaging !== "text";
      if (Yt || qt.y + qt.h <= zt) {
        if (Yt || qt.y >= St && qt.x <= ee) {
          var Ut = Yt ? _.text : this.pdf.splitTextToSize(_.text, _.maxWidth || ee - qt.x)[0], Me = V([JSON.parse(JSON.stringify(Pt))], this.posX + this.margin[3], -Ee + St + this.ctx.prevPageLastElemOffset)[0], ye = Yt && (Dt > Ht || Dt < At) && P.call(this);
          ye && (this.pdf.saveGraphicsState(), this.pdf.rect(this.margin[3], this.margin[0], ne, _e, null).clip().discardPath()), this.pdf.text(Ut, Me.x, Me.y, { angle: _.angle, align: T, renderingMode: _.renderingMode }), ye && this.pdf.restoreGraphicsState();
        }
      } else qt.y < zt && (this.ctx.prevPageLastElemOffset += zt - qt.y);
      _.scale >= 0.01 && (this.pdf.setFontSize(xt), this.lineWidth = kt);
    }
    else _.scale >= 0.01 && (xt = this.pdf.internal.getFontSize(), this.pdf.setFontSize(xt * _.scale), kt = this.lineWidth, this.lineWidth = kt * _.scale), this.pdf.text(_.text, nt.x + this.posX, nt.y + this.posY, { angle: _.angle, align: T, renderingMode: _.renderingMode, maxWidth: _.maxWidth }), _.scale >= 0.01 && (this.pdf.setFontSize(xt), this.lineWidth = kt);
  }, z = function(_, T, B, H) {
    B = B || 0, H = H || 0, this.pdf.internal.out(e(_ + B) + " " + r(T + H) + " l");
  }, q = function(_, T, B) {
    return this.pdf.lines(_, T, B, null, null);
  }, rt = function(_, T, B, H, Y, nt, ot, at) {
    this.pdf.internal.out([n(i(B + _)), n(o(H + T)), n(i(Y + _)), n(o(nt + T)), n(i(ot + _)), n(o(at + T)), "c"].join(" "));
  }, st = function(_, T, B, H) {
    for (var Y = 2 * Math.PI, nt = Math.PI / 2; T > B; ) T -= Y;
    var ot = Math.abs(B - T);
    ot < Y && H && (ot = Y - ot);
    for (var at = [], vt = H ? -1 : 1, xt = T; ot > 1e-5; ) {
      var kt = xt + vt * Math.min(ot, nt);
      at.push(ht.call(this, _, xt, kt)), ot -= Math.abs(kt - xt), xt = kt;
    }
    return at;
  }, ht = function(_, T, B) {
    var H = (B - T) / 2, Y = _ * Math.cos(H), nt = _ * Math.sin(H), ot = Y, at = -nt, vt = ot * ot + at * at, xt = vt + ot * Y + at * nt, kt = 4 / 3 * (Math.sqrt(2 * vt * xt) - xt) / (ot * nt - at * Y), Pt = ot - kt * at, ut = at + kt * ot, R = Pt, pe = -ut, oe = H + T, Ht = Math.cos(oe), At = Math.sin(oe);
    return { x1: _ * Math.cos(T), y1: _ * Math.sin(T), x2: Pt * Ht - ut * At, y2: Pt * At + ut * Ht, x3: R * Ht - pe * At, y3: R * At + pe * Ht, x4: _ * Math.cos(B), y4: _ * Math.sin(B) };
  }, tt = function(_) {
    return 180 * _ / Math.PI;
  }, ft = function(_, T, B, H, Y, nt) {
    var ot = _ + 0.5 * (B - _), at = T + 0.5 * (H - T), vt = Y + 0.5 * (B - Y), xt = nt + 0.5 * (H - nt), kt = Math.min(_, Y, ot, vt), Pt = Math.max(_, Y, ot, vt), ut = Math.min(T, nt, at, xt), R = Math.max(T, nt, at, xt);
    return new l(kt, ut, Pt - kt, R - ut);
  }, Lt = function(_, T, B, H, Y, nt, ot, at) {
    var vt, xt, kt, Pt, ut, R, pe, oe, Ht, At, Dt, St, se, zt, _e = B - _, ee = H - T, ne = Y - B, Ee = nt - H, le = ot - Y, qt = at - nt;
    for (xt = 0; xt < 41; xt++) Ht = (pe = (kt = _ + (vt = xt / 40) * _e) + vt * ((ut = B + vt * ne) - kt)) + vt * (ut + vt * (Y + vt * le - ut) - pe), At = (oe = (Pt = T + vt * ee) + vt * ((R = H + vt * Ee) - Pt)) + vt * (R + vt * (nt + vt * qt - R) - oe), xt == 0 ? (Dt = Ht, St = At, se = Ht, zt = At) : (Dt = Math.min(Dt, Ht), St = Math.min(St, At), se = Math.max(se, Ht), zt = Math.max(zt, At));
    return new l(Math.round(Dt), Math.round(St), Math.round(se - Dt), Math.round(zt - St));
  }, lt = function() {
    if (this.prevLineDash || this.ctx.lineDash.length || this.ctx.lineDashOffset) {
      var _, T, B = (_ = this.ctx.lineDash, T = this.ctx.lineDashOffset, JSON.stringify({ lineDash: _, lineDashOffset: T }));
      this.prevLineDash !== B && (this.pdf.setLineDash(this.ctx.lineDash, this.ctx.lineDashOffset), this.prevLineDash = B);
    }
  };
})(jt.API), (function(t3) {
  var n = function(u) {
    var l, f, c, p, x, L, g, O, P, M;
    for (f = [], c = 0, p = (u += l = "\0\0\0\0".slice(u.length % 4 || 4)).length; p > c; c += 4) (x = (u.charCodeAt(c) << 24) + (u.charCodeAt(c + 1) << 16) + (u.charCodeAt(c + 2) << 8) + u.charCodeAt(c + 3)) !== 0 ? (L = (x = ((x = ((x = ((x = (x - (M = x % 85)) / 85) - (P = x % 85)) / 85) - (O = x % 85)) / 85) - (g = x % 85)) / 85) % 85, f.push(L + 33, g + 33, O + 33, P + 33, M + 33)) : f.push(122);
    return (function(k, V) {
      for (var G = V; G > 0; G--) k.pop();
    })(f, l.length), String.fromCharCode.apply(String, f) + "~>";
  }, e = function(u) {
    var l, f, c, p, x, L = String, g = "length", O = 255, P = "charCodeAt", M = "slice", k = "replace";
    for (u[M](-2), u = u[M](0, -2)[k](/\s/g, "")[k]("z", "!!!!!"), c = [], p = 0, x = (u += l = "uuuuu"[M](u[g] % 5 || 5))[g]; x > p; p += 5) f = 52200625 * (u[P](p) - 33) + 614125 * (u[P](p + 1) - 33) + 7225 * (u[P](p + 2) - 33) + 85 * (u[P](p + 3) - 33) + (u[P](p + 4) - 33), c.push(O & f >> 24, O & f >> 16, O & f >> 8, O & f);
    return (function(V, G) {
      for (var D = G; D > 0; D--) V.pop();
    })(c, l[g]), L.fromCharCode.apply(L, c);
  }, r = function(u) {
    return u.split("").map(function(l) {
      return ("0" + l.charCodeAt().toString(16)).slice(-2);
    }).join("") + ">";
  }, i = function(u) {
    var l = new RegExp(/^([0-9A-Fa-f]{2})+$/);
    if ((u = u.replace(/\s/g, "")).indexOf(">") !== -1 && (u = u.substr(0, u.indexOf(">"))), u.length % 2 && (u += "0"), l.test(u) === false) return "";
    for (var f = "", c = 0; c < u.length; c += 2) f += String.fromCharCode("0x" + (u[c] + u[c + 1]));
    return f;
  }, o = function(u) {
    for (var l = new Uint8Array(u.length), f = u.length; f--; ) l[f] = u.charCodeAt(f);
    return (l = Xl(l)).reduce(function(c, p) {
      return c + String.fromCharCode(p);
    }, "");
  };
  t3.processDataByFilters = function(u, l) {
    var f = 0, c = u || "", p = [];
    for (typeof (l = l || []) == "string" && (l = [l]), f = 0; f < l.length; f += 1) switch (l[f]) {
      case "ASCII85Decode":
      case "/ASCII85Decode":
        c = e(c), p.push("/ASCII85Encode");
        break;
      case "ASCII85Encode":
      case "/ASCII85Encode":
        c = n(c), p.push("/ASCII85Decode");
        break;
      case "ASCIIHexDecode":
      case "/ASCIIHexDecode":
        c = i(c), p.push("/ASCIIHexEncode");
        break;
      case "ASCIIHexEncode":
      case "/ASCIIHexEncode":
        c = r(c), p.push("/ASCIIHexDecode");
        break;
      case "FlateEncode":
      case "/FlateEncode":
        c = o(c), p.push("/FlateDecode");
        break;
      default:
        throw new Error('The filter: "' + l[f] + '" is not implemented');
    }
    return { data: c, reverseChain: p.reverse().join(" ") };
  };
})(jt.API), (function(t3) {
  t3.loadFile = function(n, e, r) {
    return (function(i, o, u) {
      o = o !== false, u = typeof u == "function" ? u : function() {
      };
      var l = void 0;
      try {
        l = (function(f, c, p) {
          var x = new XMLHttpRequest(), L = 0, g = function(O) {
            var P = O.length, M = [], k = String.fromCharCode;
            for (L = 0; L < P; L += 1) M.push(k(255 & O.charCodeAt(L)));
            return M.join("");
          };
          if (x.open("GET", f, !c), x.overrideMimeType("text/plain; charset=x-user-defined"), c === false && (x.onload = function() {
            x.status === 200 ? p(g(this.responseText)) : p(void 0);
          }), x.send(null), c && x.status === 200) return g(x.responseText);
        })(i, o, u);
      } catch {
      }
      return l;
    })(n, e, r);
  }, t3.loadImageFile = t3.loadFile;
})(jt.API), (function(t3) {
  function n() {
    return ($t.html2canvas ? Promise.resolve($t.html2canvas) : vl(() => import("../../../../../../modules/html2canvas.esm-e0a7d97b.js"), [])).catch(function(l) {
      return Promise.reject(new Error("Could not load html2canvas: " + l));
    }).then(function(l) {
      return l.default ? l.default : l;
    });
  }
  function e() {
    return ($t.DOMPurify ? Promise.resolve($t.DOMPurify) : vl(() => import("../../../../../../modules/purify.es-fd086bfc.js"), [])).catch(function(l) {
      return Promise.reject(new Error("Could not load dompurify: " + l));
    }).then(function(l) {
      return l.default ? l.default : l;
    });
  }
  var r = function(l) {
    var f = Ce(l);
    return f === "undefined" ? "undefined" : f === "string" || l instanceof String ? "string" : f === "number" || l instanceof Number ? "number" : f === "function" || l instanceof Function ? "function" : l && l.constructor === Array ? "array" : l && l.nodeType === 1 ? "element" : f === "object" ? "object" : "unknown";
  }, i = function(l, f) {
    var c = document.createElement(l);
    for (var p in f.className && (c.className = f.className), f.innerHTML && f.dompurify && (c.innerHTML = f.dompurify.sanitize(f.innerHTML)), f.style) c.style[p] = f.style[p];
    return c;
  }, o = function l(f, c) {
    for (var p = f.nodeType === 3 ? document.createTextNode(f.nodeValue) : f.cloneNode(false), x = f.firstChild; x; x = x.nextSibling) c !== true && x.nodeType === 1 && x.nodeName === "SCRIPT" || p.appendChild(l(x, c));
    return f.nodeType === 1 && (f.nodeName === "CANVAS" ? (p.width = f.width, p.height = f.height, p.getContext("2d").drawImage(f, 0, 0)) : f.nodeName !== "TEXTAREA" && f.nodeName !== "SELECT" || (p.value = f.value), p.addEventListener("load", function() {
      p.scrollTop = f.scrollTop, p.scrollLeft = f.scrollLeft;
    }, true)), p;
  }, u = function l(f) {
    var c = Object.assign(l.convert(Promise.resolve()), JSON.parse(JSON.stringify(l.template))), p = l.convert(Promise.resolve(), c);
    return (p = p.setProgress(1, l, 1, [l])).set(f);
  };
  (u.prototype = Object.create(Promise.prototype)).constructor = u, u.convert = function(l, f) {
    return l.__proto__ = f || u.prototype, l;
  }, u.template = { prop: { src: null, container: null, overlay: null, canvas: null, img: null, pdf: null, pageSize: null, callback: function() {
  } }, progress: { val: 0, state: null, n: 0, stack: [] }, opt: { filename: "file.pdf", margin: [0, 0, 0, 0], enableLinks: true, x: 0, y: 0, html2canvas: {}, jsPDF: {}, backgroundColor: "transparent" } }, u.prototype.from = function(l, f) {
    return this.then(function() {
      switch (f = f || (function(c) {
        switch (r(c)) {
          case "string":
            return "string";
          case "element":
            return c.nodeName.toLowerCase() === "canvas" ? "canvas" : "element";
          default:
            return "unknown";
        }
      })(l), f) {
        case "string":
          return this.then(e).then(function(c) {
            return this.set({ src: i("div", { innerHTML: l, dompurify: c }) });
          });
        case "element":
          return this.set({ src: l });
        case "canvas":
          return this.set({ canvas: l });
        case "img":
          return this.set({ img: l });
        default:
          return this.error("Unknown source type.");
      }
    });
  }, u.prototype.to = function(l) {
    switch (l) {
      case "container":
        return this.toContainer();
      case "canvas":
        return this.toCanvas();
      case "img":
        return this.toImg();
      case "pdf":
        return this.toPdf();
      default:
        return this.error("Invalid target.");
    }
  }, u.prototype.toContainer = function() {
    return this.thenList([function() {
      return this.prop.src || this.error("Cannot duplicate - no source HTML.");
    }, function() {
      return this.prop.pageSize || this.setPageSize();
    }]).then(function() {
      var l = { position: "relative", display: "inline-block", width: (typeof this.opt.width != "number" || isNaN(this.opt.width) || typeof this.opt.windowWidth != "number" || isNaN(this.opt.windowWidth) ? Math.max(this.prop.src.clientWidth, this.prop.src.scrollWidth, this.prop.src.offsetWidth) : this.opt.windowWidth) + "px", left: 0, right: 0, top: 0, margin: "auto", backgroundColor: this.opt.backgroundColor }, f = o(this.prop.src, this.opt.html2canvas.javascriptEnabled);
      f.tagName === "BODY" && (l.height = Math.max(document.body.scrollHeight, document.body.offsetHeight, document.documentElement.clientHeight, document.documentElement.scrollHeight, document.documentElement.offsetHeight) + "px"), this.prop.overlay = i("div", { className: "html2pdf__overlay", style: { position: "fixed", overflow: "hidden", zIndex: 1e3, left: "-100000px", right: 0, bottom: 0, top: 0 } }), this.prop.container = i("div", { className: "html2pdf__container", style: l }), this.prop.container.appendChild(f), this.prop.container.firstChild.appendChild(i("div", { style: { clear: "both", border: "0 none transparent", margin: 0, padding: 0, height: 0 } })), this.prop.container.style.float = "none", this.prop.overlay.appendChild(this.prop.container), document.body.appendChild(this.prop.overlay), this.prop.container.firstChild.style.position = "relative", this.prop.container.height = Math.max(this.prop.container.firstChild.clientHeight, this.prop.container.firstChild.scrollHeight, this.prop.container.firstChild.offsetHeight) + "px";
    });
  }, u.prototype.toCanvas = function() {
    var l = [function() {
      return document.body.contains(this.prop.container) || this.toContainer();
    }];
    return this.thenList(l).then(n).then(function(f) {
      var c = Object.assign({}, this.opt.html2canvas);
      return delete c.onrendered, f(this.prop.container, c);
    }).then(function(f) {
      (this.opt.html2canvas.onrendered || function() {
      })(f), this.prop.canvas = f, document.body.removeChild(this.prop.overlay);
    });
  }, u.prototype.toContext2d = function() {
    var l = [function() {
      return document.body.contains(this.prop.container) || this.toContainer();
    }];
    return this.thenList(l).then(n).then(function(f) {
      var c = this.opt.jsPDF, p = this.opt.fontFaces, x = typeof this.opt.width != "number" || isNaN(this.opt.width) || typeof this.opt.windowWidth != "number" || isNaN(this.opt.windowWidth) ? 1 : this.opt.width / this.opt.windowWidth, L = Object.assign({ async: true, allowTaint: true, scale: x, scrollX: this.opt.scrollX || 0, scrollY: this.opt.scrollY || 0, backgroundColor: "#ffffff", imageTimeout: 15e3, logging: true, proxy: null, removeContainer: true, foreignObjectRendering: false, useCORS: false }, this.opt.html2canvas);
      if (delete L.onrendered, c.context2d.autoPaging = this.opt.autoPaging === void 0 || this.opt.autoPaging, c.context2d.posX = this.opt.x, c.context2d.posY = this.opt.y, c.context2d.margin = this.opt.margin, c.context2d.fontFaces = p, p) for (var g = 0; g < p.length; ++g) {
        var O = p[g], P = O.src.find(function(M) {
          return M.format === "truetype";
        });
        P && c.addFont(P.url, O.ref.name, O.ref.style);
      }
      return L.windowHeight = L.windowHeight || 0, L.windowHeight = L.windowHeight == 0 ? Math.max(this.prop.container.clientHeight, this.prop.container.scrollHeight, this.prop.container.offsetHeight) : L.windowHeight, c.context2d.save(true), f(this.prop.container, L);
    }).then(function(f) {
      this.opt.jsPDF.context2d.restore(true), (this.opt.html2canvas.onrendered || function() {
      })(f), this.prop.canvas = f, document.body.removeChild(this.prop.overlay);
    });
  }, u.prototype.toImg = function() {
    return this.thenList([function() {
      return this.prop.canvas || this.toCanvas();
    }]).then(function() {
      var l = this.prop.canvas.toDataURL("image/" + this.opt.image.type, this.opt.image.quality);
      this.prop.img = document.createElement("img"), this.prop.img.src = l;
    });
  }, u.prototype.toPdf = function() {
    return this.thenList([function() {
      return this.toContext2d();
    }]).then(function() {
      this.prop.pdf = this.prop.pdf || this.opt.jsPDF;
    });
  }, u.prototype.output = function(l, f, c) {
    return (c = c || "pdf").toLowerCase() === "img" || c.toLowerCase() === "image" ? this.outputImg(l, f) : this.outputPdf(l, f);
  }, u.prototype.outputPdf = function(l, f) {
    return this.thenList([function() {
      return this.prop.pdf || this.toPdf();
    }]).then(function() {
      return this.prop.pdf.output(l, f);
    });
  }, u.prototype.outputImg = function(l) {
    return this.thenList([function() {
      return this.prop.img || this.toImg();
    }]).then(function() {
      switch (l) {
        case void 0:
        case "img":
          return this.prop.img;
        case "datauristring":
        case "dataurlstring":
          return this.prop.img.src;
        case "datauri":
        case "dataurl":
          return document.location.href = this.prop.img.src;
        default:
          throw 'Image output type "' + l + '" is not supported.';
      }
    });
  }, u.prototype.save = function(l) {
    return this.thenList([function() {
      return this.prop.pdf || this.toPdf();
    }]).set(l ? { filename: l } : null).then(function() {
      this.prop.pdf.save(this.opt.filename);
    });
  }, u.prototype.doCallback = function() {
    return this.thenList([function() {
      return this.prop.pdf || this.toPdf();
    }]).then(function() {
      this.prop.callback(this.prop.pdf);
    });
  }, u.prototype.set = function(l) {
    if (r(l) !== "object") return this;
    var f = Object.keys(l || {}).map(function(c) {
      if (c in u.template.prop) return function() {
        this.prop[c] = l[c];
      };
      switch (c) {
        case "margin":
          return this.setMargin.bind(this, l.margin);
        case "jsPDF":
          return function() {
            return this.opt.jsPDF = l.jsPDF, this.setPageSize();
          };
        case "pageSize":
          return this.setPageSize.bind(this, l.pageSize);
        default:
          return function() {
            this.opt[c] = l[c];
          };
      }
    }, this);
    return this.then(function() {
      return this.thenList(f);
    });
  }, u.prototype.get = function(l, f) {
    return this.then(function() {
      var c = l in u.template.prop ? this.prop[l] : this.opt[l];
      return f ? f(c) : c;
    });
  }, u.prototype.setMargin = function(l) {
    return this.then(function() {
      switch (r(l)) {
        case "number":
          l = [l, l, l, l];
        case "array":
          if (l.length === 2 && (l = [l[0], l[1], l[0], l[1]]), l.length === 4) break;
        default:
          return this.error("Invalid margin array.");
      }
      this.opt.margin = l;
    }).then(this.setPageSize);
  }, u.prototype.setPageSize = function(l) {
    function f(c, p) {
      return Math.floor(c * p / 72 * 96);
    }
    return this.then(function() {
      (l = l || jt.getPageSize(this.opt.jsPDF)).hasOwnProperty("inner") || (l.inner = { width: l.width - this.opt.margin[1] - this.opt.margin[3], height: l.height - this.opt.margin[0] - this.opt.margin[2] }, l.inner.px = { width: f(l.inner.width, l.k), height: f(l.inner.height, l.k) }, l.inner.ratio = l.inner.height / l.inner.width), this.prop.pageSize = l;
    });
  }, u.prototype.setProgress = function(l, f, c, p) {
    return l != null && (this.progress.val = l), f != null && (this.progress.state = f), c != null && (this.progress.n = c), p != null && (this.progress.stack = p), this.progress.ratio = this.progress.val / this.progress.state, this;
  }, u.prototype.updateProgress = function(l, f, c, p) {
    return this.setProgress(l ? this.progress.val + l : null, f || null, c ? this.progress.n + c : null, p ? this.progress.stack.concat(p) : null);
  }, u.prototype.then = function(l, f) {
    var c = this;
    return this.thenCore(l, f, function(p, x) {
      return c.updateProgress(null, null, 1, [p]), Promise.prototype.then.call(this, function(L) {
        return c.updateProgress(null, p), L;
      }).then(p, x).then(function(L) {
        return c.updateProgress(1), L;
      });
    });
  }, u.prototype.thenCore = function(l, f, c) {
    c = c || Promise.prototype.then;
    var p = this;
    l && (l = l.bind(p)), f && (f = f.bind(p));
    var x = Promise.toString().indexOf("[native code]") !== -1 && Promise.name === "Promise" ? p : u.convert(Object.assign({}, p), Promise.prototype), L = c.call(x, l, f);
    return u.convert(L, p.__proto__);
  }, u.prototype.thenExternal = function(l, f) {
    return Promise.prototype.then.call(this, l, f);
  }, u.prototype.thenList = function(l) {
    var f = this;
    return l.forEach(function(c) {
      f = f.thenCore(c);
    }), f;
  }, u.prototype.catch = function(l) {
    l && (l = l.bind(this));
    var f = Promise.prototype.catch.call(this, l);
    return u.convert(f, this);
  }, u.prototype.catchExternal = function(l) {
    return Promise.prototype.catch.call(this, l);
  }, u.prototype.error = function(l) {
    return this.then(function() {
      throw new Error(l);
    });
  }, u.prototype.using = u.prototype.set, u.prototype.saveAs = u.prototype.save, u.prototype.export = u.prototype.output, u.prototype.run = u.prototype.then, jt.getPageSize = function(l, f, c) {
    if (Ce(l) === "object") {
      var p = l;
      l = p.orientation, f = p.unit || f, c = p.format || c;
    }
    f = f || "mm", c = c || "a4", l = ("" + (l || "P")).toLowerCase();
    var x, L = ("" + c).toLowerCase(), g = { a0: [2383.94, 3370.39], a1: [1683.78, 2383.94], a2: [1190.55, 1683.78], a3: [841.89, 1190.55], a4: [595.28, 841.89], a5: [419.53, 595.28], a6: [297.64, 419.53], a7: [209.76, 297.64], a8: [147.4, 209.76], a9: [104.88, 147.4], a10: [73.7, 104.88], b0: [2834.65, 4008.19], b1: [2004.09, 2834.65], b2: [1417.32, 2004.09], b3: [1000.63, 1417.32], b4: [708.66, 1000.63], b5: [498.9, 708.66], b6: [354.33, 498.9], b7: [249.45, 354.33], b8: [175.75, 249.45], b9: [124.72, 175.75], b10: [87.87, 124.72], c0: [2599.37, 3676.54], c1: [1836.85, 2599.37], c2: [1298.27, 1836.85], c3: [918.43, 1298.27], c4: [649.13, 918.43], c5: [459.21, 649.13], c6: [323.15, 459.21], c7: [229.61, 323.15], c8: [161.57, 229.61], c9: [113.39, 161.57], c10: [79.37, 113.39], dl: [311.81, 623.62], letter: [612, 792], "government-letter": [576, 756], legal: [612, 1008], "junior-legal": [576, 360], ledger: [1224, 792], tabloid: [792, 1224], "credit-card": [153, 243] };
    switch (f) {
      case "pt":
        x = 1;
        break;
      case "mm":
        x = 72 / 25.4;
        break;
      case "cm":
        x = 72 / 2.54;
        break;
      case "in":
        x = 72;
        break;
      case "px":
        x = 0.75;
        break;
      case "pc":
      case "em":
        x = 12;
        break;
      case "ex":
        x = 6;
        break;
      default:
        throw "Invalid unit: " + f;
    }
    var O, P = 0, M = 0;
    if (g.hasOwnProperty(L)) P = g[L][1] / x, M = g[L][0] / x;
    else try {
      P = c[1], M = c[0];
    } catch {
      throw new Error("Invalid format: " + c);
    }
    if (l === "p" || l === "portrait") l = "p", M > P && (O = M, M = P, P = O);
    else {
      if (l !== "l" && l !== "landscape") throw "Invalid orientation: " + l;
      l = "l", P > M && (O = M, M = P, P = O);
    }
    return { width: M, height: P, unit: f, k: x, orientation: l };
  }, t3.html = function(l, f) {
    (f = f || {}).callback = f.callback || function() {
    }, f.html2canvas = f.html2canvas || {}, f.html2canvas.canvas = f.html2canvas.canvas || this.canvas, f.jsPDF = f.jsPDF || this, f.fontFaces = f.fontFaces ? f.fontFaces.map(Wl) : null;
    var c = new u(f);
    return f.worker ? c : c.from(l).doCallback();
  };
})(jt.API), jt.API.addJS = function(t3) {
  return yc = t3, this.internal.events.subscribe("postPutResources", function() {
    _s = this.internal.newObject(), this.internal.out("<<"), this.internal.out("/Names [(EmbeddedJS) " + (_s + 1) + " 0 R]"), this.internal.out(">>"), this.internal.out("endobj"), _c = this.internal.newObject(), this.internal.out("<<"), this.internal.out("/S /JavaScript"), this.internal.out("/JS (" + yc + ")"), this.internal.out(">>"), this.internal.out("endobj");
  }), this.internal.events.subscribe("putCatalog", function() {
    _s !== void 0 && _c !== void 0 && this.internal.out("/Names <</JavaScript " + _s + " 0 R>>");
  }), this;
}, (function(t3) {
  var n;
  t3.events.push(["postPutResources", function() {
    var e = this, r = /^(\d+) 0 obj$/;
    if (this.outline.root.children.length > 0) for (var i = e.outline.render().split(/\r\n/), o = 0; o < i.length; o++) {
      var u = i[o], l = r.exec(u);
      if (l != null) {
        var f = l[1];
        e.internal.newObjectDeferredBegin(f, false);
      }
      e.internal.write(u);
    }
    if (this.outline.createNamedDestinations) {
      var c = this.internal.pages.length, p = [];
      for (o = 0; o < c; o++) {
        var x = e.internal.newObject();
        p.push(x);
        var L = e.internal.getPageInfo(o + 1);
        e.internal.write("<< /D[" + L.objId + " 0 R /XYZ null null null]>> endobj");
      }
      var g = e.internal.newObject();
      for (e.internal.write("<< /Names [ "), o = 0; o < p.length; o++) e.internal.write("(page_" + (o + 1) + ")" + p[o] + " 0 R");
      e.internal.write(" ] >>", "endobj"), n = e.internal.newObject(), e.internal.write("<< /Dests " + g + " 0 R"), e.internal.write(">>", "endobj");
    }
  }]), t3.events.push(["putCatalog", function() {
    var e = this;
    e.outline.root.children.length > 0 && (e.internal.write("/Outlines", this.outline.makeRef(this.outline.root)), this.outline.createNamedDestinations && e.internal.write("/Names " + n + " 0 R"));
  }]), t3.events.push(["initialized", function() {
    var e = this;
    e.outline = { createNamedDestinations: false, root: { children: [] } }, e.outline.add = function(r, i, o) {
      var u = { title: i, options: o, children: [] };
      return r == null && (r = this.root), r.children.push(u), u;
    }, e.outline.render = function() {
      return this.ctx = {}, this.ctx.val = "", this.ctx.pdf = e, this.genIds_r(this.root), this.renderRoot(this.root), this.renderItems(this.root), this.ctx.val;
    }, e.outline.genIds_r = function(r) {
      r.id = e.internal.newObjectDeferred();
      for (var i = 0; i < r.children.length; i++) this.genIds_r(r.children[i]);
    }, e.outline.renderRoot = function(r) {
      this.objStart(r), this.line("/Type /Outlines"), r.children.length > 0 && (this.line("/First " + this.makeRef(r.children[0])), this.line("/Last " + this.makeRef(r.children[r.children.length - 1]))), this.line("/Count " + this.count_r({ count: 0 }, r)), this.objEnd();
    }, e.outline.renderItems = function(r) {
      for (var i = this.ctx.pdf.internal.getVerticalCoordinateString, o = 0; o < r.children.length; o++) {
        var u = r.children[o];
        this.objStart(u), this.line("/Title " + this.makeString(u.title)), this.line("/Parent " + this.makeRef(r)), o > 0 && this.line("/Prev " + this.makeRef(r.children[o - 1])), o < r.children.length - 1 && this.line("/Next " + this.makeRef(r.children[o + 1])), u.children.length > 0 && (this.line("/First " + this.makeRef(u.children[0])), this.line("/Last " + this.makeRef(u.children[u.children.length - 1])));
        var l = this.count = this.count_r({ count: 0 }, u);
        if (l > 0 && this.line("/Count " + l), u.options && u.options.pageNumber) {
          var f = e.internal.getPageInfo(u.options.pageNumber);
          this.line("/Dest [" + f.objId + " 0 R /XYZ 0 " + i(0) + " 0]");
        }
        this.objEnd();
      }
      for (var c = 0; c < r.children.length; c++) this.renderItems(r.children[c]);
    }, e.outline.line = function(r) {
      this.ctx.val += r + `\r
`;
    }, e.outline.makeRef = function(r) {
      return r.id + " 0 R";
    }, e.outline.makeString = function(r) {
      return "(" + e.internal.pdfEscape(r) + ")";
    }, e.outline.objStart = function(r) {
      this.ctx.val += `\r
` + r.id + ` 0 obj\r
<<\r
`;
    }, e.outline.objEnd = function() {
      this.ctx.val += `>> \r
endobj\r
`;
    }, e.outline.count_r = function(r, i) {
      for (var o = 0; o < i.children.length; o++) r.count++, this.count_r(r, i.children[o]);
      return r.count;
    };
  }]);
})(jt.API), (function(t3) {
  var n = [192, 193, 194, 195, 196, 197, 198, 199];
  t3.processJPEG = function(e, r, i, o, u, l) {
    var f, c = this.decode.DCT_DECODE, p = null;
    if (typeof e == "string" || this.__addimage__.isArrayBuffer(e) || this.__addimage__.isArrayBufferView(e)) {
      switch (e = u || e, e = this.__addimage__.isArrayBuffer(e) ? new Uint8Array(e) : e, f = (function(x) {
        for (var L, g = 256 * x.charCodeAt(4) + x.charCodeAt(5), O = x.length, P = { width: 0, height: 0, numcomponents: 1 }, M = 4; M < O; M += 2) {
          if (M += g, n.indexOf(x.charCodeAt(M + 1)) !== -1) {
            L = 256 * x.charCodeAt(M + 5) + x.charCodeAt(M + 6), P = { width: 256 * x.charCodeAt(M + 7) + x.charCodeAt(M + 8), height: L, numcomponents: x.charCodeAt(M + 9) };
            break;
          }
          g = 256 * x.charCodeAt(M + 2) + x.charCodeAt(M + 3);
        }
        return P;
      })(e = this.__addimage__.isArrayBufferView(e) ? this.__addimage__.arrayBufferToBinaryString(e) : e), f.numcomponents) {
        case 1:
          l = this.color_spaces.DEVICE_GRAY;
          break;
        case 4:
          l = this.color_spaces.DEVICE_CMYK;
          break;
        case 3:
          l = this.color_spaces.DEVICE_RGB;
      }
      p = { data: e, width: f.width, height: f.height, colorSpace: l, bitsPerComponent: 8, filter: c, index: r, alias: i };
    }
    return p;
  };
})(jt.API), jt.API.processPNG = function(t3, n, e, r) {
  if (this.__addimage__.isArrayBuffer(t3) && (t3 = new Uint8Array(t3)), this.__addimage__.isArrayBufferView(t3)) {
    var i, o = K5(t3, { checkCrc: true }), u = o.width, l = o.height, f = o.channels, c = o.palette, p = o.depth;
    i = c && f === 1 ? (function($) {
      for (var j = $.width, J = $.height, N = $.data, C = $.palette, z = $.depth, q = false, rt = [], st = [], ht = void 0, tt = false, ft = 0, Lt = 0; Lt < C.length; Lt++) {
        var lt = gu(C[Lt], 4), _ = lt[0], T = lt[1], B = lt[2], H = lt[3];
        rt.push(_, T, B), H != null && (H === 0 ? (ft++, st.length < 1 && st.push(Lt)) : H < 255 && (tt = true));
      }
      if (tt || ft > 1) {
        q = true, st = void 0;
        var Y = j * J;
        ht = new Uint8Array(Y);
        for (var nt = new DataView(N.buffer), ot = 0; ot < Y; ot++) {
          var at = Gl(nt, ot, z), vt = gu(C[at], 4)[3];
          ht[ot] = vt;
        }
      } else ft === 0 && (st = void 0);
      return { colorSpace: "Indexed", colorsPerPixel: 1, sMaskBitsPerComponent: q ? 8 : void 0, colorBytes: N, alphaBytes: ht, needSMask: q, palette: rt, mask: st };
    })(o) : f === 2 || f === 4 ? (function($) {
      for (var j = $.data, J = $.width, N = $.height, C = $.channels, z = $.depth, q = C === 2 ? "DeviceGray" : "DeviceRGB", rt = C - 1, st = J * N, ht = rt, tt = st * ht, ft = 1 * st, Lt = Math.ceil(tt * z / 8), lt = Math.ceil(ft * z / 8), _ = new Uint8Array(Lt), T = new Uint8Array(lt), B = new DataView(j.buffer), H = new DataView(_.buffer), Y = new DataView(T.buffer), nt = false, ot = 0; ot < st; ot++) {
        for (var at = ot * C, vt = 0; vt < ht; vt++) Ec(H, Gl(B, at + vt, z), ot * ht + vt, z);
        var xt = Gl(B, at + ht, z);
        xt < (1 << z) - 1 && (nt = true), Ec(Y, xt, 1 * ot, z);
      }
      return { colorSpace: q, colorsPerPixel: rt, sMaskBitsPerComponent: nt ? z : void 0, colorBytes: _, alphaBytes: T, needSMask: nt };
    })(o) : (function($) {
      var j = $.data, J = $.channels === 1 ? "DeviceGray" : "DeviceRGB";
      return { colorSpace: J, colorsPerPixel: J === "DeviceGray" ? 1 : 3, colorBytes: j instanceof Uint16Array ? (function(N) {
        for (var C = N.length, z = new Uint8Array(2 * C), q = new DataView(z.buffer, z.byteOffset, z.byteLength), rt = 0; rt < C; rt++) q.setUint16(2 * rt, N[rt], false);
        return z;
      })(j) : j, needSMask: false };
    })(o);
    var x, L, g, O = i, P = O.colorSpace, M = O.colorsPerPixel, k = O.sMaskBitsPerComponent, V = O.colorBytes, G = O.alphaBytes, D = O.needSMask, it = O.palette, bt = O.mask, dt = null;
    return r !== jt.API.image_compression.NONE && typeof Xl == "function" ? (dt = (function($) {
      var j;
      switch ($) {
        case jt.API.image_compression.FAST:
          j = 11;
          break;
        case jt.API.image_compression.MEDIUM:
          j = 13;
          break;
        case jt.API.image_compression.SLOW:
          j = 14;
          break;
        default:
          j = 12;
      }
      return j;
    })(r), x = this.decode.FLATE_DECODE, L = "/Predictor ".concat(dt, " /Colors ").concat(M, " /BitsPerComponent ").concat(p, " /Columns ").concat(u), t3 = Nc(V, Math.ceil(u * M * p / 8), M, p, r), D && (g = Nc(G, Math.ceil(u * k / 8), 1, k, r))) : (x = void 0, L = void 0, t3 = V, D && (g = G)), (this.__addimage__.isArrayBuffer(t3) || this.__addimage__.isArrayBufferView(t3)) && (t3 = this.__addimage__.arrayBufferToBinaryString(t3)), (g && this.__addimage__.isArrayBuffer(g) || this.__addimage__.isArrayBufferView(g)) && (g = this.__addimage__.arrayBufferToBinaryString(g)), { alias: e, data: t3, index: n, filter: x, decodeParameters: L, transparency: bt, palette: it, sMask: g, predictor: dt, width: u, height: l, bitsPerComponent: p, sMaskBitsPerComponent: k, colorSpace: P };
  }
}, (function(t3) {
  t3.processGIF89A = function(n, e, r, i) {
    var o = new vd(n), u = o.width, l = o.height, f = [];
    o.decodeAndBlitFrameRGBA(0, f);
    var c = { data: f, width: u, height: l }, p = new Zl(100).encode(c, 100);
    return t3.processJPEG.call(this, p, e, r, i);
  }, t3.processGIF87A = t3.processGIF89A;
})(jt.API), pr.prototype.parseHeader = function() {
  if (this.fileSize = this.datav.getUint32(this.pos, true), this.pos += 4, this.reserved = this.datav.getUint32(this.pos, true), this.pos += 4, this.offset = this.datav.getUint32(this.pos, true), this.pos += 4, this.headerSize = this.datav.getUint32(this.pos, true), this.pos += 4, this.width = this.datav.getUint32(this.pos, true), this.pos += 4, this.height = this.datav.getInt32(this.pos, true), this.pos += 4, this.planes = this.datav.getUint16(this.pos, true), this.pos += 2, this.bitPP = this.datav.getUint16(this.pos, true), this.pos += 2, this.compress = this.datav.getUint32(this.pos, true), this.pos += 4, this.rawSize = this.datav.getUint32(this.pos, true), this.pos += 4, this.hr = this.datav.getUint32(this.pos, true), this.pos += 4, this.vr = this.datav.getUint32(this.pos, true), this.pos += 4, this.colors = this.datav.getUint32(this.pos, true), this.pos += 4, this.importantColors = this.datav.getUint32(this.pos, true), this.pos += 4, this.bitPP === 16 && this.is_with_alpha && (this.bitPP = 15), this.bitPP < 15) {
    var t3 = this.colors === 0 ? 1 << this.bitPP : this.colors;
    this.palette = new Array(t3);
    for (var n = 0; n < t3; n++) {
      var e = this.datav.getUint8(this.pos++, true), r = this.datav.getUint8(this.pos++, true), i = this.datav.getUint8(this.pos++, true), o = this.datav.getUint8(this.pos++, true);
      this.palette[n] = { red: i, green: r, blue: e, quad: o };
    }
  }
  this.height < 0 && (this.height *= -1, this.bottom_up = false);
}, pr.prototype.parseBGR = function() {
  this.pos = this.offset;
  try {
    var t3 = "bit" + this.bitPP, n = this.width * this.height * 4;
    this.data = new Uint8Array(n), this[t3]();
  } catch (e) {
    Re.log("bit decode error:" + e);
  }
}, pr.prototype.bit1 = function() {
  var t3, n = Math.ceil(this.width / 8), e = n % 4;
  for (t3 = this.height - 1; t3 >= 0; t3--) {
    for (var r = this.bottom_up ? t3 : this.height - 1 - t3, i = 0; i < n; i++) for (var o = this.datav.getUint8(this.pos++, true), u = r * this.width * 4 + 8 * i * 4, l = 0; l < 8 && 8 * i + l < this.width; l++) {
      var f = this.palette[o >> 7 - l & 1];
      this.data[u + 4 * l] = f.blue, this.data[u + 4 * l + 1] = f.green, this.data[u + 4 * l + 2] = f.red, this.data[u + 4 * l + 3] = 255;
    }
    e !== 0 && (this.pos += 4 - e);
  }
}, pr.prototype.bit4 = function() {
  for (var t3 = Math.ceil(this.width / 2), n = t3 % 4, e = this.height - 1; e >= 0; e--) {
    for (var r = this.bottom_up ? e : this.height - 1 - e, i = 0; i < t3; i++) {
      var o = this.datav.getUint8(this.pos++, true), u = r * this.width * 4 + 2 * i * 4, l = o >> 4, f = 15 & o, c = this.palette[l];
      if (this.data[u] = c.blue, this.data[u + 1] = c.green, this.data[u + 2] = c.red, this.data[u + 3] = 255, 2 * i + 1 >= this.width) break;
      c = this.palette[f], this.data[u + 4] = c.blue, this.data[u + 4 + 1] = c.green, this.data[u + 4 + 2] = c.red, this.data[u + 4 + 3] = 255;
    }
    n !== 0 && (this.pos += 4 - n);
  }
}, pr.prototype.bit8 = function() {
  for (var t3 = this.width % 4, n = this.height - 1; n >= 0; n--) {
    for (var e = this.bottom_up ? n : this.height - 1 - n, r = 0; r < this.width; r++) {
      var i = this.datav.getUint8(this.pos++, true), o = e * this.width * 4 + 4 * r;
      if (i < this.palette.length) {
        var u = this.palette[i];
        this.data[o] = u.red, this.data[o + 1] = u.green, this.data[o + 2] = u.blue, this.data[o + 3] = 255;
      } else this.data[o] = 255, this.data[o + 1] = 255, this.data[o + 2] = 255, this.data[o + 3] = 255;
    }
    t3 !== 0 && (this.pos += 4 - t3);
  }
}, pr.prototype.bit15 = function() {
  for (var t3 = this.width % 3, n = parseInt("11111", 2), e = this.height - 1; e >= 0; e--) {
    for (var r = this.bottom_up ? e : this.height - 1 - e, i = 0; i < this.width; i++) {
      var o = this.datav.getUint16(this.pos, true);
      this.pos += 2;
      var u = (o & n) / n * 255 | 0, l = (o >> 5 & n) / n * 255 | 0, f = (o >> 10 & n) / n * 255 | 0, c = o >> 15 ? 255 : 0, p = r * this.width * 4 + 4 * i;
      this.data[p] = f, this.data[p + 1] = l, this.data[p + 2] = u, this.data[p + 3] = c;
    }
    this.pos += t3;
  }
}, pr.prototype.bit16 = function() {
  for (var t3 = this.width % 3, n = parseInt("11111", 2), e = parseInt("111111", 2), r = this.height - 1; r >= 0; r--) {
    for (var i = this.bottom_up ? r : this.height - 1 - r, o = 0; o < this.width; o++) {
      var u = this.datav.getUint16(this.pos, true);
      this.pos += 2;
      var l = (u & n) / n * 255 | 0, f = (u >> 5 & e) / e * 255 | 0, c = (u >> 11) / n * 255 | 0, p = i * this.width * 4 + 4 * o;
      this.data[p] = c, this.data[p + 1] = f, this.data[p + 2] = l, this.data[p + 3] = 255;
    }
    this.pos += t3;
  }
}, pr.prototype.bit24 = function() {
  for (var t3 = this.height - 1; t3 >= 0; t3--) {
    for (var n = this.bottom_up ? t3 : this.height - 1 - t3, e = 0; e < this.width; e++) {
      var r = this.datav.getUint8(this.pos++, true), i = this.datav.getUint8(this.pos++, true), o = this.datav.getUint8(this.pos++, true), u = n * this.width * 4 + 4 * e;
      this.data[u] = o, this.data[u + 1] = i, this.data[u + 2] = r, this.data[u + 3] = 255;
    }
    this.pos += this.width % 4;
  }
}, pr.prototype.bit32 = function() {
  for (var t3 = this.height - 1; t3 >= 0; t3--) for (var n = this.bottom_up ? t3 : this.height - 1 - t3, e = 0; e < this.width; e++) {
    var r = this.datav.getUint8(this.pos++, true), i = this.datav.getUint8(this.pos++, true), o = this.datav.getUint8(this.pos++, true), u = this.datav.getUint8(this.pos++, true), l = n * this.width * 4 + 4 * e;
    this.data[l] = o, this.data[l + 1] = i, this.data[l + 2] = r, this.data[l + 3] = u;
  }
}, pr.prototype.getData = function() {
  return this.data;
}, (function(t3) {
  t3.processBMP = function(n, e, r, i) {
    var o = new pr(n, false), u = o.width, l = o.height, f = { data: o.getData(), width: u, height: l }, c = new Zl(100).encode(f, 100);
    return t3.processJPEG.call(this, c, e, r, i);
  };
})(jt.API), Fc.prototype.getData = function() {
  return this.data;
}, (function(t3) {
  t3.processWEBP = function(n, e, r, i) {
    var o = new Fc(n), u = o.width, l = o.height, f = { data: o.getData(), width: u, height: l }, c = new Zl(100).encode(f, 100);
    return t3.processJPEG.call(this, c, e, r, i);
  };
})(jt.API), jt.API.processRGBA = function(t3, n, e) {
  for (var r = t3.data, i = r.length, o = new Uint8Array(i / 4 * 3), u = new Uint8Array(i / 4), l = 0, f = 0, c = 0; c < i; c += 4) {
    var p = r[c], x = r[c + 1], L = r[c + 2], g = r[c + 3];
    o[l++] = p, o[l++] = x, o[l++] = L, u[f++] = g;
  }
  var O = this.__addimage__.arrayBufferToBinaryString(o);
  return { alpha: this.__addimage__.arrayBufferToBinaryString(u), data: O, index: n, alias: e, colorSpace: "DeviceRGB", bitsPerComponent: 8, width: t3.width, height: t3.height };
}, jt.API.setLanguage = function(t3) {
  return this.internal.languageSettings === void 0 && (this.internal.languageSettings = {}, this.internal.languageSettings.isSubscribed = false), { af: "Afrikaans", sq: "Albanian", ar: "Arabic (Standard)", "ar-DZ": "Arabic (Algeria)", "ar-BH": "Arabic (Bahrain)", "ar-EG": "Arabic (Egypt)", "ar-IQ": "Arabic (Iraq)", "ar-JO": "Arabic (Jordan)", "ar-KW": "Arabic (Kuwait)", "ar-LB": "Arabic (Lebanon)", "ar-LY": "Arabic (Libya)", "ar-MA": "Arabic (Morocco)", "ar-OM": "Arabic (Oman)", "ar-QA": "Arabic (Qatar)", "ar-SA": "Arabic (Saudi Arabia)", "ar-SY": "Arabic (Syria)", "ar-TN": "Arabic (Tunisia)", "ar-AE": "Arabic (U.A.E.)", "ar-YE": "Arabic (Yemen)", an: "Aragonese", hy: "Armenian", as: "Assamese", ast: "Asturian", az: "Azerbaijani", eu: "Basque", be: "Belarusian", bn: "Bengali", bs: "Bosnian", br: "Breton", bg: "Bulgarian", my: "Burmese", ca: "Catalan", ch: "Chamorro", ce: "Chechen", zh: "Chinese", "zh-HK": "Chinese (Hong Kong)", "zh-CN": "Chinese (PRC)", "zh-SG": "Chinese (Singapore)", "zh-TW": "Chinese (Taiwan)", cv: "Chuvash", co: "Corsican", cr: "Cree", hr: "Croatian", cs: "Czech", da: "Danish", nl: "Dutch (Standard)", "nl-BE": "Dutch (Belgian)", en: "English", "en-AU": "English (Australia)", "en-BZ": "English (Belize)", "en-CA": "English (Canada)", "en-IE": "English (Ireland)", "en-JM": "English (Jamaica)", "en-NZ": "English (New Zealand)", "en-PH": "English (Philippines)", "en-ZA": "English (South Africa)", "en-TT": "English (Trinidad & Tobago)", "en-GB": "English (United Kingdom)", "en-US": "English (United States)", "en-ZW": "English (Zimbabwe)", eo: "Esperanto", et: "Estonian", fo: "Faeroese", fj: "Fijian", fi: "Finnish", fr: "French (Standard)", "fr-BE": "French (Belgium)", "fr-CA": "French (Canada)", "fr-FR": "French (France)", "fr-LU": "French (Luxembourg)", "fr-MC": "French (Monaco)", "fr-CH": "French (Switzerland)", fy: "Frisian", fur: "Friulian", gd: "Gaelic (Scots)", "gd-IE": "Gaelic (Irish)", gl: "Galacian", ka: "Georgian", de: "German (Standard)", "de-AT": "German (Austria)", "de-DE": "German (Germany)", "de-LI": "German (Liechtenstein)", "de-LU": "German (Luxembourg)", "de-CH": "German (Switzerland)", el: "Greek", gu: "Gujurati", ht: "Haitian", he: "Hebrew", hi: "Hindi", hu: "Hungarian", is: "Icelandic", id: "Indonesian", iu: "Inuktitut", ga: "Irish", it: "Italian (Standard)", "it-CH": "Italian (Switzerland)", ja: "Japanese", kn: "Kannada", ks: "Kashmiri", kk: "Kazakh", km: "Khmer", ky: "Kirghiz", tlh: "Klingon", ko: "Korean", "ko-KP": "Korean (North Korea)", "ko-KR": "Korean (South Korea)", la: "Latin", lv: "Latvian", lt: "Lithuanian", lb: "Luxembourgish", mk: "North Macedonia", ms: "Malay", ml: "Malayalam", mt: "Maltese", mi: "Maori", mr: "Marathi", mo: "Moldavian", nv: "Navajo", ng: "Ndonga", ne: "Nepali", no: "Norwegian", nb: "Norwegian (Bokmal)", nn: "Norwegian (Nynorsk)", oc: "Occitan", or: "Oriya", om: "Oromo", fa: "Persian", "fa-IR": "Persian/Iran", pl: "Polish", pt: "Portuguese", "pt-BR": "Portuguese (Brazil)", pa: "Punjabi", "pa-IN": "Punjabi (India)", "pa-PK": "Punjabi (Pakistan)", qu: "Quechua", rm: "Rhaeto-Romanic", ro: "Romanian", "ro-MO": "Romanian (Moldavia)", ru: "Russian", "ru-MO": "Russian (Moldavia)", sz: "Sami (Lappish)", sg: "Sango", sa: "Sanskrit", sc: "Sardinian", sd: "Sindhi", si: "Singhalese", sr: "Serbian", sk: "Slovak", sl: "Slovenian", so: "Somani", sb: "Sorbian", es: "Spanish", "es-AR": "Spanish (Argentina)", "es-BO": "Spanish (Bolivia)", "es-CL": "Spanish (Chile)", "es-CO": "Spanish (Colombia)", "es-CR": "Spanish (Costa Rica)", "es-DO": "Spanish (Dominican Republic)", "es-EC": "Spanish (Ecuador)", "es-SV": "Spanish (El Salvador)", "es-GT": "Spanish (Guatemala)", "es-HN": "Spanish (Honduras)", "es-MX": "Spanish (Mexico)", "es-NI": "Spanish (Nicaragua)", "es-PA": "Spanish (Panama)", "es-PY": "Spanish (Paraguay)", "es-PE": "Spanish (Peru)", "es-PR": "Spanish (Puerto Rico)", "es-ES": "Spanish (Spain)", "es-UY": "Spanish (Uruguay)", "es-VE": "Spanish (Venezuela)", sx: "Sutu", sw: "Swahili", sv: "Swedish", "sv-FI": "Swedish (Finland)", "sv-SV": "Swedish (Sweden)", ta: "Tamil", tt: "Tatar", te: "Teluga", th: "Thai", tig: "Tigre", ts: "Tsonga", tn: "Tswana", tr: "Turkish", tk: "Turkmen", uk: "Ukrainian", hsb: "Upper Sorbian", ur: "Urdu", ve: "Venda", vi: "Vietnamese", vo: "Volapuk", wa: "Walloon", cy: "Welsh", xh: "Xhosa", ji: "Yiddish", zu: "Zulu" }[t3] !== void 0 && (this.internal.languageSettings.languageCode = t3, this.internal.languageSettings.isSubscribed === false && (this.internal.events.subscribe("putCatalog", function() {
    this.internal.write("/Lang (" + this.internal.languageSettings.languageCode + ")");
  }), this.internal.languageSettings.isSubscribed = true)), this;
}, wa = jt.API, ys = wa.getCharWidthsArray = function(t3, n) {
  var e, r, i = (n = n || {}).font || this.internal.getFont(), o = n.fontSize || this.internal.getFontSize(), u = n.charSpace || this.internal.getCharSpace(), l = n.widths ? n.widths : i.metadata.Unicode.widths, f = l.fof ? l.fof : 1, c = n.kerning ? n.kerning : i.metadata.Unicode.kerning, p = c.fof ? c.fof : 1, x = n.doKerning !== false, L = 0, g = t3.length, O = 0, P = l[0] || f, M = [];
  for (e = 0; e < g; e++) r = t3.charCodeAt(e), typeof i.metadata.widthOfString == "function" ? M.push((i.metadata.widthOfGlyph(i.metadata.characterToGlyph(r)) + u * (1e3 / o) || 0) / 1e3) : (L = x && Ce(c[r]) === "object" && !isNaN(parseInt(c[r][O], 10)) ? c[r][O] / p : 0, M.push((l[r] || P) / f + L)), O = r;
  return M;
}, xc = wa.getStringUnitWidth = function(t3, n) {
  var e = (n = n || {}).fontSize || this.internal.getFontSize(), r = n.font || this.internal.getFont(), i = n.charSpace || this.internal.getCharSpace();
  return wa.processArabic && (t3 = wa.processArabic(t3)), typeof r.metadata.widthOfString == "function" ? r.metadata.widthOfString(t3, e, i) / e : ys.apply(this, arguments).reduce(function(o, u) {
    return o + u;
  }, 0);
}, Ac = function(t3, n, e, r) {
  for (var i = [], o = 0, u = t3.length, l = 0; o !== u && l + n[o] < e; ) l += n[o], o++;
  i.push(t3.slice(0, o));
  var f = o;
  for (l = 0; o !== u; ) l + n[o] > r && (i.push(t3.slice(f, o)), l = 0, f = o), l += n[o], o++;
  return f !== o && i.push(t3.slice(f, o)), i;
}, Lc = function(t3, n, e) {
  e || (e = {});
  var r, i, o, u, l, f, c, p = [], x = [p], L = e.textIndent || 0, g = 0, O = 0, P = t3.split(" "), M = ys.apply(this, [" ", e])[0];
  if (f = e.lineIndent === -1 ? P[0].length + 2 : e.lineIndent || 0) {
    var k = Array(f).join(" "), V = [];
    P.map(function(D) {
      (D = D.split(/\s*\n/)).length > 1 ? V = V.concat(D.map(function(it, bt) {
        return (bt && it.length ? `
` : "") + it;
      })) : V.push(D[0]);
    }), P = V, f = xc.apply(this, [k, e]);
  }
  for (o = 0, u = P.length; o < u; o++) {
    var G = 0;
    if (r = P[o], f && r[0] == `
` && (r = r.substr(1), G = 1), L + g + (O = (i = ys.apply(this, [r, e])).reduce(function(D, it) {
      return D + it;
    }, 0)) > n || G) {
      if (O > n) {
        for (l = Ac.apply(this, [r, i, n - (L + g), n]), p.push(l.shift()), p = [l.pop()]; l.length; ) x.push([l.shift()]);
        O = i.slice(r.length - (p[0] ? p[0].length : 0)).reduce(function(D, it) {
          return D + it;
        }, 0);
      } else p = [r];
      x.push(p), L = O + f, g = M;
    } else p.push(r), L += g + O, g = M;
  }
  return c = f ? function(D, it) {
    return (it ? k : "") + D.join(" ");
  } : function(D) {
    return D.join(" ");
  }, x.map(c);
}, wa.splitTextToSize = function(t3, n, e) {
  var r, i = (e = e || {}).fontSize || this.internal.getFontSize(), o = (function(p) {
    if (p.widths && p.kerning) return { widths: p.widths, kerning: p.kerning };
    var x = this.internal.getFont(p.fontName, p.fontStyle), L = "Unicode";
    return x.metadata[L] ? { widths: x.metadata[L].widths || { 0: 1 }, kerning: x.metadata[L].kerning || {} } : { font: x.metadata, fontSize: this.internal.getFontSize(), charSpace: this.internal.getCharSpace() };
  }).call(this, e);
  r = Array.isArray(t3) ? t3 : String(t3).split(/\r?\n/);
  var u = 1 * this.internal.scaleFactor * n / i;
  o.textIndent = e.textIndent ? 1 * e.textIndent * this.internal.scaleFactor / i : 0, o.lineIndent = e.lineIndent;
  var l, f, c = [];
  for (l = 0, f = r.length; l < f; l++) c = c.concat(Lc.apply(this, [r[l], u, o]));
  return c;
}, (function(t3) {
  t3.__fontmetrics__ = t3.__fontmetrics__ || {};
  for (var n = "0123456789abcdef", e = "klmnopqrstuvwxyz", r = {}, i = {}, o = 0; o < 16; o++) r[e[o]] = n[o], i[n[o]] = e[o];
  var u = function(L) {
    return "0x" + parseInt(L, 10).toString(16);
  }, l = t3.__fontmetrics__.compress = function(L) {
    var g, O, P, M, k = ["{"];
    for (var V in L) {
      if (g = L[V], isNaN(parseInt(V, 10)) ? O = "'" + V + "'" : (V = parseInt(V, 10), O = (O = u(V).slice(2)).slice(0, -1) + i[O.slice(-1)]), typeof g == "number") g < 0 ? (P = u(g).slice(3), M = "-") : (P = u(g).slice(2), M = ""), P = M + P.slice(0, -1) + i[P.slice(-1)];
      else {
        if (Ce(g) !== "object") throw new Error("Don't know what to do with value type " + Ce(g) + ".");
        P = l(g);
      }
      k.push(O + P);
    }
    return k.push("}"), k.join("");
  }, f = t3.__fontmetrics__.uncompress = function(L) {
    if (typeof L != "string") throw new Error("Invalid argument passed to uncompress.");
    for (var g, O, P, M, k = {}, V = 1, G = k, D = [], it = "", bt = "", dt = L.length - 1, $ = 1; $ < dt; $ += 1) (M = L[$]) == "'" ? g ? (P = g.join(""), g = void 0) : g = [] : g ? g.push(M) : M == "{" ? (D.push([G, P]), G = {}, P = void 0) : M == "}" ? ((O = D.pop())[0][O[1]] = G, P = void 0, G = O[0]) : M == "-" ? V = -1 : P === void 0 ? r.hasOwnProperty(M) ? (it += r[M], P = parseInt(it, 16) * V, V = 1, it = "") : it += M : r.hasOwnProperty(M) ? (bt += r[M], G[P] = parseInt(bt, 16) * V, V = 1, P = void 0, bt = "") : bt += M;
    return k;
  }, c = { codePages: ["WinAnsiEncoding"], WinAnsiEncoding: f("{19m8n201n9q201o9r201s9l201t9m201u8m201w9n201x9o201y8o202k8q202l8r202m9p202q8p20aw8k203k8t203t8v203u9v2cq8s212m9t15m8w15n9w2dw9s16k8u16l9u17s9z17x8y17y9y}") }, p = { Unicode: { Courier: c, "Courier-Bold": c, "Courier-BoldOblique": c, "Courier-Oblique": c, Helvetica: c, "Helvetica-Bold": c, "Helvetica-BoldOblique": c, "Helvetica-Oblique": c, "Times-Roman": c, "Times-Bold": c, "Times-BoldItalic": c, "Times-Italic": c } }, x = { Unicode: { "Courier-Oblique": f("{'widths'{k3w'fof'6o}'kerning'{'fof'-6o}}"), "Times-BoldItalic": f("{'widths'{k3o2q4ycx2r201n3m201o6o201s2l201t2l201u2l201w3m201x3m201y3m2k1t2l2r202m2n2n3m2o3m2p5n202q6o2r1w2s2l2t2l2u3m2v3t2w1t2x2l2y1t2z1w3k3m3l3m3m3m3n3m3o3m3p3m3q3m3r3m3s3m203t2l203u2l3v2l3w3t3x3t3y3t3z3m4k5n4l4m4m4m4n4m4o4s4p4m4q4m4r4s4s4y4t2r4u3m4v4m4w3x4x5t4y4s4z4s5k3x5l4s5m4m5n3r5o3x5p4s5q4m5r5t5s4m5t3x5u3x5v2l5w1w5x2l5y3t5z3m6k2l6l3m6m3m6n2w6o3m6p2w6q2l6r3m6s3r6t1w6u1w6v3m6w1w6x4y6y3r6z3m7k3m7l3m7m2r7n2r7o1w7p3r7q2w7r4m7s3m7t2w7u2r7v2n7w1q7x2n7y3t202l3mcl4mal2ram3man3mao3map3mar3mas2lat4uau1uav3maw3way4uaz2lbk2sbl3t'fof'6obo2lbp3tbq3mbr1tbs2lbu1ybv3mbz3mck4m202k3mcm4mcn4mco4mcp4mcq5ycr4mcs4mct4mcu4mcv4mcw2r2m3rcy2rcz2rdl4sdm4sdn4sdo4sdp4sdq4sds4sdt4sdu4sdv4sdw4sdz3mek3mel3mem3men3meo3mep3meq4ser2wes2wet2weu2wev2wew1wex1wey1wez1wfl3rfm3mfn3mfo3mfp3mfq3mfr3tfs3mft3rfu3rfv3rfw3rfz2w203k6o212m6o2dw2l2cq2l3t3m3u2l17s3x19m3m}'kerning'{cl{4qu5kt5qt5rs17ss5ts}201s{201ss}201t{cks4lscmscnscoscpscls2wu2yu201ts}201x{2wu2yu}2k{201ts}2w{4qx5kx5ou5qx5rs17su5tu}2x{17su5tu5ou}2y{4qx5kx5ou5qx5rs17ss5ts}'fof'-6ofn{17sw5tw5ou5qw5rs}7t{cksclscmscnscoscps4ls}3u{17su5tu5os5qs}3v{17su5tu5os5qs}7p{17su5tu}ck{4qu5kt5qt5rs17ss5ts}4l{4qu5kt5qt5rs17ss5ts}cm{4qu5kt5qt5rs17ss5ts}cn{4qu5kt5qt5rs17ss5ts}co{4qu5kt5qt5rs17ss5ts}cp{4qu5kt5qt5rs17ss5ts}6l{4qu5ou5qw5rt17su5tu}5q{ckuclucmucnucoucpu4lu}5r{ckuclucmucnucoucpu4lu}7q{cksclscmscnscoscps4ls}6p{4qu5ou5qw5rt17sw5tw}ek{4qu5ou5qw5rt17su5tu}el{4qu5ou5qw5rt17su5tu}em{4qu5ou5qw5rt17su5tu}en{4qu5ou5qw5rt17su5tu}eo{4qu5ou5qw5rt17su5tu}ep{4qu5ou5qw5rt17su5tu}es{17ss5ts5qs4qu}et{4qu5ou5qw5rt17sw5tw}eu{4qu5ou5qw5rt17ss5ts}ev{17ss5ts5qs4qu}6z{17sw5tw5ou5qw5rs}fm{17sw5tw5ou5qw5rs}7n{201ts}fo{17sw5tw5ou5qw5rs}fp{17sw5tw5ou5qw5rs}fq{17sw5tw5ou5qw5rs}7r{cksclscmscnscoscps4ls}fs{17sw5tw5ou5qw5rs}ft{17su5tu}fu{17su5tu}fv{17su5tu}fw{17su5tu}fz{cksclscmscnscoscps4ls}}}"), "Helvetica-Bold": f("{'widths'{k3s2q4scx1w201n3r201o6o201s1w201t1w201u1w201w3m201x3m201y3m2k1w2l2l202m2n2n3r2o3r2p5t202q6o2r1s2s2l2t2l2u2r2v3u2w1w2x2l2y1w2z1w3k3r3l3r3m3r3n3r3o3r3p3r3q3r3r3r3s3r203t2l203u2l3v2l3w3u3x3u3y3u3z3x4k6l4l4s4m4s4n4s4o4s4p4m4q3x4r4y4s4s4t1w4u3r4v4s4w3x4x5n4y4s4z4y5k4m5l4y5m4s5n4m5o3x5p4s5q4m5r5y5s4m5t4m5u3x5v2l5w1w5x2l5y3u5z3r6k2l6l3r6m3x6n3r6o3x6p3r6q2l6r3x6s3x6t1w6u1w6v3r6w1w6x5t6y3x6z3x7k3x7l3x7m2r7n3r7o2l7p3x7q3r7r4y7s3r7t3r7u3m7v2r7w1w7x2r7y3u202l3rcl4sal2lam3ran3rao3rap3rar3ras2lat4tau2pav3raw3uay4taz2lbk2sbl3u'fof'6obo2lbp3xbq3rbr1wbs2lbu2obv3rbz3xck4s202k3rcm4scn4sco4scp4scq6ocr4scs4mct4mcu4mcv4mcw1w2m2zcy1wcz1wdl4sdm4ydn4ydo4ydp4ydq4yds4ydt4sdu4sdv4sdw4sdz3xek3rel3rem3ren3reo3rep3req5ter3res3ret3reu3rev3rew1wex1wey1wez1wfl3xfm3xfn3xfo3xfp3xfq3xfr3ufs3xft3xfu3xfv3xfw3xfz3r203k6o212m6o2dw2l2cq2l3t3r3u2l17s4m19m3r}'kerning'{cl{4qs5ku5ot5qs17sv5tv}201t{2ww4wy2yw}201w{2ks}201x{2ww4wy2yw}2k{201ts201xs}2w{7qs4qu5kw5os5qw5rs17su5tu7tsfzs}2x{5ow5qs}2y{7qs4qu5kw5os5qw5rs17su5tu7tsfzs}'fof'-6o7p{17su5tu5ot}ck{4qs5ku5ot5qs17sv5tv}4l{4qs5ku5ot5qs17sv5tv}cm{4qs5ku5ot5qs17sv5tv}cn{4qs5ku5ot5qs17sv5tv}co{4qs5ku5ot5qs17sv5tv}cp{4qs5ku5ot5qs17sv5tv}6l{17st5tt5os}17s{2kwclvcmvcnvcovcpv4lv4wwckv}5o{2kucltcmtcntcotcpt4lt4wtckt}5q{2ksclscmscnscoscps4ls4wvcks}5r{2ks4ws}5t{2kwclvcmvcnvcovcpv4lv4wwckv}eo{17st5tt5os}fu{17su5tu5ot}6p{17ss5ts}ek{17st5tt5os}el{17st5tt5os}em{17st5tt5os}en{17st5tt5os}6o{201ts}ep{17st5tt5os}es{17ss5ts}et{17ss5ts}eu{17ss5ts}ev{17ss5ts}6z{17su5tu5os5qt}fm{17su5tu5os5qt}fn{17su5tu5os5qt}fo{17su5tu5os5qt}fp{17su5tu5os5qt}fq{17su5tu5os5qt}fs{17su5tu5os5qt}ft{17su5tu5ot}7m{5os}fv{17su5tu5ot}fw{17su5tu5ot}}}"), Courier: f("{'widths'{k3w'fof'6o}'kerning'{'fof'-6o}}"), "Courier-BoldOblique": f("{'widths'{k3w'fof'6o}'kerning'{'fof'-6o}}"), "Times-Bold": f("{'widths'{k3q2q5ncx2r201n3m201o6o201s2l201t2l201u2l201w3m201x3m201y3m2k1t2l2l202m2n2n3m2o3m2p6o202q6o2r1w2s2l2t2l2u3m2v3t2w1t2x2l2y1t2z1w3k3m3l3m3m3m3n3m3o3m3p3m3q3m3r3m3s3m203t2l203u2l3v2l3w3t3x3t3y3t3z3m4k5x4l4s4m4m4n4s4o4s4p4m4q3x4r4y4s4y4t2r4u3m4v4y4w4m4x5y4y4s4z4y5k3x5l4y5m4s5n3r5o4m5p4s5q4s5r6o5s4s5t4s5u4m5v2l5w1w5x2l5y3u5z3m6k2l6l3m6m3r6n2w6o3r6p2w6q2l6r3m6s3r6t1w6u2l6v3r6w1w6x5n6y3r6z3m7k3r7l3r7m2w7n2r7o2l7p3r7q3m7r4s7s3m7t3m7u2w7v2r7w1q7x2r7y3o202l3mcl4sal2lam3man3mao3map3mar3mas2lat4uau1yav3maw3tay4uaz2lbk2sbl3t'fof'6obo2lbp3rbr1tbs2lbu2lbv3mbz3mck4s202k3mcm4scn4sco4scp4scq6ocr4scs4mct4mcu4mcv4mcw2r2m3rcy2rcz2rdl4sdm4ydn4ydo4ydp4ydq4yds4ydt4sdu4sdv4sdw4sdz3rek3mel3mem3men3meo3mep3meq4ser2wes2wet2weu2wev2wew1wex1wey1wez1wfl3rfm3mfn3mfo3mfp3mfq3mfr3tfs3mft3rfu3rfv3rfw3rfz3m203k6o212m6o2dw2l2cq2l3t3m3u2l17s4s19m3m}'kerning'{cl{4qt5ks5ot5qy5rw17sv5tv}201t{cks4lscmscnscoscpscls4wv}2k{201ts}2w{4qu5ku7mu5os5qx5ru17su5tu}2x{17su5tu5ou5qs}2y{4qv5kv7mu5ot5qz5ru17su5tu}'fof'-6o7t{cksclscmscnscoscps4ls}3u{17su5tu5os5qu}3v{17su5tu5os5qu}fu{17su5tu5ou5qu}7p{17su5tu5ou5qu}ck{4qt5ks5ot5qy5rw17sv5tv}4l{4qt5ks5ot5qy5rw17sv5tv}cm{4qt5ks5ot5qy5rw17sv5tv}cn{4qt5ks5ot5qy5rw17sv5tv}co{4qt5ks5ot5qy5rw17sv5tv}cp{4qt5ks5ot5qy5rw17sv5tv}6l{17st5tt5ou5qu}17s{ckuclucmucnucoucpu4lu4wu}5o{ckuclucmucnucoucpu4lu4wu}5q{ckzclzcmzcnzcozcpz4lz4wu}5r{ckxclxcmxcnxcoxcpx4lx4wu}5t{ckuclucmucnucoucpu4lu4wu}7q{ckuclucmucnucoucpu4lu}6p{17sw5tw5ou5qu}ek{17st5tt5qu}el{17st5tt5ou5qu}em{17st5tt5qu}en{17st5tt5qu}eo{17st5tt5qu}ep{17st5tt5ou5qu}es{17ss5ts5qu}et{17sw5tw5ou5qu}eu{17sw5tw5ou5qu}ev{17ss5ts5qu}6z{17sw5tw5ou5qu5rs}fm{17sw5tw5ou5qu5rs}fn{17sw5tw5ou5qu5rs}fo{17sw5tw5ou5qu5rs}fp{17sw5tw5ou5qu5rs}fq{17sw5tw5ou5qu5rs}7r{cktcltcmtcntcotcpt4lt5os}fs{17sw5tw5ou5qu5rs}ft{17su5tu5ou5qu}7m{5os}fv{17su5tu5ou5qu}fw{17su5tu5ou5qu}fz{cksclscmscnscoscps4ls}}}"), Symbol: f("{'widths'{k3uaw4r19m3m2k1t2l2l202m2y2n3m2p5n202q6o3k3m2s2l2t2l2v3r2w1t3m3m2y1t2z1wbk2sbl3r'fof'6o3n3m3o3m3p3m3q3m3r3m3s3m3t3m3u1w3v1w3w3r3x3r3y3r3z2wbp3t3l3m5v2l5x2l5z3m2q4yfr3r7v3k7w1o7x3k}'kerning'{'fof'-6o}}"), Helvetica: f("{'widths'{k3p2q4mcx1w201n3r201o6o201s1q201t1q201u1q201w2l201x2l201y2l2k1w2l1w202m2n2n3r2o3r2p5t202q6o2r1n2s2l2t2l2u2r2v3u2w1w2x2l2y1w2z1w3k3r3l3r3m3r3n3r3o3r3p3r3q3r3r3r3s3r203t2l203u2l3v1w3w3u3x3u3y3u3z3r4k6p4l4m4m4m4n4s4o4s4p4m4q3x4r4y4s4s4t1w4u3m4v4m4w3r4x5n4y4s4z4y5k4m5l4y5m4s5n4m5o3x5p4s5q4m5r5y5s4m5t4m5u3x5v1w5w1w5x1w5y2z5z3r6k2l6l3r6m3r6n3m6o3r6p3r6q1w6r3r6s3r6t1q6u1q6v3m6w1q6x5n6y3r6z3r7k3r7l3r7m2l7n3m7o1w7p3r7q3m7r4s7s3m7t3m7u3m7v2l7w1u7x2l7y3u202l3rcl4mal2lam3ran3rao3rap3rar3ras2lat4tau2pav3raw3uay4taz2lbk2sbl3u'fof'6obo2lbp3rbr1wbs2lbu2obv3rbz3xck4m202k3rcm4mcn4mco4mcp4mcq6ocr4scs4mct4mcu4mcv4mcw1w2m2ncy1wcz1wdl4sdm4ydn4ydo4ydp4ydq4yds4ydt4sdu4sdv4sdw4sdz3xek3rel3rem3ren3reo3rep3req5ter3mes3ret3reu3rev3rew1wex1wey1wez1wfl3rfm3rfn3rfo3rfp3rfq3rfr3ufs3xft3rfu3rfv3rfw3rfz3m203k6o212m6o2dw2l2cq2l3t3r3u1w17s4m19m3r}'kerning'{5q{4wv}cl{4qs5kw5ow5qs17sv5tv}201t{2wu4w1k2yu}201x{2wu4wy2yu}17s{2ktclucmucnu4otcpu4lu4wycoucku}2w{7qs4qz5k1m17sy5ow5qx5rsfsu5ty7tufzu}2x{17sy5ty5oy5qs}2y{7qs4qz5k1m17sy5ow5qx5rsfsu5ty7tufzu}'fof'-6o7p{17sv5tv5ow}ck{4qs5kw5ow5qs17sv5tv}4l{4qs5kw5ow5qs17sv5tv}cm{4qs5kw5ow5qs17sv5tv}cn{4qs5kw5ow5qs17sv5tv}co{4qs5kw5ow5qs17sv5tv}cp{4qs5kw5ow5qs17sv5tv}6l{17sy5ty5ow}do{17st5tt}4z{17st5tt}7s{fst}dm{17st5tt}dn{17st5tt}5o{ckwclwcmwcnwcowcpw4lw4wv}dp{17st5tt}dq{17st5tt}7t{5ow}ds{17st5tt}5t{2ktclucmucnu4otcpu4lu4wycoucku}fu{17sv5tv5ow}6p{17sy5ty5ow5qs}ek{17sy5ty5ow}el{17sy5ty5ow}em{17sy5ty5ow}en{5ty}eo{17sy5ty5ow}ep{17sy5ty5ow}es{17sy5ty5qs}et{17sy5ty5ow5qs}eu{17sy5ty5ow5qs}ev{17sy5ty5ow5qs}6z{17sy5ty5ow5qs}fm{17sy5ty5ow5qs}fn{17sy5ty5ow5qs}fo{17sy5ty5ow5qs}fp{17sy5ty5qs}fq{17sy5ty5ow5qs}7r{5ow}fs{17sy5ty5ow5qs}ft{17sv5tv5ow}7m{5ow}fv{17sv5tv5ow}fw{17sv5tv5ow}}}"), "Helvetica-BoldOblique": f("{'widths'{k3s2q4scx1w201n3r201o6o201s1w201t1w201u1w201w3m201x3m201y3m2k1w2l2l202m2n2n3r2o3r2p5t202q6o2r1s2s2l2t2l2u2r2v3u2w1w2x2l2y1w2z1w3k3r3l3r3m3r3n3r3o3r3p3r3q3r3r3r3s3r203t2l203u2l3v2l3w3u3x3u3y3u3z3x4k6l4l4s4m4s4n4s4o4s4p4m4q3x4r4y4s4s4t1w4u3r4v4s4w3x4x5n4y4s4z4y5k4m5l4y5m4s5n4m5o3x5p4s5q4m5r5y5s4m5t4m5u3x5v2l5w1w5x2l5y3u5z3r6k2l6l3r6m3x6n3r6o3x6p3r6q2l6r3x6s3x6t1w6u1w6v3r6w1w6x5t6y3x6z3x7k3x7l3x7m2r7n3r7o2l7p3x7q3r7r4y7s3r7t3r7u3m7v2r7w1w7x2r7y3u202l3rcl4sal2lam3ran3rao3rap3rar3ras2lat4tau2pav3raw3uay4taz2lbk2sbl3u'fof'6obo2lbp3xbq3rbr1wbs2lbu2obv3rbz3xck4s202k3rcm4scn4sco4scp4scq6ocr4scs4mct4mcu4mcv4mcw1w2m2zcy1wcz1wdl4sdm4ydn4ydo4ydp4ydq4yds4ydt4sdu4sdv4sdw4sdz3xek3rel3rem3ren3reo3rep3req5ter3res3ret3reu3rev3rew1wex1wey1wez1wfl3xfm3xfn3xfo3xfp3xfq3xfr3ufs3xft3xfu3xfv3xfw3xfz3r203k6o212m6o2dw2l2cq2l3t3r3u2l17s4m19m3r}'kerning'{cl{4qs5ku5ot5qs17sv5tv}201t{2ww4wy2yw}201w{2ks}201x{2ww4wy2yw}2k{201ts201xs}2w{7qs4qu5kw5os5qw5rs17su5tu7tsfzs}2x{5ow5qs}2y{7qs4qu5kw5os5qw5rs17su5tu7tsfzs}'fof'-6o7p{17su5tu5ot}ck{4qs5ku5ot5qs17sv5tv}4l{4qs5ku5ot5qs17sv5tv}cm{4qs5ku5ot5qs17sv5tv}cn{4qs5ku5ot5qs17sv5tv}co{4qs5ku5ot5qs17sv5tv}cp{4qs5ku5ot5qs17sv5tv}6l{17st5tt5os}17s{2kwclvcmvcnvcovcpv4lv4wwckv}5o{2kucltcmtcntcotcpt4lt4wtckt}5q{2ksclscmscnscoscps4ls4wvcks}5r{2ks4ws}5t{2kwclvcmvcnvcovcpv4lv4wwckv}eo{17st5tt5os}fu{17su5tu5ot}6p{17ss5ts}ek{17st5tt5os}el{17st5tt5os}em{17st5tt5os}en{17st5tt5os}6o{201ts}ep{17st5tt5os}es{17ss5ts}et{17ss5ts}eu{17ss5ts}ev{17ss5ts}6z{17su5tu5os5qt}fm{17su5tu5os5qt}fn{17su5tu5os5qt}fo{17su5tu5os5qt}fp{17su5tu5os5qt}fq{17su5tu5os5qt}fs{17su5tu5os5qt}ft{17su5tu5ot}7m{5os}fv{17su5tu5ot}fw{17su5tu5ot}}}"), ZapfDingbats: f("{'widths'{k4u2k1w'fof'6o}'kerning'{'fof'-6o}}"), "Courier-Bold": f("{'widths'{k3w'fof'6o}'kerning'{'fof'-6o}}"), "Times-Italic": f("{'widths'{k3n2q4ycx2l201n3m201o5t201s2l201t2l201u2l201w3r201x3r201y3r2k1t2l2l202m2n2n3m2o3m2p5n202q5t2r1p2s2l2t2l2u3m2v4n2w1t2x2l2y1t2z1w3k3m3l3m3m3m3n3m3o3m3p3m3q3m3r3m3s3m203t2l203u2l3v2l3w4n3x4n3y4n3z3m4k5w4l3x4m3x4n4m4o4s4p3x4q3x4r4s4s4s4t2l4u2w4v4m4w3r4x5n4y4m4z4s5k3x5l4s5m3x5n3m5o3r5p4s5q3x5r5n5s3x5t3r5u3r5v2r5w1w5x2r5y2u5z3m6k2l6l3m6m3m6n2w6o3m6p2w6q1w6r3m6s3m6t1w6u1w6v2w6w1w6x4s6y3m6z3m7k3m7l3m7m2r7n2r7o1w7p3m7q2w7r4m7s2w7t2w7u2r7v2s7w1v7x2s7y3q202l3mcl3xal2ram3man3mao3map3mar3mas2lat4wau1vav3maw4nay4waz2lbk2sbl4n'fof'6obo2lbp3mbq3obr1tbs2lbu1zbv3mbz3mck3x202k3mcm3xcn3xco3xcp3xcq5tcr4mcs3xct3xcu3xcv3xcw2l2m2ucy2lcz2ldl4mdm4sdn4sdo4sdp4sdq4sds4sdt4sdu4sdv4sdw4sdz3mek3mel3mem3men3meo3mep3meq4mer2wes2wet2weu2wev2wew1wex1wey1wez1wfl3mfm3mfn3mfo3mfp3mfq3mfr4nfs3mft3mfu3mfv3mfw3mfz2w203k6o212m6m2dw2l2cq2l3t3m3u2l17s3r19m3m}'kerning'{cl{5kt4qw}201s{201sw}201t{201tw2wy2yy6q-t}201x{2wy2yy}2k{201tw}2w{7qs4qy7rs5ky7mw5os5qx5ru17su5tu}2x{17ss5ts5os}2y{7qs4qy7rs5ky7mw5os5qx5ru17su5tu}'fof'-6o6t{17ss5ts5qs}7t{5os}3v{5qs}7p{17su5tu5qs}ck{5kt4qw}4l{5kt4qw}cm{5kt4qw}cn{5kt4qw}co{5kt4qw}cp{5kt4qw}6l{4qs5ks5ou5qw5ru17su5tu}17s{2ks}5q{ckvclvcmvcnvcovcpv4lv}5r{ckuclucmucnucoucpu4lu}5t{2ks}6p{4qs5ks5ou5qw5ru17su5tu}ek{4qs5ks5ou5qw5ru17su5tu}el{4qs5ks5ou5qw5ru17su5tu}em{4qs5ks5ou5qw5ru17su5tu}en{4qs5ks5ou5qw5ru17su5tu}eo{4qs5ks5ou5qw5ru17su5tu}ep{4qs5ks5ou5qw5ru17su5tu}es{5ks5qs4qs}et{4qs5ks5ou5qw5ru17su5tu}eu{4qs5ks5qw5ru17su5tu}ev{5ks5qs4qs}ex{17ss5ts5qs}6z{4qv5ks5ou5qw5ru17su5tu}fm{4qv5ks5ou5qw5ru17su5tu}fn{4qv5ks5ou5qw5ru17su5tu}fo{4qv5ks5ou5qw5ru17su5tu}fp{4qv5ks5ou5qw5ru17su5tu}fq{4qv5ks5ou5qw5ru17su5tu}7r{5os}fs{4qv5ks5ou5qw5ru17su5tu}ft{17su5tu5qs}fu{17su5tu5qs}fv{17su5tu5qs}fw{17su5tu5qs}}}"), "Times-Roman": f("{'widths'{k3n2q4ycx2l201n3m201o6o201s2l201t2l201u2l201w2w201x2w201y2w2k1t2l2l202m2n2n3m2o3m2p5n202q6o2r1m2s2l2t2l2u3m2v3s2w1t2x2l2y1t2z1w3k3m3l3m3m3m3n3m3o3m3p3m3q3m3r3m3s3m203t2l203u2l3v1w3w3s3x3s3y3s3z2w4k5w4l4s4m4m4n4m4o4s4p3x4q3r4r4s4s4s4t2l4u2r4v4s4w3x4x5t4y4s4z4s5k3r5l4s5m4m5n3r5o3x5p4s5q4s5r5y5s4s5t4s5u3x5v2l5w1w5x2l5y2z5z3m6k2l6l2w6m3m6n2w6o3m6p2w6q2l6r3m6s3m6t1w6u1w6v3m6w1w6x4y6y3m6z3m7k3m7l3m7m2l7n2r7o1w7p3m7q3m7r4s7s3m7t3m7u2w7v3k7w1o7x3k7y3q202l3mcl4sal2lam3man3mao3map3mar3mas2lat4wau1vav3maw3say4waz2lbk2sbl3s'fof'6obo2lbp3mbq2xbr1tbs2lbu1zbv3mbz2wck4s202k3mcm4scn4sco4scp4scq5tcr4mcs3xct3xcu3xcv3xcw2l2m2tcy2lcz2ldl4sdm4sdn4sdo4sdp4sdq4sds4sdt4sdu4sdv4sdw4sdz3mek2wel2wem2wen2weo2wep2weq4mer2wes2wet2weu2wev2wew1wex1wey1wez1wfl3mfm3mfn3mfo3mfp3mfq3mfr3sfs3mft3mfu3mfv3mfw3mfz3m203k6o212m6m2dw2l2cq2l3t3m3u1w17s4s19m3m}'kerning'{cl{4qs5ku17sw5ou5qy5rw201ss5tw201ws}201s{201ss}201t{ckw4lwcmwcnwcowcpwclw4wu201ts}2k{201ts}2w{4qs5kw5os5qx5ru17sx5tx}2x{17sw5tw5ou5qu}2y{4qs5kw5os5qx5ru17sx5tx}'fof'-6o7t{ckuclucmucnucoucpu4lu5os5rs}3u{17su5tu5qs}3v{17su5tu5qs}7p{17sw5tw5qs}ck{4qs5ku17sw5ou5qy5rw201ss5tw201ws}4l{4qs5ku17sw5ou5qy5rw201ss5tw201ws}cm{4qs5ku17sw5ou5qy5rw201ss5tw201ws}cn{4qs5ku17sw5ou5qy5rw201ss5tw201ws}co{4qs5ku17sw5ou5qy5rw201ss5tw201ws}cp{4qs5ku17sw5ou5qy5rw201ss5tw201ws}6l{17su5tu5os5qw5rs}17s{2ktclvcmvcnvcovcpv4lv4wuckv}5o{ckwclwcmwcnwcowcpw4lw4wu}5q{ckyclycmycnycoycpy4ly4wu5ms}5r{cktcltcmtcntcotcpt4lt4ws}5t{2ktclvcmvcnvcovcpv4lv4wuckv}7q{cksclscmscnscoscps4ls}6p{17su5tu5qw5rs}ek{5qs5rs}el{17su5tu5os5qw5rs}em{17su5tu5os5qs5rs}en{17su5qs5rs}eo{5qs5rs}ep{17su5tu5os5qw5rs}es{5qs}et{17su5tu5qw5rs}eu{17su5tu5qs5rs}ev{5qs}6z{17sv5tv5os5qx5rs}fm{5os5qt5rs}fn{17sv5tv5os5qx5rs}fo{17sv5tv5os5qx5rs}fp{5os5qt5rs}fq{5os5qt5rs}7r{ckuclucmucnucoucpu4lu5os}fs{17sv5tv5os5qx5rs}ft{17ss5ts5qs}fu{17sw5tw5qs}fv{17sw5tw5qs}fw{17ss5ts5qs}fz{ckuclucmucnucoucpu4lu5os5rs}}}"), "Helvetica-Oblique": f("{'widths'{k3p2q4mcx1w201n3r201o6o201s1q201t1q201u1q201w2l201x2l201y2l2k1w2l1w202m2n2n3r2o3r2p5t202q6o2r1n2s2l2t2l2u2r2v3u2w1w2x2l2y1w2z1w3k3r3l3r3m3r3n3r3o3r3p3r3q3r3r3r3s3r203t2l203u2l3v1w3w3u3x3u3y3u3z3r4k6p4l4m4m4m4n4s4o4s4p4m4q3x4r4y4s4s4t1w4u3m4v4m4w3r4x5n4y4s4z4y5k4m5l4y5m4s5n4m5o3x5p4s5q4m5r5y5s4m5t4m5u3x5v1w5w1w5x1w5y2z5z3r6k2l6l3r6m3r6n3m6o3r6p3r6q1w6r3r6s3r6t1q6u1q6v3m6w1q6x5n6y3r6z3r7k3r7l3r7m2l7n3m7o1w7p3r7q3m7r4s7s3m7t3m7u3m7v2l7w1u7x2l7y3u202l3rcl4mal2lam3ran3rao3rap3rar3ras2lat4tau2pav3raw3uay4taz2lbk2sbl3u'fof'6obo2lbp3rbr1wbs2lbu2obv3rbz3xck4m202k3rcm4mcn4mco4mcp4mcq6ocr4scs4mct4mcu4mcv4mcw1w2m2ncy1wcz1wdl4sdm4ydn4ydo4ydp4ydq4yds4ydt4sdu4sdv4sdw4sdz3xek3rel3rem3ren3reo3rep3req5ter3mes3ret3reu3rev3rew1wex1wey1wez1wfl3rfm3rfn3rfo3rfp3rfq3rfr3ufs3xft3rfu3rfv3rfw3rfz3m203k6o212m6o2dw2l2cq2l3t3r3u1w17s4m19m3r}'kerning'{5q{4wv}cl{4qs5kw5ow5qs17sv5tv}201t{2wu4w1k2yu}201x{2wu4wy2yu}17s{2ktclucmucnu4otcpu4lu4wycoucku}2w{7qs4qz5k1m17sy5ow5qx5rsfsu5ty7tufzu}2x{17sy5ty5oy5qs}2y{7qs4qz5k1m17sy5ow5qx5rsfsu5ty7tufzu}'fof'-6o7p{17sv5tv5ow}ck{4qs5kw5ow5qs17sv5tv}4l{4qs5kw5ow5qs17sv5tv}cm{4qs5kw5ow5qs17sv5tv}cn{4qs5kw5ow5qs17sv5tv}co{4qs5kw5ow5qs17sv5tv}cp{4qs5kw5ow5qs17sv5tv}6l{17sy5ty5ow}do{17st5tt}4z{17st5tt}7s{fst}dm{17st5tt}dn{17st5tt}5o{ckwclwcmwcnwcowcpw4lw4wv}dp{17st5tt}dq{17st5tt}7t{5ow}ds{17st5tt}5t{2ktclucmucnu4otcpu4lu4wycoucku}fu{17sv5tv5ow}6p{17sy5ty5ow5qs}ek{17sy5ty5ow}el{17sy5ty5ow}em{17sy5ty5ow}en{5ty}eo{17sy5ty5ow}ep{17sy5ty5ow}es{17sy5ty5qs}et{17sy5ty5ow5qs}eu{17sy5ty5ow5qs}ev{17sy5ty5ow5qs}6z{17sy5ty5ow5qs}fm{17sy5ty5ow5qs}fn{17sy5ty5ow5qs}fo{17sy5ty5ow5qs}fp{17sy5ty5qs}fq{17sy5ty5ow5qs}7r{5ow}fs{17sy5ty5ow5qs}ft{17sv5tv5ow}7m{5ow}fv{17sv5tv5ow}fw{17sv5tv5ow}}}") } };
  t3.events.push(["addFont", function(L) {
    var g = L.font, O = x.Unicode[g.postScriptName];
    O && (g.metadata.Unicode = {}, g.metadata.Unicode.widths = O.widths, g.metadata.Unicode.kerning = O.kerning);
    var P = p.Unicode[g.postScriptName];
    P && (g.metadata.Unicode.encoding = P, g.encoding = P.codePages[0]);
  }]);
})(jt.API), (function(t3) {
  var n = function(e) {
    for (var r = e.length, i = new Uint8Array(r), o = 0; o < r; o++) i[o] = e.charCodeAt(o);
    return i;
  };
  t3.API.events.push(["addFont", function(e) {
    var r = void 0, i = e.font, o = e.instance;
    if (!i.isStandardFont) {
      if (o === void 0) throw new Error("Font does not exist in vFS, import fonts or remove declaration doc.addFont('" + i.postScriptName + "').");
      if (typeof (r = o.existsFileInVFS(i.postScriptName) === false ? o.loadFile(i.postScriptName) : o.getFileFromVFS(i.postScriptName)) != "string") throw new Error("Font is not stored as string-data in vFS, import fonts or remove declaration doc.addFont('" + i.postScriptName + "').");
      (function(u, l) {
        l = /^\x00\x01\x00\x00/.test(l) ? n(l) : n(Ls(l)), u.metadata = t3.API.TTFFont.open(l), u.metadata.Unicode = u.metadata.Unicode || { encoding: {}, kerning: {}, widths: [] }, u.metadata.glyIdsUsed = [0];
      })(i, r);
    }
  }]);
})(jt), jt.API.addSvgAsImage = function(t3, n, e, r, i, o, u, l) {
  if (isNaN(n) || isNaN(e)) throw Re.error("jsPDF.addSvgAsImage: Invalid coordinates", arguments), new Error("Invalid coordinates passed to jsPDF.addSvgAsImage");
  if (isNaN(r) || isNaN(i)) throw Re.error("jsPDF.addSvgAsImage: Invalid measurements", arguments), new Error("Invalid measurements (width and/or height) passed to jsPDF.addSvgAsImage");
  var f = document.createElement("canvas");
  f.width = r, f.height = i;
  var c = f.getContext("2d");
  c.fillStyle = "#fff", c.fillRect(0, 0, f.width, f.height);
  var p = { ignoreMouse: true, ignoreAnimation: true, ignoreDimensions: true }, x = this;
  return ($t.canvg ? Promise.resolve($t.canvg) : vl(() => import("../../../../../../modules/index.es-2977e3e8.js"), ["static/js/index.es-2977e3e8.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/html2canvas.esm-e0a7d97b.js", "static/js/index-50216080.js", "static/css/index-685b5588.css"])).catch(function(L) {
    return Promise.reject(new Error("Could not load canvg: " + L));
  }).then(function(L) {
    return L.default ? L.default : L;
  }).then(function(L) {
    return L.fromString(c, t3, p);
  }, function() {
    return Promise.reject(new Error("Could not load canvg."));
  }).then(function(L) {
    return L.render(p);
  }).then(function() {
    x.addImage(f.toDataURL("image/jpeg", 1), n, e, r, i, u, l);
  });
}, jt.API.putTotalPages = function(t3) {
  var n, e = 0;
  parseInt(this.internal.getFont().id.substr(1), 10) < 15 ? (n = new RegExp(t3, "g"), e = this.internal.getNumberOfPages()) : (n = new RegExp(this.pdfEscape16(t3, this.internal.getFont()), "g"), e = this.pdfEscape16(this.internal.getNumberOfPages() + "", this.internal.getFont()));
  for (var r = 1; r <= this.internal.getNumberOfPages(); r++) for (var i = 0; i < this.internal.pages[r].length; i++) this.internal.pages[r][i] = this.internal.pages[r][i].replace(n, e);
  return this;
}, jt.API.viewerPreferences = function(t3, n) {
  var e;
  t3 = t3 || {}, n = n || false;
  var r, i, o, u = { HideToolbar: { defaultValue: false, value: false, type: "boolean", explicitSet: false, valueSet: [true, false], pdfVersion: 1.3 }, HideMenubar: { defaultValue: false, value: false, type: "boolean", explicitSet: false, valueSet: [true, false], pdfVersion: 1.3 }, HideWindowUI: { defaultValue: false, value: false, type: "boolean", explicitSet: false, valueSet: [true, false], pdfVersion: 1.3 }, FitWindow: { defaultValue: false, value: false, type: "boolean", explicitSet: false, valueSet: [true, false], pdfVersion: 1.3 }, CenterWindow: { defaultValue: false, value: false, type: "boolean", explicitSet: false, valueSet: [true, false], pdfVersion: 1.3 }, DisplayDocTitle: { defaultValue: false, value: false, type: "boolean", explicitSet: false, valueSet: [true, false], pdfVersion: 1.4 }, NonFullScreenPageMode: { defaultValue: "UseNone", value: "UseNone", type: "name", explicitSet: false, valueSet: ["UseNone", "UseOutlines", "UseThumbs", "UseOC"], pdfVersion: 1.3 }, Direction: { defaultValue: "L2R", value: "L2R", type: "name", explicitSet: false, valueSet: ["L2R", "R2L"], pdfVersion: 1.3 }, ViewArea: { defaultValue: "CropBox", value: "CropBox", type: "name", explicitSet: false, valueSet: ["MediaBox", "CropBox", "TrimBox", "BleedBox", "ArtBox"], pdfVersion: 1.4 }, ViewClip: { defaultValue: "CropBox", value: "CropBox", type: "name", explicitSet: false, valueSet: ["MediaBox", "CropBox", "TrimBox", "BleedBox", "ArtBox"], pdfVersion: 1.4 }, PrintArea: { defaultValue: "CropBox", value: "CropBox", type: "name", explicitSet: false, valueSet: ["MediaBox", "CropBox", "TrimBox", "BleedBox", "ArtBox"], pdfVersion: 1.4 }, PrintClip: { defaultValue: "CropBox", value: "CropBox", type: "name", explicitSet: false, valueSet: ["MediaBox", "CropBox", "TrimBox", "BleedBox", "ArtBox"], pdfVersion: 1.4 }, PrintScaling: { defaultValue: "AppDefault", value: "AppDefault", type: "name", explicitSet: false, valueSet: ["AppDefault", "None"], pdfVersion: 1.6 }, Duplex: { defaultValue: "", value: "none", type: "name", explicitSet: false, valueSet: ["Simplex", "DuplexFlipShortEdge", "DuplexFlipLongEdge", "none"], pdfVersion: 1.7 }, PickTrayByPDFSize: { defaultValue: false, value: false, type: "boolean", explicitSet: false, valueSet: [true, false], pdfVersion: 1.7 }, PrintPageRange: { defaultValue: "", value: "", type: "array", explicitSet: false, valueSet: null, pdfVersion: 1.7 }, NumCopies: { defaultValue: 1, value: 1, type: "integer", explicitSet: false, valueSet: null, pdfVersion: 1.7 } }, l = Object.keys(u), f = [], c = 0, p = 0, x = 0;
  function L(O, P) {
    var M, k = false;
    for (M = 0; M < O.length; M += 1) O[M] === P && (k = true);
    return k;
  }
  if (this.internal.viewerpreferences === void 0 && (this.internal.viewerpreferences = {}, this.internal.viewerpreferences.configuration = JSON.parse(JSON.stringify(u)), this.internal.viewerpreferences.isSubscribed = false), e = this.internal.viewerpreferences.configuration, t3 === "reset" || n === true) {
    var g = l.length;
    for (x = 0; x < g; x += 1) e[l[x]].value = e[l[x]].defaultValue, e[l[x]].explicitSet = false;
  }
  if (Ce(t3) === "object") {
    for (i in t3) if (o = t3[i], L(l, i) && o !== void 0) {
      if (e[i].type === "boolean" && typeof o == "boolean") e[i].value = o;
      else if (e[i].type === "name" && L(e[i].valueSet, o)) e[i].value = o;
      else if (e[i].type === "integer" && Number.isInteger(o)) e[i].value = o;
      else if (e[i].type === "array") {
        for (c = 0; c < o.length; c += 1) if (r = true, o[c].length === 1 && typeof o[c][0] == "number") f.push(String(o[c] - 1));
        else if (o[c].length > 1) {
          for (p = 0; p < o[c].length; p += 1) typeof o[c][p] != "number" && (r = false);
          r === true && f.push([o[c][0] - 1, o[c][1] - 1].join(" "));
        }
        e[i].value = "[" + f.join(" ") + "]";
      } else e[i].value = e[i].defaultValue;
      e[i].explicitSet = true;
    }
  }
  return this.internal.viewerpreferences.isSubscribed === false && (this.internal.events.subscribe("putCatalog", function() {
    var O, P = [];
    for (O in e) e[O].explicitSet === true && (e[O].type === "name" ? P.push("/" + O + " /" + e[O].value) : P.push("/" + O + " " + e[O].value));
    P.length !== 0 && this.internal.write(`/ViewerPreferences
<<
` + P.join(`
`) + `
>>`);
  }), this.internal.viewerpreferences.isSubscribed = true), this.internal.viewerpreferences.configuration = e, this;
}, (function(t3) {
  var n = function() {
    var r = '<rdf:RDF xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"><rdf:Description rdf:about="" xmlns:jspdf="' + this.internal.__metadata__.namespaceuri + '"><jspdf:metadata>', i = unescape(encodeURIComponent('<x:xmpmeta xmlns:x="adobe:ns:meta/">')), o = unescape(encodeURIComponent(r)), u = unescape(encodeURIComponent(this.internal.__metadata__.metadata)), l = unescape(encodeURIComponent("</jspdf:metadata></rdf:Description></rdf:RDF>")), f = unescape(encodeURIComponent("</x:xmpmeta>")), c = o.length + u.length + l.length + i.length + f.length;
    this.internal.__metadata__.metadata_object_number = this.internal.newObject(), this.internal.write("<< /Type /Metadata /Subtype /XML /Length " + c + " >>"), this.internal.write("stream"), this.internal.write(i + o + u + l + f), this.internal.write("endstream"), this.internal.write("endobj");
  }, e = function() {
    this.internal.__metadata__.metadata_object_number && this.internal.write("/Metadata " + this.internal.__metadata__.metadata_object_number + " 0 R");
  };
  t3.addMetadata = function(r, i) {
    return this.internal.__metadata__ === void 0 && (this.internal.__metadata__ = { metadata: r, namespaceuri: i || "http://jspdf.default.namespaceuri/" }, this.internal.events.subscribe("putCatalog", e), this.internal.events.subscribe("postPutResources", n)), this;
  };
})(jt.API), (function(t3) {
  var n = t3.API, e = n.pdfEscape16 = function(o, u) {
    for (var l, f = u.metadata.Unicode.widths, c = ["", "0", "00", "000", "0000"], p = [""], x = 0, L = o.length; x < L; ++x) {
      if (l = u.metadata.characterToGlyph(o.charCodeAt(x)), u.metadata.glyIdsUsed.push(l), u.metadata.toUnicode[l] = o.charCodeAt(x), f.indexOf(l) == -1 && (f.push(l), f.push([parseInt(u.metadata.widthOfGlyph(l), 10)])), l == "0") return p.join("");
      l = l.toString(16), p.push(c[4 - l.length], l);
    }
    return p.join("");
  }, r = function(o) {
    var u, l, f, c, p, x, L;
    for (p = `/CIDInit /ProcSet findresource begin
12 dict begin
begincmap
/CIDSystemInfo <<
  /Registry (Adobe)
  /Ordering (UCS)
  /Supplement 0
>> def
/CMapName /Adobe-Identity-UCS def
/CMapType 2 def
1 begincodespacerange
<0000><ffff>
endcodespacerange`, f = [], x = 0, L = (l = Object.keys(o).sort(function(g, O) {
      return g - O;
    })).length; x < L; x++) u = l[x], f.length >= 100 && (p += `
` + f.length + ` beginbfchar
` + f.join(`
`) + `
endbfchar`, f = []), o[u] !== void 0 && o[u] !== null && typeof o[u].toString == "function" && (c = ("0000" + o[u].toString(16)).slice(-4), u = ("0000" + (+u).toString(16)).slice(-4), f.push("<" + u + "><" + c + ">"));
    return f.length && (p += `
` + f.length + ` beginbfchar
` + f.join(`
`) + `
endbfchar
`), p + `endcmap
CMapName currentdict /CMap defineresource pop
end
end`;
  };
  n.events.push(["putFont", function(o) {
    (function(u) {
      var l = u.font, f = u.out, c = u.newObject, p = u.putStream;
      if (l.metadata instanceof t3.API.TTFFont && l.encoding === "Identity-H") {
        for (var x = l.metadata.Unicode.widths, L = l.metadata.subset.encode(l.metadata.glyIdsUsed, 1), g = "", O = 0; O < L.length; O++) g += String.fromCharCode(L[O]);
        var P = c();
        p({ data: g, addLength1: true, objectId: P }), f("endobj");
        var M = c();
        p({ data: r(l.metadata.toUnicode), addLength1: true, objectId: M }), f("endobj");
        var k = c();
        f("<<"), f("/Type /FontDescriptor"), f("/FontName /" + ya(l.fontName)), f("/FontFile2 " + P + " 0 R"), f("/FontBBox " + t3.API.PDFObject.convert(l.metadata.bbox)), f("/Flags " + l.metadata.flags), f("/StemV " + l.metadata.stemV), f("/ItalicAngle " + l.metadata.italicAngle), f("/Ascent " + l.metadata.ascender), f("/Descent " + l.metadata.decender), f("/CapHeight " + l.metadata.capHeight), f(">>"), f("endobj");
        var V = c();
        f("<<"), f("/Type /Font"), f("/BaseFont /" + ya(l.fontName)), f("/FontDescriptor " + k + " 0 R"), f("/W " + t3.API.PDFObject.convert(x)), f("/CIDToGIDMap /Identity"), f("/DW 1000"), f("/Subtype /CIDFontType2"), f("/CIDSystemInfo"), f("<<"), f("/Supplement 0"), f("/Registry (Adobe)"), f("/Ordering (" + l.encoding + ")"), f(">>"), f(">>"), f("endobj"), l.objectNumber = c(), f("<<"), f("/Type /Font"), f("/Subtype /Type0"), f("/ToUnicode " + M + " 0 R"), f("/BaseFont /" + ya(l.fontName)), f("/Encoding /" + l.encoding), f("/DescendantFonts [" + V + " 0 R]"), f(">>"), f("endobj"), l.isAlreadyPutted = true;
      }
    })(o);
  }]), n.events.push(["putFont", function(o) {
    (function(u) {
      var l = u.font, f = u.out, c = u.newObject, p = u.putStream;
      if (l.metadata instanceof t3.API.TTFFont && l.encoding === "WinAnsiEncoding") {
        for (var x = l.metadata.rawData, L = "", g = 0; g < x.length; g++) L += String.fromCharCode(x[g]);
        var O = c();
        p({ data: L, addLength1: true, objectId: O }), f("endobj");
        var P = c();
        p({ data: r(l.metadata.toUnicode), addLength1: true, objectId: P }), f("endobj");
        var M = c();
        f("<<"), f("/Descent " + l.metadata.decender), f("/CapHeight " + l.metadata.capHeight), f("/StemV " + l.metadata.stemV), f("/Type /FontDescriptor"), f("/FontFile2 " + O + " 0 R"), f("/Flags 96"), f("/FontBBox " + t3.API.PDFObject.convert(l.metadata.bbox)), f("/FontName /" + ya(l.fontName)), f("/ItalicAngle " + l.metadata.italicAngle), f("/Ascent " + l.metadata.ascender), f(">>"), f("endobj"), l.objectNumber = c();
        for (var k = 0; k < l.metadata.hmtx.widths.length; k++) l.metadata.hmtx.widths[k] = parseInt(l.metadata.hmtx.widths[k] * (1e3 / l.metadata.head.unitsPerEm));
        f("<</Subtype/TrueType/Type/Font/ToUnicode " + P + " 0 R/BaseFont/" + ya(l.fontName) + "/FontDescriptor " + M + " 0 R/Encoding/" + l.encoding + " /FirstChar 29 /LastChar 255 /Widths " + t3.API.PDFObject.convert(l.metadata.hmtx.widths) + ">>"), f("endobj"), l.isAlreadyPutted = true;
      }
    })(o);
  }]);
  var i = function(o) {
    var u, l = o.text || "", f = o.x, c = o.y, p = o.options || {}, x = o.mutex || {}, L = x.pdfEscape, g = x.activeFontKey, O = x.fonts, P = g, M = "", k = 0, V = "", G = O[P].encoding;
    if (O[P].encoding !== "Identity-H") return { text: l, x: f, y: c, options: p, mutex: x };
    for (V = l, P = g, Array.isArray(l) && (V = l[0]), k = 0; k < V.length; k += 1) O[P].metadata.hasOwnProperty("cmap") && (u = O[P].metadata.cmap.unicode.codeMap[V[k].charCodeAt(0)]), u || V[k].charCodeAt(0) < 256 && O[P].metadata.hasOwnProperty("Unicode") ? M += V[k] : M += "";
    var D = "";
    return parseInt(P.slice(1)) < 14 || G === "WinAnsiEncoding" ? D = L(M, P).split("").map(function(it) {
      return it.charCodeAt(0).toString(16);
    }).join("") : G === "Identity-H" && (D = e(M, O[P])), x.isHex = true, { text: D, x: f, y: c, options: p, mutex: x };
  };
  n.events.push(["postProcessText", function(o) {
    var u = o.text || "", l = [], f = { text: u, x: o.x, y: o.y, options: o.options, mutex: o.mutex };
    if (Array.isArray(u)) {
      var c = 0;
      for (c = 0; c < u.length; c += 1) Array.isArray(u[c]) && u[c].length === 3 ? l.push([i(Object.assign({}, f, { text: u[c][0] })).text, u[c][1], u[c][2]]) : l.push(i(Object.assign({}, f, { text: u[c] })).text);
      o.text = l;
    } else o.text = i(Object.assign({}, f, { text: u })).text;
  }]);
})(jt), (function(t3) {
  var n = function() {
    return this.internal.vFS === void 0 && (this.internal.vFS = {}), true;
  };
  t3.existsFileInVFS = function(e) {
    return n.call(this), this.internal.vFS[e] !== void 0;
  }, t3.addFileToVFS = function(e, r) {
    return n.call(this), this.internal.vFS[e] = r, this;
  }, t3.getFileFromVFS = function(e) {
    return n.call(this), this.internal.vFS[e] !== void 0 ? this.internal.vFS[e] : null;
  };
})(jt.API), (function(t3) {
  t3.__bidiEngine__ = t3.prototype.__bidiEngine__ = function(r) {
    var i, o, u, l, f, c, p, x = n, L = [[0, 3, 0, 1, 0, 0, 0], [0, 3, 0, 1, 2, 2, 0], [0, 3, 0, 17, 2, 0, 1], [0, 3, 5, 5, 4, 1, 0], [0, 3, 21, 21, 4, 0, 1], [0, 3, 5, 5, 4, 2, 0]], g = [[2, 0, 1, 1, 0, 1, 0], [2, 0, 1, 1, 0, 2, 0], [2, 0, 2, 1, 3, 2, 0], [2, 0, 2, 33, 3, 1, 1]], O = { L: 0, R: 1, EN: 2, AN: 3, N: 4, B: 5, S: 6 }, P = { 0: 0, 5: 1, 6: 2, 7: 3, 32: 4, 251: 5, 254: 6, 255: 7 }, M = ["(", ")", "(", "<", ">", "<", "[", "]", "[", "{", "}", "{", "«", "»", "«", "‹", "›", "‹", "⁅", "⁆", "⁅", "⁽", "⁾", "⁽", "₍", "₎", "₍", "≤", "≥", "≤", "〈", "〉", "〈", "﹙", "﹚", "﹙", "﹛", "﹜", "﹛", "﹝", "﹞", "﹝", "﹤", "﹥", "﹤"], k = new RegExp(/^([1-4|9]|1[0-9]|2[0-9]|3[0168]|4[04589]|5[012]|7[78]|159|16[0-9]|17[0-2]|21[569]|22[03489]|250)$/), V = false, G = 0;
    this.__bidiEngine__ = {};
    var D = function(N) {
      var C = N.charCodeAt(), z = C >> 8, q = P[z];
      return q !== void 0 ? x[256 * q + (255 & C)] : z === 252 || z === 253 ? "AL" : k.test(z) ? "L" : z === 8 ? "R" : "N";
    }, it = function(N) {
      for (var C, z = 0; z < N.length; z++) {
        if ((C = D(N.charAt(z))) === "L") return false;
        if (C === "R") return true;
      }
      return false;
    }, bt = function(N, C, z, q) {
      var rt, st, ht, tt, ft = C[q];
      switch (ft) {
        case "L":
        case "R":
        case "LRE":
        case "RLE":
        case "LRO":
        case "RLO":
        case "PDF":
          V = false;
          break;
        case "N":
        case "AN":
          break;
        case "EN":
          V && (ft = "AN");
          break;
        case "AL":
          V = true, ft = "R";
          break;
        case "WS":
        case "BN":
          ft = "N";
          break;
        case "CS":
          q < 1 || q + 1 >= C.length || (rt = z[q - 1]) !== "EN" && rt !== "AN" || (st = C[q + 1]) !== "EN" && st !== "AN" ? ft = "N" : V && (st = "AN"), ft = st === rt ? st : "N";
          break;
        case "ES":
          ft = (rt = q > 0 ? z[q - 1] : "B") === "EN" && q + 1 < C.length && C[q + 1] === "EN" ? "EN" : "N";
          break;
        case "ET":
          if (q > 0 && z[q - 1] === "EN") {
            ft = "EN";
            break;
          }
          if (V) {
            ft = "N";
            break;
          }
          for (ht = q + 1, tt = C.length; ht < tt && C[ht] === "ET"; ) ht++;
          ft = ht < tt && C[ht] === "EN" ? "EN" : "N";
          break;
        case "NSM":
          if (u && !l) {
            for (tt = C.length, ht = q + 1; ht < tt && C[ht] === "NSM"; ) ht++;
            if (ht < tt) {
              var Lt = N[q], lt = Lt >= 1425 && Lt <= 2303 || Lt === 64286;
              if (rt = C[ht], lt && (rt === "R" || rt === "AL")) {
                ft = "R";
                break;
              }
            }
          }
          ft = q < 1 || (rt = C[q - 1]) === "B" ? "N" : z[q - 1];
          break;
        case "B":
          V = false, i = true, ft = G;
          break;
        case "S":
          o = true, ft = "N";
      }
      return ft;
    }, dt = function(N, C, z) {
      var q = N.split("");
      return z && $(q, z, { hiLevel: G }), q.reverse(), C && C.reverse(), q.join("");
    }, $ = function(N, C, z) {
      var q, rt, st, ht, tt, ft = -1, Lt = N.length, lt = 0, _ = [], T = G ? g : L, B = [];
      for (V = false, i = false, o = false, rt = 0; rt < Lt; rt++) B[rt] = D(N[rt]);
      for (st = 0; st < Lt; st++) {
        if (tt = lt, _[st] = bt(N, B, _, st), q = 240 & (lt = T[tt][O[_[st]]]), lt &= 15, C[st] = ht = T[lt][5], q > 0) if (q === 16) {
          for (rt = ft; rt < st; rt++) C[rt] = 1;
          ft = -1;
        } else ft = -1;
        if (T[lt][6]) ft === -1 && (ft = st);
        else if (ft > -1) {
          for (rt = ft; rt < st; rt++) C[rt] = ht;
          ft = -1;
        }
        B[st] === "B" && (C[st] = 0), z.hiLevel |= ht;
      }
      o && (function(H, Y, nt) {
        for (var ot = 0; ot < nt; ot++) if (H[ot] === "S") {
          Y[ot] = G;
          for (var at = ot - 1; at >= 0 && H[at] === "WS"; at--) Y[at] = G;
        }
      })(B, C, Lt);
    }, j = function(N, C, z, q, rt) {
      if (!(rt.hiLevel < N)) {
        if (N === 1 && G === 1 && !i) return C.reverse(), void (z && z.reverse());
        for (var st, ht, tt, ft, Lt = C.length, lt = 0; lt < Lt; ) {
          if (q[lt] >= N) {
            for (tt = lt + 1; tt < Lt && q[tt] >= N; ) tt++;
            for (ft = lt, ht = tt - 1; ft < ht; ft++, ht--) st = C[ft], C[ft] = C[ht], C[ht] = st, z && (st = z[ft], z[ft] = z[ht], z[ht] = st);
            lt = tt;
          }
          lt++;
        }
      }
    }, J = function(N, C, z) {
      var q = N.split(""), rt = { hiLevel: G };
      return z || (z = []), $(q, z, rt), (function(st, ht, tt) {
        if (tt.hiLevel !== 0 && p) for (var ft, Lt = 0; Lt < st.length; Lt++) ht[Lt] === 1 && (ft = M.indexOf(st[Lt])) >= 0 && (st[Lt] = M[ft + 1]);
      })(q, z, rt), j(2, q, C, z, rt), j(1, q, C, z, rt), q.join("");
    };
    return this.__bidiEngine__.doBidiReorder = function(N, C, z) {
      if ((function(rt, st) {
        if (st) for (var ht = 0; ht < rt.length; ht++) st[ht] = ht;
        l === void 0 && (l = it(rt)), c === void 0 && (c = it(rt));
      })(N, C), u || !f || c) if (u && f && l ^ c) G = l ? 1 : 0, N = dt(N, C, z);
      else if (!u && f && c) G = l ? 1 : 0, N = J(N, C, z), N = dt(N, C);
      else if (!u || l || f || c) {
        if (u && !f && l ^ c) N = dt(N, C), l ? (G = 0, N = J(N, C, z)) : (G = 1, N = J(N, C, z), N = dt(N, C));
        else if (u && l && !f && c) G = 1, N = J(N, C, z), N = dt(N, C);
        else if (!u && !f && l ^ c) {
          var q = p;
          l ? (G = 1, N = J(N, C, z), G = 0, p = false, N = J(N, C, z), p = q) : (G = 0, N = J(N, C, z), N = dt(N, C), G = 1, p = false, N = J(N, C, z), p = q, N = dt(N, C));
        }
      } else G = 0, N = J(N, C, z);
      else G = l ? 1 : 0, N = J(N, C, z);
      return N;
    }, this.__bidiEngine__.setOptions = function(N) {
      N && (u = N.isInputVisual, f = N.isOutputVisual, l = N.isInputRtl, c = N.isOutputRtl, p = N.isSymmetricSwapping);
    }, this.__bidiEngine__.setOptions(r), this.__bidiEngine__;
  };
  var n = ["BN", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "S", "B", "S", "WS", "B", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "B", "B", "B", "S", "WS", "N", "N", "ET", "ET", "ET", "N", "N", "N", "N", "N", "ES", "CS", "ES", "CS", "CS", "EN", "EN", "EN", "EN", "EN", "EN", "EN", "EN", "EN", "EN", "CS", "N", "N", "N", "N", "N", "N", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "N", "N", "N", "N", "N", "N", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "N", "N", "N", "N", "BN", "BN", "BN", "BN", "BN", "BN", "B", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "BN", "CS", "N", "ET", "ET", "ET", "ET", "N", "N", "N", "N", "L", "N", "N", "BN", "N", "N", "ET", "ET", "EN", "EN", "N", "L", "N", "N", "N", "EN", "L", "N", "N", "N", "N", "N", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "N", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "N", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "N", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "N", "N", "L", "L", "L", "L", "L", "L", "L", "N", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "N", "L", "N", "N", "N", "N", "N", "ET", "N", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "R", "NSM", "R", "NSM", "NSM", "R", "NSM", "NSM", "R", "NSM", "N", "N", "N", "N", "N", "N", "N", "N", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "N", "N", "N", "N", "N", "R", "R", "R", "R", "R", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "AN", "AN", "AN", "AN", "AN", "AN", "N", "N", "AL", "ET", "ET", "AL", "CS", "AL", "N", "N", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "AL", "AL", "N", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "AN", "AN", "AN", "AN", "AN", "AN", "AN", "AN", "AN", "AN", "ET", "AN", "AN", "AL", "AL", "AL", "NSM", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "AN", "N", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "AL", "AL", "NSM", "NSM", "N", "NSM", "NSM", "NSM", "NSM", "AL", "AL", "EN", "EN", "EN", "EN", "EN", "EN", "EN", "EN", "EN", "EN", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "N", "AL", "AL", "NSM", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "N", "N", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "AL", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "R", "R", "N", "N", "N", "N", "R", "N", "N", "N", "N", "N", "WS", "WS", "WS", "WS", "WS", "WS", "WS", "WS", "WS", "WS", "WS", "BN", "BN", "BN", "L", "R", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "WS", "B", "LRE", "RLE", "PDF", "LRO", "RLO", "CS", "ET", "ET", "ET", "ET", "ET", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "CS", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "WS", "BN", "BN", "BN", "BN", "BN", "N", "LRI", "RLI", "FSI", "PDI", "BN", "BN", "BN", "BN", "BN", "BN", "EN", "L", "N", "N", "EN", "EN", "EN", "EN", "EN", "EN", "ES", "ES", "N", "N", "N", "L", "EN", "EN", "EN", "EN", "EN", "EN", "EN", "EN", "EN", "EN", "ES", "ES", "N", "N", "N", "N", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "N", "N", "N", "ET", "ET", "ET", "ET", "ET", "ET", "ET", "ET", "ET", "ET", "ET", "ET", "ET", "ET", "ET", "ET", "ET", "ET", "ET", "ET", "ET", "ET", "ET", "ET", "ET", "ET", "ET", "ET", "ET", "ET", "ET", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "L", "L", "L", "L", "L", "L", "L", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "L", "L", "L", "L", "L", "N", "N", "N", "N", "N", "R", "NSM", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "ES", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "N", "R", "R", "R", "R", "R", "N", "R", "N", "R", "R", "N", "R", "R", "N", "R", "R", "R", "R", "R", "R", "R", "R", "R", "R", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "NSM", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "CS", "N", "CS", "N", "N", "CS", "N", "N", "N", "N", "N", "N", "N", "N", "N", "ET", "N", "N", "ES", "ES", "N", "N", "N", "N", "N", "ET", "ET", "N", "N", "N", "N", "N", "AL", "AL", "AL", "AL", "AL", "N", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "AL", "N", "N", "BN", "N", "N", "N", "ET", "ET", "ET", "N", "N", "N", "N", "N", "ES", "CS", "ES", "CS", "CS", "EN", "EN", "EN", "EN", "EN", "EN", "EN", "EN", "EN", "EN", "CS", "N", "N", "N", "N", "N", "N", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "N", "N", "N", "N", "N", "N", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "L", "N", "N", "N", "L", "L", "L", "L", "L", "L", "N", "N", "L", "L", "L", "L", "L", "L", "N", "N", "L", "L", "L", "L", "L", "L", "N", "N", "L", "L", "L", "N", "N", "N", "ET", "ET", "N", "N", "N", "ET", "ET", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N"], e = new t3.__bidiEngine__({ isInputVisual: true });
  t3.API.events.push(["postProcessText", function(r) {
    var i = r.text;
    r.x, r.y;
    var o = r.options || {};
    r.mutex, o.lang;
    var u = [];
    if (o.isInputVisual = typeof o.isInputVisual != "boolean" || o.isInputVisual, e.setOptions(o), Object.prototype.toString.call(i) === "[object Array]") {
      var l = 0;
      for (u = [], l = 0; l < i.length; l += 1) Object.prototype.toString.call(i[l]) === "[object Array]" ? u.push([e.doBidiReorder(i[l][0]), i[l][1], i[l][2]]) : u.push([e.doBidiReorder(i[l])]);
      r.text = u;
    } else r.text = e.doBidiReorder(i);
    e.setOptions({ isInputVisual: true });
  }]);
})(jt), jt.API.TTFFont = (function() {
  function t3(n) {
    var e;
    if (this.rawData = n, e = this.contents = new yi(n), this.contents.pos = 4, e.readString(4) === "ttcf") throw new Error("TTCF not supported.");
    e.pos = 0, this.parse(), this.subset = new Fd(this), this.registerTTF();
  }
  return t3.open = function(n) {
    return new t3(n);
  }, t3.prototype.parse = function() {
    return this.directory = new bd(this.contents), this.head = new _d(this), this.name = new Nd(this), this.cmap = new zf(this), this.toUnicode = {}, this.hhea = new yd(this), this.maxp = new Sd(this), this.hmtx = new kd(this), this.post = new Ad(this), this.os2 = new xd(this), this.loca = new Id(this), this.glyf = new Pd(this), this.ascender = this.os2.exists && this.os2.ascender || this.hhea.ascender, this.decender = this.os2.exists && this.os2.decender || this.hhea.decender, this.lineGap = this.os2.exists && this.os2.lineGap || this.hhea.lineGap, this.bbox = [this.head.xMin, this.head.yMin, this.head.xMax, this.head.yMax];
  }, t3.prototype.registerTTF = function() {
    var n, e, r, i, o;
    if (this.scaleFactor = 1e3 / this.head.unitsPerEm, this.bbox = (function() {
      var u, l, f, c;
      for (c = [], u = 0, l = (f = this.bbox).length; u < l; u++) n = f[u], c.push(Math.round(n * this.scaleFactor));
      return c;
    }).call(this), this.stemV = 0, this.post.exists ? (r = 255 & (i = this.post.italic_angle), 32768 & (e = i >> 16) && (e = -(1 + (65535 ^ e))), this.italicAngle = +(e + "." + r)) : this.italicAngle = 0, this.ascender = Math.round(this.ascender * this.scaleFactor), this.decender = Math.round(this.decender * this.scaleFactor), this.lineGap = Math.round(this.lineGap * this.scaleFactor), this.capHeight = this.os2.exists && this.os2.capHeight || this.ascender, this.xHeight = this.os2.exists && this.os2.xHeight || 0, this.familyClass = (this.os2.exists && this.os2.familyClass || 0) >> 8, this.isSerif = (o = this.familyClass) === 1 || o === 2 || o === 3 || o === 4 || o === 5 || o === 7, this.isScript = this.familyClass === 10, this.flags = 0, this.post.isFixedPitch && (this.flags |= 1), this.isSerif && (this.flags |= 2), this.isScript && (this.flags |= 8), this.italicAngle !== 0 && (this.flags |= 64), this.flags |= 32, !this.cmap.unicode) throw new Error("No unicode cmap for font");
  }, t3.prototype.characterToGlyph = function(n) {
    var e;
    return ((e = this.cmap.unicode) != null ? e.codeMap[n] : void 0) || 0;
  }, t3.prototype.widthOfGlyph = function(n) {
    var e;
    return e = 1e3 / this.head.unitsPerEm, this.hmtx.forGlyph(n).advance * e;
  }, t3.prototype.widthOfString = function(n, e, r) {
    var i, o, u, l;
    for (u = 0, o = 0, l = (n = "" + n).length; 0 <= l ? o < l : o > l; o = 0 <= l ? ++o : --o) i = n.charCodeAt(o), u += this.widthOfGlyph(this.characterToGlyph(i)) + r * (1e3 / e) || 0;
    return u * (e / 1e3);
  }, t3.prototype.lineHeight = function(n, e) {
    var r;
    return e == null && (e = false), r = e ? this.lineGap : 0, (this.ascender + r - this.decender) / 1e3 * n;
  }, t3;
})();
var vr, yi = (function() {
  function t3(n) {
    this.data = n ?? [], this.pos = 0, this.length = this.data.length;
  }
  return t3.prototype.readByte = function() {
    return this.data[this.pos++];
  }, t3.prototype.writeByte = function(n) {
    return this.data[this.pos++] = n;
  }, t3.prototype.readUInt32 = function() {
    return 16777216 * this.readByte() + (this.readByte() << 16) + (this.readByte() << 8) + this.readByte();
  }, t3.prototype.writeUInt32 = function(n) {
    return this.writeByte(n >>> 24 & 255), this.writeByte(n >> 16 & 255), this.writeByte(n >> 8 & 255), this.writeByte(255 & n);
  }, t3.prototype.readInt32 = function() {
    var n;
    return (n = this.readUInt32()) >= 2147483648 ? n - 4294967296 : n;
  }, t3.prototype.writeInt32 = function(n) {
    return n < 0 && (n += 4294967296), this.writeUInt32(n);
  }, t3.prototype.readUInt16 = function() {
    return this.readByte() << 8 | this.readByte();
  }, t3.prototype.writeUInt16 = function(n) {
    return this.writeByte(n >> 8 & 255), this.writeByte(255 & n);
  }, t3.prototype.readInt16 = function() {
    var n;
    return (n = this.readUInt16()) >= 32768 ? n - 65536 : n;
  }, t3.prototype.writeInt16 = function(n) {
    return n < 0 && (n += 65536), this.writeUInt16(n);
  }, t3.prototype.readString = function(n) {
    var e, r;
    for (r = [], e = 0; 0 <= n ? e < n : e > n; e = 0 <= n ? ++e : --e) r[e] = String.fromCharCode(this.readByte());
    return r.join("");
  }, t3.prototype.writeString = function(n) {
    var e, r, i;
    for (i = [], e = 0, r = n.length; 0 <= r ? e < r : e > r; e = 0 <= r ? ++e : --e) i.push(this.writeByte(n.charCodeAt(e)));
    return i;
  }, t3.prototype.readShort = function() {
    return this.readInt16();
  }, t3.prototype.writeShort = function(n) {
    return this.writeInt16(n);
  }, t3.prototype.readLongLong = function() {
    var n, e, r, i, o, u, l, f;
    return n = this.readByte(), e = this.readByte(), r = this.readByte(), i = this.readByte(), o = this.readByte(), u = this.readByte(), l = this.readByte(), f = this.readByte(), 128 & n ? -1 * (72057594037927940 * (255 ^ n) + 281474976710656 * (255 ^ e) + 1099511627776 * (255 ^ r) + 4294967296 * (255 ^ i) + 16777216 * (255 ^ o) + 65536 * (255 ^ u) + 256 * (255 ^ l) + (255 ^ f) + 1) : 72057594037927940 * n + 281474976710656 * e + 1099511627776 * r + 4294967296 * i + 16777216 * o + 65536 * u + 256 * l + f;
  }, t3.prototype.writeLongLong = function(n) {
    var e, r;
    return e = Math.floor(n / 4294967296), r = 4294967295 & n, this.writeByte(e >> 24 & 255), this.writeByte(e >> 16 & 255), this.writeByte(e >> 8 & 255), this.writeByte(255 & e), this.writeByte(r >> 24 & 255), this.writeByte(r >> 16 & 255), this.writeByte(r >> 8 & 255), this.writeByte(255 & r);
  }, t3.prototype.readInt = function() {
    return this.readInt32();
  }, t3.prototype.writeInt = function(n) {
    return this.writeInt32(n);
  }, t3.prototype.read = function(n) {
    var e, r;
    for (e = [], r = 0; 0 <= n ? r < n : r > n; r = 0 <= n ? ++r : --r) e.push(this.readByte());
    return e;
  }, t3.prototype.write = function(n) {
    var e, r, i, o;
    for (o = [], r = 0, i = n.length; r < i; r++) e = n[r], o.push(this.writeByte(e));
    return o;
  }, t3;
})(), bd = (function() {
  var t3;
  function n(e) {
    var r, i, o;
    for (this.scalarType = e.readInt(), this.tableCount = e.readShort(), this.searchRange = e.readShort(), this.entrySelector = e.readShort(), this.rangeShift = e.readShort(), this.tables = {}, i = 0, o = this.tableCount; 0 <= o ? i < o : i > o; i = 0 <= o ? ++i : --i) r = { tag: e.readString(4), checksum: e.readInt(), offset: e.readInt(), length: e.readInt() }, this.tables[r.tag] = r;
  }
  return n.prototype.encode = function(e) {
    var r, i, o, u, l, f, c, p, x, L, g, O, P;
    for (P in g = Object.keys(e).length, f = Math.log(2), x = 16 * Math.floor(Math.log(g) / f), u = Math.floor(x / f), p = 16 * g - x, (i = new yi()).writeInt(this.scalarType), i.writeShort(g), i.writeShort(x), i.writeShort(u), i.writeShort(p), o = 16 * g, c = i.pos + o, l = null, O = [], e) for (L = e[P], i.writeString(P), i.writeInt(t3(L)), i.writeInt(c), i.writeInt(L.length), O = O.concat(L), P === "head" && (l = c), c += L.length; c % 4; ) O.push(0), c++;
    return i.write(O), r = 2981146554 - t3(i.data), i.pos = l + 8, i.writeUInt32(r), i.data;
  }, t3 = function(e) {
    var r, i, o, u;
    for (e = Hf.call(e); e.length % 4; ) e.push(0);
    for (o = new yi(e), i = 0, r = 0, u = e.length; r < u; r = r += 4) i += o.readUInt32();
    return 4294967295 & i;
  }, n;
})(), wd = {}.hasOwnProperty, Ir = function(t3, n) {
  for (var e in n) wd.call(n, e) && (t3[e] = n[e]);
  function r() {
    this.constructor = t3;
  }
  return r.prototype = n.prototype, t3.prototype = new r(), t3.__super__ = n.prototype, t3;
};
vr = (function() {
  function t3(n) {
    var e;
    this.file = n, e = this.file.directory.tables[this.tag], this.exists = !!e, e && (this.offset = e.offset, this.length = e.length, this.parse(this.file.contents));
  }
  return t3.prototype.parse = function() {
  }, t3.prototype.encode = function() {
  }, t3.prototype.raw = function() {
    return this.exists ? (this.file.contents.pos = this.offset, this.file.contents.read(this.length)) : null;
  }, t3;
})();
var _d = (function() {
  function t3() {
    return t3.__super__.constructor.apply(this, arguments);
  }
  return Ir(t3, vr), t3.prototype.tag = "head", t3.prototype.parse = function(n) {
    return n.pos = this.offset, this.version = n.readInt(), this.revision = n.readInt(), this.checkSumAdjustment = n.readInt(), this.magicNumber = n.readInt(), this.flags = n.readShort(), this.unitsPerEm = n.readShort(), this.created = n.readLongLong(), this.modified = n.readLongLong(), this.xMin = n.readShort(), this.yMin = n.readShort(), this.xMax = n.readShort(), this.yMax = n.readShort(), this.macStyle = n.readShort(), this.lowestRecPPEM = n.readShort(), this.fontDirectionHint = n.readShort(), this.indexToLocFormat = n.readShort(), this.glyphDataFormat = n.readShort();
  }, t3.prototype.encode = function(n) {
    var e;
    return (e = new yi()).writeInt(this.version), e.writeInt(this.revision), e.writeInt(this.checkSumAdjustment), e.writeInt(this.magicNumber), e.writeShort(this.flags), e.writeShort(this.unitsPerEm), e.writeLongLong(this.created), e.writeLongLong(this.modified), e.writeShort(this.xMin), e.writeShort(this.yMin), e.writeShort(this.xMax), e.writeShort(this.yMax), e.writeShort(this.macStyle), e.writeShort(this.lowestRecPPEM), e.writeShort(this.fontDirectionHint), e.writeShort(n), e.writeShort(this.glyphDataFormat), e.data;
  }, t3;
})(), Oc = (function() {
  function t3(n, e) {
    var r, i, o, u, l, f, c, p, x, L, g, O, P, M, k, V, G;
    switch (this.platformID = n.readUInt16(), this.encodingID = n.readShort(), this.offset = e + n.readInt(), x = n.pos, n.pos = this.offset, this.format = n.readUInt16(), this.length = n.readUInt16(), this.language = n.readUInt16(), this.isUnicode = this.platformID === 3 && this.encodingID === 1 && this.format === 4 || this.platformID === 0 && this.format === 4, this.codeMap = {}, this.format) {
      case 0:
        for (f = 0; f < 256; ++f) this.codeMap[f] = n.readByte();
        break;
      case 4:
        for (g = n.readUInt16(), L = g / 2, n.pos += 6, o = (function() {
          var D, it;
          for (it = [], f = D = 0; 0 <= L ? D < L : D > L; f = 0 <= L ? ++D : --D) it.push(n.readUInt16());
          return it;
        })(), n.pos += 2, P = (function() {
          var D, it;
          for (it = [], f = D = 0; 0 <= L ? D < L : D > L; f = 0 <= L ? ++D : --D) it.push(n.readUInt16());
          return it;
        })(), c = (function() {
          var D, it;
          for (it = [], f = D = 0; 0 <= L ? D < L : D > L; f = 0 <= L ? ++D : --D) it.push(n.readUInt16());
          return it;
        })(), p = (function() {
          var D, it;
          for (it = [], f = D = 0; 0 <= L ? D < L : D > L; f = 0 <= L ? ++D : --D) it.push(n.readUInt16());
          return it;
        })(), i = (this.length - n.pos + this.offset) / 2, l = (function() {
          var D, it;
          for (it = [], f = D = 0; 0 <= i ? D < i : D > i; f = 0 <= i ? ++D : --D) it.push(n.readUInt16());
          return it;
        })(), f = k = 0, G = o.length; k < G; f = ++k) for (M = o[f], r = V = O = P[f]; O <= M ? V <= M : V >= M; r = O <= M ? ++V : --V) p[f] === 0 ? u = r + c[f] : (u = l[p[f] / 2 + (r - O) - (L - f)] || 0) !== 0 && (u += c[f]), this.codeMap[r] = 65535 & u;
    }
    n.pos = x;
  }
  return t3.encode = function(n, e) {
    var r, i, o, u, l, f, c, p, x, L, g, O, P, M, k, V, G, D, it, bt, dt, $, j, J, N, C, z, q, rt, st, ht, tt, ft, Lt, lt, _, T, B, H, Y, nt, ot, at, vt, xt, kt;
    switch (q = new yi(), u = Object.keys(n).sort(function(Pt, ut) {
      return Pt - ut;
    }), e) {
      case "macroman":
        for (P = 0, M = (function() {
          var Pt = [];
          for (O = 0; O < 256; ++O) Pt.push(0);
          return Pt;
        })(), V = { 0: 0 }, o = {}, rt = 0, ft = u.length; rt < ft; rt++) V[at = n[i = u[rt]]] == null && (V[at] = ++P), o[i] = { old: n[i], new: V[n[i]] }, M[i] = V[n[i]];
        return q.writeUInt16(1), q.writeUInt16(0), q.writeUInt32(12), q.writeUInt16(0), q.writeUInt16(262), q.writeUInt16(0), q.write(M), { charMap: o, subtable: q.data, maxGlyphID: P + 1 };
      case "unicode":
        for (C = [], x = [], G = 0, V = {}, r = {}, k = c = null, st = 0, Lt = u.length; st < Lt; st++) V[it = n[i = u[st]]] == null && (V[it] = ++G), r[i] = { old: it, new: V[it] }, l = V[it] - i, k != null && l === c || (k && x.push(k), C.push(i), c = l), k = i;
        for (k && x.push(k), x.push(65535), C.push(65535), J = 2 * (j = C.length), $ = 2 * Math.pow(Math.log(j) / Math.LN2, 2), L = Math.log($ / 2) / Math.LN2, dt = 2 * j - $, f = [], bt = [], g = [], O = ht = 0, lt = C.length; ht < lt; O = ++ht) {
          if (N = C[O], p = x[O], N === 65535) {
            f.push(0), bt.push(0);
            break;
          }
          if (N - (z = r[N].new) >= 32768) for (f.push(0), bt.push(2 * (g.length + j - O)), i = tt = N; N <= p ? tt <= p : tt >= p; i = N <= p ? ++tt : --tt) g.push(r[i].new);
          else f.push(z - N), bt.push(0);
        }
        for (q.writeUInt16(3), q.writeUInt16(1), q.writeUInt32(12), q.writeUInt16(4), q.writeUInt16(16 + 8 * j + 2 * g.length), q.writeUInt16(0), q.writeUInt16(J), q.writeUInt16($), q.writeUInt16(L), q.writeUInt16(dt), nt = 0, _ = x.length; nt < _; nt++) i = x[nt], q.writeUInt16(i);
        for (q.writeUInt16(0), ot = 0, T = C.length; ot < T; ot++) i = C[ot], q.writeUInt16(i);
        for (vt = 0, B = f.length; vt < B; vt++) l = f[vt], q.writeUInt16(l);
        for (xt = 0, H = bt.length; xt < H; xt++) D = bt[xt], q.writeUInt16(D);
        for (kt = 0, Y = g.length; kt < Y; kt++) P = g[kt], q.writeUInt16(P);
        return { charMap: r, subtable: q.data, maxGlyphID: G + 1 };
    }
  }, t3;
})(), zf = (function() {
  function t3() {
    return t3.__super__.constructor.apply(this, arguments);
  }
  return Ir(t3, vr), t3.prototype.tag = "cmap", t3.prototype.parse = function(n) {
    var e, r, i;
    for (n.pos = this.offset, this.version = n.readUInt16(), i = n.readUInt16(), this.tables = [], this.unicode = null, r = 0; 0 <= i ? r < i : r > i; r = 0 <= i ? ++r : --r) e = new Oc(n, this.offset), this.tables.push(e), e.isUnicode && this.unicode == null && (this.unicode = e);
    return true;
  }, t3.encode = function(n, e) {
    var r, i;
    return e == null && (e = "macroman"), r = Oc.encode(n, e), (i = new yi()).writeUInt16(0), i.writeUInt16(1), r.table = i.data.concat(r.subtable), r;
  }, t3;
})(), yd = (function() {
  function t3() {
    return t3.__super__.constructor.apply(this, arguments);
  }
  return Ir(t3, vr), t3.prototype.tag = "hhea", t3.prototype.parse = function(n) {
    return n.pos = this.offset, this.version = n.readInt(), this.ascender = n.readShort(), this.decender = n.readShort(), this.lineGap = n.readShort(), this.advanceWidthMax = n.readShort(), this.minLeftSideBearing = n.readShort(), this.minRightSideBearing = n.readShort(), this.xMaxExtent = n.readShort(), this.caretSlopeRise = n.readShort(), this.caretSlopeRun = n.readShort(), this.caretOffset = n.readShort(), n.pos += 8, this.metricDataFormat = n.readShort(), this.numberOfMetrics = n.readUInt16();
  }, t3;
})(), xd = (function() {
  function t3() {
    return t3.__super__.constructor.apply(this, arguments);
  }
  return Ir(t3, vr), t3.prototype.tag = "OS/2", t3.prototype.parse = function(n) {
    if (n.pos = this.offset, this.version = n.readUInt16(), this.averageCharWidth = n.readShort(), this.weightClass = n.readUInt16(), this.widthClass = n.readUInt16(), this.type = n.readShort(), this.ySubscriptXSize = n.readShort(), this.ySubscriptYSize = n.readShort(), this.ySubscriptXOffset = n.readShort(), this.ySubscriptYOffset = n.readShort(), this.ySuperscriptXSize = n.readShort(), this.ySuperscriptYSize = n.readShort(), this.ySuperscriptXOffset = n.readShort(), this.ySuperscriptYOffset = n.readShort(), this.yStrikeoutSize = n.readShort(), this.yStrikeoutPosition = n.readShort(), this.familyClass = n.readShort(), this.panose = (function() {
      var e, r;
      for (r = [], e = 0; e < 10; ++e) r.push(n.readByte());
      return r;
    })(), this.charRange = (function() {
      var e, r;
      for (r = [], e = 0; e < 4; ++e) r.push(n.readInt());
      return r;
    })(), this.vendorID = n.readString(4), this.selection = n.readShort(), this.firstCharIndex = n.readShort(), this.lastCharIndex = n.readShort(), this.version > 0 && (this.ascent = n.readShort(), this.descent = n.readShort(), this.lineGap = n.readShort(), this.winAscent = n.readShort(), this.winDescent = n.readShort(), this.codePageRange = (function() {
      var e, r;
      for (r = [], e = 0; e < 2; e = ++e) r.push(n.readInt());
      return r;
    })(), this.version > 1)) return this.xHeight = n.readShort(), this.capHeight = n.readShort(), this.defaultChar = n.readShort(), this.breakChar = n.readShort(), this.maxContext = n.readShort();
  }, t3;
})(), Ad = (function() {
  function t3() {
    return t3.__super__.constructor.apply(this, arguments);
  }
  return Ir(t3, vr), t3.prototype.tag = "post", t3.prototype.parse = function(n) {
    var e, r, i;
    switch (n.pos = this.offset, this.format = n.readInt(), this.italicAngle = n.readInt(), this.underlinePosition = n.readShort(), this.underlineThickness = n.readShort(), this.isFixedPitch = n.readInt(), this.minMemType42 = n.readInt(), this.maxMemType42 = n.readInt(), this.minMemType1 = n.readInt(), this.maxMemType1 = n.readInt(), this.format) {
      case 65536:
      case 196608:
        break;
      case 131072:
        var o;
        for (r = n.readUInt16(), this.glyphNameIndex = [], o = 0; 0 <= r ? o < r : o > r; o = 0 <= r ? ++o : --o) this.glyphNameIndex.push(n.readUInt16());
        for (this.names = [], i = []; n.pos < this.offset + this.length; ) e = n.readByte(), i.push(this.names.push(n.readString(e)));
        return i;
      case 151552:
        return r = n.readUInt16(), this.offsets = n.read(r);
      case 262144:
        return this.map = (function() {
          var u, l, f;
          for (f = [], o = u = 0, l = this.file.maxp.numGlyphs; 0 <= l ? u < l : u > l; o = 0 <= l ? ++u : --u) f.push(n.readUInt32());
          return f;
        }).call(this);
    }
  }, t3;
})(), Ld = function(t3, n) {
  this.raw = t3, this.length = t3.length, this.platformID = n.platformID, this.encodingID = n.encodingID, this.languageID = n.languageID;
}, Nd = (function() {
  function t3() {
    return t3.__super__.constructor.apply(this, arguments);
  }
  return Ir(t3, vr), t3.prototype.tag = "name", t3.prototype.parse = function(n) {
    var e, r, i, o, u, l, f, c, p, x, L;
    for (n.pos = this.offset, n.readShort(), e = n.readShort(), l = n.readShort(), r = [], o = 0; 0 <= e ? o < e : o > e; o = 0 <= e ? ++o : --o) r.push({ platformID: n.readShort(), encodingID: n.readShort(), languageID: n.readShort(), nameID: n.readShort(), length: n.readShort(), offset: this.offset + l + n.readShort() });
    for (f = {}, o = p = 0, x = r.length; p < x; o = ++p) i = r[o], n.pos = i.offset, c = n.readString(i.length), u = new Ld(c, i), f[L = i.nameID] == null && (f[L] = []), f[i.nameID].push(u);
    this.strings = f, this.copyright = f[0], this.fontFamily = f[1], this.fontSubfamily = f[2], this.uniqueSubfamily = f[3], this.fontName = f[4], this.version = f[5];
    try {
      this.postscriptName = f[6][0].raw.replace(/[\x00-\x19\x80-\xff]/g, "");
    } catch {
      this.postscriptName = f[4][0].raw.replace(/[\x00-\x19\x80-\xff]/g, "");
    }
    return this.trademark = f[7], this.manufacturer = f[8], this.designer = f[9], this.description = f[10], this.vendorUrl = f[11], this.designerUrl = f[12], this.license = f[13], this.licenseUrl = f[14], this.preferredFamily = f[15], this.preferredSubfamily = f[17], this.compatibleFull = f[18], this.sampleText = f[19];
  }, t3;
})(), Sd = (function() {
  function t3() {
    return t3.__super__.constructor.apply(this, arguments);
  }
  return Ir(t3, vr), t3.prototype.tag = "maxp", t3.prototype.parse = function(n) {
    return n.pos = this.offset, this.version = n.readInt(), this.numGlyphs = n.readUInt16(), this.maxPoints = n.readUInt16(), this.maxContours = n.readUInt16(), this.maxCompositePoints = n.readUInt16(), this.maxComponentContours = n.readUInt16(), this.maxZones = n.readUInt16(), this.maxTwilightPoints = n.readUInt16(), this.maxStorage = n.readUInt16(), this.maxFunctionDefs = n.readUInt16(), this.maxInstructionDefs = n.readUInt16(), this.maxStackElements = n.readUInt16(), this.maxSizeOfInstructions = n.readUInt16(), this.maxComponentElements = n.readUInt16(), this.maxComponentDepth = n.readUInt16();
  }, t3;
})(), kd = (function() {
  function t3() {
    return t3.__super__.constructor.apply(this, arguments);
  }
  return Ir(t3, vr), t3.prototype.tag = "hmtx", t3.prototype.parse = function(n) {
    var e, r, i, o, u, l, f;
    for (n.pos = this.offset, this.metrics = [], e = 0, l = this.file.hhea.numberOfMetrics; 0 <= l ? e < l : e > l; e = 0 <= l ? ++e : --e) this.metrics.push({ advance: n.readUInt16(), lsb: n.readInt16() });
    for (i = this.file.maxp.numGlyphs - this.file.hhea.numberOfMetrics, this.leftSideBearings = (function() {
      var c, p;
      for (p = [], e = c = 0; 0 <= i ? c < i : c > i; e = 0 <= i ? ++c : --c) p.push(n.readInt16());
      return p;
    })(), this.widths = (function() {
      var c, p, x, L;
      for (L = [], c = 0, p = (x = this.metrics).length; c < p; c++) o = x[c], L.push(o.advance);
      return L;
    }).call(this), r = this.widths[this.widths.length - 1], f = [], e = u = 0; 0 <= i ? u < i : u > i; e = 0 <= i ? ++u : --u) f.push(this.widths.push(r));
    return f;
  }, t3.prototype.forGlyph = function(n) {
    return n in this.metrics ? this.metrics[n] : { advance: this.metrics[this.metrics.length - 1].advance, lsb: this.leftSideBearings[n - this.metrics.length] };
  }, t3;
})(), Hf = [].slice, Pd = (function() {
  function t3() {
    return t3.__super__.constructor.apply(this, arguments);
  }
  return Ir(t3, vr), t3.prototype.tag = "glyf", t3.prototype.parse = function() {
    return this.cache = {};
  }, t3.prototype.glyphFor = function(n) {
    var e, r, i, o, u, l, f, c, p, x;
    return n in this.cache ? this.cache[n] : (o = this.file.loca, e = this.file.contents, r = o.indexOf(n), (i = o.lengthOf(n)) === 0 ? this.cache[n] = null : (e.pos = this.offset + r, u = (l = new yi(e.read(i))).readShort(), c = l.readShort(), x = l.readShort(), f = l.readShort(), p = l.readShort(), this.cache[n] = u === -1 ? new Ed(l, c, x, f, p) : new Cd(l, u, c, x, f, p), this.cache[n]));
  }, t3.prototype.encode = function(n, e, r) {
    var i, o, u, l, f;
    for (u = [], o = [], l = 0, f = e.length; l < f; l++) i = n[e[l]], o.push(u.length), i && (u = u.concat(i.encode(r)));
    return o.push(u.length), { table: u, offsets: o };
  }, t3;
})(), Cd = (function() {
  function t3(n, e, r, i, o, u) {
    this.raw = n, this.numberOfContours = e, this.xMin = r, this.yMin = i, this.xMax = o, this.yMax = u, this.compound = false;
  }
  return t3.prototype.encode = function() {
    return this.raw.data;
  }, t3;
})(), Ed = (function() {
  function t3(n, e, r, i, o) {
    var u, l;
    for (this.raw = n, this.xMin = e, this.yMin = r, this.xMax = i, this.yMax = o, this.compound = true, this.glyphIDs = [], this.glyphOffsets = [], u = this.raw; l = u.readShort(), this.glyphOffsets.push(u.pos), this.glyphIDs.push(u.readUInt16()), 32 & l; ) u.pos += 1 & l ? 4 : 2, 128 & l ? u.pos += 8 : 64 & l ? u.pos += 4 : 8 & l && (u.pos += 2);
  }
  return t3.prototype.encode = function() {
    var n, e, r;
    for (e = new yi(Hf.call(this.raw.data)), n = 0, r = this.glyphIDs.length; n < r; ++n) e.pos = this.glyphOffsets[n];
    return e.data;
  }, t3;
})(), Id = (function() {
  function t3() {
    return t3.__super__.constructor.apply(this, arguments);
  }
  return Ir(t3, vr), t3.prototype.tag = "loca", t3.prototype.parse = function(n) {
    var e, r;
    return n.pos = this.offset, e = this.file.head.indexToLocFormat, this.offsets = e === 0 ? (function() {
      var i, o;
      for (o = [], r = 0, i = this.length; r < i; r += 2) o.push(2 * n.readUInt16());
      return o;
    }).call(this) : (function() {
      var i, o;
      for (o = [], r = 0, i = this.length; r < i; r += 4) o.push(n.readUInt32());
      return o;
    }).call(this);
  }, t3.prototype.indexOf = function(n) {
    return this.offsets[n];
  }, t3.prototype.lengthOf = function(n) {
    return this.offsets[n + 1] - this.offsets[n];
  }, t3.prototype.encode = function(n, e) {
    for (var r = new Uint32Array(this.offsets.length), i = 0, o = 0, u = 0; u < r.length; ++u) if (r[u] = i, o < e.length && e[o] == u) {
      ++o, r[u] = i;
      var l = this.offsets[u], f = this.offsets[u + 1] - l;
      f > 0 && (i += f);
    }
    for (var c = new Array(4 * r.length), p = 0; p < r.length; ++p) c[4 * p + 3] = 255 & r[p], c[4 * p + 2] = (65280 & r[p]) >> 8, c[4 * p + 1] = (16711680 & r[p]) >> 16, c[4 * p] = (4278190080 & r[p]) >> 24;
    return c;
  }, t3;
})(), Fd = (function() {
  function t3(n) {
    this.font = n, this.subset = {}, this.unicodes = {}, this.next = 33;
  }
  return t3.prototype.generateCmap = function() {
    var n, e, r, i, o;
    for (e in i = this.font.cmap.tables[0].codeMap, n = {}, o = this.subset) r = o[e], n[e] = i[r];
    return n;
  }, t3.prototype.glyphsFor = function(n) {
    var e, r, i, o, u, l, f;
    for (i = {}, u = 0, l = n.length; u < l; u++) i[o = n[u]] = this.font.glyf.glyphFor(o);
    for (o in e = [], i) (r = i[o]) != null && r.compound && e.push.apply(e, r.glyphIDs);
    if (e.length > 0) for (o in f = this.glyphsFor(e)) r = f[o], i[o] = r;
    return i;
  }, t3.prototype.encode = function(n, e) {
    var r, i, o, u, l, f, c, p, x, L, g, O, P, M, k;
    for (i in r = zf.encode(this.generateCmap(), "unicode"), u = this.glyphsFor(n), g = { 0: 0 }, k = r.charMap) g[(f = k[i]).old] = f.new;
    for (O in L = r.maxGlyphID, u) O in g || (g[O] = L++);
    return p = (function(V) {
      var G, D;
      for (G in D = {}, V) D[V[G]] = G;
      return D;
    })(g), x = Object.keys(p).sort(function(V, G) {
      return V - G;
    }), P = (function() {
      var V, G, D;
      for (D = [], V = 0, G = x.length; V < G; V++) l = x[V], D.push(p[l]);
      return D;
    })(), o = this.font.glyf.encode(u, P, g), c = this.font.loca.encode(o.offsets, P), M = { cmap: this.font.cmap.raw(), glyf: o.table, loca: c, hmtx: this.font.hmtx.raw(), hhea: this.font.hhea.raw(), maxp: this.font.maxp.raw(), post: this.font.post.raw(), name: this.font.name.raw(), head: this.font.head.encode(e) }, this.font.os2.exists && (M["OS/2"] = this.font.os2.raw()), this.font.directory.encode(M);
  }, t3;
})();
jt.API.PDFObject = (function() {
  var t3;
  function n() {
  }
  return t3 = function(e, r) {
    return (Array(r + 1).join("0") + e).slice(-r);
  }, n.convert = function(e) {
    var r, i, o, u;
    if (Array.isArray(e)) return "[" + (function() {
      var l, f, c;
      for (c = [], l = 0, f = e.length; l < f; l++) r = e[l], c.push(n.convert(r));
      return c;
    })().join(" ") + "]";
    if (typeof e == "string") return "/" + e;
    if (e != null && e.isString) return "(" + e + ")";
    if (e instanceof Date) return "(D:" + t3(e.getUTCFullYear(), 4) + t3(e.getUTCMonth(), 2) + t3(e.getUTCDate(), 2) + t3(e.getUTCHours(), 2) + t3(e.getUTCMinutes(), 2) + t3(e.getUTCSeconds(), 2) + "Z)";
    if ({}.toString.call(e) === "[object Object]") {
      for (i in o = ["<<"], e) u = e[i], o.push("/" + i + " " + n.convert(u));
      return o.push(">>"), o.join(`
`);
    }
    return "" + e;
  }, n;
})();
const Od = { border: "0", cellspacing: "0", cellpadding: "0" }, Td = { colspan: "4" }, Rd = { colspan: "5" }, Md = { colspan: "5" }, Bd = { colspan: "2" }, jd = { colspan: "2" }, Dd = { colspan: "2" }, qd = { colspan: "2" }, Ud = { colspan: "3" }, zd = { colspan: "4" }, Hd = { colspan: "5" }, Wd = { colspan: "4" }, Vd = { colspan: "5" }, Gd = ["rowspan"], Zd = { colspan: "3" }, Yd = ["rowspan"], $d = { colspan: "2" }, Kd = { colspan: "5" }, Xd = { colspan: "5" }, Jd = { class: "img-wrap" }, Qd = ["src"], tp = { colspan: "6" }, ep = { class: "img-wrap" }, np = ["src"], rp = ["rowspan"], ip = { colspan: "2" }, ap = { colspan: "2" }, op = { colspan: "5" }, sp = { colspan: "10" }, lp = { colspan: "12", class: "text-left" }, hp = { class: "flex-rbc user-info" }, up = { __name: "craft-library-table", props: { detailList: { type: Array, default: () => [] } }, setup(t3, { expose: n }) {
  const e = t3, r = cs(), i = cs(0), o = cs({}), u = cs([{}, {}, {}]);
  async function l() {
    var c;
    i.value = 0;
    const f = new jt("p", "mm", "a4");
    await su(50);
    for (let p = 0; p < e.detailList.length; p++) {
      i.value = p, o.value = ((c = e.detailList) == null ? void 0 : c[i.value]) || {}, o.value.cappCraftCardStorehouseTemperatureLink = o.value.cappCraftCardStorehouseTemperatureLinkDetailVOList || u.value, o.value.cappCraftCardStorehouseCraftParameterPassLink = o.value.cappCraftCardStorehouseCraftParameterPassLinkDetailVOList || u.value, o.value.cappCraftCardStorehouseMaterialsLink = o.value.cappCraftCardStorehouseMaterialsLinkDetailVOList || u.value, await su(50);
      const L = (await C1(r.value, { scale: 2, useCORS: true, backgroundColor: "#fff" })).toDataURL("image/png"), g = 210 - 44, O = 297 - 50;
      p > 0 && f.addPage(), f.addImage(L, "PNG", 22, 25, g, O);
    }
    f.save(`焊接工艺-${bl(/* @__PURE__ */ new Date(), "{y}{m}{d}")}.pdf`);
  }
  return n({ downloadPdf: l }), (f, c) => {
    var x, L, g, O, P, M, k, V, G, D, it, bt, dt, $, j, J, N, C, z, q, rt, st, ht, tt, ft, Lt;
    const p = I1("empty-text");
    return Gt(), Zt("div", { ref_key: "tableRef", ref: r, class: "craft-library-table" }, [c[33] || (c[33] = Ft("p", null, "焊接工艺规程", -1)), (Gt(), Zt("div", { key: Math.random(), class: "table-wrap" }, [Ft("table", Od, [Ft("tbody", null, [Ft("tr", null, [c[0] || (c[0] = Ft("td", { colspan: "2" }, "工程名称", -1)), ce((Gt(), Zt("td", Td, [fe(de((x = o.value) == null ? void 0 : x.projectName), 1)])), [[p]]), c[1] || (c[1] = Ft("td", { colspan: "2" }, "指导书编号", -1)), ce((Gt(), Zt("td", Rd, [fe(de((L = o.value) == null ? void 0 : L.serialNumber), 1)])), [[p]])]), Ft("tr", null, [c[2] || (c[2] = Ft("td", { colspan: "2" }, "母材钢号", -1)), ce((Gt(), Zt("td", null, [fe(de((g = o.value) == null ? void 0 : g.weldingBaseParentMaterialSteelGrade), 1)])), [[p]]), c[3] || (c[3] = Ft("td", { colspan: "2" }, "板厚或管径×壁厚", -1)), ce((Gt(), Zt("td", null, [fe(de((O = o.value) == null ? void 0 : O.weldingBasePlateThicknessOrPipeDiameter), 1)])), [[p]]), c[4] || (c[4] = Ft("td", { colspan: "2" }, "轧制或热处理状态", -1)), ce((Gt(), Zt("td", Md, [fe(de((P = o.value) == null ? void 0 : P.weldingBaseHotRollingOrHeatTreatmentStatus), 1)])), [[p]])]), c[27] || (c[27] = Ft("tr", null, [Ft("td", { colspan: "2" }, "焊接材料"), Ft("td", null, "生产厂"), Ft("td", { colspan: "2" }, "牌号"), Ft("td", null, "型号"), Ft("td", { colspan: "2" }, "类型"), Ft("td", { colspan: "2" }, "烘干制(℃×h)"), Ft("td", { colspan: "3" }, "备注")], -1)), (Gt(true), Zt(wl, null, _l((M = o.value) == null ? void 0 : M.cappCraftCardStorehouseMaterialsLink, (lt, _) => (Gt(), Zt("tr", { key: `cappCraftCardStorehouseMaterialsLink_${_}` }, [ce((Gt(), Zt("td", Bd, [fe(de(lt.weldingMaterialName), 1)])), [[p]]), ce((Gt(), Zt("td", null, [fe(de(lt.weldingMaterialManufacturingPlant), 1)])), [[p]]), ce((Gt(), Zt("td", jd, [fe(de(lt.weldingMaterialTrademark), 1)])), [[p]]), ce((Gt(), Zt("td", null, [fe(de(lt.weldingMaterialModel), 1)])), [[p]]), ce((Gt(), Zt("td", Dd, [fe(de(lt.weldingMaterialType), 1)])), [[p]]), ce((Gt(), Zt("td", qd, [fe(de(lt.weldingMaterialDryingProcedure), 1)])), [[p]]), ce((Gt(), Zt("td", Ud, [fe(de(lt.remark), 1)])), [[p]])]))), 128)), Ft("tr", null, [c[5] || (c[5] = Ft("td", { colspan: "2" }, "焊接方法", -1)), ce((Gt(), Zt("td", zd, [fe(de((k = o.value) == null ? void 0 : k.weldingBaseWeldingMethod), 1)])), [[p]]), c[6] || (c[6] = Ft("td", { colspan: "2" }, "焊接位置", -1)), ce((Gt(), Zt("td", Hd, [fe(de((V = o.value) == null ? void 0 : V.weldingBaseWeldingPosition), 1)])), [[p]])]), Ft("tr", null, [c[7] || (c[7] = Ft("td", { colspan: "2" }, "焊接设备型号", -1)), ce((Gt(), Zt("td", Wd, [fe(de((G = o.value) == null ? void 0 : G.weldingBaseWeldingDeviceType), 1)])), [[p]]), c[8] || (c[8] = Ft("td", { colspan: "2" }, "电源及极性", -1)), ce((Gt(), Zt("td", Vd, [fe(de((D = o.value) == null ? void 0 : D.weldingBasePowerSupplyAndPolarity), 1)])), [[p]])]), (Gt(true), Zt(wl, null, _l((it = o.value) == null ? void 0 : it.cappCraftCardStorehouseTemperatureLink, (lt, _) => {
      var T, B, H, Y;
      return Gt(), Zt("tr", { key: `cappCraftCardStorehouseTemperatureLink_${_}` }, [_ === 0 ? ce((Gt(), Zt("td", { key: 0, colspan: "2", rowspan: (B = (T = o.value) == null ? void 0 : T.cappCraftCardStorehouseTemperatureLink) == null ? void 0 : B.length }, c[9] || (c[9] = [fe(" 预热温度(℃) ")]), 8, Gd)), [[p]]) : lu("", true), ce((Gt(), Zt("td", null, [fe(de(lt.thickness), 1)])), [[p]]), ce((Gt(), Zt("td", Zd, [fe(de(lt.preheatingTemperature), 1)])), [[p]]), _ === 0 ? ce((Gt(), Zt("td", { key: 1, colspan: "2", rowspan: (Y = (H = o.value) == null ? void 0 : H.cappCraftCardStorehouseTemperatureLink) == null ? void 0 : Y.length }, c[10] || (c[10] = [fe(" 道间温度(℃) ")]), 8, Yd)), [[p]]) : lu("", true), ce((Gt(), Zt("td", $d, [fe(de(lt.thickness), 1)])), [[p]]), ce((Gt(), Zt("td", Kd, [fe(de(lt.roadTemperature), 1)])), [[p]])]);
    }), 128)), Ft("tr", null, [c[11] || (c[11] = Ft("td", null, "接头及坡口尺寸图", -1)), Ft("td", Xd, [Ft("div", Jd, [Ft("img", { src: (dt = (bt = o.value) == null ? void 0 : bt.jointSchematicDiagramAttachmentDTO) == null ? void 0 : dt.imageUrl, crossorigin: "anonymous" }, null, 8, Qd)])]), c[12] || (c[12] = Ft("td", null, "焊接顺序图", -1)), Ft("td", tp, [Ft("div", ep, [Ft("img", { src: (j = ($ = o.value) == null ? void 0 : $.weldingSchematicDiagramAttachmentDTO) == null ? void 0 : j.imageUrl, crossorigin: "anonymous" }, null, 8, np)])])]), Ft("tr", null, [Ft("td", { rowspan: 2 + ((N = (J = o.value) == null ? void 0 : J.cappCraftCardStorehouseCraftParameterPassLink) == null ? void 0 : N.length) }, "焊接工艺参数", 8, rp), c[13] || (c[13] = Ft("td", { rowspan: "2" }, "道次", -1)), c[14] || (c[14] = Ft("td", { rowspan: "2" }, "焊接方法", -1)), c[15] || (c[15] = Ft("td", { rowspan: "2" }, "焊条或焊丝", -1)), c[16] || (c[16] = Ft("td", { colspan: "2" }, "焊剂或保护气", -1)), c[17] || (c[17] = Ft("td", { colspan: "2", rowspan: "2" }, "保护气体流量(L/min)", -1)), c[18] || (c[18] = Ft("td", { rowspan: "2" }, "电流(A)", -1)), c[19] || (c[19] = Ft("td", { rowspan: "2" }, "电压(V)", -1)), c[20] || (c[20] = Ft("td", { rowspan: "2" }, "焊接速度(cm/min)", -1)), c[21] || (c[21] = Ft("td", { rowspan: "2" }, "热输入(kj/cm)", -1)), c[22] || (c[22] = Ft("td", { rowspan: "2" }, "备注", -1))]), c[28] || (c[28] = Ft("tr", null, [Ft("td", null, "牌号"), Ft("td", { style: { "border-right": "none" } }, "φ(mm)")], -1)), (Gt(true), Zt(wl, null, _l((C = o.value) == null ? void 0 : C.cappCraftCardStorehouseCraftParameterPassLink, (lt, _) => (Gt(), Zt("tr", { key: `cappCraftCardStorehouseCraftParameterPassLink_${_}` }, [ce((Gt(), Zt("td", null, [fe(de(lt.weldingCraftParameterPass), 1)])), [[p]]), ce((Gt(), Zt("td", null, [fe(de(lt.weldingBaseWeldingMethod), 1)])), [[p]]), ce((Gt(), Zt("td", null, [fe(de(lt.weldingMaterialTrademark), 1)])), [[p]]), ce((Gt(), Zt("td", null, [fe(de(lt.weldingCraftParameterRodOrWireDesignation), 1)])), [[p]]), ce((Gt(), Zt("td", null, [fe(de(lt.weldingCraftParameterWeldingFluxOrShieldingGas), 1)])), [[p]]), ce((Gt(), Zt("td", ip, [fe(de(lt.weldingCraftParameterShieldingGasFlow), 1)])), [[p]]), ce((Gt(), Zt("td", null, [fe(de(lt.electricity), 1)])), [[p]]), ce((Gt(), Zt("td", null, [fe(de(lt.voltage), 1)])), [[p]]), ce((Gt(), Zt("td", null, [fe(de(lt.weldingSpeed), 1)])), [[p]]), ce((Gt(), Zt("td", null, [fe(de(lt.thermalInput), 1)])), [[p]]), ce((Gt(), Zt("td", null, [fe(de(lt.remark), 1)])), [[p]])]))), 128)), Ft("tr", null, [c[23] || (c[23] = Ft("td", { rowspan: "3" }, "技术措施", -1)), c[24] || (c[24] = Ft("td", { colspan: "2" }, "焊前清理", -1)), ce((Gt(), Zt("td", ap, [fe(de((z = o.value) == null ? void 0 : z.weldingTechnicalMeasurePreWeldCleaning), 1)])), [[p]]), c[25] || (c[25] = Ft("td", { colspan: "3" }, "道间清理", -1)), ce((Gt(), Zt("td", op, [fe(de((q = o.value) == null ? void 0 : q.weldingTechnicalMeasureRoadCleaning), 1)])), [[p]])]), Ft("tr", null, [c[26] || (c[26] = Ft("td", { colspan: "2" }, "背面清根", -1)), ce((Gt(), Zt("td", sp, [fe(de((rt = o.value) == null ? void 0 : rt.weldingTechnicalMeasureBackCleaning), 1)])), [[p]])]), Ft("tr", null, [Ft("td", lp, "其他：" + de((st = o.value) == null ? void 0 : st.weldingTechnicalMeasureOther), 1)])])]), Ft("div", hp, [c[29] || (c[29] = Ft("div", null, "编制", -1)), ce((Gt(), Zt("div", null, [fe(de((ht = o.value) == null ? void 0 : ht.operatorUserName), 1)])), [[p]]), c[30] || (c[30] = Ft("div", null, "日期", -1)), ce((Gt(), Zt("div", null, [fe(de(hu(bl)((tt = o.value) == null ? void 0 : tt.operatorDateTime, "{y} 年 {m} 月 {d} 日")), 1)])), [[p]]), c[31] || (c[31] = Ft("div", null, "审核", -1)), ce((Gt(), Zt("div", null, [fe(de((ft = o.value) == null ? void 0 : ft.auditorUserName), 1)])), [[p]]), c[32] || (c[32] = Ft("div", null, "日期", -1)), ce((Gt(), Zt("div", null, [fe(de(hu(bl)((Lt = o.value) == null ? void 0 : Lt.auditDateTime, "{y} 年 {m} 月 {d} 日")), 1)])), [[p]])])])), Ft("p", null, de(i.value + 1), 1)], 512);
  };
} }, cp = E1(up, [["__scopeId", "data-v-8b0d1176"]]), bp = Object.freeze(Object.defineProperty({ __proto__: null, default: cp }, Symbol.toStringTag, { value: "Module" }));
export {
  Ce as _,
  bp as a,
  cp as c
};
