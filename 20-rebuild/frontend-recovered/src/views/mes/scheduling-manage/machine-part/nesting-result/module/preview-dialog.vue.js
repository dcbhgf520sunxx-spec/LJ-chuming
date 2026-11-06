import { ref as y } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as N } from "vue";
import { createBlock as V } from "vue";
import { withCtx as a } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as k } from "vue";
import { unref as d } from "vue";
import { createElementVNode as m } from "vue";
import { toDisplayString as g } from "vue";
import { isRef as B } from "vue";
import { ElNotification as H } from "element-plus";
import { ElTableColumn as A } from "element-plus";
import { a as D } from "../../../../../../modules/common-a5dc7899.js";
import { _ as R, u as j, o as z } from "../../../../../../shared/runtime.js";
const E = { __name: "preview-dialog", props: { visible: { type: Boolean, default: false }, list: { type: Array, default: () => [] }, info: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(w, { emit: x }) {
  const b = x, l = w, { visible: r, handleClose: u } = j({ emit: b, props: l, field: "visible" }), { maxHeight: C } = z({ mainBox: ".nesting-task-issue-preview", extraBox: [".el-dialog__header", ".tip"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, r), T = y([["askCompleteTime", ["parse-time", "{y}-{m}-{d}"]]]), c = y(false);
  async function I() {
    var f, e, i, o, p;
    try {
      c.value = true;
      const s = { askCompleteTime: (f = l.info) == null ? void 0 : f.askCompleteTime, drillAskCompleteTime: (e = l.info) == null ? void 0 : e.drillAskCompleteTime, drillGroupsId: (i = l.info) == null ? void 0 : i.drillGroupsId, groupsId: (o = l.info) == null ? void 0 : o.groupsId, schedulingId: (p = l.info) == null ? void 0 : p.id };
      await D(s), u(), H({ title: "任务下发成功", type: "success", duration: 3e3 }), b("success");
    } catch (s) {
      console.log("任务下发失败", s);
    } finally {
      c.value = false;
    }
  }
  return (f, e) => {
    const i = _("common-button"), o = A, p = _("common-table"), s = _("common-dialog");
    return N(), V(s, { title: "任务下发预览", customClass: "nesting-task-issue-preview", modelValue: d(r), "onUpdate:modelValue": e[0] || (e[0] = (n) => B(r) ? r.value = n : null), "close-on-click-modal": false, width: "1100px", showClose: false, "before-close": d(u) }, { titleRight: a(() => [t(i, { size: "default", type: "primary", loading: c.value, onClick: I }, { default: a(() => e[1] || (e[1] = [k(" 确认下发 ")])), _: 1, __: [1] }, 8, ["loading"]), t(i, { size: "default", onClick: d(u) }, { default: a(() => e[2] || (e[2] = [k(" 取消 ")])), _: 1, __: [2] }, 8, ["onClick"])]), default: a(() => [e[3] || (e[3] = m("div", { class: "tip" }, [m("span", null, "* 提示："), m("span", null, " 点击确认下发后，任务无法撤回，请再次确认！")], -1)), t(p, { data: w.list, "data-format": T.value, "max-height": d(C), style: { width: "100%" } }, { default: a(() => [t(o, { label: "序号", type: "index", align: "center", width: "60" }), t(o, { prop: "cutNumber", "show-overflow-tooltip": true, label: "切割指令号", "min-width": "120", align: "center" }), t(o, { prop: "spec", "show-overflow-tooltip": true, label: "原材料规格", "min-width": "120", align: "center" }), t(o, { prop: "num", "show-overflow-tooltip": true, label: "板材数量(件)", width: "120", align: "center" }), t(o, { prop: "cutName", "show-overflow-tooltip": true, label: "切割方式", width: "100", align: "center" }), t(o, { "show-overflow-tooltip": true, label: "生产组", "min-width": "160", align: "center" }, { default: a(({ row: n }) => {
      var v, h;
      return [m("span", null, g((v = n.workshop) == null ? void 0 : v.name) + ">" + g((h = n.productionLine) == null ? void 0 : h.name) + ">" + g(n.groupsName), 1)];
    }), _: 1 }), t(o, { prop: "askCompleteTime", "show-overflow-tooltip": true, label: "需求完成日期", width: "100", align: "center" })]), _: 1 }, 8, ["data", "data-format", "max-height"])]), _: 1, __: [3] }, 8, ["modelValue", "before-close"]);
  };
} }, F = R(E, [["__scopeId", "data-v-29081570"]]);
export {
  F as default
};
