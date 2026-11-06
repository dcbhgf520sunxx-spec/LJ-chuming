import { commonjsGlobal as F } from "../runtime/build-helpers.mjs";
import { ref as E } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as R } from "vue";
import { createElementVNode as _ } from "vue";
import { toDisplayString as C } from "vue";
import { unref as te } from "vue";
import { createVNode as w } from "vue";
import V from "qrcode.vue";
import { computed as M } from "vue";
import { resolveComponent as q } from "vue";
import { withCtx as k } from "vue";
import { createTextVNode as j } from "vue";
import { withModifiers as oe } from "vue";
import { Fragment as ne } from "vue";
import { renderList as ae } from "vue";
import { createBlock as se } from "vue";
import { resolveDynamicComponent as ie } from "vue";
import { nextTick as N } from "vue";
import { ElMessage as A } from "element-plus";
import ce from "jszip";
import { ElCheckTag as le } from "element-plus";
import $ from "./html2canvas.esm-e0a7d97b.js";
import { _ as Q, m as re } from "../shared/runtime.js";
var W = { exports: {} };
(function(b, s) {
  (function(v, u) {
    u();
  })(F, function() {
    function v(e, o) {
      return typeof o > "u" ? o = { autoBom: false } : typeof o != "object" && (console.warn("Deprecated: Expected third argument to be a object"), o = { autoBom: !o }), o.autoBom && /^\s*(?:text\/\S*|application\/xml|\S*\/\S*\+xml)\s*;.*charset\s*=\s*utf-8/i.test(e.type) ? new Blob(["\uFEFF", e], { type: e.type }) : e;
    }
    function u(e, o, m) {
      var n = new XMLHttpRequest();
      n.open("GET", e), n.responseType = "blob", n.onload = function() {
        L(n.response, o, m);
      }, n.onerror = function() {
        console.error("could not download file");
      }, n.send();
    }
    function g(e) {
      var o = new XMLHttpRequest();
      o.open("HEAD", e, false);
      try {
        o.send();
      } catch {
      }
      return 200 <= o.status && 299 >= o.status;
    }
    function x(e) {
      try {
        e.dispatchEvent(new MouseEvent("click"));
      } catch {
        var o = document.createEvent("MouseEvents");
        o.initMouseEvent("click", true, true, window, 0, 0, 0, 80, 20, false, false, false, false, 0, null), e.dispatchEvent(o);
      }
    }
    var c = typeof window == "object" && window.window === window ? window : typeof self == "object" && self.self === self ? self : typeof F == "object" && F.global === F ? F : void 0, h = c.navigator && /Macintosh/.test(navigator.userAgent) && /AppleWebKit/.test(navigator.userAgent) && !/Safari/.test(navigator.userAgent), L = c.saveAs || (typeof window != "object" || window !== c ? function() {
    } : "download" in HTMLAnchorElement.prototype && !h ? function(e, o, m) {
      var n = c.URL || c.webkitURL, f = document.createElement("a");
      o = o || e.name || "download", f.download = o, f.rel = "noopener", typeof e == "string" ? (f.href = e, f.origin === location.origin ? x(f) : g(f.href) ? u(e, o, m) : x(f, f.target = "_blank")) : (f.href = n.createObjectURL(e), setTimeout(function() {
        n.revokeObjectURL(f.href);
      }, 4e4), setTimeout(function() {
        x(f);
      }, 0));
    } : "msSaveOrOpenBlob" in navigator ? function(e, o, m) {
      if (o = o || e.name || "download", typeof e != "string") navigator.msSaveOrOpenBlob(v(e, m), o);
      else if (g(e)) u(e, o, m);
      else {
        var n = document.createElement("a");
        n.href = e, n.target = "_blank", setTimeout(function() {
          x(n);
        });
      }
    } : function(e, o, m, n) {
      if (n = n || open("", "_blank"), n && (n.document.title = n.document.body.innerText = "downloading..."), typeof e == "string") return u(e, o, m);
      var f = e.type === "application/octet-stream", z = /constructor/i.test(c.HTMLElement) || c.safari, S = /CriOS\/[\d]+/.test(navigator.userAgent);
      if ((S || f && z || h) && typeof FileReader < "u") {
        var l = new FileReader();
        l.onloadend = function() {
          var t = l.result;
          t = S ? t : t.replace(/^data:[^;]*;/, "data:attachment/file;"), n ? n.location.href = t : location = t, n = null;
        }, l.readAsDataURL(e);
      } else {
        var a = c.URL || c.webkitURL, r = a.createObjectURL(e);
        n ? n.location = r : location.href = r, n = null, setTimeout(function() {
          a.revokeObjectURL(r);
        }, 4e4);
      }
    });
    c.saveAs = L.saveAs = L, b.exports = L;
  });
})(W);
var de = W.exports;
const ue = { class: "label-content" }, fe = { class: "title" }, pe = { class: "qrcode-content" }, me = { class: "qrcode-header" }, ve = { class: "qrcode-middle" }, ge = { class: "qrcode-footer" }, he = { __name: "inspection-qrcode-label", props: { data: { type: Object, default: () => {
} } }, setup(b, { expose: s }) {
  const { user: v } = re("user"), u = E();
  return s({ contentRef: u }), (g, x) => {
    var c, h;
    return y(), R("div", { ref_key: "contentRef", ref: u, class: "label-container" }, [_("div", ue, [_("h2", fe, C(te(v).companyName), 1), _("div", pe, [_("div", me, [w(V, { value: b.data.qrCode, size: 180, margin: 2, style: { "border-radius": "5px", "margin-top": "20px" } }, null, 8, ["value"])]), _("div", ve, C((c = b.data) == null ? void 0 : c.projectName), 1), _("div", ge, "巡检点：" + C((h = b.data) == null ? void 0 : h.inspectionName), 1)])])], 512);
  };
} }, D = Q(he, [["__scopeId", "data-v-a59a9015"]]);
const _e = { class: "label-content" }, be = { class: "qrcode-content" }, ye = { class: "qrcode-header" }, we = { __name: "personal-qrcode-label", props: { data: { type: Object, default: () => {
} } }, setup(b, { expose: s }) {
  const v = E();
  return s({ contentRef: v }), (u, g) => (y(), R("div", { ref_key: "contentRef", ref: v, class: "label-container" }, [_("div", _e, [g[0] || (g[0] = _("h2", { class: "title" }, "花名册人员信息二维码", -1)), _("div", be, [_("div", ye, [w(V, { value: b.data.qrCode, size: 180, margin: 2, style: { "border-radius": "5px", "margin-top": "20px" } }, null, 8, ["value"])])])])], 512));
} }, xe = Q(we, [["__scopeId", "data-v-f6dbf734"]]), ke = { key: 0 }, Ee = { key: 1 }, Re = { style: { position: "fixed", top: "-100000px", left: "0px" } }, Ce = { __name: "index", props: { btnType: { type: String, default: "success" }, size: { type: String, default: "default" }, disabled: { type: Boolean, default: false }, btnName: { type: String, default: "下载二维码" }, exportMode: { type: String, default: "single" }, exportInfo: { type: Object, default: () => {
} }, labelType: { type: String }, beforeExportFn: { type: Function } }, setup(b) {
  const s = b, v = E(), u = E(false), g = E({}), x = M(() => {
    switch (s.labelType) {
      case "inspection":
        return D;
      case "personal":
        return xe;
      default:
        return D;
    }
  }), c = E([{ id: 1, checked: false, label: "105（宽）* 148（长）毫米" }]), h = E(false);
  function L(l, a) {
    c.value.some((t) => t.checked === true) && c.value.forEach((t) => t.checked = false), a.checked = l;
  }
  const e = M(() => c.value.findIndex((l) => l.checked === true) < 0);
  function o() {
    h.value = false, c.value.forEach((l) => l.checked = false);
  }
  async function m() {
    await n(), h.value = false;
  }
  async function n() {
    var l, a, r;
    try {
      if (u.value = true, typeof s.beforeExportFn == "function" && await s.beforeExportFn(), s.exportMode === "single" && (console.log(s.exportInfo, "single"), g.value = ((l = s.exportInfo) == null ? void 0 : l.data) || {}, N(async () => {
        var T;
        const t = v.value.contentRef, d = t.offsetWidth, i = t.offsetHeight, p = await $(t, { useCORS: true, logging: true, width: d, height: i, scale: 2, windowHeight: window.innerHeight - ((T = t == null ? void 0 : t.offsetParent) == null ? void 0 : T.offsetTop) });
        console.log(p);
        const I = p.toDataURL("image/png"), U = await f(I, [p.width, p.height]);
        await z(U), A.success("二维码下载成功"), u.value = false;
      })), s.exportMode === "batch") {
        const t = new ce(), d = ((r = (a = s.exportInfo) == null ? void 0 : a.data) == null ? void 0 : r.list) || [];
        console.log(d, s.exportInfo, "batch");
        for (let i = 0; i < d.length; i++) setTimeout(() => {
          g.value = d[i], N(async () => {
            var B, H;
            const p = v.value.contentRef, I = p.offsetWidth, U = p.offsetHeight, T = await $(p, { useCORS: true, logging: true, width: I, height: U, scale: 2, windowHeight: window.innerHeight - ((B = p == null ? void 0 : p.offsetParent) == null ? void 0 : B.offsetTop) }), G = T.toDataURL("image/png"), P = await f(G, [T.width, T.height]);
            let O = (H = s.exportInfo) == null ? void 0 : H.fnFormat;
            O || (O = d[i].fnFormat);
            const K = S(d[i], O), X = P.split("base64,")[1];
            t.file(`${K}.png`, X, { base64: true }), i === d.length - 1 && t.generateAsync({ type: "blob" }).then((J) => {
              const { znFormat: Z, data: Y } = s.exportInfo, ee = S(Y, Z);
              de.saveAs(J, ee), A.success("二维码下载成功"), u.value = false;
            });
          });
        });
      }
    } catch (t) {
      u.value = false, A.error("下载失败"), console.log(t, "下载二维码错误");
    }
  }
  function f(l, a) {
    return new Promise((r) => {
      let t = document.createElement("canvas");
      const d = t.getContext("2d");
      d.mozImageSmoothingEnabled = false, d.webkitImageSmoothingEnabled = false, d.msImageSmoothingEnabled = false, d.imageSmoothingEnabled = false;
      const i = new Image();
      i.crossOrigin = "Anonymous", i.src = l, i.onload = () => {
        t.height = a[1], t.width = a[0], d.drawImage(i, 0, 0, a[0], a[1]);
        const p = t.toDataURL("image/png");
        t = null, r(p);
      };
    });
  }
  async function z(l) {
    const a = document.createElement("a"), { fnFormat: r } = s.exportInfo, t = S(g.value, r);
    a.href = l, a.download = `${t}.png`, a.click();
  }
  function S(l, a) {
    return a.replace(/\{[^\}]+\}/g, (r, t) => {
      const d = r.slice(1, -1), i = l[d];
      return i == null ? void 0 : i.toString();
    });
  }
  return (l, a) => {
    const r = q("common-button"), t = le, d = q("common-dialog");
    return y(), R("div", null, [b.labelType === "inspection" ? (y(), R("div", ke, [w(r, { type: s.btnType, size: s.size, icon: "el-icon-download", onClick: a[0] || (a[0] = (i) => h.value = true), disabled: s.disabled }, { default: k(() => [j(C(s.btnName), 1)]), _: 1 }, 8, ["type", "size", "disabled"]), w(d, { title: "选择二维码尺寸", modelValue: h.value, "onUpdate:modelValue": a[1] || (a[1] = (i) => h.value = i), center: false, "close-on-click-modal": false, "show-close": false, width: "600px" }, { titleRight: k(() => [w(r, { type: "primary", size: "default", loading: u.value, disabled: e.value, onClick: m }, { default: k(() => a[2] || (a[2] = [j("确认")])), _: 1, __: [2] }, 8, ["loading", "disabled"]), w(r, { size: "default", onClick: oe(o, ["stop"]) }, { default: k(() => a[3] || (a[3] = [j("关闭")])), _: 1, __: [3] })]), default: k(() => [(y(true), R(ne, null, ae(c.value, (i) => (y(), R("div", { key: i.id, style: { display: "inline-block", "margin-right": "20px" } }, [w(t, { checked: i.checked, style: { width: "210px" }, onChange: (p) => L(p, i) }, { default: k(() => [j(C(i.label), 1)]), _: 2 }, 1032, ["checked", "onChange"])]))), 128))]), _: 1 }, 8, ["modelValue"])])) : (y(), R("div", Ee, [w(r, { type: s.btnType, size: s.size, icon: "el-icon-download", onClick: n, loading: u.value, disabled: s.disabled }, { default: k(() => [j(C(s.btnName), 1)]), _: 1 }, 8, ["type", "size", "loading", "disabled"])])), _("div", Re, [(y(), se(ie(x.value), { ref_key: "compRef", ref: v, data: g.value }, null, 8, ["data"]))])]);
  };
} };
export {
  Ce as _
};
