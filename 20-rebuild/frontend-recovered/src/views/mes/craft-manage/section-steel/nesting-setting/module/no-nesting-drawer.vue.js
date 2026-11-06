import { ref as i } from "vue";
import { inject as I } from "vue";
import { resolveComponent as f } from "vue";
import { resolveDirective as L } from "vue";
import { openBlock as w } from "vue";
import { createBlock as g } from "vue";
import { withCtx as n } from "vue";
import { withDirectives as b } from "vue";
import { createTextVNode as S } from "vue";
import { unref as r } from "vue";
import { createVNode as t } from "vue";
import { createElementVNode as j } from "vue";
import { isRef as $ } from "vue";
import { ElMessage as A } from "element-plus";
import { ElMessageBox as F } from "element-plus";
import { ElNotification as v } from "element-plus";
import { ElTableColumn as O } from "element-plus";
import { vLoading as P } from "element-plus";
import { a as U, d as x } from "../../../../../../modules/nesting-setting-83aca0bd.js";
import { _ as W } from "../../../../../../modules/popover-confirm-35927771.js";
import { u as G, o as J, nr as K } from "../../../../../../shared/runtime.js";
const te = { __name: "no-nesting-drawer", props: { visible: { type: Boolean, default: false }, list: { type: Array, default: () => [] } }, emits: ["update:visible", "refresh"], setup(y, { emit: N }) {
  const h = i(), s = N, B = I("crud"), C = y, { visible: c, handleClose: V } = G({ emit: s, props: C, field: "visible", showHook: k }), { maxHeight: R } = J({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, h), d = i(false), _ = i([]), p = i([]);
  function k() {
    u();
  }
  async function u() {
    try {
      d.value = true;
      const { content: o } = await U(B.query);
      _.value = o;
    } catch (o) {
      console.log("获取无需套料清单失败", o);
    } finally {
      d.value = false;
    }
  }
  function D(o) {
    p.value = o;
  }
  async function H() {
    var o;
    if (!((o = p.value) != null && o.length)) {
      A.warning("请至少选择一条数据");
      return;
    }
    try {
      F.confirm("是否确认将所选的数据移出【无需套料清单】", "提示", { confirmButtonText: "确认", cancelButtonText: "取消", type: "warning" }).then(async () => {
        try {
          const e = p.value.map((l) => l.assembleDetailId);
          await x(e), v({ title: "移出成功", type: "success", duration: 2500 }), u(), s("refresh");
        } catch (e) {
          console.log("移出失败", e);
        }
      });
    } catch (e) {
      console.log("移出失败", e);
    }
  }
  async function M(o) {
    try {
      await x([o.assembleDetailId]), v({ title: "移出成功", type: "success", duration: 2500 }), u(), s("refresh");
    } catch (e) {
      console.log("移出失败", e);
    }
  }
  return (o, e) => {
    const l = f("common-button"), a = O, E = f("common-table"), T = f("common-drawer"), q = L("permission"), z = P;
    return w(), g(T, { ref_key: "drawerRef", ref: h, title: "无需套料清单", modelValue: r(c), "onUpdate:modelValue": e[0] || (e[0] = (m) => $(c) ? c.value = m : null), direction: "rtl", "before-close": r(V), size: "60%" }, { titleRight: n(() => [b((w(), g(l, { type: "danger", size: "default", icon: "el-icon-delete", onClick: H }, { default: n(() => e[1] || (e[1] = [S("批量移出")])), _: 1, __: [1] })), [[q, r(K).moveOutNoNestingList]])]), content: n(() => [b((w(), g(E, { data: _.value, "max-height": r(R), style: { width: "100%" }, onSelectionChange: D }, { default: n(() => [t(a, { type: "selection", width: "55", align: "center" }), t(a, { label: "序号", type: "index", align: "center", width: "60" }), t(a, { prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", "min-width": "100px", align: "center" }), t(a, { prop: "area.name", "show-overflow-tooltip": true, label: "区域", "min-width": "100px", align: "center" }), t(a, { prop: "serialNumber", "show-overflow-tooltip": true, label: "部件编号", width: "120px", align: "center" }), t(a, { prop: "quantity", "show-overflow-tooltip": true, label: "数量", align: "center", width: "80px" }), t(a, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "100px", align: "center" }), t(a, { prop: "length", "show-overflow-tooltip": true, label: "长度（mm）", align: "center", width: "100px" }), t(a, { prop: "material", "show-overflow-tooltip": true, label: "材质", align: "center", width: "100px" }), t(a, { prop: "netWeight", "show-overflow-tooltip": true, label: "单重（kg）", align: "center", width: "100px" }), t(a, { label: "操作", align: "center", width: "100px" }, { default: n(({ row: m }) => [t(W, { onConfirm: (Q) => M(m) }, { reference: n(() => [t(l, { icon: "el-icon-delete", type: "danger", size: "default" })]), default: n(() => [e[2] || (e[2] = j("p", null, "是否确认将该数据移出【无需套料清单】？", -1))]), _: 2, __: [2] }, 1032, ["onConfirm"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[z, d.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  te as default
};
