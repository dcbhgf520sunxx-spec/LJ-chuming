import { ref as C } from "vue";
import { onMounted as x } from "vue";
import { resolveComponent as O } from "vue";
import { resolveDirective as D } from "vue";
import { openBlock as L } from "vue";
import { createElementBlock as Y } from "vue";
import { createElementVNode as T } from "vue";
import { createVNode as s } from "vue";
import { withDirectives as B } from "vue";
import { unref as u } from "vue";
import { withCtx as w } from "vue";
import { toDisplayString as R } from "vue";
import { ElDatePicker as S } from "element-plus";
import { ElTableColumn as W } from "element-plus";
import { l as U, cY as K, cZ as z, c_ as c, c$ as M, d0 as N, eK as j, d1 as H, c as d, D as g, t as I, p as G, G as V, o as Z } from "../../../shared/runtime.js";
import { p as P } from "../../../modules/operation-4e9312fe.js";
import { _ as $ } from "../../../modules/index-f406fc4e.js";
function q(y) {
  return U({ url: "/api/contract/finance/operationAnalysis/painting-price", method: "get", params: y });
}
function J(y) {
  return U({ url: "/api/contract/finance/operationAnalysis/painting-price/print", method: "get", params: y });
}
const Q = { fontUnit: "pt", unit: K.MM.V, unitPrecision: z.ZERO.V, type: "PAINTING_FEE_LIST_IMPL", name: "涂装费清单", width: 210, height: 297, paddingLR: 10, paddingTB: 10, title: { show: true, allPage: false, title: "涂装费清单", align: c.CENTER.V, verticleAlign: M.CENTER.V, size: 17, bold: "bold", height: 10 }, header: { show: true, allPage: false, align: c.LEFT.V, verticleAlign: M.CENTER.V, size: 10, bold: "bold", height: 6, width: 190, emptyVal: "" }, table: { th: { size: 10, bold: "bold", lineHeight: 15, paddingTB: 1 }, td: { size: 9, bold: "unset", lineHeight: 13, paddingTB: 1 }, emptyVal: "/", index: { show: true, title: "序号", width: 10, align: c.CENTER.V }, summary: { show: true, title: "合计" }, extraFields: [], fields: [{ show: true, key: "project", title: "项目", minWidth: 50, type: N.PROJECT.K, format: { showProjectFullName: false, showSerialNumber: true, projectNameShowConfig: j.SERIAL_NUMBER_START.V, lineBreak: false } }, { show: true, key: "mete", title: "累计产量（吨）", align: c.CENTER.V, minWidth: 30, type: N.METE.K, format: { toThousand: false }, sum: true }, { show: true, key: "area", title: "油漆面积（㎡）", align: c.CENTER.V, minWidth: 30, type: N.OTHER.K, format: { toThousand: false }, sum: true }, { show: true, key: "paintingUnitPrice", title: "涂装单价", align: c.CENTER.V, minWidth: 30, type: N.AMOUNT.K }, { show: true, key: "price", title: "应付工程款（元）", align: c.CENTER.V, minWidth: 35, type: N.AMOUNT.K, format: { toThousand: false }, sum: true }, { show: true, key: "averageUnitPrice", title: "平均单价（元/吨）", align: c.CENTER.V, minWidth: 35, type: N.AMOUNT.K, sum: true }] }, page: { show: true, format: H.DEFAULT.V, align: c.CENTER.V, size: 11, bold: "unset", bottom: 2 }, fetch: async (y) => {
  var h;
  const E = await J(y);
  return (h = E.table) == null || h.forEach((a) => {
    a.mete = d(a.mete, "kg", "t", g.COM_WT__T), a.area = d(a.area, "mm2", "m2", g.COM_AREA__M2), a.paintingUnitPrice = a.price && a.area ? (a.price / a.area).toFixed(g.YUAN) : 0, a.averageUnitPrice = a.price && a.mete ? (a.price / a.mete).toFixed(g.YUAN) : 0;
  }), E;
} }, X = { class: "app-container" }, ee = { class: "head-container" }, te = { style: { float: "left" } }, ae = { style: { float: "right" } }, se = { __name: "index", setup(y) {
  const { decimalPrecision: E } = I(), h = C(G(/* @__PURE__ */ new Date(), "{y}")), a = C([]);
  x(() => {
    A();
  });
  async function A() {
    if (!V(P.get)) return false;
    try {
      const { content: l } = await q({ year: h.value });
      l.forEach((r) => {
        r.paintingUnitPrice = r.price && r.area ? (r.price / d(r.area, "mm2", "m2", g.COM_AREA__M2)).toFixed(E.value.operation) : 0, r.averageUnitPrice = (r.price / d(r.mete, "kg", "t", g.COM_WT__T)).toFixed(E.value.operation);
      }), a.value = l || [];
    } catch (l) {
      console.log("获取涂装费列表失败", l);
    }
  }
  function F(l) {
    return l > /* @__PURE__ */ new Date();
  }
  const { maxHeight: k } = Z({ extraBox: [".head-container"], paginate: true });
  function v(l) {
    const { columns: r, data: f } = l, t = [];
    return r.forEach((p, n) => {
      if (n === 0) {
        t[n] = "合计";
        return;
      }
      if (n === 6) {
        const i = f.map((m) => m.mete), e = f.map((m) => m.price), o = i.reduce((m, b) => Number(b) ? m + b : m, 0), _ = e.reduce((m, b) => Number(b) ? m + b : m, 0);
        t[n] = o ? (_ / (o / 1e3)).toFixed(2) : 0;
      }
      if (p.property === "mete") {
        const i = f.map((e) => Number(e[p.property]));
        i.every((e) => isNaN(e)) || (t[n] = i.reduce((e, o) => {
          const _ = Number(o);
          return isNaN(_) ? e : e + o;
        }, 0), t[n] = d(t[n], "kg", "t", 2));
      }
      if (p.property === "area") {
        const i = f.map((e) => Number(e[p.property]));
        i.every((e) => isNaN(e)) || (t[n] = i.reduce((e, o) => {
          const _ = Number(o);
          return isNaN(_) ? e : e + o;
        }, 0), t[n] = d(t[n], "mm2", "m2", g.COM_AREA__M2));
      }
      if (p.property === "price") {
        const i = f.map((e) => Number(e[p.property]));
        i.every((e) => isNaN(e)) || (t[n] = i.reduce((e, o) => {
          const _ = Number(o);
          return isNaN(_) ? e : e + o;
        }, 0), t[n] = t[n].toFixed(E.value.operation));
      }
    }), t;
  }
  return (l, r) => {
    const f = S, t = W, p = O("common-table"), n = D("permission");
    return L(), Y("div", X, [T("div", ee, [T("div", te, [s(f, { modelValue: h.value, "onUpdate:modelValue": r[0] || (r[0] = (i) => h.value = i), type: "year", size: "default", style: { width: "100px" }, placeholder: "选择年", class: "filter-item", format: "YYYY", "value-format": "YYYY", clearable: "", "disabled-date": F, onChange: A }, null, 8, ["modelValue"])]), T("div", ae, [B(s($, { "btn-name": "涂装费清单", "btn-type": "warning", template: u(Q), filename: "涂装费清单", params: { year: h.value } }, null, 8, ["template", "params"]), [[n, u(P).download]])])]), s(p, { ref: "tableRef", data: a.value, "empty-text": u(V)(u(P).get) ? "暂无数据" : "暂无权限", "max-height": u(k), "row-key": "id", style: { width: "100%" }, "show-summary": "", "summary-method": v }, { default: w(() => [s(t, { type: "index", label: "序号", prop: "indx", align: "center", width: "60" }), s(t, { label: "项目名称", prop: "project.name", align: "center", "min-width": "160px" }), s(t, { label: "累计产量（吨）", prop: "mete", align: "center" }, { default: w(({ row: i }) => [T("span", null, R(i.mete ? u(d)(i.mete, "kg", "t", 2) : 0), 1)]), _: 1 }), s(t, { label: "油漆面积（㎡）", prop: "area", align: "center" }, { default: w((i) => [T("span", null, R(u(d)(i.row.area, "mm2", "m2", u(g).COM_AREA__M2)), 1)]), _: 1 }), s(t, { label: "涂装单价", prop: "paintingUnitPrice", align: "center" }), s(t, { label: "应付工程款（元）", prop: "price", align: "center" }), s(t, { label: "平均单价（元/吨）", prop: "averageUnitPrice", align: "center" })]), _: 1 }, 8, ["data", "empty-text", "max-height"])]);
  };
} };
export {
  se as default
};
