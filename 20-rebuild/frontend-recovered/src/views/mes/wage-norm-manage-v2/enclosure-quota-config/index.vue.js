import { ref as w } from "vue";
import { provide as R } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as S } from "vue";
import { createElementVNode as d } from "vue";
import { createVNode as f } from "vue";
import { unref as e } from "vue";
import { withDirectives as $ } from "vue";
import { createBlock as i } from "vue";
import { withCtx as r } from "vue";
import { toDisplayString as _ } from "vue";
import { createCommentVNode as l } from "vue";
import { withModifiers as k } from "vue";
import { ElMessageBox as V } from "element-plus";
import { ElMessage as H } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { vLoading as A } from "element-plus";
import { l as g, _ as O, x as U, s6 as b, o as F, g8 as G, bV as I, G as C, P as K } from "../../../../shared/runtime.js";
import { P as L } from "../../../../modules/base-6bc46ddf.js";
import Q from "./module/form.vue.js";
import W from "./module/header.vue.js";
function j(a) {
  return g({ module: "mes", url: "quota-config/enclosure/page", method: "get", params: a });
}
function J(a) {
  return g({ module: "mes", url: "quota-config/enclosure", method: "post", data: a });
}
function X(a) {
  return g({ module: "mes", url: "quota-config/enclosure", method: "put", data: a });
}
function D(a) {
  return g({ module: "mes", url: "quota-config/enclosure", method: "delete", params: a });
}
const Y = { get: j, add: J, edit: X, del: D };
const Z = { class: "app-container" }, ee = { class: "head-container" }, te = { __name: "index", setup(a) {
  const T = { add: true, edit: false, del: false, download: false }, h = w(), { crud: c, columns: u, CRUD: N } = U({ title: "围护定额", permission: { ...b }, optShow: { ...T }, crudApi: { ...Y }, hasPagination: true }, h), { maxHeight: B } = F({ paginate: true });
  G(["enclosure_type"]);
  const p = w(false);
  async function P() {
    try {
      const n = await L();
      p.value = n || false;
    } catch (n) {
      console.log("工价统计截止日", n);
    }
  }
  N.HOOK.handleRefresh = (n, y) => {
    P();
  };
  async function E(n) {
    try {
      await V.confirm(`确认将定额 ${n.serialNumber} 删除？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await D({ id: n.id }), H.success("删除成功！"), c.refresh();
    } catch (y) {
      console.log(y);
    }
  }
  return R("boolConfig", p), (n, y) => {
    const s = z, v = x("common-button"), q = x("common-table"), M = A;
    return o(), S("div", Z, [d("div", ee, [f(e(W))]), $((o(), i(q, { ref_key: "tableRef", ref: h, data: e(c).data, "empty-text": e(c).emptyText, "max-height": e(B), showEmptySymbol: false, style: { width: "100%" } }, { default: r(() => [f(s, { type: "index", label: "序号", align: "center", width: "55", fixed: "left" }), e(u).visible("serialNumber") ? (o(), i(s, { key: "serialNumber", prop: "serialNumber", label: "定额编号", align: "center", fixed: "left" }, { default: r((t) => [d("span", null, _(t.row.serialNumber || "-"), 1)]), _: 1 })) : l("", true), e(u).visible("enclosureTypeDictionary") ? (o(), i(s, { key: "enclosureTypeDictionary", prop: "enclosureTypeDictionary", "show-overflow-tooltip": true, label: "围护类型", align: "center" }, { default: r((t) => {
      var m;
      return [d("span", null, _(((m = t.row.enclosureTypeDictionary) == null ? void 0 : m.label) || "-"), 1)];
    }), _: 1 })) : l("", true), e(u).visible("unit") ? (o(), i(s, { key: "unit", prop: "unit", "show-overflow-tooltip": true, label: "单位", align: "center" }, { default: r((t) => [d("span", null, _(t.row.unit || "-"), 1)]), _: 1 })) : l("", true), e(u).visible("price") ? (o(), i(s, { key: "price", prop: "price", "show-overflow-tooltip": true, label: "单价", align: "center" }, { default: r((t) => [d("span", null, _(e(I)(t.row.price) ?? "-"), 1)]), _: 1 })) : l("", true), e(u).visible("operation") ? (o(), i(s, { key: 4, label: "操作", prop: "operation", align: "center", fixed: "right" }, { default: r((t) => [e(C)(e(b).edit) ? (o(), i(v, { key: 0, icon: "el-icon-edit", size: "default", type: "primary", disabled: !p.value, onClick: k((m) => e(c).toEdit(t.row), ["stop"]) }, null, 8, ["disabled", "onClick"])) : l("", true), e(C)(e(b).del) ? (o(), i(v, { key: 1, icon: "el-icon-delete", size: "default", type: "danger", disabled: !p.value, onClick: k((m) => E(t.row), ["stop"]) }, null, 8, ["disabled", "onClick"])) : l("", true)]), _: 1 })) : l("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[M, e(c).loading]]), f(e(Q)), f(e(K))]);
  };
} }, se = O(te, [["__scopeId", "data-v-9ffe86aa"]]);
export {
  se as default
};
