import { ref as p } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as k } from "vue";
import { createElementVNode as N } from "vue";
import { createVNode as s } from "vue";
import { withCtx as d } from "vue";
import { unref as e } from "vue";
import { createBlock as a } from "vue";
import { createCommentVNode as n } from "vue";
import { withDirectives as B } from "vue";
import { ElTableColumn as C } from "element-plus";
import { vLoading as D } from "element-plus";
import { l as R, au as T, x as P, o as U, G as j, P as E } from "../../../../shared/runtime.js";
import { x as u } from "../../../../modules/crm-c6ba92ff.js";
import W from "./module/header.vue.js";
function F(l) {
  return R({ module: "crm", url: "data/center/new/project", method: "get", params: l });
}
const H = { get: F }, S = { class: "app-container" }, V = { class: "head-container" }, O = { __name: "index", setup(l) {
  const f = { add: false, edit: false, del: false, download: false }, h = p([["informantDateTime", ["parse-time"]], ["isWinningBidder", ["parse-enum", T]]]), m = p(), { crud: i, CRUD: _, columns: r } = P({ title: "工程信息登记统计", sort: [], optShow: { ...f }, permission: { permission: u }, crudApi: { ...H }, hasPagination: true }, m), { maxHeight: g } = U({ extraBox: [".head-container"], paginate: true });
  return _.HOOK.handleRefresh = (w, { data: b }) => {
  }, (w, b) => {
    const v = c("print-table"), o = C, y = c("common-table"), x = D;
    return t(), k("div", S, [N("div", V, [s(W, null, { printBtn: d(() => [e(j)(e(u).print) ? (t(), a(v, { key: 0, "api-key": "engineerInformationReport", params: { ...e(i).query }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"])) : n("", true)]), _: 1 })]), B((t(), a(y, { ref_key: "tableRef", ref: m, data: e(i).data, "empty-text": e(i).emptyText, dataFormat: h.value, "max-height": e(g), "row-key": "id", style: { width: "100%" } }, { default: d(() => [s(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(r).visible("departmentName") ? (t(), a(o, { key: "departmentName", prop: "departmentName", "show-overflow-tooltip": true, label: "销售部", align: "center" })) : n("", true), e(r).visible("informantUserName") ? (t(), a(o, { align: "center", key: "informantUserName", prop: "informantUserName", "show-overflow-tooltip": true, label: "销售员" })) : n("", true), e(r).visible("projectName") ? (t(), a(o, { key: "projectName", prop: "projectName", align: "center", "show-overflow-tooltip": true, label: "工程名称" })) : n("", true), e(r).visible("informantDateTime") ? (t(), a(o, { key: "informantDateTime", prop: "informantDateTime", "show-overflow-tooltip": true, align: "center", label: "创建时间" })) : n("", true), e(r).visible("estimatedCost") ? (t(), a(o, { key: "estimatedCost", prop: "estimatedCost", align: "center", "show-overflow-tooltip": true, label: "预测金额(万元)" })) : n("", true), e(r).visible("isWinningBidder") ? (t(), a(o, { key: "isWinningBidder", prop: "isWinningBidder", align: "center", "show-overflow-tooltip": true, label: "是否中标" })) : n("", true), e(r).visible("amount") ? (t(), a(o, { key: "amount", prop: "amount", align: "center", "show-overflow-tooltip": true, label: "中标金额(万元)" })) : n("", true)]), _: 1 }, 8, ["data", "empty-text", "dataFormat", "max-height"])), [[x, e(i).loading]]), s(e(E))]);
  };
} };
export {
  O as default
};
