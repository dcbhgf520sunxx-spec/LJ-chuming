import { useStore as B } from "vuex";
import { ref as c } from "vue";
import { watch as M } from "vue";
import { onMounted as $ } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as x } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { withDirectives as F } from "vue";
import { createBlock as s } from "vue";
import { withCtx as p } from "vue";
import { createElementVNode as f } from "vue";
import { createTextVNode as _ } from "vue";
import { toDisplayString as b } from "vue";
import { createCommentVNode as n } from "vue";
import { ElTableColumn as H } from "element-plus";
import { ElTag as I } from "element-plus";
import { vLoading as K } from "element-plus";
import { _ as L, uv as W, x as q, xj as w, xk as G, o as Q, aR as z, j$ as N, G as S, an as J, P as X } from "../../../../shared/runtime.js";
import Y from "./module/header.vue.js";
import Z from "./module/detail.vue.js";
import ee from "./module/adjust-form.vue.js";
import "../../../../modules/warehouse-project-cascader-17e2b952.js";
const te = { class: "app-container" }, ae = { key: 0 }, oe = { key: 2 }, le = { __name: "index", setup(se) {
  const C = B(), j = { add: false, edit: false, del: false, download: false }, h = c([]), R = c(), y = c(false), P = c({}), V = c([...W, ["qualityTestingTime", "parse-time"], ["approvalComments", "empty-text"]]), { crud: u, columns: i, CRUD: A } = q({ title: "价格调整", sort: ["id.desc"], permission: { ...w }, invisibleColumns: ["licensePlate", "shipmentNumber"], optShow: { ...j }, crudApi: { ...G } }, R), { maxHeight: D } = Q({ paginate: true });
  function E(d) {
    P.value = d, y.value = true;
  }
  return A.HOOK.handleRefresh = async (d, { data: o }) => {
    o.content = o.content.map((l) => {
      var m;
      return l.imgUrls = ((m = l.attachments) == null ? void 0 : m.map((v) => v.imageUrl)) || [], l;
    });
  }, M(() => C.state.approval_list.isRefresh, (d) => {
    d && u.toQuery();
  }, { deep: true }), $(async () => {
    await C.dispatch("wms/fetchSteelDensityCfg");
  }), (d, o) => {
    const l = H, m = k("table-cell-tag"), v = I, O = k("common-button"), T = k("common-table"), U = K;
    return a(), x("div", te, [r(e(Y)), F((a(), s(T, { ref_key: "tableRef", ref: R, data: e(u).data, "data-format": V.value, "default-expand-all": false, "expand-row-keys": h.value, "max-height": e(D), "row-key": "id" }, { default: p(() => [r(z, { "expand-row-keys": h.value, "onUpdate:expandRowKeys": o[0] || (o[0] = (t) => h.value = t), data: e(u).data, "row-key": "id" }, { default: p(({ row: t }) => [f("p", null, [o[2] || (o[2] = _(" 关联项目：")), f("span", null, b(t.projectsFullName), 1)]), f("p", null, [o[3] || (o[3] = _(" 审批意见：")), f("span", null, b(t.approvalComments), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), r(l, { align: "center", label: "序号", type: "index", width: "60" }), e(i).visible("purchaseSN") ? (a(), s(l, { key: "purchaseSN", "show-overflow-tooltip": true, label: "采购合同编号", "min-width": "155", prop: "purchaseSN" }, { default: p(({ row: { sourceRow: t } }) => [r(m, { offset: 10, show: !!t.boolPartyA && !!t.purchaseSN, name: "甲供", type: "partyA" }, null, 8, ["show"]), t.purchaseSN ? (a(), x("span", ae, b(t.purchaseSN), 1)) : n("", true), t.boolPartyA ? (a(), s(v, { key: 1, effect: "dark", size: "default", type: "danger" }, { default: p(() => o[4] || (o[4] = [_("甲供")])), _: 1, __: [4] })) : (a(), x("span", oe, "-"))]), _: 1 })) : n("", true), e(i).visible("serialNumber") ? (a(), s(l, { key: "serialNumber", "show-overflow-tooltip": true, align: "left", label: "入库单号", "min-width": "160", prop: "serialNumber" }, { default: p(({ row: { sourceRow: t } }) => {
      var g;
      return [t.inboundWay === e(N).OPENING_RECEIPT.V ? (a(), s(m, { key: 0, name: e(N).VL[t.inboundWay], color: (g = e(N).V[t.inboundWay]) == null ? void 0 : g.COLOR }, null, 8, ["name", "color"])) : n("", true), f("span", null, b(t.serialNumber), 1)];
    }), _: 1 })) : n("", true), e(i).visible("licensePlate") ? (a(), s(l, { key: "licensePlate", "show-overflow-tooltip": true, align: "left", label: "车牌/船牌号", prop: "licensePlate", width: "100" })) : n("", true), e(i).visible("shipmentNumber") ? (a(), s(l, { key: "shipmentNumber", align: "left", label: "物流单号", "min-width": "150", prop: "shipmentNumber", "show-overflow-tooltip": "" })) : n("", true), e(i).visible("basicClass") ? (a(), s(l, { key: "basicClass", "show-overflow-tooltip": true, label: "物料种类", prop: "basicClass", width: "120" })) : n("", true), e(i).visible("projects") ? (a(), s(l, { key: "projects", label: "关联项目", "min-width": "170", prop: "projects", "show-overflow-tooltip": "" })) : n("", true), e(i).visible("supplier.name") ? (a(), s(l, { key: "supplier.name", "show-overflow-tooltip": true, label: "供应商", "min-width": "200", prop: "supplier.name" })) : n("", true), e(i).visible("applicantName") ? (a(), s(l, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "申请人", "min-width": "100", prop: "applicantName" })) : n("", true), e(i).visible("editorName") ? (a(), s(l, { key: "editorName", "show-overflow-tooltip": true, align: "center", label: "编辑人", "min-width": "100", prop: "editorName" })) : n("", true), e(S)([...e(w).detail, ...e(w).add]) ? (a(), s(l, { key: 9, align: "center", fixed: "right", label: "操作", width: "170px" }, { default: p(({ row: { sourceRow: t } }) => [r(J, { data: t, "show-del": false, "show-edit": false, "show-detail": "" }, null, 8, ["data"]), e(S)(e(w).add) ? (a(), s(O, { key: 0, type: "warning", onClick: (g) => E(t) }, { default: p(() => o[5] || (o[5] = [_(" 价格调整 ")])), _: 2, __: [5] }, 1032, ["onClick"])) : n("", true)]), _: 1 })) : n("", true)]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])), [[U, e(u).loading]]), r(e(X)), r(Z), r(ee, { modelValue: y.value, "onUpdate:modelValue": o[1] || (o[1] = (t) => y.value = t), data: P.value, onSuccess: e(u).toQuery }, null, 8, ["modelValue", "data", "onSuccess"])]);
  };
} }, me = L(le, [["__scopeId", "data-v-d635b079"]]);
export {
  me as default
};
