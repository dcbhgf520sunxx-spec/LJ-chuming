import { ref as D } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as i } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as b } from "vue";
import { unref as e } from "vue";
import { withDirectives as A } from "vue";
import { createBlock as u } from "vue";
import { withCtx as h } from "vue";
import { createCommentVNode as p } from "vue";
import { toDisplayString as c } from "vue";
import { withModifiers as T } from "vue";
import { ElMessageBox as H } from "element-plus";
import { ElMessage as $ } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { vLoading as F } from "element-plus";
import { l as k, _ as U, x as Y, s6 as x, o as j, kA as G, i as O, e0 as I, e1 as K, bV as q, G as C } from "../../../../shared/runtime.js";
import Q from "./module/header.vue.js";
import W from "./module/form.vue.js";
function X(s) {
  return k({ module: "mes", url: "wage-quota/enclosure-product-quota-config/page", method: "get", params: s });
}
function J(s) {
  return k({ module: "mes", url: "wage-quota/enclosure-product-quota-config", method: "post", data: s });
}
function Z(s) {
  return k({ module: "mes", url: "wage-quota/enclosure-product-quota-config", method: "put", data: s });
}
function ee(s) {
  return k({ module: "mes", url: "wage-quota/enclosure-product-quota-config", method: "delete", params: s });
}
const E = { get: X, del: ee, add: J, edit: Z };
const te = { class: "app-container" }, oe = { class: "head-container" }, ne = { key: 0 }, ae = { key: 1 }, re = { key: 0 }, ie = { key: 1 }, se = { key: 0, class: "detailList" }, le = { key: 1 }, de = { key: 0 }, ue = { key: 1 }, ce = { __name: "index", setup(s) {
  const B = { add: true, edit: false, del: false, download: false }, L = D(), { crud: l, columns: w, CRUD: M } = Y({ title: "围护产品定额", permission: { ...x }, optShow: { ...B }, crudApi: { ...E }, sort: [], hasPagination: true }, L), { maxHeight: V } = j({ paginate: true });
  M.HOOK.handleRefresh = async (g, { data: r }) => {
    r.content.forEach((t) => {
      (!t.detailList || !t.detailList.length) && (t.detailList = [{ comparisonOperatorOne: void 0, comparisonOperatorTwo: void 0, numberOne: void 0, numberTwo: void 0, price: void 0 }]), t.detailParamList = t.detailList;
    }), r.content = r.content.flatMap((t, y) => {
      var d;
      return (d = t == null ? void 0 : t.detailList) == null ? void 0 : d.map((m) => ({ ...t, index: y + 1, detailList: m }));
    });
  };
  async function R(g) {
    try {
      await H.confirm("确认删除该配置？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await E.del({ id: g.id }), $.success("删除成功！"), l.refresh();
    } catch (r) {
      console.log(r);
    }
  }
  const P = ["index", "quotaNumber", "workshopNameList", "productType", "operation"];
  function S({ row: g, column: r, rowIndex: t, columnIndex: y }) {
    if (P.includes(r.property)) {
      const d = g.quotaNumber || "", m = l.data[t - 1], o = m ? m.quotaNumber : null;
      if (d === o) return { rowspan: 0, colspan: 0 };
      {
        let a = 1;
        for (let _ = t + 1; _ < l.data.length; _++) {
          const v = l.data[_].quotaNumber || "";
          if (v && d && v === d) a++;
          else break;
        }
        return { rowspan: a, colspan: 1 };
      }
    }
  }
  return (g, r) => {
    const t = z, y = N("common-button"), d = N("common-table"), m = F;
    return n(), i("div", te, [f("div", oe, [b(e(Q))]), A((n(), u(d, { ref_key: "tableRef", ref: L, data: e(l).data, "empty-text": e(l).emptyText, "max-height": e(V), "span-method": S, style: { width: "100%" } }, { default: h(() => [b(t, { label: "序号", prop: "index", align: "center", width: "60" }), e(w).visible("quotaNumber") ? (n(), u(t, { key: "quotaNumber", prop: "quotaNumber", "show-overflow-tooltip": true, label: "定额编号", align: "center", "min-width": "100px" })) : p("", true), e(w).visible("workshopNameList") ? (n(), u(t, { key: "workshopNameList", prop: "workshopNameList", "show-overflow-tooltip": true, label: "车间", align: "center", "min-width": "100px" }, { default: h((o) => {
      var a;
      return [(a = o.row.workshopNameList) != null && a.length ? (n(), i("span", ne, c(o.row.workshopNameList.join("、")), 1)) : (n(), i("span", ae, "-"))];
    }), _: 1 })) : p("", true), e(w).visible("productType") ? (n(), u(t, { key: "productType", prop: "productType", "show-overflow-tooltip": true, label: "产品类型", align: "center", "min-width": "100px" }, { default: h((o) => [o.row.productType ? (n(), i("span", re, c(e(G).VL[o.row.productType]), 1)) : (n(), i("span", ie, "-"))]), _: 1 })) : p("", true), e(w).visible("type") ? (n(), u(t, { key: "type", prop: "type", "show-overflow-tooltip": true, label: "长度分类（mm）", align: "center" }, { default: h((o) => {
      var a;
      return [e(O)((a = o.row.detailList) == null ? void 0 : a.numberOne) ? (n(), i("div", se, [f("span", null, c(o.row.detailList.numberOne), 1), f("span", null, c(e(I).VL[o.row.detailList.comparisonOperatorOne]), 1), r[0] || (r[0] = f("span", null, "X", -1)), f("span", null, c(e(K).VL[o.row.detailList.comparisonOperatorTwo]), 1), f("span", null, c(o.row.detailList.numberTwo), 1)])) : (n(), i("span", le, "-"))];
    }), _: 1 })) : p("", true), e(w).visible("price") ? (n(), u(t, { key: "price", prop: "price", "show-overflow-tooltip": true, label: "单价(元/米)", align: "center", "min-width": "100px" }, { default: h((o) => {
      var a, _;
      return [e(O)((a = o.row.detailList) == null ? void 0 : a.price) ? (n(), i("span", de, c(e(q)((_ = o.row.detailList) == null ? void 0 : _.price) ?? "-"), 1)) : (n(), i("span", ue, c(e(q)(o.row.price) ?? "-"), 1))];
    }), _: 1 })) : p("", true), b(t, { label: "操作", prop: "operation", width: "130px", align: "center", fixed: "right" }, { default: h((o) => [e(C)(e(x).edit) ? (n(), u(y, { key: 0, icon: "el-icon-edit", size: "default", type: "primary", onClick: T((a) => e(l).toEdit(o.row), ["stop"]) }, null, 8, ["onClick"])) : p("", true), e(C)(e(x).del) ? (n(), u(y, { key: 1, icon: "el-icon-delete", size: "default", type: "danger", onClick: T((a) => R(o.row), ["stop"]) }, null, 8, ["onClick"])) : p("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[m, e(l).loading]]), b(e(W))]);
  };
} }, ge = U(ce, [["__scopeId", "data-v-d55d522e"]]);
export {
  ge as default
};
