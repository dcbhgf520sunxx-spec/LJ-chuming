import { ref as i } from "vue";
import I from "moment";
import { computed as B } from "vue";
import { resolveComponent as O } from "vue";
import { openBlock as x } from "vue";
import { createElementBlock as w } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as r } from "vue";
import { withDirectives as C } from "vue";
import { normalizeStyle as S } from "vue";
import { unref as k } from "vue";
import { createBlock as T } from "vue";
import { withCtx as m } from "vue";
import { toDisplayString as _ } from "vue";
import { ElDatePicker as P } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { vLoading as F } from "element-plus";
import { l as M, t as N, o as U, iH as j, ba as q } from "../../../shared/runtime.js";
import { u as L } from "../../../modules/use-chart-59e4b63c.js";
import "../../../modules/index-18acf776.js";
function Y({ branchCompanyId: g, dateTime: n }) {
  return M({ url: "/api/operational/analysis/income", method: "get", params: { branchCompanyId: g, dateTime: n } });
}
const $ = { class: "app-container" }, G = { class: "head-container" }, J = { style: { display: "flex" } }, X = { __name: "index", setup(g) {
  const { decimalPrecision: n } = N();
  function V(e) {
    return e > /* @__PURE__ */ new Date();
  }
  const p = i(I().valueOf()), h = i(), u = i(false), f = i([]);
  for (let e = 1; e <= 12; e++) f.value.push(e + "月");
  const d = i([]), { maxHeight: b } = U({ extraHeight: 0 }), A = B(() => [["income", ["to-thousand", n.value.operation]], ["expend", ["to-thousand", n.value.operation]]]);
  function D(e) {
    return q(e, { props: [["income", n.value.operation], ["expend", n.value.operation]], toThousandFields: ["income", "expend"] });
  }
  const { getMyChart: E } = L({ elementId: "incomeExpenditureChart", fetchHook: v, initOption: { legend: { right: 0 }, title: { text: "收入与支出" }, yAxis: { type: "category", axisTick: { show: false }, data: f.value }, xAxis: { type: "value" }, series: [{ name: "收入", type: "bar", data: [] }, { name: "支出", type: "bar", data: [] }] } });
  async function v() {
    try {
      u.value = true;
      const e = E(), { content: o } = await Y({ dateTime: p.value, branchCompanyId: h.value });
      d.value = f.value.reduce((a, y, c) => {
        const t = o.find((H) => H.month === c + 1) || {};
        return a.push({ month: y, income: t.intoAmount || 0, expend: t.outAmount || 0 }), a;
      }, []);
      const s = e.getOption();
      s.series[0].data = d.value.map((a) => a.income), s.series[1].data = d.value.map((a) => a.expend), e.setOption(s);
    } catch (e) {
      console.log(e, "获取年度信息失败");
    } finally {
      u.value = false;
    }
  }
  return (e, o) => {
    const s = P, a = z, y = O("common-table"), c = F;
    return x(), w("div", $, [l("div", G, [r(s, { modelValue: p.value, "onUpdate:modelValue": o[0] || (o[0] = (t) => p.value = t), type: "year", size: "default", style: { width: "300px" }, placeholder: "选择年", clearable: false, "value-format": "x", "disabled-date": V, class: "filter-item", onChange: v }, null, 8, ["modelValue"]), r(j, { modelValue: h.value, "onUpdate:modelValue": o[1] || (o[1] = (t) => h.value = t), clearable: "", class: "filter-item", onChange: v, style: { width: "350px" } }, null, 8, ["modelValue"])]), l("div", J, [C((x(), w("div", { style: S([{ height: k(b) + "px" }, { flex: "1" }]) }, o[2] || (o[2] = [l("div", { id: "incomeExpenditureChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[c, u.value]]), C((x(), T(y, { data: d.value, height: k(b), "data-format": A.value, "show-summary": "", "summary-method": D, style: { width: "500px", "margin-left": "20px" } }, { default: m(() => [r(a, { "show-overflow-tooltip": true, label: "月份", align: "center" }, { default: m(({ row: t }) => [l("span", null, _(t.month), 1)]), _: 1 }), r(a, { prop: "income", "show-overflow-tooltip": true, label: "收入", align: "center" }, { default: m(({ row: t }) => [l("span", null, _(t.income), 1)]), _: 1 }), r(a, { prop: "expend", "show-overflow-tooltip": true, label: "支出", align: "center" }, { default: m(({ row: t }) => [l("span", null, _(t.expend), 1)]), _: 1 })]), _: 1 }, 8, ["data", "height", "data-format"])), [[c, u.value]])])]);
  };
} };
export {
  X as default
};
