import { ref as r } from "vue";
import { withDirectives as h } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as p } from "vue";
import { createElementVNode as m } from "vue";
import { normalizeStyle as u } from "vue";
import { vLoading as g } from "element-plus";
import { u as f } from "../../../modules/use-chart-v2-ba3ec3fa.js";
import "../../../modules/index-18acf776.js";
const b = { __name: "project-total-process", props: { maxHeight: [Number, String], default: void 0 }, setup(i) {
  const o = r(false), l = r(false), { getMyChart: n } = f({ elementId: "projectTotalProcessChart", fetchHook: c, initOption: { grid: { right: "20" }, legend: { data: ["清单量", "完成量"], left: "center" }, custom: { title: [{ text: "项目总体进度" }, { text: "单位：吨", right: 0, textStyle: { fontSize: 13 } }] }, yAxis: [{ data: ["深化设计", "生产加工", "物流发运", "项目安装"], axisLabel: { rotate: 45 } }], xAxis: { axisLabel: { formatter: "{value}%" } }, series: [{ name: "清单量", type: "bar", stack: "total", emphasis: { itemStyle: { shadowBlur: 10, shadowColor: "rgba(0,0,0,0.3)" } }, label: { show: true, distance: 5, position: "right" }, data: [10, 20] }, { name: "完成量", type: "bar", stack: "total", emphasis: { itemStyle: { shadowBlur: 10, shadowColor: "rgba(0,0,0,0.3)" } }, label: { show: true, distance: 5, position: "right" }, data: [20, 30] }] } });
  async function c(s) {
    try {
      o.value = true;
      const t = s || n(), e = t.getOption();
      t.on("click", function(a) {
        console.log(a, "params"), l.value = true;
      }), e.xAxis[0].data = content.map((a) => a.year), e.series[0].data = content.map((a) => a.averageDifferenceRatio), t.setOption(e);
    } catch (t) {
      console.log(t, "获取差异分析柱状图失败");
    } finally {
      o.value = false;
    }
  }
  return (s, t) => {
    const e = g;
    return h((d(), p("div", { style: u({ height: i.maxHeight + "px" }) }, t[0] || (t[0] = [m("div", { id: "projectTotalProcessChart", style: { width: "100%", height: "100%" } }, null, -1)]), 4)), [[e, o.value]]);
  };
} };
export {
  b as default
};
