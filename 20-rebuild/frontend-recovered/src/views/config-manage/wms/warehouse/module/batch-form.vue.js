import { ref as N } from "vue";
import { computed as z } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as A } from "vue";
import { createBlock as F } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as h } from "vue";
import { withModifiers as q } from "vue";
import { ElTableColumn as H } from "element-plus";
import { ElInput as $ } from "element-plus";
import { ElForm as D } from "element-plus";
import { a_ as G, o as K, b4 as L, am as b, aw as P } from "../../../../../shared/runtime.js";
import { u as j } from "../../../../../modules/use-table-operate-4f84437f.js";
const J = { style: { float: "right" } }, Z = { __name: "batch-form", setup(Q) {
  const w = { name: [{ required: true, max: 20, message: "不能超过20个字符", trigger: "blur" }], materialType: [{ required: true, message: "请选择仓库存储的材料类型", trigger: "change" }], sort: [{ max: 3, message: "不能超过3个字符", trigger: "blur" }] }, y = { list: [] }, g = { name: void 0, materialType: void 0, sort: void 0 }, p = N(), { CRUD: u, crud: o, form: i, ADD_FORM: x } = G(y, p), f = z(() => o.bStatus.cu > u.STATUS.NORMAL), { init: k, addRow: C, removeRow: V } = j(g, 10), { tableValidate: T, cleanUpData: U, wrongCellMask: S } = P({ rules: w }), { maxHeight: B } = K({ mainBox: ".warehouse-batch-add", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false }, f);
  return x.init = () => {
    k(i.list);
  }, u.HOOK.beforeValidateBCU = () => {
    const { validResult: n, dealList: l } = T(i.list);
    if (n) i.list = l;
    else return n;
  }, o.submitBatchFormFormat = (n) => (U(n.list), n.list.map((l) => {
    l.workshopId = o.query.workshopId, l.warehouseType = o.query.warehouseType;
  }), n.workshopId = o.query.workshopId, n), (n, l) => {
    const c = m("common-button"), d = H, R = $, v = m("common-select"), O = m("common-input-number"), M = m("common-table"), E = D, I = m("common-dialog");
    return A(), F(I, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(o).cancelBCU, visible: f.value, title: `${e(o).props.workshop ? e(o).props.workshop.name + "：" : ""}${e(o).bStatus.title}`, "show-close": false, "custom-class": "warehouse-batch-add", width: "1000px", top: "10vh" }, { titleRight: s(() => [_("span", J, [t(c, { size: "default", type: "success", icon: "el-icon-plus", onClick: l[0] || (l[0] = (a) => e(C)(e(i).list)) }), t(c, { loading: e(o).bStatus.cu === e(u).STATUS.PROCESSING, type: "primary", size: "default", onClick: e(o).submitBCU }, { default: s(() => l[1] || (l[1] = [h(" 提 交 ")])), _: 1, __: [1] }, 8, ["loading", "onClick"]), t(L, { type: "crudBatch" }), t(c, { size: "default", onClick: e(o).cancelBCU }, { default: s(() => l[2] || (l[2] = [h("关 闭")])), _: 1, __: [2] }, 8, ["onClick"])])]), default: s(() => [_("div", null, [t(E, { ref_key: "formRef", ref: p, model: e(i), disabled: e(o).bStatus.cu === e(u).STATUS.PROCESSING }, { default: s(() => [t(M, { data: e(i).list, "show-empty-symbol": false, "return-source-data": "", "empty-text": "暂无数据", "max-height": e(B), "default-expand-all": "", "cell-class-name": e(S), "row-key": "uid" }, { default: s(() => [t(d, { label: "序号", type: "index", align: "center", width: "60" }), t(d, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "仓库位置", width: "220" }, { default: s(({ row: a }) => [t(R, { modelValue: a.name, "onUpdate:modelValue": (r) => a.name = r, modelModifiers: { trim: true }, type: "text", clearable: "", placeholder: "仓库位置", size: "default", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(d, { key: "materialType", prop: "materialType", "show-overflow-tooltip": true, label: "可存储材料类型", "min-width": "160" }, { default: s(({ row: a }) => [t(v, { modelValue: a.materialType, "onUpdate:modelValue": (r) => a.materialType = r, options: e(b).ENUM, unshowOptions: [e(b).GAS.K], multiple: "", clearable: "", mode: "bit", type: "enum", placeholder: "可存储材料类型", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "unshowOptions"])]), _: 1 }), t(d, { key: "sort", prop: "sort", "show-overflow-tooltip": true, label: "排序", align: "center", width: "100" }, { default: s(({ row: a }) => [t(O, { modelValue: a.sort, "onUpdate:modelValue": (r) => a.sort = r, type: "text", maxlength: "3", size: "default", placeholder: "排序", style: { width: "100%" }, controls: false }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(d, { label: "操作", width: "55", align: "center", fixed: "right" }, { default: s(({ $index: a }) => [t(c, { type: "danger", icon: "el-icon-delete", size: "default", style: { padding: "6px" }, onClick: q((r) => e(V)(e(i).list, a), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])]), _: 1 }, 8, ["model", "disabled"])])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  Z as default
};
