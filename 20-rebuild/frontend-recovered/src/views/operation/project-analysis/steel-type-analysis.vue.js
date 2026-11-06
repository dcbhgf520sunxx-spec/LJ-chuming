import { ref as f } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as g } from "vue";
import { createElementVNode as c } from "vue";
import { withDirectives as y } from "vue";
import { normalizeStyle as w } from "vue";
import { createBlock as F } from "vue";
import { withCtx as S } from "vue";
import { createVNode as r } from "vue";
import { Fragment as H } from "vue";
import { ElTableColumn as N } from "element-plus";
import { vLoading as B } from "element-plus";
import { ba as T } from "../../../shared/runtime.js";
import { u as A } from "../../../modules/use-chart-59e4b63c.js";
import "../../../modules/index-18acf776.js";
const D = { style: { display: "flex" } }, L = { __name: "steel-type-analysis", props: { maxHeight: [Number, String], default: void 0 }, setup(u) {
  const p = f(false), b = f([{}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}]), { getMyChart: x } = A({ elementId: "steelTypeAnalysisChart", fetchHook: C, initOption: { color: ["#009DFF", "#22E4FF", "#3BFFD0", "#04E38A", "#9DFF86"], tooltip: { trigger: "item", appendToBody: true, position: function(e, t, a, o, n) {
    var l = 0, i = 0, s = e[0], m = e[1], v = n.contentSize[0], d = n.contentSize[1];
    return v > s ? l = 5 : l = s - v, d > m ? i = 5 : i = m - d, [l, i];
  }, confine: true, extraCssText: "max-width: 370px;white-space:pre-wrap;" }, legend: { show: true, orient: "vertical", type: "scroll", top: 7, right: 10, formatter: function(e) {
    let t = "";
    const a = e.length, o = 15, n = Math.ceil(a / o);
    if (a > o) for (let l = 0; l < n; l++) {
      const i = l * o, s = i + o, m = l === n - 1 ? e.substring(i, a) : e.substring(i, s) + `
`;
      t += m;
    }
    else t = e;
    return t;
  } }, series: [{ type: "pie", center: ["35%", "45%"], data: [{ name: "焊接H型构件", value: "10" }, { name: "箱体构件", value: "15" }, { name: "圆管构件", value: "25" }, { name: "方管构件", value: "10" }, { name: "变形构件", value: "30" }, { name: "构件1", value: "10" }, { name: "构件2", value: "15" }, { name: "构件3", value: "25" }, { name: "构件4", value: "10" }, { name: "构件5", value: "30" }, { name: "构件6", value: "10" }, { name: "构件7", value: "15" }, { name: "构件8", value: "25" }, { name: "构件9", value: "10" }, { name: "构件10", value: "30" }, { name: "构件11", value: "30" }, { name: "构件12", value: "30" }, { name: "构件13", value: "30" }, { name: "构件14", value: "30" }], label: { formatter: (e) => `${e.value}` }, emphasis: { itemStyle: { shadowBlur: 10, shadowOffsetX: 0, shadowColor: "rgba(0, 0, 0, 0.5)" } } }] } });
  async function C(e) {
    try {
      p.value = true;
      const t = e || x();
      t.on("click", function(n) {
        console.log(n, "params");
      });
      const { content: a } = await getDiffAverageAnalysis({ range: 10 }), o = t.getOption();
      o.series[0].data = [{ name: "焊接H型构件", value: "30%" }], t.setOption(o);
    } catch (t) {
      console.log(t, "获取差异分析柱状图失败");
    } finally {
      p.value = false;
    }
  }
  function k(e) {
    return T(e, { props: ["quantity", "mete"] });
  }
  return (e, t) => {
    const a = N, o = _("common-table"), n = B;
    return h(), g(H, null, [t[1] || (t[1] = c("div", { style: { "font-size": "18px", "font-weight": "bold" } }, "钢材类型分析", -1)), c("div", D, [y((h(), g("div", { style: w({ height: u.maxHeight + "px", flex: 1 }) }, t[0] || (t[0] = [c("div", { id: "steelTypeAnalysisChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[n, p.value]]), c("div", { style: w(`width: 70%;height: ${u.maxHeight}px`) }, [y((h(), F(o, { ref: "tableRef", data: b.value, height: u.maxHeight, "show-summary": "", "summary-method": k, style: { width: "100%" } }, { default: S(() => [r(a, { align: "center", label: "序号", type: "index", width: "55" }), r(a, { key: "mainType", align: "center", "show-overflow-tooltip": "", label: "类别", prop: "mainType" }), r(a, { key: "specification", align: "center", "show-overflow-tooltip": "", label: "规格", prop: "specification" }), r(a, { key: "material", align: "center", "show-overflow-tooltip": "", label: "材质", prop: "material" }), r(a, { key: "mete", prop: "mete", align: "center", "show-overflow-tooltip": "", label: "重量（吨）" }), r(a, { key: "productMete", prop: "productMete", align: "center", "show-overflow-tooltip": "", label: "占比" })]), _: 1 }, 8, ["data", "height"])), [[n, e.tableLoading]])], 4)])], 64);
  };
} };
export {
  L as default
};
