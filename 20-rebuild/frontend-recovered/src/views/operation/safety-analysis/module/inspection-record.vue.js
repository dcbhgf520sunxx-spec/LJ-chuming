import { ref as h } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as d } from "vue";
import { createBlock as u } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as e } from "vue";
import { ElTableColumn as b } from "element-plus";
import { ElCard as g } from "element-plus";
import { u as w } from "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
const v = { __name: "inspection-record", props: { query: { type: Object, default: () => ({}) }, permission: { type: Object, default: () => {
} }, maxHeight: { type: [Number, String], default: void 0 } }, setup(l) {
  const i = h([{}, {}, {}, {}, {}, {}, {}, {}, {}]), { getMyChart: n } = w({ elementId: "teamSafetyProblem", fetchHook: s, initOption: { grid: { top: "15", bottom: "15", right: "30", left: "20" }, yAxis: { type: "category", axisTick: { show: true }, axisLabel: { show: true, fontSize: 10 }, data: ["张三", "李四", "王五", "测试"] }, xAxis: { type: "value", min: 0, max: 100, axisTick: { show: true, length: 8, lineStyle: { width: 1 } }, axisLabel: { show: true, margin: 16, fontSize: 10 } }, tooltip: { show: true, padding: 8, textStyle: { fontSize: 10 }, axisPointer: { type: "shadow" } }, series: [{ name: "", data: [10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 100, 100], type: "bar", barMaxWidth: 30, label: { show: true, verticalAlign: "middle", distance: 3, position: "right" }, itemStyle: { color: "#119760" } }] } });
  async function s(r) {
    (r || n()).getOption();
  }
  return (r, o) => {
    const t = b, m = c("common-table"), p = g;
    return d(), u(p, null, { header: a(() => o[0] || (o[0] = [f("div", null, "巡检记录（近30天内）", -1)])), default: a(() => [e(m, { ref: "tableRef", data: i.value, height: l.maxHeight, "max-height": l.maxHeight, style: { width: "100%" }, border: false }, { default: a(() => [e(t, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(t, { "show-overflow-tooltip": true, prop: "problemName", label: "日期", align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "totalProblems", label: "编号", align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "totalProblems", label: "检查人", align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "totalProblems", label: "问题", align: "center" })]), _: 1 }, 8, ["data", "height", "max-height"])]), _: 1 });
  };
} };
export {
  v as default
};
