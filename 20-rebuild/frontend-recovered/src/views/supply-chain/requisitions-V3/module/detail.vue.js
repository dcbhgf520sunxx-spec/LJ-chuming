import { useStore as pe } from "vuex";
import { inject as me } from "vue";
import { ref as g } from "vue";
import { computed as X } from "vue";
import { resolveComponent as x } from "vue";
import { resolveDirective as de } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as v } from "vue";
import { createVNode as t } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as m } from "vue";
import { withDirectives as ce } from "vue";
import { unref as e } from "vue";
import { createTextVNode as c } from "vue";
import { toDisplayString as u } from "vue";
import { createBlock as y } from "vue";
import { createCommentVNode as N } from "vue";
import { withModifiers as K } from "vue";
import { Fragment as F } from "vue";
import { normalizeClass as ue } from "vue";
import { ElMessage as k } from "element-plus";
import { ElTag as fe } from "element-plus";
import { ElPopconfirm as we } from "element-plus";
import { ElTableColumn as he } from "element-plus";
import { ElInput as _e } from "element-plus";
import { _ as ge, jX as ve, gt as ye, o as be, j_ as Ee, cO as Te, am as Se, wc as A, jl as xe, c as C, wd as f, iX as V, jP as Ne, an as Ve, b as M, uP as H, vd as q, G as z, wg as D, ib as L, jG as Re, jH as Ie, i as ke, k5 as Ae, wb as Ce, T as De, R as Le, S as Ue, wh as Be, t0 as b, wi as je, ba as J, jN as Pe } from "../../../../shared/runtime.js";
import Oe from "./form.vue.js";
import "./application/steel/index.vue.js";
import "./application/components/common-wrapper.vue.js";
import "./application/components/common-footer.vue.js";
import "./application/components/confirm-dialog.vue.js";
import "./application/steel/module/steel-plate-table.vue.js";
import "./application/steel/module/section-steel-table.vue.js";
import "./application/steel/module/steel-coil-table.vue.js";
import "./application/steel/module/other-steel-materials-table.vue.js";
import "./application/components/inventory-drawer.vue.js";
import "./application/components/capsule-label/index.vue.js";
import "./application/auxiliary-material/index.vue.js";
import "../../../../modules/aux-material-a427f83d.js";
import "./application/auxiliary-material/module/aux-mat-table.vue.js";
import "./application/manufactured/index.vue.js";
import "./application/manufactured/module/enclosure-table.vue.js";
import "./application/manufactured/module/structure-table.vue.js";
import "./application/other/index.vue.js";
import "../../../../modules/other-e93f8d3e.js";
import "./application/gas/index.vue.js";
const Fe = { class: "print-wrap" }, Me = { style: { display: "flex", "justify-content": "space-between" } }, He = { class: "table-header" }, qe = { style: { display: "flex" } }, ze = { key: 0 }, We = { key: 1 }, $e = { class: "table-remark" }, Ge = { __name: "detail", props: { ApprovalFlag: { type: Boolean, default: false }, showButtom: { type: Boolean, default: false } }, setup(U) {
  const w = pe(), B = U, E = me("permission"), W = g([["arrivalTime", ["parse-time", "{y}-{m}-{d}"]]]), Z = g([...ve, ...W.value]), ee = g(), { CRUD: te, crud: d, detail: l } = ye(), { maxHeight: $ } = be({ mainBox: ".requisitions-application-record-detail", extraBox: [".el-drawer__header", ".table-header", ".table-remark"], wrapperBox: [".el-drawer__body"], clientHRepMainH: true, minHeight: 300, extraHeight: 10 }, () => X(() => !d.detailLoading)), R = X(() => !!(l.materialType & Ee.MANUFACTURED.V)), j = g(false), I = g({ dataId: void 0, opinion: void 0, decision: void 0 }), P = g(false);
  te.HOOK.beforeDetailLoaded = async (r, a) => {
    var h;
    I.value = { dataId: void 0, opinion: void 0, decision: void 0 }, P.value = false, R.value ? (a.detailList.forEach((n) => {
      n.totalLength = C(V(n.totalLength, f.LENGTH_DP), f.LENGTH, "m"), n.totalWeight = C(V(n.totalWeight, f.WEIGHT_DP), f.WEIGHT, "kg"), n.weight = C(V(n.weight, f.WEIGHT_DP), f.WEIGHT, "kg"), n.totalArea = C(V(n.totalArea, f.AREA_DP), f.AREA, "m²");
    }), a.projectNames = [], (h = a.projectInfos) == null || h.forEach((n) => {
      a.projectNames.push(n.serialNumber + " " + n.shortName);
    }), a.projectNames = a.projectNames.join(",")) : (await Te(a.detailList), a.detailList.forEach((n) => {
      n.basicClass === Se.STEEL_COIL.V && (n.measureUnit = "米", n.measurePrecision = 3), n.materialInventoryId ? n.requisitionMode = A.USE_INVENTORY.V : n.requisitionMode = A.PURCHASE.V;
    }), a.detailList = await xe(a.detailList));
  };
  async function G(r) {
    const a = { dataId: l.id, opinion: I.value.opinion, decision: r, approveRecordId: l.approveRecordIdNow };
    if (r === L.REFUSE.V && M(a.opinion)) {
      k.error("请输入审批意见"), P.value = true;
      return;
    }
    await Be(a).then(async (h) => {
      r === L.PASS.V ? k.success("审批通过") : (k.error("审批驳回"), await w.dispatch("approval_list/fetchRejNum", b.REQUISITIONS_V2.V)), await w.dispatch("approval_list/fetchApprovalNum", b.REQUISITIONS_V2.V), await w.dispatch("approval_list/fetchSubNum", b.REQUISITIONS_V2.V), await d.toQuery(), await d.cancelDetail();
    });
  }
  async function ae(r) {
    j.value = true;
    try {
      const a = { id: r.id, delButtonType: r.delButtonType };
      await je(a).then(async (h) => {
        h && (k.success(`${D.VL[r.delButtonType]}成功`), await w.dispatch("approval_list/fetchApprovalNum", b.REQUISITIONS_V2.V), await w.dispatch("approval_list/fetchApprovalNum"), await w.dispatch("approval_list/fetchSubNum", b.REQUISITIONS_V2.V), await w.dispatch("approval_list/fetchRejNum", b.REQUISITIONS_V2.V), await d.toQuery(), await d.cancelDetail());
      });
    } catch (a) {
      console.log(a);
    } finally {
      j.value = false;
    }
  }
  function oe(r) {
    return J(r, { props: [["quantity", 3], ["mete", Pe.weight.precision]] });
  }
  function ie(r) {
    return J(r, { props: [["quantity", 3], "totalWeight"] });
  }
  return (r, a) => {
    const h = x("print-table"), n = fe, T = x("common-button"), O = we, le = x("table-cell-tag"), i = he, Q = x("common-table"), ne = _e, se = x("common-drawer"), re = de("permission");
    return p(), v(F, null, [t(se, { ref_key: "drawerRef", ref: ee, "before-close": e(d).cancelDetail, "content-loading": e(d).detailLoading, "show-close": true, visible: e(d).detailVisible, "custom-class": "requisitions-application-record-detail", size: "80%", title: "申购详情" }, { titleRight: s(() => {
      var o, _, S;
      return [m("div", Fe, [ce(t(h, { "api-key": R.value ? "scmManufRequisitionsDetail" : "scmRequisitionsDetail", params: R.value ? { id: (o = e(l)) == null ? void 0 : o.id } : (_ = e(l)) == null ? void 0 : _.id, size: "default", type: "warning" }, null, 8, ["api-key", "params"]), [[re, (S = e(E)) == null ? void 0 : S.print]])])];
    }), content: s(() => [m("div", Me, [m("div", He, [t(n, { effect: "plain", size: "large" }, { default: s(() => {
      var o;
      return [c("申购编号：" + u((o = e(l)) == null ? void 0 : o.serialNumber), 1)];
    }), _: 1 }), t(n, { effect: "plain", size: "large", type: "success" }, { default: s(() => {
      var o;
      return [c("申购人：" + u((o = e(l)) == null ? void 0 : o.applicantName), 1)];
    }), _: 1 }), e(l).materialType & e(Ne).MANUFACTURED.V ? (p(), y(n, { key: 0, effect: "plain", size: "large", type: "danger" }, { default: s(() => {
      var o;
      return [c(" 项目：" + u((o = e(l)) == null ? void 0 : o.projectNames), 1)];
    }), _: 1 })) : N("", true)]), m("div", qe, [!U.ApprovalFlag && U.showButtom ? (p(), v("div", ze, [t(Ve, { data: { id: e(l).id }, permission: e(E), "show-del": false, "show-edit": e(M)(e(l).purchaseCreationState) && e(l).dataStatus === e(H).UNDER_APPROVAL.V || e(l).purchaseCreationState === e(q).NOT_STARTED.V && e(l).dataStatus === e(H).PASSED.V || e(l).purchaseCreationState === e(q).NOT_STARTED.V && e(l).dataStatus === e(H).UNDER_APPROVAL.V }, null, 8, ["data", "permission", "show-edit"]), e(z)(e(E).del) && e(l).delButtonType !== e(D).NO_DEL.V && (e(l).purchaseCreationState === e(q).NOT_STARTED.V || e(M)(e(l).purchaseCreationState)) ? (p(), y(O, { key: 0, title: `您确定要${e(D).VL[e(l).delButtonType]}该条数据吗?`, "cancel-button-text": "取消", "confirm-button-text": "确定", onConfirm: a[0] || (a[0] = (o) => ae(e(l))) }, { reference: s(() => [t(T, { loading: j.value, class: "filter-item", size: "default", type: "danger" }, { default: s(() => [c(u(e(D).VL[e(l).delButtonType] || "删除"), 1)]), _: 1 }, 8, ["loading"])]), _: 1 }, 8, ["title"])) : N("", true), t(T, { class: "filter-item", size: "default", onClick: K(e(d).cancelDetail, ["stop"]) }, { default: s(() => a[5] || (a[5] = [c(" 关 闭 ")])), _: 1, __: [5] }, 8, ["onClick"])])) : (p(), v("div", We, [B.ApprovalFlag && e(z)(e(E).approvalCfg) ? (p(), y(O, { key: 0, title: "确认通过", onConfirm: a[1] || (a[1] = (o) => G(e(L).PASS.V)) }, { reference: s(() => [t(T, { class: "filter-item", size: "default", type: "success" }, { default: s(() => a[6] || (a[6] = [c("通过")])), _: 1, __: [6] })]), _: 1 })) : N("", true), B.ApprovalFlag && e(z)(e(E).approvalCfg) ? (p(), y(O, { key: 1, title: "确认驳回", onConfirm: a[2] || (a[2] = (o) => G(e(L).REFUSE.V)) }, { reference: s(() => [t(T, { class: "filter-item", size: "default", type: "danger" }, { default: s(() => a[7] || (a[7] = [c(" 驳回 ")])), _: 1, __: [7] })]), _: 1 })) : N("", true), t(T, { class: "filter-item", size: "default", onClick: K(e(d).cancelDetail, ["stop"]) }, { default: s(() => a[8] || (a[8] = [c(" 关 闭 ")])), _: 1, __: [8] }, 8, ["onClick"])]))])]), R.value ? (p(), y(Q, { key: 1, data: e(l).detailList, "data-format": W.value, "max-height": e($), "summary-method": ie, "show-summary": "" }, { default: s(() => [t(i, { align: "center", fixed: "left", label: "序号", type: "index", width: "55" }), e(l).finishedProductType === e(Ce).STRUC_MANUFACTURED.V ? (p(), v(F, { key: 0 }, [t(i, { align: "center", label: "单体", "min-width": "120px", prop: "monomer.name", "show-overflow-tooltip": "" }), t(i, { align: "center", label: "区域", "min-width": "120px", prop: "area.name", "show-overflow-tooltip": "" }), t(i, { align: "center", label: "名称", "min-width": "100px", prop: "manufacturedName", "show-overflow-tooltip": "" }), t(i, { align: "center", label: "编号", "min-width": "100px", prop: "manufacturedSn", "show-overflow-tooltip": "" }), t(i, { align: "center", label: "规格", "min-width": "140px", prop: "specification", "show-overflow-tooltip": "" }), t(i, { align: "center", label: "长度（mm）", "min-width": "120px", prop: "length", "show-overflow-tooltip": "" }), t(i, { align: "center", label: "材质", prop: "material", "show-overflow-tooltip": "" }), t(i, { align: "center", label: "数量", "min-width": "100px", "show-overflow-tooltip": "" }, { default: s(({ row: { sourceRow: o } }) => [c(u(o.quantity), 1)]), _: 1 }), t(i, { align: "center", label: "单重（kg）", "min-width": "120px", "show-overflow-tooltip": "" }, { default: s(({ row: { sourceRow: o } }) => [m("span", null, u(e(V)(o.weight, 2)), 1)]), _: 1 }), t(i, { align: "center", label: "总重（kg）", "min-width": "120px", prop: "totalWeight", "show-overflow-tooltip": "" }, { default: s(({ row: { sourceRow: o } }) => [m("span", null, u(o.totalWeight), 1)]), _: 1 })], 64)) : (p(), v(F, { key: 1 }, [t(i, { align: "center", label: "类型", "min-width": "120px", prop: "category", "show-overflow-tooltip": "" }, { default: s(({ row: { sourceRow: o } }) => [c(u(e(De).VL[o.manufacturedType]), 1)]), _: 1 }), t(i, { align: "center", label: "编号", "min-width": "120px", prop: "manufacturedSn", "show-overflow-tooltip": "" }), t(i, { align: "center", label: "名称", "min-width": "100px", prop: "manufacturedName", "show-overflow-tooltip": "" }), t(i, { align: "center", label: "规格", "min-width": "140px", prop: "specification", "show-overflow-tooltip": "" }), t(i, { align: "center", label: "有效宽度", "min-width": "100px", prop: "width", "show-overflow-tooltip": "" }), t(i, { align: "center", label: "厚度（mm）", "min-width": "120px", prop: "thickness", "show-overflow-tooltip": "" }), t(i, { align: "center", label: "品牌", prop: "brand", "show-overflow-tooltip": "" }), t(i, { align: "center", label: "颜色", prop: "color", "show-overflow-tooltip": "" }), t(i, { align: "center", label: "材质", prop: "material", "show-overflow-tooltip": "" }), t(i, { align: "center", label: "单长（mm）", "min-width": "120px", prop: "length", "show-overflow-tooltip": "" }), t(i, { align: "center", label: "数量（张）", "min-width": "100px", prop: "quantity", "show-overflow-tooltip": "" }), t(i, { align: "center", label: "总长（m）", "min-width": "120px", prop: "totalLength", "show-overflow-tooltip": "" }), t(i, { align: "center", label: "总面积（m²）", "min-width": "120px", prop: "totalArea", "show-overflow-tooltip": "" }), t(i, { align: "center", label: "总重（kg）", "min-width": "150px", prop: "totalWeight", "show-overflow-tooltip": "" })], 64)), t(i, { align: "center", label: "到厂日期", "min-width": "120px", prop: "arrivalTime", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "data-format", "max-height"])) : (p(), y(Q, { key: 0, data: e(l).detailList, "data-format": Z.value, "max-height": e($), "summary-method": oe, "show-summary": "" }, { default: s(() => [t(i, { align: "center", fixed: "left", label: "序号", type: "index", width: "55" }, { default: s(({ row: o, $index: _ }) => [t(le, { name: e(A).USE_INVENTORY.L, show: o.requisitionMode === e(A).USE_INVENTORY.V, color: "#e6a23c" }, null, 8, ["name", "show"]), m("span", null, u(_ + 1), 1)]), _: 1 }), t(Re, { showIndex: false, fixed: "left" }), t(Ie), t(i, { align: "left", label: "项目", "min-width": "200px", prop: "project" }, { default: s(({ row: { sourceRow: o } }) => {
      var _, S, Y;
      return [c(u(e(ke)((_ = o.project) == null ? void 0 : _.shortName) ? `${(S = o.project) == null ? void 0 : S.serialNumber} ${(Y = o.project) == null ? void 0 : Y.shortName}` : "-"), 1)];
    }), _: 1 }), t(Ae), t(i, { align: "center", label: "到厂日期", prop: "arrivalTime", "show-overflow-tooltip": "", width: "120px" })]), _: 1 }, 8, ["data", "data-format", "max-height"])), m("div", $e, [a[9] || (a[9] = m("span", null, "备注", -1)), m("span", null, [m("span", null, u(e(l).remark), 1)])]), t(Le, { files: e(l).attachments, "onUpdate:files": a[3] || (a[3] = (o) => e(l).attachments = o), "file-classify": e(Ue).PURCHASE_ORDER_ATT.V, showView: true, uploadable: false, "empty-text": "暂未上传附件", "show-download": "", style: { "margin-top": "10px" } }, null, 8, ["files", "file-classify"]), B.ApprovalFlag ? (p(), v("div", { key: 2, class: ue(P.value ? "table-remark isApproval-not" : "table-remark") }, [a[10] || (a[10] = m("span", { style: { padding: "0 4px", display: "block", width: "63px" } }, "审批意见", -1)), t(ne, { modelValue: I.value.opinion, "onUpdate:modelValue": a[4] || (a[4] = (o) => I.value.opinion = o), rows: 2, class: "remark input-border-none", maxlength: "200", placeholder: "请填写审批意见", "show-word-limit": "", type: "textarea" }, null, 8, ["modelValue"])], 2)) : N("", true)]), _: 1 }, 8, ["before-close", "content-loading", "visible"]), t(e(Oe), { "show-ts-buttom": false, onDetailSuccess: e(d).cancelDetail }, null, 8, ["onDetailSuccess"])], 64);
  };
} }, ht = ge(Ge, [["__scopeId", "data-v-07bf8dc6"]]);
export {
  ht as default
};
