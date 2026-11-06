import { ref as M } from "vue";
import { computed as F } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as b } from "vue";
import { createBlock as g } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as C } from "vue";
import { createVNode as t } from "vue";
import { unref as e } from "vue";
import { createTextVNode as f } from "vue";
import { withModifiers as N } from "vue";
import { createCommentVNode as O } from "vue";
import { ElTableColumn as z } from "element-plus";
import { ElInput as D } from "element-plus";
import { ElForm as E } from "element-plus";
import { a_ as I, aw as $ } from "../../../../../../shared/runtime.js";
import { u as j } from "../../../../../../modules/use-table-operate-4f84437f.js";
const q = { style: { float: "right" } }, G = { style: { "text-align": "center" } }, Q = { __name: "form", setup(H) {
  const p = M(), k = { mesArtifactClassList: [{ name: "", remark: "" }] }, w = { name: "", remark: "" }, { CRUD: c, crud: s, form: r, ADD_FORM: y } = I(k, p), h = F(() => s.bStatus.cu > c.STATUS.NORMAL), { init: V, addRow: x, removeRow: R } = j(w, 1), U = { name: [{ required: true, message: "请输入构件类别名称", trigger: "blur" }] }, { tableValidate: A, cleanUpData: v, wrongCellMask: S } = $({ rules: U, errorMsg: "请填写表格中标红的信息" });
  return y.init = () => {
    V(r.mesArtifactClassList);
  }, c.HOOK.beforeValidateBCU = () => {
    const { validResult: n, dealList: l } = A(r.mesArtifactClassList);
    if (!n) return n;
  }, s.submitBatchFormFormat = (n) => (v(n.mesArtifactClassList), n), (n, l) => {
    const i = u("common-button"), m = z, _ = D, B = u("common-table"), L = E, T = u("common-dialog");
    return b(), g(T, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(s).cancelCU, visible: h.value, title: e(s).bStatus.title, "show-close": false, "custom-class": "warehouse-batch-add", width: "700px", top: "10vh" }, { titleRight: a(() => [C("span", q, [t(i, { loading: e(s).bStatus.cu === e(c).STATUS.PROCESSING, type: "primary", size: "default", onClick: e(s).submitBCU }, { default: a(() => l[1] || (l[1] = [f(" 提 交 ")])), _: 1, __: [1] }, 8, ["loading", "onClick"]), t(i, { size: "default", onClick: e(s).cancelBCU }, { default: a(() => l[2] || (l[2] = [f("关 闭")])), _: 1, __: [2] }, 8, ["onClick"])])]), default: a(() => [t(L, { ref_key: "formRef", ref: p, model: e(r), rules: n.rules, size: "default", "label-width": "80px" }, { default: a(() => [t(B, { ref: "detailRef", border: "", data: e(r).mesArtifactClassList, style: { width: "100%", "margin-top": "10px" }, class: "upload-table", "return-source-data": "", "max-height": "500px", showEmptySymbol: false, "cell-class-name": e(S) }, { default: a(() => [t(m, { label: "序号", type: "index", align: "center", width: "50" }), t(m, { key: "name", prop: "name", label: "构件类别名称", align: "center" }, { default: a((o) => [t(_, { modelValue: o.row.name, "onUpdate:modelValue": (d) => o.row.name = d, modelModifiers: { trim: true }, type: "text", clearable: "", placeholder: "请填写", maxlength: "20" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(m, { key: "remark", prop: "remark", label: "备注", align: "center" }, { default: a((o) => [t(_, { modelValue: o.row.remark, "onUpdate:modelValue": (d) => o.row.remark = d, modelModifiers: { trim: true }, type: "text", clearable: "", placeholder: "请填写", maxlength: "20" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), e(r).id ? O("", true) : (b(), g(m, { key: 0, label: "操作", align: "center", width: "100" }, { default: a(({ $index: o }) => [t(i, { size: "default", icon: "el-icon-delete", type: "danger", onClick: N((d) => e(R)(e(r).mesArtifactClassList, o), ["stop"]) }, null, 8, ["onClick"])]), _: 1 }))]), _: 1 }, 8, ["data", "cell-class-name"])]), _: 1 }, 8, ["model", "rules"]), C("div", G, [t(i, { size: "default", icon: "el-icon-circle-plus", type: "warning", style: { "margin-top": "15px" }, onClick: l[0] || (l[0] = (o) => e(x)(e(r).mesArtifactClassList)) }, { default: a(() => l[3] || (l[3] = [f(" 添加 ")])), _: 1, __: [3] })])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  Q as default
};
