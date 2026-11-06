import { ref as p } from "vue";
import { watch as y } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as f } from "vue";
import { createBlock as g } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as u } from "vue";
import { toDisplayString as b } from "vue";
import { renderSlot as x } from "vue";
import { createVNode as s } from "vue";
import { unref as T } from "vue";
import { createTextVNode as m } from "vue";
import { mergeProps as v } from "vue";
import { ElDivider as C } from "element-plus";
import { xb as V } from "../../../../shared/runtime.js";
import k from "./table-tree/index.vue.js";
import "./table-tree/TableItem.vue.js";
import "../../../../modules/use-dept-b8e95315.js";
const w = { style: { "font-size": "18px", "font-weight": "bold", "margin-right": "10px" } }, A = { style: { display: "flex", "align-items": "center" } }, I = { __name: "menu-assignation", props: { currentId: { type: Number, default: 0 }, menus: { type: Array, required: true }, menuIds: { type: Array, default: () => [] }, permission: { type: Object, default: () => {
} }, roleName: { type: String, default: "" }, currentRow: { type: Object, default: () => {
} }, closeMenuAssignation: { type: Function }, menuLoading: { type: Boolean }, saveMenu: { type: Function }, menuType: { type: Number }, dataPermissionList: { type: Object, default: () => {
} }, showPermissionType: { type: Number }, isExist: { type: Boolean, default: false } }, setup(e) {
  const i = e, o = p([]);
  return y(i.menuIds, (n) => {
    o.value = n;
  }, { immediate: true, deep: true }), (n, t) => {
    const l = C, r = c("common-button");
    return f(), g(k, v(n.$attrs, { modelValue: o.value, "onUpdate:modelValue": t[0] || (t[0] = (d) => o.value = d), checkable: "", "return-leaf": false, "is-delete-nonexistent": false, "return-indeterminate": "", options: i.menus, menuType: e.menuType, dataPermissionList: e.dataPermissionList }), { header: a(() => [u("span", w, b(e.currentRow.name), 1)]), footer: a(() => [u("span", A, [x(n.$slots, "menuBtn"), s(l, { style: { height: "26px", margin: "0 10px" }, direction: "vertical" }), s(r, { type: e.menuType === T(V).DATA_PICK.V && !e.isExist ? "danger" : "primary", size: "default", loading: e.menuLoading, onClick: e.saveMenu }, { default: a(() => t[1] || (t[1] = [m(" 保存 ")])), _: 1, __: [1] }, 8, ["type", "loading", "onClick"]), s(r, { size: "default", onClick: e.closeMenuAssignation }, { default: a(() => t[2] || (t[2] = [m("取消")])), _: 1, __: [2] }, 8, ["onClick"])])]), _: 3 }, 16, ["modelValue", "options", "menuType", "dataPermissionList"]);
  };
} };
export {
  I as default
};
