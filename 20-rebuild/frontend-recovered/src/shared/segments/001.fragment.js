(function() {
  const o = document.createElement("link").relList;
  if (o && o.supports && o.supports("modulepreload")) return;
  for (const u of document.querySelectorAll('link[rel="modulepreload"]')) c(u);
  new MutationObserver((u) => {
    for (const r of u) if (r.type === "childList") for (const E of r.addedNodes) E.tagName === "LINK" && E.rel === "modulepreload" && c(E);
  }).observe(document, { childList: true, subtree: true });
  function n(u) {
    const r = {};
    return u.integrity && (r.integrity = u.integrity), u.referrerPolicy && (r.referrerPolicy = u.referrerPolicy), u.crossOrigin === "use-credentials" ? r.credentials = "include" : u.crossOrigin === "anonymous" ? r.credentials = "omit" : r.credentials = "same-origin", r;
  }
  function c(u) {
    if (u.ep) return;
    u.ep = true;
    const r = n(u);
    fetch(u.href, r);
  }
})();
const uA = `:export{theme:#1890ff}
`, cA = false, dA = true, mA = true, pA = true, hA = false, fA = 3, oc = "User-Token", Hm = "Request-Url", gA = uA.theme, EA = true, yA = true, TA = 100;
class _A {
  constructor(o) {
    this.props = o || {}, this.source = this.props.source || window.localStorage, this.initRun();
  }
  initRun() {
    const o = new RegExp("__expires__"), n = this.source, c = Object.keys(n);
    c.length > 0 && c.map((u, r) => {
      if (!o.test(u)) {
        const E = Date.now(), y = n[`${u}__expires__`] || Date.now + 1;
        E >= y && this.remove(u);
      }
      return u;
    });
  }
  set(o, n, c) {
    const u = this.source;
    return u[o] = JSON.stringify(n), c && (u[`${o}__expires__`] = Date.now() + c), n;
  }
  get(o) {
    const n = this.source, c = n[`${o}__expires__`] || Date.now + 1;
    if (Date.now() >= c) {
      this.remove(o);
      return;
    }
    let r = n[o];
    if (n[o]) switch (n[o]) {
      case "undefined":
        r = void 0;
        break;
      case void 0:
        r = void 0;
        break;
      default:
        r = JSON.parse(n[o]);
    }
    return r;
  }
  remove(o) {
    const n = this.source, c = n[o];
    return delete n[o], delete n[`${o}__expires__`], c;
  }
}
const ci = new _A();
function or() {
  return JSON.parse(sessionStorage.getItem("ljaps-recovered-token") || "null");
}
function JV(token) {
  sessionStorage.setItem("ljaps-recovered-token", JSON.stringify(token));
  return token;
}
function bA() {
  sessionStorage.removeItem("ljaps-recovered-token");
}
function yn() {
  return location.origin;
}
function XV() {
  return location.origin;
}
function VA() {
  return void 0;
}
function wA() {
  return ci.get("steelWeightType");
}
function SA(e) {
  return ci.set("steelWeightType", e);
}
function vA() {
  return ci.remove("steelWeightType");
}
function Un() {
  return ci.get("steelsSpeShowConfig");
}
function RA(e) {
  return ci.set("steelsSpeShowConfig", e);
}
function MA() {
  return ci.remove("steelsSpeShowConfig");
}
function S2() {
  return ci.get("financeBranchId");
}
function $V(e) {
  return ci.set("financeBranchId", e);
}
function fr() {
  return ci.get("closingTimeConfig");
}
function AA(e) {
  return ci.set("closingTimeConfig", e);
}
function NA() {
  return ci.remove("closingTimeConfig");
}
function v2() {
  return ci.get("LAST_DEVICE_PATH");
}
function LA(e) {
  return ci.set("LAST_DEVICE_PATH", e);
}
function Hlt() {
  return ci.get("LAST_PML_PATH");
}
function ew(e) {
  return ci.set("LAST_PML_PATH", e);
}
function tu(e, o) {
  e = At(e), o = At(o);
  var n = Object.getOwnPropertyNames(e), c = Object.getOwnPropertyNames(o);
  if (n.length !== c.length) return false;
  for (var u = 0; u < n.length; u++) {
    var r = n[u];
    if (r !== "__ob__" && e[r] !== o[r]) return typeof e[r] == "object" ? tu(e[r], o[r]) : false;
  }
  return true;
}
function tw(e) {
  if (typeof e != "object") throw Error("不是“object”类型", typeof e);
  Object.keys(e).forEach((o) => {
    e[o] = void 0;
  });
}
function qm(e) {
  const o = [];
  for (let n = 0; n < e.length; n++) e[n] && o.push(e[n]);
  return o;
}
function qlt(e) {
  const o = {};
  for (const n in e) {
    if (o[e[n]]) return true;
    o[e[n]] = true;
  }
  return false;
}
function Tn(e) {
  return Array.from(new Set(e));
}
function mi(e, o, n, c = true) {
  if (!(e instanceof Array) || !(o instanceof Array) || e.length !== o.length) return false;
  if (c) {
    for (let u = 0; u < e.length; u++) if (A(n)) {
      if (e[u][n] !== o[u][n]) return false;
    } else if (e[u] !== o[u]) return false;
  } else for (let u = 0; u < e.length; u++) {
    let r = false;
    for (let E = 0; E < o.length; E++) if (A(n)) {
      if (e[u][n] === o[E][n]) {
        r = true;
        break;
      }
    } else if (e[u] === o[E]) {
      r = true;
      break;
    }
    if (!r) return false;
  }
  return true;
}
function Glt(e = {}, o, n = false) {
  return o.forEach((c, u) => {
    n ? e[u] = e[c] : e[c] = e[u];
  }), e;
}
function iw(e, o) {
  return Ae(e) ? "" : o + e;
}
function aw(e, o) {
  return Ae(e) ? "" : e + o;
}
function Si(e, o = "-") {
  return e === 0 && (e = "0"), e = `${e || ""}`.trim(), (e === "undefined" || e === "null") && (e = ""), e || o;
}
function ji(e, o, { toNum: n = false } = {}) {
  return e == null || isNaN(+e) ? e : n ? +(+e).toFixed(o) : (+e).toFixed(o);
}
function Be(e, o = 0) {
  return parseFloat(`${Math.round(e * Math.pow(10, o)) / Math.pow(10, o)}`);
}
function el(e, o) {
  if (!A(e) && !A(o)) return true;
  if (!A(e) || !A(o)) return false;
  if (e.constructor === o.constructor) switch (e.constructor) {
    case Object:
      return tu(e, o);
    case Array:
      return mi(e, o);
    default:
      return e === o;
  }
  else return false;
}
function A(...e) {
  if (!e.length) throw new Error("No parameters passed in");
  for (const o of e) {
    if (o == null || o === "null" || o === "undefined" || o === "NaN" || o === "") return false;
    if (o instanceof Map) return o.size > 0;
    let n = null;
    try {
      n = JSON.stringify(o);
    } catch {
      n = "";
    }
    if (n === "{}" || n === "[]") return false;
  }
  return true;
}
function Ae(...e) {
  if (!e.length) throw new Error("No parameters passed in");
  for (const o of e) {
    if (o == null || o === "null" || o === "undefined" || o === "NaN" || o === "" || Number.isNaN(o)) return true;
    let n = null;
    if (o instanceof Map) return o.size === 0;
    try {
      n = JSON.stringify(o);
    } catch {
      n = "";
    }
    if (n === "{}" || n === "[]") return true;
  }
  return false;
}
function At(e) {
  if (!e && typeof e != "object") throw new Error("error arguments", "deepClone");
  const o = e.constructor === Array ? [] : {};
  return Object.keys(e).forEach((n) => {
    e[n] && typeof e[n] == "object" ? o[n] = At(e[n]) : o[n] = e[n];
  }), o;
}
function Lu(e, o = 2) {
  return e.toString().length >= o ? e : (Array(o).join(0) + e).slice(-o);
}
function lw(e) {
  var r;
  const o = parseInt(e).toString(2), n = new RegExp("\\d{1,1}", "g"), c = (r = o.match(n)) == null ? void 0 : r.reverse(), u = [];
  return c == null || c.forEach((E, y) => {
    parseInt(E) === 1 && u.push(Math.pow(2, y));
  }), u;
}
function ow(e, o, n, { label: c = "label", key: u = "key", value: r = "value" } = {}) {
  const E = [];
  for (const y in e) if (e[y][r] & o) switch (n) {
    case "key":
      E.push(e[y][u]);
      break;
    case "value":
      E.push(e[y][r]);
      break;
    case "label":
      E.push(e[y][c]);
      break;
    default:
      E.push(e[y].value);
      break;
  }
  return E;
}
function Qlt(e) {
  let o;
  return Array.isArray(e) && (o = e), o.reduce((n, c) => n | c, 0);
}
function R2(e) {
  if (isNaN(e)) return e;
  const o = "" + e;
  return /e/i.test(o) ? (+e).toFixed(18).replace(/\.?0+$/, "") : e;
}
function iu(e) {
  if (isNaN(+e) || (e = parseFloat(e), e >= 1e15)) return "";
  const n = ["角", "分", "厘", "毫"], c = ["零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"], u = [["", "拾", "佰", "仟"], ["", "万", "亿", "兆"]], r = e < 0 ? "欠" : "";
  e = Math.abs(e);
  let E = "", y, b;
  const V = e.toString();
  if (V.indexOf(".") === -1) y = V, b = "";
  else {
    const M = V.split(".");
    y = M[0], b = M[1].substr(0, 4);
  }
  if (b !== "") {
    const M = b.length;
    for (let g = 0; g < M; g++) {
      const S = b.substr(g, 1);
      S !== "0" && (E += c[Number(S)] + n[g]);
    }
  }
  if (E = E || "整", parseInt(y, 10) > 0) {
    let M = 0, g = "";
    const S = y.length;
    for (let h = 0; h < S; h++) {
      const T = y.substr(h, 1), _ = S - h - 1, f = _ / 4, m = _ % 4;
      T === "0" ? M++ : (M > 0 && (g += c[0]), M = 0, g += c[parseInt(T)] + u[0][m]), m === 0 && M < 4 && (g += u[1][f]);
    }
    g += "元", E = g + E;
  }
  return r + E.replace(/^整$/, "零元整");
}
function Zlt(e) {
  if (!/^\d*(\.\d*)?$/.test(e)) return "错误的数字";
  for (var o = ["零", "一", "二", "三", "四", "五", "六", "七", "八", "九"], n = ["", "十", "百", "千", "万", "亿", "点", ""], c = ("" + e).replace(/(^0*)/g, "").split("."), u = 0, r = "", E = c[0].length - 1; E >= 0; E--) {
    switch (u) {
      case 0:
        r = n[7] + r;
        break;
      case 4:
        new RegExp("0{4}\\d{" + (c[0].length - E - 1) + "}$").test(c[0]) || (r = n[4] + r);
        break;
      case 8:
        r = n[5] + r, n[7] = n[5], u = 0;
        break;
    }
    u % 4 === 2 && c[0].charAt(E + 2) !== 0 && c[0].charAt(E + 1) === 0 && (r = o[0] + r), c[0].charAt(E) !== 0 && (r = o[c[0].charAt(E)] + n[u % 4] + r), u++;
  }
  if (c.length > 1) for (r += n[6], E = 0; E < c[1].length; E++) r += o[c[1].charAt(E)];
  return r;
}
function Mi(e, o = 2) {
  return e === "" || e === void 0 || e === null || isNaN(+e) ? e : (+e || 0).toFixed(o).replace(/^-?\d+/g, (n) => n.replace(/(?=(?!\b)(\d{3})+$)/g, ","));
}
function IA(e) {
  return e === "" || e === void 0 || e === null || isNaN(+e) ? e : (+e || 0).toString().replace(/^-?\d+/g, (o) => o.replace(/(?=(?!\b)(\d{3})+$)/g, ","));
}
