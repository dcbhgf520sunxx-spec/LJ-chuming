import { ref as w } from "vue";
import { ElMessage as F } from "element-plus";
import { resolveComponent as f } from "vue";
import { openBlock as g } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as r } from "vue";
import { createVNode as t } from "vue";
import { unref as o } from "vue";
import { createTextVNode as k } from "vue";
import { createCommentVNode as x } from "vue";
import { createElementVNode as O } from "vue";
import { ElTableColumn as z } from "element-plus";
import { ElInput as H } from "element-plus";
import { ElInputNumber as S } from "element-plus";
import { ElForm as $ } from "element-plus";
import { s as I } from "../../../../../modules/parallel-config-554d8028.js";
import { _ as P, ao as D, o as K, D as p, aw as G } from "../../../../../shared/runtime.js";
import J from "./uploadBtn.vue.js";
const L = { class: "add-row-box" }, j = { __name: "form", setup(Q) {
  const h = w(), b = w(), M = { id: void 0, list: [] }, { crud: u, form: s, CRUD: V } = D(M, h), U = {}, { maxHeight: C } = K({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body", ".upload-table"], navbar: false, extraHeight: 120 }, () => b.value.loaded), v = { serialNumber: [{ required: true, message: "请输入编号", trigger: "blur" }], specification: [{ required: true, message: "请输入规格", trigger: "blur" }], material: [{ required: true, message: "请输入材质", trigger: "blur" }], length: [{ required: true, message: "请输入长度", trigger: "blur" }], thick: [{ validator: (l, n) => !!l, message: "请输入厚度", trigger: "blur" }], grossWeight: [{ required: true, message: "请输入单毛重", trigger: "blur" }], netWeight: [{ required: true, message: "请输入单净重", trigger: "blur" }], surfaceArea: [{ required: true, message: "请输入面积", trigger: "blur" }], filePath: [{ required: true, message: "请上传图片", trigger: "change" }] }, { tableValidate: W, wrongCellMask: T } = G({ rules: v });
  function R() {
    s.list.push({});
  }
  function N(l) {
    s.list.splice(l, 1);
  }
  function y(l) {
    l.totalNetWeight = l.quantity && l.netWeight ? l.quantity * l.netWeight : void 0, l.totalGrossWeight = l.quantity && l.grossWeight ? l.quantity * l.grossWeight : void 0;
  }
  function q(l, n) {
    n.filePath = l;
  }
  return V.HOOK.beforeSubmit = (l, n) => {
    if (l.form.list && l.form.list.length === 0) return F.error("请填写明细"), false;
    const { validResult: d, dealList: i } = W(l.form.list);
    if (d) l.form.list = i;
    else return d;
    l.form.id && (l.form = l.form.list[0]);
  }, V.HOOK.afterToEdit = (l, n) => {
    const d = JSON.parse(JSON.stringify(n));
    n.list = [d];
  }, (l, n) => {
    const d = f("common-button"), i = z, c = H, m = S, A = f("common-table"), B = $, E = f("common-drawer");
    return g(), _(E, { "append-to-body": "", "close-on-click-modal": false, "before-close": o(u).cancelCU, visible: o(u).status.cu > 0, title: o(u).status.title, "wrapper-closable": false, ref_key: "drawerRef", ref: b, size: "90%" }, { titleRight: r(() => [t(d, { loading: o(u).status.cu === 2, type: "primary", size: "default", onClick: o(u).submitCU }, { default: r(() => n[1] || (n[1] = [k("确认")])), _: 1, __: [1] }, 8, ["loading", "onClick"])]), content: r(() => [t(B, { ref_key: "formRef", ref: h, model: o(s), rules: U, size: "default", "label-width": "140px" }, { default: r(() => [t(A, { ref: "detailRef", border: "", data: o(s).list, "max-height": o(C), style: { width: "100%", "margin-top": "10px" }, class: "upload-table", "return-source-data": "", showEmptySymbol: false, "cell-class-name": o(T) }, { default: r(() => [t(i, { label: "序号", type: "index", align: "center", width: "55" }), t(i, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center" }, { default: r((e) => [t(c, { modelValue: e.row.serialNumber, "onUpdate:modelValue": (a) => e.row.serialNumber = a, modelModifiers: { trim: true }, type: "text", placeholder: "请填写", maxlength: "10", disabled: o(s).id && o(s).boolHaveHole }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled"])]), _: 1 }), t(i, { key: "specification", prop: "specification", label: "规格", align: "center" }, { default: r((e) => [t(c, { modelValue: e.row.specification, "onUpdate:modelValue": (a) => e.row.specification = a, modelModifiers: { trim: true }, type: "text", placeholder: "请填写", maxlength: "10" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(i, { key: "length", prop: "length", label: `长度
(mm)`, align: "center" }, { default: r((e) => [t(m, { modelValue: e.row.length, "onUpdate:modelValue": (a) => e.row.length = a, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: o(p).MES_ARTIFACT_L__MM, placeholder: "请填写", "controls-position": "right" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }), t(i, { key: "thick", prop: "thick", label: `厚度
(mm)`, align: "center" }, { default: r((e) => [t(m, { modelValue: e.row.thick, "onUpdate:modelValue": (a) => e.row.thick = a, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: o(p).MES_ARTIFACT_T__MM, placeholder: "请填写", "controls-position": "right" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }), t(i, { key: "material", prop: "material", label: "材质", align: "center" }, { default: r((e) => [t(c, { modelValue: e.row.material, "onUpdate:modelValue": (a) => e.row.material = a, modelModifiers: { trim: true }, type: "text", placeholder: "请填写", maxlength: "10" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(i, { key: "netWeight", prop: "netWeight", label: `单净重
(kg)`, align: "left" }, { default: r((e) => [t(m, { modelValue: e.row.netWeight, "onUpdate:modelValue": (a) => e.row.netWeight = a, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: o(p).COM_WT__KG, placeholder: "请填写", "controls-position": "right", size: "default", onBlur: (a) => y(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])]), _: 1 }), t(i, { key: "grossWeight", prop: "grossWeight", label: `单毛重
(kg)`, align: "left" }, { default: r((e) => [t(m, { modelValue: e.row.grossWeight, "onUpdate:modelValue": (a) => e.row.grossWeight = a, modelModifiers: { number: true }, min: 0, max: 9999999999, step: 1, precision: o(p).COM_WT__KG, placeholder: "请填写", "controls-position": "right", size: "default", onBlur: (a) => y(e.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "precision", "onBlur"])]), _: 1 }), t(i, { key: "surfaceArea", prop: "surfaceArea", label: `单面积
(㎡)`, align: "left", "min-width": "80px" }, { default: r((e) => [t(m, { modelValue: e.row.surfaceArea, "onUpdate:modelValue": (a) => e.row.surfaceArea = a, modelModifiers: { number: true }, max: 9999999999, step: 1, precision: o(p).COM_AREA__M2, placeholder: "请填写", "controls-position": "right" }, null, 8, ["modelValue", "onUpdate:modelValue", "precision"])]), _: 1 }), t(i, { key: "remark", prop: "remark", label: "备注", align: "center" }, { default: r((e) => [t(c, { modelValue: e.row.remark, "onUpdate:modelValue": (a) => e.row.remark = a, modelModifiers: { trim: true }, type: "text", placeholder: "请填写", maxlength: "100" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(i, { align: "center", prop: "filePath", label: "dxf上传" }, { default: r((e) => [t(o(J), { accept: ".dxf", data: e.row, tip: l.uploadType, size: "default", uploadFun: o(I), "btn-name": e.row.filePath ? "覆盖上传" : "上传", type: "primary", limit: 1, onChange: q }, null, 8, ["data", "tip", "uploadFun", "btn-name"])]), _: 1 }), o(s).id ? x("", true) : (g(), _(i, { key: 0, label: "操作", align: "center", width: "100" }, { default: r((e) => [t(d, { size: "default", icon: "el-icon-delete", type: "danger", onClick: (a) => N(e.$index) }, null, 8, ["onClick"])]), _: 1 }))]), _: 1 }, 8, ["data", "max-height", "cell-class-name"]), O("div", L, [o(s).id ? x("", true) : (g(), _(d, { key: 0, size: "default", icon: "el-icon-circle-plus", type: "warning", style: { "margin-top": "15px" }, onClick: n[0] || (n[0] = (e) => R()) }, { default: r(() => n[2] || (n[2] = [k("添加")])), _: 1, __: [2] }))])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, te = P(j, [["__scopeId", "data-v-0f5a1246"]]);
export {
  te as default
};
