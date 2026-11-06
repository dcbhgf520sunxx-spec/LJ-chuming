import { ref as v } from "vue";
import { inject as qe } from "vue";
import { reactive as je } from "vue";
import { watch as De } from "vue";
import { watchEffect as Oe } from "vue";
import { computed as A } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as n } from "vue";
import { createBlock as s } from "vue";
import { withCtx as i } from "vue";
import { createVNode as o } from "vue";
import { createTextVNode as Y } from "vue";
import { createElementVNode as m } from "vue";
import { toDisplayString as w } from "vue";
import { unref as c } from "vue";
import { createCommentVNode as u } from "vue";
import { createElementBlock as X } from "vue";
import { withDirectives as He } from "vue";
import { isRef as $e } from "vue";
import { ElMessage as M } from "element-plus";
import { nextTick as Fe } from "vue";
import { ElFormItem as Ge } from "element-plus";
import { ElInput as We } from "element-plus";
import { ElTableColumn as ze } from "element-plus";
import { ElInputNumber as Be } from "element-plus";
import { Plus as Ye } from "@element-plus/icons-vue";
import { ElIcon as Xe } from "element-plus";
import { ElImage as Je } from "element-plus";
import { ZoomIn as Qe } from "@element-plus/icons-vue";
import { Delete as Ke } from "@element-plus/icons-vue";
import { ElUpload as Ze } from "element-plus";
import { ElForm as et } from "element-plus";
import { ElDialog as tt } from "element-plus";
import { vLoading as at } from "element-plus";
import { l as K, _ as lt, m as ot, X as nt, S as it, o as rt, kH as x, kI as U, kG as f, kC as J, u as st, mx as ut, ku as dt, kL as g, uf as ct, ug as Q, fD as pt, bV as k, aw as mt, ba as ft } from "../../../../../../shared/runtime.js";
import { m as ht } from "../../../../../../modules/manuf-warehouse-select-bae65ecc.js";
function gt(I) {
  return K({ url: "/api/project/returnProductChild/projectReturnChildsByType", method: "get", params: I });
}
function _t(I) {
  return K({ url: "/api/project/returnProductMain/save", method: "post", data: I });
}
const jt = { get: gt };
const vt = { class: "form-row" }, yt = { class: "form-row" }, bt = { key: 0, class: "form-row" }, Vt = { style: { height: "100%", display: "flex", "align-items": "center" } }, wt = { key: 1 }, Et = { class: "form-row" }, At = { style: { padding: "10px", width: "100%" }, class: "flex-rsc" }, Rt = { class: "el-upload-list__item-actions" }, Mt = ["onClick"], kt = ["onClick"], It = ["src"], xt = { __name: "summary-list", props: { visible: { type: Boolean, default: false }, auditDataList: { type: Array, default: () => [] } }, emits: ["update:visible", "delete", "success"], setup(I, { expose: Z, emit: ee }) {
  const { fileUploadApi: te } = ot("fileUploadApi"), ae = v({ Authorization: nt() }), le = v({ fileType: it.NORMAL.V }), P = ee, C = I, d = qe("query"), oe = v(false), N = v(false), R = v(), l = je({ handleMethod: void 0, warehouseId: void 0, freight: void 0, fileList: [], attachmentIds: [] }), S = v(false), O = v(), L = v(), y = v(), { maxHeight: ne } = rt({ paginate: false, extraHeight: 80 });
  De(() => C.auditDataList, (e) => {
    y.value = C.auditDataList.map((a) => (a.originQuantity = a.quantity, a.originUnitPrice = a.unitPrice, b.value && (a.pricingManner = x.WEIGHT.V), _.value && (a.pricingManner = U.LENGTH.V), a));
  }, { immediate: true, deep: true }), Oe(() => {
    l.attachmentIds = l.fileList.map((e) => e.id);
  });
  const b = A(() => d.type === f.AUXILIARY_MATERIAL.V), _ = A(() => d.type === f.ENCLOSURE.V), V = A(() => d.type === f.STRUCTURE.V), H = A(() => d.type === f.AUXILIARY_MATERIAL.V && d.relationType === J.STRUCTURE.V), ie = A(() => d.type === f.AUXILIARY_MATERIAL.V && d.relationType === J.ENCLOSURE.V), { visible: q, handleClose: $ } = st({ emit: P, props: C, field: "visible", showHook: ve, closeHook: ye }), re = { pricingManner: [{ validator: (e, a) => !((d.type === f.ENCLOSURE.V || d.type === f.STRUCTURE.V) && !e && e !== 0), message: "请选择计价方式", trigger: "change" }], quantity: [{ required: true, message: "请选择输入数量", trigger: "blur" }], unitPrice: [{ validator: (e, a) => !(l.handleMethod !== g.REPAIR.V && !e), message: "请选择输入单价", trigger: "blur" }] }, { tableValidate: se, cleanUpData: ue, wrongCellMask: de } = mt({ rules: re, errorMsg: "请修正表格中标红的信息" }), ce = { handleMethod: [{ required: true, message: "请选择处理方式", trigger: "change" }], freight: [{ required: true, message: "请选择输入费用", trigger: "blur" }], warehouseId: [{ required: true, message: "请选择存放位置", trigger: "change" }], attachmentIds: [{ required: true, message: "请选择上传文件", trigger: "change" }] }, pe = A(() => d.type === f.STRUCTURE.V ? x : d.type === f.ENCLOSURE.V ? U : {});
  function F(e, a) {
    d.type === f.STRUCTURE.V && (e.pricingManner === x.WEIGHT.V && (e.totalAmount = e.unitPrice * e.quantity * e.netWeight, e.totalNetWeight = (e.quantity * e.netWeight).toFixed(5) ?? "-", k(e.totalAmount, 3), console.log("结构-重量", e.totalAmount)), e.pricingManner === x.LENGTH.V && (e.totalAmount = e.unitPrice * e.quantity * e.length, e.totalLength = (e.quantity * e.length).toFixed(2) ?? "-", k(e.totalAmount, 3), console.log("结构-长度", e.totalAmount))), d.type === f.ENCLOSURE.V && (e.pricingManner === U.AREA.V && (e.totalAmount = e.unitPrice * e.quantity * e.surfaceArea, e.totalArea = (e.quantity * e.surfaceArea).toFixed(2) ?? "-", k(e.totalAmount, 3), console.log("围护-面积", e.totalAmount)), e.pricingManner === U.LENGTH.V && (e.totalAmount = e.unitPrice * e.quantity * e.length, e.totalLength = (e.quantity * e.length).toFixed(2) ?? "-", k(e.totalAmount, 3), console.log("围护-长度", e.totalAmount))), d.type === f.AUXILIARY_MATERIAL.V && (e.mete = (e.singleMete * e.quantity).toFixed(2) ?? "-", e.totalAmount = e.unitPrice * e.quantity * e.singleMete, k(e.totalAmount, 3), console.log("配套件制品", e.totalAmount));
  }
  function me(e) {
    return ft(e, { props: ["quantity", ["totalAmount", 3]], toThousandFields: ["totalAmount"] });
  }
  function fe(e) {
    P("delete", e);
  }
  async function he() {
    if (!await R.value.validate()) return false;
    const { validResult: a } = se(y.value);
    if (a && ue(y.value), !a) return false;
    N.value = true;
    try {
      const p = { ...l, projectReturnProductChildDTOParamList: y.value, remark: L.value, projectId: d.projectId, productType: d.type, status: d.status, relationType: d.relationType };
      await _t(p), M.success("提交成功"), G(), P("success"), $();
    } catch (p) {
      console.log(p);
    } finally {
      N.value = false;
    }
  }
  const { userProjectsMap: ge } = ut();
  function _e(e) {
    y.value = JSON.parse(JSON.stringify(C.auditDataList)), e === g.REPAIR.V && (l.warehouseId = void 0), (b.value || _.value) && y.value.forEach((a) => {
      b.value && (a.pricingManner = x.WEIGHT.V), _.value && (a.pricingManner = U.LENGTH.V);
    });
  }
  const j = A(() => ge.value[dt].filter((p) => p.id === d.projectId)[0]);
  function G() {
    Fe(() => {
      R.value && R.value.resetFields(), R.value && R.value.clearValidate(), l.fileList = [], l.attachmentIds = [], L.value = void 0, y.value = [];
    });
  }
  function ve() {
  }
  function ye() {
  }
  function be(e) {
    const a = l.fileList.findIndex((p) => p.id === e.id);
    l.fileList.splice(a, 1);
  }
  function Ve(e) {
    O.value = e.path, S.value = true;
  }
  function we(e, a, p) {
    console.log(e, a, p), p.splice(p.length - 1, 1), e.code === 2e4 ? (l.fileList.push(Object.assign(e.data, { uid: a.uid, url: a.url })), M.success("上传成功")) : M.error(e.message);
  }
  function Ee(e, a, p) {
    M.error(e.message);
  }
  function Ae() {
    M.error("最多只能上传10张logo");
  }
  function Re(e) {
    return e.size > 10 * 1024 * 1024 ? (M.error("上传logo大小不能超过10MB!", 2e3), false) : true;
  }
  return Z({ resetForm: G }), (e, a) => {
    const p = T("common-button"), E = Ge, Me = T("common-select"), W = We, r = ze, z = Be, ke = T("common-table"), Ie = Ye, D = Xe, xe = Je, Ue = Qe, Ce = Ke, Le = Ze, Te = et, Pe = tt, Ne = T("common-drawer"), Se = at;
    return n(), s(Ne, { "append-to-body": "", ref: "drawerRef", title: "退货汇总清单", modelValue: c(q), "onUpdate:modelValue": a[7] || (a[7] = (t) => $e(q) ? q.value = t : null), direction: "rtl", "before-close": c($), size: "80%" }, { titleAfter: i(() => a[8] || (a[8] = [])), titleRight: i(() => [o(p, { loading: N.value, type: "success", size: "default", onClick: he }, { default: i(() => a[9] || (a[9] = [Y("发起审核")])), _: 1, __: [9] }, 8, ["loading"])]), content: i(() => [o(Te, { class: "form form-descriptions-bordered", ref_key: "formRef", ref: R, "label-width": "120px", model: l, rules: ce, "show-message": false }, { default: i(() => [m("div", vt, [o(E, { class: "form-item fixed", label: "项目", prop: "projrct" }, { default: i(() => {
      var t, h;
      return [Y(w(`${(t = j.value) == null ? void 0 : t.serialNumber}   ${(h = j.value) == null ? void 0 : h.shortName}`), 1)];
    }), _: 1 }), o(E, { class: "form-item", label: "处理方式", prop: "handleMethod" }, { default: i(() => [o(Me, { modelValue: l.handleMethod, "onUpdate:modelValue": a[0] || (a[0] = (t) => l.handleMethod = t), options: V.value ? c(g).ENUM : c(ct).ENUM, disabledVal: [c(Q).STORAGE.V, c(Q).NO_STORAGE.V].includes(c(d).status) ? [c(g).REPAIR.V, c(g).RECYCLE.V] : [], type: "enum", size: "default", style: { width: "100%", height: "100%" }, placeholder: "请选择处理方式", onChange: _e }, null, 8, ["modelValue", "options", "disabledVal"])]), _: 1 }), l.handleMethod === c(g).REPAIR.V ? (n(), s(E, { key: 0, class: "form-item input", label: "费用", prop: "freight" }, { default: i(() => [o(W, { modelValue: l.freight, "onUpdate:modelValue": a[1] || (a[1] = (t) => l.freight = t), modelModifiers: { number: true }, type: "number", placeholder: "输入费用", style: { width: "100%", height: "100%" }, size: "default", clearable: "" }, null, 8, ["modelValue"])]), _: 1 })) : u("", true)]), m("div", yt, [l.handleMethod !== c(g).REPAIR.V ? (n(), s(E, { key: 0, class: "form-item input", label: "存放位置", prop: "warehouseId" }, { default: i(() => [o(c(ht), { clearable: "", disabled: l.handleMethod === c(g).REPAIR.V, modelValue: l.warehouseId, "onUpdate:modelValue": a[2] || (a[2] = (t) => l.warehouseId = t), style: { width: "100%", height: "100%" } }, null, 8, ["disabled", "modelValue"])]), _: 1 })) : u("", true)]), l.handleMethod === c(g).RECYCLE.V ? (n(), X("div", bt, [o(E, { class: "form-item", label: "购买方", prop: "branchCompanyId" }, { default: i(() => [o(pt, { modelValue: l.branchCompanyId, "onUpdate:modelValue": a[3] || (a[3] = (t) => l.branchCompanyId = t), class: "input-border-none", clearable: "", filterable: "", placeholder: "请选择购买方", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 }), o(E, { class: "form-item", label: "出售方" }, { default: i(() => [m("div", Vt, w(j.value.customerUnit || "-"), 1)]), _: 1 })])) : u("", true), He((n(), s(ke, { ref: "tableRef", data: y.value, "return-source-data": "", "show-empty-symbol": false, "cell-class-name": c(de), "max-height": c(ne), "show-summary": "", "summary-method": me, style: { width: "100%", margin: "15px 0px" } }, { default: i(() => [o(r, { label: "序号", type: "index", align: "center", width: "60" }), V.value || H.value ? (n(), s(r, { "show-overflow-tooltip": "", prop: "monomerName", key: "monomerName", label: "单体", align: "center" })) : u("", true), V.value || H.value ? (n(), s(r, { "show-overflow-tooltip": "", prop: "areaName", key: "areaName", label: "区域", align: "center" })) : u("", true), _.value || ie.value ? (n(), s(r, { "show-overflow-tooltip": "", prop: "planName", key: "planName", label: "计划", align: "center" })) : u("", true), o(r, { "show-overflow-tooltip": "", prop: "productName", key: "productName", label: "名称", align: "center" }), b.value ? u("", true) : (n(), s(r, { "show-overflow-tooltip": "", prop: "serialNumber", key: "serialNumber", label: "编号", align: "center" })), _.value ? (n(), s(r, { "show-overflow-tooltip": "", prop: "plate", key: "plate", label: "板型", align: "center" }, { default: i((t) => [m("span", null, w(t.row.plate || "-"), 1)]), _: 1 })) : u("", true), o(r, { "show-overflow-tooltip": "", prop: "specification", key: "specification", label: "规格", align: "center" }), V.value ? (n(), s(r, { "show-overflow-tooltip": "", prop: "length", key: "length", label: "长度（m）", align: "center", width: "100px" })) : u("", true), b.value ? (n(), s(r, { "show-overflow-tooltip": "", prop: "singleMete", key: "singleMete", label: "单核算量", align: "center" })) : u("", true), b.value ? (n(), s(r, { "show-overflow-tooltip": "", prop: "mete", key: "mete", label: "核算量", align: "center" })) : u("", true), b.value ? (n(), s(r, { "show-overflow-tooltip": "", prop: "accountingUnit", key: "accountingUnit", label: "核算单位", align: "center" })) : u("", true), V.value ? (n(), s(r, { "show-overflow-tooltip": "", prop: "material", key: "material", label: "材质", align: "center" })) : u("", true), V.value || _.value ? (n(), s(r, { "show-overflow-tooltip": "", prop: "pricingManner", key: "pricingManner", label: "计价方式", align: "center", width: "120px" }, { default: i((t) => [m("span", null, w(pe.value.VL[t.row.pricingManner] || "-"), 1)]), _: 1 })) : u("", true), o(r, { "show-overflow-tooltip": "", prop: "quantity", key: "quantity", label: "数量", align: "center", width: "120px" }, { default: i((t) => {
      var h;
      return [l.handleMethod ? (n(), s(z, { key: 0, modelValue: t.row.quantity, "onUpdate:modelValue": (B) => t.row.quantity = B, "controls-position": "right", step: 1, max: (h = t.row) == null ? void 0 : h.originQuantity, min: 1, precision: 0, onChange: (B) => F(t.row, t.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "onChange"])) : (n(), X("span", wt, w(t.row.quantity || "-"), 1))];
    }), _: 1 }), b.value ? (n(), s(r, { "show-overflow-tooltip": "", prop: "measureUnit", key: "measureUnit", label: "单位", align: "center" })) : u("", true), V.value ? (n(), s(r, { "show-overflow-tooltip": "", prop: "netWeight", key: "netWeight", label: "单重（t）", align: "center" })) : u("", true), V.value ? (n(), s(r, { "show-overflow-tooltip": "", prop: "totalNetWeight", key: "totalNetWeight", label: "总重(t)", align: "center" })) : u("", true), _.value ? (n(), s(r, { "show-overflow-tooltip": "", prop: "length", key: "length", label: "单长（m）", align: "center" })) : u("", true), _.value ? (n(), s(r, { "show-overflow-tooltip": "", prop: "totalLength", key: "totalLength", label: "总长度（m）", align: "center", width: "100px" })) : u("", true), _.value ? (n(), s(r, { "show-overflow-tooltip": "", prop: "surfaceArea", key: "surfaceArea", label: "单面积（m²）", align: "center", width: "100px" }, { default: i((t) => [m("span", null, w(t.row.surfaceArea || "-"), 1)]), _: 1 })) : u("", true), _.value ? (n(), s(r, { "show-overflow-tooltip": "", prop: "totalArea", key: "totalArea", label: "总面积（㎡）", width: "100px", align: "center" }, { default: i((t) => [m("span", null, w(t.row.totalArea || "-"), 1)]), _: 1 })) : u("", true), l.handleMethod !== c(g).REPAIR.V ? (n(), s(r, { "show-overflow-tooltip": "", prop: "unitPrice", key: "unitPrice", label: "单价（元）", align: "center", width: "150px" }, { default: i((t) => [o(z, { modelValue: t.row.unitPrice, "onUpdate:modelValue": (h) => t.row.unitPrice = h, "controls-position": "right", step: 1, max: 999999999e-2, min: 0, precision: 2, onChange: (h) => F(t.row, t.$index) }, null, 8, ["modelValue", "onUpdate:modelValue", "onChange"])]), _: 1 })) : u("", true), l.handleMethod !== c(g).REPAIR.V ? (n(), s(r, { "show-overflow-tooltip": "", prop: "totalAmount", key: "totalAmount", label: "总价（元）", align: "center" }, { default: i((t) => [m("span", null, w(c(k)(t.row.totalAmount, 3) || 0), 1)]), _: 1 })) : u("", true), o(r, { "show-overflow-tooltip": "", label: "操作", align: "center" }, { default: i((t) => [o(p, { type: "danger", icon: "el-icon-delete", onClick: (h) => fe(t.$index), disabled: !t.row.id }, null, 8, ["onClick", "disabled"])]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name", "max-height"])), [[Se, oe.value]]), m("div", Et, [o(E, { class: "form-item input", label: "上传图片", prop: "attachmentIds" }, { default: i(() => [m("div", At, [o(Le, { action: c(te), accept: "image/*", headers: ae.value, limit: 10, "list-type": "picture-card", data: le.value, "file-list": l.fileList, "onUpdate:fileList": a[4] || (a[4] = (t) => l.fileList = t), "before-upload": Re, "on-success": we, "on-error": Ee, "on-exceed": Ae }, { file: i(({ file: t }) => [o(xe, { class: "el-upload-list__item-thumbnail", src: t.url, alt: "logo", fit: "scale-down" }, null, 8, ["src"]), m("span", Rt, [m("span", { class: "el-upload-list__item-preview", onClick: (h) => Ve(t) }, [o(D, null, { default: i(() => [o(Ue)]), _: 1 })], 8, Mt), m("span", { class: "el-upload-list__item-delete", onClick: (h) => be(t) }, [o(D, null, { default: i(() => [o(Ce)]), _: 1 })], 8, kt)])]), default: i(() => [o(D, null, { default: i(() => [o(Ie)]), _: 1 })]), _: 1 }, 8, ["action", "headers", "data", "file-list"])])]), _: 1 })]), o(W, { class: "remark", type: "textarea", placeholder: "备注说明", maxlength: "200", "show-word-limit": "", modelValue: L.value, "onUpdate:modelValue": a[5] || (a[5] = (t) => L.value = t) }, null, 8, ["modelValue"])]), _: 1 }, 8, ["model"]), o(Pe, { modelValue: S.value, "onUpdate:modelValue": a[6] || (a[6] = (t) => S.value = t) }, { default: i(() => [m("img", { style: { width: "100%" }, src: O.value, alt: "logo" }, null, 8, It)]), _: 1 }, 8, ["modelValue"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ut = lt(xt, [["__scopeId", "data-v-f6c0d8d9"]]), Dt = Object.freeze(Object.defineProperty({ __proto__: null, default: Ut }, Symbol.toStringTag, { value: "Module" }));
export {
  Dt as a,
  jt as c,
  Ut as s
};
