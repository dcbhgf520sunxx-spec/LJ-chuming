import { resolveComponent as s } from "vue";
import { openBlock as p } from "vue";
import { createBlock as m } from "vue";
import { withCtx as a } from "vue";
import { createVNode as o } from "vue";
import { createElementVNode as l } from "vue";
import { toDisplayString as n } from "vue";
import { ElTableColumn as u } from "element-plus";
const d = { __name: "preview", props: { previewTableData: { type: Object, default: () => {
} }, maxHeight: { type: [Number, String], default: void 0 } }, setup(r) {
  return (c, w) => {
    const t = u, i = s("common-table");
    return p(), m(i, { ref: "tableRef", data: r.previewTableData, "max-height": r.maxHeight, showEmptySymbol: false, style: { width: "100%" } }, { default: a(() => [o(t, { label: "序号", type: "index", align: "center", width: "60" }), o(t, { key: "monomerName", prop: "monomerName", "show-overflow-tooltip": "", label: "单体", align: "center" }, { default: a((e) => [l("span", null, n(e.row.monomerName || "-"), 1)]), _: 1 }), o(t, { key: "areaBatchName", prop: "areaBatchName", "show-overflow-tooltip": "", label: "批次", align: "center" }, { default: a((e) => [l("span", null, n(e.row.areaBatchName || "-"), 1)]), _: 1 }), o(t, { key: "artifactClassName", prop: "artifactClassName", "show-overflow-tooltip": "", label: "构件类别", align: "center" }, { default: a((e) => [l("span", null, n(e.row.artifactClassName || "-"), 1)]), _: 1 }), o(t, { key: "totalNetWeight", prop: "totalNetWeight", "show-overflow-tooltip": "", label: "总净重(kg)", align: "center" }, { default: a((e) => [l("span", null, n(e.row.totalNetWeight ?? "-"), 1)]), _: 1 }), o(t, { key: "totalGrossWeight", prop: "totalGrossWeight", "show-overflow-tooltip": "", label: "总毛重(kg)", align: "center" }, { default: a((e) => [l("span", null, n(e.row.totalGrossWeight ?? "-"), 1)]), _: 1 }), o(t, { key: "cumulativeFeedingQuantity", prop: "cumulativeFeedingQuantity", "show-overflow-tooltip": "", label: "累计已投料量(t)", align: "center" }, { default: a((e) => [l("span", null, n(e.row.cumulativeFeedingQuantity ?? "-"), 1)]), _: 1 }), o(t, { key: "feedingQuantity", prop: "feedingQuantity", "show-overflow-tooltip": "", label: "本次投料量(kg)", align: "center" }, { default: a((e) => [l("span", null, n(e.row.feedingQuantity ?? "-"), 1)]), _: 1 }), o(t, { key: "workshopId", prop: "workshopId", "show-overflow-tooltip": "", label: "生产车间", align: "center" }, { default: a((e) => [l("span", null, n(e.row.workshopName || "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"]);
  };
} };
export {
  d as default
};
