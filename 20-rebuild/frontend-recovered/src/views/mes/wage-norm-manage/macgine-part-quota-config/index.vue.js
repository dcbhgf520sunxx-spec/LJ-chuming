import { ref as E } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as w } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as y } from "vue";
import { unref as t } from "vue";
import { withDirectives as A } from "vue";
import { createBlock as l } from "vue";
import { withCtx as d } from "vue";
import { createCommentVNode as r } from "vue";
import { toDisplayString as c } from "vue";
import { withModifiers as V } from "vue";
import { ElMessageBox as T } from "element-plus";
import { ElNotification as F } from "element-plus";
import { ElMessage as H } from "element-plus";
import { ElTableColumn as j } from "element-plus";
import { ElSwitch as z } from "element-plus";
import { vLoading as J } from "element-plus";
import { c as Q, e as Y, d as G } from "../../../../modules/macgine-part-quota-config-e44baebd.js";
import { _ as I, x as K, s7 as v, o as X, i as O, e8 as Z, qo as ee, s9 as te, e0 as ae, e1 as oe, bV as P, aS as g, G as k, P as ne } from "../../../../shared/runtime.js";
import se from "./module/form.vue.js";
import ie from "./module/header.vue.js";
const le = { class: "app-container" }, re = { class: "head-container" }, ce = { key: 0 }, ue = { key: 1 }, pe = { key: 0, class: "detailList" }, de = { key: 1 }, me = { key: 0 }, fe = { key: 1 }, _e = { __name: "index", setup(we) {
  const q = { add: true, edit: false, del: false, download: false }, N = E(), C = E(), { crud: m, columns: u, CRUD: B } = K({ title: "零件定额", permission: { ...v }, optShow: { ...q }, crudApi: { ...Q }, hasPagination: true }, N), { maxHeight: R } = X({ paginate: true });
  B.HOOK.handleRefresh = (i, n) => {
    C.value = JSON.parse(JSON.stringify(n.data.content)), n.data.content.forEach((a) => {
      (!a.detailList || !a.detailList.length) && (a.detailList = [{ comparisonOperatorOne: void 0, comparisonOperatorTwo: void 0, numberOne: void 0, numberTwo: void 0, price: void 0 }]);
    }), n.data.content = n.data.content.flatMap((a, _) => {
      var f;
      return (f = a == null ? void 0 : a.detailList) == null ? void 0 : f.map((h) => ({ ...a, index: _ + 1, detailList: h }));
    });
  };
  async function M(i, n) {
    console.log(i, n);
    try {
      await T.confirm(`此操作将 ${i.quotaNumber} 的状态改为 ${g.VL[n]}, 是否继续？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await Y({ id: i.id, status: n }), m.toQuery(), F({ title: `${i.quotaNumber}的状态修改成功`, type: "success", duration: 3e3 });
    } catch (a) {
      console.log("变更是否固定资产折旧失败", a), i.status = i.status === g.TRUE.V ? g.FALSE.V : g.TRUE.V;
    }
  }
  async function $(i) {
    try {
      await T.confirm(`确认将 ${i.quotaNumber} 删除？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await G({ id: i.id }), H.success("删除成功！"), m.refresh();
    } catch (n) {
      console.log(n);
    }
  }
  function D(i) {
    var a;
    let n = {};
    (a = C.value) == null || a.forEach((_) => {
      _.quotaNumber === i.quotaNumber && (n = _);
    }), m.toEdit(n);
  }
  const U = ["index", "quotaNumber", "workshopNameList", "machinePartType", "machinePartClassNameList", "processName", "calculationWay", "boolSpecificationClass", "status", "operation"];
  function W({ row: i, column: n, rowIndex: a, columnIndex: _ }) {
    if (U.includes(n.property)) {
      const f = i.quotaNumber || "", h = m.data[a - 1], L = h ? h.quotaNumber : null;
      if (f === L) return { rowspan: 0, colspan: 0 };
      {
        let e = 1;
        for (let s = a + 1; s < m.data.length; s++) {
          const x = m.data[s].quotaNumber || "";
          if (x && f && x === f) e++;
          else break;
        }
        return { rowspan: e, colspan: 1 };
      }
    }
  }
  return (i, n) => {
    const a = j, _ = z, f = S("common-button"), h = S("common-table"), L = J;
    return o(), w("div", le, [p("div", re, [y(t(ie))]), A((o(), l(h, { ref_key: "tableRef", ref: N, data: t(m).data, "empty-text": t(m).emptyText, "max-height": t(R), style: { width: "100%" }, showEmptySymbol: false, "span-method": W }, { default: d(() => [y(a, { label: "序号", prop: "index", align: "center", width: "60" }), t(u).visible("quotaNumber") ? (o(), l(a, { key: "quotaNumber", prop: "quotaNumber", "show-overflow-tooltip": true, label: "定额编号", align: "center" })) : r("", true), t(u).visible("workshopNameList") ? (o(), l(a, { key: "workshopNameList", prop: "workshopNameList", "show-overflow-tooltip": true, label: "车间", align: "center" }, { default: d((e) => [t(O)(e.row.workshopNameList) ? (o(), w("span", ce, c(e.row.workshopNameList.join("、")), 1)) : (o(), w("span", ue, "-"))]), _: 1 })) : r("", true), t(u).visible("machinePartType") ? (o(), l(a, { key: "machinePartType", prop: "machinePartType", "show-overflow-tooltip": true, label: "零件类型", align: "center" }, { default: d((e) => [p("span", null, c(t(Z).VL[e.row.machinePartType] || "-"), 1)]), _: 1 })) : r("", true), t(u).visible("machinePartClassNameList") ? (o(), l(a, { key: "machinePartClassNameList", prop: "machinePartClassNameList", "show-overflow-tooltip": true, label: "零件截面", align: "center" }, { default: d((e) => {
      var s, b;
      return [p("span", null, c(((b = (s = e.row) == null ? void 0 : s.machinePartClassNameList) == null ? void 0 : b.join()) || "-"), 1)];
    }), _: 1 })) : r("", true), t(u).visible("processName") ? (o(), l(a, { key: "processName", prop: "processName", "show-overflow-tooltip": true, label: "下料方式", align: "center" })) : r("", true), t(u).visible("calculationWay") ? (o(), l(a, { key: "calculationWay", prop: "calculationWay", "show-overflow-tooltip": true, label: "计算方式", align: "center" }, { default: d((e) => [p("span", null, c(t(ee).VL[e.row.calculationWay] || "-"), 1)]), _: 1 })) : r("", true), t(u).visible("boolSpecificationClass") ? (o(), l(a, { key: "boolSpecificationClass", prop: "boolSpecificationClass", "show-overflow-tooltip": true, label: "规格分类", align: "center" }, { default: d((e) => [p("span", null, c(t(te).VL[e.row.boolSpecificationClass] || "-"), 1)]), _: 1 })) : r("", true), t(u).visible("type") ? (o(), l(a, { key: "type", prop: "type", "show-overflow-tooltip": true, label: "分类", align: "center" }, { default: d((e) => {
      var s;
      return [t(O)((s = e.row.detailList) == null ? void 0 : s.numberOne) ? (o(), w("div", pe, [p("span", null, c(e.row.detailList.numberOne), 1), p("span", null, c(t(ae).VL[e.row.detailList.comparisonOperatorOne]), 1), n[0] || (n[0] = p("span", null, "X", -1)), p("span", null, c(t(oe).VL[e.row.detailList.comparisonOperatorTwo]), 1), p("span", null, c(e.row.detailList.numberTwo), 1)])) : (o(), w("span", de, "-"))];
    }), _: 1 })) : r("", true), t(u).visible("price") ? (o(), l(a, { key: "price", prop: "price", "show-overflow-tooltip": true, label: "单价（元）", align: "center" }, { default: d((e) => {
      var s, b;
      return [(s = e.row.detailList) != null && s.price ? (o(), w("span", me, c(t(P)((b = e.row.detailList) == null ? void 0 : b.price)), 1)) : (o(), w("span", fe, c(t(P)(e.row.price)), 1))];
    }), _: 1 })) : r("", true), t(u).visible("status") ? (o(), l(a, { key: "status", prop: "status", label: "状态", align: "center" }, { default: d((e) => [y(_, { modelValue: e.row.status, "onUpdate:modelValue": (s) => e.row.status = s, "active-value": t(g).TRUE.V, "inactive-value": t(g).FALSE.V, disabled: !t(k)(t(v).status) || !e.row.status, onChange: (s) => M(e.row, e.row.status) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "inactive-value", "disabled", "onChange"])]), _: 1 })) : r("", true), y(a, { label: "操作", prop: "operation", align: "center" }, { default: d((e) => [t(k)(t(v).edit) && e.row.status ? (o(), l(f, { key: 0, icon: "el-icon-edit", size: "default", type: "primary", onClick: V((s) => D(e.row), ["stop"]) }, null, 8, ["onClick"])) : r("", true), t(k)(t(v).del) && e.row.status ? (o(), l(f, { key: 1, icon: "el-icon-delete", size: "default", type: "danger", onClick: V((s) => $(e.row), ["stop"]) }, null, 8, ["onClick"])) : r("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[L, t(m).loading]]), y(t(se)), y(t(ne))]);
  };
} }, ke = I(_e, [["__scopeId", "data-v-b1e32ae8"]]);
export {
  ke as default
};
