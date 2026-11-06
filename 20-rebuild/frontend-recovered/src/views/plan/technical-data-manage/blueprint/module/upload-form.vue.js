import { ref as _ } from "vue";
import { watch as O } from "vue";
import { computed as S } from "vue";
import { useStore as j } from "vuex";
import { resolveComponent as x } from "vue";
import { openBlock as b } from "vue";
import { createBlock as y } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as r } from "vue";
import { toDisplayString as v } from "vue";
import { unref as n } from "vue";
import { createCommentVNode as P } from "vue";
import { isRef as B } from "vue";
import { ElFormItem as U } from "element-plus";
import { ElInput as F } from "element-plus";
import { ElForm as z } from "element-plus";
import { _ as E, u as M, z as A, t1 as L, t2 as k, t0 as c } from "../../../../../shared/runtime.js";
import D from "../../components/drawing-upload-btn/index.vue.js";
import "../../../../../modules/index-ce9deea8.js";
const q = { class: "project-name" }, J = { __name: "upload-form", props: { currentMonomer: { type: Object, default: () => {
} }, globalProject: { type: Object, default: () => {
} }, dataType: { type: [String, Number], default: void 0 }, modelValue: { type: Boolean, require: true }, currentRow: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(e, { emit: g }) {
  const t = e, o = _(JSON.parse(JSON.stringify({ fileName: void 0 }))), R = _(), V = { fileName: { required: true, message: "请输入文件命名", trigger: "blur" } }, p = g, { visible: s, handleClose: f } = M({ emit: p, props: t });
  O(() => s.value, (N) => {
    N && (o.value.fileName = void 0);
  }, { deep: true, immediate: true });
  const h = S(() => t.currentRow.id ? { id: t.currentRow.id, monomerId: t.currentMonomer.id, fileName: o.value.fileName } : { projectId: t.globalProject.id, monomerId: t.currentMonomer.id, dataType: t.dataType, fileName: o.value.fileName }), u = j();
  function T() {
    p("success"), u.dispatch("approval_list/fetchApprovalNum"), u.dispatch("approval_list/fetchSubNum", c.PLAN_CONSTRUCTION_BLUEPRINT.V), u.dispatch("approval_list/fetchApprovalNum", c.PLAN_CONSTRUCTION_BLUEPRINT.V), u.dispatch("approval_list/fetchRejNum", c.PLAN_CONSTRUCTION_BLUEPRINT.V), f();
  }
  return (N, l) => {
    const d = U, w = F, I = z, C = x("common-dialog");
    return b(), y(C, { modelValue: n(s), "onUpdate:modelValue": l[1] || (l[1] = (m) => B(s) ? s.value = m : null), "before-close": n(f), "close-on-click-modal": false, title: e.currentRow.id ? "文件替换" : "文件上传", "append-to-body": "", width: "550px" }, { titleAfter: a(() => l[2] || (l[2] = [i("span", { style: { color: "red", "font-size": "12px" } }, "*导入格式为压缩包,文件类型仅支持DWG格式", -1)])), default: a(() => [r(I, { ref_key: "formRef", ref: R, model: o.value, rules: V, "label-width": "150px", size: "default" }, { default: a(() => [r(d, { label: "所属项目" }, { default: a(() => [i("span", q, v(n(A)(e.globalProject)), 1)]), _: 1 }), e.currentMonomer && e.currentMonomer.name ? (b(), y(d, { key: 0, label: "单体" }, { default: a(() => [i("span", null, v(e.currentMonomer.name), 1)]), _: 1 })) : P("", true), r(d, { label: "文件命名" }, { default: a(() => [r(w, { modelValue: o.value.fileName, "onUpdate:modelValue": l[0] || (l[0] = (m) => o.value.fileName = m), maxlength: 20, placeholder: "文件命名", style: { width: "320px" } }, null, 8, ["modelValue"])]), _: 1 }), r(d, { label: "上传" }, { default: a(() => [r(n(D), { ref: "changeFileRef", accept: ".zip", "btn-name": "文件上传", "btn-size": "mini", "btn-type": "warning", data: h.value, "data-type": e.dataType, icon: "el-icon-upload", "upload-fun": e.currentRow.id ? n(L) : n(k), class: "filter-item", "success-msg": "审批流已生成!请点击审批记录查看", tip: ".dwg", onSuccess: T }, null, 8, ["data", "data-type", "upload-fun"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close", "title"]);
  };
} }, X = E(J, [["__scopeId", "data-v-2ff3fcba"]]);
export {
  X as default
};
