import { provide as p } from "vue";
import { resolveDirective as c } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as f } from "vue";
import { createVNode as o } from "vue";
import { withCtx as n } from "vue";
import { withDirectives as i } from "vue";
import { unref as t } from "vue";
import { createBlock as _ } from "vue";
import { createCommentVNode as g } from "vue";
import { ElCol as u } from "element-plus";
import { ElRow as d } from "element-plus";
import { fr as e, m as x, a3 as b } from "../../../../shared/runtime.js";
import y from "./component/overweight-sms-config.vue.js";
import G from "./component/safe-amount-config.vue.js";
import C from "./component/drawing-sn-config.vue.js";
import $ from "./component/app-print-config.vue.js";
import h from "./component/car-model-config.vue.js";
import w from "./component/folding-price-method.vue.js";
import M from "./component/steel-bind-config.vue.js";
import S from "./component/app-task-report.vue.js";
import v from "./component/machine-part-scheduling-config.vue.js";
import P from "./component/structure-audit-config.vue.js";
import E from "./component/price-manage-config.vue.js";
import k from "./component/app-show-weight-config.vue.js";
import R from "./component/measuring-add-coating-config.vue.js";
import B from "./component/deep_pen_config.vue.js";
import N from "./component/wage-statistics-deadline-config.vue.js";
import D from "./component/raw-material-loss-formula.vue.js";
import T from "./component/mes-warehouse-manage.vue.js";
import L from "./component/nest-task-config.vue.js";
import V from "./component/product-label-config.vue.js";
import "../../../../modules/base-6bc46ddf.js";
import "../../../../modules/index-9d220fe1.js";
import "../../../../modules/use-users-4d979987.js";
const F = { class: "app-container" }, _t = { __name: "index", setup(W) {
  p("permission", e);
  const { productMenu: s } = x("productMenu");
  return (q, A) => {
    const r = u, l = d, m = c("permission");
    return a(), f("div", F, [o(l, { gutter: 20 }, { default: n(() => [o(r, { xs: 24, sm: 24, md: 12, lg: 8 }, { default: n(() => [i(o(t(y), { style: { "margin-bottom": "20px" } }, null, 512), [[m, t(e).overweightSMSRecipientGet]]), i(o(t(G), { style: { "margin-bottom": "20px" } }, null, 512), [[m, t(e).safeAmountFactorGet]]), i(o(M, { style: { "margin-bottom": "20px" } }, null, 512), [[m, t(e).steelBindConfigGet]]), i(o(t(E), { style: { "margin-bottom": "20px" } }, null, 512), [[m, t(e).machinePartStructureGet]]), i(o(N, { style: { "margin-bottom": "20px" } }, null, 512), [[m, t(e).wageStatisticsDeadlineConfigGet]]), i(o(D, { style: { "margin-bottom": "20px" } }, null, 512), [[m, t(e).rawMaterialLossFormulaGet]])]), _: 1 }), o(r, { xs: 24, sm: 24, md: 12, lg: 8 }, { default: n(() => [i(o(t(C), { style: { "margin-bottom": "20px" } }, null, 512), [[m, t(e).drawingSNConfigGet]]), i(o(t($), { style: { "margin-bottom": "20px" } }, null, 512), [[m, t(e).appPrintConfigGet]]), t(s) & t(b).ENCLOSURE.V ? i((a(), _(t(w), { key: 0, style: { "margin-bottom": "20px" } }, null, 512)), [[m, t(e).foldingPriceMethodGet]]) : g("", true), i(o(S, { style: { "margin-bottom": "20px" } }, null, 512), [[m, t(e).appTaskReportGet]]), i(o(R, { style: { "margin-bottom": "20px" } }, null, 512), [[m, t(e).coatingCreateTypeConfigGet]]), i(o(t(B), { style: { "margin-bottom": "20px" } }, null, 512), [[m, t(e).deepPenConfigEdit]]), i(o(T, { style: { "margin-bottom": "20px" } }, null, 512), [[m, t(e).mesWarehouseManageGet]]), i(o(L, null, null, 512), [[m, t(e).mesNestTaskConfigGet]])]), _: 1 }), o(r, { xs: 24, sm: 24, md: 24, lg: 8 }, { default: n(() => [i(o(t(h), { style: { "margin-bottom": "20px" } }, null, 512), [[m, t(e).carModelConfigGet]]), i(o(v, { style: { "margin-bottom": "20px" } }, null, 512), [[m, t(e).machinePartSchedulingGet]]), i(o(t(P), { style: { "margin-bottom": "20px" } }, null, 512), [[m, t(e).contractPriceConfigGet]]), i(o(k, { style: { "margin-bottom": "20px" } }, null, 512), [[m, t(e).appShowWeightConfigGet]]), i(o(V, null, null, 512), [[m, t(e).labelPrintConfigGet]])]), _: 1 })]), _: 1 })]);
  };
} };
export {
  _t as default
};
