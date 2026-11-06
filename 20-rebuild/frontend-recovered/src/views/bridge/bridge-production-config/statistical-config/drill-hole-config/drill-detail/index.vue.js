import { ref as m } from "vue";
import { inject as q } from "vue";
import { computed as A } from "vue";
import { watch as G } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as L } from "vue";
import { createElementBlock as M } from "vue";
import { withDirectives as R } from "vue";
import { vShow as k } from "vue";
import { createElementVNode as l } from "vue";
import { createVNode as t } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as g } from "vue";
import { unref as O } from "vue";
import { toDisplayString as B } from "vue";
import { withModifiers as D } from "vue";
import { Fragment as J } from "vue";
import { ElTableColumn as K } from "element-plus";
import { ElPopover as Q } from "element-plus";
import { ElCard as W } from "element-plus";
import { _ as X, d as Y } from "./module/form.vue.js";
import "../../../../../../shared/runtime.js";
const Z = { style: { display: "flex", "align-items": "center", "justify-content": "space-between" } }, ee = { style: { "text-align": "right", margin: "0" } }, ne = { __name: "index", props: { layingOffRow: { type: Object, default: () => {
} } }, emits: ["refresh"], setup(s, { expose: E, emit: z }) {
  const S = z, c = m(false), d = m(false), o = m({}), v = m(false), j = q("maxHeight"), y = s, V = A(() => y.layingOffRow && y.layingOffRow.id);
  G(() => V, (n) => {
    n.value && (v.value = true);
  }, { deep: true, immediate: true });
  function I() {
    v.value = false;
  }
  function N(n) {
    o.value = n, c.value = true, d.value = true;
  }
  function T(n) {
    o.value = n, n.deleteBtn = true;
  }
  function U() {
    o.value.deleteBtn = false;
  }
  function w() {
    S("refresh");
  }
  async function $() {
    o.value.deleteBtn = false;
    try {
      await Y([o.value.id]), w();
    } catch (n) {
      console.log("删除孔径详情失败", n);
    }
  }
  function b() {
    c.value = false, d.value = true;
  }
  return E({ toAdd: b, refresh: I }), (n, e) => {
    var x, _, h;
    const r = C("common-button"), f = K, F = Q, H = C("common-table"), P = W;
    return L(), M(J, null, [R(l("div", null, e[1] || (e[1] = [l("div", { class: "my-code" }, "点击钻孔配置查看详情", -1)]), 512), [[k, !((x = s.layingOffRow) != null && x.id)]]), R(l("div", null, [t(P, { class: "box-card team-card" }, { header: i(() => [l("div", Z, [e[3] || (e[3] = l("span", { style: { display: "flex", "align-items": "center" } }, [l("span", null, "孔径详情列表")], -1)), t(r, { size: "default", style: { float: "right", padding: "6px 10px", "margin-bottom": "0px" }, type: "primary", icon: "el-icon-plus", onClick: b }, { default: i(() => e[2] || (e[2] = [g(" 新增 ")])), _: 1, __: [2] })])]), default: i(() => {
      var u;
      return [t(H, { ref: "tableRef", data: (u = s.layingOffRow) == null ? void 0 : u.configLinkDTOS, "highlight-current-row": "", "empty-text": "暂无数据", "max-height": O(j) + 92, style: { width: "100%" }, "row-key": "id" }, { default: i(() => [t(f, { label: "序号", type: "index", align: "center", width: "60" }), t(f, { "show-overflow-tooltip": true, label: "孔径数值范围（毫米）", align: "center", "min-width": "180px" }, { default: i(({ row: a }) => [l("span", null, B(a.minBoreDiameter), 1), e[4] || (e[4] = l("span", null, " ~ ", -1)), l("span", null, B(a.maxBoreDiameter), 1)]), _: 1 }), t(f, { "show-overflow-tooltip": true, prop: "unitPrice", label: "单价（元/个）", align: "center", width: "130px" }), t(f, { label: "操作", width: "130px", align: "center", fixed: "right" }, { default: i(({ row: a }) => [t(r, { class: "filter-item", size: "default", type: "primary", icon: "el-icon-edit", onClick: D((p) => N(a), ["stop"]) }, null, 8, ["onClick"]), t(F, { visible: a.deleteBtn, "onUpdate:visible": (p) => a.deleteBtn = p, placement: "top", width: "180", trigger: "manual" }, { reference: i(() => [t(r, { type: "danger", icon: "el-icon-delete", size: "default", onClick: D((p) => T(a), ["stop"]) }, null, 8, ["onClick"])]), default: i(() => [e[7] || (e[7] = l("p", null, "确认删除本条数据吗？", -1)), l("div", ee, [t(r, { size: "default", link: "", type: "primary", onClick: U }, { default: i(() => e[5] || (e[5] = [g("取消")])), _: 1, __: [5] }), t(r, { type: "primary", size: "default", onClick: $ }, { default: i(() => e[6] || (e[6] = [g("确定")])), _: 1, __: [6] })])]), _: 2, __: [7] }, 1032, ["visible", "onUpdate:visible"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])];
    }), _: 1 }), t(O(X), { visible: d.value, "onUpdate:visible": e[0] || (e[0] = (u) => d.value = u), isEdit: c.value, "form-data": o.value, layingOffRowId: (_ = s.layingOffRow) == null ? void 0 : _.id, onRefresh: w }, null, 8, ["visible", "isEdit", "form-data", "layingOffRowId"])], 512), [[k, (h = s.layingOffRow) == null ? void 0 : h.id]])], 64);
  };
} };
export {
  ne as default
};
