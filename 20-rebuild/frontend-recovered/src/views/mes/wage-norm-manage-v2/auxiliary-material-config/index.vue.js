import { ref as y } from "vue";
import { provide as v } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as V } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as d } from "vue";
import { unref as e } from "vue";
import { withDirectives as $ } from "vue";
import { createBlock as n } from "vue";
import { withCtx as r } from "vue";
import { toDisplayString as g } from "vue";
import { createCommentVNode as s } from "vue";
import { withModifiers as C } from "vue";
import { ElMessageBox as H } from "element-plus";
import { ElMessage as z } from "element-plus";
import { ElTableColumn as A } from "element-plus";
import { vLoading as O } from "element-plus";
import { l as m, x as U, s5 as _, o as F, bV as G, G as N, P as K } from "../../../../shared/runtime.js";
import { P as W } from "../../../../modules/base-6bc46ddf.js";
import j from "./module/header.vue.js";
import I from "./module/form.vue.js";
function J(a) {
  return m({ module: "mes", url: "quota-config/auxiliary-material/page", method: "get", params: a });
}
function Q(a) {
  return m({ module: "mes", url: "quota-config/auxiliary-material", method: "post", data: a });
}
function X(a) {
  return m({ module: "mes", url: "quota-config/auxiliary-material", method: "put", data: a });
}
function Y(a) {
  return m({ module: "mes", url: "quota-config/auxiliary-material", method: "delete", params: a });
}
function Z(a) {
  return m({ module: "mes", url: "quota-config/auxiliary-material/type-select-list", method: "get", params: a });
}
const S = { get: J, del: Y, add: Q, edit: X }, ee = { class: "app-container" }, te = { class: "head-container" }, re = { __name: "index", setup(a) {
  const B = { add: true, edit: false, del: false, download: false }, w = y(), b = y([]), { crud: c, columns: p, CRUD: D } = U({ title: "栓钉套筒定额", permission: { ..._ }, optShow: { ...B }, crudApi: { ...S }, sort: [], hasPagination: true }, w), { maxHeight: T } = F({ paginate: true }), f = y(false);
  async function q() {
    try {
      const t = await W();
      f.value = t || false;
    } catch (t) {
      console.log("工价统计截止日", t);
    }
  }
  D.HOOK.handleRefresh = (t, h) => {
    q();
  };
  async function M() {
    try {
      const t = await Z();
      b.value = t || [];
    } catch (t) {
      console.log("获取栓钉套筒类型列表", t);
    }
  }
  M();
  async function P(t) {
    try {
      await H.confirm("确认删除该配置？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await S.del({ id: t.id }), z.success("删除成功！"), c.refresh();
    } catch (h) {
      console.log(h);
    }
  }
  return v("typeSelectList", b), v("boolConfig", f), (t, h) => {
    const l = A, x = k("common-button"), E = k("common-table"), R = O;
    return i(), V("div", ee, [u("div", te, [d(e(j))]), $((i(), n(E, { ref_key: "tableRef", ref: w, data: e(c).data, "empty-text": e(c).emptyText, "max-height": e(T), style: { width: "100%" } }, { default: r(() => [d(l, { label: "序号", type: "index", align: "center", width: "60" }), e(p).visible("serialNumber") ? (i(), n(l, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": "", label: "定额编号", align: "center", "min-width": "100px" }, { default: r((o) => [u("span", null, g(o.row.serialNumber || "-"), 1)]), _: 1 })) : s("", true), e(p).visible("typeName") ? (i(), n(l, { key: "typeName", prop: "typeName", "show-overflow-tooltip": "", label: "类型", align: "center", "min-width": "100px" }, { default: r((o) => [u("span", null, g(o.row.typeName || "-"), 1)]), _: 1 })) : s("", true), e(p).visible("unit") ? (i(), n(l, { key: "unit", prop: "unit", "show-overflow-tooltip": "", label: "单位", align: "center", "min-width": "100px" }, { default: r((o) => [u("span", null, g(o.row.unit || "-"), 1)]), _: 1 })) : s("", true), e(p).visible("price") ? (i(), n(l, { key: "price", prop: "price", "show-overflow-tooltip": "", label: "定额单价", align: "center", "min-width": "100px" }, { default: r((o) => [u("span", null, g(e(G)(o.row.price) ?? "-"), 1)]), _: 1 })) : s("", true), d(l, { label: "操作", width: "130px", align: "center", fixed: "right" }, { default: r((o) => [e(N)(e(_).edit) ? (i(), n(x, { key: 0, icon: "el-icon-edit", size: "default", type: "primary", disabled: !f.value, onClick: C((L) => e(c).toEdit(o.row), ["stop"]) }, null, 8, ["disabled", "onClick"])) : s("", true), e(N)(e(_).del) ? (i(), n(x, { key: 1, icon: "el-icon-delete", size: "default", type: "danger", disabled: !f.value, onClick: C((L) => P(o.row), ["stop"]) }, null, 8, ["disabled", "onClick"])) : s("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[R, e(c).loading]]), d(e(K)), d(e(I))]);
  };
} };
export {
  re as default
};
