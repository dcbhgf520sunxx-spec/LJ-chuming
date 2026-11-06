import { ref as f } from "vue";
import { resolveComponent as R } from "vue";
import { resolveDirective as y } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as v } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { createBlock as a } from "vue";
import { withCtx as s } from "vue";
import { createTextVNode as b } from "vue";
import { Fragment as B } from "vue";
import { withDirectives as x } from "vue";
import { createCommentVNode as i } from "vue";
import { toDisplayString as g } from "vue";
import { nextTick as O } from "vue";
import { ElTag as H } from "element-plus";
import { ElTableColumn as M } from "element-plus";
import { vLoading as V } from "element-plus";
import { c as A } from "../../../../modules/scheduling-work-order-cf0c3c01.js";
import { g as _ } from "../../../../modules/enclosure-365a2177.js";
import { _ as I, D as Q, kA as U, x as $, o as z, br as F, G as k, an as G, P as K } from "../../../../shared/runtime.js";
import W from "./project-list/index.vue.js";
import J from "./module/header.vue.js";
import X from "./module/detail.vue.js";
import "./project-list/module/header.vue.js";
const Y = { class: "wrap" }, Z = { class: "wrap-left" }, ee = { class: "wrap-right" }, te = { class: "app-container" }, oe = { __name: "index", setup(ae) {
  const N = { add: false, edit: false, del: true, download: false }, w = f(), u = f({}), C = f([["totalLength", ["to-fixed", Q.MES_ENCLOSURE_L__M]], ["createTime", ["parse-time", "{y}-{m}-{d}"]], ["category", ["parse-enum", U]]]), { CRUD: L, crud: c, columns: n } = $({ title: "排产工单", sort: [], permission: { ..._ }, optShow: { ...N }, crudApi: { ...A }, requiredQuery: ["projectId"], invisibleColumns: [], queryOnPresenterCreated: false }, w), { maxHeight: T } = z({ extraBox: ".scheduling-head-container", paginate: true });
  function j(d = {}) {
    u.value = d, O(() => {
      c.query.projectId = d.id, c.toQuery();
    });
  }
  function E(d) {
    return !d.booleanProduce;
  }
  return L.HOOK.handleRefresh = async (d, { data: h }) => {
    h.content.forEach((p) => {
      p.totalLength = (p.totalLength || 0) / 1e3;
    });
  }, (d, h) => {
    const p = H, o = M, P = R("common-table"), S = y("empty-text"), D = y("parse-project"), q = V;
    return t(), v("div", Y, [m("div", Z, [r(e(W), { onProjectChange: j })]), m("div", ee, [m("div", te, [u.value.id ? (t(), v(B, { key: 1 }, [r(e(J), { class: "head-container scheduling-head-container" }, { viewLeft: s(() => [r(p, { effect: "plain", size: "large" }, { default: s(() => [x(m("span", null, null, 512), [[S], [D, { project: u.value }]])]), _: 1 })]), _: 1 }), x((t(), a(P, { ref_key: "tableRef", ref: w, data: e(c).data, "data-format": C.value, "empty-text": e(c).emptyText, "max-height": e(T), "row-key": "id", onSelectionChange: e(c).selectionChangeHandler }, { default: s(() => [r(o, { selectable: E, align: "center", type: "selection", width: "55" }), r(o, { align: "center", label: "序号", type: "index", width: "60" }), e(n).visible("createTime") ? (t(), a(o, { key: "createTime", align: "center", label: "排产日期", prop: "createTime", "show-overflow-tooltip": "", width: "100" })) : i("", true), e(n).visible("orderNumber") ? (t(), a(o, { key: "orderNumber", align: "center", label: "任务工单", "min-width": "140", prop: "orderNumber", "show-overflow-tooltip": "" }, { default: s(({ row: l }) => [r(e(F), { offset: 15, show: !!l.printQuantity, color: "#e64242", name: "已打印" }, null, 8, ["show"]), m("span", null, g(l.orderNumber), 1)]), _: 1 })) : i("", true), e(n).visible("userName") ? (t(), a(o, { key: "userName", align: "center", label: "排产人", prop: "userName", "show-overflow-tooltip": "", width: "90" })) : i("", true), e(n).visible("factoryName") ? (t(), a(o, { key: "factoryName", align: "center", label: "工厂", "min-width": "100", prop: "factoryName", "show-overflow-tooltip": "" })) : i("", true), e(n).visible("workshopName") ? (t(), a(o, { key: "workshopName", align: "center", label: "车间", "min-width": "100", prop: "workshopName", "show-overflow-tooltip": "" })) : i("", true), e(n).visible("productionLineName") ? (t(), a(o, { key: "productionLineName", align: "center", label: "生产线", "min-width": "130", prop: "productionLineName", "show-overflow-tooltip": "" }, { default: s(({ row: l }) => [b(g(l.productionLineName) + " / " + g(l.leaderName), 1)]), _: 1 })) : i("", true), e(n).visible("quantity") ? (t(), a(o, { key: "quantity", align: "center", label: "任务数(件)", prop: "quantity", "show-overflow-tooltip": "", width: "80" })) : i("", true), e(n).visible("totalLength") ? (t(), a(o, { key: "totalLength", align: "right", label: "任务量(m)", prop: "totalLength", "show-overflow-tooltip": "", width: "80" })) : i("", true), e(k)([...e(_).detail, ...e(_).del]) ? (t(), a(o, { key: 8, align: "center", fixed: "right", label: "操作", width: "120px" }, { default: s(({ row: l }) => [r(e(G), { data: l, "show-del": !l.booleanProduce, "show-detail": e(k)(e(_).detail), "show-edit": false }, null, 8, ["data", "show-del", "show-detail"])]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height", "onSelectionChange"])), [[q, e(c).loading]]), r(e(K)), r(e(X), { project: u.value }, null, 8, ["project"])], 64)) : (t(), a(p, { key: 0, effect: "plain", size: "large", type: "info" }, { default: s(() => h[0] || (h[0] = [b(" * 请点击左侧项目列表查看详情")])), _: 1, __: [0] }))])])]);
  };
} }, me = I(oe, [["__scopeId", "data-v-d304c400"]]);
export {
  me as default
};
