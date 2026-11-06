import { ref as s } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as h } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as n } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as y } from "vue";
import { toDisplayString as p } from "vue";
import { createElementVNode as v } from "vue";
import { withDirectives as L } from "vue";
import { unref as m } from "vue";
import { isRef as S } from "vue";
import { ElTag as U } from "element-plus";
import { ElTableColumn as P } from "element-plus";
import { vLoading as q } from "element-plus";
import { j as E } from "../../../../modules/fabricating-cost-statistics-5d4cd0ec.js";
import { _ as z, u as F, o as O, jm as Y, ba as G, D as J } from "../../../../shared/runtime.js";
const K = { class: "content-header" }, Q = { __name: "manuf-return-repair", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, currentData: { type: Object, default: () => {
} }, timeInterval: { type: String, default: "-" } }, emits: ["update:modelValue"], setup(l, { emit: k }) {
  const x = k, w = l, b = s(), R = s(), g = s(), u = s(false), { visible: d, handleClose: D } = F({ emit: x, props: w, showHook: M, closeHook: H }), { maxHeight: j } = O({ mainBox: ".amount-detail", extraBox: [".el-drawer__header", ".content-header"], wrapperBox: ".el-drawer__body", extraHeight: 50, paginate: false, minHeight: 300, navbar: false, clientHRepMainH: true }, b), N = s([["auditTime", ["parse-time", "{y}-{m}-{d}"]], ["unitPrice", ["to-thousand", 3]], ["totalAmount", ["to-thousand", 3]]]);
  async function V() {
    var r;
    u.value = true;
    try {
      const o = { projectId: (r = w.currentData) == null ? void 0 : r.projectId }, c = await E(o);
      g.value = c;
    } catch (o) {
      console.log(o);
    } finally {
      u.value = false;
    }
  }
  function M() {
    V();
  }
  function H() {
  }
  function I(r) {
    return G(r, { props: [["scrapAmountMoney", J.YUAN]], toThousandFields: ["scrapAmountMoney"] });
  }
  return (r, o) => {
    const c = U, A = f("print-table"), t = P, B = f("common-table"), T = f("common-drawer"), C = q;
    return h(), _(T, { ref_key: "drawerRef", ref: b, title: "回厂返修费用", "close-on-click-modal": false, modelValue: m(d), "onUpdate:modelValue": o[0] || (o[0] = (a) => S(d) ? d.value = a : null), direction: "rtl", "before-close": m(D), "wrapper-closable": false, "custom-class": "amount-detail", size: "85%" }, { titleAfter: n(() => [e(c, null, { default: n(() => {
      var a, i;
      return [y("项目：" + p(((a = l.currentData) == null ? void 0 : a.serialNumber) || "-") + " " + p(((i = l.currentData) == null ? void 0 : i.projectName) || "-"), 1)];
    }), _: 1 })]), content: n(() => {
      var a;
      return [v("div", K, [e(c, null, { default: n(() => [y("统计日期：" + p(l.timeInterval || "-"), 1)]), _: 1 }), e(A, { "api-key": "manufCostReturnRepair", params: { projectId: (a = l.currentData) == null ? void 0 : a.projectId }, size: "default", type: "warning", class: "filter-item", style: { "margin-bottom": "10px" } }, null, 8, ["params"])]), L((h(), _(B, { ref_key: "tableRef", ref: R, data: g.value, "max-height": m(j), "data-format": N.value, "summary-method": I, "show-summary": "" }, { default: n(() => [e(t, { "show-overflow-tooltip": "", type: "index", label: "序号", align: "center" }), e(t, { "show-overflow-tooltip": "", prop: "auditTime", key: "auditTime", label: "日期", align: "center" }), e(t, { "show-overflow-tooltip": "", prop: "monomer.name", key: "monomer.name", label: "单体", align: "center" }), e(t, { "show-overflow-tooltip": "", prop: "area.name", key: "area.name", label: "区域", align: "center" }), e(t, { "show-overflow-tooltip": "", prop: "name", key: "name", label: "名称", align: "center" }), e(t, { "show-overflow-tooltip": "", prop: "serialNumber", key: "serialNumber", label: "编号", align: "center" }), e(t, { "show-overflow-tooltip": "", prop: "specification", key: "specification", label: "规格", align: "center", width: "120px" }), e(t, { "show-overflow-tooltip": "", prop: "material", key: "material", label: "材质", align: "center" }), e(t, { "show-overflow-tooltip": "", prop: "pricingManner", key: "pricingManner", label: "计价方式", align: "center" }, { default: n((i) => [v("span", null, p(i.row.pricingManner ? m(Y).VL[i.row.pricingManner] : "-"), 1)]), _: 1 }), e(t, { "show-overflow-tooltip": "", prop: "quantity", key: "quantity", label: "数量", align: "center" }), e(t, { "show-overflow-tooltip": "", prop: "measureUnit", key: "measureUnit", label: "单位", align: "center" }), e(t, { "show-overflow-tooltip": "", prop: "mete", key: "mete", label: "核算量", align: "center" }), e(t, { "show-overflow-tooltip": "", prop: "accountingUnit", key: "accountingUnit", label: "核算单位", align: "center" }), e(t, { "show-overflow-tooltip": "", prop: "unitPrice", key: "unitPrice", label: "单价（元）", align: "center", width: "100px" }), e(t, { "show-overflow-tooltip": "", prop: "totalAmount", key: "totalAmount", label: "总价（元）", align: "center", width: "100px" }), e(t, { "show-overflow-tooltip": "", prop: "handleSerialNumber", key: "handleSerialNumber", label: "单据", align: "center" })]), _: 1 }, 8, ["data", "max-height", "data-format"])), [[C, u.value]])];
    }), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, $ = z(Q, [["__scopeId", "data-v-cf119e4e"]]);
export {
  $ as default
};
