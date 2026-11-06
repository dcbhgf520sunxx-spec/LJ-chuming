import { ref as r } from "vue";
import { reactive as ke } from "vue";
import { computed as a } from "vue";
import { resolveComponent as ee } from "vue";
import { openBlock as c } from "vue";
import { createBlock as N } from "vue";
import { withCtx as m } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as b } from "vue";
import { createElementBlock as d } from "vue";
import { Fragment as O } from "vue";
import { renderList as te } from "vue";
import { unref as f } from "vue";
import { createTextVNode as J } from "vue";
import { normalizeStyle as v } from "vue";
import { createCommentVNode as p } from "vue";
import ze from "qrcode.vue";
import { ElOption as Le } from "element-plus";
import { ElSelect as Ve } from "element-plus";
import { ElImage as Ae } from "element-plus";
import { _ as Ne, gt as De, gj as le, i, gl as s, gn as ne, go as ie, b as B, ck as D, d5 as Re, bg as Ee, cl as Fe, gs as Me } from "../../../../../shared/runtime.js";
import { e as q } from "../../../../../modules/index-73880c3c.js";
const Oe = { class: "dialog-title" }, Je = { class: "dialog-middle" }, Be = ["innerHTML"], qe = ["innerHTML"], Ue = ["innerHTML"], je = ["innerHTML"], Ie = ["innerHTML"], Pe = ["innerHTML"], Qe = { key: 1, class: "table-type-tip" }, We = { __name: "detail", setup(Xe) {
  const U = r(""), j = r(""), I = r(""), P = r(""), Q = r(""), R = r(100), H = r(10), ae = r([50, 60, 70, 75, 80, 90, 100]), oe = r([0, 10, 20, 30, 50, 100]), E = r("欢迎来到中南绿建钢结构生产执行管理系统"), S = r({}), T = r({}), w = r([]), n = r({}), g = ke({ columns: {}, columnRows: {}, lastColumns: {} }), { crud: x, detail: k, CRUD: se } = De(), F = a(() => {
    var e;
    return (e = n.value) == null ? void 0 : e.qrCode;
  }), C = a(() => {
    var e;
    return (e = n.value) == null ? void 0 : e.logo;
  }), z = a(() => {
    var e;
    return (e = n.value) == null ? void 0 : e.title;
  }), L = a(() => {
    var e;
    return (e = n.value) == null ? void 0 : e.header;
  }), M = a(() => {
    var e;
    return (e = n.value) == null ? void 0 : e.footer;
  }), V = a(() => {
    var e;
    return (e = n.value) == null ? void 0 : e.page;
  }), y = a(() => {
    var e;
    return (e = n.value) == null ? void 0 : e.table;
  }), ue = a(() => le.TRANSVERSE.V === n.value.orient ? n.value.height : n.value.width), re = a(() => le.TRANSVERSE.V === n.value.orient ? n.value.width : n.value.height), ce = a(() => {
    const e = n.value, l = R.value / 100;
    return e.unit ? { transform: `scale(${l})`, "margin-right": `-${e.width * (1 - l) + e.unit}`, "margin-bottom": `-${e.height * (1 - l) + e.unit}`, width: ue.value + e.unit, height: re.value + e.unit, padding: `${e.paddingTB || 0}${e.unit} ${e.paddingLR || 0}${e.unit}` } : { transform: `scale(${l})`, "margin-right": `-${210 * (1 - l)}mm`, "margin-bottom": `-${297 * (1 - l)}mm`, width: "210mm", height: "297mm", padding: "10mm 10mm" };
  }), de = a(() => {
    const e = {};
    if (F.value) {
      const l = n.value, t = F.value;
      i(t.height) && (e.height = `${t.height}${l.unit}`), i(t.width) && (e.width = `${t.width}${l.unit}`), i(t.top) && (e.top = `${t.top}${l.unit}`), i(t.left) && (e.left = `${t.left}${l.unit}`);
    }
    return e;
  }), fe = a(() => {
    const e = {};
    if (C.value) {
      const l = n.value, t = C.value;
      i(t.height) && (e.height = `${t.height}${l.unit}`), i(t.width) && (e.width = `${t.width}${l.unit}`), i(t.top) && (e.top = `${t.top}${l.unit}`), i(t.left) && (e.left = `${t.left}${l.unit}`);
    }
    return e;
  }), ve = a(() => {
    const e = {};
    if (z.value) {
      const l = n.value, t = z.value;
      i(t.size) && (e["font-size"] = `${t.size}${l.fontUnit}`), i(t.bold) && (e["font-weight"] = t.bold), i(t.height) && (e.height = `${t.height}${l.unit}`), i(t.align) && (e["justify-content"] = s.flexAlign(t.align)), i(t.verticleAlign) && (e["align-items"] = s.verticleAlign(t.verticleAlign));
    }
    return e;
  }), ge = a(() => {
    const e = {};
    if (V.value) {
      const l = n.value, t = V.value;
      i(l.paddingLR) && (e["padding-left"] = `${l.paddingLR || 0}${l.unit}`, e["padding-right"] = `${l.paddingLR || 0}${n.value.unit}`), i(t.bottom) && (e.bottom = `${t.bottom}${l.unit}`), i(t.size) && (e["font-size"] = `${t.size}${l.fontUnit}`), i(t.bold) && (e["font-weight"] = t.bold), i(t.align) && (e["text-align"] = s.textAlign(t.align));
    }
    return e;
  }), he = a(() => {
    const e = {};
    if (L.value) {
      const l = n.value, t = L.value;
      i(t.width) && (e.width = `${t.width}${l.unit}`), i(t.height) && (e.height = `${t.height}${l.unit}`), i(t.size) && (e["font-size"] = `${t.size}${l.fontUnit}`), i(t.align) && (e["justify-content"] = s.flexAlign(t.align)), i(t.verticleAlign) && (e["align-items"] = s.verticleAlign(t.verticleAlign));
    }
    return e;
  }), me = a(() => {
    var l, t, h;
    const e = {};
    if (y.value) {
      const o = n.value;
      let $ = o.height - o.paddingTB * 2;
      (l = o.title) != null && l.show && ($ -= o.title.height), (t = o.header) != null && t.show && ($ -= o.header.height), (h = o.footer) != null && h.show && ($ -= o.footer.height), e["max-height"] = `${$}${o.unit}`;
    }
    return e;
  }), _e = a(() => {
    const e = {};
    if (M.value) {
      const l = n.value, t = M.value;
      i(t.width) && (e.width = `${t.width}${l.unit}`), i(t.height) && (e.height = `${t.height}${l.unit}`), i(t.size) && (e["font-size"] = `${t.size}${l.fontUnit}`), i(t.align) && (e["justify-content"] = s.flexAlign(t.align)), i(t.verticleAlign) && (e["align-items"] = s.verticleAlign(t.verticleAlign));
    }
    return e;
  }), A = a(() => {
    let e = [];
    if (i(w.value)) {
      const l = H.value > w.value.length ? w.value.length : H.value;
      e = w.value.slice(0, l);
    }
    return e;
  });
  se.HOOK.afterToDetail = async (e) => {
    n.value = i(k.config) && JSON.parse(k.config), ye(), we();
  };
  async function pe() {
    let e = { header: S.value, table: A.value, footer: T.value, qrCode: E.value };
    const l = k.type;
    l && D[l] && (e = await D[l](e)), e.config = JSON.parse(JSON.stringify(n.value)), Re(e);
  }
  function ye() {
    var e, l, t;
    if (i((e = n.value.table) == null ? void 0 : e.fields)) {
      const h = ne(JSON.parse(JSON.stringify(n.value.table.fields))), o = ie(h);
      w.value = q.getList({ fields: o, extraFields: n.value.table.extraFields, number: 100 });
    }
    i((l = n.value.header) == null ? void 0 : l.fields) && (S.value = q.getOne({ fields: n.value.header.fields, extraFields: n.value.header.extraFields })), i((t = n.value.footer) == null ? void 0 : t.fields) && (T.value = q.getOne({ fields: n.value.footer.fields, extraFields: n.value.footer.extraFields }));
  }
  async function $e() {
    let e = { header: S.value, table: A.value, footer: T.value, qrCode: E.value };
    const l = k.type;
    l && D[l] && (e = await D[l](e)), e.printMode = Ee.PREVIEW.V, e.config = JSON.parse(JSON.stringify(n.value)), Fe(e);
  }
  function be() {
    y.value && (g.columns = Me(JSON.parse(JSON.stringify(y.value.fields))), g.columnRows = ne(g.columns), g.lastColumns = ie(g.columnRows));
  }
  function we() {
    B(n.value) || (Ce(), He(), W(), Se(), Te());
  }
  function Ce() {
    U.value = s.getTitleHtml(z.value);
  }
  function He() {
    s.setHeaderFieldStyle(n.value), j.value = s.getHeaderHtml(S.value, L.value);
  }
  function W() {
    be(), s.setTableStyle(n.value, g), I.value = s.getTableHtml(A.value, y.value, g);
  }
  function Se() {
    s.setFooterFieldStyle(n.value), P.value = s.getFooterHtml(T.value, n.value);
  }
  function Te() {
    Q.value = s.getPageHtml(V.value);
  }
  return (e, l) => {
    const t = Le, h = Ve, o = ee("common-button"), $ = Ae, xe = ee("common-dialog");
    return c(), N(xe, { "append-to-body": "", "close-on-click-modal": false, "before-close": f(x).cancelDetail, visible: f(x).detailVisible, title: f(x).detailTitle, "custom-class": "print-template-detail", "show-close": true, width: "100%", fullscreen: "" }, { title: m(() => [_("div", Oe, [l[5] || (l[5] = _("span", null, "打印预览", -1)), _("div", null, [b(h, { modelValue: R.value, "onUpdate:modelValue": l[0] || (l[0] = (u) => R.value = u), placeholder: "显示比例", size: "default", class: "zoom-select" }, { default: m(() => [(c(true), d(O, null, te(ae.value, (u) => (c(), N(t, { key: u, label: `${u}%`, value: u }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"]), b(h, { modelValue: H.value, "onUpdate:modelValue": l[1] || (l[1] = (u) => H.value = u), onChange: W, placeholder: "数据填充", size: "default", class: "zoom-select" }, { default: m(() => [(c(true), d(O, null, te(oe.value, (u) => (c(), N(t, { key: u, label: `${u}条`, value: u }, null, 8, ["label", "value"]))), 128))]), _: 1 }, 8, ["modelValue"]), b(o, { size: "default", type: "danger", disabled: f(B)(n.value), onClick: $e }, { default: m(() => l[2] || (l[2] = [J("打印预览")])), _: 1, __: [2] }, 8, ["disabled"]), b(o, { size: "default", type: "success", disabled: f(B)(n.value), onClick: pe }, { default: m(() => l[3] || (l[3] = [J("导出 Excel")])), _: 1, __: [3] }, 8, ["disabled"]), b(o, { size: "default", onClick: f(x).cancelDetail }, { default: m(() => l[4] || (l[4] = [J("退出")])), _: 1, __: [4] }, 8, ["onClick"])])])]), default: m(() => {
      var u, X, Z, K, G, Y;
      return [_("div", Je, [_("div", { class: "content", style: v(ce.value) }, [f(i)(n.value) ? (c(), d(O, { key: 0 }, [(u = C.value) != null && u.show && C.value.url ? (c(), N($, { key: 0, class: "logo-info", style: v(fe.value), src: C.value.url, fit: "scale-down" }, null, 8, ["style", "src"])) : p("", true), (X = F.value) != null && X.show ? (c(), d("div", { key: 1, class: "qr-info", style: v(de.value) }, [b(ze, { value: E.value, size: 150, margin: 1 }, null, 8, ["value"])], 4)) : p("", true), (Z = z.value) != null && Z.show ? (c(), d("div", { key: 2, class: "title-info", style: v(ve.value), innerHTML: U.value }, null, 12, Be)) : p("", true), (K = L.value) != null && K.show ? (c(), d("div", { key: 3, class: "header-info", style: v(he.value), innerHTML: j.value }, null, 12, qe)) : p("", true), y.value && f(i)(A.value) ? (c(), d("div", { key: 4, class: "table-info", style: v(me.value) }, [_("div", { innerHTML: y.value.style }, null, 8, Ue), _("div", { innerHTML: I.value }, null, 8, je)], 4)) : p("", true), (G = M.value) != null && G.show ? (c(), d("div", { key: 5, class: "footer-info", style: v(_e.value), innerHTML: P.value }, null, 12, Ie)) : p("", true), (Y = V.value) != null && Y.show ? (c(), d("div", { key: 6, class: "page-info", style: v(ge.value), innerHTML: Q.value }, null, 12, Pe)) : p("", true)], 64)) : (c(), d("span", Qe, "* 表格模板错误"))], 4)])];
    }), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, Ye = Ne(We, [["__scopeId", "data-v-96b92201"]]);
export {
  Ye as default
};
