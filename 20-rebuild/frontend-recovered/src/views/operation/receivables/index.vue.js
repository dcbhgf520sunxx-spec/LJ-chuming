import { ref as y } from "vue";
import { computed as j } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as v } from "vue";
import { createElementBlock as w } from "vue";
import { createElementVNode as a } from "vue";
import { createVNode as s } from "vue";
import { withDirectives as x } from "vue";
import { unref as d } from "vue";
import { createBlock as h } from "vue";
import { createCommentVNode as b } from "vue";
import { normalizeStyle as k } from "vue";
import { withCtx as p } from "vue";
import { toDisplayString as f } from "vue";
import { ElTableColumn as M } from "element-plus";
import { vLoading as O } from "element-plus";
import { l as D, _ as B, t as z, o as P, n as F, z as H, ba as K } from "../../../shared/runtime.js";
import { u as U } from "../../../modules/use-chart-59e4b63c.js";
import { P as _ } from "../../../modules/index-5b9e6004.js";
import "../../../modules/index-18acf776.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
function q(E) {
  return D({ url: "/api/operational/analysis/collection", method: "get", params: E });
}
const R = { class: "app-container" }, G = { class: "head-container" }, J = { class: "view-summary" }, Q = { style: { display: "flex" } }, W = { class: "project-name" }, X = { __name: "index", setup(E) {
  const { decimalPrecision: r } = z(), { maxHeight: V } = P({ extraBox: [".head-container", ".view-summary"] }), A = y(false), l = y({}), n = y(), C = y([]), u = { INVOICE: { L: "已开票应收", K: "INVOICE", V: 1, field: "invoiceAmount" }, SETTLEMENT: { L: "已结算应收", K: "SETTLEMENT", V: 2, field: "settlementAmount" } };
  F(u);
  const I = j(() => [["contractAmount", ["to-thousand", r.value.operation]], ["invoiceAmount", ["to-thousand", r.value.operation]], ["settlementAmount", ["to-thousand", r.value.operation]], ["collectionAmount", ["to-thousand", r.value.operation]], ["receivableAmount", ["to-thousand", r.value.operation]]]);
  function L(c) {
    return K(c, { props: [["contractAmount", r.value.operation], ["invoiceAmount", r.value.operation], ["settlementAmount", r.value.operation], ["receivableAmount", r.value.operation]], toThousandFields: ["contractAmount", "invoiceAmount", "settlementAmount", "receivableAmount"] });
  }
  const { getMyChart: S } = U({ elementId: "pieChart", fetchHook: N, initOption: { title: { text: u.VL[n.value] }, xAxis: { show: false }, tooltip: { trigger: "item" }, legend: { cancelDefaultData: true, top: "center", left: "right", orient: "vertical" }, series: [{ type: "pie", radius: [50, 110], center: ["40%", "50%"], roseType: "area", itemStyle: { borderRadius: 8 }, label: { show: true }, data: [] }] } });
  async function N() {
    try {
      const c = S();
      if (!c) return;
      const i = c.getOption();
      A.value = true;
      const { content: g } = await q({ type: n.value });
      l.value = g.reduce((e, m) => {
        e.projectCount++, e.invoiceAmount += m.invoiceAmount || 0, e.collectionAmount += m.collectionAmount || 0, e.settlementAmount += m.settlementAmount || 0;
        const o = m.accountAge;
        return o <= 10 ? e.accountAge[0].value++ : o > 10 && o <= 30 ? e.accountAge[1].value++ : o > 30 && o <= 60 ? e.accountAge[2].value++ : o > 60 && o <= 180 ? e.accountAge[3].value++ : o > 180 && e.accountAge[4].value++, e;
      }, { projectCount: 0, invoiceAmount: 0, collectionAmount: 0, settlementAmount: 0, receivableAmount: 0, accountAge: [{ value: 0, name: "≤10天" }, { value: 0, name: "<10天≤30天" }, { value: 0, name: "<30天≤60天" }, { value: 0, name: "<60天≤180天" }, { value: 0, name: ">180天" }] }), l.value.receivableAmount = l.value[u.V[n.value].field] - l.value.collectionAmount, C.value = g.map((e) => {
        e.project = { id: e.id, name: e.name, serialNumber: e.serialNumber, shortName: e.shortName };
        const m = e[u.V[n.value].field] || 0;
        return e.collectionAmount = e.collectionAmount || 0, e.receivableAmount = m - e.collectionAmount, e;
      }), i.title[0].text = u.VL[n.value], i.series[0].data = l.value.accountAge, c.setOption(i);
    } catch (c) {
      console.log(c, "获取应收款信息");
    } finally {
      A.value = false;
    }
  }
  return (c, i) => {
    const g = T("common-radio-button"), e = M, m = T("common-table"), o = O;
    return v(), w("div", R, [a("div", G, [s(g, { modelValue: n.value, "onUpdate:modelValue": i[0] || (i[0] = (t) => n.value = t), options: u.ENUM, default: "", type: "enum", onChange: N }, null, 8, ["modelValue", "options"]), i[1] || (i[1] = a("div", { style: { float: "right", "font-size": "16px", color: "#303133" } }, "单位：元", -1))]), x((v(), w("div", J, [s(d(_), { name: "应收项目", "num-color": "#1890ff", "end-val": l.value.projectCount || 0, class: "summary-item" }, null, 8, ["end-val"]), n.value === u.INVOICE.V ? (v(), h(d(_), { key: 0, name: "开票总额", "num-color": "#1890ff", "end-val": l.value.invoiceAmount || 0, class: "summary-item" }, null, 8, ["end-val"])) : b("", true), n.value === u.SETTLEMENT.V ? (v(), h(d(_), { key: 1, name: "结算总额", "num-color": "#1890ff", "end-val": l.value.settlementAmount || 0, class: "summary-item" }, null, 8, ["end-val"])) : b("", true), s(d(_), { name: "实际收款", "num-color": "#1890ff", "end-val": l.value.collectionAmount || 0, class: "summary-item" }, null, 8, ["end-val"]), s(d(_), { name: "应收款", "num-color": "#1890ff", "end-val": l.value.receivableAmount || 0, class: "summary-item" }, null, 8, ["end-val"])])), [[o, A.value]]), a("div", Q, [x((v(), w("div", { style: k([{ height: d(V) + "px" }, { flex: "1", "margin-right": "20px" }]) }, i[2] || (i[2] = [a("div", { id: "pieChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[o, A.value]]), x((v(), h(m, { height: d(V), data: C.value, "data-format": I.value, "show-summary": "", "summary-method": L, style: { flex: "1" } }, { default: p(() => [s(e, { label: "序号", type: "index", align: "center", width: "60" }), s(e, { prop: "project.shortName", "show-overflow-tooltip": true, label: "所属项目", "min-width": "120" }, { default: p(({ row: t }) => [a("span", W, f(d(H)(t.project, null, false)), 1)]), _: 1 }), s(e, { prop: "contractAmount", "show-overflow-tooltip": true, label: "合同额", align: "center" }, { default: p(({ row: t }) => [a("span", null, f(t.contractAmount), 1)]), _: 1 }), n.value === u.INVOICE.V ? (v(), h(e, { key: 0, prop: "invoiceAmount", "show-overflow-tooltip": true, label: "累计开票额", align: "center" }, { default: p(({ row: t }) => [a("span", null, f(t.invoiceAmount), 1)]), _: 1 })) : b("", true), n.value === u.SETTLEMENT.V ? (v(), h(e, { key: 1, prop: "settlementAmount", "show-overflow-tooltip": true, label: "结算额", align: "center" }, { default: p(({ row: t }) => [a("span", null, f(t.settlementAmount), 1)]), _: 1 })) : b("", true), s(e, { prop: "collectionAmount", "show-overflow-tooltip": true, label: "实际收款", align: "center" }, { default: p(({ row: t }) => [a("span", null, f(t.collectionAmount), 1)]), _: 1 }), s(e, { prop: "receivableAmount", "show-overflow-tooltip": true, label: "应收款", align: "center" }, { default: p(({ row: t }) => [a("span", null, f(t.receivableAmount), 1)]), _: 1 }), s(e, { "show-overflow-tooltip": true, label: "账龄(天)", align: "center" }, { default: p(({ row: t }) => [a("span", null, f(t.accountAge), 1)]), _: 1 })]), _: 1 }, 8, ["height", "data", "data-format"])), [[o, A.value]])])]);
  };
} }, ne = B(X, [["__scopeId", "data-v-afb6df98"]]);
export {
  ne as default
};
