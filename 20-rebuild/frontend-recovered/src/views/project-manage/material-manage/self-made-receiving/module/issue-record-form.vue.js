import { ref as g } from "vue";
import { watch as K } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as y } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as l } from "vue";
import { unref as s } from "vue";
import { createTextVNode as v } from "vue";
import { createCommentVNode as z } from "vue";
import { createElementVNode as E } from "vue";
import { withDirectives as A } from "vue";
import { createVNode as e } from "vue";
import { toDisplayString as d } from "vue";
import { withModifiers as W } from "vue";
import { isRef as X } from "vue";
import { ElNotification as Y } from "element-plus";
import { ElDescriptionsItem as Z } from "element-plus";
import { ElDescriptions as ee } from "element-plus";
import { ElTableColumn as te } from "element-plus";
import { ElInput as ae } from "element-plus";
import { ElFormItem as le } from "element-plus";
import { ElForm as ne } from "element-plus";
import { vLoading as oe } from "element-plus";
import { l as C, u as ie, o as re, G as Q, z as se, p as q, S as ce, aw as me } from "../../../../../shared/runtime.js";
import { _ as ue } from "../../../../../modules/PicUpload-8580ccfc.js";
function de(n) {
  return C({ module: "project", url: "receiving/listReceiving", method: "get", params: n });
}
function pe(n) {
  return C({ module: "project", url: "receiving/confirmReceivingV2", method: "post", data: n });
}
function ke(n, p) {
  return C({ module: "project", url: `receiving/listProductUp/${n}`, method: "get", params: p });
}
function Re(n, p) {
  return C({ module: "project", url: `receiving/listCanReceiveProduct/${n}`, method: "get", params: p });
}
const fe = { edit: pe, get: de }, be = { class: "head-container" }, ge = { __name: "issue-record-form", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, globalProject: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, selections: { type: Array, default: () => [] } }, emits: ["update:modelValue", "success", "del-change"], setup(n, { emit: p }) {
  const I = p, h = n, L = g(), k = g({}), B = { picAttament: [{ required: true, validator: (i, t, m) => {
    !t || !(t != null && t.length) ? m(new Error("请上传图片")) : m();
  }, message: "请上传图片", trigger: ["change", "blur"] }] }, { visible: R, handleClose: M } = ie({ emit: I, props: h }), D = { selectQuantity: [{ required: true, message: "请填写数量", trigger: "blur" }], problemRemark: [{ required: true, message: "请填写问题描述", trigger: "blur" }] }, { tableValidate: O, wrongCellMask: F } = me({ rules: D });
  K(R, (i) => {
    i && (f.value = h.selections);
  });
  const f = g([]), N = g(), P = g(false), { maxHeight: H } = re({ mainBox: ".delivery-detail", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, N);
  function $(i, t) {
    f.value.splice(t, 1), I("del-change", i);
  }
  function S(i, t) {
    i.selectQuantity = t, i.actualMete = (i.selectQuantity * (i.accountingMete / i.quantity)).toFixed(3);
  }
  async function G(i) {
    var u, V, o, w;
    const { validResult: t } = O(f.value), m = await L.value.validate();
    if (!(!t || !m)) try {
      const b = (u = k.value.picAttament) == null ? void 0 : u.map((c) => c.id), j = (V = f.value) == null ? void 0 : V.map((c) => ({ problemDesc: c.problemRemark, linkId: c.linkId, productType: c.productType, quantity: c.selectQuantity })), U = { boolProblemReceiving: i, cargoListId: (o = h.detailInfo) == null ? void 0 : o.id, projectId: (w = h.globalProject) == null ? void 0 : w.id, problemAttachmentIds: b, receiveProductDTOParam: j };
      await fe.edit(U), Y({ title: "提交成功", type: "success" }), I("success"), M();
    } catch (b) {
      console.log("审核", b);
    }
  }
  return (i, t) => {
    const m = x("common-button"), u = Z, V = ee, o = te, w = x("common-input-number"), b = ae, j = x("common-table"), U = le, c = ne, J = x("common-drawer"), T = oe;
    return y(), _(J, { ref_key: "drawerRef", ref: N, title: "问题记录", "close-on-click-modal": false, modelValue: s(R), "onUpdate:modelValue": t[2] || (t[2] = (a) => X(R) ? R.value = a : null), direction: "rtl", "before-close": s(M), "custom-class": "delivery-detail", size: "70%" }, { titleRight: l(() => [s(Q)(n.permission.save) ? (y(), _(m, { key: 0, type: "success", size: "default", onClick: t[0] || (t[0] = (a) => G(1)) }, { default: l(() => t[3] || (t[3] = [v("保存")])), _: 1, __: [3] })) : z("", true)]), content: l(() => [E("div", be, [A((y(), _(V, { column: 2, border: "" }, { default: l(() => [e(u, { align: "center", "label-class-name": "contractLabel", label: "项目" }, { default: l(() => [v(d(s(se)(n.detailInfo.project)), 1)]), _: 1 }), e(u, { align: "center", "label-class-name": "contractLabel", label: "发运日期" }, { default: l(() => [v(d(s(q)(n.detailInfo.auditTime, "{y}-{m}-{d}")), 1)]), _: 1 }), e(u, { align: "center", "label-class-name": "contractLabel", label: "收货人" }, { default: l(() => [v(d(n.detailInfo.auditReceiptName), 1)]), _: 1 }), e(u, { align: "center", "label-class-name": "contractLabel", label: "收货日期" }, { default: l(() => [v(d(s(q)(n.detailInfo.auditReceiptTime, "{y}-{m}-{d}")), 1)]), _: 1 })]), _: 1 })), [[T, P.value]])]), A((y(), _(j, { data: f.value, "max-height": s(H), "cell-class-name": s(F), "return-source-data": "" }, { default: l(() => [e(o, { label: "序号", type: "index", align: "center", width: "60" }), e(o, { key: "monomer.name", prop: "monomer.name", label: "单体", align: "center" }, { default: l(({ row: a }) => {
      var r;
      return [E("span", null, d(((r = a.monomer) == null ? void 0 : r.name) || "-"), 1)];
    }), _: 1 }), e(o, { key: "area.name", prop: "area.name", label: "区域", align: "center" }, { default: l(({ row: a }) => {
      var r;
      return [E("span", null, d(((r = a.area) == null ? void 0 : r.name) || "-"), 1)];
    }), _: 1 }), e(o, { key: "name", prop: "name", label: "名称", align: "center" }), e(o, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center" }), e(o, { key: "specification", prop: "specification", label: "规格", align: "center" }), e(o, { key: "measureUnit", prop: "measureUnit", label: "计量单位", align: "center" }), e(o, { key: "selectQuantity", prop: "selectQuantity", label: "数量", align: "center" }, { default: l(({ row: a }) => [e(w, { modelValue: a.selectQuantity, "onUpdate:modelValue": (r) => a.selectQuantity = r, controls: false, min: 0, max: a.quantity, precision: 0, size: "default", clearable: "", placeholder: "数量", style: { width: "100%" }, onChange: (r) => S(a, r) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "onChange"])]), _: 1 }), e(o, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center" }), e(o, { key: "actualMete", prop: "actualMete", label: "核算量", align: "center" }), e(o, { key: "problemRemark", prop: "problemRemark", label: "问题描述", align: "center", "min-width": "130" }, { default: l(({ row: a }) => [e(b, { modelValue: a.problemRemark, "onUpdate:modelValue": (r) => a.problemRemark = r, type: "textarea", autosize: { minRows: 2, maxRows: 5 }, placeholder: "请填写备注", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), s(Q)(n.permission.del) ? (y(), _(o, { key: 0, label: "操作", width: "80", align: "center" }, { default: l(({ row: { sourceRow: a }, $index: r }) => [e(m, { size: "default", icon: "el-icon-delete", type: "danger", onClick: W((ye) => $(a, r), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })) : z("", true)]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])), [[T, P.value]]), e(c, { ref_key: "formRef", ref: L, model: k.value, rules: B, size: "default", "label-position": "top", "label-width": "100px" }, { default: l(() => [e(U, { label: "添加佐证", prop: "picAttament" }, { default: l(() => [e(s(ue), { files: k.value.picAttament, "onUpdate:files": t[1] || (t[1] = (a) => k.value.picAttament = a), "file-classify": s(ce).NORMAL.V, style: { width: "100%" } }, null, 8, ["files", "file-classify"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ve = Object.freeze(Object.defineProperty({ __proto__: null, default: ge }, Symbol.toStringTag, { value: "Module" }));
export {
  ge as _,
  Re as a,
  fe as c,
  ke as d,
  Ve as i
};
