import { ref as i } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as w } from "vue";
import { createBlock as x } from "vue";
import { withCtx as c } from "vue";
import { createElementVNode as k } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as U } from "vue";
import { withDirectives as $ } from "vue";
import { unref as l } from "vue";
import { toDisplayString as J } from "vue";
import { withModifiers as F } from "vue";
import { isRef as G } from "vue";
import { ElMessageBox as C } from "element-plus";
import { ElNotification as K } from "element-plus";
import { ElTableColumn as Q } from "element-plus";
import { ElPagination as W } from "element-plus";
import { vLoading as X } from "element-plus";
import { a as Y, d as N } from "../../../../../../../modules/coating-list-667107a8.js";
import { u as Z, J as ee, o as ae } from "../../../../../../../shared/runtime.js";
const re = { __name: "detail", props: { modelValue: { type: Boolean, default: false }, rowData: { type: Object, default: () => {
} }, craftId: { type: Number, default: null } }, emits: ["update:modelValue", "success"], setup(D, { emit: V }) {
  const r = D, _ = i([]), m = i(false), p = i(false), d = i(), g = i([]), f = V, { visible: b, handleClose: z } = Z({ props: r, emit: f, showHook: s }), { handleSizeChange: B, handleCurrentChange: T, total: L, setTotalPage: I, queryPage: h } = ee({ fetchHook: s }), { maxHeight: S } = ae({ paginate: true }), q = i([{ name: "已开始生产", val: true }, { name: "未开始生产", val: false }]);
  async function s() {
    const a = { area: r.rowData.surfaceArea, artifactId: r.rowData.id, boolTask: d.value, id: r.craftId };
    m.value = true;
    try {
      const { totalElements: t, content: y } = await Y({ ...a, ...h });
      I(t), _.value = y;
    } catch (t) {
      console.log(t);
    } finally {
      m.value = false;
    }
  }
  function E(a) {
    g.value = a;
  }
  function H() {
    C.confirm("是否确认批量删除选中的清单数据？", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning", draggable: true }).then(async () => {
      const a = [];
      g.value.map((t) => {
        a.push(t.id);
      }), p.value = true, await N(a, r.craftId), s(), f("success"), K({ title: "批量删除成功", type: "success", duration: 2500 });
    }).catch((a) => {
      console.log(a, "批量删除失败");
    }).finally(() => {
      p.value = false;
    });
  }
  function A(a) {
    C.confirm(`确认删除【编码：${a.sortNumber}】这条数据吗?`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }).then(() => {
      P(a);
    }).catch(() => {
    });
  }
  async function P(a) {
    try {
      await N([a.id], r.craftId), s(), f("success");
    } catch (t) {
      console.log(t);
    }
  }
  return (a, t) => {
    const y = u("common-select"), v = u("common-button"), n = Q, M = u("common-table"), j = W, O = u("common-drawer"), R = X;
    return w(), x(O, { modelValue: l(b), "onUpdate:modelValue": t[1] || (t[1] = (o) => G(b) ? b.value = o : null), "before-close": l(z), size: "70%", title: "修改清单详情" }, { content: c(() => [k("div", null, [e(y, { placeholder: "是否开始生产", class: "filter-item", options: q.value, "data-structure": { key: "val", label: "name", value: "val" }, modelValue: d.value, "onUpdate:modelValue": t[0] || (t[0] = (o) => d.value = o), clearable: "", style: { "margin-bottom": "10px", "margin-right": "20px" }, onChange: s }, null, 8, ["options", "modelValue"]), e(v, { type: "danger", size: "default", disabled: g.value.length === 0, loading: p.value, onClick: H }, { default: c(() => t[2] || (t[2] = [U(" 批量删除 ")])), _: 1, __: [2] }, 8, ["disabled", "loading"])]), $((w(), x(M, { ref: "tableRef", data: _.value, "empty-text": "暂无数据", "max-height": l(S), style: { width: "100%" }, "row-key": "id", onSelectionChange: E }, { default: c(() => [e(n, { type: "selection", width: "55", align: "center", fixed: "left" }), e(n, { label: "序号", type: "index", align: "center", width: "60" }), e(n, { key: "monomerName", prop: "monomerName", label: "单体", align: "center" }), e(n, { key: "areaName", prop: "areaName", label: "区域", align: "center" }), e(n, { key: "name", prop: "name", label: "名称", align: "center" }), e(n, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center" }), e(n, { key: "sortNumber", prop: "sortNumber", label: "编码", align: "center" }), e(n, { key: "specification", prop: "specification", label: "规格", align: "center", width: "120px" }), e(n, { key: "length", prop: "length", label: "长度（mm）", align: "center" }), e(n, { key: "material", prop: "material", label: "材质", align: "center" }), e(n, { key: "quantity", prop: "quantity", label: "数量", align: "center" }), e(n, { key: "surfaceArea", prop: "surfaceArea", label: "单件面积(mm²)", align: "center", width: "130px" }, { default: c((o) => [k("span", null, J(o.row.surfaceArea || "-"), 1)]), _: 1 }), e(n, { label: "操作", align: "center" }, { default: c((o) => [e(v, { type: "danger", icon: "el-icon-delete", size: "default", onClick: F((te) => A(o.row), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[R, m.value]]), e(j, { total: l(L), "current-page": l(h).pageNumber, "page-size": l(h).pageSize, onSizeChange: l(B), onCurrentChange: l(T), layout: "total, prev, pager, next, sizes", style: { "margin-top": "8px" } }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  re as default
};
