import { ref as B } from "vue";
import { watch as H } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as L } from "vue";
import { createBlock as M } from "vue";
import { withCtx as a } from "vue";
import { createVNode as l } from "vue";
import { unref as i } from "vue";
import { createTextVNode as b } from "vue";
import { withModifiers as _ } from "vue";
import { isRef as T } from "vue";
import { ElMessage as q } from "element-plus";
import { ElTableColumn as E } from "element-plus";
import { s as N, d as $ } from "../../../../../modules/information-validity-6783e35a.js";
import { u as A, o as D, V as h, aw as F } from "../../../../../shared/runtime.js";
import { u as O } from "../../../../../modules/use-table-operate-4f84437f.js";
import { u as S } from "../../../../../modules/index-9d220fe1.js";
import "../../../../../modules/use-users-4d979987.js";
const Y = { __name: "custom-user-dialog", props: { visible: { type: Boolean, default: false }, customList: { type: Array, default: () => [] } }, emits: ["update:visible", "success"], setup(v, { emit: w }) {
  const f = w, r = v, o = B({ id: void 0, list: [] }), { visible: c, handleClose: g } = A({ emit: f, props: r, field: "visible" }), { maxHeight: V } = D({ extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, c);
  H(() => r.visible, async (n) => {
    n && (o.value.list = [], r.customList && r.customList.length > 0 ? o.value.list = h(r.customList) : y(o.value.list));
  }, { immediate: true });
  const x = { userIds: [{ required: true, message: "请选择人员", trigger: "change" }], projectQuota: [{ required: true, message: "请填写数量", trigger: "change" }] }, { init: y, addRow: C, removeRow: k } = O({}, 2), { tableValidate: I, cleanUpData: R, wrongCellMask: j } = F({ rules: x });
  async function Q() {
    try {
      if (o.value.list && o.value.list.length > 0) {
        const { validResult: n, dealList: e } = I(o.value.list), s = R(h(e));
        if (console.log(s, "list"), !n) return;
        const u = s == null ? void 0 : s.map((d) => ({ projectQuota: d.projectQuota, userIds: d.userIds }));
        await N(u);
      } else await $();
      q.success("自定义人员保存成功"), f("success"), g();
    } catch (n) {
      console.log(n, "自定义人员保存失败");
    }
  }
  return (n, e) => {
    const s = p("common-button"), u = E, d = p("common-input-number"), U = p("common-table"), z = p("common-dialog");
    return L(), M(z, { ref: "dialogRef", title: "自定义人员", modelValue: i(c), "onUpdate:modelValue": e[1] || (e[1] = (t) => T(c) ? c.value = t : null), direction: "rtl", "close-on-click-modal": false, "before-close": i(g), width: "700px" }, { titleRight: a(() => [l(s, { size: "default", type: "warning", icon: "el-icon-plus", onClick: e[0] || (e[0] = (t) => i(C)(o.value.list)) }, { default: a(() => e[2] || (e[2] = [b(" 添加一行 ")])), _: 1, __: [2] }), l(s, { size: "default", type: "success", onClick: _(Q, ["stop"]) }, { default: a(() => e[3] || (e[3] = [b(" 保存 ")])), _: 1, __: [3] })]), default: a(() => [l(U, { ref: "table", data: o.value.list, "show-empty-symbol": false, "return-source-data": "", "empty-text": "暂无数据", "max-height": i(V), "cell-class-name": i(j) }, { default: a(() => [l(u, { label: "序号", type: "index", align: "center", width: "60" }), l(u, { prop: "userIds", "show-overflow-tooltip": true, label: "选择人员", align: "center", "min-width": "150px" }, { default: a(({ row: t }) => [l(i(S), { modelValue: t.userIds, "onUpdate:modelValue": (m) => t.userIds = m, size: "default", placeholder: "选择人员", multiple: true, "collapse-tags": "", "collapse-tags-tooltip": "", "max-collapse-tags": "1", class: "input-underline", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(u, { prop: "projectQuota", "show-overflow-tooltip": true, label: "项目人员名额上限", align: "center", width: "130" }, { default: a(({ row: t }) => [l(d, { modelValue: t.projectQuota, "onUpdate:modelValue": (m) => t.projectQuota = m, step: 1, min: 1, precision: 0, clearable: "", controls: false, size: "small", class: "input-underline", placeholder: "填写数量", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), l(u, { label: "操作", width: "100px", align: "center" }, { default: a(({ $index: t }) => [l(s, { type: "danger", icon: "el-icon-delete", size: "default", onClick: _((m) => i(k)(o.value.list, t), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  Y as default
};
