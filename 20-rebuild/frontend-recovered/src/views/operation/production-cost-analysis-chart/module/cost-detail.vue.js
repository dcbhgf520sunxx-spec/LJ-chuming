import { ref as w } from "vue";
import { onMounted as O } from "vue";
import { watch as v } from "vue";
import { resolveComponent as q } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as L } from "vue";
import { createElementVNode as l } from "vue";
import { unref as r } from "vue";
import { createBlock as k } from "vue";
import { withCtx as a } from "vue";
import { createTextVNode as B } from "vue";
import { createCommentVNode as C } from "vue";
import { withDirectives as I } from "vue";
import { createVNode as o } from "vue";
import { toDisplayString as i } from "vue";
import { ElTableColumn as j } from "element-plus";
import { vLoading as z } from "element-plus";
import { c as D, d as E } from "../../../../modules/production-cost-analysis-chart-d811fbd9.js";
import { G as g, L as V, p as F, i as s } from "../../../../shared/runtime.js";
const R = { class: "head-container", style: { display: "flex", "justify-content": "space-between" } }, $ = { __name: "cost-detail", props: { maxHeight: { type: [Number, String], default: void 0 }, query: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, setup(c) {
  const u = c, _ = w(), x = w(false), p = w([]);
  O(() => {
    b();
  }), v(() => u.query, (h) => {
    b();
  }, { deep: true });
  async function b() {
    var h;
    if (!g((h = u.permission) == null ? void 0 : h.get)) return false;
    try {
      const m = await D({ ...u.query });
      p.value = m || [], p.value.forEach((t) => {
        var d;
        ["平均单价", "金额合计", "产量合计"].includes(t.className) ? t.type = 2 : t.type = 1, (d = t == null ? void 0 : t.costInfoList) == null || d.forEach((n) => {
          switch (n.month) {
            case "1月":
              t.month1 = n.costOrMete;
              break;
            case "2月":
              t.month2 = n.costOrMete;
              break;
            case "3月":
              t.month3 = n.costOrMete;
              break;
            case "4月":
              t.month4 = n.costOrMete;
              break;
            case "5月":
              t.month5 = n.costOrMete;
              break;
            case "6月":
              t.month6 = n.costOrMete;
              break;
            case "7月":
              t.month7 = n.costOrMete;
              break;
            case "8月":
              t.month8 = n.costOrMete;
              break;
            case "9月":
              t.month9 = n.costOrMete;
              break;
            case "10月":
              t.month10 = n.costOrMete;
              break;
            case "11月":
              t.month11 = n.costOrMete;
              break;
            case "12月":
              t.month12 = n.costOrMete;
              break;
            default:
              break;
          }
        });
      });
    } catch (m) {
      console.log(m, "获取生产成本分析列表失败");
    }
  }
  function M({ row: h, rowIndex: m }) {
    if (h.className === "平均单价") return { position: "sticky", bottom: "0 !important", zIndex: 1 };
    if (h.className === "金额合计") return { position: "sticky", bottom: "80px !important", zIndex: 1 };
    if (h.className === "产量合计") return { position: "sticky", bottom: "40px !important", zIndex: 1 };
  }
  return (h, m) => {
    var n;
    const t = j, y = q("common-table"), d = z;
    return f(), L("div", null, [l("div", R, [m[1] || (m[1] = l("div", { style: { "font-size": "18px", "font-weight": "bold" } }, "成本明细表", -1)), r(g)((n = c.permission) == null ? void 0 : n.download) ? (f(), k(V, { key: 0, fn: r(E), params: { ...c.query } }, { default: a(() => m[0] || (m[0] = [B("成本明细清单")])), _: 1, __: [0] }, 8, ["fn", "params"])) : C("", true)]), I((f(), k(y, { ref_key: "tableRef", ref: _, data: p.value, border: "", "max-height": c.maxHeight, style: { width: "100%" }, "show-empty-symbol": false, "row-style": M }, { default: a(() => [o(t, { align: "center", label: "序号", type: "index" }, { default: a(({ row: e, $index: N }) => [l("div", null, i(e.type === 2 ? "" : N + 1), 1)]), _: 1 }), o(t, { key: "className", align: "center", "show-overflow-tooltip": "", label: "类别", prop: "className", width: "90" }), o(t, { key: "processName", align: "center", "show-overflow-tooltip": "", label: `年度：${r(F)(c.query.yearDate, "{y}") + "   "} 金额：元`, prop: "applicantName" }, { default: a(() => [o(t, { key: "month1", prop: "month1", align: "center", label: "1月", width: "70" }, { default: a((e) => [l("div", null, i(r(s)(e.row.month1) ? e.row.month1 : "-"), 1)]), _: 1 }), o(t, { key: "month2", prop: "month2", align: "center", label: "2月", width: "70" }, { default: a((e) => [l("div", null, i(r(s)(e.row.month2) ? e.row.month2 : "-"), 1)]), _: 1 }), o(t, { key: "month3", prop: "month3", align: "center", label: "3月", width: "80" }, { default: a((e) => [l("div", null, i(r(s)(e.row.month3) ? e.row.month3 : "-"), 1)]), _: 1 }), o(t, { key: "month4", prop: "month4", align: "center", label: "4月", width: "70" }, { default: a((e) => [l("div", null, i(r(s)(e.row.month4) ? e.row.month4 : "-"), 1)]), _: 1 }), o(t, { key: "month5", prop: "month5", align: "center", label: "5月", width: "70" }, { default: a((e) => [l("div", null, i(r(s)(e.row.month5) ? e.row.month5 : "-"), 1)]), _: 1 }), o(t, { key: "month6", prop: "month6", align: "center", label: "6月", width: "70" }, { default: a((e) => [l("div", null, i(r(s)(e.row.month6) ? e.row.month6 : "-"), 1)]), _: 1 }), o(t, { key: "month7", prop: "month7", align: "center", label: "7月", width: "70" }, { default: a((e) => [l("div", null, i(r(s)(e.row.month7) ? e.row.month7 : "-"), 1)]), _: 1 }), o(t, { key: "month8", prop: "month8", align: "center", label: "8月", width: "70" }, { default: a((e) => [l("div", null, i(r(s)(e.row.month8) ? e.row.month8 : "-"), 1)]), _: 1 }), o(t, { key: "month9", prop: "month9", align: "center", label: "9月", width: "70" }, { default: a((e) => [l("div", null, i(r(s)(e.row.month9) ? e.row.month9 : "-"), 1)]), _: 1 }), o(t, { key: "month10", prop: "month10", align: "center", label: "10月", width: "70" }, { default: a((e) => [l("div", null, i(r(s)(e.row.month10) ? e.row.month10 : "-"), 1)]), _: 1 }), o(t, { key: "month11", prop: "month11", align: "center", label: "11月", width: "70" }, { default: a((e) => [l("div", null, i(r(s)(e.row.month11) ? e.row.month11 : "-"), 1)]), _: 1 }), o(t, { key: "month12", prop: "month12", align: "center", label: "12月", width: "70" }, { default: a((e) => [l("div", null, i(r(s)(e.row.month12) ? e.row.month12 : "-"), 1)]), _: 1 })]), _: 1 }, 8, ["label"]), o(t, { key: "sumMete", prop: "sumMete", align: "center", "show-overflow-tooltip": "", label: `合计
（元）` }), o(t, { key: "avgMete", prop: "avgMete", align: "center", "show-overflow-tooltip": "", label: `平均
（元/吨）` })]), _: 1 }, 8, ["data", "max-height"])), [[d, x.value]])]);
  };
} };
export {
  $ as default
};
